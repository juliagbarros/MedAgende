package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import conexao.ConnectionFactory;
import model.Usuario;


public class UsuarioDAO {
	public void create(Usuario u) {
		
		Connection con = ConnectionFactory.getConnection(); 
		PreparedStatement stmt = null;
		
		try {

			
			stmt = con.prepareStatement("INSERT INTO usuarios (Email, Senha, Nome, CPF, Data_Nasc, Bairro, Rua, Num_Casa, Cidade, Uf, Servíco, Plano_De_Saude, CEP, Telefone) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)");
		        stmt.setString(1, u.getEmail());
		        stmt.setString(2, u.getSenha());
		        stmt.setString(3, u.getNome());
		        stmt.setString(4, u.getCpf());
		        stmt.setDate(5, u.getDataNasc());
		        stmt.setString(6, u.getBairro());
		        stmt.setString(7, u.getRua());
		        stmt.setString(8, u.getNumCasa());
		        stmt.setString(9, u.getCidade());
		        stmt.setString(10, u.getUf());
		        stmt.setString(11, u.getServico());
		        stmt.setString(12, u.getPlanoDeSaude());
		        stmt.setString(13, u.getCep());
		        stmt.setString(14, u.getTelefone());

		        stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar!");
			
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
	}
	public Usuario buscarPorCpf(String cpf) throws Exception {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM usuarios WHERE CPF = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, cpf);

            rs = pst.executeQuery();

            if (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("Id_Usuario"));
                u.setNome(rs.getString("Nome"));
                u.setEmail(rs.getString("Email"));
                u.setTelefone(rs.getString("Telefone"));
                u.setCpf(rs.getString("CPF"));
                u.setRua(rs.getString("Rua"));
                u.setNumCasa(rs.getString("Num_Casa"));
                u.setBairro(rs.getString("Bairro"));
                u.setCidade(rs.getString("Cidade"));
                u.setUf(rs.getString("Uf"));
                u.setCep(rs.getString("CEP"));
                u.setServico(rs.getString("Servíco"));
                u.setPlanoDeSaude(rs.getString("Plano_De_Saude"));
                u.setDataNasc(rs.getDate("Data_Nasc"));
                return u;
            }
            return null;

        } finally {
            ConnectionFactory.closeConnection(con, pst);
        }
    }
    
    public void atualizarUsuario(Connection con, Usuario u) throws Exception {

        String sql = "UPDATE usuarios SET Nome = ?, Email = ?, Data_Nasc=?, Telefone = ?, Rua = ?, Bairro = ?, Num_Casa =?, Cidade = ?, Uf = ?, CEP = ?, Plano_De_Saude = ?, Senha=? WHERE CPF = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getEmail());
        stmt.setDate(3, u.getDataNasc());
        stmt.setString(4, u.getTelefone());
        stmt.setString(5, u.getRua());
        stmt.setString(6, u.getBairro());
        stmt.setString(7, u.getNumCasa());
        stmt.setString(8, u.getCidade());
        stmt.setString(9, u.getUf());
        stmt.setString(10, u.getCep());
        stmt.setString(11, u.getPlanoDeSaude());
        stmt.setString(12, u.getSenha());
        stmt.setString(13, u.getCpf());

        stmt.executeUpdate();
    }
    
    public void deletarUsuario(Connection con, int id) throws Exception {

        String sql = "DELETE FROM usuarios WHERE Id_Usuario = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);

        stmt.executeUpdate();
    }
}