package pe.gob.mef.siga.certificacion.port.inbound.util;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class EmptyStringToNullDeserializer extends JsonDeserializer<String> {

  @Override
  public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
    var value = p.getText();
    return value.isEmpty() ? null : value;
  }

}
