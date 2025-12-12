package telasSistema.Administrador;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaAdministradorGestaoUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaAdministradorGestaoUsuarios() {
		setBounds(100, 100, 742, 454);
		getContentPane().setBackground(new Color(170, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 253, 255));
		panel.setBounds(0, 1, 729, 417);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGestao = new JLabel("Gestão de Usuários");
		lblGestao.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblGestao.setBounds(229, 10, 231, 54);
		panel.add(lblGestao);
		
		JButton btnAtivarDestivar = new JButton("Ativar/Desativar Usuários do Sistema");
		btnAtivarDestivar.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnAtivarDestivar.setBounds(212, 91, 266, 70);
		panel.add(btnAtivarDestivar);
		
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipalAdministrador tela = new TelaPrincipalAdministrador();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				 dispose();
			}
		});
		btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnVoltar.setBounds(70, 375, 126, 32);
		panel.add(btnVoltar);
		
		JButton btnPrximo = new JButton("Próximo");
		btnPrximo.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
		btnPrximo.setBounds(488, 375, 126, 32);
		panel.add(btnPrximo);
		
		JButton btnEditarUsuarios = new JButton("Editar Usuarios");
		btnEditarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdminEditarUsuarios tela=new TelaAdminEditarUsuarios();
				tela.setVisible(true);
				tela.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnEditarUsuarios.setBounds(212, 187, 266, 70);
		panel.add(btnEditarUsuarios);
		
		JButton btnExcluirUsuarios = new JButton("Excluir Usuarios");
		btnExcluirUsuarios.setBounds(212, 295, 266, 63);
		panel.add(btnExcluirUsuarios);
		

	}
}
