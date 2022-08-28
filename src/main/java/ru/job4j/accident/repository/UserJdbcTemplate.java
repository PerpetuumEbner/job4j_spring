package ru.job4j.accident.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.User;

import java.util.Collection;

@Repository
public class UserJdbcTemplate {
    private final JdbcTemplate jdbc;

    public UserJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Collection<User> findAll() {
        return jdbc.query("SELECT * FROM types", new BeanPropertyRowMapper<>(User.class));
    }
}