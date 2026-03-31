package pe.gob.mef.siga.certificacion.domain.value;

public enum TipoCertificado {
  CERTIFICADO(1),
  COMPROMISO_ANUAL(2);
  
  private final Integer valor;
  
  TipoCertificado(Integer valor){
    this.valor = valor;
  }
  
  public Integer getValor() {
    return valor;
  }
  
  public static TipoCertificado from(Integer valor) {
    for (TipoCertificado t : values()) {
        if (t.valor.equals(valor)) {
            return t;
        }
    }
    throw new IllegalArgumentException("Tipo de certificado inválido: " + valor);
  }
}
