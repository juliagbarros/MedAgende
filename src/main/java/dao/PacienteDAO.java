package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexao.ConnectionFactory;

public class PacienteDAO {
	 public static int Buscapacientepornome(String Nome_Paciente) {
	    	try {
	    	Connection con = ConnectionFactory.getConnection();
	        PreparedStatement pst = null;
	        ResultSet rs = null;
	        //System.out.println("[DEBUG Buscamedicopornome] Nome do médico recebido: " + Nome_Paciente);
	        String sql = "SELECT paciente.Id_Paciente FROM paciente WHERE Nome = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, Nome_Paciente);
			rs = pst.executeQuery();
			if (rs.next()) {
	            return rs.getInt("Id_Paciente");
	        }

	        return 0; // não encontrado

	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    		return 0;
	    	}
	    }
	 
	 public static int BuscapacienteporCPF(String CPF) {
	    	try {
	    	Connection con = ConnectionFactory.getConnection();
	        PreparedStatement pst = null;
	        ResultSet rs = null;
	        //System.out.println("[DEBUG Buscamedicopornome] Nome do médico recebido: " + Nome_Paciente);
	        String sql = "SELECT paciente.Id_Paciente FROM paciente WHERE CPF = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, CPF);
			rs = pst.executeQuery();
			if (rs.next()) {
	            return rs.getInt("Id_Paciente");
	        }

	        return 0; // não encontrado

	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
	    		return 0;
	    	}
	    }

}
