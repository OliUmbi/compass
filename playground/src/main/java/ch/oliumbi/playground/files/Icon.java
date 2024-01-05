package ch.oliumbi.playground.files;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.core.enums.Status;
import ch.oliumbi.compass.core.resource.Resource;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.server.response.Response;
import ch.oliumbi.compass.server.route.Route;

@Autoload
public class Icon implements Route {

  @Override
  public String path() {
    return "/icon.png";
  }

  @Override
  public Method method() {
    return Method.READ;
  }

  @Override
  public Response handle(Request request, Response response) {

    Resource.loadBytes("static/images/icon.png")
        .ifPresentOrElse(icon -> {
              response.setStatus(Status.OK);
              response.setBody(icon);
            },
            () -> response.setStatus(Status.ERROR_SERVER));

    return response;
  }
}
