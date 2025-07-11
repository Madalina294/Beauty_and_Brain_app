package beauty.app.controller;

import java.util.List;

import beauty.app.service.UserService;
import beauty.app.domain.User;
import org.springframework.security.access.annotation.Secured;
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
    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{UserId}")
    @Secured("ROLE_ADMIN")
    public User getUserById(@PathVariable Long UserId) {
        return userService.getUserById(UserId);
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    public User saveOrUpdateUser(@RequestBody User user) {
        return userService.saveOrUpdateUser(user);
    }
} 

