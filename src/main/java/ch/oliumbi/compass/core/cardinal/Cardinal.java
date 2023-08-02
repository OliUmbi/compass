package ch.oliumbi.compass.core.cardinal;

import ch.oliumbi.compass.core.cardinal.dtos.CardinalDirectionDTO;
import ch.oliumbi.compass.core.exceptions.ExceptionHandler;
import ch.oliumbi.compass.core.logging.Logging;
import java.util.List;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

public class Cardinal {

  public void start(List<CardinalDirectionDTO> routes) {
    Server server = new Server();
    ServerConnector connector = new ServerConnector(server);
    connector.setHost("localhost");
    connector.setPort(8080);

    server.addConnector(connector);

    server.setHandler(new CardinalHandler(routes));

    try {
      server.start();
    } catch (Exception e) {
      ExceptionHandler.handle(e);
    }

    Logging.info("started cardinal");
  }
}
