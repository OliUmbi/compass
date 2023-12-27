package ch.oliumbi.compass.client;

import ch.oliumbi.compass.core.enums.Method;
import ch.oliumbi.compass.core.enums.MimeType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Objects;
import java.util.Optional;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.util.StringRequestContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Http {

  public static final Logger LOGGER = LoggerFactory.getLogger(Http.class);

  private final HttpClient httpClient = new HttpClient();
  private final ObjectMapper objectMapper = new ObjectMapper();

  public <T> Optional<T> request(String url, Method method, Class<T> clazz, Object body) {
    try {
      start();

      StringRequestContent content = new StringRequestContent(
          MimeType.JSON.translate(),
          objectMapper.writeValueAsString(body)
      );

      ContentResponse response = httpClient.newRequest(url)
          .method(method.name())
          .body(content)
          .send();

      if (response.getStatus() != 200) {
        LOGGER.error("Response is not 200 OK, status " + response.getStatus());
        return Optional.empty();
      }

      if (!Objects.equals(response.getMediaType(), MimeType.JSON.translate())) {
        LOGGER.error("Media type is not json, type " + response.getMediaType());
        return Optional.empty();
      }

      return Optional.of(objectMapper.readValue(response.getContentAsString(), clazz));
    } catch (Exception e) {
      // todo error handling
      LOGGER.error("Failed to send request", e);
      throw new RuntimeException();
    }
  }

  private void start() {
    try {
      if (!httpClient.isStarted()) {
        httpClient.start();
      }
    } catch (Exception e) {
      // todo error handling
      LOGGER.error("Failed to start client", e);
      throw new RuntimeException();
    }
  }
}
