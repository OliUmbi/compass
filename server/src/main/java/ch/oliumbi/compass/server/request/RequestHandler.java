package ch.oliumbi.compass.server.request;

import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.server.path.Path;

public interface RequestHandler {

  boolean interested(Path path);
  String handle(Path path, Method method, String body);
}
