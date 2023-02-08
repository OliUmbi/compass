package ch.oliumbi.compass.core.exceptions;

public class ConfigurationException extends RuntimeException {

  public ConfigurationException() {
    super("configuration exception");
  }

  public ConfigurationException(String message) {
    super(message);
  }

  public ConfigurationException(String message, Throwable cause) {
    super(message, cause);
  }
}
