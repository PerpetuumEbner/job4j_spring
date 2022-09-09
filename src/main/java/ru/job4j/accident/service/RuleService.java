package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.RuleRepository;

import java.util.Collection;

@Service
public class RuleService {
    private final RuleRepository ruleRepository;

    public RuleService(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public Rule findById(int id) {
        return ruleRepository.findById(id).orElse(null);
    }

    public Collection<Rule> findAll() {
        return ruleRepository.findAll();
    }
}