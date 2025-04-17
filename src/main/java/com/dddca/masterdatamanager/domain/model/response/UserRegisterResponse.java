package com.dddca.masterdatamanager.domain.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Schema(description = "新規ユーザー登録のレスポンス")
@Builder
public record UserRegisterResponse(
        @Schema(description = "メッセージ", example = "SUCCESS REGISTER")
        String message
) {
}
