package BaseDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO {

    protected Connection con;// objeto connection que será usado nos métodos abaixo

    // Metodo base para cadastrar
    public boolean Cadastrar(Object objeto) throws Exception {
        return true;
    }

    // Metodo base para deletar
    public boolean Deletar(Object objeto) throws Exception {
        return true;
    }

    // Metodo base para atualizar
    public boolean Atualizar(Object objeto) throws Exception {
        return true;
    }
}
