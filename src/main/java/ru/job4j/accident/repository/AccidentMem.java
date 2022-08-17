package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccidentMem {
    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();

    private AccidentMem() {
        accidents.put(1, new Accident());
        accidents.put(2, new Accident());
        accidents.put(3, new Accident());
        accidents.put(4, new Accident());
        accidents.put(5, new Accident());
    }

    public Collection<Accident> findAll() {
        return accidents.values();
    }
}