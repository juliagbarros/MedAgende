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

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
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
		panel.setBounds(356, 0, 372, 417);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite aqui seu e-mail:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel.setBounds(46, 116, 105, 13);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(168, 114, 120, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Digite aqui sua senha:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(43, 151, 91, 12);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Digite aqui sua matrícula:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(43, 192, 120, 15);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(173, 191, 117, 18);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		
		//BOTAO LOGIN: AO APERTAR, ELA VAI P TELA PRINCIPAL
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			TelaProfissional janelaProfissional = new TelaProfissional();
			janelaProfissional.setVisible(true);}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(0, 159, 255));
		btnNewButton.setBounds(156, 275, 84, 20);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("LOGIN");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblNewLabel_3.setBounds(161, 23, 79, 39);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Realize o login para continuar");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(108, 60, 159, 19);
		panel.add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 149, 117, 18);
		panel.add(passwordField);
		
		JLabel lblNewLabel_4_2 = new JLabel("Ainda não possui cadastro no sistema?");
		lblNewLabel_4_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_4_2.setBounds(20, 339, 220, 19);
		panel.add(lblNewLabel_4_2);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnCadastrar.setBackground(new Color(255, 255, 255));
		btnCadastrar.setBounds(231, 342, 97, 16);
		panel.add(btnCadastrar);
		
		JLabel lblNewLabel_3_1 = new JLabel("Bem-vindo(a) ao MedAgende!");
		lblNewLabel_3_1.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblNewLabel_3_1.setBounds(10, 10, 349, 68);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Seu sistema de gerenciamento de consultas");
		lblNewLabel_3_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(20, 36, 349, 68);
		contentPane.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("falta adc imagem!");
		lblNewLabel_3_1_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_3_1_2.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblNewLabel_3_1_2.setBounds(51, 170, 349, 68);
		contentPane.add(lblNewLabel_3_1_2);

	}
}
