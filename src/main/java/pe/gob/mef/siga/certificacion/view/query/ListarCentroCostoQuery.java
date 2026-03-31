package pe.gob.mef.siga.certificacion.view.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ListarCentroCostoQuery {

  Long entidad;
  
  Integer anio;
  
  String estado;
  
  Long idSede;
  
  String nombre;
}
