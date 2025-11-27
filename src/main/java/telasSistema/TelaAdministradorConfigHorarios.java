package telasSistema;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaAdministradorConfigHorarios extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaAdministradorConfigHorarios() {
		setBounds(100, 100, 742, 454);
		getContentPane().setBackground(new Color(170, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 253, 255));
		panel.setBounds(0, 1, 729, 417);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGestao = new JLabel("Configuração de Horários e Funcionamento");
		lblGestao.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblGestao.setBounds(92, 21, 561, 54);
		panel.add(lblGestao);
		

		JButton btnNewButton = new JButton("Definir horário de funcionamento da clínica");
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton.setBounds(191, 136, 332, 49);
		panel.add(btnNewButton);
		
		JButton btnAtivarDestivar = new JButton("Configurar agenda padrão ");
		btnAtivarDestivar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnAtivarDestivar.setBounds(191, 195, 332, 48);
		panel.add(btnAtivarDestivar);
		
		JButton btnDefinirPermissesDe = new JButton("Bloquear datas específicas (feriados, manutenção, etc)");
		btnDefinirPermissesDe.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnDefinirPermissesDe.setBounds(191, 256, 332, 49);
		panel.add(btnDefinirPermissesDe);
		
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
		btnPrximo.setBounds(512, 345, 126, 32);
		panel.add(btnPrximo);
		

	}
}
