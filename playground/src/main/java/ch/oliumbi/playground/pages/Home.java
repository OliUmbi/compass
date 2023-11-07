package ch.oliumbi.playground.pages;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.server.page.component.Component;
import ch.oliumbi.compass.server.page.Page;
import ch.oliumbi.playground.components.Button;
import ch.oliumbi.playground.components.Outline;

@Autoload
public class Home implements Page {

  @Override
  public String path() {
    return "/";
  }

  @Override
  public Component body() {
    return new Outline(
        new Button("Hello World", "red"),
        new Button("Hello Oli", "blue"),
        new Button("Hello Compass", "green")
    );
  }
}
