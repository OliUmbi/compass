package ch.oliumbi.compass.core.cardinal.dtos;

import ch.oliumbi.compass.core.cardinal.CardinalDirection;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardinalDirectionDTO {

  private String path;
  private CardinalDirection cardinalDirection;
}
