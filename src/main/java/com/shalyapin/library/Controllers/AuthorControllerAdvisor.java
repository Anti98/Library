package com.shalyapin.library.Controllers;

import com.shalyapin.library.exception.AuthorException;
import com.shalyapin.library.exception.BookException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springfox.documentation.annotations.ApiIgnore;

@RestControllerAdvice
public class AuthorControllerAdvisor {
    @ApiIgnore
    @ExceptionHandler(AuthorException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleAuthorException(AuthorException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
