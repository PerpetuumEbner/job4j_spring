package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentHibernate;

import java.util.Collection;

@Service
public class AccidentService {
    private final AccidentHibernate accidentHibernate;

    public AccidentService(AccidentHibernate accidentHibernate) {
        this.accidentHibernate = accidentHibernate;
    }

    public void create(Accident accident) {
        accidentHibernate.create(accident);
    }

    public Collection<Accident> findAll() {
        return accidentHibernate.findAll();
    }

    public Accident findById(int id) {
        return accidentHibernate.findById(id);
    }

    public void update(Accident accident) {
        accidentHibernate.update(accident);
    }
}