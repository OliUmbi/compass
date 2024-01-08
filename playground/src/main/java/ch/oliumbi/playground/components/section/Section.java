package ch.oliumbi.playground.components.section;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.style.State;
import ch.oliumbi.compass.ui.style.Style;
import ch.oliumbi.playground.Theme;
import java.util.List;

public class Section extends Component {

  private final List<Component> components;

  public Section(Component... components) {
    this.components = List.of(components);
  }

  @Override
  protected String tag() {
    return "section";
  }

  @Override
  protected List<Component> components() {
    return components;
  }

  @Override
  protected State xl() {
    return new State()
        .normal(new Style()
            .padding("6rem 5rem")
            .widthMax(Theme.xl())
            .margin("auto"));
  }

  @Override
  protected State l() {
    return new State()
        .normal(new Style()
            .padding("5rem 4rem"));
  }

  @Override
  protected State m() {
    return new State()
        .normal(new Style()
            .padding("4rem 3rem"));
  }

  @Override
  protected State s() {
    return new State()
        .normal(new Style()
            .padding("3rem 2rem"));
  }

  @Override
  protected State xs() {
    return new State()
        .normal(new Style()
            .padding("2rem 1rem"));
  }
}
