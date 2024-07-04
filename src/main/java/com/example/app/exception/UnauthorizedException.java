package com.example.app.exception;

import com.example.app.exception.enums.ExceptionCode;

public class UnauthorizedException extends SeskException {

  public UnauthorizedException() {
    super(ExceptionCode.UNAUTHORIZED);
  }
}
