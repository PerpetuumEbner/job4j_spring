package ru.job4j.accident.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;

import java.util.List;

@Repository
public interface AccidentTypeRepository extends CrudRepository<AccidentType, Integer> {
    List<AccidentType> findAll();
}