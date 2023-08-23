package ch.oliumbi.server.routes;

import ch.oliumbi.compass.autoload.Autoload;
import ch.oliumbi.compass.enums.Method;
import ch.oliumbi.compass.route.Route;
import ch.oliumbi.server.services.DataService;

@Autoload
public class LoadBoardMessageRoute implements Route<Void> {

  private final DataService dataService;

  public LoadBoardMessageRoute(DataService dataService) {
    this.dataService = dataService;
  }

  @Override
  public String path() {
    return "/message";
  }

  @Override
  public Method method() {
    return Method.GET;
  }

  @Override
  public Class<Void> mapping() {
    return null;
  }

  @Override
  public Object handle(Void body, String ip) {
    return dataService.getBoardMessages();
  }
}
