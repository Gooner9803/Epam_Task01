package com.example.simple_rest_api.exception;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class ApiError {

  private final HttpStatus status;
  private final Instant timestamp;
  private final String message;
}
