
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Driver_manager {
    final private static String MYSQL_JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    final private static int DB_PORT=8080;
    final private static String DB_HOST="localhost";
    final private static String DB_NAME="COLTEC";
    private String url;
    private String user;
    private String password;
    Driver_manager(String user, String password){
        this.user=user;
        this.password=password;
        this.url="jdbc:mysql://"+DB_HOST+":"+DB_PORT+"/"+DB_NAME;
    }

    public void Realizar_conexao(){
        try{
            Class.forName(MYSQL_JDBC_DRIVER);
            System.out.println("Driver carregado");
        
        }
        catch(ClassNotFoundException e){
            System.out.println("Driver não encontrado: "+e.getMessage());
        }
        try{
            Connection conexao= DriverManager.getConnection(url, user, password);

            Statement statement= conexao.createStatement();
            ResultSet tabelaAlunos= statement.executeQuery("SELECT * FROM Alunos");
            while(tabelaAlunos.next()){
                System.out.println("Matricula: "+tabelaAlunos.getInt("matricula"));
                System.out.println("Nome: "+tabelaAlunos.getString("nome"));
                System.out.println("Idade: "+tabelaAlunos.getString("idade"));
                System.out.println("Curso: "+tabelaAlunos.getString("curso"));
                System.out.println("Senha: "+tabelaAlunos.getString("senha"));
                System.out.println("---------------------");
            }
            tabelaAlunos.close();
            statement.close();
            conexao.close();
        }
        catch(Exception e){
            System.out.println("Erro ao conectar: "+e.getMessage());
        }
    }
}
