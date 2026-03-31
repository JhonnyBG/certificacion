package pe.gob.mef.siga.certificacion.port.inbound.api.dto;

import java.io.Serializable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class RegistroCertificadoResponse implements Serializable {

  private static final long serialVersionUID = -7531429080787892714L;

  String codigoMensaje;
  String mensaje;
  Long certificado;
  Integer secuencia;
  Integer correlativo;
  Integer anio;
  String estadoRegistro;
  String montoMN;
}
