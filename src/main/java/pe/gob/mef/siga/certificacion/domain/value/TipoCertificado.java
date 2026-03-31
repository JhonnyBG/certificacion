package pe.gob.mef.siga.certificacion.domain.value;

public enum TipoCertificado {
  CERTIFICADO(1),
  COMPROMISO_ANUAL(2);
  
  private final Integer valor;
  
  TipoCertificado(Integer valor){
    this.valor = valor;
  }
}
