package ch.oliumbi.compass.core;

import ch.oliumbi.compass.core.toml.Toml;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

public class Compass {

    public static void start() throws Exception {
        Toml toml = new Toml();

        toml.parse();

        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setHost("localhost");
        connector.setPort(8080);

        server.addConnector(connector);

        server.setHandler(new ServerHandler());

        server.start();
    }
}
