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
  public static Class<?> clazz;
  public static String[] args;
  public static Class<? extends Window> first;
  public static Stage stage;

  public static void run(String[] args, Class<?> clazz, Class<? extends Window> first) {
    Fx.clazz = clazz;
    Fx.args = args;
    Fx.first = first;

    launch(args);
  }

  @Override
  public void start(Stage stage) {
    Fx.stage = stage;

    Compass.start(clazz, args);

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

