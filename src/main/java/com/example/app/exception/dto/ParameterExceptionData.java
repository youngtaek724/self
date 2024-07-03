package com.example.app.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ParameterExceptionData {
  private String field;
  private String message;

}
