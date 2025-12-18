package telasSistema.TelaInicial;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Back.Usuarios;
import conexao.ConnectionFactory;
import dao.MedicoDAO;
import model.Criptografia;
import model.Medico;
import telasSistema.Administrador.TelaPrincipalAdministrador;
import telasSistema.Medico.TelaPrincipalMedico;
import telasSistema.Secretaria.TelaPrincipalSecretaria;

public class TelaLogin extends JFrame {

	Connection connection = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	private JTextField textFieldEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setLocationRelativeTo(null);
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

		// Conecta ao banco
		try {
		    connection = ConnectionFactory.getConnection();
		    System.out.println(connection);
		} 
		catch (Exception e) {
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(null, "Falha ao conectar ao banco de dados:\n" + e.getMessage(),
		    "Erro", JOptionPane.ERROR_MESSAGE);
		}

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(357, 1, 372, 417);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblEmail = new JLabel("Digite aqui seu e-mail:");
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEmail.setBounds(114, 114, 156, 32);
		panel.add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(95, 143, 175, 40);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel lblSenha = new JLabel("Digite aqui sua senha:");
		lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblSenha.setBounds(114, 194, 175, 31);
		panel.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(95, 225, 175, 39);
		panel.add(passwordField);
		ButtonGroup grupoBotoes = new ButtonGroup();

		// BOTAO LOGIN:
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("[DEBUG telalogin] Botão de logar apertadp");
				// condição para não deixar ele passar se estiver em branco
				String mensagemDeErro = "Por favor, preencha os seguintes campos obrigatórios:\n";
				int camposEmBranco = 0;

				// Agora, estas variáveis estão acessíveis!
				if (textFieldEmail.getText().trim().isEmpty()) {
					camposEmBranco++;
					mensagemDeErro += "- E-mail\n";
				}

				if (passwordField.getPassword().length == 0) {
					camposEmBranco++;
					mensagemDeErro += "- Senha\n";
				}

				if (camposEmBranco > 0) {
					JOptionPane.showMessageDialog(null, mensagemDeErro, "Erro de Validação",
					JOptionPane.WARNING_MESSAGE);
					return;
				}
				// Aqui você chamaria o método logar() e faria a verificação
				// logar();
				logar();

			}
		});

		btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(0, 159, 255));
		btnLogin.setBounds(128, 303, 105, 32);
		panel.add(btnLogin);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Segoe UI", Font.BOLD, 26));
		lblLogin.setBounds(128, 31, 105, 39);
		panel.add(lblLogin);

		JLabel lblRealizarLogin = new JLabel("Realize o login para continuar");
		lblRealizarLogin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblRealizarLogin.setBounds(95, 84, 189, 19);
		panel.add(lblRealizarLogin);

		JLabel logarComo = new JLabel("Logar como:");
		logarComo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		logarComo.setBounds(136, 273, 97, 19);
		panel.add(logarComo);

		JLabel esqueceuSenha = new JLabel("Esqueceu a senha?");
		esqueceuSenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		esqueceuSenha.setBounds(96, 375, 114, 32);
		panel.add(esqueceuSenha);

		JButton btnRecuperarSenha = new JButton("Recuperar Senha");
		btnRecuperarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRecuperaçãoSenha tela = new TelaRecuperaçãoSenha();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				dispose();

			}
		});
		btnRecuperarSenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnRecuperarSenha.setBackground(Color.WHITE);
		btnRecuperarSenha.setBounds(208, 375, 132, 32);
		panel.add(btnRecuperarSenha);

		JLabel boasVindas = new JLabel("Bem-vindo(a) ao MedAgende!");
		boasVindas.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		boasVindas.setBounds(10, 0, 349, 68);
		contentPane.add(boasVindas);

		JLabel gerenciamento = new JLabel("Seu sistema de gerenciamento de consultas");
		gerenciamento.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		gerenciamento.setBounds(20, 46, 349, 39);
		contentPane.add(gerenciamento);

	} // FECHA O CONSTRUTOR TelaLogin()

	public void logar() {
	    String sql = "SELECT * FROM usuarios WHERE Email=? AND Senha=?";
	    try {
	        pst = connection.prepareStatement(sql);
	        pst.setString(1, textFieldEmail.getText().trim());
	        
	        // 1. Captura a senha digitada
	        String senhaDigitada = new String(passwordField.getPassword());
	        
	        // 2. Criptografa a senha digitada (mesmo processo do cadastro)
	        Criptografia criptografia = new Criptografia(senhaDigitada, "md5");
	        String senhaCriptografada = criptografia.getInformacao();
	        
	        // 3. Compara com o hash armazenado no banco
	        pst.setString(2, senhaCriptografada);
	        //System.out.println("[DUBUG Logar] Senha criptografada: " + senhaCriptografada);
	        
	        // 4. Executa a consulta
	        rs = pst.executeQuery();
	        
	        if (rs.next()) {
	        	String nome = rs.getString("nome");
				String serviço = rs.getString("servíco");
				String id_conectado = rs.getString("id_usuario");
				if (serviço.equals("Secretária")){
					Usuarios.criausuarioconectado(id_conectado);
					JOptionPane.showMessageDialog(null, "Bem vindo(a) "+nome);
					TelaPrincipalSecretaria tela = new TelaPrincipalSecretaria();
					tela.setLocationRelativeTo(null);
					tela.setVisible(true);
					dispose();
				}else if (serviço.equals("Administrador")) {
					Usuarios.criausuarioconectado(id_conectado);
					JOptionPane.showMessageDialog(null, "Bem vindo(a) "+nome);
					TelaPrincipalAdministrador tela = new TelaPrincipalAdministrador();
					tela.setLocationRelativeTo(null);
					tela.setVisible(true);
					dispose();
					
					
				}else if (serviço.equals("Médico")) {
					System.out.println("usuário era um médico");
					Medico.criamedico(id_conectado);
					JOptionPane.showMessageDialog(null, "Bem vindo(a) Doutor(a) "+nome);
					TelaPrincipalMedico tela = new TelaPrincipalMedico();
					tela.setLocationRelativeTo(null);
					tela.setVisible(true);
					dispose();
				}	        } else {
	            JOptionPane.showMessageDialog(null, 
	                "Usuário e/ou senha inválido(s)", 
	                "Erro de Login", 
	                JOptionPane.ERROR_MESSAGE);
	        }
	        
	    } catch (Exception e) {
	        System.out.println("ERRO no login: " + e.getMessage());
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, 
	            "Erro ao realizar login: " + e.getMessage(), 
	            "Erro", 
	            JOptionPane.ERROR_MESSAGE);
	    }
	
	}

}
