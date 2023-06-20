package com.api.parkingControl.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CustomException extends RuntimeException {
    private final String message;
    public CustomException(String message) {
        this.message = message;
    }
}
