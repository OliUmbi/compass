package ch.oliumbi.playground.pages;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.playground.UncleT;
import ch.oliumbi.playground.components.section.Section;
import ch.oliumbi.playground.components.typography.H1;
import ch.oliumbi.playground.components.typography.H3;
import ch.oliumbi.playground.components.typography.P;
import java.util.List;

@Autoload
public class Legal extends UncleT {

  @Override
  protected List<Component> load(Request request) {
    return List.of(
        new Section(
            new H3("Impressum"),
            new P("Verantwortlich für den Inhalt der Seiten"),
            new P("Uncle-T GmbH"),
            new P("Thomas Habegger"),
            new P("Zelgliweg 2"),
            new P("5506 Mägenwil"),
            new P("info@uncle-t.ch")
        ),
        new Section(
            new H3("Copyright"),
            new P("Das Copyright für sämtliche Inhalte dieser Website liegt bei Uncle-T GmbH Thomas Habegger.")
        ),
        new Section(
            new H3("Disclaimer"),
            new P("Alle Texte und Links wurden sorgfältig geprüft und werden laufend aktualisiert. Wir sind bemüht, richtige und vollständige Informationen auf dieser Website bereitzustellen, übernehmen aber keinerlei Verantwortung, Garantien oder Haftung dafür, dass die durch diese Website bereitgestellten Informationen, einschliesslich jeglicher Datenbankeinträge, richtig, vollständig oder aktuell sind. Wir behalten uns das Recht vor, jederzeit und ohne Vorankündigung die Informationen auf dieser Website zu ändern und verpflichten uns auch nicht, die enthaltenen Informationen zu aktualisieren. Alle Links zu externen Anbietern wurden zum Zeitpunkt ihrer Aufnahme auf ihre Richtigkeit überprüft. Dennoch haften wir nicht für Inhalte und Verfügbarkeit von Websites, die mittels Hyperlinks zu erreichen sind. Für illegale, fehlerhafte oder unvollständige Inhalte und insbesondere für Schäden, die durch die ungeprüfte Nutzung von Inhalten verknüpfter Seiten entstehen, haftet allein der Anbieter der Seite, auf welche verwiesen wurde. Dabei ist es gleichgültig, ob der Schaden direkter, indirekter oder finanzieller Natur ist oder ein sonstiger Schaden vorliegt, der sich aus Datenverlust, Nutzungsausfall oder anderen Gründen aller Art ergeben könnte.\n")
        )
    );
  }

  @Override
  public String path() {
    return "/impressum";
  }

  @Override
  protected String title() {
    return "Uncle-T - Impressum";
  }

  @Override
  protected String description() {
    return "Uncle-T Impressum";
  }
}
