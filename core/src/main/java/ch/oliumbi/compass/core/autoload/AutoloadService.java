package ch.oliumbi.compass.core.autoload;

import ch.oliumbi.compass.core.annotations.Autoload;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoloadService {

  public static final Logger LOGGER = LoggerFactory.getLogger(AutoloadService.class);

  private final Class<?> clazz;

  public AutoloadService(Class<?> clazz) {
    this.clazz = clazz;
  }

  public List<Object> autoload() {

    ClassLoader classLoader = clazz.getClassLoader();
    String packageName = clazz.getPackageName();
    URL url = classLoader.getResource(packageName.replace(".", "/"));

    List<Class<?>> classes = new ArrayList<>();

    for (AutoloadPackage autoloadPackage : autoloadPackages()) {

      if (url.getProtocol().equals(autoloadPackage.protocol())) {
        classes.addAll(autoloadPackage.classes(classLoader, url, packageName));
      }
    }

    List<Class<?>> autoload = classes.stream().filter(aClass -> aClass.isAnnotationPresent(Autoload.class)).toList();

    AutoloadInstantiate autoloadInstantiate = new AutoloadInstantiate();
    return autoload.stream().map(autoloadInstantiate::instantiate).toList();
  }

  private List<AutoloadPackage> autoloadPackages() {
    return List.of(
        new AutoloadPackageFile(),
        new AutoloadPackageJar()
    );
  }
}
