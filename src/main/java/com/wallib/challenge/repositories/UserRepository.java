package com.wallib.challenge.repositories;

import com.wallib.challenge.exceptions.EmailAlreadyExistsException;
import com.wallib.challenge.exceptions.UsernameAlreadyExistsException;
import com.wallib.challenge.models.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    Map<String, User> users = new HashMap<>();

    public User registerUser (User user) {
        if (users.containsKey(user.getUsername())) {
            throw new UsernameAlreadyExistsException ();
        }
        if (users.values().stream()
                .filter(x-> x.getEmail().equals(user.getEmail()))
                .findFirst()
                .isPresent()) {
            throw new EmailAlreadyExistsException();
        }
        users.put (user.getUsername(), user);
        return user;
    }


    public Optional<User> findByUsername(String username) {
        if (users.containsKey(username)) {
            return Optional.of(users.get(username));
        } else return Optional.empty();
    }

    public Collection<User> findAll () {
        return users.values();
    }

}
