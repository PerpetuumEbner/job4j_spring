package ru.job4j.accident.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import ru.job4j.accident.model.User;

import java.util.Collection;

@Service
public class UserHibernate implements Wrapper {
    private final SessionFactory sf;

    public UserHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public Collection<User> findAll() {
        return this.tx(session -> session.createQuery("from User").list(), sf);
    }
}