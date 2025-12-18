package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {

    // Dados do seu banco MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/medagendebd";
    private static final String USER = "root";
    private static final String PASSWORD = "And30hei06@";

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

	public static void closeConnection(Connection con, PreparedStatement stmt) {
		// TODO Auto-generated method stub
		
	}
}
