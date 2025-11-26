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
import java.awt.Choice;
import javax.swing.JMenu;
import java.awt.List;
import java.awt.Checkbox;

public class TelaProfissional extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProfissional frame = new TelaProfissional();
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
	public TelaProfissional() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 253, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("Bem-vindo(a) de volta!");
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.BOLD, 33));
		lblNewLabel_3_1.setBounds(160, 11, 493, 68);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Que tipo de profissional você é?");
		lblNewLabel_3_1_1.setFont(new Font("Serif", Font.PLAIN, 18));
		lblNewLabel_3_1_1.setBounds(220, 65, 282, 68);
		contentPane.add(lblNewLabel_3_1_1);
		
		//PASSA P TELA DE SECRETARIA AO CLICAR NO BOTAO
		Button button = new Button("Secretária");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			TelaPrincipalSecretaria telaSecretaria= new TelaPrincipalSecretaria();
			telaSecretaria.setVisible(true);}
		});
		button.setBackground(new Color(255, 255, 255));
		button.setFont(new Font("Segoe UI", Font.BOLD, 24));
		button.setBounds(41, 184, 194, 38);
		contentPane.add(button);
		
		Button button_1 = new Button("Médico");
		button_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(269, 184, 194, 38);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Administrador");
		button_2.setActionCommand("Administrador");
		button_2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(490, 184, 194, 38);
		contentPane.add(button_2);

	}
}
