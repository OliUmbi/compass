package ch.oliumbi.compass.web;

import ch.oliumbi.compass.enums.MimeType;
import ch.oliumbi.compass.page.DefaultHead;
import ch.oliumbi.compass.page.Head;
import ch.oliumbi.compass.page.Page;
import ch.oliumbi.playground.Main;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class WebHandler extends AbstractHandler {

  private final ObjectMapper objectMapper = new ObjectMapper();
  private final List<Page> pages = new ArrayList<>();;
  private Head head = new DefaultHead();

  public WebHandler(List<Object> instances) {

    for (Object instance : instances) {
      if (instance instanceof Page page) {
        pages.add(page);
      }
      if (instance instanceof Head head) {
        this.head = head;
      }
    }
  }

  @Override
  public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) {

    baseRequest.setHandled(true);

    try {

      if (target.startsWith("/static")) {

        InputStream resourceAsStream = Main.class.getResourceAsStream(target);

        response.getOutputStream().write(resourceAsStream.readAllBytes());
      }

      if (target.equals("/manifest.json")) {


        response.getOutputStream().print(objectMapper.writeValueAsString(head.manifest()));
      }

      for (Page page : pages) {

        if (page.path().equals(target)) {

          response.setContentType(MimeType.HTML.translate());

          String html = String.format("""
                  <!doctype html>
                  <html lang="%s">
                  <head>
                    <meta charset="%s">
                    <title>%s</title>
                    <meta name="description" content="%s">
                    <meta name="theme-color" content="%s">
                    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
                    <meta http-equiv="X-UA-Compatible" content="ie=edge">
                    <link rel="icon" href="%s">
                    <link rel="manifest" href="manifest.json" />
                  </head>
                  <body>
                  """,
              head.language(),
              head.charset(),
              head.title(),
              head.description(),
              head.themeColor(),
              head.iconHref()
          );

          html += page.body();

          html += """
              </body>
              </html>
              """;

          response.getOutputStream().print(html);
        }

      }
    } catch (Exception e) {
      e.printStackTrace();
      // todo handle exception
    }

  }
}
