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

public class TelaSecretariaCadastrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSecretariaCadastrar frame = new TelaSecretariaCadastrar();
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
	public TelaSecretariaCadastrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 253, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ButtonGroup grupoBotoes= new ButtonGroup();
		

		JLabel CadastrarPaciente = new JLabel("Cadastro do Paciente");
		CadastrarPaciente.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		CadastrarPaciente.setBounds(245, 10, 349, 68);
		contentPane.add(CadastrarPaciente);
		
		JLabel PreenchaDados = new JLabel("Preencha os dados do paciente");
		PreenchaDados.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		PreenchaDados.setBounds(287, 65, 180, 39);
		contentPane.add(PreenchaDados);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(61, 143, 160, 18);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(61, 191, 160, 18);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(61, 245, 160, 18);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(61, 298, 160, 18);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(299, 143, 160, 18);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(299, 191, 160, 18);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(299, 245, 160, 18);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(299, 298, 160, 18);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(527, 143, 160, 18);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(527, 191, 160, 18);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(527, 245, 160, 18);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(527, 298, 160, 18);
		contentPane.add(textField_10);
		
		JLabel lblNewLabel = new JLabel("Nome Completo");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblNewLabel.setBounds(93, 121, 109, 12);
		contentPane.add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblCpf.setBounds(125, 171, 30, 12);
		contentPane.add(lblCpf);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblEmail.setBounds(125, 223, 30, 12);
		contentPane.add(lblEmail);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblDataDeNascimento.setBounds(93, 276, 109, 12);
		contentPane.add(lblDataDeNascimento);
		
		JLabel lblTelefoneParaContato = new JLabel("Telefone Para Contato");
		lblTelefoneParaContato.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblTelefoneParaContato.setBounds(320, 121, 109, 12);
		contentPane.add(lblTelefoneParaContato);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblCep.setBounds(367, 171, 30, 12);
		contentPane.add(lblCep);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblCidade.setBounds(365, 223, 42, 12);
		contentPane.add(lblCidade);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblBairro.setBounds(365, 276, 42, 12);
		contentPane.add(lblBairro);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblRua.setBounds(596, 121, 24, 12);
		contentPane.add(lblRua);
		
		JLabel lblN = new JLabel("Nº");
		lblN.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblN.setBounds(603, 169, 30, 12);
		contentPane.add(lblN);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblComplemento.setBounds(577, 223, 66, 12);
		contentPane.add(lblComplemento);
		
		JLabel lblPlanoDeSade = new JLabel("Plano de Saúde (Opcional)");
		lblPlanoDeSade.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblPlanoDeSade.setBounds(537, 276, 133, 12);
		contentPane.add(lblPlanoDeSade);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
				 dispose();
			}
		});
		btnCadastrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnCadastrar.setBounds(516, 370, 104, 20);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
				 dispose();
			}
		});
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnVoltar.setBounds(93, 371, 104, 20);
		contentPane.add(btnVoltar);

		
		
	}
}
