package ch.oliumbi.compass.core.resource;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class Resource {

  public static Optional<byte[]> loadBytes(String path) {
    try {
      InputStream inputStream = ClassLoader.getSystemResourceAsStream(path);

      if (inputStream == null) {
        return Optional.empty();
      }

      return Optional.of(inputStream.readAllBytes());
    } catch (Exception ignored) {
      return Optional.empty();
    }
  }
}
