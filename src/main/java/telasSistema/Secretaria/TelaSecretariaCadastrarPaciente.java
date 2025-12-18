package telasSistema.Secretaria;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaSecretariaCadastrarPaciente extends JFrame {

 
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
					TelaSecretariaCadastrarPaciente frame = new TelaSecretariaCadastrarPaciente();
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
	public TelaSecretariaCadastrarPaciente() {
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
		
		JLabel LabelCadastroPaciente = new JLabel("Cadastro do Paciente:");
		LabelCadastroPaciente.setBounds(315, 0, 277, 67);
		LabelCadastroPaciente.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		contentPane.add(LabelCadastroPaciente);
		
		FieldNome = new JTextField();
		FieldNome.setBounds(21, 142, 206, 20);
		contentPane.add(FieldNome);
		FieldNome.setColumns(10);
		
		FieldCpf = new JTextField();
		FieldCpf.setBounds(279, 142, 86, 20);
		contentPane.add(FieldCpf);
		FieldCpf.setColumns(10);
		
		FieldEmail = new JTextField();
		FieldEmail.setToolTipText("Ex: costelinha123@gmail.com...");
		FieldEmail.setBounds(21, 198, 206, 20);
		contentPane.add(FieldEmail);
		FieldEmail.setColumns(10);
		
		JLabel LabelEmail = new JLabel("Digite o Email:");
		LabelEmail.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		LabelEmail.setBounds(31, 172, 189, 14);
		contentPane.add(LabelEmail);
		
		JLabel LabelCPF = new JLabel("CPF:");
		LabelCPF.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		LabelCPF.setBounds(260, 118, 154, 14);
		contentPane.add(LabelCPF);
		
		JLabel LabelNome = new JLabel("Nome Completo:");
		LabelNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		LabelNome.setBounds(21, 118, 206, 14);
		contentPane.add(LabelNome);
		
		JLabel LabelDataNascimento = new JLabel("Insira a Data de Nascimento:");
		LabelDataNascimento.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		LabelDataNascimento.setBounds(438, 118, 167, 14);
		contentPane.add(LabelDataNascimento);
        
        // --- JCALENDAR ---
        dcDataNascimento = new JDateChooser();
        dcDataNascimento.setToolTipText("Ex: 25/06/2003...");
        dcDataNascimento.setDateFormatString("dd/MM/yyyy");
        dcDataNascimento.setBounds(441, 142, 120, 20); 
        contentPane.add(dcDataNascimento);
        
        JButton btnCadastro = new JButton("Cadastrar");
        btnCadastro.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        btnCadastro.setForeground(new Color(0, 0, 0));
        btnCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if (realizarValidação()) {
                
				try {
					cadastrarDadosPaciente();
				} catch (SQLException ex) {
	                JOptionPane.showMessageDialog(null,
	                        "Erro SQL: " + ex.getMessage(),
	                        "Erro no Banco de Dados",
	                        JOptionPane.ERROR_MESSAGE);
	                    ex.printStackTrace();
	                }catch (Exception ex) {
	                    JOptionPane.showMessageDialog(null,
	                            "Erro inesperado: " + ex.getMessage(),
	                            "Erro",
	                            JOptionPane.ERROR_MESSAGE);
	                        ex.printStackTrace();
	                    }

				
				
               }
               }
        });
        btnCadastro.setBounds(683, 401, 135, 35);
        contentPane.add(btnCadastro);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaPrincipalSecretaria tela = new TelaPrincipalSecretaria();
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
        lblNewLabel.setBounds(652, 117, 46, 14);
        contentPane.add(lblNewLabel);
        
        FieldCep = new JTextField(); // CEP
        FieldCep.setBounds(644, 140, 86, 20);
        contentPane.add(FieldCep);
        FieldCep.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Rua:");
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNewLabel_1.setBounds(740, 230, 46, 14);
        contentPane.add(lblNewLabel_1);
        
        FieldRua = new JTextField(); // Rua
        FieldRua.setBounds(740, 255, 86, 20);
        contentPane.add(FieldRua);
        FieldRua.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Número:");
        lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNewLabel_2.setBounds(740, 286, 72, 14);
        contentPane.add(lblNewLabel_2);
        
        FieldNumero = new JTextField(); // Número
        FieldNumero.setBounds(740, 311, 59, 20);
        contentPane.add(FieldNumero);
        FieldNumero.setColumns(10);
        
        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblBairro.setBounds(644, 230, 46, 14);
        contentPane.add(lblBairro);
        
        FieldBairro = new JTextField(); // Bairro
        FieldBairro.setBounds(644, 255, 86, 20);
        contentPane.add(FieldBairro);
        FieldBairro.setColumns(10);
        
        JLabel lblMunicipio = new JLabel("Município:");
        lblMunicipio.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblMunicipio.setBounds(740, 173, 72, 14);
        contentPane.add(lblMunicipio);
        
        FieldMunicipio = new JTextField(); // Município
        FieldMunicipio.setBounds(740, 198, 86, 20);
        contentPane.add(FieldMunicipio);
        FieldMunicipio.setColumns(10);
        
        JLabel lblEstadoUF = new JLabel("Estado(UF):");
        lblEstadoUF.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblEstadoUF.setBounds(644, 173, 72, 14);
        contentPane.add(lblEstadoUF);
        
        FieldEstado = new JTextField(); // Estado(UF)
        FieldEstado.setBounds(644, 198, 46, 20);
        contentPane.add(FieldEstado);
        FieldEstado.setColumns(10);
        
        // BOTÃO PARA BUSCAR CEP
        JButton btnBuscarCEP = new JButton("Buscar");
        btnBuscarCEP.setBounds(740, 140, 83, 20);
        btnBuscarCEP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarEnderecoPorCEP();
            }
        });
        contentPane.add(btnBuscarCEP);
        
        JLabel lblPreenchaOsDados = new JLabel("Preencha os dados do(a) profissional:");
        lblPreenchaOsDados.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblPreenchaOsDados.setBounds(338, 56, 223, 14);
        contentPane.add(lblPreenchaOsDados);
        
        JLabel lblDigiteOTelefone = new JLabel("Digite o Telefone:");
        lblDigiteOTelefone.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblDigiteOTelefone.setBounds(289, 172, 189, 14);
        contentPane.add(lblDigiteOTelefone);
        
        JLabel lblDigitePlano = new JLabel("Digite o Plano de saúde:");
        lblDigitePlano.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblDigitePlano.setBounds(31, 231, 189, 14);
        contentPane.add(lblDigitePlano);
        
        JLabel lblDigiteProfissao = new JLabel("Digite a profissão:");
        lblDigiteProfissao.setToolTipText("Digite a profissão:");
        lblDigiteProfissao.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblDigiteProfissao.setBounds(279, 231, 189, 14);
        contentPane.add(lblDigiteProfissao);
        
        FieldProfissao = new JTextField();
        FieldProfissao.setToolTipText("Digite a profissão:");
        FieldProfissao.setBounds(279, 255, 206, 18);
        contentPane.add(FieldProfissao);
        FieldProfissao.setColumns(10);
        
         boxSexo = new JComboBox();
        boxSexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
        boxSexo.setBounds(533, 197, 46, 22);
        contentPane.add(boxSexo);
        
        JLabel lblDigiteSuasAlergias = new JLabel("Digite a(s) alergia(a):");
        lblDigiteSuasAlergias.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblDigiteSuasAlergias.setBounds(31, 304, 189, 14);
        contentPane.add(lblDigiteSuasAlergias);
        
        JLabel lblDigiteAsComorbidades = new JLabel("Digite a(s) comorbidade(s):");
        lblDigiteAsComorbidades.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblDigiteAsComorbidades.setBounds(279, 304, 189, 14);
        contentPane.add(lblDigiteAsComorbidades);
        
        FieldPlanoSaude = new JTextField();
        FieldPlanoSaude.setBounds(21, 255, 206, 20);
        contentPane.add(FieldPlanoSaude);
        FieldPlanoSaude.setColumns(10);
        
        FieldAlergia = new JTextField();
        FieldAlergia.setBounds(21, 329, 206, 20);
        contentPane.add(FieldAlergia);
        FieldAlergia.setColumns(10);
        
        FieldComorbidade = new JTextField();
        FieldComorbidade.setColumns(10);
        FieldComorbidade.setBounds(279, 329, 206, 20);
        contentPane.add(FieldComorbidade);
        
        FieldTelefone = new JTextField();
        FieldTelefone.setText("(81)");
        FieldTelefone.setColumns(10);
        FieldTelefone.setBounds(279, 198, 206, 20);
        contentPane.add(FieldTelefone);

        
        // ADICIONA LISTENER PARA BUSCA AUTOMÁTICA DE CEP
        implementCEPAutoComplete();
	}
	public void cadastrarDadosPaciente() throws SQLException {
	    Connection conn = null;
	    PreparedStatement pstPaciente = null;
	    PreparedStatement pstAlergia = null;
	    PreparedStatement pstComorbidade = null;
	    ResultSet rs = null;
	    
	    try {
	        // desativa autocommit
	        conexao.setAutoCommit(false);
	        
	        
	        String sqlPaciente = "INSERT INTO paciente (Email, Nome, Data_Nasc, Bairro, Rua, Num_Casa, Municipio, Plano_De_Saude, CEP,  CPF, Telefone, Estado, Profissao, Sexo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	        pstPaciente = conexao.prepareStatement(sqlPaciente, Statement.RETURN_GENERATED_KEYS);
	      //o metodo abaixo ele utiliza a tabela de paciente como referencia
	        // Preenche os parâmetros (igual ao seu código)
	        pstPaciente.setString(1, FieldEmail.getText());
	        pstPaciente.setString(2, FieldNome.getText());
	        
	        // Data de nascimento
	        java.util.Date dataUtil = dcDataNascimento.getDate();
	        if (dataUtil != null) {
	            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
	            pstPaciente.setDate(3, dataSql);
	        } else {
	            pstPaciente.setNull(3, java.sql.Types.DATE);
	        }
	        
	        pstPaciente.setString(4, FieldBairro.getText());
	        pstPaciente.setString(5, FieldRua.getText());
	        pstPaciente.setString(6, FieldNumero.getText());
	        pstPaciente.setString(7, FieldMunicipio.getText());
	        pstPaciente.setString(8, FieldPlanoSaude.getText());
	        pstPaciente.setString(9, FieldCep.getText());
	        pstPaciente.setString(10, FieldCpf.getText());
	        pstPaciente.setString(11, FieldTelefone.getText());
	        pstPaciente.setString(12, FieldEstado.getText());
	        pstPaciente.setString(13, FieldProfissao.getText());
	        
	        String sexo = (String) boxSexo.getSelectedItem();
	        pstPaciente.setString(14, sexo != null ? sexo : "");
	        
	        int linhasAfetadas = pstPaciente.executeUpdate();
	        
	        if (linhasAfetadas == 0) {
	            throw new SQLException("Falha ao cadastrar paciente");
	        }
	        
	        //   pega o idPaciente que é autoincrement
	        rs = pstPaciente.getGeneratedKeys();
	        int idPaciente = 0;
	        if (rs.next()) {
	            idPaciente = rs.getInt(1);
	        }
	        
	        String alergia = FieldAlergia.getText().trim();
	            String sqlAlergia = "INSERT INTO alergias(Id_Paciente, Alergia) VALUES (?,?)";
	            pstAlergia = conexao.prepareStatement(sqlAlergia);
	            pstAlergia.setInt(1, idPaciente);
	            pstAlergia.setString(2, alergia);
	            pstAlergia.executeUpdate();
	        
	        
	        String comorbidade = FieldComorbidade.getText().trim();
	       
	            String sqlComorbidade = "INSERT INTO comorbidades(Id_Paciente, Comorbidade) VALUES (?,?)";
	            pstComorbidade = conexao.prepareStatement(sqlComorbidade);
	            pstComorbidade.setInt(1, idPaciente);
	            pstComorbidade.setString(2, comorbidade);
	            pstComorbidade.executeUpdate();
	        
	        
	        conexao.commit();
	        
	        JOptionPane.showMessageDialog(null,
	            "Paciente cadastrado com sucesso! ID: " + idPaciente,
	            "Sucesso", JOptionPane.INFORMATION_MESSAGE);
	        
	        limparCampos();
	        
	    } catch (Exception e) {
	        if (conexao != null) {
	            try {
	                conexao.rollback();
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }
	        }
	        
	        JOptionPane.showMessageDialog(null,
	            "Erro ao cadastrar paciente: " + e.getMessage(),
	            "Erro no Cadastro", JOptionPane.ERROR_MESSAGE);
	        throw e;
	        
	    } finally {
	        if (rs != null) try { rs.close(); } catch (SQLException e) {}
	        if (pstPaciente != null) try { pstPaciente.close(); } catch (SQLException e) {}
	        if (pstAlergia != null) try { pstAlergia.close(); } catch (SQLException e) {}
	        if (pstComorbidade != null) try { pstComorbidade.close(); } catch (SQLException e) {}
	        
	        if (conexao != null) {
	            try {
	                conexao.setAutoCommit(true);
	            } catch (SQLException e) {}
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
     * Método para realizar o cadastro
     */
  
        
        private boolean realizarValidação() {
            String mensagem = "";
            int camposEmBranco = 0;
            
            if (FieldNome.getText().trim().isEmpty()) {
                camposEmBranco++;
                mensagem += "Nome\n";
            }
            if (FieldCpf.getText().trim().isEmpty()) {
                camposEmBranco++;
                mensagem += "CPF\n";
            }
            if (FieldEmail.getText().trim().isEmpty()) {
                camposEmBranco++;
                mensagem += "Email\n";
            }
          
            if (dcDataNascimento.getDate() == null) {
                camposEmBranco++;
                mensagem += "Data de Nascimento\n";
            }
            if(FieldProfissao.getText().trim().isEmpty()) {
            	camposEmBranco++;
                mensagem += "Profissão\n";
            }
            if(FieldAlergia.getText().trim().isEmpty()) {
            	camposEmBranco++;
                mensagem += "Alergia\n";
            }
            if(FieldComorbidade.getText().trim().isEmpty()) {
            	camposEmBranco++;
                mensagem += "Comorbidade\n";
            }
            if(FieldPlanoSaude.getText().trim().isEmpty()) {
            	camposEmBranco++;
                mensagem += "Plano de Saude\n";
            }
            if(FieldTelefone.getText().trim().isEmpty()) {
            	camposEmBranco++;
                mensagem += "Telefone\n";
            }        
        if (camposEmBranco > 0) {
            JOptionPane.showMessageDialog(
                null,
                "Preencha os campos:\n" + mensagem,
                "Erro de Validação",
                JOptionPane.WARNING_MESSAGE
              
            	);
          return false;
        }
        
        String cpf = FieldCpf.getText().replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            JOptionPane.showMessageDialog(null,
                "CPF inválido! Deve conter 11 dígitos.",
                "CPF Inválido",
                JOptionPane.WARNING_MESSAGE);
            FieldCpf.requestFocus();
            return false;
        }
        String email = FieldEmail.getText().trim();
        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(null,
                "Email inválido! Digite um email válido.",
                "Email Inválido",
                JOptionPane.WARNING_MESSAGE);
            FieldEmail.requestFocus();
            return false;
        }
        String telefone = FieldTelefone.getText().replaceAll("[^0-9]", "");
        if (telefone.length() < 10) {
            JOptionPane.showMessageDialog(null,
                "Telefone inválido! Deve conter no mínimo 10 dígitos.",
                "Telefone Inválido",
                JOptionPane.WARNING_MESSAGE);
            FieldTelefone.requestFocus();
            return false;
        }
		return true;
 
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
                        JOptionPane.showMessageDialog(TelaSecretariaCadastrarPaciente.this, 
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
                    JOptionPane.showMessageDialog(TelaSecretariaCadastrarPaciente.this,
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
}