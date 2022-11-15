package ch.oliumbi.compass;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(new QueuedThreadPool(5, 1, 1000));
        ServerConnector connector = new ServerConnector(server);
        connector.setHost("localhost");
        connector.setPort(8080);

        server.addConnector(connector);

        server.setHandler(new SimpleHandler());

        server.start();
    }
}
