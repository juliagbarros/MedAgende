package telasSistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class TelaSolicitacaoExame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdade;
	private JTextField txtNomeCompleto;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtNomeDoProfissional;
	private JTextField txtCRM;
	private JTextField txtEnderecoClinica;
	private JTextField txtExamesSolicitados;
	private JTextField txtDataSolicitacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSolicitacaoExame frame = new TelaSolicitacaoExame();
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
	public TelaSolicitacaoExame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 222, 239));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDadosPaciente = new JLabel("Dados do paciente");
		lblDadosPaciente.setBounds(394, 55, 104, 14);
		lblDadosPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblDadosPaciente);
		
		JLabel lblSolicitacaoExame = new JLabel("Solicitação de exame");
		lblSolicitacaoExame.setBounds(293, 11, 298, 35);
		lblSolicitacaoExame.setFont(new Font("Arial Black", Font.BOLD, 24));
		contentPane.add(lblSolicitacaoExame);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setForeground(Color.GRAY);
		lblIdade.setBounds(40, 80, 46, 14);
		contentPane.add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(40, 105, 46, 20);
		contentPane.add(txtIdade);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setForeground(Color.GRAY);
		lblNomeCompleto.setBounds(110, 80, 146, 14);
		contentPane.add(lblNomeCompleto);
		
		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setColumns(10);
		txtNomeCompleto.setBounds(110, 105, 224, 20);
		contentPane.add(txtNomeCompleto);
		
		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setForeground(Color.GRAY);
		lblEndereco.setBounds(355, 80, 86, 14);
		contentPane.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(354, 105, 265, 20);
		contentPane.add(txtEndereco);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(Color.GRAY);
		lblSexo.setBounds(654, 80, 46, 14);
		contentPane.add(lblSexo);
		
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBoxSexo.setBounds(654, 104, 46, 22);
		contentPane.add(comboBoxSexo);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(Color.GRAY);
		lblTelefone.setBounds(723, 80, 86, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(723, 105, 86, 20);
		contentPane.add(txtTelefone);
		
		JLabel lblDadosSolicitante = new JLabel("Dados do solicitante");
		lblDadosSolicitante.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosSolicitante.setBounds(394, 163, 170, 14);
		contentPane.add(lblDadosSolicitante);
		
		JLabel lblNomeDoProfissional = new JLabel("Nome do profissional");
		lblNomeDoProfissional.setForeground(Color.GRAY);
		lblNomeDoProfissional.setBounds(40, 194, 146, 14);
		contentPane.add(lblNomeDoProfissional);
		
		txtNomeDoProfissional = new JTextField();
		txtNomeDoProfissional.setColumns(10);
		txtNomeDoProfissional.setBounds(40, 219, 224, 20);
		contentPane.add(txtNomeDoProfissional);
		
		JLabel lblCRM = new JLabel("CRM");
		lblCRM.setForeground(Color.GRAY);
		lblCRM.setBounds(276, 194, 46, 14);
		contentPane.add(lblCRM);
		
		txtCRM = new JTextField();
		txtCRM.setColumns(10);
		txtCRM.setBounds(274, 219, 170, 20);
		contentPane.add(txtCRM);
		
		JLabel lblEnderecoClinica = new JLabel("Endereço da clínica");
		lblEnderecoClinica.setForeground(Color.GRAY);
		lblEnderecoClinica.setBounds(454, 194, 131, 14);
		contentPane.add(lblEnderecoClinica);
		
		txtEnderecoClinica = new JTextField();
		txtEnderecoClinica.setColumns(10);
		txtEnderecoClinica.setBounds(454, 219, 170, 20);
		contentPane.add(txtEnderecoClinica);
		
		JLabel lblExamesSolicitados = new JLabel("Exames Solicitados");
		lblExamesSolicitados.setForeground(Color.GRAY);
		lblExamesSolicitados.setBounds(637, 194, 131, 14);
		contentPane.add(lblExamesSolicitados);
		
		txtExamesSolicitados = new JTextField();
		txtExamesSolicitados.setColumns(10);
		txtExamesSolicitados.setBounds(634, 219, 175, 20);
		contentPane.add(txtExamesSolicitados);
		
		JLabel lblObservacoes = new JLabel("Observações adicionais");
		lblObservacoes.setForeground(Color.GRAY);
		lblObservacoes.setBounds(40, 255, 146, 14);
		contentPane.add(lblObservacoes);
		
		JTextArea textAreaObservacoes = new JTextArea();
		textAreaObservacoes.setBounds(40, 280, 265, 66);
		contentPane.add(textAreaObservacoes);
		
		JLabel lblDataSolicitacao = new JLabel("Data da solicitação");
		lblDataSolicitacao.setForeground(Color.GRAY);
		lblDataSolicitacao.setBounds(338, 255, 146, 14);
		contentPane.add(lblDataSolicitacao);
		
		txtDataSolicitacao = new JTextField();
		txtDataSolicitacao.setColumns(10);
		txtDataSolicitacao.setBounds(338, 282, 120, 20);
		contentPane.add(txtDataSolicitacao);
		
		JLabel lblCarimboAssinatura = new JLabel("Carimbo e assinatura");
		lblCarimboAssinatura.setForeground(Color.GRAY);
		lblCarimboAssinatura.setBounds(563, 255, 131, 14);
		contentPane.add(lblCarimboAssinatura);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaPrincipalMedico telaPrincipalMedico = new TelaPrincipalMedico();
				telaPrincipalMedico.setVisible(true);
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(Color.DARK_GRAY);
		btnVoltar.setBounds(293, 405, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setActionCommand("Imprimir");
		btnImprimir.setForeground(Color.WHITE);
		btnImprimir.setBorder(null);
		btnImprimir.setBackground(Color.DARK_GRAY);
		btnImprimir.setBounds(530, 405, 89, 23);
		contentPane.add(btnImprimir);

	}
}
