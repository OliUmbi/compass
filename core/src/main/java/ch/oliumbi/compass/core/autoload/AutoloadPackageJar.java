package ch.oliumbi.compass.core.autoload;

import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoloadPackageJar extends AutoloadPackage {

  public static final Logger LOGGER = LoggerFactory.getLogger(AutoloadPackageJar.class);

  @Override
  public String protocol() {
    return "jar";
  }

  @Override
  public List<Class<?>> classes(ClassLoader classLoader, URL url, String packageName) {

    List<Class<?>> classes = new ArrayList<>();

    try {

      if (url.openConnection() instanceof JarURLConnection jarURLConnection) {
        JarFile jarFile = jarURLConnection.getJarFile();

        List<String> paths = jarFile.stream()
            .filter(jarEntry -> !jarEntry.isDirectory())
            .filter(jarEntry -> jarEntry.getName().startsWith(packageName.replace(".", "/")))
            .map(ZipEntry::getName)
            .toList();

        for (String path : paths) {
          String className = path
              .replace(".class", "")
              .replace("/", ".");

          classes.add(classLoader.loadClass(className));
        }
      }

    } catch (Exception e) {
      LOGGER.warn("Failed to load class, url " + url, e);
    }

    return classes;
  }
}
