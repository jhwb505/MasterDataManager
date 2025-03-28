package com.dddca.masterdatamanager.presentation.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AuthenticatedResourceAPIController {

    @PostMapping("user/details")
    public String getUserDetails(@RequestParam("emailAddress") final String emailAddress,
                                 @RequestParam(value = "versionId", required = false) Optional<Long> versionIdOptional) {
        // TODO ：versionId指定していない場合、現在のcurrentVersionIdを自動設定する、
        // TODO ：固定は暫定
        final Long versionId = versionIdOptional.orElse(Long.valueOf(1));


        // TODO return json指定したい、UserDetails実装まち
        // TODO DBアクセスはJPAではなく、queryで行う、CQRSパターン、実装まち
        return """
                {
                    "userName": "abc@mdm.dddca.com",
                    "versionId": "1",
                    "lastName": "momo",
                    "firstName":"taro",
                    "emailAddress":"abc@mdm.dddca.com",
                    "userNumber":"10001",
                    "staticUserId":"3"
                }
                """;
    }
}
