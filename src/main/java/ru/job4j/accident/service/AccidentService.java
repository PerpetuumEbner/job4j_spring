package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentJdbcTemplate;

import java.util.Collection;

@Service
public class AccidentService {
    private final AccidentJdbcTemplate accidentJdbcTemplate;

    public AccidentService(AccidentJdbcTemplate accidentJdbcTemplate) {
        this.accidentJdbcTemplate = accidentJdbcTemplate;
    }

    public void create(Accident accident) {
        accidentJdbcTemplate.create(accident);
    }

    public Collection<Accident> findAll() {
        return accidentJdbcTemplate.findAll();
    }

    public Accident findById(int id) {
        return accidentJdbcTemplate.findById(id);
    }

    public void update(Accident accident) {
        accidentJdbcTemplate.update(accident);
    }
}