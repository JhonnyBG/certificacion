package pe.gob.mef.siga.certificacion.view.entity.id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CentroCostoId {

  Long secEjec;
  
  Integer anio;

  String centroCosto;
}
