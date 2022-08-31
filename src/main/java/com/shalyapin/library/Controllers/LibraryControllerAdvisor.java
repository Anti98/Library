package com.shalyapin.library.Controllers;

import com.shalyapin.library.exception.BookException;
import com.shalyapin.library.exception.LibraryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springfox.documentation.annotations.ApiIgnore;
@RestControllerAdvice
public class LibraryControllerAdvisor {
    @ApiIgnore
    @ExceptionHandler(LibraryException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleLibraryException(LibraryException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}


