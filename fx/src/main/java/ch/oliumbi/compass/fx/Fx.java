package ch.oliumbi.compass.fx;

import ch.oliumbi.compass.core.Compass;
import ch.oliumbi.compass.fx.window.Window;
import java.util.List;
import javafx.application.Application;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Fx extends Application {

  public static final Logger LOGGER = LoggerFactory.getLogger(Fx.class);
  public static Stage stage;
  public static Class<? extends Window> first;

  public static void run(String[] args, Class<? extends Window> first) {
    Fx.first = first;

    launch(args);
  }

  @Override
  public void start(Stage stage) {
    Fx.stage = stage;

    open(first);
  }

  public static void open(Class<? extends Window> clazz) {
    List<Window> windows = Compass.instances(Window.class);

    for (Window window : windows) {
      if (clazz.isInstance(window)) {

        Stage currentStage = stage;

        if (window.newWindow()) {
          currentStage = new Stage();
        }

        window.show(currentStage);
      }
    }
  }
}

