package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import conexao.ConnectionFactory;
import model.Medico;

public class MedicoDAO {

    public void atualizarMedico(Connection con, int id, String crm, String rqe, int especialidade) throws Exception {

        String sql = "UPDATE medico SET CRM = ?, Rqe = ?, Especialidade = ? WHERE Id_Usuario = ? ";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, crm);
        stmt.setString(2, rqe);
        stmt.setInt(3, especialidade);
        stmt.setInt(4, id);
        
        stmt.executeUpdate();
    }
    
    public void deletarMedico(Connection con, int id) throws Exception {
    	
    	String sql = "DELETE FROM medico WHERE Id_Usuario = ?";
    	PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    
    }
    
    public Medico buscarMedico(int idUsuario) throws Exception {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT CRM, Rqe, Especialidade FROM medico WHERE Id_Usuario = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Medico m = new Medico();
                m.setCrm(rs.getString("CRM"));
                m.setRqe(rs.getString("Rqe"));
                m.setEspecialidade(rs.getString("Especialidade"));
                return m;
            }
            return null;

        } finally {
            //ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }

    public static Medico criamedicoconectado(String id) throws Exception {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM usuarios INNER JOIN medico ON usuarios.Id_usuario = medico.Id_Usuario WHERE usuarios.Id_usuario = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);

            rs = pst.executeQuery();

            if (rs.next()) {
            	
                Medico medico_conectado = new Medico();
                medico_conectado.setIdUsuario(rs.getInt("Id_Usuario"));
                medico_conectado.setNome(rs.getString("Nome"));
                medico_conectado.setEmail(rs.getString("Email"));
                medico_conectado.setTelefone(rs.getString("Telefone"));
                medico_conectado.setCpf(rs.getString("CPF"));
                medico_conectado.setRua(rs.getString("Rua"));
                medico_conectado.setBairro(rs.getString("Bairro"));
                medico_conectado.setCidade(rs.getString("Cidade"));
                medico_conectado.setCep(rs.getString("CEP"));
                medico_conectado.setServico(rs.getString("Servíco"));
                medico_conectado.setDataNasc(rs.getDate("Data_Nasc"));
                medico_conectado.setMatricula(rs.getString("Matricula"));
                medico_conectado.setEspecialidade(rs.getString("Especialidade"));
                medico_conectado.setCrm(rs.getString("CRM"));
                medico_conectado.setRqe(rs.getString("Rqe"));
                
                
                System.out.println(" médico cadastrado com sucesso");
                
                return medico_conectado;
            }

            return null;

        } finally {
            //ConnectionFactory.closeConnection(con, pst, rs);
        }
}
    public static ComboBoxModel<String> Buscamedicoporespecialidade(int Id_Especialidade){
    	Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        //String debug = null;
        DefaultComboBoxModel<String> Caixa = new DefaultComboBoxModel<String>();
        
        try {
			String sql = "SELECT usuarios.Nome, medico.Id_Usuario, especialidades.Nome_Especialidade FROM usuarios INNER JOIN medico ON usuarios.Id_Usuario = medico.Id_Usuario INNER JOIN especialidades ON medico.Especialidade = especialidades.Id_Especialidade WHERE especialidades.Id_Especialidade = ? ORDER BY usuarios.Nome";
			pst = con.prepareStatement(sql);
			pst.setInt(1, Id_Especialidade);
			rs = pst.executeQuery();
			//debug = ("[DEBUG] MÉTODO GETESPECIALIDADES CHAMADO, RESULTADO: ");
			
			while(rs.next()) {
				Caixa.addElement(rs.getString("Nome"));
				//debug += (rs.getString("Nome_Especialidade") + ", ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        //System.out.println(debug);
        	return Caixa;
	}  
    
    public static int Buscamedicopornome(String Nome_Medico) {
    	try {
    	Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        System.out.println("[DEBUG Buscamedicopornome] Nome do médico recebido: " + Nome_Medico);
        String sql = "SELECT usuarios.Id_Usuario FROM usuarios WHERE Nome = ?";
		pst = con.prepareStatement(sql);
		pst.setString(1, Nome_Medico);
		rs = pst.executeQuery();
		if (rs.next()) {
            return rs.getInt("Id_Usuario");
        }

        return 0; // não encontrado

    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		return 0;
    	}
    }
    
    public static int Buscamatriculapornome(String Nome_Medico) {
    	try {
    	Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        System.out.println("[DEBUG Buscamedicopornome] Nome do médico recebido: " + Nome_Medico);
        String sql = "SELECT usuarios.Nome, medico.Matricula FROM medico\r\n"
        		+ "INNER JOIN usuarios ON medico.Id_Usuario = usuarios.Id_Usuario\r\n"
        		+ "WHERE Nome = ?";
		pst = con.prepareStatement(sql);
		pst.setString(1, Nome_Medico);
		rs = pst.executeQuery();
		if (rs.next()) {
            return rs.getInt("Matricula");
        }

        return 0; // não encontrado

    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		return 0;
    	}
    }


}
