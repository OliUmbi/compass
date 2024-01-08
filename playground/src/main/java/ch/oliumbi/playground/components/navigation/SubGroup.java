package ch.oliumbi.playground.components.navigation;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.style.State;
import ch.oliumbi.compass.ui.style.Style;
import java.util.List;

public class SubGroup extends Component {

  @Override
  protected String tag() {
    return "div";
  }

  @Override
  protected List<Component> components() {
    return List.of(
        new SubLink("Kontakt", "/kontakt"),
        new SubLink("Geschäftsbedingung", "/allgemeine-geschäftsbedingung"),
        new SubLink("Datenschutz", "/datenschutz"),
        new SubLink("Impressum", "/impressum")
    );
  }

  @Override
  protected State xl() {
    return new State()
        .normal(new Style()
            .width("100%"));
  }
}
