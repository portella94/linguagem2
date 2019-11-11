package Entidades.Enumeradores;
// ISO/IEC 5218
public enum Sexo {

    DESCONHECIDO(0),
    HOMEM(1),
    MULHER(2),
    NAO_APLICAVEL(9);
    
    private final int value;
    private Sexo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
//    public void setSexo(int valor){
//        this.valor = valor;
//    }

}
