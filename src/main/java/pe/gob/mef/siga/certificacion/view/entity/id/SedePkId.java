package pe.gob.mef.siga.certificacion.view.entity.id;

import java.io.Serializable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SedePkId implements Serializable {

  static final long serialVersionUID = -309526745641681396L;

  Integer secEjec;

  Integer sedeId;
}
