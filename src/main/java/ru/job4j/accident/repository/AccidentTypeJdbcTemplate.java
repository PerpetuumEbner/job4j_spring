package ru.job4j.accident.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;

import java.util.Collection;

@Repository
public class AccidentTypeJdbcTemplate {
    private final JdbcTemplate jdbc;

    public AccidentTypeJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public AccidentType findById(int id) {
        return jdbc.query("SELECT * FROM types WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(AccidentType.class))
                .stream().findAny().orElse(null);
    }

    public Collection<AccidentType> findAll() {
        return jdbc.query("SELECT * FROM types", new BeanPropertyRowMapper<>(AccidentType.class));
    }
}