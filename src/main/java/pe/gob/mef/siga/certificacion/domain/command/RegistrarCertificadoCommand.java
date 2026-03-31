package pe.gob.mef.siga.certificacion.domain.command;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistrarCertificadoCommand {
  
  Integer anoEje;
  
  Integer secEjec;
  
  Integer tipoCertificado;
  
  String tipoOperacion;

}
