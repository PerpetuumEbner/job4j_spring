package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.User;
import ru.job4j.accident.repository.UserJdbcTemplate;

import java.util.Collection;

@Service
public class UserService {
    private final UserJdbcTemplate userJdbcTemplate;

    public UserService(UserJdbcTemplate userJdbcTemplate) {
        this.userJdbcTemplate = userJdbcTemplate;
    }

    public Collection<User> findAll() {
        return userJdbcTemplate.findAll();
    }
}