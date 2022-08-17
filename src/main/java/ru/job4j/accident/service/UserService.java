package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.User;
import ru.job4j.accident.repository.UserMem;

import java.util.Collection;

@Service
public class UserService {
    private final UserMem userMem;

    public UserService(UserMem userMem) {
        this.userMem = userMem;
    }

    public Collection<User> findAll() {
        return userMem.findAll();
    }
}