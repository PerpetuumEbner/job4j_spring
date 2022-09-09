package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.User;
import ru.job4j.accident.repository.UserRepository;

import java.util.Collection;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> findAll() {
        return userRepository.findAll();
    }
}