package ch.oliumbi.playground.components.typography;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.style.State;
import ch.oliumbi.compass.ui.style.Style;

public class S extends Component {

  private String value;

  public S(String value) {
    this.value = value;
  }

  @Override
  protected String tag() {
    return "small";
  }

  @Override
  protected String value() {
    return value;
  }

  @Override
  protected State xl() {
    return new State()
        .normal(new Style()
            .fontFamily("geist")
            .fontWeight("400")
            .fontSize("0.875rem")
            .fontHeight("1.3125rem"));
  }

  @Override
  protected State l() {
    return new State()
        .normal(new Style()
            .fontSize("0.8125rem")
            .fontHeight("1.21875rem"));
  }

  @Override
  protected State m() {
    return new State()
        .normal(new Style()
            .fontSize("0.75rem")
            .fontHeight("1.125rem"));
  }

  @Override
  protected State s() {
    return new State()
        .normal(new Style()
            .fontSize("0.6875rem")
            .fontHeight("1.03125rem"));
  }

  @Override
  protected State xs() {
    return new State()
        .normal(new Style()
            .fontSize("0.625rem")
            .fontHeight("0.9375rem"));
  }
}
