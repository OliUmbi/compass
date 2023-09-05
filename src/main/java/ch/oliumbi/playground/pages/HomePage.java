package ch.oliumbi.playground.pages;

import ch.oliumbi.compass.client.Client;
import ch.oliumbi.compass.enums.Method;
import ch.oliumbi.compass.page.Page;
import ch.oliumbi.playground.routes.PingRequest;
import ch.oliumbi.playground.routes.PingResponse;
import java.util.Optional;

public class HomePage implements Page {

  @Override
  public String path() {
    return "/";
  }

  @Override
  public String body() {

    Client client = new Client();
    Optional<PingResponse> ping = client.request("http://localhost:8080/ping", Method.POST, PingResponse.class,
        new PingRequest("ping"));

    System.out.println(ping);

    return """
        <p style="font-family: 'Inter';">hello world</p>
        """;
  }
}
