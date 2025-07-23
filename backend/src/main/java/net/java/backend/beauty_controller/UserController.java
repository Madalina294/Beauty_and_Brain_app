package net.java.backend.beauty_controller;

import java.util.List;


import net.java.backend.beauty_domain.User;
import net.java.backend.beauty_dto.UserDto;
import net.java.backend.beauty_service.UserService;
import net.java.backend.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") Long UserId) {
        return userService.getUserById(UserId);
    }

    @PostMapping("/save")
    public UserDto saveUser(@RequestBody User user) {
        return userService.saveUser(UserMapper.mapToUserDto(user));
    }

    @PutMapping("/update/{id}")
    public UserDto updateUser(@PathVariable("id") Long UserId, @RequestBody User user) {
        return userService.updateUser(UserId, UserMapper.mapToUserDto(user));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long UserId) {
        userService.deleteUser(UserId);
    }

} 

