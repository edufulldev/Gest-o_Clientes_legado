package edu.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

    private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException
    {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassCastException | ClassNotFoundException ex) {
            throw new SQLException("Driver do H2 não encontrado na aplicação", ex);
        }
        Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
        criarTabelaSeNaoExistir(connection);
        return connection;
    }

    private static void criarTabelaSeNaoExistir(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS clientes (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "nome VARCHAR(100) NOT NULL, " +
                "email VARCHAR(100) NOT NULL, " +
                "telefone VARCHAR(20) NOT NULL)";
        try(Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
