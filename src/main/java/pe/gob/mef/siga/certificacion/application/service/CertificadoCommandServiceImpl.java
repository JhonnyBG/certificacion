package pe.gob.mef.siga.certificacion.application.service;

import org.springframework.stereotype.Service;
import pe.gob.mef.siga.certificacion.domain.aggregate.CertificadoAggregate;
import pe.gob.mef.siga.certificacion.domain.command.RegistrarCertificadoCommand;
import pe.gob.mef.siga.certificacion.domain.id.CertificadoId;
import pe.gob.mef.siga.certificacion.domain.value.TipoCertificado;
import pe.gob.mef.siga.certificacion.domain.value.TipoOperacion;

@Service
public class CertificadoCommandServiceImpl implements CertificadoCommandService {

  @Override
  public CertificadoAggregate registrar(RegistrarCertificadoCommand command) {

    Long correlativo = generarCorrelativoTemporal();


    CertificadoId id = new CertificadoId(command.getAnoEje(), command.getSecEjec(),
        !command.getCertificado().equals(0) ? command.getCertificado() : correlativo);

    return new CertificadoAggregate(id, TipoCertificado.from(command.getTipoCertificado()),
        new TipoOperacion(command.getTipoOperacion()));
  }

  private Long generarCorrelativoTemporal() {
    return System.currentTimeMillis();
  }

}
