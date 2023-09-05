package ch.oliumbi.compass;

import ch.oliumbi.compass.autoload.AutoloadService;
import ch.oliumbi.compass.http.HttpServer;
import ch.oliumbi.compass.http.HttpHandler;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Compass {

  public static final Logger LOGGER = LoggerFactory.getLogger(Compass.class);

  public static void start(Class<?> clazz, String[] arguments) {
    LOGGER.info("Started compass");

    AutoloadService autoloadService = new AutoloadService(clazz);
    List<Object> instances = autoloadService.autoload();

    HttpHandler httpHandler = new HttpHandler(instances);

    HttpServer httpServer = new HttpServer(httpHandler);
    httpServer.start();
  }
}
