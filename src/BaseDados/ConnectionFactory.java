package BaseDados;

import Entidades.Parametros;
import Entidades.Sessao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public ConnectionFactory() {
    }

    public static Connection createConnection() throws Exception {
        String url = "jdbc:mysql://" + getServer() + ":" + getPort() + "/" + getDatabase()
                + "?useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
        String user = "sIxh05JdC7"; // nome do usuário do MySQL
        String password = "3PhWMPjJY7"; // senha do MySQL

        Connection conexao = null;
        conexao = DriverManager.getConnection(url, user, password);

        return conexao;
    }

    private static String getServer() {
        return Sessao.GetInstance().getParametros().getServer();
    }

    private static String getPort() {
        return Sessao.GetInstance().getParametros().getPort();
    }

    private static String getDatabase() {
        return Sessao.GetInstance().getParametros().getDatabase();
    }    
}
