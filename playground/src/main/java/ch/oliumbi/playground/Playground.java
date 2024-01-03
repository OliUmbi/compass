package ch.oliumbi.playground;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.core.enums.Language;
import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.core.enums.Status;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.server.response.Response;
import ch.oliumbi.compass.server.route.Route;
import ch.oliumbi.compass.ui.Ui;
import ch.oliumbi.compass.ui.color.Color;
import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.font.Font;
import ch.oliumbi.compass.ui.image.Image;
import ch.oliumbi.compass.ui.manifest.Manifest;
import java.util.Collections;
import java.util.List;

@Autoload
public abstract class Playground extends Ui implements Route {

  protected abstract List<Component> load(Request request);

  @Override
  public Response handle(Request request, Response response) {

    List<Component> components = load(request);

    response.setStatus(Status.OK);
    response.setBody(render(components));

    return response;
  }

  @Override
  public Method method() {
    return Method.READ;
  }

  @Override
  protected Language language() {
    return Language.ENGLISH;
  }

  @Override
  protected String color() {
    return "#000000";
  }

  @Override
  protected Image icon() {
    return new Image();
  }

  @Override
  protected Image image() {
    return new Image();
  }

  @Override
  protected Manifest manifest() {
    return new Manifest();
  }

  @Override
  protected List<Font> fonts() {
    return Collections.emptyList();
  }

  @Override
  protected String url() {
    // todo figure this out
    return "";
  }
}
