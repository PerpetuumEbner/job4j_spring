package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentTypeRepository;

import java.util.Collection;

@Service
public class AccidentTypeService {
    private final AccidentTypeRepository accidentTypeRepository;

    public AccidentTypeService(AccidentTypeRepository accidentTypeRepository) {
        this.accidentTypeRepository = accidentTypeRepository;
    }

    public AccidentType findById(int id) {
        return accidentTypeRepository.findById(id).orElse(null);
    }

    public Collection<AccidentType> findAll() {
        return accidentTypeRepository.findAll();
    }
}