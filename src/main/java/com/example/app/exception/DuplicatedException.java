package com.example.app.exception;

import com.example.app.exception.enums.ExceptionCode;

import lombok.Getter;

@Getter
public class DuplicatedException extends SeskException {
  public DuplicatedException() {
    super(ExceptionCode.DUPLICATED);
  }
}