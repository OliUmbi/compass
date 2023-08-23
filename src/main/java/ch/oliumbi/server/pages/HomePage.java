package ch.oliumbi.server.pages;

import ch.oliumbi.compass.autoload.Autoload;
import ch.oliumbi.compass.page.Page;
import ch.oliumbi.server.dtos.BoardMessage;
import ch.oliumbi.server.services.DataService;
import java.util.stream.Collectors;

@Autoload
public class HomePage implements Page {

  private final DataService dataService;

  public HomePage(DataService dataService) {
    this.dataService = dataService;
  }

  @Override
  public String path() {
    return "/";
  }

  @Override
  public String body() {

    return String.format("""
        <div class="board">
          <div class="board-head">
            <h1>Message board</h1>
            <button onclick="reload()">Reload</button>
          </div>
          <div class="board-messages" id="messages">
            %s
          </div>
        </div>
        """,
        dataService.getBoardMessages().stream().map(BoardMessage::toString).collect(Collectors.joining()));
  }
}
