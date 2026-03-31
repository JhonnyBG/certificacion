package pe.gob.mef.siga.certificacion.port.outbound.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.gob.mef.siga.certificacion.view.entity.CentroCostoEntity;
import pe.gob.mef.siga.certificacion.view.entity.id.CentroCostoId;
import pe.gob.mef.siga.certificacion.view.projection.ListarCentroCostoProjection;
import pe.gob.mef.siga.certificacion.view.query.ListarCentroCostoQuery;

@Repository
public interface SigCentroCostoRepository extends JpaRepository<CentroCostoEntity, CentroCostoId> {

  @Query("""
      select 
        centroCosto.centroCosto as centroCosto,
        centroCosto.nombre as nombre,
        centroCosto.nivel as nivel,
        centroCosto.estado as estado,
        sede.idSede as idSede,
        sedeEntity.nombre as nombreSede,
        centroCosto.centroPadre as centroPadre
      from CentroCostoEntity centroCosto
      JOIN CentroCostoSedeEntity sede
        ON  sede.secEjec = centroCosto.secEjec
        AND sede.anio = centroCosto.anio
        AND sede.codigo = centroCosto.centroCosto
      JOIN SedeEntity sedeEntity
        ON sedeEntity.secEjec = sede.secEjec
        AND sedeEntity.sedeId = sede.idSede
      WHERE centroCosto.secEjec= :#{#listarCentroCostoQuery.entidad}
        AND centroCosto.anio= :#{#listarCentroCostoQuery.anio}
        AND (:#{#listarCentroCostoQuery.estado} is null OR centroCosto.estado=:#{#listarCentroCostoQuery.estado})
        AND (:#{#listarCentroCostoQuery.idSede} = 0 OR sede.idSede=:#{#listarCentroCostoQuery.idSede})
        AND (:#{#listarCentroCostoQuery.nombre} is null OR centroCosto.nombre
          like UPPER(CONCAT('%',:#{#listarCentroCostoQuery.nombre}, '%')) )
      ORDER BY centroCosto.centroCosto asc
      """)
  List<ListarCentroCostoProjection> listarCentroCosto(
      @Param("listarCentroCostoQuery") ListarCentroCostoQuery listarCentroCostoQuery);
}
