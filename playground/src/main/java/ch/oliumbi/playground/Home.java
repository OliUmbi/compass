package ch.oliumbi.playground;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.fx.window.Window;

@Autoload
public class Home extends Window {

  @Override
  public String fxml() {
    return "/fxml/home.fxml";
  }

  @Override
  public String title() {
    return "Home";
  }
}
