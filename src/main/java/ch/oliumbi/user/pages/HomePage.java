package ch.oliumbi.user.pages;

import ch.oliumbi.compass.autoload.Autoload;
import ch.oliumbi.compass.page.Page;
import ch.oliumbi.server.services.DataService;

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
        <div class="app">
          <div class="board">
            <div class="board-head">
              <h1>Message board</h1>
            </div>
            <div class="board-messages" id="messages">
            </div>
          </div>
          <div class="user">
            <div class="user-head">
              <h1>Benutzer</h1>
            </div>
            <div class="user-config">
              <small>Configuration</small>
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
        </div
        """);
  }
}
