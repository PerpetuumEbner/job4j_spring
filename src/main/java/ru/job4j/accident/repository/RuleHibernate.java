package ru.job4j.accident.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Rule;

import java.util.Collection;

@Repository
public class RuleHibernate implements Wrapper {
    private final SessionFactory sf;

    public RuleHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public Rule findById(int id) {
        return (Rule) this.tx(session -> session.createQuery("from Rule where id = :id")
                .setParameter("id", id).uniqueResult(), sf);
    }

    public Collection<Rule> findAll() {
        return this.tx(session -> session.createQuery("from Accident").list(), sf);
    }
}