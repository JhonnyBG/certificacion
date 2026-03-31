package pe.gob.mef.siga.certificacion.port.inbound.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pe.gob.mef.siga.certificacion.port.inbound.util.EmptyStringToNullDeserializer;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class RegistrarCertificadoRequest {

  Integer anio;

  Integer entidad;

  @NotNull
  Long certificado;

  Integer secuencia;

  Integer correlativo;

  Integer secuenciaPadre;

  String fuenteFinanciamiento;

  @NotNull(message = "Documento no puede estar vacio")
  @Size(min = 1, max = 10, message = "Codigo de Documento debe tener entre 1 y 10 digitos")
  String codigoDocumento;

  @NotNull(message = "Numero Documento no puede estar vacio")
  @Pattern(regexp = "^[a-zA-Z0-9 /-]+$",
      message = "Solo se permiten letras, numeros, espacios, - y /")
  String numeroDocumento;

  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  @NotNull(message = "La fecha no puede ser nula")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  LocalDate fecha;

  String moneda;

  BigDecimal tipoCambio;

  @Positive(message = "El monto debe ser mayor a 0")
  @NotNull
  @Column(precision = 19, scale = 2)
  BigDecimal monto;

  @Positive(message = "El monto nacional debe ser mayor a 0")
  @NotNull
  @Column(precision = 19, scale = 2)
  BigDecimal montoNacional;

  @Pattern(regexp = "^[a-zA-Z0-9 /\\\\ñóáéíúÑÁÉÍÓÚ°$%()º;,:-]+$",
      message = "Solo se permiten letras, numeros, espacios, y los caracteres especiales /, -, :, \\, ñ, $, %, (, ), °, ;, ,")
  @JsonDeserialize(using = EmptyStringToNullDeserializer.class)
  String glosa;

  Integer tipoCertificacion;

  String indicadorInterfase;

  String certificadoSiga;

  Integer dispositivoLegal = 0;

  @NotNull
  private List<RegistrarCertificadoClasifRequest> clasificadores;

}
