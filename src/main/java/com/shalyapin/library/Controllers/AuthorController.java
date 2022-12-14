package com.shalyapin.library.Controllers;

import com.shalyapin.library.dto.AuthorDTO;
import com.shalyapin.library.entity.Author;
import com.shalyapin.library.repository.AuthorRepository;
import com.shalyapin.library.service.AuthorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorRepository authorRepository;
    private final AuthorService authorService;

    @ApiOperation(value = "This method is used to get the author.")
    @GetMapping
    public ResponseEntity<List<Author>> getAuthor(
            @ApiParam(
            name =  "AuthorName",
            type = "String",
            value = "First name of the author",
            example = "Fedor"
            )@RequestParam(required = false) Optional<String> authorName,
            @ApiParam(
                    name =  "AuthorSurName",
                    type = "String",
                    value = "sur name of the author",
                    example = "Ivanovich"
            )
            @RequestParam(required = false) Optional<String> authorSurName) {
        if ((authorName.isPresent() & authorSurName.isPresent())) {
            return new ResponseEntity<>(authorService.selectAuthorByNameAndSurname(authorName.get(),authorSurName.get()),HttpStatus.OK);
        } else if (authorName.isPresent())
        {
            log.info(authorName.get());
            log.info(String.valueOf(authorService.selectAuthorByName(authorName.get()).size()));
            return new ResponseEntity<>(authorService.selectAuthorByName(authorName.get()), HttpStatus.OK);}
        else if (authorSurName.isPresent())
            return new ResponseEntity<>(authorService.selectAuthorBySurname(authorSurName.get()), HttpStatus.OK);
        return new ResponseEntity<>(authorService.selectAllAuthor(), HttpStatus.OK);

    }

    @ApiOperation(value = "This method is used to get the author by id.")
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(
            @ApiParam(
                    value = " author id ",
                    type = "Long",
                    example = "2",
                    required = true
            )@PathVariable Long id) {
        return new ResponseEntity<>(authorService.selectAuthor(id), HttpStatus.OK);
    }
    @ApiOperation(value = "This method is used to update(put) the author.")
    @PutMapping("/{id}")
    public ResponseEntity<Author> putAuthor(@PathVariable("id") Long id, @RequestBody AuthorDTO authorDTO) {

        return new ResponseEntity<>(authorService.updateAuthor(authorDTO, id), HttpStatus.OK);
    }
    @ApiOperation(value = "This method is used to post author.")
    @PostMapping()
    public ResponseEntity<Author> postAuthor(@RequestBody AuthorDTO authorDTO) {

        return new ResponseEntity<>(authorService.createAuthor(authorDTO), HttpStatus.OK);
    }
    @ApiOperation(value = "This method is used to get the author by id")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAuthor(@PathVariable("id") Long id) {
        if (authorService.deleteAuthor(id))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
/*    //???????? ?????? ?????????? ???????????????????? ?? 1 ???????????? ?????? ?????????? ?????????????????? ?????????????????? ???????????????? ????????????????????, ???? ?????????????? ?
    @GetMapping
    public ResponseEntity<Author> getAuthorByName(@RequestParam String authorName) {
        return new ResponseEntity<>(authorService.selectAuthorByName(authorName), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Author> getAuthorBySurName(@RequestParam String authorSurName) {
        return new ResponseEntity<>(authorService.selectAuthorByName(authorSurName), HttpStatus.OK);
    }*/
}
  /*    @PatchMapping("/{id}") //?????????? ???? ?????????? ?????????????????? ???? ???????? ??????????? ?????????????? ??????, ???? ???????? ???????????? ???????????????? ???????????? ???????? ?????? ??????????????????. ?????????? ?????????????? ???????????????????? ???????????????????????? ????????.
        public ResponseEntity<Author> updateAutorFields(@PathVariable("id") Long id,@RequestBody Author authorDetails){
            Author author= authorRepository.findAuthorById(id);
           // if (author.getName()!=authorDetails.getName()) author.setName(au);
            return
        }*/
