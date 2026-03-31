package pe.gob.mef.siga.certificacion.view.dto;

public record ListarCentroCostoDTO(
    String centroCosto, 
    String nombre, 
    String nivel, 
    String estado,
    Integer idSede, 
    String nombreSede, 
    String centroPadre
) {};

