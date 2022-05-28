package ru.yandex.practicum.catsgram.controller;


import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exceptions.InvalidEmailException;
import ru.yandex.practicum.catsgram.exceptions.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {
    private Set< User> users = new HashSet<>();

    @GetMapping
    public Set<User> getUsers() {
        return users;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        try {
            if (users.contains(user))
                throw new UserAlreadyExistException();
            else if (user.getEmail().isBlank() || user.getEmail().isEmpty() || user.getEmail() == null)
                throw new InvalidEmailException();
            else users.add(user);

        } catch (UserAlreadyExistException | InvalidEmailException e) {
            e.getMessage();
        }
        return user;
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        try {
            if (user.getEmail().isBlank() || user.getEmail().isEmpty() || user.getEmail() == null)
                throw new InvalidEmailException();
            else {
                users.remove(user);
                users.add(user);
            }
        } catch (InvalidEmailException e) {
            e.getMessage();

        }

        return user;
    }
}
