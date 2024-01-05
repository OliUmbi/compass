package ch.oliumbi.compass.core.resource;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class Resource {

  public static Optional<File> load(String path) {
    try {
      ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
      URL resource = contextClassLoader.getResource(path);

      if (resource == null) {
        return Optional.empty();
      }

      return Optional.of(new File(resource.toURI()));
    } catch (Exception ignored) {
      return Optional.empty();
    }
  }

  public static Optional<byte[]> loadBytes(String path) {
    try {
      ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
      URL resource = contextClassLoader.getResource(path);

      if (resource == null) {
        return Optional.empty();
      }

      return Optional.of(Files.readAllBytes(Path.of(resource.toURI())));
    } catch (Exception ignored) {
      return Optional.empty();
    }
  }
}
