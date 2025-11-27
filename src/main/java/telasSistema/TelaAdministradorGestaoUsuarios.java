package telasSistema;

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
		lblGestao.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblGestao.setBounds(228, 21, 231, 54);
		panel.add(lblGestao);
		
		
		JButton btnNewButton = new JButton("Cadastro de novos usuários");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton.setBounds(82, 136, 242, 49);
		panel.add(btnNewButton);
		
		JButton btnAtivarDestivar = new JButton("Ativar/Desativar Usuários do Sistema");
		btnAtivarDestivar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnAtivarDestivar.setBounds(82, 195, 242, 48);
		panel.add(btnAtivarDestivar);
		
		JButton btnDefinirPermissesDe = new JButton("Definir Permissões de Acesso");
		btnDefinirPermissesDe.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnDefinirPermissesDe.setBounds(82, 253, 242, 49);
		panel.add(btnDefinirPermissesDe);
		
		JButton btnEditarDadosDe = new JButton("Editar dados de usuários existentes");
		btnEditarDadosDe.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnEditarDadosDe.setBounds(411, 133, 242, 54);
		panel.add(btnEditarDadosDe);
		
		JButton btnRedefinirSenhaDos = new JButton("Redefinir senha dos usuários");
		btnRedefinirSenhaDos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnRedefinirSenhaDos.setBounds(411, 195, 242, 48);
		panel.add(btnRedefinirSenhaDos);
		
		JButton btnGestoDeEspecialidades = new JButton("Gestão de Especialidades");
		btnGestoDeEspecialidades.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnGestoDeEspecialidades.setBounds(411, 253, 242, 49);
		panel.add(btnGestoDeEspecialidades);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipalAdministrador tela = new TelaPrincipalAdministrador();
				tela.setVisible(true);
				 dispose();
			}
		});
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnVoltar.setBounds(76, 345, 126, 32);
		panel.add(btnVoltar);
		
		JButton btnPrximo = new JButton("Próximo");
		btnPrximo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnPrximo.setBounds(478, 345, 126, 32);
		panel.add(btnPrximo);
		

	}
}
