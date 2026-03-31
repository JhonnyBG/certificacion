package pe.gob.mef.siga.certificacion.port.inbound.api.controller;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import pe.gob.mef.siga.certificacion.port.inbound.api.dto.ListarCentroCostoResponse;

public interface CentroCostoApi {

  /**
   * GET /centros-costos: Consulta todas las Áreas Usuarias o un Área Usuaria en específico siendo
   * el campo Área Usuaria no requerido Consulta todas las Áreas Usuarias
   *
   * @param anno Año del Área Usuaria (required)
   * @param estado Estado del Área Usuaria (required)
   * @param sedeCodigo Código de la Sede (required)
   * @param centroCostoNombre Nombre del Área Usuaria (optional)
   * @return Operación exitosa (status code 200) or No Content (status code 204) or Error en el
   *         servidor (status code 500) or Error inesperado (status code 200)
   */
  @GetMapping(value = "/centros-costos", produces = {"application/json"})
  ResponseEntity<List<ListarCentroCostoResponse>> listarCentroCosto(
      @NotNull @Valid @RequestParam(required = true) Integer anno,
      @Valid @RequestParam(required = false) String estado,
      @NotNull @Valid @RequestParam(value = "sede_codigo", required = true) Integer sedeCodigo,
      @Valid @RequestParam(value = "centro_costo_nombre",
          required = false) String centroCostoNombre);

  @GetMapping(value = "/centros-costos2", produces = {"application/json"})
  ResponseEntity<Page<ListarCentroCostoResponse>> listarCentroCosto2(
      @NotNull @Valid @RequestParam(required = true) Integer anno,
      @RequestParam() Integer page, @RequestParam() Integer size);
}
