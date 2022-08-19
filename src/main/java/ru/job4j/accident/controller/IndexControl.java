package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.service.AccidentService;
import ru.job4j.accident.service.AccidentTypeService;
import ru.job4j.accident.service.UserService;

@Controller
public class IndexControl {
    private final AccidentService accidentService;

    private final UserService userService;

    private final AccidentTypeService typeService;

    public IndexControl(AccidentService accidentService, UserService userService, AccidentTypeService typeService) {
        this.accidentService = accidentService;
        this.userService = userService;
        this.typeService = typeService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("types", typeService.findAll());
        model.addAttribute("accidents", accidentService.findAll());
        return "index";
    }
}