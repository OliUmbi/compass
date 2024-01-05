package ch.oliumbi.compass.core.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.Optional;

public class Json {

  public static Optional<String> convert(Object object) {
    try {

      ObjectMapper objectMapper = new ObjectMapper();
      ObjectWriter objectWriter = objectMapper.writer();

      return Optional.of(objectWriter.writeValueAsString(object));
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}
