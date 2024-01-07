package ch.oliumbi.playground.components.navigation;

import ch.oliumbi.compass.ui.attribute.Attribute;
import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.style.State;
import ch.oliumbi.compass.ui.style.Style;
import ch.oliumbi.playground.Theme;
import ch.oliumbi.playground.components.typography.H1;
import ch.oliumbi.playground.components.typography.H4;
import ch.oliumbi.playground.components.typography.P;
import java.util.List;

public class SubLink extends Component {

  private final String name;
  private final String url;

  public SubLink(String name, String url) {
    this.name = name;
    this.url = url;
  }

  @Override
  protected String tag() {
    return "a";
  }

  @Override
  protected List<Component> components() {
    return List.of(
        new P(name)
    );
  }

  @Override
  protected List<Attribute> attributes() {
    return List.of(
        new Attribute("href", url)
    );
  }

  @Override
  protected State xl() {
    return new State()
        .normal(new Style()
            .width("100%")
            .fontColor(Theme.blackLight())
            .fontDecoration("none"))
        .hover(new Style()
            .fontColor(Theme.primary()));
  }
}
