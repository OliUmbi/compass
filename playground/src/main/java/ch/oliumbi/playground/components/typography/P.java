package ch.oliumbi.playground.components.typography;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.style.State;

public class P extends Component {

  private String value;

  public P(String value) {
    this.value = value;
  }

  @Override
  protected String tag() {
    return "p";
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
            .fontSize("1.125rem")
            .fontHeight("1.6875rem"));
  }

  @Override
  protected State l() {
    return new State()
        .normal(new Style()
            .fontSize("1.0625rem")
            .fontHeight("1.59375rem"));
  }

  @Override
  protected State m() {
    return new State()
        .normal(new Style()
            .fontSize("1rem")
            .fontHeight("1.5rem"));
  }

  @Override
  protected State s() {
    return new State()
        .normal(new Style()
            .fontSize("0.9375rem")
            .fontHeight("1.40625rem"));
  }

  @Override
  protected State xs() {
    return new State()
        .normal(new Style()
            .fontSize("0.875rem")
            .fontHeight("1.3125rem"));
  }
}
