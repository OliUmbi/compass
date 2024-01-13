package ch.oliumbi.playground.components.typography;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.style.State;

public class H1 extends Component {

  private String value;

  public H1(String value) {
    this.value = value;
  }

  @Override
  protected String tag() {
    return "h1";
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
            .fontWeight("800")
            .fontSize("4.5rem")
            .fontHeight("4.95rem"));
  }

  @Override
  protected State l() {
    return new State()
        .normal(new Style()
            .fontSize("4rem")
            .fontHeight("4.4rem"));
  }

  @Override
  protected State m() {
    return new State()
        .normal(new Style()
            .fontSize("3.5rem")
            .fontHeight("3.85rem"));
  }

  @Override
  protected State s() {
    return new State()
        .normal(new Style()
            .fontSize("3rem")
            .fontHeight("3.3rem"));
  }

  @Override
  protected State xs() {
    return new State()
        .normal(new Style()
            .fontSize("2.5rem")
            .fontHeight("2.75rem"));
  }
}
