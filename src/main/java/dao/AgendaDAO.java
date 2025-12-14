package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JOptionPane;

import conexao.ConnectionFactory;

public class AgendaDAO {
	public static void cadastradata(String Id_medico_conectado, LocalDate data, LocalTime horario_entrada, LocalTime horario_saida) {
		System.out.println("[DEBUG AgendaDAO] cadastradata foi chamado");
		Connection con = ConnectionFactory.getConnection(); 
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO agenda (matricula_medico, dia, hora_entrada, hora_saida) VALUES (?, ?, ?, ?)");
		        stmt.setString(1, Id_medico_conectado );
		        stmt.setDate(2, java.sql.Date.valueOf(data));
		        stmt.setTime(3, java.sql.Time.valueOf(horario_entrada));
		        stmt.setTime(4, java.sql.Time.valueOf(horario_saida));
		        stmt.executeUpdate();
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar!");
			
			e.printStackTrace();
		}
		finally {
			//ConnectionFactory.closeConnection(con,stmt);
		}
	}
	}

