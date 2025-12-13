package Back;

import java.sql.Connection;

import dao.MedicoDAO;
import dao.UsuarioDAO;
import conexao.ConnectionFactory;
import model.Usuario;

public class Médico {

    public void editarMedico(Usuario usuario, String crm, String rqe, int especialidade) throws Exception {

        Connection con = ConnectionFactory.getConnection();

        try {
            con.setAutoCommit(false);

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.atualizarUsuario(con, usuario);

            MedicoDAO medicoDAO = new MedicoDAO();
            medicoDAO.atualizarMedico(con, usuario.getIdUsuario(),crm, rqe,especialidade);

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
    public void deletarMedico(int id) throws Exception {

        Connection con = ConnectionFactory.getConnection();

        try {
            con.setAutoCommit(false);

            MedicoDAO medicoDAO = new MedicoDAO();
            medicoDAO.deletarMedico(con, id);

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            usuarioDAO.deletarUsuario(con, id);

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
