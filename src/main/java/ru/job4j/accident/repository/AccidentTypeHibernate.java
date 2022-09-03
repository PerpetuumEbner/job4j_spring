package ru.job4j.accident.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.AccidentType;

import java.util.Collection;

@Repository
public class AccidentTypeHibernate implements Wrapper {
    private final SessionFactory sf;

    public AccidentTypeHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public AccidentType findById(int id) {
        return (AccidentType) this.tx(session -> session.createQuery("from AccidentType where id = :id")
                .setParameter("id", id).uniqueResult(), sf);
    }

    public Collection<AccidentType> findAll() {
        return this.tx(session -> session.createQuery("from AccidentType").list(), sf);
    }
}