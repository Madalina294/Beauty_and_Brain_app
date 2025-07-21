package net.java.backend.mapper;

import net.java.backend.beauty_domain.User;
import net.java.backend.beauty_dto.UserDto;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPasswordHash(),
                user.getProducts(), user.getReminders(), user.getRoutines(),
                user.getAdvices(), user.getCreatedAt(), user.getUpdatedAt());
    }
    public static User mapToUser(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail(), userDto.getPasswordHash(),
                userDto.getProducts(), userDto.getReminders(), userDto.getRoutines(),
                userDto.getAdvices(), userDto.getCreatedAt(), userDto.getUpdatedAt());
    }
}
