package com.dddca.masterdatamanager.domain.model.response;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "ログインのレスポンス")
public record LoginResponse(
        @Schema(description = "アクセストークン")
        String access_token
) {
}
