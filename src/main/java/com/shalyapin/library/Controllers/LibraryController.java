package com.shalyapin.library.Controllers;

import com.shalyapin.library.entity.Library;
import com.shalyapin.library.repository.BookRepository;
import com.shalyapin.library.repository.LibraryRepository;
import com.shalyapin.library.service.LibraryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/library")
public class LibraryController {
    private final LibraryService libraryService;

    @GetMapping
    public ResponseEntity<List<Library>> getAllLibraries(@RequestParam(required = false) String name) {
        if (name==null) return new ResponseEntity<>(libraryService.getAllLibraries(), HttpStatus.OK);
        else return new ResponseEntity<>(libraryService.getLibraryByName(name), HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Library> getLibraryById(@PathVariable Long id){
        return new ResponseEntity<>(libraryService.getLibrary(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Library> postLibrary(@RequestBody Library library){
        return new ResponseEntity<>(libraryService.postLibrary(library),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStatus> deleteLibraryById(@PathVariable Long id){
        libraryService.deleteLibrary(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Library> putLibraryById(@PathVariable Long id, @RequestBody Library newLibrary){
        return new ResponseEntity<>(libraryService.updateLibrary(id,newLibrary),HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Library> updateLibraryName(@PathVariable Long id, @RequestBody String name){
        return new ResponseEntity<>(libraryService.patchLibraryName(id,name),HttpStatus.OK);
    }
}
