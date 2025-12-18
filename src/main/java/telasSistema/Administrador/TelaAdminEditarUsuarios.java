package telasSistema.Administrador;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import telasSistema.Secretaria.TelaSecretariaEditarPaciente;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAdminEditarUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdminEditarUsuarios frame = new TelaAdminEditarUsuarios();
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
	public TelaAdminEditarUsuarios() {
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
		lblNewLabel_2.setIcon(new ImageIcon(TelaAdminEditarUsuarios.class.getResource("/agta2.png")));
		lblNewLabel_2.setBounds(527, 111, 192, 178);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaAdminEditarUsuarios.class.getResource("/Cartaxo3.png")));
		lblNewLabel_1.setBounds(279, 139, 150, 150);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaAdminEditarUsuarios.class.getResource("/juninho.png")));
		lblNewLabel.setBounds(50, 139, 150, 150);
		panel.add(lblNewLabel);
		
		JButton btnEditarPaciente = new JButton("Editar Paciente");
		btnEditarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorEditarPaciente telaAdministradorEditarPaciente = new TelaAdministradorEditarPaciente();
				telaAdministradorEditarPaciente.setLocationRelativeTo(null);
				telaAdministradorEditarPaciente.setVisible(true);
				dispose();
			}
		});
		btnEditarPaciente.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEditarPaciente.setToolTipText("");
		btnEditarPaciente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEditarPaciente.setBounds(39, 132, 178, 186);
		panel.add(btnEditarPaciente);
		
		JButton btnEditarMedico = new JButton("Editar Médico");
		btnEditarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorEditarMedico telaAdministradorEditarMedico = new TelaAdministradorEditarMedico();
				telaAdministradorEditarMedico.setLocationRelativeTo(null);
				telaAdministradorEditarMedico.setVisible(true);
				dispose();
			}
		});
		btnEditarMedico.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEditarMedico.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEditarMedico.setBounds(267, 132, 178, 186);
		panel.add(btnEditarMedico);
		
		JButton btnEditarSecretaria = new JButton("Editar Secretaria");
		btnEditarSecretaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdministradorEditarSecretaria telaAdministradorEditarSecretaria = new TelaAdministradorEditarSecretaria();
				telaAdministradorEditarSecretaria.setLocationRelativeTo(null);
				telaAdministradorEditarSecretaria.setVisible(true);
				dispose();
			}
		});
		btnEditarSecretaria.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEditarSecretaria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEditarSecretaria.setBounds(493, 132, 186, 186);
		panel.add(btnEditarSecretaria);
		
		JLabel lblTitulo = new JLabel("Edição de Usuarios");
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

