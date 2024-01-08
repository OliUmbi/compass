package ch.oliumbi.playground.pages;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.playground.UncleT;
import ch.oliumbi.playground.components.section.Section;
import ch.oliumbi.playground.components.typography.H1;
import ch.oliumbi.playground.components.typography.P;
import ch.oliumbi.playground.components.typography.Small;
import java.util.List;

@Autoload
public class Business extends UncleT {

  @Override
  protected List<Component> load(Request request) {
    return List.of(
        new Section(
            new H1("Allgemeine Geschäftsbedingung")
        ),
        new Section(
            new P("Der Kunde überträgt das Catering gemäss Detail-Offerten an die Uncle-T GmbH."),
            new Small("1"),
            new P("Die oben genannten Preise verstehen sich als absolute Richtwerte. Verrechnet wird nach effektivem Aufwand."),
            new Small("2"),
            new P("Der Kunde muss dem Caterer eine Änderung der Personenzahl spätestens 4 Tage vor Anlassbeginn in schriftlicher Form mitteilen. Spätere Änderungen können nicht mehr garantiert werden. Die vom Kunden bekannt gegebene Teilnehmerzahl ist verbindlich. Zusätzliche Personen stellt der Caterer dem Kunden nachträglich in Rechnung. Leistungen für nachträglich noch wegfallende Teilnehmer werden dem Kunden in Rechnung gestellt.")
        )
    );
  }

  @Override
  public String path() {
    return "/allgemeine-geschäftsbedingung";
  }

  @Override
  protected String title() {
    return "Uncle-T - Allgemeine Geschäftsbedingung";
  }

  @Override
  protected String description() {
    return "Uncle-T Allgemeine Geschäftsbedingung";
  }
}
