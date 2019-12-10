package Negocio;

import Entidades.Sessao;

public abstract class BaseNG {
    /// <summary>
    /// Sessao do usuario e parametros
    /// </summary>
    protected Sessao sessao;

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public BaseNG(Sessao sessao) {
        this.setSessao(sessao);        
    }

    public BaseNG() {
    }
}