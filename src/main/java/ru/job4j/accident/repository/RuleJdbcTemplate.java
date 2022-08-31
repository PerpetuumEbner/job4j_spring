package ru.job4j.accident.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;

import java.util.Collection;

@Repository
public class RuleJdbcTemplate {
    private final JdbcTemplate jdbc;

    public RuleJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Rule findById(int id) {
        return jdbc.queryForObject("SELECT * FROM types WHERE id = ?", new BeanPropertyRowMapper<>(Rule.class), id);
    }

    public Collection<Rule> findAll() {
        return jdbc.query("SELECT * FROM types", new BeanPropertyRowMapper<>(Rule.class));
    }
}