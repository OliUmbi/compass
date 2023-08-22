package ch.oliumbi.compass.web;

import ch.oliumbi.compass.page.Page;
import java.util.List;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Web {

  public static final Logger LOGGER = LoggerFactory.getLogger(Web.class);
  private final WebHandler webHandler;

  public Web(WebHandler webHandler) {
    this.webHandler = webHandler;
  }

  public void start() {

    try {
      Server server = new Server();
      server.addConnector(connector(server));
      server.setHandler(webHandler);

      server.start();

      LOGGER.info("Started web server");
    } catch (Exception e) {
      LOGGER.error("Failed to start web server", e);
    }
  }

  private ServerConnector connector(Server server) {
    ServerConnector serverConnector = new ServerConnector(server);
    // todo move to config
    serverConnector.setHost("0.0.0.0");
    serverConnector.setPort(8080);
    serverConnector.getConnectionFactories().stream()
        .filter(connectionFactory -> connectionFactory instanceof HttpConnectionFactory)
        .forEach(connectionFactory -> ((HttpConnectionFactory) connectionFactory).getHttpConfiguration()
            .setSendServerVersion(false));

    return serverConnector;
  }
}
