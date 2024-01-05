package ch.oliumbi.compass.ui.component;

import ch.oliumbi.compass.ui.script.Script;
import ch.oliumbi.compass.ui.style.State;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.text.StringEscapeUtils;

public abstract class Component {

  protected String id = hash();

  protected abstract String tag();

  protected List<Component> components() {
    return new ArrayList<>();
  }

  protected String value() {
    return "";
  }

  protected boolean error() {
    return false;
  }

  protected boolean disabled() {
    return false;
  }

  protected Script script() {
    return new Script();
  }

  protected State xl() {
    return new State();
  }

  protected State l() {
    return new State();
  }

  protected State m() {
    return new State();
  }

  protected State s() {
    return new State();
  }

  protected State xs() {
    return new State();
  }

  public Render render() {
    Render render = new Render();

    List<Component> components = components();
    String tag = tag();
    StringBuilder value = new StringBuilder(StringEscapeUtils.escapeHtml4(value()));
    StringBuilder script = new StringBuilder(script().render(id));
    StringBuilder xl = new StringBuilder(xl().render(id));
    StringBuilder l = new StringBuilder(l().render(id));
    StringBuilder m = new StringBuilder(m().render(id));
    StringBuilder s = new StringBuilder(s().render(id));
    StringBuilder xs = new StringBuilder(xs().render(id));

    for (Component component : components) {
      Render child = component.render();

      value.append(child.getValue());
      script.append(child.getScript());
      xl.append(child.getXl());
      l.append(child.getL());
      m.append(child.getM());
      s.append(child.getS());
      xs.append(child.getXs());
    }

    render.setValue(STR."""
    <\{tag} id="\{id}" data-error="\{error()}" \{disabled() ? "disabled" : ""}>\{value.toString()}</\{tag}>
    """);
    render.setScript(script.toString());
    render.setXl(xl.toString());
    render.setL(l.toString());
    render.setM(m.toString());
    render.setS(s.toString());
    render.setXs(xs.toString());

    return render;
  }

  private String hash() {
    Random random = new Random();
    String options = "abcdefghijklmnopqrstuvwxyz";
    StringBuilder hash = new StringBuilder();

    for (int i = 0; i < 8; i++) {
      hash.append(options.charAt(random.nextInt(options.length())));
    }

    return hash.toString();
  }
}
