package com.dddca.masterdatamanager.domain.model.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(description = "新規ユーザー登録のリクエスト")
@Builder
public record UserRegisterRequest(
        @JsonProperty("first_name")
        @Schema(description = "First Name(名)")
        String firstName,
        @JsonProperty("last_name")
        @Schema(description = "Last Name(姓)")
        String lastName,
        @JsonProperty("email_address")
        @Schema(description = "E-mailアドレス")
        String emailAddress,
        @JsonProperty("password")
        @Schema(description = "パスワード")
        String passWord
) {

}
