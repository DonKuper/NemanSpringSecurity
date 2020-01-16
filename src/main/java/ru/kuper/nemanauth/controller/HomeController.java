package ru.kuper.nemanauth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kuper.nemanauth.domain.User;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {
            model.addAttribute("user", user.getUsername());
            return "index";
        }
        model.addAttribute("user","anonymous");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PreAuthorize(value = "hasAuthority('USER') or hasAuthority('ADMIN')") //Разрешает попасть на страницу и user, и admin
    @GetMapping("/foruser")
    public String foruser() {
        return "foruser";
    }

    @PreAuthorize(value = "hasAuthority('ADMIN')") //Разрешает попасть на страницу только admin
    @GetMapping("/foradmin")
    public String foradimin() {
        return "foradmin";
    }
}
