package ch.oliumbi.compass.sql.output;

import ch.oliumbi.compass.core.exceptions.CompassReflectionException;
import ch.oliumbi.compass.core.reflection.Reflection;
import ch.oliumbi.compass.sql.exceptions.CompassSqlException;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutputService {

  public static final Logger LOGGER = LoggerFactory.getLogger(OutputService.class);

  public <T> List<T> resolve(ResultSet resultSet, Class<T> clazzOutput, List<String> queryOutputs)
      throws CompassSqlException, CompassReflectionException {

    List<T> outputs = new ArrayList<>();

    try {
      while (resultSet.next()) {

        T output = Reflection.instantiate(clazzOutput);

        for (int i = 0; i < queryOutputs.size(); i++) {
          String queryOutput = queryOutputs.get(i);

          Field field = Reflection.field(clazzOutput, queryOutput);
          Object value = value(resultSet, field.getType(), (i + 1));

          Reflection.fieldSet(output, queryOutput, value);
        }

        outputs.add(output);
      }
    } catch (SQLException e) {
      LOGGER.error("Failed to read next value of result set", e);
      throw new CompassSqlException();
    }

    return outputs;
  }

  public boolean exists(ResultSet resultSet) throws CompassSqlException {
    try {
      resultSet.next();

      return resultSet.getBoolean(1);
    } catch (SQLException e) {
      LOGGER.error("Failed to read exists result", e);
      throw new CompassSqlException();
    }
  }

  private Object value(ResultSet resultSet, Class<?> type, int index) throws CompassSqlException {
    try {
      if (type == byte[].class) {
        return resultSet.getBytes(index);
      }

      return resultSet.getObject(index, type);
    } catch (SQLException e) {
      LOGGER.error("Failed to convert value", e);
      throw new CompassSqlException();
    }
  }
}
