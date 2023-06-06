package com.wallib.challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UsernameAlreadyExistsException extends RuntimeException {

    public UsernameAlreadyExistsException () {
        super("Username is already registered");
    }

}
