package ch.oliumbi.compass.core;

import ch.oliumbi.compass.core.autoload.AutoloadService;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Compass {

  private static final Logger LOGGER = LoggerFactory.getLogger(Compass.class);
  private static final List<Object> instances = new ArrayList<>();
  private static Class<?> clazz;

  private Compass() {}

  public static void start(Class<?> clazz, String[] arguments) {
    LOGGER.info("Started compass");

    Compass.clazz = clazz;

    AutoloadService autoloadService = new AutoloadService(clazz);
    instances.addAll(autoloadService.autoload());
    LOGGER.info("Autoloaded " + instances.size() + " classes");
  }

  public static List<Object> instances() {
    return instances;
  }

  public static <T> List<T> instances(Class<T> clazz) {
    return instances.stream().filter(clazz::isInstance).map(clazz::cast).toList();
  }

  public static Class<?> clazz() {
    return clazz;
  }

  public static URL resource(String name) {
    return clazz.getResource(name);
  }
}
