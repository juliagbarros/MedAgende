package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexao.ConnectionFactory;
import model.Usuario;
import Back.Crypto;


public class UsuarioDAO {
	public void create(Usuario u) {
		
		Connection con = ConnectionFactory.getConnection(); 
		PreparedStatement stmt = null;
		
		try {
			// Garantir que a senha esteja em hash bcrypt antes de gravar
			if (u.getSenha() != null) {
				String s = u.getSenha();
				boolean looksLikeBcrypt = s.startsWith("$2a$") || s.startsWith("$2b$") || s.startsWith("$2y$");
				if (!looksLikeBcrypt) {
					Crypto crypto = new Crypto();
					String hashed = crypto.gerarHashBCrypt(s);
					// armazena o hash diretamente no objeto para evitar re-hash posterior
					u.setSenhaHash(hashed);
				}
			}
			
			stmt = con.prepareStatement("INSERT INTO usuarios (Email, Senha, Nome, CPF, Data_Nasc, Bairro, Rua, Num_Casa, Cidade, Servíço, Plano_De_Saude, CEP, Telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)");
		        stmt.setString(1, u.getEmail());
		        stmt.setString(2, u.getSenha());
		        stmt.setString(3, u.getNome());
		        stmt.setString(4, u.getCpf());
		        stmt.setDate(5, u.getDataNasc());
		        stmt.setString(6, u.getBairro());
		        stmt.setString(7, u.getRua());
		        stmt.setString(8, u.getNumCasa());
		        stmt.setString(9, u.getCidade());
		        stmt.setString(10, u.getServico());
		        stmt.setString(11, u.getPlanoDeSaude());
		        stmt.setString(12, u.getCep());
		        stmt.setString(13, u.getTelefone());
		        stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "Erro ao salvar!");
			
			e.printStackTrace();
		} 
		finally {
			ConnectionFactory.closeConnection(con,stmt);
		}
	}

}