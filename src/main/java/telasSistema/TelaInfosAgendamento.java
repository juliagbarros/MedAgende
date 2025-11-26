package telasSistema;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaInfosAgendamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldRegiao;
	private JTextField textFieldCidade;
	private JTextField textFieldBairro;
	private JTextField textFieldEspecialidade;
	private JTextField textFieldProfissional;
	private JTextField textFieldDiaHorario;

	/**
	 * Create the panel.
	 */
	public TelaInfosAgendamento() {
		setBounds(100, 100, 742, 454);
		getContentPane().setBackground(new Color(170, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 253, 255));
		panel.setBounds(0, 1, 729, 417);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAgendarConsulta = new JLabel("Agendar Consulta");
		lblAgendarConsulta.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblAgendarConsulta.setBounds(278, 31, 234, 54);
		panel.add(lblAgendarConsulta);
		
		JLabel lblEscolhaRegiao = new JLabel("Escolha a região");
		lblEscolhaRegiao.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEscolhaRegiao.setBounds(42, 105, 203, 16);
		panel.add(lblEscolhaRegiao);
		
		textFieldRegiao = new JTextField();
		textFieldRegiao.setBounds(27, 131, 265, 18);
		panel.add(textFieldRegiao);
		textFieldRegiao.setColumns(10);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setBounds(27, 205, 265, 18);
		panel.add(textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel lblEscolhaCidade = new JLabel("Escolha a Cidade");
		lblEscolhaCidade.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEscolhaCidade.setBounds(42, 179, 203, 16);
		panel.add(lblEscolhaCidade);
		
		JLabel lblEscolhaBairro = new JLabel("Escolha o Bairro");
		lblEscolhaBairro.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEscolhaBairro.setBounds(42, 258, 203, 16);
		panel.add(lblEscolhaBairro);
		
		JLabel lblEscolhaEspecialidade = new JLabel("Escolha a especialidade desejada");
		lblEscolhaEspecialidade.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEscolhaEspecialidade.setBounds(432, 105, 203, 16);
		panel.add(lblEscolhaEspecialidade);
		
		JLabel lblEscolhaProfissional = new JLabel("Escolha o Profissional");
		lblEscolhaProfissional.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEscolhaProfissional.setBounds(443, 179, 203, 16);
		panel.add(lblEscolhaProfissional);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(27, 284, 265, 18);
		panel.add(textFieldBairro);
		
		textFieldEspecialidade = new JTextField();
		textFieldEspecialidade.setColumns(10);
		textFieldEspecialidade.setBounds(398, 131, 265, 18);
		panel.add(textFieldEspecialidade);
		
		textFieldProfissional = new JTextField();
		textFieldProfissional.setColumns(10);
		textFieldProfissional.setBounds(398, 205, 265, 18);
		panel.add(textFieldProfissional);
		
		JLabel lblEscolhaDiahorrio = new JLabel("Escolha o dia/horário ");
		lblEscolhaDiahorrio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEscolhaDiahorrio.setBounds(432, 261, 203, 16);
		panel.add(lblEscolhaDiahorrio);
		
		textFieldDiaHorario = new JTextField();
		textFieldDiaHorario.setColumns(10);
		textFieldDiaHorario.setBounds(398, 284, 265, 18);
		panel.add(textFieldDiaHorario);
		
		JButton btnProximo = new JButton("Próximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaConfirmar().setVisible(true);
				dispose();
				
			}
		});
		btnProximo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnProximo.setBounds(508, 349, 84, 20);
		panel.add(btnProximo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSecretariaAgendar tela = new TelaSecretariaAgendar();
				tela.setVisible(true);
				 dispose();
			}
		});
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnVoltar.setBounds(98, 349, 84, 20);
		panel.add(btnVoltar);
		

	}
}

		
		