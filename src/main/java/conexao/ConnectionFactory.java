package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

    // Dados do seu banco MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/BancodeDadosMedAgende";
    private static final String USER = "root";
    private static final String PASSWORD = "30096700";

    // Método que retorna uma conexão pronta
    public static Connection getConnection() {
        try {
            // Carrega o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Retorna a conexão criada
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            throw new RuntimeException(e);

        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado!");
            throw new RuntimeException(e);
        }
    }

    // Utilitários para fechar recursos
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Erro fechando Connection: " + e.getMessage());
            }
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.err.println("Erro fechando PreparedStatement: " + e.getMessage());
            }
        }
        closeConnection(conn);
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.err.println("Erro fechando ResultSet: " + e.getMessage());
            }
        }
        closeConnection(conn, stmt);
    }
}