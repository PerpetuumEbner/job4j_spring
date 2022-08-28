package ru.job4j.accident.repository;

import ru.job4j.accident.model.Rule;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RuleMem {
    private final Map<Integer, Rule> rules = new ConcurrentHashMap<>();

    RuleMem() {
        rules.put(1, new Rule(1, "Статья 12.1"));
        rules.put(2, new Rule(2, "Статья 12.5"));
        rules.put(3, new Rule(3, "Статья 12.7"));
        rules.put(4, new Rule(4, "Статья 12.8"));
        rules.put(5, new Rule(5, "Статья 12.9"));
    }

    public Rule findById(int id) {
        return rules.get(id);
    }

    public Collection<Rule> findAll() {
        return rules.values();
    }
}