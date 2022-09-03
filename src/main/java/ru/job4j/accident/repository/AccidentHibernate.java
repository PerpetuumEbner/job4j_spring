package ru.job4j.accident.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;

@Repository
public class AccidentHibernate implements Wrapper {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public void create(Accident accident) {
        this.tx(session -> session.save(accident), sf);
    }

    public void update(Accident accident) {
        this.tx(session -> {
            session.update(accident);
            return accident;
        }, sf);
    }

    public Accident findById(int id) {
        return (Accident) this.tx(session -> session.createQuery("select distinct a from Accident a join fetch a.rules where a.id = :id")
                .setParameter("id", id).uniqueResult(), sf);
    }

    public List<Accident> findAll() {
        return this.tx(session -> session.createQuery("select distinct a from Accident a join fetch a.rules").list(), sf);
    }
}