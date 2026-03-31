package pe.gob.mef.siga.certificacion.application.service;

import pe.gob.mef.siga.certificacion.domain.aggregate.CertificadoAggregate;
import pe.gob.mef.siga.certificacion.domain.command.RegistrarCertificadoCommand;

public interface CertificadoCommandService {
  
  CertificadoAggregate registrar(RegistrarCertificadoCommand command);

}
