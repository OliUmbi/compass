package ch.oliumbi.compass.sql.output;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Output {

  private UUID uuid;
  private String string;
  private Boolean bool;
  private Integer integer;
  private Long bigInteger;
  private Double doublePrecision;
  private byte[] bytes;
  private LocalDate date;
  private LocalDateTime timestamp;
}
