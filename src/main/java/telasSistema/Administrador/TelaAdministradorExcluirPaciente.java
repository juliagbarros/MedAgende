package telasSistema.Administrador;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import conexao.ConnectionFactory;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import com.toedter.calendar.JDateChooser;

import conexao.ConnectionFactory;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.Cursor;
import javax.swing.SwingWorker;
import javax.swing.SwingUtilities;

// IMPORTAÇÕES PARA API DOS CORREIOS
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import telasSistema.Administrador.TelaAdminExcluirUsuarios;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaAdministradorExcluirPaciente extends JFrame {

 
    private static class ViaCEPResponse {
        private String cep;
        private String logradouro;
        private String complemento;
        private String bairro;
        private String localidade;
        private String uf;
        private String ibge;
        private String gia;
        private String ddd;
        private String siafi;
        private boolean erro;
        
        // Getters e Setters
        public String getCep() { return cep; }
        public void setCep(String cep) { this.cep = cep; }
        
        public String getLogradouro() { return logradouro; }
        public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
        
        public String getBairro() { return bairro; }
        public void setBairro(String bairro) { this.bairro = bairro; }
        
        public String getLocalidade() { return localidade; }
        public void setLocalidade(String localidade) { this.localidade = localidade; }
        
        public String getUf() { return uf; }
        public void setUf(String uf) { this.uf = uf; }
        
        public String getComplemento() { return complemento; }
        public void setComplemento(String complemento) { this.complemento = complemento; }
        
        public String getIbge() { return ibge; }
        public void setIbge(String ibge) { this.ibge = ibge; }
        
        public String getGia() { return gia; }
        public void setGia(String gia) { this.gia = gia; }
        
        public String getDdd() { return ddd; }
        public void setDdd(String ddd) { this.ddd = ddd; }
        
        public String getSiafi() { return siafi; }
        public void setSiafi(String siafi) { this.siafi = siafi; }
        
        public boolean temErro() { return erro; }
        public void setErro(boolean erro) { this.erro = erro; }
    }

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JComboBox<String> boxSexo;

	private JTextField FieldNome;
	private JTextField FieldCpf;
	private JTextField FieldEmail;
	private JDateChooser dcDataNascimento;
    private JTextField FieldCep; // CEP
    private JTextField FieldRua; // Rua
    private JTextField FieldNumero; // Número
    private JTextField FieldMunicipio;
    private JTextField FieldEstado;
    private JTextField FieldBairro;
    private int idPaciente;
    
    PreparedStatement pstDelete = null;

    PreparedStatement pstPaciente = null;
    PreparedStatement pstAlergia = null;
    PreparedStatement pstComorbidade = null;  
    Connection conexao = null;  
    ResultSet rs=null;
    
    // Componentes para API
    private OkHttpClient httpClient;
    private Gson gson;
    private JTextField FieldProfissao;
    private JTextField FieldPlanoSaude;
    private JTextField FieldAlergia;
    private JTextField FieldComorbidade;
    private JTextField FieldTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministradorExcluirPaciente frame = new TelaAdministradorExcluirPaciente();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
	                        "Erro ao iniciar a aplicação: " + e.getMessage(),
	                        "Erro", JOptionPane.ERROR_MESSAGE);
	                    e.printStackTrace();

				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaAdministradorExcluirPaciente() {
		// INICIALIZA AS BIBLIOTECAS DA API
		httpClient = new OkHttpClient();
		gson = new Gson();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 222, 239));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		conexao = ConnectionFactory.getConnection();
		System.out.println(conexao);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		contentPane.setLayout(null);
		
		JLabel LabelCadastroPaciente = new JLabel("Excluir Paciente:");
		LabelCadastroPaciente.setBounds(351, 0, 387, 67);
		LabelCadastroPaciente.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		contentPane.add(LabelCadastroPaciente);
		
		FieldNome = new JTextField();
		FieldNome.setBounds(21, 195, 206, 20);
		contentPane.add(FieldNome);
		FieldNome.setColumns(10);
		
		
		// o FocusLost faz o seguinte: quandp o usuario sai do textfield de cpf, ele preenche tudo que ele buscou no banco 
		FieldCpf = new JTextField();
		FieldCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FieldCpf.addFocusListener(new FocusAdapter() {

					@Override
					public void focusLost(FocusEvent e) {
						// TODO Auto-generated method stub
						buscarPaciente(FieldCpf.getText());
					}
					
				});
			
				
			}
		});
		FieldCpf.setBounds(352, 98, 86, 20);
		contentPane.add(FieldCpf);
		FieldCpf.setColumns(10);
		
		FieldEmail = new JTextField();
		FieldEmail.setToolTipText("Ex: costelinha123@gmail.com...");
		FieldEmail.setBounds(21, 249, 206, 20);
		contentPane.add(FieldEmail);
		FieldEmail.setColumns(10);
		
		JLabel LabelEmail = new JLabel("Digite o Email:");
		LabelEmail.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		LabelEmail.setBounds(21, 225, 189, 14);
		contentPane.add(LabelEmail);
		
		JLabel LabelCPF = new JLabel("CPF:");
		LabelCPF.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		LabelCPF.setBounds(323, 99, 46, 14);
		contentPane.add(LabelCPF);
		
		JLabel LabelNome = new JLabel("Nome Completo:");
		LabelNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		LabelNome.setBounds(31, 171, 206, 14);
		contentPane.add(LabelNome);
		
		JLabel LabelDataNascimento = new JLabel("Insira a Data de Nascimento:");
		LabelDataNascimento.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		LabelDataNascimento.setBounds(272, 171, 167, 14);
		contentPane.add(LabelDataNascimento);
        
        // --- JCALENDAR ---
        dcDataNascimento = new JDateChooser();
        dcDataNascimento.setToolTipText("Ex: 25/06/2003...");
        dcDataNascimento.setDateFormatString("dd/MM/yyyy");
        dcDataNascimento.setBounds(272, 195, 120, 20); 
        contentPane.add(dcDataNascimento);
        
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        btnExcluir.setForeground(new Color(0, 0, 0));
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
							excluir();
               }
               
        });
        btnExcluir.setBounds(683, 401, 135, 35);
        contentPane.add(btnExcluir);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaAdminExcluirUsuarios tela = new TelaAdminExcluirUsuarios();
				tela.setLocationRelativeTo(null);
        		tela.setVisible(true);
				 dispose();
        	}
        });
        btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        btnVoltar.setBounds(45, 402, 125, 32);
        contentPane.add(btnVoltar);
        
        JLabel lblNewLabel = new JLabel("CEP:");
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNewLabel.setBounds(652, 172, 46, 14);
        contentPane.add(lblNewLabel);
        
        FieldCep = new JTextField(); // CEP
        FieldCep.setBounds(652, 195, 86, 20);
        contentPane.add(FieldCep);
        FieldCep.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Rua:");
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNewLabel_1.setBounds(753, 280, 46, 14);
        contentPane.add(lblNewLabel_1);
        
        FieldRua = new JTextField(); // Rua
        FieldRua.setBounds(740, 304, 86, 20);
        contentPane.add(FieldRua);
        FieldRua.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Número:");
        lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNewLabel_2.setBounds(746, 334, 72, 14);
        contentPane.add(lblNewLabel_2);
        
        FieldNumero = new JTextField(); // Número
        FieldNumero.setBounds(740, 358, 59, 20);
        contentPane.add(FieldNumero);
        FieldNumero.setColumns(10);
        
        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblBairro.setBounds(652, 280, 46, 14);
        contentPane.add(lblBairro);
        
        FieldBairro = new JTextField(); // Bairro
        FieldBairro.setBounds(644, 304, 86, 20);
        contentPane.add(FieldBairro);
        FieldBairro.setColumns(10);
        
        JLabel lblMunicipio = new JLabel("Município:");
        lblMunicipio.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblMunicipio.setBounds(746, 226, 72, 14);
        contentPane.add(lblMunicipio);
        
        FieldMunicipio = new JTextField(); // Município
        FieldMunicipio.setBounds(732, 249, 86, 20);
        contentPane.add(FieldMunicipio);
        FieldMunicipio.setColumns(10);
        
        JLabel lblEstadoUF = new JLabel("Estado(UF):");
        lblEstadoUF.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblEstadoUF.setBounds(644, 226, 72, 14);
        contentPane.add(lblEstadoUF);
        
        FieldEstado = new JTextField(); // Estado(UF)
        FieldEstado.setBounds(652, 249, 46, 20);
        contentPane.add(FieldEstado);
        FieldEstado.setColumns(10);
        
        // BOTÃO PARA BUSCAR CEP
        JButton btnBuscarCEP = new JButton("Buscar");
        btnBuscarCEP.setBounds(743, 194, 83, 20);
        btnBuscarCEP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarEnderecoPorCEP();
            }
        });
        contentPane.add(btnBuscarCEP);
        
        JLabel lblPreenchaOsDados = new JLabel("Digite o CPF para buscar o(a) paciente para excluir: ");
        lblPreenchaOsDados.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblPreenchaOsDados.setBounds(298, 53, 331, 14);
        contentPane.add(lblPreenchaOsDados);
        
        JLabel lblDigiteOTelefone = new JLabel("Digite o Telefone:");
        lblDigiteOTelefone.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblDigiteOTelefone.setBounds(289, 225, 189, 14);
        contentPane.add(lblDigiteOTelefone);
        
        JLabel lblDigitePlano = new JLabel("Digite o Plano de saúde:");
        lblDigitePlano.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblDigitePlano.setBounds(21, 279, 189, 14);
        contentPane.add(lblDigitePlano);
        
        JLabel lblDigiteProfissao = new JLabel("Digite a profissão:");
        lblDigiteProfissao.setToolTipText("Digite a profissão:");
        lblDigiteProfissao.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblDigiteProfissao.setBounds(289, 285, 189, 14);
        contentPane.add(lblDigiteProfissao);
        
        FieldProfissao = new JTextField();
        FieldProfissao.setToolTipText("Digite a profissão:");
        FieldProfissao.setBounds(272, 305, 206, 18);
        contentPane.add(FieldProfissao);
        FieldProfissao.setColumns(10);
        
         boxSexo = new JComboBox();
        boxSexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
        boxSexo.setBounds(546, 193, 46, 22);
        contentPane.add(boxSexo);
        
        JLabel lblDigiteSuasAlergias = new JLabel("Digite a(s) alergia(a):");
        lblDigiteSuasAlergias.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblDigiteSuasAlergias.setBounds(21, 333, 189, 14);
        contentPane.add(lblDigiteSuasAlergias);
        
        JLabel lblDigiteAsComorbidades = new JLabel("Digite a(s) comorbidade(s):");
        lblDigiteAsComorbidades.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblDigiteAsComorbidades.setBounds(279, 333, 189, 14);
        contentPane.add(lblDigiteAsComorbidades);
        
        FieldPlanoSaude = new JTextField();
        FieldPlanoSaude.setBounds(21, 303, 206, 20);
        contentPane.add(FieldPlanoSaude);
        FieldPlanoSaude.setColumns(10);
        
        FieldAlergia = new JTextField();
        FieldAlergia.setBounds(21, 358, 206, 20);
        contentPane.add(FieldAlergia);
        FieldAlergia.setColumns(10);
        
        FieldComorbidade = new JTextField();
        FieldComorbidade.setColumns(10);
        FieldComorbidade.setBounds(272, 358, 206, 20);
        contentPane.add(FieldComorbidade);
        
        FieldTelefone = new JTextField();
        FieldTelefone.setText("(81)");
        FieldTelefone.setColumns(10);
        FieldTelefone.setBounds(272, 249, 206, 20);
        contentPane.add(FieldTelefone);
        
        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblSexo.setBounds(548, 173, 44, 12);
        contentPane.add(lblSexo);
        
        JButton btnNewButton = new JButton("Verificar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String cpf= FieldCpf.getText().trim();
        		if (cpf.isEmpty()) {
        			JOptionPane.showMessageDialog(null, "Digite o Cpf!");
        		} else { 
        			buscarPaciente(cpf);
        		}
        		
        	}
        });
        btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        btnNewButton.setBounds(463, 97, 84, 20);
        contentPane.add(btnNewButton);

        
        implementCEPAutoComplete();
	}
	public void excluir() {
	    Connection conexao = null;
	    PreparedStatement pstPaciente = null;
	    PreparedStatement pstAlergia = null;
	    PreparedStatement pstComorbidade = null;
	    PreparedStatement pstConsulta = null;
	    PreparedStatement pstProntuario = null;
	    ResultSet rs = null;
	    
	    try {
	        conexao = ConnectionFactory.getConnection();
	        conexao.setAutoCommit(false); 
	        String cpf = FieldCpf.getText().trim();
	        
	        if (cpf.isEmpty()) {
	            JOptionPane.showMessageDialog(null, 
	                "Digite o CPF do paciente para excluir!",
	                "CPF Vazio",
	                JOptionPane.WARNING_MESSAGE);
	            return;
	        }
	        
	       
	        cpf = cpf.replaceAll("[^0-9]", "");
	        
	        String sqlBuscarPaciente = "SELECT Id_Paciente, Nome FROM paciente WHERE CPF = ?";
	        pstPaciente = conexao.prepareStatement(sqlBuscarPaciente);
	        pstPaciente.setString(1, cpf);
	        rs = pstPaciente.executeQuery();
	        
	        if (!rs.next()) {
	            JOptionPane.showMessageDialog(null,
	                "Paciente com CPF " + (cpf) + " não encontrado!",
	                "Paciente não encontrado",
	                JOptionPane.WARNING_MESSAGE);
	            return;
	        }
	        
	        int idPaciente = rs.getInt("Id_Paciente");
	        String nomePaciente = rs.getString("Nome");
	        
	        rs.close();
	        pstPaciente.close();
	        
	        int confirmacao = JOptionPane.showConfirmDialog(null,
	            "Tem certeza que deseja excluir o paciente:\n" +
	            "Nome: " + nomePaciente + "\n" +
	            "CPF: " + (cpf) + "\n\n" +
	            "Esta ação NÃO pode ser desfeita!\n" +
	            "Todos os dados relacionados serão excluídos permanentemente.",
	            "Confirmação de Exclusão",
	            JOptionPane.YES_NO_OPTION,
	            JOptionPane.WARNING_MESSAGE);
	        
	        if (confirmacao != JOptionPane.YES_OPTION) {
	            return;
	        }
	        
	        
	        String sqlAlergia = "DELETE FROM alergias WHERE Id_Paciente = ?";
	        pstAlergia = conexao.prepareStatement(sqlAlergia);
	        pstAlergia.setInt(1, idPaciente);
	        pstAlergia.executeUpdate();
	        pstAlergia.close();
	        
	        String sqlComorbidade = "DELETE FROM comorbidades WHERE Id_Paciente = ?";
	        pstComorbidade = conexao.prepareStatement(sqlComorbidade);
	        pstComorbidade.setInt(1, idPaciente);
	        pstComorbidade.executeUpdate();
	        pstComorbidade.close();
	        
	        try {
	            String sqlProntuario = "DELETE FROM prontuarios WHERE Id_Paciente = ?";
	            pstProntuario = conexao.prepareStatement(sqlProntuario);
	            pstProntuario.setInt(1, idPaciente);
	            pstProntuario.executeUpdate();
	            pstProntuario.close();
	        } catch (SQLException e) {
	            System.out.println("Info: Nenhum prontuário para excluir ou tabela não existe");
	        }
	        
	        String sqlConsulta = "DELETE FROM consultas WHERE Id_Paciente = ?";
	        pstConsulta = conexao.prepareStatement(sqlConsulta);
	        pstConsulta.setInt(1, idPaciente);
	        int consultasExcluidas = pstConsulta.executeUpdate();
	        pstConsulta.close();
	        
	        String sqlDeletePaciente = "DELETE FROM paciente WHERE Id_Paciente = ?";
	        pstPaciente = conexao.prepareStatement(sqlDeletePaciente);
	        pstPaciente.setInt(1, idPaciente);
	        int resultado = pstPaciente.executeUpdate();
	        
	        if (resultado > 0) {
	            conexao.commit();
	            
	            limparCampos();
	            
	            JOptionPane.showMessageDialog(null,
	                "✅ Paciente excluído com sucesso!\n" +
	                "Nome: " + nomePaciente + "\n" +
	                "CPF: " + (cpf) + "\n" +
	                (consultasExcluidas > 0 ? "Consultas excluídas: " + consultasExcluidas + "\n" : "") +
	                "Todos os dados relacionados foram removidos.",
	                "Exclusão Concluída",
	                JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            conexao.rollback();
	            JOptionPane.showMessageDialog(null,
	                "Erro ao excluir paciente. Nenhum registro foi afetado.",
	                "Erro",
	                JOptionPane.ERROR_MESSAGE);
	        }
	        
	    } catch (SQLException e) {
	        try {
	            if (conexao != null) {
	                conexao.rollback();
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null,
		                "❌ Erro ao excluir paciente: " + e.getMessage() + 
		                "\nCódigo: " + e.getErrorCode(),
		                "Erro no Banco de Dados",
		                JOptionPane.ERROR_MESSAGE);
	        }
	        
	       
	        e.printStackTrace();
	        
	    } finally {
	        fecharRecurso(rs);
	        fecharRecurso(pstProntuario);
	        fecharRecurso(pstConsulta);
	        fecharRecurso(pstComorbidade);
	        fecharRecurso(pstAlergia);
	        fecharRecurso(pstPaciente);
	        fecharRecurso(conexao);
	    }
	}
    
	
    
	private void fecharRecurso(AutoCloseable recurso) {
        if (recurso != null) {
            try {
                recurso.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

	private void limparCampos() {
	    FieldNome.setText("");
	    FieldCpf.setText("");
	    FieldEmail.setText("");
	    dcDataNascimento.setDate(null);
	    FieldProfissao.setText("");
	    FieldAlergia.setText("");
	    FieldComorbidade.setText("");
	    FieldPlanoSaude.setText("");
	    FieldTelefone.setText("");
	    FieldCep.setText("");
	    FieldRua.setText("");
	    FieldNumero.setText("");
	    FieldMunicipio.setText("");
	    FieldEstado.setText("");
	    FieldBairro.setText("");
	    boxSexo.setSelectedIndex(0);
	}
    
    
    /**
     * Implementa a busca automática de CEP
     */
    private void implementCEPAutoComplete() {
        FieldCep.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                buscarQuandoCompleto();
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Não faz nada
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                buscarQuandoCompleto();
            }
            
            private void buscarQuandoCompleto() {
                String cep = FieldCep.getText().replaceAll("[^0-9]", "");
                if (cep.length() == 8) {
                    Timer timer = new Timer(500, e2 -> buscarEnderecoPorCEP());
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        });
    }
    
    /**
     * Busca endereço por CEP
     */
    private void buscarEnderecoPorCEP() {
        String cep = FieldCep.getText().trim().replaceAll("[^0-9]", "");
        
        if (cep.length() != 8) {
            JOptionPane.showMessageDialog(this, "CEP deve conter 8 dígitos!", "CEP Inválido", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Mostra cursor de carregamento
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        
        SwingWorker<ViaCEPResponse, Void> worker = new SwingWorker<ViaCEPResponse, Void>() {
            @Override
            protected ViaCEPResponse doInBackground() throws Exception {
                try {
                    String url = "https://viacep.com.br/ws/" + cep + "/json/";
                    Request request = new Request.Builder()
                            .url(url)
                            .build();
                    
                    Response response = httpClient.newCall(request).execute();
                    String json = response.body().string();
                    
                    ViaCEPResponse viaCEPResponse = gson.fromJson(json, ViaCEPResponse.class);
                    return viaCEPResponse;
                    
                } catch (Exception e) {
                    return null;
                }
            }
            
            @Override
            protected void done() {
                setCursor(Cursor.getDefaultCursor());
                
                try {
                    ViaCEPResponse endereco = get();
                    
                    if (endereco == null || endereco.temErro()) {
                        JOptionPane.showMessageDialog(TelaAdministradorExcluirPaciente.this, 
                            "CEP não encontrado!\nVerifique o CEP digitado.", 
                            "CEP não encontrado", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    FieldMunicipio.setText(endereco.getLocalidade());
                    FieldEstado.setText(endereco.getUf());
                    FieldRua.setText(endereco.getLogradouro());
                    FieldBairro.setText(endereco.getBairro());
                    
                    // Foca no campo Número automaticamente
                    SwingUtilities.invokeLater(() -> {
                        FieldNumero.requestFocus();
                    });
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(TelaAdministradorExcluirPaciente.this,
                        "Erro na consulta ao CEP: " + e.getMessage(),
                        "Erro na Consulta",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        
        worker.execute();
    }

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	
	}
	
	private void buscarPaciente(String cpf) {
		Connection con = ConnectionFactory.getConnection();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    
	    try {
	    	stmt= con.prepareStatement("SELECT * FROM paciente WHERE cpf = ?");
	    	stmt.setString(1, cpf);
	    	rs=stmt.executeQuery();
	    	
	    	if (rs.next()) {
	    		FieldNome.setText(rs.getString("Nome"));
	    		dcDataNascimento.setDate(rs.getDate("Data_Nasc"));
	    		FieldCep.setText(rs.getString("CEP"));
	    		FieldEmail.setText(rs.getString("Email"));
	    		FieldTelefone.setText(rs.getString("Telefone"));
	    		boxSexo.setSelectedItem(rs.getString("Sexo"));
	    		FieldPlanoSaude.setText(rs.getString("Plano_De_Saude"));
	    		FieldProfissao.setText(rs.getString("Profissao"));
	    		FieldEstado.setText(rs.getString("Estado"));
	    		FieldMunicipio.setText(rs.getString("Municipio"));
	    		FieldBairro.setText(rs.getString("Bairro"));
	    		FieldRua.setText(rs.getString("Rua"));
	    		FieldNumero.setText(rs.getString("Num_casa"));
	    		
	    		
	    		//buscando alergias e comorbidades nas outras tabelas, usando o id do paciente
	    		this.idPaciente=rs.getInt("Id_Paciente");
	    		FieldAlergia.setText(buscarAlergias(con, idPaciente));
	    		FieldComorbidade.setText(buscarComorbidades(con, idPaciente));
	 
	    		
	    		JOptionPane.showMessageDialog(null, "Paciente encontrado!");
	    		
	    	} else {
	    		JOptionPane.showMessageDialog(null, "Paciente não encontrado! Por favor verifique novamente o cpf ou certifique-se de que ele é cadastrado no sistema!");
	    	}
	    	
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	JOptionPane.showMessageDialog (null, "Erro: "+ e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
	    	}
	    finally {
	    	try {
	    		if (rs!= null) rs.close();
	    		if (stmt!= null) stmt.close();
	    		if (con!=null) con.close();
	    		}
	    		 catch
	    			 (SQLException e) {
	    				 e.printStackTrace();
	    			 }
	    		 }
	    	
	    
	}
	private String buscarAlergias(Connection con, int idPaciente) {
		  String alergia = "";
		  PreparedStatement stmt = null;
		  ResultSet rs = null;
		  try {
			  stmt=con.prepareStatement("SELECT Alergia FROM Alergias WHERE id_Paciente= ?");
			  stmt.setInt(1, idPaciente);
			  rs=stmt.executeQuery();
			  while (rs.next()) {
				  alergia+= rs.getString("Alergia");
			  }
		  } catch(SQLException e) {
			  e.printStackTrace();
		  }
		  return alergia;
	}
	
	private String buscarComorbidades(Connection con, int idPaciente) {
		String comorbidade = "";
		 PreparedStatement stmt = null;
		    ResultSet rs = null;
		try {
			stmt=con.prepareStatement("SELECT Comorbidade FROM Comorbidades WHERE id_Paciente=?");
			stmt.setInt(1, idPaciente);
			rs=stmt.executeQuery();
			
			while (rs.next()) {
				comorbidade+=rs.getString("Comorbidade");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return comorbidade;
	}
}


