package pe.gob.mef.siga.certificacion.view.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import pe.gob.mef.siga.certificacion.view.entity.id.CentroCostoId;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@IdClass(CentroCostoId.class)
@NoArgsConstructor
@Setter
@Table(name = "CENTRO_COSTO", schema = "MTSOBJ")
public class CentroCostoEntity implements Serializable {

  @Serial
  private static final long serialVersionUID = 5779619283926016797L;

  @Id
  @Column(name = "sec_ejec")
  Long secEjec;

  @Id
  @Column(name = "anno")
  Integer anio;

  @Id
  @Column(name = "CENTRO_COSTO")
  String centroCosto;

  @Column(name = "NOMBRE")
  String nombre;

  @Column(name = "ABREVIATURA")
  String abreviatura;

  @Column(name = "NIVEL")
  String nivel;

  @Column(name = "CENTRO_PADRE")
  String centroPadre;

  @Column(name = "ORDEN")
  String orden;

  @Column(name = "PERSONAL_DOCTIP")
  String codTipoDocumentoResponsable;

  @Column(name = "PERSONAL_DOCNUM")
  String numeroDocumentoResponsable;

  @Column(name = "ESTADO")
  String estado;

  @Column(name = "FLAG_AREA_ESTRATEGICA")
  String flagAreaEstrategica;
}
