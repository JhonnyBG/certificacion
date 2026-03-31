package pe.gob.mef.siga.certificacion.port.inbound.api.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class RegistrarCertificadoMetaRequest {

  @NotNull
  Integer secFunc;

  @NotNull
  BigDecimal monto;

  @NotNull
  BigDecimal montoNacional;

  @NotNull
  BigDecimal montoComprometido;

  @NotNull
  BigDecimal montoNacionalAjuste;

}
