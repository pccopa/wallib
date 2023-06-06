package com.wallib.challenge.service;

import com.wallib.challenge.controllers.LoginDTO;
import com.wallib.challenge.models.User;

import java.util.List;

public interface UserService {

    User findByUsername (String username);

    User registerUser (User user);

    String login(LoginDTO login);
}
