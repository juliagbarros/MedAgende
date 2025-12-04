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
		lblBoasVindas.setBounds(110, 21, 511, 54);
		panel.add(lblBoasVindas);
		
		JList<String> listOpcoes = new JList<String>();
		listOpcoes.setBackground(new Color(255, 255, 255));
		listOpcoes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		listOpcoes.setModel(new AbstractListModel<String>() {
			String[] values = new String[] {"Gestão de usuários", "Configuração de horários e funcionamento", "Cadastro de especialidades", "Cadastro de Secretária(o)", "Cadastro de médicos", "Relatórios", "Auditoria e Registro"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		listOpcoes.setBounds(194, 109, 349, 184);
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
					new TelaAdministradorGestaoUsuarios().setVisible(true);
					dispose();
					break;
					
				case "Configuração de horários e funcionamento":
					new TelaAdministradorConfigHorarios().setVisible(true);
					dispose();
					break;
					
				case "Cadastro de especialidades":
					new TelaAdminAdicionarEspecialidade().setVisible(true);
					dispose();
					break;
				
				case "Cadastro de Secretária(o)":
					new TelaAdministradorCadastroUsuarios().setVisible(true);
					dispose();
					break;
				
				case "Cadastro de médicos":
				new TelaAdministradorCadastroMedicos().setVisible(true);
				dispose();
				break;
	
				case "Relatórios":
					new TelaAdministradorRelatorios().setVisible(true);
					dispose();
					break;
					
				case "Auditoria e Registro":
					new TelaAdministradorAuditoria().setVisible(true);
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
