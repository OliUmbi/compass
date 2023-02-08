package ch.oliumbi.compass.impl;

import ch.oliumbi.compass.core.Compass;
import ch.oliumbi.compass.core.configuration.Configuration;
import java.lang.reflect.ReflectPermission;

public class Main {

    public static void main(String[] args) {
        Application application = new Application();
        application.start(args);
    }
}
