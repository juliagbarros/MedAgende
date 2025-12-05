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
		btnAtivarDestivar.setBounds(212, 74, 266, 48);
		panel.add(btnAtivarDestivar);
		
		JButton btnDefinirPermissesDe = new JButton("Definir Permissões de Acesso");
		btnDefinirPermissesDe.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnDefinirPermissesDe.setBounds(212, 196, 266, 49);
		panel.add(btnDefinirPermissesDe);
		
		JButton btnEditarDadosDe = new JButton("Editar dados de usuários existentes");
		btnEditarDadosDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdminEdicaoUsuario frame = new TelaAdminEdicaoUsuario();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		btnEditarDadosDe.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnEditarDadosDe.setBounds(212, 132, 266, 54);
		panel.add(btnEditarDadosDe);
		
		JButton btnRedefinirSenhaDos = new JButton("Redefinir senha dos usuários");
		btnRedefinirSenhaDos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdminRedefinirSenha frame = new TelaAdminRedefinirSenha();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		btnRedefinirSenhaDos.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnRedefinirSenhaDos.setBounds(212, 321, 266, 48);
		panel.add(btnRedefinirSenhaDos);
		
		JButton btnGestoDeEspecialidades = new JButton("Gestão de Especialidades");
		btnGestoDeEspecialidades.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnGestoDeEspecialidades.setBounds(212, 256, 266, 49);
		panel.add(btnGestoDeEspecialidades);
		
		btnGestoDeEspecialidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdminCadastroEspecialidades frame = new TelaAdminCadastroEspecialidades();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				dispose();
			}
		});
		
		
		
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
		

	}
}
