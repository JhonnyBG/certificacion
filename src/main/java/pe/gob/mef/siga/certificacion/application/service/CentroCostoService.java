package pe.gob.mef.siga.certificacion.application.service;

import java.util.List;
import org.springframework.data.domain.Page;
import pe.gob.mef.siga.certificacion.view.dto.ListarCentroCostoDTO;
import pe.gob.mef.siga.certificacion.view.projection.ListarCentroCostoProjection;
import pe.gob.mef.siga.certificacion.view.query.ListarCentroCostoQuery;

public interface CentroCostoService {
  List<ListarCentroCostoProjection> listarCentroCosto(
      ListarCentroCostoQuery listarCentroCostoQuery);

  Page<ListarCentroCostoDTO> listarCentroCosto(
      ListarCentroCostoQuery params, int page, int size);
}
