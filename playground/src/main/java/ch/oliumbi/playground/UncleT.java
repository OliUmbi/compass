package ch.oliumbi.playground;

import ch.oliumbi.compass.core.annotations.Autoload;
import ch.oliumbi.compass.core.enums.Language;
import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.core.enums.MimeType;
import ch.oliumbi.compass.core.enums.Status;
import ch.oliumbi.compass.server.request.Request;
import ch.oliumbi.compass.server.response.Response;
import ch.oliumbi.compass.server.route.Route;
import ch.oliumbi.compass.ui.Ui;
import ch.oliumbi.compass.ui.component.Component;
import ch.oliumbi.compass.ui.font.Font;
import ch.oliumbi.playground.components.header.Header;
import java.util.ArrayList;
import java.util.List;

@Autoload
public abstract class UncleT extends Ui implements Route {

  protected abstract List<Component> load(Request request);

  @Override
  public Response handle(Request request, Response response) {
    List<Component> components = new ArrayList<>();
    components.add(new Header());
    components.addAll(load(request));

    String render = render(components);

    response.setStatus(Status.OK);
    response.setType(MimeType.HTML);
    response.setBody(render.getBytes());

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
  protected String theme() {
    return Theme.primary();
  }

  @Override
  protected String foreground() {
    return Theme.blackDark();
  }

  @Override
  protected String background() {
    return Theme.whiteLight();
  }

  @Override
  protected String icon() {
    return "/static/png/icon.png";
  }

  @Override
  protected String iconType() {
    return "image/png";
  }

  @Override
  protected String image() {
    return "/static/png/icon.png";
  }

  @Override
  protected String manifest() {
    return "/manifest.json";
  }

  @Override
  protected List<Font> fonts() {
    return List.of(
        new Font("geist", "/static/woff/geist.woff2", "woff2")
    );
  }

  @Override
  protected String url() {
    // todo figure this out
    return "https://uncle-t.ch";
  }
}
