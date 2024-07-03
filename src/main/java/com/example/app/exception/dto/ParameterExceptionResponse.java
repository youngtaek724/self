package com.example.app.exception.dto;

import java.util.List;

import com.example.app.exception.enums.ExceptionCode;

import lombok.Getter;

@Getter
public class ParameterExceptionResponse extends ExceptionResponse {

  private List<ParameterExceptionData> errors;

  public ParameterExceptionResponse(List<ParameterExceptionData> errors) {
    super(ExceptionCode.PARAMETER, null);
    this.errors = errors;
  }

}
