package ch.oliumbi.user.pages;

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
        <div class="user">
          <div class="user-head">
            <h1>Benutzer</h1>
          </div>
          <div class="user-config">
            <small>Configuration</small>
            <label>
              <h6>IP-Address</h6>
              <input type="text" id="ip" placeholder="x.x.x.x" value="192.168.0.xxx">
            </label>
            <label>
              <h6>Name</h6>
              <input type="text" id="name">
            </label>
          </div>
          <div class="user-message">
            <small>Message</small>
            <label>
              <h6>Title</h6>
              <input type="text" id="title">
            </label>
            <label>
              <h6>Description</h6>
              <textarea id="description" rows="8"></textarea>
            </label>
            <button onclick="post()">Post</button>
            <p id="result"></p>
          </div>
        </div>
        """);
  }
}
