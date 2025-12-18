package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import conexao.ConnectionFactory;
import model.Medico;

public class MédicoDAO {
    public void create(Medico m) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmtUsuario = null;
        PreparedStatement stmtMedico = null;
        ResultSet rs = null;

        try {
            con.setAutoCommit(false); // Inicia transação

            // 1. Inserir na tabela usuarios
            stmtUsuario = con.prepareStatement(
                "INSERT INTO usuarios (Email, Senha, Nome, CPF, Data_Nasc, Bairro, Rua, Num_Casa, Cidade, Uf, Servíco, Plano_De_Saude, CEP, Telefone) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
            );
            
            stmtUsuario.setString(1, m.getEmail());
            stmtUsuario.setString(2, m.getSenha());
            stmtUsuario.setString(3, m.getNome());
            stmtUsuario.setString(4, m.getCpf());
            stmtUsuario.setDate(5, m.getDataNasc());
            stmtUsuario.setString(6, m.getBairro());
            stmtUsuario.setString(7, m.getRua());
            stmtUsuario.setString(8, m.getNumCasa());
            stmtUsuario.setString(9, m.getCidade());
            stmtUsuario.setString(10, m.getUf());
            stmtUsuario.setString(11, "Médico"); 
            stmtUsuario.setString(12, m.getPlanoDeSaude());
            stmtUsuario.setString(13, m.getCep());
            stmtUsuario.setString(14, m.getTelefone());
            
            stmtUsuario.executeUpdate();
            
           
            rs = stmtUsuario.getGeneratedKeys();
            int idUsuario = 0;
            if (rs.next()) {
                idUsuario = rs.getInt(1);
            }
            
            
            stmtMedico = con.prepareStatement(
                "INSERT INTO medico (Id_Usuario, Especialidade, Crm, Situacao, Rqe) " +
                "VALUES (?, ?, ?, ?, ?)"
            );
            
            
            int idEspecialidade = getIdEspecialidade(m.getEspecialidade());
            
            stmtMedico.setInt(1, idUsuario);
            stmtMedico.setInt(2, idEspecialidade);
            stmtMedico.setString(3, m.getCrm());
            stmtMedico.setString(4, "ativo"); // Situação padrão
            stmtMedico.setString(5, m.getRqe());
            
            stmtMedico.executeUpdate();
            
            con.commit(); // Confirma transação
            JOptionPane.showMessageDialog(null, "Médico cadastrado com sucesso!");

        } catch (SQLException e) {
            try {
                con.rollback(); // Reverte em caso de erro
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar médico!");
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(con, stmtUsuario);
            if (stmtMedico != null) {
                try { stmtMedico.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }
    
    // Método auxiliar para obter ID da especialidade (implemente conforme sua lógica)
    private int getIdEspecialidade(String nomeEspecialidade) {
        // Implemente a busca do ID da especialidade na tabela especialidades
        // Pode ser uma consulta ao banco ou um mapa estático
        return 1; // Retorno temporário
    }
}