package com.example.app.exception.dto;

import com.example.app.exception.enums.ExceptionCode;

import lombok.Getter;

@Getter
public class ExceptionResponse {
  public ExceptionResponse(ExceptionCode exceptionCode, String detailMessage) {
    this.errorCode = exceptionCode.getCode();
    this.message = exceptionCode.getMessage();
    this.detailMessage = detailMessage;
  }

  private String errorCode;
  private String message;
  private String detailMessage;
}
