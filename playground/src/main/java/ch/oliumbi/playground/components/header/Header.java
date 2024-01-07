package ch.oliumbi.playground.components.header;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.style.State;
import ch.oliumbi.compass.ui.style.Style;
import ch.oliumbi.playground.components.image.Img;
import ch.oliumbi.playground.components.navigation.Control;
import ch.oliumbi.playground.components.navigation.Navigation;
import java.util.List;

public class Header extends Component {

  @Override
  protected String tag() {
    return "header";
  }

  @Override
  protected List<Component> components() {
    return List.of(
        new Logo(),
        new Navigation()
    );
  }

  @Override
  protected State xl() {
    return new State()
        .normal(new Style()
            .padding("1rem")
            .flex("row", "nowrap", "space-between", "center"));
  }
}
