package com.example.app.exception;

import com.example.app.exception.enums.ExceptionCode;

import lombok.Getter;

@Getter
public class ParamException extends SeskException {
  public ParamException(String message) {
    super(ExceptionCode.PARAMETER, message);
  }
}