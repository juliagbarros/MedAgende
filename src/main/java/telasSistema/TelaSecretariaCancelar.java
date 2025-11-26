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


public class TelaSecretariaCancelar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TelaSecretariaCancelar() {
		setBounds(100, 100, 742, 454);
		getContentPane().setBackground(new Color(170, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 253, 255));
		panel.setBounds(0, 1, 729, 417);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCancelarConsulta = new JLabel("Cancelar Consulta");
		lblCancelarConsulta.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblCancelarConsulta.setBounds(257, 26, 234, 54);
		panel.add(lblCancelarConsulta);
		
		JLabel lblPreenchaDados = new JLabel("Preencha os dados do paciente");
		lblPreenchaDados.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblPreenchaDados.setBounds(288, 84, 203, 16);
		panel.add(lblPreenchaDados);
		
		JLabel lblNomePaciente = new JLabel("Nome do paciente");
		lblNomePaciente.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNomePaciente.setBounds(98, 161, 203, 16);
		panel.add(lblNomePaciente);
		
		JLabel lblCpfPaciente = new JLabel("CPF do paciente");
		lblCpfPaciente.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblCpfPaciente.setBounds(108, 189, 203, 16);
		panel.add(lblCpfPaciente);
		
		textField = new JTextField();
		textField.setBounds(208, 161, 265, 18);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(208, 189, 265, 18);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnProximo = new JButton("Próximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaHistoricoAgendamentos().setVisible(true);
				dispose();
				
			}
		});
		btnProximo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnProximo.setBounds(508, 349, 84, 20);
		panel.add(btnProximo);
		
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
		
	}
}

		
		