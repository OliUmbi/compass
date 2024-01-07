package ch.oliumbi.playground.components.base;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.script.Script;
import ch.oliumbi.compass.ui.style.State;
import ch.oliumbi.compass.ui.style.Style;
import ch.oliumbi.playground.components.typography.P;
import java.util.List;

public class Button extends Component {

  private String value;

  public Button(String value) {
    this.value = value;
  }

  @Override
  public String tag() {
    return "button";
  }

  @Override
  protected List<Component> components() {
    return List.of(
        new P(value)
    );
  }

  @Override
  public State xl() {
    return new State()
        .normal(new Style()
            .background("lightgrey")
            .border("none")
            .padding("1rem 2rem")
            .radius("0.5rem"))
        .hover(new Style()
            .background("red"))
        .action(new Style()
            .background("blue"))
        .focus(new Style()
            .outline("0.5rem purple solid"))
        .disabled(new Style()
            .background("green")
            .opacity("0.5"))
        .error(new Style()
            .background("red"));
  }
}
