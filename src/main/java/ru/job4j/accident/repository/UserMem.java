package ru.job4j.accident.repository;

import ru.job4j.accident.model.User;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserMem {
    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    private UserMem() {
        users.put(1, new User(1, "Stanislav"));
        users.put(2, new User(2, "Pavel"));
        users.put(3, new User(3, "Andrey"));
        users.put(4, new User(4, "Nikolay"));
    }

    public Collection<User> findAll() {
        return users.values();
    }
}