package ch.oliumbi.compass.server.route;

import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.core.enums.Status;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.server.response.Response;
import ch.oliumbi.compass.server.ui.component.Component;
import ch.oliumbi.compass.server.ui.enums.Language;

public abstract class Page implements Route {

  protected abstract Component load(Request request);

  @Override
  public Method method() {
    return Method.READ;
  }

  @Override
  public Response handle(Request request, Response response) {
    response.setStatus(Status.OK);
    response.setBody(STR."""
        <head>
          <meta charset="\{Language.ENGLISH.render()}">
          <title>Test</title>
        </head>
        <body>
          \{load(request).render()}
        </body>
        """);
    return response;
  }
}
