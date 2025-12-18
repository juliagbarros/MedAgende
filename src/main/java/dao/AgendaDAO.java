package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
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
	
	public static ComboBoxModel<Date> getmedicoagenda(int Id_Medico){
		Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
       
        DefaultComboBoxModel<Date> Caixa = new DefaultComboBoxModel<Date>();
        
        try {
			String sql = "SELECT usuarios.Nome, medico.Id_Usuario, agenda.dia\r\n"
					+ "FROM usuarios\r\n"
					+ "INNER JOIN medico ON usuarios.Id_Usuario = medico.Id_Usuario \r\n"
					+ "INNER JOIN agenda ON medico.Matricula = agenda.matricula_medico\r\n"
					+ "WHERE medico.Id_Usuario = ? \r\n"
					+ "ORDER BY agenda.dia";
			

			pst = con.prepareStatement(sql);
			pst.setInt(1, Id_Medico);
			rs = pst.executeQuery();
			//debug = ("[DEBUG] MÉTODO GETESPECIALIDADES CHAMADO, RESULTADO: ");
			
			while(rs.next()) {
				Caixa.addElement(rs.getDate("dia"));
				//debug += (rs.getString("Nome_Especialidade") + ", ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        //System.out.println(debug);
        	return Caixa;
	}
	
	public static ComboBoxModel<LocalTime> Buscahorariopordata(Date data){
		Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        DefaultComboBoxModel<LocalTime> Caixa = new DefaultComboBoxModel<LocalTime>();
        
        try {
			String sql = "SELECT agenda.hora_entrada, agenda.hora_saida FROM agenda WHERE dia = ?";
			

			pst = con.prepareStatement(sql);
			pst.setDate(1, data);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				LocalTime horario_entrada = rs.getTime("hora_entrada").toLocalTime();
				LocalTime horario_saida = rs.getTime("hora_saida").toLocalTime();
				
				LocalTime horario = horario_entrada;
				while (horario != horario_saida.minusHours(1)) {
					horario = horario.plusHours(1);
					//System.out.println("[DEBUG Buscarhorariopordata] método chamado, horário registrado: " + horario);
					Caixa.addElement(horario);	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        //System.out.println(debug);
        	return Caixa;
	
		
}
		
}

