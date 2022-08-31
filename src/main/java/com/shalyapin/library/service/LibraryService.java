package com.shalyapin.library.service;

import com.shalyapin.library.entity.Library;
import com.shalyapin.library.exception.LibraryException;
import com.shalyapin.library.repository.AuthorRepository;
import com.shalyapin.library.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final AuthorRepository authorRepository;

    public Library createLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public Library getLibrary(Long id) {
        System.out.println("KEKE");
        return libraryRepository.findById(id).orElseThrow(() -> new LibraryException("No library with such id"));
    }

    public Library updateLibrary(Long id, Library newLibrary) {
        Library library = libraryRepository.findById(id).orElseThrow(() -> new LibraryException("No library with such id")); //Нужно ли проверять наличие?
        newLibrary.setId(id);
        return libraryRepository.save(newLibrary);
    }

    public void deleteLibrary(Long id) { //Нужно ли проверять наличие данной бибилотеки? Нужно ли возвращать булиан или достаточно войда?
        libraryRepository.deleteById(id);
    }

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();

    }

    //TODO Сделать возврат по содержанию слова а не полному соответсвтию
    public List<Library> getLibraryByName(String name) {
        return libraryRepository.findByName(name);
    }

    public Library postLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public Library patchLibraryName(Long id, String name) {
        Library library = libraryRepository.findById(id).orElseThrow(() -> new LibraryException("No lib with that id"));
        library.setName(name);
        return libraryRepository.save(library);
    }
}
