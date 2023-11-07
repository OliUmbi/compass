package ch.oliumbi.compass.server.page;

import ch.oliumbi.compass.core.Compass;
import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.server.path.Path;
import ch.oliumbi.compass.server.request.RequestHandler;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageHandler implements RequestHandler {

  public static final Logger LOGGER = LoggerFactory.getLogger(PageHandler.class);

  private final List<Page> pages = new ArrayList<>();

  public PageHandler() {
    pages.addAll(Compass.instances(Page.class));
  }

  @Override
  public boolean interested(Path path) {
    return true;
  }

  @Override
  public String handle(Path path, Method method, String body) {
    return null;
  }
}
