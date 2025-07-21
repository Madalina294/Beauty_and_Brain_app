package net.java.backend.beauty_service.impl;

import java.util.List;
import java.util.stream.Collectors;

import net.java.backend.beauty_domain.User;
import net.java.backend.beauty_dto.UserDto;
import net.java.backend.beauty_repository.UserJPARepository;
import net.java.backend.beauty_service.UserService;
import net.java.backend.exception.ResourceNotFoundException;
import net.java.backend.mapper.UserMapper;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserJPARepository userRepository;

    public UserServiceImpl(UserJPARepository UserRepository) {
        this.userRepository = UserRepository;
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User does not exist with the given id: "+id));
        return UserMapper.mapToUserDto(user);
    }

    public UserDto saveUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }
}
