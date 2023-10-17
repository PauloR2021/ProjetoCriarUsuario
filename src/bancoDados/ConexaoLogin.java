package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoLogin {

    private Connection connection = null;
    private Statement statement = null;
    private final ResultSet resultset = null;

    public void conectar() {
        String servidor = "jdbc:mysql://localhost:3306/cadastro_clientes";
        String usuario = "root";
        String senha = "Pr_16112001";
        String driver = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(servidor, usuario, senha);
            this.statement = this.connection.createStatement();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public boolean estaConectado() {
        return this.connection != null;
    }

   
    public boolean VerificandoUsuarioAdm(String usuario,String senha) {
        try {

            String query =  "SELECT * FROM usuario WHERE usuario = '"+usuario+"' and senha = '"+senha+"' and tipo = 'adm'";
            PreparedStatement stmt = connection.prepareStatement(query);
            
            ResultSet result = stmt.executeQuery();
            
            

            return result.isBeforeFirst();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

        }
        return false;

    }
    
    public boolean VerificandoUsuarioComum(String usuario,String senha) {
        try {

            String query =  "SELECT * FROM usuario WHERE usuario = '"+usuario+"' and senha = '"+senha+"' and tipo='user'";
            PreparedStatement stmt = connection.prepareStatement(query);
            
            ResultSet result = stmt.executeQuery();
            
            

            return result.isBeforeFirst();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

        }
        return false;

    }


  

    public void DesconectarBanco() {

        try {
            this.connection.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

}
