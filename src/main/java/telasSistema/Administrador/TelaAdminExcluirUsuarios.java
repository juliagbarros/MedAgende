package telasSistema.Administrador;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import telasSistema.Secretaria.TelaSecretariaExcluirPaciente;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAdminExcluirUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdminExcluirUsuarios frame = new TelaAdminExcluirUsuarios();
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
	/**
	 * 
	 */
	public TelaAdminExcluirUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 454);
		getContentPane().setBackground(new Color(170, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 253, 255));
		panel.setBounds(0, 1, 729, 417);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		//lblNewLabel_2.setIcon(new ImageIcon(TelaAdminExcluirUsuarios.class.getResource("/agta2.png")));
		lblNewLabel_2.setBounds(503, 147, 160, 150);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		//lblNewLabel_1.setIcon(new ImageIcon(TelaAdminExcluirUsuarios.class.getResource("/Cartaxo3.png")));
		lblNewLabel_1.setBounds(279, 139, 166, 166);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon(TelaAdminExcluirUsuarios.class.getResource("/juninho.png")));
		lblNewLabel.setBounds(50, 139, 160, 158);
		panel.add(lblNewLabel);
		
		JButton btnExcluirPaciente = new JButton("Excluir Paciente");
		btnExcluirPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSecretariaExcluirPaciente telaSecretariaExcluirPaciente = new TelaSecretariaExcluirPaciente();
				telaSecretariaExcluirPaciente.setLocationRelativeTo(null);
				telaSecretariaExcluirPaciente.setVisible(true);
				dispose();
			}
		});
		btnExcluirPaciente.setVerticalAlignment(SwingConstants.BOTTOM);
		btnExcluirPaciente.setToolTipText("");
		btnExcluirPaciente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExcluirPaciente.setBounds(39, 132, 178, 186);
		panel.add(btnExcluirPaciente);
		
		JButton btnExcluirMedico = new JButton("Excluir Médico");
		btnExcluirMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorExcluirMedico telaAdministradorExcluirMedico = new TelaAdministradorExcluirMedico();
				telaAdministradorExcluirMedico.setVisible(true);
				dispose();
			}
		});
		btnExcluirMedico.setVerticalAlignment(SwingConstants.BOTTOM);
		btnExcluirMedico.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExcluirMedico.setBounds(267, 132, 178, 186);
		panel.add(btnExcluirMedico);
		
		JButton btnExcluirSecretaria = new JButton("Excluir Secretaria");
		btnExcluirSecretaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorExcluirSecretaria telaAdministradorExcluirSecretaria = new TelaAdministradorExcluirSecretaria();
				telaAdministradorExcluirSecretaria.setVisible(true);
				dispose();
			}
		});
		btnExcluirSecretaria.setVerticalAlignment(SwingConstants.BOTTOM);
		btnExcluirSecretaria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExcluirSecretaria.setBounds(493, 132, 186, 186);
		panel.add(btnExcluirSecretaria);
		
		JLabel lblTitulo = new JLabel("Excluir Usuarios");
		lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 37));
		lblTitulo.setBounds(200, 11, 341, 73);
		panel.add(lblTitulo);
		
		JLabel lblNewLabel_3 = new JLabel("Selecione:");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(279, 81, 243, 31);
		panel.add(lblNewLabel_3);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorGestaoUsuarios tela=new TelaAdministradorGestaoUsuarios();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnVoltar.setBounds(54, 350, 96, 31);
		panel.add(btnVoltar);
		
		JButton btnProximo = new JButton("Próximo");
		btnProximo.setBounds(567, 350, 96, 31);
		panel.add(btnProximo);


	}
}
