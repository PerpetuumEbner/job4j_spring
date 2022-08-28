package ru.job4j.accident.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;

@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void create(Accident accident) {
        jdbc.update("INSERT INTO accidents (name, text, address, type_id) VALUES (?, ?, ?, ?)",
                accident.getName(), accident.getText(), accident.getAddress(), accident.getType());
    }

    public void update(Accident accident) {
        jdbc.update("UPDATE accidents SET name = ?, text = ?, address = ?, type_id = ? WHERE id = ?",
                accident.getName(), accident.getText(), accident.getAddress(), accident.getId(), accident.getId());
    }

    public Accident findById(int id) {
        return jdbc.query("SELECT * FROM accidents WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Accident.class))
                .stream().findAny().orElse(null);
    }

    public List<Accident> findAll() {
        return jdbc.query("SELECT * FROM accidents", new BeanPropertyRowMapper<>(Accident.class));
    }
}