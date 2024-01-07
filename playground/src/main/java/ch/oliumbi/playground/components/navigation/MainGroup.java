package ch.oliumbi.playground.components.navigation;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.style.State;
import ch.oliumbi.compass.ui.style.Style;
import java.util.List;

public class MainGroup extends Component {

  @Override
  protected String tag() {
    return "div";
  }

  @Override
  protected List<Component> components() {
    return List.of(
        new MainLink("Home", "/"),
        new MainLink("Privatkoch", "/"),
        new MainLink("Catering", "/"),
        new MainLink("Kurse", "/"),
        new MainLink("Über uns ", "/")
    );
  }

  @Override
  protected State xl() {
    return new State()
        .normal(new Style()
            .width("100%"));
  }
}
