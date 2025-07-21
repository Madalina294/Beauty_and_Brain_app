package net.java.backend.beauty_controller;

import java.util.List;


import net.java.backend.beauty_domain.User;
import net.java.backend.beauty_service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{UserId}")

    public User getUserById(@PathVariable Long UserId) {
        return userService.getUserById(UserId);
    }

    @PostMapping

    public User saveOrUpdateUser(@RequestBody User user) {
        return userService.saveOrUpdateUser(user);
    }
} 

