package pe.gob.mef.siga.certificacion.port.inbound.api.mapper;

import org.springframework.stereotype.Component;
import pe.gob.mef.siga.certificacion.domain.aggregate.CertificadoAggregate;
import pe.gob.mef.siga.certificacion.domain.command.RegistrarCertificadoCommand;
import pe.gob.mef.siga.certificacion.port.inbound.api.dto.RegistrarCertificadoRequest;
import pe.gob.mef.siga.certificacion.port.inbound.api.dto.RegistroCertificadoResponse;

@Component
public class CertificacionMapper {

    public RegistroCertificadoResponse toResponse(CertificadoAggregate aggregate) {

        RegistroCertificadoResponse response = new RegistroCertificadoResponse();

        response.setCodigoMensaje("0"); // éxito
        response.setMensaje("Certificado registrado correctamente");

        response.setAnio(aggregate.getId().getAnoEje());
        response.setCertificado(aggregate.getId().getCertificado());

        // Si correlativo es parte del ID
        response.setCorrelativo(aggregate.getId().getCertificado().intValue());

        // Estado inicial del certificado (si tu aggregate lo define)
        response.setEstadoRegistro(null);

        // Por ahora no manejamos montos en el aggregate
        response.setMontoMN(null);

        // Secuencia aún no existe en el dominio
        response.setSecuencia(null);

        return response;
    }
    
    public RegistrarCertificadoCommand toCommand(RegistrarCertificadoRequest request) {

      return RegistrarCertificadoCommand.builder()
              .anoEje(request.getAnio())
              .certificado(request.getCertificado())
              .tipoCertificado(1)
              .tipoOperacion(null)
              //.fecha(null)
              //.glosa("demo")
              //.usuario("usuario-demo") // luego vendrá del token
              .build();
  }

  private Integer parseTipoCertificacion(String tipo) {
      try {
          return Integer.valueOf(tipo);
      } catch (Exception e) {
          throw new IllegalArgumentException("Tipo de certificación inválido: " + tipo);
      }
  }

}