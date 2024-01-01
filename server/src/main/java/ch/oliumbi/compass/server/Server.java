package ch.oliumbi.compass.server;

import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.ServerConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server {

  public static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

  public static void start() {

    try {
      org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server();
      Entrypoint entrypoint = new Entrypoint();

      HttpConfiguration httpConfiguration = new HttpConfiguration();

      HttpConnectionFactory httpConnectionFactory = new HttpConnectionFactory(httpConfiguration);

      ServerConnector serverConnector = new ServerConnector(server, httpConnectionFactory);
      serverConnector.setPort(8080);

      server.addConnector(serverConnector);
      server.setHandler(entrypoint);
      server.start();

      LOGGER.info("Started web server");
    } catch (Exception e) {
      LOGGER.error("Failed to start web server", e);
    }
  }
}
