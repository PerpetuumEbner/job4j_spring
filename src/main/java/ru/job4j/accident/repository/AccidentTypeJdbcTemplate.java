package ru.job4j.accident.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;

import java.util.Collection;

@Repository
public class AccidentTypeJdbcTemplate {
    private static JdbcTemplate jdbc = null;

    public AccidentTypeJdbcTemplate(JdbcTemplate jdbc) {
        AccidentTypeJdbcTemplate.jdbc = jdbc;
    }

    public static AccidentType findById(int id) {
        return jdbc.queryForObject("SELECT * FROM types WHERE id = ?", new BeanPropertyRowMapper<>(AccidentType.class), id);
    }

    public Collection<AccidentType> findAll() {
        return jdbc.query("SELECT * FROM types", new BeanPropertyRowMapper<>(AccidentType.class));
    }
}