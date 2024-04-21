package com.dddca.masterdatamanager.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showLoginPage() {
        return "home";
    }
}
