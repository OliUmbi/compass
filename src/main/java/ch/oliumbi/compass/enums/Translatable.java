package ch.oliumbi.compass.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = TranslatableSerializer.class)
public interface Translatable {

  String translate();
}
