package pe.gob.mef.siga.certificacion.view.entity.id;

import java.io.Serializable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CentroCostoSedeId implements Serializable {

  static final long serialVersionUID = 8982220556298464579L;

  Long secEjec;

  Integer anio;

  String codigo;

  Integer idSede;
}
