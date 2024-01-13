package ch.oliumbi.compass.ui.script;

public class Listener implements Script {

  private final String event;
  private final String code;

  public Listener(String event, String code) {
    this.event = event;
    this.code = code;
  }

  public String render() {
    return STR."""
          component.addEventListener("\{event}", () => {
            \{code}
          });
          """;
  }
}
