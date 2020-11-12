package com.lucidworks.querying.api.fusion;

public class FusionApiException extends RuntimeException {

  public FusionApiException(String message) {
    super(message);
  }

  public FusionApiException(String message, Throwable cause) {
    super(message, cause);
  }
}
