package com.dddca.masterdatamanager.presentation.controller;

import com.dddca.masterdatamanager.domain.model.request.LoginRequest;
import com.dddca.masterdatamanager.domain.model.request.UserRegisterRequest;
import com.dddca.masterdatamanager.domain.model.response.LoginResponse;
import com.dddca.masterdatamanager.domain.model.response.UserRegisterResponse;
import com.dddca.masterdatamanager.domain.service.MdmUserRegister;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "PublicAuth")
@RestController
@RequestMapping("/public/api/auth")
public class PublicAuthController {

    @Autowired
    MdmUserRegister mdmUserRegister;

    @ApiResponse(responseCode = "200", description = "ログイン成功", content = @Content(mediaType = "application/json"))
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest req) {
        throw new IllegalStateException("JwtAuthenticationFilterにハンドルされているはず、ここに来るべきでない");
    }

    @Operation(summary = "新規ユーザー登録", description = "新規ユーザー登録を行うAPIです。")
    @ApiResponse(responseCode = "200", description = "登録成功", content = @Content(mediaType = "application/json"))
    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@RequestBody UserRegisterRequest req) {
        mdmUserRegister.register(req);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(UserRegisterResponse
                        .builder()
                        .message(
                                String.format("SUCCESS USER REGISTER. First Name: %s, Last Name: %s, E-mail Address: %s",
                                        req.firstName(),
                                        req.lastName(),
                                        req.emailAddress()))
                        .build());
    }
}
