package com.dddca.masterdatamanager.presentation.controller;

import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    public String showLoginPage() {
        return "login";
    }
}
