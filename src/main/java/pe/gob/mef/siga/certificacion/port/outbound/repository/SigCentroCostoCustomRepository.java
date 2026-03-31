package pe.gob.mef.siga.certificacion.port.outbound.repository;

import org.springframework.data.domain.Page;
import pe.gob.mef.siga.certificacion.view.dto.ListarCentroCostoDTO;
import pe.gob.mef.siga.certificacion.view.query.ListarCentroCostoQuery;

public interface SigCentroCostoCustomRepository {

  Page<ListarCentroCostoDTO> listarCentroCostoPaginado(ListarCentroCostoQuery params,
      int page, int size);

}
