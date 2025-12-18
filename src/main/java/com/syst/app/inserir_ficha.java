package com.syst.app;

import java.util.Scanner;
import java.util.Locale;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import java.awt.SystemColor;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;
import java.awt.Toolkit;
import java.awt.Button;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.border.CompoundBorder;
import java.awt.Rectangle;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class inserir_ficha extends JFrame{
	public inserir_ficha() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\overh\\eclipse-workspace\\Med-Agende\\src\\main\\java\\com\\syst\\app\\MedAgende-icone.png"));
		setTitle("MedAgende");
		
		JLabel titulo = DefaultComponentFactory.getInstance().createTitle("MedAgende");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBackground(new Color(135, 206, 250));
		titulo.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		titulo.setBorder(new CompoundBorder(new TitledBorder(new MatteBorder(0, 10, 10, 0, (Color) new Color(25, 25, 112)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 139)), new LineBorder(new Color(153, 180, 209), 3)));
		titulo.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 35));
		
		JLabel senha = new JLabel("Senha:");
		senha.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		
		JLabel usuario = DefaultComponentFactory.getInstance().createLabel("Usuário:");
		usuario.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		
		NomeLog = new JTextField();
		NomeLog.setBounds(new Rectangle(2, 2, 2, 2));
		NomeLog.setForeground(new Color(0, 0, 0));
		NomeLog.setBackground(SystemColor.activeCaption);
		NomeLog.setText("inserir nome");
		NomeLog.setColumns(10);
		NomeLog.setBorder(new LineBorder(new Color(0, 0, 139), 2, true));
		
		SenhaLog = new JPasswordField();
		SenhaLog.setForeground(SystemColor.textHighlight);
		SenhaLog.setBackground(SystemColor.activeCaption);
		
		// Aplica borda arredondada também na senha
		SenhaLog.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		
		JButton login = new JButton("Login");
		login.setAction(Login_action);
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		login.setBackground(new Color(135, 206, 235));
		login.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		
		JButton singin = new JButton("Singin");
		singin.setAction(Singin_action);
		singin.setBorder(new LineBorder(new Color(0, 0, 128), 2, true));
		singin.setBackground(new Color(135, 206, 235));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(85)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(usuario)
									.addGap(4)
									.addComponent(NomeLog, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(senha)
									.addGap(4)
									.addComponent(SenhaLog, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(singin, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
									.addGap(41)
									.addComponent(login, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
									.addGap(16)))
							.addContainerGap(96, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(titulo, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
							.addGap(78))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(titulo)
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(2)
							.addComponent(usuario))
						.addComponent(NomeLog, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(senha))
						.addComponent(SenhaLog, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(singin, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(login))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	static Scanner l = new Scanner(System.in);
	static Intern_System ficha = new Intern_System(null, null, 0);
	private JTextField NomeLog;
	private JPasswordField SenhaLog;
	private final Action Login_action = new SwingAction_Login();
	private final Action Singin_action = new SwingAction_Singin();
	public static void main(String[] args) throws Exception {

		System.out.print(
				"seja bem vindo a Padaria Santa Fé!\nE ao nosso serviço de atendimento online!\n por algum acaso você gostaria de criar uma nova conta(N) ou deseja logar(L)?\n(L/N)::>");
		String log = l.nextLine();

		switch (log.toUpperCase(Locale.ROOT)) {
		case "L":
			loginMethod();
			break;
		case "N":
			singinMethod();
			break;
		default:
			System.err.print("apenas as respostas 'N' e 'L' são aceitas aqui!!\n não se preocupe em escrever em maiúsculo ou minúsculo\no sistema pode diferenciar a caixa das letras");
			main(null);
		}
		
	}

	public static void singinMethod() throws Exception {
		System.out.print("certo vamos criar uma conta!\n qual o seu nome?\n::>");
		ficha.setNome(l.nextLine());
		System.out.print("agora, digite sua idade\n::>");
		ficha.setIdade(l.nextInt());
		System.out.print("por fim, digite uma senha\n::>");
		ficha.setSenha(l.next());
		ficha.fazerlista();
	}

	public static void loginMethod() throws Exception {

		System.out.print("Certo! vamos verificar a sua conta! Por favor digite seu nome:\n::>");
		ficha.setNome(l.nextLine());
		System.out.print("Agora " + ficha.getNome() + ", digite sua senha\n::>");
		ficha.setSenha(l.next());
		ficha.lerLista();
	}
	private class SwingAction_Login extends AbstractAction {
		public SwingAction_Login() {
			putValue(NAME, "Login");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_Singin extends AbstractAction {
		public SwingAction_Singin() {
			putValue(NAME, "Singin");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
