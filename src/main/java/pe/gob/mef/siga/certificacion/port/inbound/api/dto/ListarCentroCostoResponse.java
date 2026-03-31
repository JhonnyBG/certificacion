package pe.gob.mef.siga.certificacion.port.inbound.api.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * ObtenerCentroCostoResponse
 */
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
    comments = "Personalizado por Mariano Alcántara")
public class ListarCentroCostoResponse {

  String centroCostoCodigo;

  String centroCostoNombre;

  String centroCostoPadre;

  String nivel;

  String sedeCodigo;

  String sedeDescripcion;

  String estado;
}
