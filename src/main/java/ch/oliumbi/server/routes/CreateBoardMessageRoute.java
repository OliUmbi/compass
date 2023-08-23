package ch.oliumbi.server.routes;

import ch.oliumbi.compass.autoload.Autoload;
import ch.oliumbi.compass.enums.Method;
import ch.oliumbi.compass.route.Route;
import ch.oliumbi.server.dtos.BoardMessage;
import ch.oliumbi.server.dtos.BoardMessageRequest;
import ch.oliumbi.server.services.DataService;
import java.util.List;

@Autoload
public class CreateBoardMessageRoute implements Route<BoardMessageRequest> {

  private final DataService dataService;

  public CreateBoardMessageRoute(DataService dataService) {
    this.dataService = dataService;
  }

  @Override
  public String path() {
    return "/message";
  }

  @Override
  public Method method() {
    return Method.POST;
  }

  @Override
  public Class<BoardMessageRequest> mapping() {
    return BoardMessageRequest.class;
  }

  @Override
  public Object handle(BoardMessageRequest body, String ip) throws Exception {

    List<BoardMessage> boardMessages = dataService.getBoardMessages();

    boardMessages.add(new BoardMessage(
        body.title(),
        body.description(),
        ip,
        body.name()
    ));

    dataService.write(boardMessages);

    return "Success";
  }
}
