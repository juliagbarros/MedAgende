package telasSistema.Secretaria;

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
		listOpcoes.setModel(new AbstractListModel() {
			String[] values = new String[] {"Agendar Consulta", "Cancelar Consulta", "Visualizar Histórico de Consultas", "Cadastrar Novo Paciente", "Editar dados do Paciente", "Excluir Paciente"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listOpcoes.setBounds(186, 136, 349, 150);
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
					TelaInfosAgendamento telainfosagendamento= new TelaInfosAgendamento();
					telainfosagendamento.setLocationRelativeTo(null);
					telainfosagendamento.setVisible(true);
					 dispose();
			
					break;
					
				case "Cancelar Consulta":
					TelaSecretariaCancelar telaSecretariaCancelar = new TelaSecretariaCancelar();
					telaSecretariaCancelar.setLocationRelativeTo(null);
					telaSecretariaCancelar.setVisible(true);
					 dispose();
				
					break;
		
				case "Visualizar Histórico de Consultas":
					TelaHistoricoAgendamentos telaHistoricoAgendamentos = new TelaHistoricoAgendamentos();
					telaHistoricoAgendamentos.setLocationRelativeTo(null);
					telaHistoricoAgendamentos.setVisible(true);
					dispose();
					
					break;
						
					
				case "Cadastrar Novo Paciente":
					TelaSecretariaCadastrarPaciente telaSecretariaCadastrar = new TelaSecretariaCadastrarPaciente();
					telaSecretariaCadastrar.setLocationRelativeTo(null);
					telaSecretariaCadastrar.setVisible(true);
					 dispose();
					 break;
					 
				case "Editar dados do Paciente":
					TelaSecretariaEditarPaciente telaSecretariaEditar = new TelaSecretariaEditarPaciente();
					telaSecretariaEditar.setLocationRelativeTo(null);
					telaSecretariaEditar.setVisible(true);
					 dispose();
					
					break;
					
				case "Excluir Paciente":
					TelaSecretariaExcluirPaciente telaSecretariaExcluir = new TelaSecretariaExcluirPaciente();
					telaSecretariaExcluir.setLocationRelativeTo(null);
					telaSecretariaExcluir.setVisible(true);
					dispose();
					
					break;
						
				}
			
			}
			
		});
		BotaoProximo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		BotaoProximo.setBounds(560, 311, 126, 32);
		panel.add(BotaoProximo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin tela = new TelaLogin();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				 dispose();
			}
		});
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnVoltar.setBounds(59, 318, 126, 32);
		panel.add(btnVoltar);
		

	}
}