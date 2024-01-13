package ch.oliumbi.compass.ui.component;

import ch.oliumbi.compass.ui.attribute.Attribute;
import ch.oliumbi.compass.ui.script.Script;
import ch.oliumbi.compass.ui.style.Style;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
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

  protected List<Attribute> attributes() {
    return Collections.emptyList();
  }

  protected boolean error() {
    return false;
  }

  protected boolean disabled() {
    return false;
  }

  protected List<Script> scripts() {
    return Collections.emptyList();
  }

  protected List<Style> xl() {
    return Collections.emptyList();
  }

  protected List<Style> xlHover() {
    return Collections.emptyList();
  }

  protected List<Style> xlAction() {
    return Collections.emptyList();
  }

  protected List<Style> xlFocus() {
    return Collections.emptyList();
  }

  protected List<Style> xlDisabled() {
    return Collections.emptyList();
  }

  protected List<Style> xlError() {
    return Collections.emptyList();
  }

  protected List<Style> xlFadeFrom() {
    return Collections.emptyList();
  }

  protected List<Style> xlFadeTo() {
    return Collections.emptyList();
  }

  protected List<Style> l() {
    return Collections.emptyList();
  }

  protected List<Style> lHover() {
    return Collections.emptyList();
  }

  protected List<Style> lAction() {
    return Collections.emptyList();
  }

  protected List<Style> lFocus() {
    return Collections.emptyList();
  }

  protected List<Style> lDisabled() {
    return Collections.emptyList();
  }

  protected List<Style> lError() {
    return Collections.emptyList();
  }

  protected List<Style> lFadeFrom() {
    return Collections.emptyList();
  }

  protected List<Style> lFadeTo() {
    return Collections.emptyList();
  }

  protected List<Style> m() {
    return Collections.emptyList();
  }

  protected List<Style> mHover() {
    return Collections.emptyList();
  }

  protected List<Style> mAction() {
    return Collections.emptyList();
  }

  protected List<Style> mFocus() {
    return Collections.emptyList();
  }

  protected List<Style> mDisabled() {
    return Collections.emptyList();
  }

  protected List<Style> mError() {
    return Collections.emptyList();
  }

  protected List<Style> mFadeFrom() {
    return Collections.emptyList();
  }

  protected List<Style> mFadeTo() {
    return Collections.emptyList();
  }

  protected List<Style> s() {
    return Collections.emptyList();
  }

  protected List<Style> sHover() {
    return Collections.emptyList();
  }

  protected List<Style> sAction() {
    return Collections.emptyList();
  }

  protected List<Style> sFocus() {
    return Collections.emptyList();
  }

  protected List<Style> sDisabled() {
    return Collections.emptyList();
  }

  protected List<Style> sError() {
    return Collections.emptyList();
  }

  protected List<Style> sFadeFrom() {
    return Collections.emptyList();
  }

  protected List<Style> sFadeTo() {
    return Collections.emptyList();
  }

  protected List<Style> xs() {
    return Collections.emptyList();
  }

  protected List<Style> xsHover() {
    return Collections.emptyList();
  }

  protected List<Style> xsAction() {
    return Collections.emptyList();
  }

  protected List<Style> xsFocus() {
    return Collections.emptyList();
  }

  protected List<Style> xsDisabled() {
    return Collections.emptyList();
  }

  protected List<Style> xsError() {
    return Collections.emptyList();
  }

  protected List<Style> xsFadeFrom() {
    return Collections.emptyList();
  }

  protected List<Style> xsFadeTo() {
    return Collections.emptyList();
  }

  public String renderScript(String id) {

    if (scripts().isEmpty()) {
      return "";
    }

    StringBuilder render = new StringBuilder(STR."""
        {
          let component = document.getElementById("\{id}");
        """);

    for (Script script : scripts()) {
      render.append(script.render());
    }

    render.append("""
        }
        """);

    return render.toString();
  }

  public String renderStyle(String id, List<Style> normal, List<Style> hover, List<Style> action, List<Style> focus, List<Style> disabled, List<Style> error, List<Style> fadeFrom, List<Style> fadeTo) {

    StringBuilder render = new StringBuilder();

    if (!normal.isEmpty()) {
      render.append(STR . """
          #\{id} {
            transition: 150ms all ease-out;
            \{normal.stream().map(Style::render).collect(Collectors.joining())}
          }
          """);
    }

    if (!hover.isEmpty()) {
      render.append(STR . """
          #\{id}:hover {
            \{hover.stream().map(Style::render).collect(Collectors.joining())}
          }
          """);
    }

    if (!action.isEmpty()) {
      render.append(STR . """
          #\{id}:active {
            \{action.stream().map(Style::render).collect(Collectors.joining())}
          }
          """);
    }

    if (!focus.isEmpty()) {
      render.append(STR . """
          #\{id}:focus-visible {
            \{focus.stream().map(Style::render).collect(Collectors.joining())}
          }
          """);
    }

    if (!disabled.isEmpty()) {
      render.append(STR . """
          #\{id}:disabled {
            \{disabled.stream().map(Style::render).collect(Collectors.joining())}
          }
          """);
    }

    if (!error.isEmpty()) {
      render.append(STR . """
          #\{id}[data-error=true] {
            \{error.stream().map(Style::render).collect(Collectors.joining())}
          }
          """);
    }

    if (!fadeFrom.isEmpty() && !fadeTo.isEmpty()) {
      render.append(STR . """
          #\{id} {
            animation: \{id} linear both;
            animation-timeline: view();
            animation-range: entry 50% cover 50%;
          }

          @keyframes \{id} {
            from {
              \{fadeFrom.stream().map(Style::render).collect(Collectors.joining())}
            }
            to {
              \{fadeTo.stream().map(Style::render).collect(Collectors.joining())}
            }
          }
          """);
    }

    return render.toString();
  }

  public Render render() {
    Render render = new Render();

    List<Component> components = components();
    String tag = tag();
    StringBuilder value = new StringBuilder(StringEscapeUtils.escapeHtml4(value()));
    String attributes = attributes().stream().map(Attribute::render).collect(Collectors.joining(" "));
    StringBuilder script = new StringBuilder(renderScript(id));
    StringBuilder xl = new StringBuilder(renderStyle(id, xl(), xlHover(), xlAction(), xlFocus(), xlDisabled(), xlError(), xlFadeFrom(), xlFadeTo()));
    StringBuilder l = new StringBuilder(renderStyle(id, l(), lHover(), lAction(), lFocus(), lDisabled(), lError(), lFadeFrom(), lFadeTo()));
    StringBuilder m = new StringBuilder(renderStyle(id, m(), mHover(), mAction(), mFocus(), mDisabled(), mError(), mFadeFrom(), mFadeTo()));
    StringBuilder s = new StringBuilder(renderStyle(id, s(), sHover(), sAction(), sFocus(), sDisabled(), sError(), sFadeFrom(), sFadeTo()));
    StringBuilder xs = new StringBuilder(renderStyle(id, xs(), xsHover(), xsAction(), xsFocus(), xsDisabled(), xsError(), xsFadeFrom(), xsFadeTo()));

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
    <\{tag} id="\{id}" data-error="\{error()}" \{disabled() ? "disabled" : ""} \{attributes}>\{value.toString()}</\{tag}>
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
