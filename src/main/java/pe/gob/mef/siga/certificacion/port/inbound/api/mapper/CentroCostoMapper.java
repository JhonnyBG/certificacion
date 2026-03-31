package pe.gob.mef.siga.certificacion.port.inbound.api.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import pe.gob.mef.siga.certificacion.port.inbound.api.dto.ListarCentroCostoResponse;
import pe.gob.mef.siga.certificacion.view.dto.ListarCentroCostoDTO;
import pe.gob.mef.siga.certificacion.view.projection.ListarCentroCostoProjection;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CentroCostoMapper {

  @Mapping(source = "centroCosto", target = "centroCostoCodigo")
  @Mapping(source = "nombre", target = "centroCostoNombre")
  @Mapping(source = "idSede", target = "sedeCodigo")
  @Mapping(source = "centroPadre", target = "centroCostoPadre")
  @Mapping(source = "nombreSede", target = "sedeDescripcion")
  @Mapping(source = "estado", target = "estado")
  ListarCentroCostoResponse toResponse(ListarCentroCostoProjection listaCentroCostoProjection);

  @Mapping(source = "codigo", target = "centroCostoCodigo")
  @Mapping(source = "nombre", target = "centroCostoNombre")
  @Mapping(source = "idSede", target = "sedeCodigo")
  @Mapping(source = "centroPadre", target = "centroCostoPadre")
  @Mapping(source = "nombreSede", target = "sedeDescripcion")
  @Mapping(source = "estado", target = "estado")
  List<ListarCentroCostoResponse> toResponseList(List<ListarCentroCostoProjection> list);
  
  @Mapping(source = "centroCosto", target = "centroCostoCodigo")
  @Mapping(source = "nombre", target = "centroCostoNombre")
  @Mapping(source = "centroPadre", target = "centroCostoPadre")
  @Mapping(source = "nivel", target = "nivel")
  @Mapping(source = "idSede", target = "sedeCodigo")
  @Mapping(source = "nombreSede", target = "sedeDescripcion")
  @Mapping(source = "estado", target = "estado")
  ListarCentroCostoResponse toResponse(ListarCentroCostoDTO dto);

}


