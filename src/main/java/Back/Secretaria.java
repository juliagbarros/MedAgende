package Back;

import java.sql.Connection;
import conexao.ConnectionFactory;
import dao.UsuarioDAO;
import model.Usuario;

public class Secretaria {

    public void editarSecretaria(Usuario usuario) throws Exception {

        Connection con = ConnectionFactory.getConnection();

        try {
            con.setAutoCommit(false);

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.atualizarUsuario(con, usuario);

            con.commit();

        } catch (Exception e) {
            con.rollback();
            throw e;

        } finally {
            con.setAutoCommit(true);
        }
    }

    public void deletarSecretaria(int idUsuario) throws Exception {

        Connection con = ConnectionFactory.getConnection();

        try {
            con.setAutoCommit(false);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.deletarUsuario(con, idUsuario);
            con.commit();
            
        } 
        catch (Exception e) {
           con.rollback();
           throw e;

        } 
        finally {
           con.setAutoCommit(true);
        }
    }
}
