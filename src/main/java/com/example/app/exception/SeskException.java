package com.example.app.exception;


import com.example.app.exception.enums.ExceptionCode;

import lombok.Getter;

@Getter
public class SeskException extends Exception {

  private final ExceptionCode responseCode;
  
  public SeskException(ExceptionCode pResponseCode) {
    super(pResponseCode.getMessage());
    responseCode = pResponseCode;
  }

  public SeskException(ExceptionCode pResponseCode, Exception e) {
    super(e.getMessage());
    responseCode = pResponseCode;
  }

  public SeskException(ExceptionCode pResponseCode, String message) {
    super(message);
    responseCode = pResponseCode;
  }
}
