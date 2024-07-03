package com.example.app.exception.handler;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.app.exception.SeskException;
import com.example.app.exception.dto.ExceptionResponse;
import com.example.app.exception.dto.ParameterExceptionData;
import com.example.app.exception.dto.ParameterExceptionResponse;
import com.example.app.exception.enums.ExceptionCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**************************************************************************************
   * Validation Exception (파라미터 오류)
   * 
   * @param ex
   */
 public ResponseEntity<ParameterExceptionResponse> parameterConflict(Exception ex) {
        List<ParameterExceptionData> errors = new ArrayList<>();

        if (ex instanceof BindException) {
            BindException bindException = (BindException) ex;

            for (FieldError error : bindException.getFieldErrors()) {
                ParameterExceptionData errorData = new ParameterExceptionData(error.getField(), error.getDefaultMessage());
                errors.add(errorData);
            }
        } else if (ex instanceof MissingServletRequestParameterException) {
            MissingServletRequestParameterException missingServletRequestParameterException = (MissingServletRequestParameterException) ex;
            ParameterExceptionData errorData = new ParameterExceptionData(
                    missingServletRequestParameterException.getParameterName(),
                    missingServletRequestParameterException.getMessage());
            errors.add(errorData);
        } else if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) ex;
            for (FieldError error : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
                ParameterExceptionData errorData = new ParameterExceptionData(error.getField(),
                        error.getDefaultMessage());
                errors.add(errorData);
            }
        }

        return new ResponseEntity<>(new ParameterExceptionResponse(errors), HttpStatus.BAD_REQUEST);
    }


  /**************************************************************************************
   * CommonException Handler
   * 
   * @param ex
   */
  @ExceptionHandler({ SeskException.class })
  public ResponseEntity<ExceptionResponse> customExceptionConflict(SeskException ex) {
    log.error("Sesk Exception {}", ex.getMessage(), ex);
    ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getResponseCode(), ex.getMessage());
    return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
  }

  @ExceptionHandler({ AccessDeniedException.class })
  public ResponseEntity<ExceptionResponse> accessDeniedExceptionConflict(AccessDeniedException ex) {
    log.error("Access Denied Exception {}", ex.getMessage(), ex);
    ExceptionResponse exceptionResponse = new ExceptionResponse(ExceptionCode.FORBIDDEN, ex.getMessage());
    return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
  }

  /**************************************************************************************
   * Default Exception Handler
   * 
   * @param ex
   */
 @ExceptionHandler({ Exception.class })
    public ResponseEntity<ExceptionResponse> globalHandleConflict(Exception ex) {
        ExceptionCode responseCode = ExceptionCode.SYSTEM_ERROR;
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex instanceof EntityNotFoundException) {
            responseCode = ExceptionCode.NOT_FOUND;
            httpStatus = HttpStatus.NOT_FOUND;
        }

        log.error("System Exception {}", ex.getMessage(), ex);
        ExceptionResponse exceptionResponse = new ExceptionResponse(responseCode, ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }

}
