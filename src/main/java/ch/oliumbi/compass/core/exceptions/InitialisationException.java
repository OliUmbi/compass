package ch.oliumbi.compass.core.exceptions;

public class InitialisationException extends RuntimeException {

  public InitialisationException() {
    super("initialisation exception");
  }

  public InitialisationException(String message) {
    super(message);
  }

  public InitialisationException(String message, Throwable cause) {
    super(message, cause);
  }
}
