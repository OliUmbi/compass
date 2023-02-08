package ch.oliumbi.compass.core.configuration.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SqlConfiguration {

  private String url;
  private String username;
  private String password;
}
