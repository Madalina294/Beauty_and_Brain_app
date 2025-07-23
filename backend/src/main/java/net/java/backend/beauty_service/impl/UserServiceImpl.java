package net.java.backend.beauty_service.impl;

import java.time.LocalDateTime;
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

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User does not exist with the given id: "+id));
        user.setId(user.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPasswordHash(userDto.getPasswordHash());
        user.setUpdatedAt(userDto.getUpdatedAt());
        user.setCreatedAt(userDto.getCreatedAt());
        user.getProducts().clear();
        user.getProducts().addAll(userDto.getProducts());
        user.getAdvices().clear();
        user.getAdvices().addAll(userDto.getAdvices());
        user.getReminders().clear();
        user.getReminders().addAll(userDto.getReminders());
        user.getRoutines().clear();
        user.getRoutines().addAll(userDto.getRoutines());

        return UserMapper.mapToUserDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User does not exist with the given id: "+id));
        userRepository.deleteById(id);
    }
}
