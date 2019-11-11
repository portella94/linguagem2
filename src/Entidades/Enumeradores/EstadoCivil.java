package Entidades.Enumeradores;
// ISO/IEC 5218
public enum EstadoCivil {
    SOLTEIRO(0),
    CASADO(1);
    
    private final int value;
    private EstadoCivil(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
    
    
//    public void setEstadoCivil(int valor){
//        this.valor = valor;
//    }
