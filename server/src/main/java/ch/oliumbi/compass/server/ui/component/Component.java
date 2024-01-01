package ch.oliumbi.compass.server.ui.component;


import ch.oliumbi.compass.server.ui.script.Script;
import ch.oliumbi.compass.server.ui.style.State;

public abstract class Component {

  public abstract String tag();
  public abstract String value();

  public Script script() {
    return null;
  }

  public State xl() {
    return null;
  }

  public State l() {
    return null;
  }

  public State m() {
    return null;
  }

  public State s() {
    return null;
  }

  public State xs() {
    return null;
  }
}
