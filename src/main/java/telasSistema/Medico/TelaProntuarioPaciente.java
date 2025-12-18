package telasSistema.Medico;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Back.Prontuario;

public class TelaProntuarioPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdade;
	private JTextField txtNomeCompleto;
	private JTextField txtEndereco;
	private JTextField txtTelefone;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtAlergias;
	private JTextField txtDoencas;
	private JTextField txtProfissao;
	private JTextField txtTemperatura;
	private JTextField txtPressao;
	private JTextField txtFrequenciaCardiaca;
	private JTextField txtSintomas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaProntuarioPaciente frame = new TelaProntuarioPaciente();
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
	public TelaProntuarioPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 500);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(143, 222, 239));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDadosPaciente = new JLabel("Dados do paciente");
		lblDadosPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDadosPaciente.setBounds(391, 56, 109, 14);
		contentPane.add(lblDadosPaciente);
		
		JLabel lblViewProntuario = new JLabel("Visualizar Prontuário do paciente");
		lblViewProntuario.setBounds(230, 10, 462, 35);
		lblViewProntuario.setFont(new Font("Arial Black", Font.BOLD, 24));
		contentPane.add(lblViewProntuario);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setForeground(Color.GRAY);
		lblIdade.setBounds(40, 99, 46, 14);
		contentPane.add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setBounds(40, 124, 86, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);
		
		
		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setColumns(10);
		txtNomeCompleto.setBounds(154, 124, 224, 20);
		contentPane.add(txtNomeCompleto);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo");
		lblNomeCompleto.setForeground(Color.GRAY);
		lblNomeCompleto.setBounds(154, 99, 146, 14);
		contentPane.add(lblNomeCompleto);
		
		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setForeground(Color.GRAY);
		lblEndereco.setBounds(414, 99, 86, 14);
		contentPane.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(414, 124, 224, 20);
		contentPane.add(txtEndereco);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(Color.GRAY);
		lblSexo.setBounds(662, 99, 46, 14);
		contentPane.add(lblSexo);
		
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBoxSexo.setBounds(662, 123, 46, 22);
		contentPane.add(comboBoxSexo);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setForeground(Color.GRAY);
		lblTelefone.setBounds(728, 99, 86, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setText("(81)");
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(728, 124, 86, 20);
		contentPane.add(txtTelefone);
		
		JLabel lblPeso = new JLabel("Peso (kg)");
		lblPeso.setForeground(Color.GRAY);
		lblPeso.setBounds(40, 159, 59, 14);
		contentPane.add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(40, 184, 35, 20);
		contentPane.add(txtPeso);
		
		JLabel lblAltura = new JLabel("Altura (cm)");
		lblAltura.setForeground(Color.GRAY);
		lblAltura.setBounds(109, 159, 68, 14);
		contentPane.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(108, 184, 35, 20);
		contentPane.add(txtAltura);
		
		JLabel lblAlergias = new JLabel("Alergias");
		lblAlergias.setForeground(Color.GRAY);
		lblAlergias.setBounds(187, 159, 53, 14);
		contentPane.add(lblAlergias);
		
		txtAlergias = new JTextField();
		txtAlergias.setColumns(10);
		txtAlergias.setBounds(186, 184, 214, 20);
		contentPane.add(txtAlergias);
		
		JLabel lblDoencas = new JLabel("Doença pré-existente");
		lblDoencas.setForeground(Color.GRAY);
		lblDoencas.setBounds(414, 159, 157, 14);
		contentPane.add(lblDoencas);
		
		txtDoencas = new JTextField();
		txtDoencas.setColumns(10);
		txtDoencas.setBounds(414, 184, 224, 20);
		contentPane.add(txtDoencas);
		
		JLabel lblProfissao = new JLabel("Ocupação/Profissão");
		lblProfissao.setForeground(Color.GRAY);
		lblProfissao.setBounds(661, 159, 152, 14);
		contentPane.add(lblProfissao);
		
		txtProfissao = new JTextField();
		txtProfissao.setColumns(10);
		txtProfissao.setBounds(662, 184, 152, 20);
		contentPane.add(txtProfissao);
		
		JLabel lblExameFisico = new JLabel("Sinais Vitais e Exame Físico");
		lblExameFisico.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExameFisico.setBounds(364, 232, 157, 14);
		contentPane.add(lblExameFisico);
		
		JLabel lblTemperatura = new JLabel("Temperatura (C°)");
		lblTemperatura.setForeground(Color.GRAY);
		lblTemperatura.setBounds(40, 270, 103, 14);
		contentPane.add(lblTemperatura);
		
		txtTemperatura = new JTextField();
		txtTemperatura.setColumns(10);
		txtTemperatura.setBounds(40, 293, 35, 20);
		contentPane.add(txtTemperatura);
		
		JLabel lblPressaoArterial = new JLabel("Pressão Arterial");
		lblPressaoArterial.setForeground(Color.GRAY);
		lblPressaoArterial.setBounds(154, 270, 99, 14);
		contentPane.add(lblPressaoArterial);
		
		txtPressao = new JTextField();
		txtPressao.setColumns(10);
		txtPressao.setBounds(154, 293, 99, 20);
		contentPane.add(txtPressao);
		
		JLabel lblFrequenciaCardiaca = new JLabel("Frequência Cardíaca");
		lblFrequenciaCardiaca.setForeground(Color.GRAY);
		lblFrequenciaCardiaca.setBounds(281, 270, 121, 14);
		contentPane.add(lblFrequenciaCardiaca);
		
		txtFrequenciaCardiaca = new JTextField();
		txtFrequenciaCardiaca.setColumns(10);
		txtFrequenciaCardiaca.setBounds(279, 293, 121, 20);
		contentPane.add(txtFrequenciaCardiaca);
		
		JLabel lblSintomas = new JLabel("Sintomas ou queixas do paciente");
		lblSintomas.setForeground(Color.GRAY);
		lblSintomas.setBounds(432, 270, 224, 14);
		contentPane.add(lblSintomas);
		
		txtSintomas = new JTextField();
		txtSintomas.setColumns(10);
		txtSintomas.setBounds(432, 293, 382, 20);
		contentPane.add(txtSintomas);
		
		JLabel lblSolicitacoes = new JLabel("Solicitações");
		lblSolicitacoes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSolicitacoes.setBounds(397, 324, 72, 14);
		contentPane.add(lblSolicitacoes);
		
		JCheckBox chckbxExame = new JCheckBox("Exame");
		chckbxExame.setBounds(218, 357, 97, 23);
		contentPane.add(chckbxExame);
		
		JCheckBox chckbxAtestado = new JCheckBox("Atestado");
		chckbxAtestado.setBounds(372, 357, 97, 23);
		contentPane.add(chckbxAtestado);
		
		JCheckBox chckbxPrescricao = new JCheckBox("Prescrição");
		chckbxPrescricao.setBounds(517, 357, 97, 23);
		contentPane.add(chckbxPrescricao);
		
		JButton btnVoltar = new JButton("Voltar");		
		btnVoltar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaPrincipalMedico telaPrincipalMedico = new TelaPrincipalMedico();
				telaPrincipalMedico.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(Color.DARK_GRAY);
		btnVoltar.setBounds(289, 406, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnProximo = new JButton("Próximo");
		btnProximo.setForeground(Color.WHITE);
		btnProximo.setBorder(null);
		btnProximo.setBackground(Color.DARK_GRAY);
		btnProximo.setBounds(482, 406, 89, 23);
		contentPane.add(btnProximo);
		
		JButton btnBaixar = new JButton("Baixar Prontuário");
		btnBaixar.setForeground(Color.WHITE);
		btnBaixar.setBorder(null);
		btnBaixar.setBackground(Color.DARK_GRAY);
		btnBaixar.setBounds(693, 406, 121, 23);
		contentPane.add(btnBaixar);
		
		btnBaixar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Processando as informações guardadas nos campos
				String Idade = txtIdade.getText();
				
				String Nome = txtNomeCompleto.getText();
				
				String Endereco = txtEndereco.getText();
				
				String Telefone = txtTelefone.getText();
				
				String Peso = txtPeso.getText();
				
				String Altura = txtAltura.getText();
				
				String Alergias = txtAlergias.getText();
				
				String Doencas = txtDoencas.getText();
				
				String Profissao = txtProfissao.getText();
				
				String Temperatura = txtTemperatura.getText();
				
				String Pressao = txtPressao.getText();
				
				String FreqCardiaca = txtFrequenciaCardiaca.getText();
				
				String Sintomas = txtSintomas.getText();
				
				String Sexo = (String) comboBoxSexo.getSelectedItem();
				
				
				// [DEBUG] System.out.println("método foi chamado");
				Prontuario.EmitirProntuario(Idade, Nome, Endereco, Telefone, Peso, Altura, Alergias, Doencas, Profissao, Temperatura, Pressao, FreqCardiaca, Sintomas, Sexo);
			}
		});

	}
}
