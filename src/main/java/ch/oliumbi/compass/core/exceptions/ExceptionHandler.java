package ch.oliumbi.compass.core.exceptions;

import ch.oliumbi.compass.core.Compass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

  public void handle(Exception exception) {
    if (exception instanceof ReflectionException) {
      LOGGER.error("reflection exception occurred", exception);
      return;
    }
    if (exception instanceof InitialisationException) {
      LOGGER.error("initialisation exception occurred", exception);
      return;
    }
    LOGGER.error("unknown exception occurred", exception);
  }
}
