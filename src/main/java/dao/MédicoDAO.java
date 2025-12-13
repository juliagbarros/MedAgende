package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import conexao.ConnectionFactory;
import Back.Médico;

public class MédicoDAO {
    public void create (Médico m) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO usuarios (Email, Senha, Nome, CPF, Data_Nasc, Bairro, Rua, Num_Casa, Cidade, Servíco, Plano_De_Saude, CEP, Telefone, CRM, RQE, Especialidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?)");
            stmt.setString(1, m.getEmail());
            stmt.setString(2, m.getSenha());
            stmt.setString(3, m.getNome());
            stmt.setString(4, m.getCpf());
            stmt.setDate(5, m.getDataNasc());
            stmt.setString(6, m.getBairro());
            stmt.setString(7, m.getRua());
            stmt.setString(8, m.getNumCasa());
            stmt.setString(9, m.getCidade());
            stmt.setString(10, m.getServico());
            stmt.setString(11, m.getPlanoDeSaude());
            stmt.setString(12, m.getCep());
            stmt.setString(13, m.getTelefone());
            stmt.setString(14, m.getCRM());
            stmt.setString(15, m.getRQE());
            stmt.setString(16, m.getEspecialidade());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con,stmt);
        }
    }
}