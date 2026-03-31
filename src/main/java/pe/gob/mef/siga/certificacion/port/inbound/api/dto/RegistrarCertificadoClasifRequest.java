package pe.gob.mef.siga.certificacion.port.inbound.api.dto;


import java.math.BigDecimal;
import java.util.List;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class RegistrarCertificadoClasifRequest {

  @NotNull
  String idClasificador;

  @NotNull
  BigDecimal monto;

  @NotNull
  BigDecimal montoNacional;

  @NotNull
  BigDecimal montoComprometido;

  @NotNull
  BigDecimal montoNacionalAjuste;

  @NotNull
  List<RegistrarCertificadoMetaRequest> metas;

}
