package com.wallib.challenge.service.impl;

import com.wallib.challenge.controllers.LoginDTO;
import com.wallib.challenge.exceptions.LoginException;
import com.wallib.challenge.models.User;
import com.wallib.challenge.repositories.UserRepository;
import com.wallib.challenge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername (username).orElseThrow (()-> new LoginException());
    }

    @Override
    public User registerUser(User user) {
        return repository.registerUser(user);
    }

    @Override
    public String login(LoginDTO login) {
        Optional<User> user = repository.findByUsername(login.getUsername());
        if (user.isPresent() && user.get().getPassword().equals(login.getPassword())) {
            return "Logeado correctamente";
        } else return "Credenciales incorrectas";
    }


}
