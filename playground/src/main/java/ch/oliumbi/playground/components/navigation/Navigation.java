package ch.oliumbi.playground.components.navigation;

import ch.oliumbi.compass.ui.component.Component;
import java.util.List;

public class Navigation extends Component {

  @Override
  protected String tag() {
    return "nav";
  }

  @Override
  protected List<Component> components() {
    return List.of(
        new Control(true),
        new Drawer()
    );
  }
}
