package telasSistema.Medico;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;


public class TelaEmitirPrescrição extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	public TelaEmitirPrescrição() {
		Initialize();
	}


	public void Initialize() {
		setTitle("Emitir Prescrição");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 500);
		setVisible(true);
		
		getContentPane().setBackground(new Color(135, 206, 235));
		getContentPane().setLayout(null);
		
		JLabel lblNDaPrescrição = new JLabel("Nº da Prescrição:");
		lblNDaPrescrição.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNDaPrescrição.setBounds(114, 86, 129, 27);
		getContentPane().add(lblNDaPrescrição);
		
		JLabel lblDiagnstico = new JLabel("Diagnóstico:");
		lblDiagnstico.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDiagnstico.setBounds(114, 176, 109, 27);
		getContentPane().add(lblDiagnstico);
		
		JLabel lblPaciente = new JLabel("Paciente:");
		lblPaciente.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPaciente.setBounds(421, 92, 109, 14);
		getContentPane().add(lblPaciente);
		
		JLabel lblFrequncia = new JLabel("Frequência:");
		lblFrequncia.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblFrequncia.setBounds(633, 90, 109, 19);
		getContentPane().add(lblFrequncia);
		
		JLabel lblDataDeIncio = new JLabel("Data de início:");
		lblDataDeIncio.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDataDeIncio.setBounds(405, 182, 109, 14);
		getContentPane().add(lblDataDeIncio);
		
		JLabel lblDataDeTrmino = new JLabel("Data de término:");
		lblDataDeTrmino.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDataDeTrmino.setBounds(633, 183, 146, 14);
		getContentPane().add(lblDataDeTrmino);
		
		JLabel lblMedicamentos = new JLabel("Medicamento(s):");
		lblMedicamentos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMedicamentos.setBounds(114, 250, 129, 14);
		getContentPane().add(lblMedicamentos);
		
		JLabel lblMdicos = new JLabel("Médicos:");
		lblMdicos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMdicos.setBounds(352, 288, 109, 14);
		getContentPane().add(lblMdicos);
		
		JLabel lblConvnio = new JLabel("Convênio:");
		lblConvnio.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblConvnio.setBounds(352, 323, 109, 14);
		getContentPane().add(lblConvnio);
		
		JLabel lblAlergias = new JLabel("Alergia(s):");
		lblAlergias.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAlergias.setBounds(352, 350, 109, 27);
		getContentPane().add(lblAlergias);
		
		JLabel lblDescrição = new JLabel("Descrição:");
		lblDescrição.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDescrição.setBounds(633, 244, 146, 27);
		getContentPane().add(lblDescrição);
		
		textField = new JTextField();
		textField.setBounds(203, 181, 118, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(484, 91, 118, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(718, 91, 118, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(431, 287, 118, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(431, 322, 118, 20);
		getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(429, 354, 118, 20);
		getContentPane().add(textField_5);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(114, 275, 207, 102);
		getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(629, 275, 207, 102);
		getContentPane().add(textArea_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(508, 178, 30, 22);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(756, 180, 30, 22);
		getContentPane().add(comboBox_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(237, 89, 84, 22);
		getContentPane().add(textArea_2);
		
		JLabel lblEmitirPrescrio = new JLabel("EMITIR PRESCRIÇÃO");
		lblEmitirPrescrio.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmitirPrescrio.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblEmitirPrescrio.setBounds(389, 28, 198, 27);
		getContentPane().add(lblEmitirPrescrio);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(595, 404, 147, 23);
		getContentPane().add(btnImprimir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(237, 404, 147, 23);
		getContentPane().add(btnVoltar);
	
		
	}
}
