package com.example.simple_rest_api.exception;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler({InvalidStoreException.class})
  public ResponseEntity<ApiError> handleInvalidStoreException(InvalidStoreException ex) {
    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, Instant.now(), ex.getMessage());

    return new ResponseEntity<>(apiError, apiError.getStatus());
  }
}
