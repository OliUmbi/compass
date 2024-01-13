package ch.oliumbi.playground.components.navigation;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.script.Script;
import ch.oliumbi.compass.ui.style.State;
import ch.oliumbi.playground.Theme;
import java.util.List;

public class Drawer extends Component {

  @Override
  protected String tag() {
    return "div";
  }

  @Override
  protected List<Component> components() {
    return List.of(
        new Control(false),
        new MainGroup(),
        new SubGroup()
    );
  }

  @Override
  protected Script script() {
    return new Script()
        .event("navigation", """
            if (component.style.right === "") {
              component.style.right = "0%";
            } else {
              component.style.right = "";
            }
            """);
  }

  @Override
  protected State xl() {
    return new State()
        .normal(new Style()
            .position("fixed")
            .top("0")
            .right("-100%")
            .width("40rem")
            .height("100%")
            .background(Theme.white())
            .padding("4rem")
            .flex("column", "nowrap", "space-between", "flex-end"));
  }

  @Override
  protected State l() {
    return new State()
        .normal(new Style()
            .width("36rem"));
  }

  @Override
  protected State m() {
    return new State()
        .normal(new Style()
            .width("32rem")
            .padding("3rem"));
  }

  @Override
  protected State s() {
    return new State()
        .normal(new Style()
            .width("100%")
            .padding("2rem"));
  }

  @Override
  protected State xs() {
    return new State()
        .normal(new Style()
            .padding("1rem"));
  }
}
