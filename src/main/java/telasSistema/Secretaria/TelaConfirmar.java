package telasSistema.Secretaria;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Back.Consulta;
import dao.ConsultaDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalTime;
import java.awt.event.ActionEvent;


public class TelaConfirmar extends JFrame {

	private static final long serialVersionUID = 1L;


	/**
	 * Create the panel.
	 */
	public TelaConfirmar(String Nome_Med, String Nome_Pac, String Especialidade, Date Data_Consulta, LocalTime Horario_Consulta) {
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
				ConsultaDAO.cadastrarconsulta(Nome_Med, Nome_Pac, Data_Consulta, Horario_Consulta);
				
				JOptionPane.showMessageDialog(btnConfirmar,
	                    "Consulta cadastrada com sucesso!",
	                    "Sucesso",
	                    JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnConfirmar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnConfirmar.setBounds(312, 349, 95, 20);
		panel.add(btnConfirmar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInfosAgendamento tela=new TelaInfosAgendamento();
				tela.setLocationRelativeTo(null);
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
		
		JLabel lblConfirmação = new JLabel("<html>Confirmar consulta de Paciente " + Nome_Pac + ". especialidade " + Especialidade + ", com o(a) médico(a) " + Nome_Med + " no dia " + Data_Consulta + " às " + Horario_Consulta + " horas? </html>");
		lblConfirmação.setBounds(20, 22, 618, 87);
		panel_1.add(lblConfirmação);
		lblConfirmação.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consulta.EmitirComprovanteConsulta(Nome_Med, Nome_Pac, Especialidade, Data_Consulta, Horario_Consulta);
			}
		});
		btnImprimir.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnImprimir.setBounds(550, 349, 95, 20);
		panel.add(btnImprimir);
		

	}
}

		
		