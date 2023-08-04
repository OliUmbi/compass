package ch.oliumbi.compass.web;

import ch.oliumbi.compass.route.Route;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class WebHandler extends AbstractHandler {

  private final List<Route> routes;

  public WebHandler(List<Route> routes) {
    this.routes = routes;
  }

  @Override
  public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {

    baseRequest.setHandled(true);

    Route route = routes.get(0);

    response.setContentType(route.contentType().translate());

    try {
      Object body = route.handle(request, response);

      response.getOutputStream().print(body.toString());
    } catch (Exception e) {
      e.printStackTrace();
      // todo handle exception
    }
  }
}
