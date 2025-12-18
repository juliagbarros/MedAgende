package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;

import conexao.ConnectionFactory;

public class EspecialidadeDAO {
	public static DefaultComboBoxModel<String> getespecialidades() {
		Connection con = ConnectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        //String debug = null;
        DefaultComboBoxModel<String> Caixa = new DefaultComboBoxModel<String>();
        
        try {
			String sql = "SELECT `Nome_Especialidade` FROM `especialidades` WHERE 1";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			//debug = ("[DEBUG] MÉTODO GETESPECIALIDADES CHAMADO, RESULTADO: ");
			
			while(rs.next()) {
				Caixa.addElement(rs.getString("Nome_especialidade"));
				//debug += (rs.getString("Nome_Especialidade") + ", ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        //System.out.println(debug);
        	return Caixa;
	}
}
