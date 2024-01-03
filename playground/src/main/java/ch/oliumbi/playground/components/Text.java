package ch.oliumbi.playground.components;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.style.State;
import ch.oliumbi.compass.ui.style.Style;

public class Text extends Component {

  private final String tag;
  private final String value;

  public Text(String tag, String value) {
    this.tag = tag;
    this.value = value;
  }

  @Override
  protected String tag() {
    return tag;
  }

  @Override
  protected String value() {
    return value;
  }

  @Override
  protected State xl() {
    return new State()
        .fade(
            new Style().opacity("0"),
            new Style().opacity("1")
        );
  }
}
