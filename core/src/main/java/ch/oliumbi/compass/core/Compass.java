package ch.oliumbi.compass.core;

import ch.oliumbi.compass.core.autoload.AutoloadService;
import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Compass {

  public static final Logger LOGGER = LoggerFactory.getLogger(Compass.class);
  public static final List<Object> instances = new ArrayList<>();
  private static Class<?> clazz;

  private Compass() {}

  public static void start(Class<?> clazz, String[] arguments) {
    LOGGER.info("Started compass");

    Compass.clazz = clazz;

    AutoloadService autoloadService = new AutoloadService(clazz);
    instances.addAll(autoloadService.autoload());
  }

  public static List<Object> getInstances() {
    return instances;
  }

  public static <T> List<T> getInstances(Class<T> clazz) {
    return instances.stream().filter(clazz::isInstance).map(clazz::cast).toList();
  }

  public static Class<?> getClazz() {
    return clazz;
  }
}
