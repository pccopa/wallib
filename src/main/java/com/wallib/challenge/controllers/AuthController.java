package com.wallib.challenge.controllers;

import com.wallib.challenge.exceptions.EmailAlreadyExistsException;
import com.wallib.challenge.exceptions.UsernameAlreadyExistsException;
import com.wallib.challenge.models.User;
import com.wallib.challenge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RequestMapping ("v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser (@RequestBody User user) {
        return service.registerUser(user);
    }

    @PostMapping("/login")
    public String login (@RequestBody LoginDTO login) {
        return service.login(login);
    }

    @ExceptionHandler ({EmailAlreadyExistsException.class, UsernameAlreadyExistsException.class })
    public String handler (Exception e) {
        ResponseStatus responseStatus = e.getClass().getAnnotation(ResponseStatus.class);
        HttpStatus httpStatus = responseStatus.value();
        int statusCode = httpStatus.value();
        return "Error  " + statusCode + e.getMessage();
    }
}
