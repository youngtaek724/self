package com.example.app.user.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true, title = "회원 타입", description = "USER : 회원, HOTEL : 호텔, ADMIN : 관리자")
public enum UserType {
  USER, HOTEL, ADMIN
}
