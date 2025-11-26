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


public class TelaHistoricoAgendamentos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldBairro;
	private JTextField textFieldEspecialidade;
	private JTextField textFieldProfissional;
	private JTextField textFieldDiaHorario;

	/**
	 * Create the panel.
	 */
	public TelaHistoricoAgendamentos() {
		setBounds(100, 100, 742, 454);
		getContentPane().setBackground(new Color(170, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 253, 255));
		panel.setBounds(0, 1, 729, 417);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCancelarAgendamento = new JLabel("Cancelar Agendamento de Consulta");
		lblCancelarAgendamento.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblCancelarAgendamento.setBounds(127, 31, 441, 54);
		panel.add(lblCancelarAgendamento);
		

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipalSecretaria tela = new TelaPrincipalSecretaria();
				tela.setVisible(true);
				dispose();
				
			}
		});
		btnConfirmar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnConfirmar.setBounds(533, 349, 95, 20);
		panel.add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipalSecretaria tela = new TelaPrincipalSecretaria();
				tela.setVisible(true);
				 dispose();
			}
		});
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnVoltar.setBounds(98, 349, 84, 20);
		panel.add(btnVoltar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(81, 142, 572, 54);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblConfirmação = new JLabel(" Clínica Paulista, especialidade Fisioterapia, com o(a) médico(a) Carolina Maria Andrade no dia 01/12/2025 às 09:00 ");
		lblConfirmação.setForeground(new Color(0, 128, 0));
		lblConfirmação.setBounds(0, 10, 575, 40);
		panel_1.add(lblConfirmação);
		lblConfirmação.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		
		JLabel lblHistoricoConsultas = new JLabel("Histórico de Consultas do paciente");
		lblHistoricoConsultas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblHistoricoConsultas.setBounds(58, 78, 628, 76);
		panel.add(lblHistoricoConsultas);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(81, 220, 572, 54);
		panel.add(panel_1_1);
		
		JLabel lblClnicaOlindaEspecialidade = new JLabel(" Clínica Olinda, especialidade Clínica Geral, com o(a) médico(a) Maria dos Santos no dia 25/06/2025 às 10:30 ");
		lblClnicaOlindaEspecialidade.setForeground(new Color(255, 0, 0));
		lblClnicaOlindaEspecialidade.setBounds(0, 10, 575, 40);
		panel_1_1.add(lblClnicaOlindaEspecialidade);
		lblClnicaOlindaEspecialidade.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(81, 285, 572, 54);
		panel.add(panel_1_1_1);
		
		JLabel lblClnicaRecifeEspecialidade = new JLabel(" Clínica Recife, especialidade Cardiologia, com o(a) médico(a) André Ferreira Araújo no dia 11/02/2025 às 15:30 ");
		lblClnicaRecifeEspecialidade.setForeground(Color.RED);
		lblClnicaRecifeEspecialidade.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblClnicaRecifeEspecialidade.setBounds(0, 10, 575, 40);
		panel_1_1_1.add(lblClnicaRecifeEspecialidade);
		

	}
}

		
		