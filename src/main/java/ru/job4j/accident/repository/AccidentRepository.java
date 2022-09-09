package ru.job4j.accident.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccidentRepository extends CrudRepository<Accident, Integer> {
    @Query("select distinct a from Accident a join fetch a.rules where a.id = :id")
    Optional<Accident> findById(@Param("id") Integer accidentId);

    @Query("select distinct a from Accident a join fetch a.rules")
    List<Accident> findAll();
}