package telasSistema.Medico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Back.Atestado;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class TelaEmitirAtestado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEmitirAtestado frame = new TelaEmitirAtestado();
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
	public TelaEmitirAtestado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 222, 239));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnAtestoParaOs = new JTextPane();
		txtpnAtestoParaOs.setText("Atesto para os devidos fins que _______________________________________, portador do RG ____________ esteve em consulta médica neste consultório, no dia ____/____/_______, do periódo das ____ às ____.\r\n\r\n\r\n________, ________ de _________ de 2025\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\nAssinatura: _________________");
		txtpnAtestoParaOs.setBounds(234, 87, 424, 263);
		contentPane.add(txtpnAtestoParaOs);
		
		JLabel lblEmitirAtestado = new JLabel("Emitir atestado");
		lblEmitirAtestado.setBounds(334, 10, 241, 35);
		lblEmitirAtestado.setFont(new Font("Arial Black", Font.BOLD, 24));
		contentPane.add(lblEmitirAtestado);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaPrincipalMedico telaPrincipalMedico = new TelaPrincipalMedico();
				telaPrincipalMedico.setLocationRelativeTo(null);
				telaPrincipalMedico.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(Color.DARK_GRAY);
		btnVoltar.setBounds(261, 404, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Atestado.EmitirAtestado();
			}
		});
		btnImprimir.setForeground(Color.WHITE);
		btnImprimir.setBorder(null);
		btnImprimir.setBackground(Color.DARK_GRAY);
		btnImprimir.setActionCommand("Imprimir");
		btnImprimir.setBounds(536, 404, 89, 23);
		contentPane.add(btnImprimir);

	}

}
