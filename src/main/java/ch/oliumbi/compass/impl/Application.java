package ch.oliumbi.compass.impl;

import ch.oliumbi.compass.core.Compass;
import ch.oliumbi.compass.core.configuration.Configuration;
import ch.oliumbi.compass.core.configuration.data.ServerConfiguration;

public class Application extends Compass {

  @Override
  protected Configuration configuration() {
    return new SpecificConfiguration();
  }
}
