package ch.oliumbi.compass;

import ch.oliumbi.compass.autoload.AutoloadService;
import ch.oliumbi.compass.web.Web;
import ch.oliumbi.compass.web.WebHandler;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Compass {

  public static final Logger LOGGER = LoggerFactory.getLogger(Compass.class);

  public static void start(Class<?> clazz, String[] arguments) {
    LOGGER.info("Started compass");

    AutoloadService autoloadService = new AutoloadService();
    List<Object> instances = autoloadService.autoload(clazz.getPackageName());

    WebHandler webHandler = new WebHandler(instances);

    Web web = new Web(webHandler);
    web.start();
  }
}
