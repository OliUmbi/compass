package ch.oliumbi.compass.server.route;

import ch.oliumbi.compass.server.request.RequestTarget;

public interface Route<T> extends RequestTarget {

  Class<T> mapping();
  Object handle(T body) throws Exception;
}
