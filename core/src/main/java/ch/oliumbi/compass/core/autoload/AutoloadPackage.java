package ch.oliumbi.compass.core.autoload;

import java.net.URL;
import java.util.List;

public abstract class AutoloadPackage {

  public abstract String protocol();

  public abstract List<Class<?>> classes(ClassLoader classLoader, URL url, String packageName);
}
