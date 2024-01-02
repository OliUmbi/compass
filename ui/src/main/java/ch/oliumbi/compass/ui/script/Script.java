package ch.oliumbi.compass.ui.script;

import java.util.ArrayList;
import java.util.List;

public class Script {

  private List<Event> componentEvents = new ArrayList<>();
  private List<Event> customEvents = new ArrayList<>();

  public Script load(String code) {
    componentEvents.add(new Event("load", code));
    return this;
  }

  public Script click(String code) {
    componentEvents.add(new Event("click", code));
    return this;
  }

  public Script event(String name, String code) {
    customEvents.add(new Event(name, code));
    return this;
  }

  public String render(String id) {

    if (componentEvents.isEmpty() && customEvents.isEmpty()) {
      return "";
    }

    StringBuilder script = new StringBuilder(STR."""
        {
          let component = document.getElementById("\{id}")
        """);

    for (Event componentEvent : componentEvents) {
      script.append(STR."""
          component.addEventListener("\{componentEvent.getName()}", () => {
            \{componentEvent.getCode()}
          })
          """);
    }

    for (Event customEvent : customEvents) {
      script.append(STR."""
          listeners.push({
            name: "\{customEvent.getName()}",
            callback: () => {
              \{customEvent.getCode()}
            }
          })
          """);
    }

    script.append("""
        }
        """);

    return script.toString();
  }

  public static void main(String[] args) {
    Script script = new Script()
        .event("meun", """
                if (component.style.right === "") {
                  component.style.right = "0%"
                } else {
                  component.style.right = ""
                }
        """)
        .click("""
            event("sdaf")
            """);

    System.out.println(script.render("test-icon"));
  }
}
