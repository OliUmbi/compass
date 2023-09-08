package ch.oliumbi.compass.core.enums;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class TranslatableSerializer extends JsonSerializer<Translatable> {

  @Override
  public void serialize(Translatable translatable, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {
    jsonGenerator.writeString(translatable.translate());
  }
}
