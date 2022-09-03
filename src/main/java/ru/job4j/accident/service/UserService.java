package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.User;
import ru.job4j.accident.repository.UserHibernate;
import ru.job4j.accident.repository.UserJdbcTemplate;

import java.util.Collection;

@Service
public class UserService {
    private final UserHibernate userHibernate;

    public UserService(UserHibernate userHibernate) {
        this.userHibernate = userHibernate;
    }

    public Collection<User> findAll() {
        return userHibernate.findAll();
    }
}