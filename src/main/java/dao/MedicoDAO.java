package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
                
                
                System.out.println("[DEBUG MedicoDAO] médico cadastrado com sucesso");
                
                return medico_conectado;
            }

            return null;

        } finally {
            //ConnectionFactory.closeConnection(con, pst, rs);
        }
}

}
