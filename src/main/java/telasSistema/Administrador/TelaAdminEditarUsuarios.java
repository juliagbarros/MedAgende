package telasSistema.Administrador;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\heito\\OneDrive\\Imagens\\agata2.png"));
		lblNewLabel_2.setBounds(503, 147, 160, 150);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\heito\\OneDrive\\Imagens\\Cartaxo3.png"));
		lblNewLabel_1.setBounds(279, 139, 166, 166);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\heito\\OneDrive\\Imagens\\juninho.png"));
		lblNewLabel.setBounds(50, 139, 160, 158);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Editar Paciente");
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setToolTipText("");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(39, 132, 178, 186);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar Médico");
		btnNewButton_1.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(267, 132, 178, 186);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Editar Secretaria");
		btnNewButton_2.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(493, 132, 186, 186);
		panel.add(btnNewButton_2);
		
		JLabel lblTitulo = new JLabel("Edição de Usuarios");
		lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 37));
		lblTitulo.setBounds(200, 11, 341, 73);
		panel.add(lblTitulo);
		
		JLabel lblNewLabel_3 = new JLabel("Selecione:");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(279, 81, 243, 31);
		panel.add(lblNewLabel_3);


	}
}
