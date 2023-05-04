package ch.oliumbi.compass.core;

import ch.oliumbi.compass.core.cardinal.Cardinal;
import ch.oliumbi.compass.core.cardinal.dtos.CardinalDirectionDTO;
import ch.oliumbi.compass.core.configuration.Configuration;
import ch.oliumbi.compass.core.exceptions.ExceptionHandler;
import ch.oliumbi.compass.core.exceptions.InitialisationException;
import ch.oliumbi.compass.core.logging.Logging;
import ch.oliumbi.compass.core.utilities.ValidationUtility;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Compass {

  private Cardinal cardinal = new Cardinal();
  private Configuration configuration;

  public void start(String[] arguments) {
    Logging.info("started compass");

    configure();

    try {
      configuration.parseArguments(arguments);
      configuration.loadConfigurationFiles();
    } catch (Exception exception) {
      ExceptionHandler.handle(exception);
    }

    cardinal.start(routes());
  }

  protected abstract Configuration configuration();

  protected abstract List<CardinalDirectionDTO> routes();

  protected void configure() {
    this.configuration = ValidationUtility.notNull(
        configuration(),
        new InitialisationException("configuration is null")
    );
  }
}
