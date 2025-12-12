package telasSistema.Administrador;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

import telasSistema.TelaInicial.TelaLogin;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipalAdministrador extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaPrincipalAdministrador() {
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
		lblBoasVindas.setBounds(161, 21, 511, 54);
		panel.add(lblBoasVindas);
		
		JList<String> listOpcoes = new JList<String>();
		listOpcoes.setBackground(new Color(240, 240, 240));
		listOpcoes.setFont(new Font("Trebuchet MS", Font.PLAIN, 27));
		listOpcoes.setModel(new AbstractListModel() {
			String[] values = new String[] {"Gestão de usuários", "Configuração de horários e funcionamento", "Cadastro de Secretária(o)", "Cadastro de médicos"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listOpcoes.setBounds(138, 110, 516, 184);
		panel.add(listOpcoes);
		
		JButton BotaoProximo = new JButton("Proximo");
		BotaoProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcaoSelecionada= listOpcoes.getSelectedValue().trim();
				
				if (opcaoSelecionada==null) {
					JOptionPane.showMessageDialog(BotaoProximo, "Selecione alguma opção!");
				}
				
				switch (opcaoSelecionada) {
				case "Gestão de usuários":
					
					TelaAdministradorGestaoUsuarios tela=new TelaAdministradorGestaoUsuarios();
					tela.setVisible(true);
					tela.setLocationRelativeTo(null);
					dispose();
					break;
					
				case "Configuração de horários e funcionamento":
					TelaAdministradorConfigHorarios tela2 = new TelaAdministradorConfigHorarios();
					tela2.setVisible(true);
					tela2.setLocationRelativeTo(null);
					dispose();
					break;
				
				case "Cadastro de Secretária(o)":
					TelaAdministradorCadastroSecretaria tela3=new TelaAdministradorCadastroSecretaria();
					tela3.setVisible(true);
					tela3.setLocationRelativeTo(null);
					dispose();
					break;
				
				case "Cadastro de médicos":
					TelaAdministradorCadastrarMedicosDados tela4 = new TelaAdministradorCadastrarMedicosDados();
					tela4.setVisible(true);
					tela4.setLocationRelativeTo(null);
					dispose();
				break;
	
				}
			
			}
			
		});
		BotaoProximo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		BotaoProximo.setBounds(514, 332, 126, 32);
		panel.add(BotaoProximo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
				 dispose();
			}
		});
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnVoltar.setBounds(93, 332, 126, 32);
		panel.add(btnVoltar);
		

	}
}
