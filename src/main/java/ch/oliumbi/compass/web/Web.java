package ch.oliumbi.compass.web;

import ch.oliumbi.compass.page.Page;
import java.util.List;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

public class Web {

  private final List<Page> pages;

  public Web(List<Page> pages) {
    this.pages = pages;
  }

  public void start() {
    Server server = new Server();

    ServerConnector serverConnector = new ServerConnector(server);
    // todo move to config
    serverConnector.setHost("localhost");
    serverConnector.setPort(8080);
    serverConnector.getConnectionFactories().stream()
        .filter(connectionFactory -> connectionFactory instanceof HttpConnectionFactory)
        .forEach(connectionFactory -> ((HttpConnectionFactory) connectionFactory).getHttpConfiguration()
            .setSendServerVersion(false));

    server.addConnector(serverConnector);

    WebHandler webHandler = new WebHandler(pages);
    server.setHandler(webHandler);

    try {
      server.start();
    } catch (Exception e) {
      e.printStackTrace();
      // todo handle exception
    }

    System.out.println("Started web server");
  }
}
