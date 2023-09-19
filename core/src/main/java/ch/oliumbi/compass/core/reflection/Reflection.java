package ch.oliumbi.compass.core.reflection;

import ch.oliumbi.compass.core.exceptions.CompassReflectionException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reflection {

  public static final Logger LOGGER = LoggerFactory.getLogger(Reflection.class);

  public static List<Field> fields(Class<?> clazz) {
    List<Field> fields = new ArrayList<>(List.of(clazz.getDeclaredFields()));

    if (clazz.getSuperclass() == null) {
      return fields;
    }

    fields.addAll(fields(clazz.getSuperclass()));

    return fields;
  }

  public static Field field(Class<?> clazz, String name) throws CompassReflectionException {
    try {
      return clazz.getDeclaredField(name);
    } catch (NoSuchFieldException e) {
      if (clazz.getSuperclass() == null) {
        LOGGER.error("Failed to find field " + name);
        throw new CompassReflectionException();
      }

      return field(clazz.getSuperclass(), name);
    }
  }

  public static void fieldSet(Object object, String name, Object value) throws CompassReflectionException {
    Field field = field(object.getClass(), name);

    field.setAccessible(true);
    try {
      field.set(object, value);
    } catch (IllegalAccessException e) {
      LOGGER.error("Failed to access field " + name);
      throw new CompassReflectionException();
    }
  }

  public static Object fieldGet(Object object, String name) throws CompassReflectionException {
    Field field = field(object.getClass(), name);

    field.setAccessible(true);
    try {
      return field.get(object);
    } catch (IllegalAccessException | IllegalArgumentException e) {
      LOGGER.error("Failed to access field " + name);
      throw new CompassReflectionException();
    }
  }

  public static Method method(Class<?> clazz, String name, Class<?>... types) throws CompassReflectionException {
    try {
      if (types.length == 0) {
        return clazz.getDeclaredMethod(name);
      }

      return clazz.getDeclaredMethod(name, types);
    } catch (NoSuchMethodException e) {
      if (clazz.getSuperclass() == null) {
        LOGGER.error("Failed to find method " + name);
        throw new CompassReflectionException();
      }

      return method(clazz.getSuperclass(), name, types);
    }
  }

  public static Object invoke(Method method, Object target, Object... args) throws CompassReflectionException {
    try {
      return method.invoke(target, args);
    } catch (IllegalAccessException | InvocationTargetException e) {
      LOGGER.error("Failed to invoke function " + method.getName(), e);
      throw new CompassReflectionException();
    }
  }

  public static <T> T instantiate(Class<T> clazz, Object... args) throws CompassReflectionException {
    Constructor<T> constructor;
    try {
      constructor = clazz.getConstructor();
    } catch (NoSuchMethodException e) {
      LOGGER.error("No constructor found for class " + clazz.getName(), e);
      throw new CompassReflectionException();
    }

    try {
      return constructor.newInstance();
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
      LOGGER.error("Failed to instantiate class " + clazz.getName(), e);
      throw new CompassReflectionException();
    }
  }
}
