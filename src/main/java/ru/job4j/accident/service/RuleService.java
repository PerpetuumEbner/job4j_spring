package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.RuleHibernate;

import java.util.Collection;

@Service
public class RuleService {
    private final RuleHibernate ruleHibernate;

    public RuleService(RuleHibernate ruleHibernate) {
        this.ruleHibernate = ruleHibernate;
    }

    public Rule findById(int id) {
        return ruleHibernate.findById(id);
    }

    public Collection<Rule> findAll() {
        return ruleHibernate.findAll();
    }
}