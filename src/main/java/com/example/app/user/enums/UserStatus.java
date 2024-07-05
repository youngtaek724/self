package com.example.app.user.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true, title = "회원 상태", description = "USING : 사용중, STOP : 정지, WITHDRAW : 탈퇴")
public enum UserStatus {
  USING, STOP, WITHDRAW
}
