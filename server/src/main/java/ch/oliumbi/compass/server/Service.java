package ch.oliumbi.compass.server;

import ch.oliumbi.compass.core.Compass;
import ch.oliumbi.compass.core.enums.Status;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.server.response.Response;
import ch.oliumbi.compass.server.route.Route;
import java.util.ArrayList;
import java.util.List;

public class Service {

  private final List<Route> routes = new ArrayList<>();

  public Service() {
    routes.addAll(Compass.instances(Route.class));
  }

  public Response handle(Request request) {

    Response response = new Response();
    response.setCookies(request.getCookies());

    for (Route route : routes) {
      request.getPath().setPattern(route.path());

      if (request.getPath().matches()) {
        return route.handle(request, response);
      }
    }

    // todo 404
    response.setStatus(Status.ERROR_USER);

    return response;
  }
}
