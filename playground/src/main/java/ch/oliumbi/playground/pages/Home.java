package ch.oliumbi.playground.pages;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.playground.Playground;
import ch.oliumbi.playground.components.Button;
import java.util.List;

@Autoload
public class Home extends Playground {

  @Override
  protected List<Component> load(Request request) {
    return List.of(
        new Button("World!")
    );
  }

  @Override
  public String path() {
    return "/";
  }

  @Override
  protected String title() {
    return "Plygrnd";
  }

  @Override
  protected String description() {
    return "Playground";
  }
}
