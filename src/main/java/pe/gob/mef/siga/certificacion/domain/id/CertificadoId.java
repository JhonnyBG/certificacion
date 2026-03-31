package pe.gob.mef.siga.certificacion.domain.id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CertificadoId {
  Integer anoEje;
  
  Integer secEjec;
  
  Long certificado;
}
