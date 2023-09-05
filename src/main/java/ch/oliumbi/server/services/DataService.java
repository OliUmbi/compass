package ch.oliumbi.server.services;

import ch.oliumbi.compass.autoload.Autoload;
import ch.oliumbi.server.dtos.BoardMessage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Autoload
public class DataService {

  private final ObjectMapper objectMapper = new ObjectMapper();
  private final File file = new File("data.json");

  public List<BoardMessage> getBoardMessages() {

    try {
      return objectMapper.readValue(file, new TypeReference<List<BoardMessage>>() {});
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void write(List<BoardMessage> boardMessages) {
    try {
      Files.write(Paths.get("data.json"), objectMapper.writeValueAsString(boardMessages).getBytes(), StandardOpenOption.WRITE);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
