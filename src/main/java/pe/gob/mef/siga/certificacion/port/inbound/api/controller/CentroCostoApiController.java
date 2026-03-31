package pe.gob.mef.siga.certificacion.port.inbound.api.controller;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import pe.gob.mef.siga.certificacion.application.service.CentroCostoService;
import pe.gob.mef.siga.certificacion.port.inbound.api.dto.ListarCentroCostoResponse;
import pe.gob.mef.siga.certificacion.port.inbound.api.mapper.CentroCostoMapper;
import pe.gob.mef.siga.certificacion.view.query.ListarCentroCostoQuery;

@RestController
@RequiredArgsConstructor
public class CentroCostoApiController implements CentroCostoApi {

  private final CentroCostoService centroCostoService;
  private final CentroCostoMapper centroCostoMapper;

  @Override
  public ResponseEntity<List<ListarCentroCostoResponse>> listarCentroCosto(
      @NotNull @Valid Integer anno, @Valid String estado, @NotNull @Valid Integer sedeCodigo,
      @Valid String centroCostoNombre) {

    return ResponseEntity.ok(centroCostoMapper.toResponseList(centroCostoService
        .listarCentroCosto(ListarCentroCostoQuery.builder().entidad(46L).anio(anno).estado(estado)
            .idSede(sedeCodigo.longValue()).nombre(centroCostoNombre).build())));
  }

  @Override
  public ResponseEntity<Page<ListarCentroCostoResponse>> listarCentroCosto2(
      @NotNull @Valid Integer anno, Integer page, Integer size) {
    
    var lista = centroCostoService.listarCentroCosto(
        ListarCentroCostoQuery.builder().entidad(46L).anio(anno).build(), page, size);
//    var listaResponse = centroCostoMapper.toResponseList2(lista);
//    return ResponseEntity.ok(PagelistaResponse);
    
    var pageResponse = lista.map(centroCostoMapper::toResponse);

    return ResponseEntity.ok(pageResponse);

  }

}
