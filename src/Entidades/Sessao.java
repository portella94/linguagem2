package Entidades;

public final class Sessao {

    private static Sessao Instance;

    private Usuario usuario;

    private Parametros parametros;

    public Sessao() {
    }

    public Sessao(Parametros parametros) {
        this.Instance = new Sessao();
        this.Instance.parametros = parametros;
    }

    public static Sessao GetInstance() {
        if (Instance == null) {
            Instance = new Sessao();
        }
        return Instance;
    }

    public Parametros getParametros() {
        return parametros;
    }

    public void setParametros(Parametros parametros) {
        this.parametros = parametros;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
