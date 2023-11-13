package ch.oliumbi.compass.server.request;

import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.server.path.Path;

public interface RequestTarget {

  Path path();
  Method method();
  Response handle(Request);
}
