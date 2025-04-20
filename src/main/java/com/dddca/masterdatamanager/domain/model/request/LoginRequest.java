package com.dddca.masterdatamanager.domain.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "ログインのリクエスト")
public record LoginRequest(
        @Schema(description = "ユーザー名(Email Address)")
        String username,
        @Schema(description = "パスワード")
        String password
) {
}
