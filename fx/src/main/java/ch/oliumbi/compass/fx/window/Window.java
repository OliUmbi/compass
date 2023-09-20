package ch.oliumbi.compass.fx.window;

import ch.oliumbi.compass.core.Compass;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Window {

  public static final Logger LOGGER = LoggerFactory.getLogger(Window.class);

  private Stage stage;

  public void show(Stage stage) {
    this.stage = stage;

    init();

    Parent parent = parent();

    if (parent() == null) {
      try {
        parent = FXMLLoader.load(Compass.resource(fxml()));
      } catch (IOException e) {
        LOGGER.error("Failed to load fxml, path " + fxml(), e);
      }
    }

    stage.setScene(new Scene(parent));
    stage.setTitle(title());
    stage.setWidth(width());
    stage.setMaxWidth(widthMax());
    stage.setMinWidth(widthMin());
    stage.setHeight(height());
    stage.setMaxHeight(heightMax());
    stage.setMinHeight(heightMin());
    stage.setResizable(resizeable());
    stage.setMaximized(maximized());
    stage.setFullScreen(fullscreen());
    stage.setIconified(minimized());
    stage.setAlwaysOnTop(alwaysOnTop());

    stage.show();
  }

  protected void close() {
    stage.close();
  }

  public abstract String title();

  public String fxml() {
    return null;
  }

  public Parent parent() {
    return null;
  }

  public abstract void init();

  public boolean newWindow() {
    return false;
  }

  public double width() {
    return 500.0;
  }

  public double widthMax() {
    return Double.MAX_VALUE;
  }

  public double widthMin() {
    return 0.0;
  }

  public double height() {
    return 500.0;
  }

  public double heightMax() {
    return Double.MAX_VALUE;
  }

  public double heightMin() {
    return 0.0;
  }

  public boolean resizeable() {
    return true;
  }

  public boolean maximized() {
    return false;
  }

  public boolean fullscreen() {
    return false;
  }

  public boolean minimized() {
    return false;
  }

  public boolean alwaysOnTop() {
    return false;
  }
}
