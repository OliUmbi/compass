package ch.oliumbi.compass.sql.input;

import ch.oliumbi.compass.core.exceptions.CompassReflectionException;
import ch.oliumbi.compass.core.reflection.Reflection;
import ch.oliumbi.compass.sql.exceptions.CompassSqlException;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputService {

  public static final Logger LOGGER = LoggerFactory.getLogger(InputService.class);

  public PreparedStatement build(PreparedStatement preparedStatement, List<String> queryInputs, List<Object> objectInputs)
      throws CompassReflectionException, CompassSqlException {

    List<Input> inputs = new ArrayList<>();

    for (Object objectInput : objectInputs) {

      if (objectInput instanceof Input input) {
        inputs.add(input);
        continue;
      }

      for (Field field : Reflection.fields(objectInput.getClass())) {
        String name = field.getName();
        inputs.add(new Input(name, Reflection.fieldGet(objectInput, name)));
      }
    }

    for (int i = 0; i < queryInputs.size(); i++) {
      Input filtered = filter(inputs, queryInputs.get(i));

      try {
        preparedStatement.setObject((i + 1), convert(filtered.getValue()));
      } catch (SQLException e) {
        LOGGER.error("Failed set parameter to prepared statement", e);
        throw new CompassSqlException();
      }
    }

    return preparedStatement;
  }

  private Input filter(List<Input> inputs, String queryInput) throws CompassSqlException {
    List<Input> matched = inputs.stream().filter(input -> input.getKey().equals(queryInput)).toList();

    if (matched.isEmpty()) {
      LOGGER.error("No input found for " + queryInput);
      throw new CompassSqlException();
    }

    if (matched.size() > 1) {
      LOGGER.error("Multiple inputs found for " + queryInput);
      throw new CompassSqlException();
    }

    return matched.get(0);
  }

  private Object convert(Object value) {
    return value;
  }
}
