package ch.oliumbi.compass.server.html.script;

import java.util.ArrayList;
import java.util.List;

public class Script {

  private List<Event> events = new ArrayList<>();

  public Script load(String code) {
    click = code;
    return this;
  }

  public Script click(String code) {
    click = code;
    return this;
  }

  public Script event(String name, String code) {
    events.add(new Event(name, code));
    return this;
  }
}
