package ch.oliumbi.compass.server.route;

import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.server.response.Response;

public interface Route {

  String path();
  Method method();
  Response handle(Request request, Response response);
}
