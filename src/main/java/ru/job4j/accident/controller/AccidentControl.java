package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.service.AccidentService;
import ru.job4j.accident.service.AccidentTypeService;

@Controller
public class AccidentControl {
    private final AccidentService accidents;

    private final AccidentTypeService types;

    public AccidentControl(AccidentService accidents, AccidentTypeService types) {
        this.accidents = accidents;
        this.types = types;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("types", types.findAll());
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, @RequestParam("typeId") int typeId) {
        accident.setType(types.findDyId(typeId));
        accidents.create(accident);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("types", types.findAll());
        model.addAttribute("accident", accidents.findById(id));
        return "accident/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Accident accident, @RequestParam("typeId") int typeId) {
        accident.setType(types.findDyId(typeId));
        accidents.update(accident);
        return "redirect:/";
    }
}