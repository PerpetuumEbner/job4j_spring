package ru.job4j.accident.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.accident.model.User;
import ru.job4j.accident.service.AuthorityService;
import ru.job4j.accident.service.UserService;

@Controller
public class RegControl {
    private final PasswordEncoder encoder;

    private final UserService users;

    private final AuthorityService authorities;

    public RegControl(PasswordEncoder encoder, UserService users, AuthorityService authorities) {
        this.encoder = encoder;
        this.users = users;
        this.authorities = authorities;
    }

    @PostMapping("/reg")
    public String regSave(@ModelAttribute User user) {
        if (user.getUsername().equals("") || user.getPassword().equals("")) {
            return "redirect:/reg?empty=true";
        }
        if (users.findByUsername(user.getUsername()) == null) {
            user.setEnabled(true);
            user.setPassword(encoder.encode(user.getPassword()));
            user.setAuthority(authorities.findByAuthority("ROLE_USER"));
            users.create(user);
            return "redirect:/login";
        } else {
            return "redirect:/reg?exists=true";
        }

    }

    @GetMapping("/reg")
    public String regPage(Model model, @RequestParam(value = "exists", required = false) String exists, @RequestParam(value = "empty", required = false) String empty) {
        String errorMessage = null;
        if (exists != null) {
            errorMessage = "User with the same name already exists!!";
        }
        if (empty != null) {
            errorMessage = "Username and Password cannot be empty!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "reg";
    }
}