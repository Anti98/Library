package com.shalyapin.library.exception;

import org.springframework.beans.factory.annotation.Autowired;

public class BookException extends RuntimeException{
    public BookException(String message) {
        super(message);
    }
}
