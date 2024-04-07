package com.example.applications.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BidAlreadySentException extends RuntimeException {

    public BidAlreadySentException() {
    }

    public BidAlreadySentException(String message) {
        super(message);
    }

    public BidAlreadySentException(String message, Throwable cause) {
        super(message, cause);
    }

    public BidAlreadySentException(Throwable cause) {
        super(cause);
    }

    public BidAlreadySentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
