package com.dddca.masterdatamanager.presentation.controller;

import com.dddca.masterdatamanager.domain.service.MdmUserRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/public/api/auth")
public class PublicAuthController {
    @Autowired
    MdmUserRegister mdmUserRegister;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        throw new IllegalStateException("JwtAuthenticationFilterにハンドルされているはず、ここに来るべきでない");
    }

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> credentials) {
        final String firstName = credentials.get("first_name");
        final String lastName = credentials.get("last_name");
        final String emailAddress = credentials.get("email_address");
        final String passWord = credentials.get("password");

        //TODO

       mdmUserRegister.register(firstName, lastName, emailAddress, passWord);
        return "登録が完了しました";
    }

}
