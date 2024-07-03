package com.example.app.exception;

import com.example.app.exception.enums.ExceptionCode;

import lombok.Getter;

@Getter
public class NotFoundException extends SeskException {
  public NotFoundException() {
    super(ExceptionCode.NOT_FOUND);
  }
}