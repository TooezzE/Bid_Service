package com.example.applications.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BidCantBeEditedException extends RuntimeException {

    public BidCantBeEditedException() {
    }

    public BidCantBeEditedException(String message) {
        super(message);
    }

    public BidCantBeEditedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BidCantBeEditedException(Throwable cause) {
        super(cause);
    }

    public BidCantBeEditedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
