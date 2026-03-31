package pe.gob.mef.siga.certificacion.port.inbound.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mef.siga.certificacion.CertificacionApplication;
import pe.gob.mef.siga.certificacion.application.service.CertificadoCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import pe.gob.mef.siga.certificacion.port.inbound.api.dto.RegistrarCertificadoRequest;
import pe.gob.mef.siga.certificacion.port.inbound.api.dto.RegistroCertificadoResponse;
import pe.gob.mef.siga.certificacion.port.inbound.api.mapper.CertificacionMapper;

@RestController
@RequiredArgsConstructor
public class CertificacionApiController implements CertificacionApi {
  
    private final CertificacionMapper mapper;
    private final CertificadoCommandService certificadoCommandService; 

  @Override
  @PostMapping(value = "/certificaciones-siga", produces = {"application/json"},
  consumes = {"application/json"})
  public ResponseEntity<RegistroCertificadoResponse> registrarCertificadoSiga(
      @Valid RegistrarCertificadoRequest registrarCertificadoRequest) {

    registrarCertificadoRequest.setEntidad(46);
    registrarCertificadoRequest.setIndicadorInterfase("S");
    
    var command = mapper.toCommand(registrarCertificadoRequest);
    var aggregate = certificadoCommandService.registrar(command);
    var response = mapper.toResponse(aggregate);

    return ResponseEntity.status(HttpStatus.CREATED).body(response);

  }

}
