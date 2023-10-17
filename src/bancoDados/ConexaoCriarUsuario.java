package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoCriarUsuario {

    public Connection connection = null;
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

   
    public void AdicionarUsuario(String nome, String usuario, String senha,String tipo) {

        try {
            String query = "INSERT INTO usuario(nome,usuario,senha,tipo) VALUES ('" + nome + "','" + usuario + "','" + senha + "','"+tipo+"'); ";
            this.statement.execute(query);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public boolean verificaClientes(String usuario) {
        try {

            String query = "SELECT * FROM usuario WHERE usuario = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, usuario);
            ResultSet result = stmt.executeQuery();

            boolean resultado = result.isBeforeFirst();

            return resultado;

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());

        }
        return false;

    }
    
    public void EditarUsuario(String id, String nome, String usuario, String senha, String tipo) {
        try {
            String query = "UPDATE usuario SET nome='" + nome + "', usuario = '" + usuario + "',senha='" + senha + "',tipo ='"+tipo+"' WHERE id = '" + id + "';";
            this.statement.execute(query);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
     public void ApagarCliente(String id) {
        try {
            String query = "DELETE FROM usuario WHERE id= '" + id + "';";
            this.statement.execute(query);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }



  

    public void DesconectarBanco() {

        try {
            this.connection.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

}
