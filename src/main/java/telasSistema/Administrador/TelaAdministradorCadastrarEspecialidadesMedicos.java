package telasSistema.Administrador;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAdministradorCadastrarEspecialidadesMedicos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEspecialidade;
	private JTextField crmtextField;
	private JTextField area_atuacaotextField;
	private JTextField textRqe;
	private JButton btnEnviar;
	private JButton btnvoltarButton;
	private JLabel textCRM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdminAdicionarEspecialidade frame = new TelaAdminAdicionarEspecialidade();
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
	public TelaAdministradorCadastrarEspecialidadesMedicos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 253, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textEspecialidade = new JTextField();
		textEspecialidade.setHorizontalAlignment(SwingConstants.CENTER);
		textEspecialidade.setBounds(51, 238, 196, 45);
		contentPane.add(textEspecialidade);
		textEspecialidade.setColumns(10);
		
		crmtextField = new JTextField();
		crmtextField.setColumns(10);
		crmtextField.setBounds(51, 121, 196, 45);
		contentPane.add(crmtextField);
		
		area_atuacaotextField = new JTextField();
		area_atuacaotextField.setColumns(10);
		area_atuacaotextField.setBounds(377, 121, 196, 45);
		contentPane.add(area_atuacaotextField);
		
		textRqe = new JTextField();
		textRqe.setColumns(10);
		textRqe.setBounds(377, 238, 196, 45);
		contentPane.add(textRqe);
		
		JLabel lblNewLabel = new JLabel("Especialidades");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(52, 221, 138, 14);
		contentPane.add(lblNewLabel);
		
		JLabel labelCadastrar = new JLabel("Cadastrar as especialidades do médico");
		labelCadastrar.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		labelCadastrar.setBounds(167, 34, 416, 31);
		contentPane.add(labelCadastrar);
		
		JLabel lblAreaAtuacao = new JLabel("Area de atuação");
		lblAreaAtuacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAreaAtuacao.setBounds(377, 105, 97, 14);
		contentPane.add(lblAreaAtuacao);
		
		JLabel lblNewLabel_2_1 = new JLabel("RQE");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(377, 222, 46, 14);
		contentPane.add(lblNewLabel_2_1);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mensagem="Por favor, preencha os seguintes campos obrigatórios:\n";
				int camposEmBranco=0;
				
				if (crmtextField.getText().trim().isEmpty()) {
					camposEmBranco++;
					mensagem+="Crm\n";
				}
				if (textEspecialidade.getText().trim().isEmpty()) {
					camposEmBranco++;
					mensagem+="Especialidade\n";
				}
				if (area_atuacaotextField.getText().trim().isEmpty()) {
					camposEmBranco++;
					mensagem+="Area de atuação\n";
				}
				
				if (textRqe.getText().trim().isEmpty()) {
					camposEmBranco++;
					mensagem+="RQE\n";
				}
				if (camposEmBranco>0) {
					JOptionPane.showMessageDialog(null, mensagem,"Erro de validação",JOptionPane.WARNING_MESSAGE);
					return;
				}else {
					JOptionPane.showMessageDialog(null, "Especialidade adicionada com sucesso, voltando ao menu principal...","Especialidade adicionada",JOptionPane.INFORMATION_MESSAGE);
				}
			
				
				TelaPrincipalAdministrador tela =new TelaPrincipalAdministrador();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				dispose();
			}
		});
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEnviar.setBounds(527, 349, 109, 31);
		contentPane.add(btnEnviar);
		
		btnvoltarButton = new JButton("Voltar");
		btnvoltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdminCadastroEspecialidades tela= new TelaAdminCadastroEspecialidades();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				dispose();
			}
		});
		btnvoltarButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnvoltarButton.setBounds(35, 349, 109, 28);
		contentPane.add(btnvoltarButton);
		
		textCRM = new JLabel("CRM");
		textCRM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textCRM.setBounds(93, 97, 97, 14);
		contentPane.add(textCRM);
		
	}

}
