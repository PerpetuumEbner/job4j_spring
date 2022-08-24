package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccidentTypeMem {
    private final Map<Integer, AccidentType> types = new ConcurrentHashMap<>();

    AccidentTypeMem() {
        types.put(1, new AccidentType(1, "Легковой автомобиль"));
        types.put(2, new AccidentType(2, "Грузовой автомобиль "));
        types.put(3, new AccidentType(3, "Мотоцикл"));
        types.put(4, new AccidentType(4, "Велосипед"));
        types.put(5, new AccidentType(5, "Пешеход"));
    }

    public AccidentType findById(int id) {
        return types.get(id);
    }

    public Collection<AccidentType> findAll() {
        return types.values();
    }
}