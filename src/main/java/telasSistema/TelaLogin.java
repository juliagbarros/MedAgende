package telasSistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JLayeredPane;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.JRadioButton;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 253, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(357, 1, 372, 417);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEmail = new JLabel("Digite aqui seu e-mail:");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmail.setBounds(95, 94, 156, 32);
		panel.add(lblEmail);
		
		JTextField textFieldEmail = new JTextField();
		textFieldEmail.setBounds(95, 126, 175, 19);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblSenha = new JLabel("Digite aqui sua senha:");
		lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblSenha.setBounds(95, 145, 175, 31);
		panel.add(lblSenha);
		
		JLabel lblMatricula = new JLabel("Digite aqui sua matrícula:");
		lblMatricula.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblMatricula.setBounds(95, 198, 175, 15);
		panel.add(lblMatricula);
		
		JTextField textFieldSenha = new JTextField();
		textFieldSenha.setBounds(95, 224, 178, 18);
		panel.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
	//BOTOES SELECAO PROFISSIONAL
		
		JRadioButton rdbtnSecretaria = new JRadioButton("Secretária");
		rdbtnSecretaria.setBounds(19, 297, 102, 20);
		panel.add(rdbtnSecretaria);
		
		JRadioButton rdbtnMedico = new JRadioButton("Médico");
		rdbtnMedico.setBounds(131, 297, 102, 20);
		panel.add(rdbtnMedico);
		
		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setBounds(244, 297, 102, 20);
		panel.add(rdbtnAdministrador);
		
		ButtonGroup grupoBotoes= new ButtonGroup();
		grupoBotoes.add(rdbtnSecretaria);
		grupoBotoes.add(rdbtnMedico);
		grupoBotoes.add(rdbtnAdministrador);
		
		
		//BOTAO LOGIN: 
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (rdbtnSecretaria.isSelected()) {
					TelaPrincipalSecretaria tela = new TelaPrincipalSecretaria();
					tela.setVisible(true);
					 dispose();
				}
				//aqui, ficaria os outros else ifs pra medico e administrador!!
			}
		});
		btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(0, 159, 255));
		btnLogin.setBounds(149, 329, 84, 20);
		panel.add(btnLogin);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblLogin.setBounds(128, 11, 105, 39);
		panel.add(lblLogin);
		
		JLabel lblRealizarLogin = new JLabel("Realize o login para continuar");
		lblRealizarLogin.setFont(new Font("Serif", Font.PLAIN, 16));
		lblRealizarLogin.setBounds(81, 61, 189, 19);
		panel.add(lblRealizarLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(95, 179, 175, 18);
		panel.add(passwordField);
		
		JLabel Cadastro = new JLabel("Ainda não possui cadastro no sistema?");
		Cadastro.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		Cadastro.setBounds(20, 359, 220, 19);
		panel.add(Cadastro);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.setBounds(238, 360, 97, 16);
		panel.add(btnCadastrar);
		
		JLabel LogarComo = new JLabel("Logar como:");
		LogarComo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		LogarComo.setBounds(149, 252, 97, 19);
		panel.add(LogarComo);
		

		JLabel BoasVindas = new JLabel("Bem-vindo(a) ao MedAgende!");
		BoasVindas.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		BoasVindas.setBounds(10, 0, 349, 68);
		contentPane.add(BoasVindas);
		
		JLabel Gerenciamento = new JLabel("Seu sistema de gerenciamento de consultas");
		Gerenciamento.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		Gerenciamento.setBounds(20, 46, 349, 39);
		contentPane.add(Gerenciamento);

		
		
	}
}
