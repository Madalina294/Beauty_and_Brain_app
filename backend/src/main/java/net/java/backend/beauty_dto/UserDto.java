package net.java.backend.beauty_dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.java.backend.beauty_domain.Advice;
import net.java.backend.beauty_domain.Product;
import net.java.backend.beauty_domain.Reminder;
import net.java.backend.beauty_domain.Routine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    private Long id;

    private String name;

    private String email;

    private String passwordHash;

    private List<Product> products = new ArrayList<>();

    private List<Reminder> reminders = new ArrayList<>();

    private List<Routine> routines = new ArrayList<>();

    private List<Advice> advices = new ArrayList<>();

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

}

