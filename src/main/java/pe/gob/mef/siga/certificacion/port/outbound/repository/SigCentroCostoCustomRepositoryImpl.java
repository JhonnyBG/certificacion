package pe.gob.mef.siga.certificacion.port.outbound.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import pe.gob.mef.siga.certificacion.view.dto.ListarCentroCostoDTO;
import pe.gob.mef.siga.certificacion.view.query.ListarCentroCostoQuery;

@Repository
public class SigCentroCostoCustomRepositoryImpl implements SigCentroCostoCustomRepository {

  @PersistenceContext
  private EntityManager em;

  @Override
  public Page<ListarCentroCostoDTO> listarCentroCostoPaginado(ListarCentroCostoQuery params,
      int page, int size) {

    String sql = """
        SELECT
            cc.CENTRO_COSTO AS centroCosto,
            cc.NOMBRE AS nombre,
            cc.NIVEL AS nivel,
            cc.ESTADO AS estado,
            cs.SEDE_ID AS idSede,
            s.NOMBRE AS nombreSede,
            cc.CENTRO_PADRE AS centroPadre
        """;
    String sqlFROM = """
            FROM MTSOBJ.CENTRO_COSTO cc
            JOIN MTSOBJ.CENTRO_COSTO_SEDE cs
              ON cs.SEC_EJEC = cc.SEC_EJEC
             AND cs.ANNO = cc.ANNO
             AND cs.CENTRO_COSTO = cc.CENTRO_COSTO
            JOIN MTSOBJ.SEDE s
              ON s.SEC_EJEC = cs.SEC_EJEC
             AND s.SEDE_ID = cs.SEDE_ID
        """;

    String sqlWHERE = """
            WHERE cc.SEC_EJEC = :entidad
              AND cc.ANNO = :anio
            ORDER BY cc.CENTRO_COSTO
        """;

    sql = sql.concat(sqlFROM).concat(sqlWHERE);
    Query query = em.createNativeQuery(sql);
    query.setParameter("entidad", params.getEntidad());
    query.setParameter("anio", params.getAnio());

    if (size > 0) {
      query.setFirstResult(page * size);
      query.setMaxResults(size);
    }

    @SuppressWarnings("unchecked")
    List<Object[]> rows = (List<Object[]>) query.getResultList();

    List<ListarCentroCostoDTO> content = rows.stream()
        .map(cols -> new ListarCentroCostoDTO(
            cols[0] == null ? null : cols[0].toString(), // centroCosto
            cols[1] == null ? null : cols[1].toString(), // nombre
            cols[2] == null ? null : cols[2].toString(), // nivel
            cols[3] == null ? null : cols[3].toString(), // estado
            (Integer) cols[4], // idSede
            cols[5] == null ? null : cols[5].toString(), // nombreSede
            cols[6] == null ? null : cols[6].toString() // centroPadre
        )).toList();



    // COUNT
    String countSql = "SELECT COUNT(1) ";
    countSql = countSql.concat(sqlFROM).concat(" WHERE cc.SEC_EJEC = :entidad AND cc.ANNO = :anio");

    Query countQuery = em.createNativeQuery(countSql);
    countQuery.setParameter("entidad", params.getEntidad());
    countQuery.setParameter("anio", params.getAnio());

    long total = ((Number) countQuery.getSingleResult()).longValue();

    Pageable pageable = PageRequest.of(page, (int) (size > 0 ? size : total));
    return new PageImpl<>(content, pageable, total);
  }
}
