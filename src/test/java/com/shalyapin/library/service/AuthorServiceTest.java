package com.shalyapin.library.service;

import com.shalyapin.library.dto.AuthorDTO;
import com.shalyapin.library.entity.Author;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorServiceTest {
    private AuthorService authorService;
    @Test
    void createAuthor() {
        AuthorDTO authorDTO=new AuthorDTO();
       Author author=authorService.createAuthor(authorDTO);
    }

    @Test
    void selectAuthor() {
    }

    @Test
    void deleteAuthor() {
    }
}