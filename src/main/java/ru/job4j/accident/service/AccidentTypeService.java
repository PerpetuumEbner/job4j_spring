package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentTypeHibernate;

import java.util.Collection;

@Service
public class AccidentTypeService {
    private final AccidentTypeHibernate accidentTypeHibernate;

    public AccidentTypeService(AccidentTypeHibernate accidentTypeHibernate) {
        this.accidentTypeHibernate = accidentTypeHibernate;
    }

    public AccidentType findById(int id) {
        return accidentTypeHibernate.findById(id);
    }

    public Collection<AccidentType> findAll() {
        return accidentTypeHibernate.findAll();
    }
}