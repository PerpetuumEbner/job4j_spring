package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.RuleMem;

import java.util.Collection;

@Service
public class RuleService {
    private final RuleMem ruleMem;

    public RuleService(RuleMem ruleMem) {
        this.ruleMem = ruleMem;
    }

    public Rule findById(int id) {
        return ruleMem.findById(id);
    }

    public Collection<Rule> findAll() {
        return ruleMem.findAll();
    }
}