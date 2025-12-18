package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;



import conexao.ConnectionFactory;

public class ConsultaDAO {
	public static void cadastrarconsulta(String Nome_Med, String Nome_Pac, Date data, LocalTime horario) {
		System.out.println("[DEUBG ConsultaDAO] Método cadastrarcosulta foi chamado");
		
		 	Connection conexao = null;
	        PreparedStatement pst = null;
	        
	        
	        
	        int Id_Medico = MedicoDAO.Buscamatriculapornome(Nome_Med);
	        int Id_Paciente = PacienteDAO.Buscapacientepornome(Nome_Pac);
	        
	        try {
	            // 1. Conectando ao bd
	            conexao = ConnectionFactory.getConnection();
	           
	            
	            
	            conexao.setAutoCommit(false);
	            
	            // 3. colocando em usuario os valores
	            String sqlusuario = "INSERT INTO `consultas`(`Matricula_Med`, `Id_Paciente`, `Data`, `Hora`) VALUES (?, ?, ?, ?)";
	            
	            pst = conexao.prepareStatement(sqlusuario);
	            pst.setInt(1, Id_Medico);
	            pst.setInt(2, Id_Paciente);
	            pst.setDate(3, data);
	            pst.setTime(4, java.sql.Time.valueOf(horario));

	            pst.executeUpdate();
	            
	            conexao.commit();
	    		System.out.println("[DEUBG ConsultaDAO] Consulta cadastrada com sucesso");
	            
	        } catch (SQLException e) {
	            try {
	                if (conexao != null) {
	                    conexao.rollback();
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	 
	            e.printStackTrace();
	            
	        } finally {
	            try {
	                if (pst != null) pst.close();
	                if (conexao != null) conexao.setAutoCommit(true);
	                if (conexao != null) conexao.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	}
	}
}

