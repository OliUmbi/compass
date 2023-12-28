//package ch.oliumbi.compass.server;
//
//import ch.oliumbi.compass.core.annotations.Autoload;
//import org.eclipse.jetty.server.HttpConnectionFactory;
//import org.eclipse.jetty.server.ServerConnector;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Autoload
//public class Server {
//
//  public static final Logger LOGGER = LoggerFactory.getLogger(Server.class);
//
//  public static void start() {
//
//    try {
//      org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server();
//      server.addConnector(connector(server));
//
//      ServerHandler serverHandler = new ServerHandler();
//      server.setHandler(serverHandler);
//
//      server.start();
//
//      LOGGER.info("Started web server");
//    } catch (Exception e) {
//      LOGGER.error("Failed to start web server", e);
//    }
//  }
//
//  private static ServerConnector connector(org.eclipse.jetty.server.Server server) {
//    ServerConnector serverConnector = new ServerConnector(server);
//    // todo move to config
//    serverConnector.setHost("0.0.0.0");
//    serverConnector.setPort(8080);
//    serverConnector.getConnectionFactories().stream()
//        .filter(connectionFactory -> connectionFactory instanceof HttpConnectionFactory)
//        .forEach(connectionFactory -> ((HttpConnectionFactory) connectionFactory).getHttpConfiguration()
//            .setSendServerVersion(false));
//
//    return serverConnector;
//  }
//}
