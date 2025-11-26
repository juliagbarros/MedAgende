package telasSistema;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		listOpcoes.setBackground(new Color(255, 255, 255));
		listOpcoes.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
		listOpcoes.setBounds(186, 136, 349, 113);
		panel.add(listOpcoes);
		
		JButton BotaoProximo = new JButton("Proximo");
		BotaoProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcaoSelecionada= listOpcoes.getSelectedValue();
				
				if (opcaoSelecionada==null) {
					JOptionPane.showMessageDialog(BotaoProximo, "Selecione alguma opção!");
				}
				
				switch (opcaoSelecionada) {
				case "Agendar Consulta":
					new TelaSecretariaAgendar().setVisible(true);
					dispose();
					break;
					
				case "Cancelar Consulta":
					new TelaSecretariaCancelar().setVisible(true);
					dispose();
					break;
					
				case "Reagendar Consulta":
					new TelaSecretariaReagendar().setVisible(true);
					dispose();
					break;
					
				case "Cadastrar Novo Paciente":
					new TelaSecretariaCadastrar().setVisible(true);
					dispose();
					break;
				}
			
			}
			
		});
		BotaoProximo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		BotaoProximo.setBounds(282, 312, 126, 32);
		panel.add(BotaoProximo);
		

	}
}
