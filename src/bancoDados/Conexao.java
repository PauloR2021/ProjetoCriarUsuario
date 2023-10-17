package bancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

    public Connection connection = null;
    public Statement statement = null;
    public ResultSet resultset = null;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultset() {
        return resultset;
    }

    public void setResultset(ResultSet resultset) {
        this.resultset = resultset;
    }

    public void conectar() {
        String servidor = "jdbc:mysql://localhost:3306/cadastro_clientes";
        String usuario = "root";
        String senha = "Pr_16112001";
        String driver = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driver);
            this.connection = DriverManager.getConnection(servidor, usuario, senha);
            this.statement = this.connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public boolean estaConectado() {
        return this.connection != null;
    }

    public boolean verificaClientes(String usuario) {
        try {

            String query = "SELECT * FROM cliente WHERE usuario = ?";
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

    public void AdicionarCliente(String nome, String usuario, String senha) {

        try {
            String query = "INSERT INTO cliente(nome,usuario,senha) VALUES ('" + nome + "','" + usuario + "','" + senha + "'); ";
            this.statement.execute(query);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void EditarCliente(String id, String nome, String usuario, String senha) {
        try {
            String query = "UPDATE cliente SET nome='" + nome + "', usuario = '" + usuario + "',senha='" + senha + "' WHERE id = '" + id + "';";
            this.statement.execute(query);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void ApagarCliente(String id) {
        try {
            String query = "DELETE FROM cliente WHERE id= '" + id + "';";
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
