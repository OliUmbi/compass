package ch.oliumbi.playground.components;

import ch.oliumbi.compass.ui.component.Component;

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
}
