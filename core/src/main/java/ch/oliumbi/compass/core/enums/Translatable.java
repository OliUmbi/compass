package ch.oliumbi.compass.core.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = TranslatableSerializer.class)
public interface Translatable {

  String translate();
}
