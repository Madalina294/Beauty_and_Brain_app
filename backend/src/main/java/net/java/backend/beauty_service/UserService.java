package net.java.backend.beauty_service;

import java.util.List;


import net.java.backend.beauty_domain.User;
import net.java.backend.beauty_repository.UserJPARepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private final UserJPARepository userRepository;

    public UserService(UserJPARepository UserRepository) {
        this.userRepository = UserRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }
}
