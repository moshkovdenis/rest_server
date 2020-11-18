package ru.denis.rest_server.controller;

import org.springframework.web.bind.annotation.*;
import ru.denis.rest_server.model.User;
import ru.denis.rest_server.service.UserService;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> allUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User userById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping("/{id}")
    public void updateUserById(@PathVariable("id") Long id, @RequestBody User updateUser) {
        User user = userService.findById(id);
        user.setName(updateUser.getName());
        user.setLogin(updateUser.getLogin());
        user.setPassword(updateUser.getPassword());
        userService.update(user);
    }

    @PutMapping
    public void updateUser(@RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}
