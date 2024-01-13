package ch.oliumbi.playground.components.header;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.style.State;
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
            .padding("5rem")
            .flex("row", "nowrap", "space-between", "center"));
  }

  @Override
  protected State l() {
    return new State()
        .normal(new Style()
            .padding("4rem"));
  }

  @Override
  protected State m() {
    return new State()
        .normal(new Style()
            .padding("3rem"));
  }

  @Override
  protected State s() {
    return new State()
        .normal(new Style()
            .padding("2rem"));
  }

  @Override
  protected State xs() {
    return new State()
        .normal(new Style()
            .padding("1rem"));
  }
}
