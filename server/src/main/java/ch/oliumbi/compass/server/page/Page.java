package ch.oliumbi.compass.server.page;

import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.server.html.Html;
import ch.oliumbi.compass.server.path.Path;
import ch.oliumbi.compass.server.request.RequestTarget;

public abstract class Page extends Html implements RequestTarget {



  @Override
  public Method method() {
    return Method.GET;
  }
}
