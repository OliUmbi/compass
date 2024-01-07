package ch.oliumbi.playground.files;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.core.enums.MimeType;
import ch.oliumbi.compass.core.enums.Status;
import ch.oliumbi.compass.core.resource.Resource;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.server.response.Response;
import ch.oliumbi.compass.server.route.Route;

@Autoload
public class Svg implements Route {

  @Override
  public String path() {
    return "/static/svg/:svg";
  }

  @Override
  public Method method() {
    return Method.READ;
  }

  @Override
  public Response handle(Request request, Response response) {

    String svg = request.getPath().element("svg");

    Resource.loadBytes(STR."static/svg/\{svg}")
        .ifPresentOrElse(file -> {
              response.setStatus(Status.OK);
              response.setType(MimeType.SVG);
              response.setBody(file);
            },
            () -> response.setStatus(Status.ERROR_SERVER));

    return response;
  }
}
