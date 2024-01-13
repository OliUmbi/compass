package ch.oliumbi.playground.components.typography;

import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.style.State;

public class H4 extends Component {

  private String value;

  public H4(String value) {
    this.value = value;
  }

  @Override
  protected String tag() {
    return "h4";
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
            .fontWeight("500")
            .fontSize("3rem")
            .fontHeight("4.2rem"));
  }

  @Override
  protected State l() {
    return new State()
        .normal(new Style()
            .fontSize("2.5rem")
            .fontHeight("3.5rem"));
  }

  @Override
  protected State m() {
    return new State()
        .normal(new Style()
            .fontSize("2rem")
            .fontHeight("2.8rem"));
  }

  @Override
  protected State s() {
    return new State()
        .normal(new Style()
            .fontSize("1.5rem")
            .fontHeight("2.1rem"));
  }

  @Override
  protected State xs() {
    return new State()
        .normal(new Style()
            .fontSize("1rem")
            .fontHeight("1.4rem"));
  }
}
