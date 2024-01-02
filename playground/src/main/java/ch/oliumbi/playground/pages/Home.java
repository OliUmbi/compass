package ch.oliumbi.playground.pages;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.server.route.Page;
import ch.oliumbi.compass.server.ui.component.Component;
import ch.oliumbi.playground.components.Button;

@Autoload
public class Home extends Page {

  @Override
  public String path() {
    return "/test/*/yeet/:id";
  }

  @Override
  public Component load(Request request) {
    String value = request.getPath().element("id");

    return new Button(value);
  }
}
