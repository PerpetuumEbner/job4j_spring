package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentTypeJdbcTemplate;

import java.util.Collection;

@Service
public class AccidentTypeService {
    private final AccidentTypeJdbcTemplate accidentTypeJdbcTemplate;

    public AccidentTypeService(AccidentTypeJdbcTemplate accidentTypeJdbcTemplate) {
        this.accidentTypeJdbcTemplate = accidentTypeJdbcTemplate;
    }

    public AccidentType findById(int id) {
        return accidentTypeJdbcTemplate.findById(id);
    }

    public Collection<AccidentType> findAll() {
        return accidentTypeJdbcTemplate.findAll();
    }
}