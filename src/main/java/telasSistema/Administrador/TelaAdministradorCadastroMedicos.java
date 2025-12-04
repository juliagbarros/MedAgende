package telasSistema.Administrador;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAdministradorCadastroMedicos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministradorCadastroMedicos frame = new TelaAdministradorCadastroMedicos();
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
	public TelaAdministradorCadastroMedicos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 454);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setBackground(new Color(170, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(204, 253, 255));
		contentPane_1.setBounds(0, 0, 726, 415);
		getContentPane().add(contentPane_1);
		
		JLabel edicaoUsuario = new JLabel("Cadastro de médicos");
		edicaoUsuario.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		edicaoUsuario.setBounds(248, 10, 262, 68);
		contentPane_1.add(edicaoUsuario);
		
		JButton btnCadastrar = new JButton("Próximo");
		btnCadastrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnCadastrar.setBounds(516, 370, 104, 20);
		contentPane_1.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorGestaoUsuarios tela= new TelaAdministradorGestaoUsuarios();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnVoltar.setBounds(93, 371, 104, 20);
		contentPane_1.add(btnVoltar);
		
		JButton btnNewButton = new JButton("Cadastrar médicos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorCadastrarMedicosDados tela = new TelaAdministradorCadastrarMedicosDados();
				tela.setVisible(true);
				 dispose();
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnNewButton.setBounds(49, 90, 190, 52);
		contentPane_1.add(btnNewButton);
		
		JButton btnVincularMdicos = new JButton("Vincular médicos à clínicas e especialidades");
		btnVincularMdicos.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnVincularMdicos.setBounds(148, 300, 402, 52);
		contentPane_1.add(btnVincularMdicos);
		
		JButton btnDesativarMdicosInativos = new JButton("Desativar médicos inativos e Desativar especialidades");
		btnDesativarMdicosInativos.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnDesativarMdicosInativos.setBounds(148, 225, 402, 52);
		contentPane_1.add(btnDesativarMdicosInativos);
		
		JButton btnDefinirHorriosE = new JButton("Definir horários e disponibilidade dos médicos");
		btnDefinirHorriosE.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnDefinirHorriosE.setBounds(148, 163, 402, 52);
		contentPane_1.add(btnDefinirHorriosE);
		
		JButton btnEditarDadosMdicos = new JButton("Editar dados médicos");
		btnEditarDadosMdicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarDadosMdicos.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnEditarDadosMdicos.setBounds(430, 90, 190, 52);
		contentPane_1.add(btnEditarDadosMdicos);

	}
}
