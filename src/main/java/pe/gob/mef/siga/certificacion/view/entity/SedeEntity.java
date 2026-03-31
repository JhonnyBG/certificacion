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
import pe.gob.mef.siga.certificacion.view.entity.id.SedePkId;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@IdClass(SedePkId.class)
@NoArgsConstructor
@Setter
@Table(name = "SEDE", schema = "MTSOBJ")
public class SedeEntity implements Serializable {

  private static final long serialVersionUID = 8044948311641906887L;

  @Id
  @Column(name = "SEC_EJEC")
  Integer secEjec;

  @Id
  @Column(name = "SEDE_ID")
  Integer sedeId;

  String nombre;

  String pais;

  String departamento;

  String provincia;

  String distrito;

  String direccion;

  String referencia;

  String telefono;

  String flagPrincipal;
}
