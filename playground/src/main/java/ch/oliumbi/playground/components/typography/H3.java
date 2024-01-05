package ch.oliumbi.playground.components.typography;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.style.State;
import ch.oliumbi.compass.ui.style.Style;

public class H3 extends Component {

  private String value;

  public H3(String value) {
    this.value = value;
  }

  @Override
  protected String tag() {
    return "h3";
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
            .fontWeight("600")
            .fontSize("3.5rem")
            .fontHeight("4.55rem"));
  }

  @Override
  protected State l() {
    return new State()
        .normal(new Style()
            .fontSize("3rem")
            .fontHeight("3.9rem"));
  }

  @Override
  protected State m() {
    return new State()
        .normal(new Style()
            .fontSize("2.5rem")
            .fontHeight("3.25rem"));
  }

  @Override
  protected State s() {
    return new State()
        .normal(new Style()
            .fontSize("2rem")
            .fontHeight("2.6rem"));
  }

  @Override
  protected State xs() {
    return new State()
        .normal(new Style()
            .fontSize("1.5rem")
            .fontHeight("1.95rem"));
  }
}
