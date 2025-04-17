package com.dddca.masterdatamanager.presentation.controller;

import com.dddca.masterdatamanager.domain.model.request.UserRegisterRequest;
import com.dddca.masterdatamanager.domain.service.MdmUserRegister;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name= "PublicAuth")
@RestController
@RequestMapping("/public/api/auth")
public class PublicAuthController {

    @Autowired
    MdmUserRegister mdmUserRegister;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        throw new IllegalStateException("JwtAuthenticationFilterにハンドルされているはず、ここに来るべきでない");
    }

    @Operation(summary = "新規ユーザー登録", description = "新規ユーザー登録を行うAPIです。")
    @ApiResponse(responseCode = "200", description = "登録成功", content = @Content(mediaType = "application/json"))
    @PostMapping("/register")
    public String register(@RequestBody UserRegisterRequest req) {

        System.out.println(req);

//      mdmUserRegister.register(firstName, lastName, emailAddress, passWord);
        return "登録が完了しました";
    }

}
