package ch.oliumbi.compass.core.exceptions;

public class ReflectionException extends RuntimeException {
  public ReflectionException() {
    super("reflection exception");
  }

  public ReflectionException(String message) {
    super(message);
  }

  public ReflectionException(String message, Throwable cause) {
    super(message, cause);
  }
}
