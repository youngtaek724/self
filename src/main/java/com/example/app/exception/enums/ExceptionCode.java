package com.example.app.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {

  SYSTEM_ERROR("error.system", "시스템 오류입니다.\n관리자에게 문의하세요."),
  DONE("error.done", "이미 처리되었습니다."),
  PARAMETER("error.parameter", "입력값이 잘못되었습니다."),
  NOT_FOUND("error.not.found", "데이터가 존재하지 않습니다."),
  DUPLICATED("error.duplicated", "중복된 데이터가 존재합니다."),
  FORBIDDEN("error.forbidden", "권한이 없습니다."),
  UNAUTHORIZED("error.unauthorized", "인증이 필요합니다."),
  LOGIN_FAIL("error.login.fail", "아이디 또는 비밀번호가 맞지 않습니다."),
  ERROR_NOT_MATCH_PASSWORD("error.not.match.password", "비밀번호가 일치하지 않습니다.")
  
  ;
  private final String code;
  private final String message;
}
