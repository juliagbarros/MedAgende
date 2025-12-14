package Back;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conexao.ConnectionFactory;
import dao.UsuarioDAO;
import model.Usuario;

public class Usuarios {

    public Usuario buscarUsuarioPorCpf(String cpf) throws Exception {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.buscarPorCpf(cpf);
    }
    
    public static Usuario criausuarioconectado(String id) throws Exception {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM usuarios WHERE Id_Usuario = ?";
            pst = con.prepareStatement(sql);
            pst.setString(1, id);

            rs = pst.executeQuery();

            if (rs.next()) {
                Usuario usuario_conectado = new Usuario();
                usuario_conectado.setIdUsuario(rs.getInt("Id_Usuario"));
                usuario_conectado.setNome(rs.getString("Nome"));
                usuario_conectado.setEmail(rs.getString("Email"));
                usuario_conectado.setTelefone(rs.getString("Telefone"));
                usuario_conectado.setCpf(rs.getString("CPF"));
                usuario_conectado.setRua(rs.getString("Rua"));
                usuario_conectado.setBairro(rs.getString("Bairro"));
                usuario_conectado.setCidade(rs.getString("Cidade"));
                usuario_conectado.setCep(rs.getString("CEP"));
                usuario_conectado.setServico(rs.getString("Servíco"));
                usuario_conectado.setDataNasc(rs.getDate("Data_Nasc"));
                return usuario_conectado;
            }

            return null;

        } finally {
            //ConnectionFactory.closeConnection(con, pst, rs);
        }
    }
}
