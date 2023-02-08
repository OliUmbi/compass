package ch.oliumbi.compass.core;

import ch.oliumbi.compass.core.configuration.Configuration;
import ch.oliumbi.compass.core.exceptions.ExceptionHandler;
import ch.oliumbi.compass.core.exceptions.InitialisationException;
import ch.oliumbi.compass.core.utilities.ValidationUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Compass {

  private static final Logger LOGGER = LoggerFactory.getLogger(Compass.class);

  private Configuration configuration;
  private ExceptionHandler exceptionHandler = new ExceptionHandler();

  public void start(String[] arguments) {
    LOGGER.info("started compass");

    configure();

    try {
      configuration.parseArguments(arguments);
      configuration.loadConfigurationFiles();
    } catch (Exception exception) {
      exceptionHandler.handle(exception);
    }


  }

  protected abstract Configuration configuration();

  protected void configure() {
    this.configuration = ValidationUtility.notNull(
        configuration(),
        new InitialisationException("configuration is null")
    );
  }
}
