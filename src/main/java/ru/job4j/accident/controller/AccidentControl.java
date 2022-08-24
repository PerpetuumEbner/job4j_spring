package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;
import ru.job4j.accident.service.AccidentTypeService;
import ru.job4j.accident.service.RuleService;

import java.util.List;

@Controller
public class AccidentControl {
    private final AccidentService accidents;

    private final AccidentTypeService types;

    private final RuleService rules;

    public AccidentControl(AccidentService accidents,
                           AccidentTypeService types,
                           RuleService rules) {
        this.accidents = accidents;
        this.types = types;
        this.rules = rules;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", types.findAll());
        model.addAttribute("rules", rules.findAll());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident,
                       @RequestParam("typeId") int typeId,
                       @RequestParam("rulesId") List<Integer> rulesId) {
        for (Integer id : rulesId) {
            accident.addRule(rules.findById(id));
        }
        accident.setType(types.findById(typeId));
        accidents.create(accident);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("types", types.findAll());
        model.addAttribute("rules", rules.findAll());
        model.addAttribute("accident", accidents.findById(id));
        return "accident/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident,
                         @RequestParam("typeId") int typeId,
                         @RequestParam("rulesId") List<Integer> rulesId) {
        for (Integer id : rulesId) {
            accident.addRule(rules.findById(id));
        }
        accident.setType(types.findById(typeId));
        accidents.update(accident);
        return "redirect:/";
    }
}