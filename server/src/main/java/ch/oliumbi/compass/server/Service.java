package ch.oliumbi.compass.server;

import ch.oliumbi.compass.core.Compass;
import ch.oliumbi.compass.core.enums.MimeType;
import ch.oliumbi.compass.core.enums.Status;
import ch.oliumbi.compass.server.header.Header;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.server.response.Response;
import ch.oliumbi.compass.server.route.Route;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {

  private final List<Route> routes = new ArrayList<>();

  public Service() {
    routes.addAll(Compass.instances(Route.class));
  }

  public Response handle(Request request) {

    Response response = new Response();
    response.setCookies(request.getCookies());
    response.setHeaders(Collections.emptyList());

    for (Route route : routes) {
      request.getPath().setPattern(route.path());

      if (request.getPath().matches()) {
        Response handle = route.handle(request, response);

        if (handle.getStatus() == null) {
          handle.setStatus(Status.OK);
        }
        if (handle.getType() == null) {
          handle.setType(MimeType.PLAIN);
        }

        return handle;
      }
    }

    // todo 404
    response.setStatus(Status.ERROR_USER);

    return response;
  }
}
