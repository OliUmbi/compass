package ch.oliumbi.compass.server;

import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Server {

  public static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

  public static void start(int port) {

    try {
      org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server();
      Entrypoint entrypoint = new Entrypoint();

      HttpConfiguration httpConfiguration = new HttpConfiguration();

      HttpConnectionFactory httpConnectionFactory = new HttpConnectionFactory(httpConfiguration);

      ServerConnector serverConnector = new ServerConnector(server, httpConnectionFactory);
      serverConnector.setPort(port);
      server.addConnector(serverConnector);

      GzipHandler gzipHandler = new GzipHandler();
      server.setHandler(gzipHandler);
      gzipHandler.setMinGzipSize(1024);
      gzipHandler.setHandler(entrypoint);

      server.start();

      LOGGER.info("Started web server");
    } catch (Exception e) {
      LOGGER.error("Failed to start web server", e);
    }
  }
}
