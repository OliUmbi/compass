package ch.oliumbi.playground;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.fx.grid.Grid;
import ch.oliumbi.compass.fx.window.Window;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

@Autoload
public class Test extends Window {

  @FXML
  private Label title = new Label();

  @FXML
  private Label subtitle = new Label();

  @Override
  public String title() {
    return "Test";
  }

  @Override
  public Parent parent() {
    Grid grid = new Grid();
    grid.columns(3);
    grid.rows(2);
    grid.add(title, 0, 3);
    grid.add(subtitle, 1, 1);

    return grid;
  }

  @Override
  public void init() {
    title.setText("Title");
    title.setPrefSize(50, 50);
    title.setMinSize(50, 50);
    title.setMaxSize(50, 50);
    subtitle.setText("Subtitle");

  }
}
