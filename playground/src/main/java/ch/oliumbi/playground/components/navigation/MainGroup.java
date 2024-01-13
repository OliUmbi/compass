package ch.oliumbi.playground.components.navigation;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.style.State;
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
        new MainLink("Privatkoch", "/privatkoch"),
        new MainLink("Catering", "/catering"),
        new MainLink("Kurse", "/kurse"),
        new MainLink("Über Mich", "/ueber-mich")
    );
  }

  @Override
  protected State xl() {
    return new State()
        .normal(new Style()
            .width("100%"));
  }
}
