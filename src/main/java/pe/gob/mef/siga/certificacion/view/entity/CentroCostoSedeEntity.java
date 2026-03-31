package pe.gob.mef.siga.certificacion.view.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import pe.gob.mef.siga.certificacion.view.entity.id.CentroCostoSedeId;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@IdClass(CentroCostoSedeId.class)
@NoArgsConstructor
@Setter
@Table(name = "CENTRO_COSTO_SEDE", schema = "MTSOBJ")
public class CentroCostoSedeEntity implements Serializable {

  static final long serialVersionUID = -3262593605759131563L;

  @Id
  @Column(name = "SEC_EJEC")
  Long secEjec;

  @Id
  @Column(name = "ANNO")
  Integer anio;

  @Id
  @Column(name = "CENTRO_COSTO")
  String codigo;

  @Id
  @Column(name = "SEDE_ID")
  Integer idSede;

  @Column(name = "ESTADO")
  String estado;

}
