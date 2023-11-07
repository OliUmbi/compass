package ch.oliumbi.compass.server.page;

import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.server.page.component.Component;
import ch.oliumbi.compass.server.request.RequestTarget;

public abstract class Page implements RequestTarget {

  protected abstract Component body();

  @Override
  public Method method() {
    return Method.GET;
  }
}
