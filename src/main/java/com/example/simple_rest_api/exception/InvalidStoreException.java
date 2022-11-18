package com.example.simple_rest_api.exception;

public class InvalidStoreException extends RuntimeException{

  public static final String DEFAULT_MESSAGE = "The store is invalid.";

  public InvalidStoreException() {
    super(DEFAULT_MESSAGE);
  }

  public InvalidStoreException(String message) {
    super(message);
  }
}
