package ch.oliumbi.compass.core.configuration;

import ch.oliumbi.compass.core.configuration.data.Arguments;
import ch.oliumbi.compass.core.configuration.data.ServerConfiguration;
import ch.oliumbi.compass.core.configuration.data.SqlConfiguration;
import ch.oliumbi.compass.core.exceptions.ConfigurationException;
import ch.oliumbi.compass.core.utilities.ValidationUtility;
import java.lang.reflect.Field;

public abstract class Configuration {

  private static Arguments arguments;
  private static ServerConfiguration serverConfiguration;
  private static SqlConfiguration sqlConfiguration;

  public void parseArguments(String[] args) {

    String[] arguments = ValidationUtility.notNull(args, new ConfigurationException("arguments is null"));

    if (Arguments.class.getDeclaredFields().length * 2 < args.length) {
      // todo exception handling
      throw new RuntimeException("too many arguments");
    }

    for (int i = 0; i < args.length; i = i + 2) {
      String flag = args[i];
      String value = args[i + 1];

      if (!flag.startsWith("-")) {
        // todo exception handling
        throw new RuntimeException("flag missing");
      }

      String key = flag.substring(1);

      // todo find flag name and set data object;

    }

    for (String arg : args) {


      System.out.println(arg);
    }
  }

  public void loadConfigurationFiles() {

  }
}
