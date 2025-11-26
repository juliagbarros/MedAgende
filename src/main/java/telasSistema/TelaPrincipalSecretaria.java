package telasSistema;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;

public class TelaPrincipalSecretaria extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaPrincipalSecretaria() {
		setBounds(100, 100, 742, 454);
		getContentPane().setBackground(new Color(170, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 253, 255));
		panel.setBounds(0, 1, 729, 417);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBoasVindas = new JLabel("Bem-Vindo(a)! O que deseja fazer?");
		lblBoasVindas.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblBoasVindas.setBounds(110, 21, 511, 54);
		panel.add(lblBoasVindas);
		
		JList<String> listOpcoes = new JList<String>();
		listOpcoes.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Agendar Consulta", "Cancelar Consulta", "Reagendar Consulta", "Cadastrar Novo Paciente"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		listOpcoes.setBounds(260, 143, 199, 78);
		panel.add(listOpcoes);
		
		JButton BotaoProximo = new JButton("Proximo");
		BotaoProximo.setBounds(324, 312, 84, 20);
		panel.add(BotaoProximo);

	}
}
