package Entidades;

import Entidades.Enumeradores.EstadoCivil;
import Entidades.Enumeradores.Sexo;
import Entidades.ObjetoGenerico;

public class Pessoa extends ObjetoGenerico {

    private String email;

    private int sexo;

    private int estadoCivil;

    private boolean maior18;

    private String escolaridade;

    private String outrasInformacoes;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public boolean isMaior18() {
        return maior18;
    }

    public void setMaior18(boolean maior18) {
        this.maior18 = maior18;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getOutrasInformacoes() {
        return outrasInformacoes;
    }

    public void setOutrasInformacoes(String outrasInformacoes) {
        this.outrasInformacoes = outrasInformacoes;
    }

}
