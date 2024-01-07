package ch.oliumbi.playground;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.core.enums.MimeType;
import ch.oliumbi.compass.core.enums.Status;
import ch.oliumbi.compass.core.json.Json;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.server.response.Response;
import ch.oliumbi.compass.server.route.Route;
import ch.oliumbi.compass.ui.manifest.Category;
import ch.oliumbi.compass.ui.manifest.Display;
import ch.oliumbi.compass.ui.manifest.Icon;
import ch.oliumbi.compass.ui.manifest.Manifest;
import ch.oliumbi.compass.ui.manifest.Orientation;
import ch.oliumbi.compass.ui.manifest.ShareTarget;
import ch.oliumbi.compass.ui.manifest.Shortcut;
import java.util.ArrayList;
import java.util.List;

@Autoload
public class PWA implements Route {

  @Override
  public String path() {
    return "/manifest.json";
  }

  @Override
  public Method method() {
    return Method.READ;
  }

  @Override
  public Response handle(Request request, Response response) {

    Manifest manifest = new Manifest();
    manifest.setName("Uncle-T | Privatkoch & Catering");
    manifest.setShort_name("Uncle-T");
    manifest.setDescription("Mit Uncle-T erleben Sie exzellente Privatkoch- und Catering-Services für jeden Anlass.");
    manifest.setBackground_color("#000000");
    manifest.setTheme_color("#3d4a5c");
    manifest.setDisplay(Display.STANDALONE);
    manifest.setIcons(List.of(new Icon("/icon.png", "32x32", MimeType.PNG)));
    manifest.setStart_url("/");
    manifest.setScreenshots(List.of());
    manifest.setShortcuts(List.of(
        new Shortcut("Privatkoch", "Privatkoch", "Planen Sie Ihre private Veranstaltung noch heute", "/privatkoch", List.of(new Icon("/icon.png", "32x32", MimeType.PNG))),
        new Shortcut("Catering", "Catering", "Unvergessliches Catering für jeden Anlass", "/catering", List.of(new Icon("/icon.png", "32x32", MimeType.PNG))),
        new Shortcut("Kurse", "Kurse", "Erlernen Sie neue Fähigkeiten bei unseren Kursen", "/kurse", List.of(new Icon("/icon.png", "32x32", MimeType.PNG)))
    ));
    manifest.setCategories(List.of(Category.FOOD, Category.HEALTH, Category.LIFESTYLE));
    manifest.setShare_target(null);
    manifest.setScope("/");
    manifest.setOrientation(Orientation.ANY);

    Json.convert(manifest)
        .ifPresentOrElse(
            json -> {
              response.setStatus(Status.OK);
              response.setType(MimeType.JSON);
              response.setBody(json.getBytes());
            },
            () -> {
              response.setStatus(Status.ERROR_SERVER);
            }
        );

    return response;
  }
}
