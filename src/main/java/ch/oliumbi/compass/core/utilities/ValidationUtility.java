package ch.oliumbi.compass.core.utilities;

public class ValidationUtility {

  public static <T> T notNull(T object, Class<? extends RuntimeException> exception) {
    if (object == null) {
      throw ReflectionUtility.createInstance(exception);
    }

    return object;
  }

  public static <T> T notNull(T object, RuntimeException exception) {
    if (object == null) {
      throw exception;
    }

    return object;
  }

}
