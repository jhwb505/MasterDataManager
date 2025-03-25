package com.dddca.masterdatamanager.presentation.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/public/api/auth")
public class PublicAuthController {

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        throw new IllegalStateException("JwtAuthenticationFilterにハンドルされているはず、ここに来るべきでない");
    }
}
