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


public class TelaConfirmar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldBairro;
	private JTextField textFieldEspecialidade;
	private JTextField textFieldProfissional;
	private JTextField textFieldDiaHorario;

	/**
	 * Create the panel.
	 */
	public TelaConfirmar() {
		setBounds(100, 100, 742, 454);
		getContentPane().setBackground(new Color(170, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 253, 255));
		panel.setBounds(0, 1, 729, 417);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblConfirmarAgendamento = new JLabel("Confirmar Agendamento de consulta");
		lblConfirmarAgendamento.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblConfirmarAgendamento.setBounds(127, 31, 441, 54);
		panel.add(lblConfirmarAgendamento);
		

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaConfirmar().setVisible(true);
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
		panel_1.setBounds(38, 145, 648, 120);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblConfirmação = new JLabel("Confirmar consulta na clínica xxxxx, especialidade xxxxx, com o(a) médico(a) xxxxx no dia xx/xx/xxxx às xx:xx horas?");
		lblConfirmação.setBounds(20, 22, 628, 76);
		panel_1.add(lblConfirmação);
		lblConfirmação.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		

	}
}

		
		