package com.jasmine22.challenge.share;

import com.jasmine.creditcalculator.message.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SimpleExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  public ErrorResponse invalidInputParam(Exception ex) {
    return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
  }
}
