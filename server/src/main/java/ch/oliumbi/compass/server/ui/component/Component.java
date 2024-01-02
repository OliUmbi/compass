package ch.oliumbi.compass.server.ui.component;


import ch.oliumbi.compass.server.ui.script.Script;
import ch.oliumbi.compass.server.ui.style.State;

public abstract class Component {

  public String render() {
    return STR."<\{tag()}>\{value()}</\{tag()}>";
  }

  protected abstract String tag();
  protected abstract String value();

  protected Script script() {
    return null;
  }

  protected State xl() {
    return null;
  }

  protected State l() {
    return null;
  }

  protected State m() {
    return null;
  }

  protected State s() {
    return null;
  }

  protected State xs() {
    return null;
  }
}
