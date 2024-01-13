package ch.oliumbi.compass.ui.script;

public class Custom implements Script {

  private final String event;
  private final String code;

  public Custom(String event, String code) {
    this.event = event;
    this.code = code;
  }

  public String render() {
    return STR."""
        listeners.push({
          name: "\{event}",
          callback: () => {
            \{code}
          }
        });
        """;
  }
}
