package ch.oliumbi.playground;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.fx.Fx;
import ch.oliumbi.compass.fx.window.Window;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

@Autoload
public class Home extends Window {

  @FXML
  private Button next;

  @Override
  public String title() {
    return "Home";
  }

  @Override
  public String fxml() {
    return "/fxml/home.fxml";
  }

  @Override
  public void init() {

  }

  public void test(ActionEvent actionEvent) {
    Fx.open(Test.class);
  }
}
