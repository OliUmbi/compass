package ch.oliumbi.playground.components;

import ch.oliumbi.compass.server.ui.component.Component;
import ch.oliumbi.compass.server.ui.script.Script;
import ch.oliumbi.compass.server.ui.style.State;
import ch.oliumbi.compass.server.ui.style.Style;

public class Button extends Component {

  @Override
  public String tag() {
    return "button";
  }

  public String value() {
    return "hello";
  }

  @Override
  public Script script() {
    return new Script()
        .click("""
            event(menu)
            """);
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
