package telasSistema.Secretaria;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import conexao.ConnectionFactory;
import dao.AgendaDAO;
import dao.EspecialidadeDAO;
import dao.MedicoDAO;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;


public class TelaInfosAgendamento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtEspecialidade;
	private JComboBox<String> ComboboxProfissional;
	private JComboBox<Date> ComboboxDia;
	private JTextField txtcpfpaciente;
	private JTextField txtnomepaciente;
	private JComboBox<LocalTime> Comboboxhorario;

	/**
	 * Create the panel.
	 */
	public TelaInfosAgendamento() {
		setBounds(100, 100, 742, 454);
		getContentPane().setBackground(new Color(170, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 253, 255));
		panel.setBounds(0, 1, 729, 417);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAgendarConsulta = new JLabel("Agendar Consulta");
		lblAgendarConsulta.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblAgendarConsulta.setBounds(278, 31, 234, 54);
		panel.add(lblAgendarConsulta);
		
		JLabel lblEscolhaEspecialidade = new JLabel("Escolha a especialidade desejada");
		lblEscolhaEspecialidade.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEscolhaEspecialidade.setBounds(398, 102, 203, 16);
		panel.add(lblEscolhaEspecialidade);
		
		JLabel lblEscolhaProfissional = new JLabel("Escolha o Profissional");
		lblEscolhaProfissional.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblEscolhaProfissional.setBounds(398, 178, 203, 16);
		panel.add(lblEscolhaProfissional);
		
		DefaultComboBoxModel<String> modeloespecialidades = EspecialidadeDAO.getespecialidades();
		JComboBox<String> ComboboxEspecialidade = new JComboBox<String>();
		ComboboxEspecialidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ComboBoxModel<String> modelomedicoespecialidade = MedicoDAO.Buscamedicoporespecialidade((ComboboxEspecialidade.getSelectedIndex())+1); 
					ComboboxProfissional.setModel(modelomedicoespecialidade);
				} catch (RuntimeException er){
					JOptionPane.showMessageDialog(TelaInfosAgendamento.this, "Erro ao carregar profissionais.\n" +
					"Tente novamente.", "", JOptionPane.ERROR_MESSAGE);
					er.printStackTrace();
				}
			}
		});
		 ComboboxEspecialidade.setModel(modeloespecialidades);
	     ComboboxEspecialidade.setBounds(398, 129, 206, 22);
	     panel.add(ComboboxEspecialidade);
		
	     ComboboxProfissional = new JComboBox<String>();
	     ComboboxProfissional.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		try {
					int Id_Medico = MedicoDAO.Buscamedicopornome(ComboboxProfissional.getSelectedItem().toString());
					ComboBoxModel<Date> modelodatamedico = AgendaDAO.getmedicoagenda(Id_Medico);
					ComboboxDia.setModel(modelodatamedico);
	     		} catch (RuntimeException er) {
	     			JOptionPane.showMessageDialog(TelaInfosAgendamento.this, "Erro ao carregar agenda do médico.\n", 
	     			"Erro",JOptionPane.ERROR_MESSAGE);
	     		}
	     	}
	     });

	    ComboboxProfissional.setEditable(false);
		ComboboxProfissional.setBounds(398, 205, 206, 18);
		panel.add(ComboboxProfissional);
		
		JLabel lbldia = new JLabel("Escolha o dia");
		lbldia.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbldia.setBounds(398, 257, 78, 16);
		panel.add(lbldia);
		
		ComboboxDia = new JComboBox<Date>();
		ComboboxDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date data = (Date) ComboboxDia.getSelectedItem();
				ComboBoxModel<LocalTime> modelohorariodata = AgendaDAO.Buscahorariopordata(data);
				Comboboxhorario.setModel(modelohorariodata);
			}
		});
		ComboboxDia.setBounds(398, 284, 96, 18);
		panel.add(ComboboxDia);
		
		JButton btnProximo = new JButton("Próximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Nome_Med = ComboboxProfissional.getSelectedItem().toString();
				String Nome_Pac = txtnomepaciente.getText();
				String Especialidade = ComboboxEspecialidade.getSelectedItem().toString();
				Date Data_Consulta = (Date) ComboboxDia.getSelectedItem();
				LocalTime Horario_Consulta = (LocalTime) Comboboxhorario.getSelectedItem();
				
				TelaConfirmar tela = new TelaConfirmar(Nome_Med, Nome_Pac, Especialidade , Data_Consulta, Horario_Consulta);
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				 dispose();
				//new TelaConfirmar().setVisible(true);
				//dispose();
				
			}
		});
		btnProximo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnProximo.setBounds(398, 349, 84, 20);
		panel.add(btnProximo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipalSecretaria tela = new TelaPrincipalSecretaria();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnVoltar.setBounds(248, 349, 84, 20);
		panel.add(btnVoltar);
		
		JLabel lblcpfpaciente = new JLabel("Digite o CPF do paciente");
		lblcpfpaciente.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblcpfpaciente.setBounds(71, 107, 203, 16);
		panel.add(lblcpfpaciente);
		
		JLabel lblnomepaciente = new JLabel("Nome do Paciente:");
		lblnomepaciente.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblnomepaciente.setBounds(71, 181, 203, 16);
		panel.add(lblnomepaciente);
		
		txtcpfpaciente = new JTextField();
		txtcpfpaciente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarNome();
			}
		});
		txtcpfpaciente.setColumns(10);
		txtcpfpaciente.setBounds(67, 131, 265, 18);
		panel.add(txtcpfpaciente);
		
		txtnomepaciente = new JTextField();
		txtnomepaciente.setEditable(false);
		txtnomepaciente.setColumns(10);
		txtnomepaciente.setBounds(67, 205, 265, 18);
		panel.add(txtnomepaciente);
		
		JLabel lblhorario = new JLabel("Escolha o horário");
		lblhorario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblhorario.setBounds(539, 257, 96, 16);
		panel.add(lblhorario);
		
		Comboboxhorario = new JComboBox<LocalTime>();
		Comboboxhorario.setBounds(539, 284, 96, 18);
		panel.add(Comboboxhorario);
		
		JLabel lblCadastroPaciente = new JLabel("Primeira vez do paciente na clínica?");
		lblCadastroPaciente.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblCadastroPaciente.setBounds(71, 257, 203, 16);
		panel.add(lblCadastroPaciente);
		
		JButton btnCadastrarPaciente = new JButton("Cadastrar Paciente");
		btnCadastrarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaSecretariaCadastrarPaciente tela= new TelaSecretariaCadastrarPaciente();
				tela.setLocationRelativeTo(null);
				tela.setVisible(true);
				dispose();
			}
		});
		btnCadastrarPaciente.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		btnCadastrarPaciente.setBounds(71, 283, 137, 20);
		panel.add(btnCadastrarPaciente);
		

	}
	
	private void buscarNome() {
		Connection conexao=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		try {
			conexao = ConnectionFactory.getConnection();
			 if (conexao == null) {
		            JOptionPane.showMessageDialog(this, 
		                "Erro ao conectar ao banco de dados", 
		                "Erro de Conexão", 
		                JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        // 3. Validar que o CPF foi digitado
		        String cpf = txtcpfpaciente.getText().trim();
		        if (cpf.isEmpty()) {
		            JOptionPane.showMessageDialog(this, 
		                "Digite um CPF para buscar", 
		                "Aviso", 
		                JOptionPane.WARNING_MESSAGE);
		            txtcpfpaciente.requestFocus();
		            return;
		        
		        }
		        String sql = "SELECT nome FROM paciente WHERE cpf = ?";

		        ps = conexao.prepareStatement(sql);
		        ps.setString(1, cpf);
		        rs = ps.executeQuery();
		        if(rs.next()) {
		        	String nomeEncontrado=rs.getString("Nome");
		        	txtnomepaciente.setText(nomeEncontrado);
		        JOptionPane.showMessageDialog(this, 
		                "Paciente encontrado!", 
		                "Sucesso", 
		                JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            // Se não encontrou, limpa o campo e informa
		            txtnomepaciente.setText("");
		            JOptionPane.showMessageDialog(this, 
		                "Paciente não encontrado com o CPF: " + cpf, 
		                "Paciente não encontrado", 
		                JOptionPane.WARNING_MESSAGE);
		            
		            // Opcional: focar no campo de nome para cadastro
		            txtnomepaciente.requestFocus();
		        }
		        
		        
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Erro ao buscar paciente:\n" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		        e.printStackTrace();
		}
	}	
}

		
		
