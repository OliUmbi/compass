package ch.oliumbi.playground.components.navigation;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.script.Script;
import ch.oliumbi.compass.ui.style.State;
import ch.oliumbi.compass.ui.style.Style;
import ch.oliumbi.playground.Theme;
import ch.oliumbi.playground.components.base.Icon;
import java.util.List;

public class Control extends Component {

  private final boolean open;

  public Control(boolean open) {
    this.open = open;
  }

  @Override
  protected String tag() {
    return "button";
  }

  @Override
  protected List<Component> components() {

    if (open) {
      return List.of(Icon.menu());
    } else {
      return List.of(Icon.close());
    }
  }

  @Override
  protected Script script() {
    return new Script()
        .click("""
            event("navigation")
            """);
  }

  @Override
  protected State xl() {
    return new State()
        .normal(new Style()
            .padding("0.5rem")
            .border("none")
            .background(Theme.white()))
        .hover(new Style()
            .background(Theme.whiteDark()))
        .focus(new Style()
            .outline(Theme.outline()))
        .action(new Style()
            .background(Theme.primary()));
  }
}
