package ch.oliumbi.compass.impl;

import static com.fasterxml.jackson.databind.type.LogicalType.Array;

import ch.oliumbi.compass.core.Compass;
import ch.oliumbi.compass.core.cardinal.dtos.CardinalDirectionDTO;
import ch.oliumbi.compass.core.configuration.Configuration;
import ch.oliumbi.compass.core.configuration.data.ServerConfiguration;
import ch.oliumbi.compass.impl.north.HomeNorth;
import java.util.Arrays;
import java.util.List;

public class Application extends Compass {

  @Override
  protected Configuration configuration() {
    return new SpecificConfiguration();
  }

  @Override
  protected List<CardinalDirectionDTO> routes() {
    return Arrays.asList(
        new CardinalDirectionDTO("/", new HomeNorth())
    );
  }
}
