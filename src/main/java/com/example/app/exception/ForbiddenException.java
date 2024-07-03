package com.example.app.exception;

import com.example.app.exception.enums.ExceptionCode;

public class ForbiddenException extends SeskException {
  public ForbiddenException() {
    super(ExceptionCode.FORBIDDEN);
  }

}
