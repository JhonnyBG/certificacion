package pe.gob.mef.siga.certificacion.domain.aggregate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import pe.gob.mef.siga.certificacion.domain.id.CertificadoId;
import pe.gob.mef.siga.certificacion.domain.value.TipoCertificado;
import pe.gob.mef.siga.certificacion.domain.value.TipoOperacion;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CertificadoAggregate {

  CertificadoId id;
  
  TipoCertificado tipoCertificado; 
  
  TipoOperacion tipoOperacion;
}
