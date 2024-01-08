package ch.oliumbi.playground.pages;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.playground.UncleT;
import ch.oliumbi.playground.components.section.Section;
import ch.oliumbi.playground.components.typography.H1;
import java.util.List;

@Autoload
public class Contact extends UncleT {

  @Override
  protected List<Component> load(Request request) {
    return List.of(
        new Section(
            new H1("Kontakt")
        )
    );
  }

  @Override
  public String path() {
    return "/kontakt";
  }

  @Override
  protected String title() {
    return "Uncle-T - Kontakt";
  }

  @Override
  protected String description() {
    return "Uncle-T Kontakt";
  }
}
