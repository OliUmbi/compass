package ch.oliumbi.compass.ui.style;

public class State {

  private Style normal;
  private Style hover;
  private Style action;
  private Style focus;
  private Style disabled;
  private Style error;

  public State normal(Style style) {
    normal = style;
    return this;
  }

  public State hover(Style style) {
    hover = style;
    return this;
  }

  public State action(Style style) {
    action = style;
    return this;
  }

  public State focus(Style style) {
    focus = style;
    return this;
  }

  public State disabled(Style style) {
    disabled = style;
    return this;
  }

  public State error(Style style) {
    error = style;
    return this;
  }

  public String render(String id) {

    StringBuilder state = new StringBuilder();

    if (normal != null) {
      state.append(STR . """
          #\{id} {
            transition: 150ms all ease-out;
            \{normal.render()}
          }
          """);
    }

    if (hover != null) {
      state.append(STR . """
          #\{id}:hover {
            \{hover.render()}
          }
          """);
    }

    if (action != null) {
      state.append(STR . """
          #\{id}:active {
            \{action.render()}
          }
          """);
    }

    if (focus != null) {
      state.append(STR . """
          #\{id}:focus-visible {
            \{focus.render()}
          }
          """);
    }

    if (disabled != null) {
      state.append(STR . """
          #\{id}:disabled {
            \{disabled.render()}
          }
          """);
    }

    if (error != null) {
      state.append(STR . """
          #\{id}[data-error=true] {
            \{error.render()}
          }
          """);
    }

    return state.toString();
  }

}
