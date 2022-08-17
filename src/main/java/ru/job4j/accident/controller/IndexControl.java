package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.service.AccidentService;
import ru.job4j.accident.service.UserService;

@Controller
public class IndexControl {
    private final AccidentService accidentService;

    private final UserService userService;

    public IndexControl(AccidentService accidentService, UserService userService) {
        this.accidentService = accidentService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("accidents", accidentService.findAll());
        return "index";
    }
}