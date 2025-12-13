package Back;

import dao.UsuarioDAO;
import model.Usuario;

public class Usuarios {

    public Usuario buscarUsuarioPorCpf(String cpf) throws Exception {
        UsuarioDAO dao = new UsuarioDAO();
        return dao.buscarPorCpf(cpf);
    }
}
