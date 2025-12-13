package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MedicoDAO {

    public void atualizarMedico(Connection con, int id, String crm, String rqe, int especialidade) throws Exception {

        String sql = "UPDATE medico SET Crm = ?, Rqe = ?, Especialidade = ? WHERE Id_Usuario = ? ";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, crm);
        stmt.setString(2, rqe);
        stmt.setInt(3, especialidade);
        stmt.setInt(4, id);
        
        stmt.executeUpdate();
    }
}
