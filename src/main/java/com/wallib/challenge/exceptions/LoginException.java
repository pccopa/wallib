package com.wallib.challenge.exceptions;

import com.wallib.challenge.controllers.LoginDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class LoginException extends RuntimeException{

    public LoginException() {
        super ("Incorrect username or password");
    }
}
