package ch.oliumbi.compass.server.route;

import ch.oliumbi.compass.core.enums.Method;

public interface Route<T> {

  String path();
  Method method();
  Class<T> mapping();

  Object handle(T body, String ip) throws Exception;
}
