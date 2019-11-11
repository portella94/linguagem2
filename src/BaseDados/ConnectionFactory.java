package BaseDados;

import Entidades.Parametros;
import Entidades.Sessao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Parametros parametros;

    public ConnectionFactory() {
        this.parametros = Sessao.GetInstance().getParametros();
    }

    public static Connection createConnection() throws SQLException {
        String url = "jdbc:mysql://" + parametros.getServer() + ":" + parametros.getPorta() + "/" + parametros.getDatabase();
        String user = "sIxh05JdC7"; //nome do usuário do MySQL
        String password = "3PhWMPjJY7"; //senha do MySQL

        Connection conexao = null;
        conexao = DriverManager.getConnection(url, user, password);

        return conexao;
    }
}
