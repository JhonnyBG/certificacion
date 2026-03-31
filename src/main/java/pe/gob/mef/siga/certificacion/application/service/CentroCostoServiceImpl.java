package pe.gob.mef.siga.certificacion.application.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import pe.gob.mef.siga.certificacion.port.outbound.repository.SigCentroCostoCustomRepository;
import pe.gob.mef.siga.certificacion.port.outbound.repository.SigCentroCostoRepository;
import pe.gob.mef.siga.certificacion.view.dto.ListarCentroCostoDTO;
import pe.gob.mef.siga.certificacion.view.projection.ListarCentroCostoProjection;
import pe.gob.mef.siga.certificacion.view.query.ListarCentroCostoQuery;

@Service
@RequiredArgsConstructor
public class CentroCostoServiceImpl implements CentroCostoService {

  private final SigCentroCostoRepository sigCentroCostoRepository;
  private final SigCentroCostoCustomRepository sigCentroCostoCustomRepository;

  @Override
  public List<ListarCentroCostoProjection> listarCentroCosto(
      ListarCentroCostoQuery listarCentroCostoQuery) {
    return sigCentroCostoRepository.listarCentroCosto(listarCentroCostoQuery);
  }

  @Override
  public Page<ListarCentroCostoDTO> listarCentroCosto(ListarCentroCostoQuery params,
      int page, int size) {
    //return sigCentroCostoCustomRepository.listarCentroCostoPaginado(params, page, size);
    return sigCentroCostoCustomRepository.listarCentroCostoPaginado(params, page, size);
  }
}
