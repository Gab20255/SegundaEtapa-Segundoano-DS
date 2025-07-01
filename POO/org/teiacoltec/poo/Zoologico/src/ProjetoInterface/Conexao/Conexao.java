
package ProjetoInterface.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

    final private static String MYSQL_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    // Bloco estático para carregamento do driver
    static {
         // Carrega o Driver do JDBC MYSQL
        try {
            Class.forName(MYSQL_JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            System.err.println("Falha ao carregar o Driver do JDBC MySQL");
        }
    }

    static private Connection conexao = null;

    private Conexao() {}

    public static Connection obtemConexao() throws FalhaConexaoException {

        // Configurações de conexão
        String url = "jdbc:mysql://localhost:8082/coltec";
        String usuario = "root";
        String senha = "Azeitona07";

        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection(url, usuario, senha);
            }
            return conexao;
        } catch (SQLException e) {
            throw new FalhaConexaoException(e.getMessage());
        }
    }

    public static void fechaConexao() {
        try {
        if (conexao != null) conexao.close();
        } catch (SQLException e) {
            // Faço nada
        }
    }



}