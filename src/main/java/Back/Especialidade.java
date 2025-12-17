package Back;
import javax.swing.DefaultComboBoxModel;
import dao.EspecialidadeDAO;

public class Especialidade {
	public DefaultComboBoxModel<String> buscaEspecialidades() throws Exception {
        EspecialidadeDAO dao = new EspecialidadeDAO();
        return dao.getespecialidades();
    }
}
