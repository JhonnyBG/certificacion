package pe.gob.mef.siga.certificacion.port.inbound.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import pe.gob.mef.siga.certificacion.port.inbound.api.dto.RegistrarCertificadoRequest;
import pe.gob.mef.siga.certificacion.port.inbound.api.dto.RegistroCertificadoResponse;

@RestController
public class CertificacionApiController implements CertificacionApi {

  @Override
  @PostMapping(value = "/certificaciones-siga", produces = {"application/json"},
  consumes = {"application/json"})
  public ResponseEntity<RegistroCertificadoResponse> registrarCertificadoSiga(
      @Valid RegistrarCertificadoRequest registrarCertificadoRequest) {

    registrarCertificadoRequest.setEntidad(46);
    registrarCertificadoRequest.setIndicadorInterfase("S");

    var response = this.certificacionCommandService
        .registrar(CertificacionMapper.mapToCommand(registrarCertificadoRequest));
    
    /*
    this.transmitirSiga(response.getAnio(), response.getCertificado(), response.getSecuencia(),
        response.getCorrelativo());

    return ResponseEntity
        .created(UriComponentsBuilder.fromPath("/certificaciones/{anio}/{entidad}/{certificado}")
            .buildAndExpand(registrarCertificadoRequest.getAnio(),
                Objects.isNull(response) ? 0 : response.getCodigoMensaje(),
                Objects.isNull(response) ? 0 : response.getMensaje(),
                Objects.isNull(response) ? 0 : response.getCertificado(),
                Objects.isNull(response) ? 0 : response.getSecuencia())
            .toUri())
        .body(response);
     */
    
    return ResponseEntity.ok(pageResponse);

  }

}
