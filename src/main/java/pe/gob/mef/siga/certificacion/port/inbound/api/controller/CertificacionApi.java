package pe.gob.mef.siga.certificacion.port.inbound.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import pe.gob.mef.siga.certificacion.port.inbound.api.dto.RegistrarCertificadoRequest;
import pe.gob.mef.siga.certificacion.port.inbound.api.dto.RegistroCertificadoResponse;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
comments = "Personalizado por gtomas")
@Validated
public interface CertificacionApi {

  /**
   * POST /certificaciones-siga : Registrar certificado Permite registrar los certificados con los
   * datos ingresados por el usuario a través del siga. Transmite automáticamente.
   *
   * @param registrarCertificadoRequest (required)
   * @return Certificado Registrado (status code 201)
   */
  ResponseEntity<RegistroCertificadoResponse> registrarCertificadoSiga(
      @Valid @RequestBody RegistrarCertificadoRequest registrarCertificadoRequest);

}
