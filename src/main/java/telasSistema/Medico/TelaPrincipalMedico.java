package telasSistema.Medico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import telasSistema.TelaInicial.TelaLogin;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Point;

public class TelaPrincipalMedico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalMedico frame = new TelaPrincipalMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipalMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 222, 239));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBemVindoMedico = new JLabel("Bem vinda(o), Dr. xxxxxxxx!!!!");
		lblBemVindoMedico.setBounds(276, 10, 414, 35);
		lblBemVindoMedico.setFont(new Font("Arial Black", Font.BOLD, 24));
		contentPane.add(lblBemVindoMedico);
		
		JButton btnViewProntuario = new JButton("Visualizar Prontuário");
		btnViewProntuario.setBounds(151, 174, 154, 62);
		btnViewProntuario.setAlignmentY(0.0f);
		btnViewProntuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProntuarioPaciente telaProntuarioPaciente = new TelaProntuarioPaciente();
				telaProntuarioPaciente.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnViewProntuario);
		
		
		JButton btnSolicitarExame = new JButton("Solicitar exame");
		btnSolicitarExame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSolicitacaoExame telaSolicitacaoExame = new TelaSolicitacaoExame();
				telaSolicitacaoExame.setVisible(true);
				dispose();
			}
		});
		btnSolicitarExame.setAlignmentY(0.0f);
		btnSolicitarExame.setBounds(357, 174, 154, 62);
		contentPane.add(btnSolicitarExame);
		
		JButton btnEmitirAtestado = new JButton("Emitir atestado");
		btnEmitirAtestado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEmitirAtestado telaEmitirAtestado = new TelaEmitirAtestado();
				telaEmitirAtestado.setVisible(true);
				dispose();
			}
		});
		btnEmitirAtestado.setAlignmentY(0.0f);
		btnEmitirAtestado.setBounds(572, 174, 154, 62);
		contentPane.add(btnEmitirAtestado);
		
		JButton btnEmitirPrescricao = new JButton("Emitir prescrição");
		btnEmitirPrescricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEmitirPrescrição telaemitirprescicao = new TelaEmitirPrescrição();
				telaemitirprescicao.setVisible(true);
				dispose();
			}
		});
		
		btnEmitirPrescricao.setAlignmentY(0.0f);
		btnEmitirPrescricao.setBounds(242, 277, 154, 62);
		contentPane.add(btnEmitirPrescricao);
		
		JLabel lblOqueDeseja = new JLabel("O que deseja realizar?");
		lblOqueDeseja.setBounds(418, 84, 188, 14);
		contentPane.add(lblOqueDeseja);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
				 dispose();
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton.setBounds(85, 385, 84, 20);
		contentPane.add(btnNewButton);
		
		JButton btnPrximo = new JButton("Próximo");
		btnPrximo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnPrximo.setBounds(658, 386, 84, 20);
		contentPane.add(btnPrximo);
		
		JButton btnAgenda = new JButton("Configurar agenda");
		btnAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInserirAgenda telainseriragenda = new TelaInserirAgenda();
				telainseriragenda.setVisible(true);
				dispose();
			}
		});
		btnAgenda.setBounds(449, 277, 155, 62);
		contentPane.add(btnAgenda);

	}
}


