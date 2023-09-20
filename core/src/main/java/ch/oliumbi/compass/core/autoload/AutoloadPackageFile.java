package ch.oliumbi.compass.core.autoload;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoloadPackageFile extends AutoloadPackage {

  public static final Logger LOGGER = LoggerFactory.getLogger(AutoloadPackageFile.class);

  @Override
  public String protocol() {
    return "file";
  }

  @Override
  public List<Class<?>> classes(ClassLoader classLoader, URL url, String packageName) {

    List<Class<?>> classes = new ArrayList<>();

    try {
      List<String> paths = Files.walk(Paths.get(url.toURI()))
          .filter(Files::isRegularFile)
          .map(path -> path.toUri().getPath())
          .toList();

      for (String path : paths) {
        String className = path
            .replace(url.getPath(), "")
            .replace(".class", "")
            .replace("/", ".");

        classes.add(classLoader.loadClass(packageName + className));
      }

    } catch (Exception e) {
      LOGGER.warn("Failed to load class, url " + url, e);
    }

    return classes;
  }
}
