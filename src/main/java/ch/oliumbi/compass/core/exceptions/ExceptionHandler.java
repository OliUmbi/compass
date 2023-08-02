package ch.oliumbi.compass.core.exceptions;

import ch.oliumbi.compass.core.logging.Logging;

public class ExceptionHandler {

  public static void handle(Exception exception) {
    if (exception instanceof ReflectionException) {
      Logging.error("reflection exception occurred", exception);
      return;
    }
    if (exception instanceof InitialisationException) {
      Logging.error("initialisation exception occurred", exception);
      return;
    }
    Logging.error("unknown exception occurred", exception);
  }
}
