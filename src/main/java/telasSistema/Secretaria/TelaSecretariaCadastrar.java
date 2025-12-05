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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import com.toedter.calendar.JDateChooser;
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

public class TelaSecretariaCadastrar extends JFrame {

 
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
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textEmail;
	private JDateChooser dcDataNascimento;
    private JTextField textField; // CEP
    private JTextField textField_1; // Rua
    private JTextField textField_2; // Número
    private JTextField textMunicipio;
    private JTextField textEstadoUF;
    private JTextField textBairro;
    
    // Componentes para API
    private OkHttpClient httpClient;
    private Gson gson;
    private JPasswordField TelefoneField;
    private JPasswordField PlanoSaudeField;
    private JTextField textProfissao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSecretariaCadastrar frame = new TelaSecretariaCadastrar();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaSecretariaCadastrar() {
		// INICIALIZA AS BIBLIOTECAS DA API
		httpClient = new OkHttpClient();
		gson = new Gson();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 222, 239));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		contentPane.setLayout(null);
		
		JLabel LabelCadastroPaciente = new JLabel("Cadastro do Paciente:");
		LabelCadastroPaciente.setBounds(315, 0, 277, 67);
		LabelCadastroPaciente.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		contentPane.add(LabelCadastroPaciente);
		
		textNome = new JTextField();
		textNome.setBounds(21, 142, 206, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCPF = new JTextField();
		textCPF.setBounds(279, 142, 86, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setToolTipText("Ex: costelinha123@gmail.com...");
		textEmail.setBounds(21, 198, 206, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
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
                realizarCadastro();
            }
        });
        btnCadastro.setBounds(683, 401, 135, 35);
        contentPane.add(btnCadastro);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaSecretariaAgendar tela = new TelaSecretariaAgendar();
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
        
        textField = new JTextField(); // CEP
        textField.setBounds(644, 140, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Rua:");
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNewLabel_1.setBounds(740, 230, 46, 14);
        contentPane.add(lblNewLabel_1);
        
        textField_1 = new JTextField(); // Rua
        textField_1.setBounds(740, 255, 86, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Número:");
        lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNewLabel_2.setBounds(740, 286, 72, 14);
        contentPane.add(lblNewLabel_2);
        
        textField_2 = new JTextField(); // Número
        textField_2.setBounds(740, 311, 59, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblBairro.setBounds(644, 230, 46, 14);
        contentPane.add(lblBairro);
        
        textBairro = new JTextField(); // Bairro
        textBairro.setBounds(644, 255, 86, 20);
        contentPane.add(textBairro);
        textBairro.setColumns(10);
        
        JLabel lblMunicipio = new JLabel("Município:");
        lblMunicipio.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblMunicipio.setBounds(740, 173, 72, 14);
        contentPane.add(lblMunicipio);
        
        textMunicipio = new JTextField(); // Município
        textMunicipio.setBounds(740, 198, 86, 20);
        contentPane.add(textMunicipio);
        textMunicipio.setColumns(10);
        
        JLabel lblEstadoUF = new JLabel("Estado(UF):");
        lblEstadoUF.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblEstadoUF.setBounds(644, 173, 72, 14);
        contentPane.add(lblEstadoUF);
        
        textEstadoUF = new JTextField(); // Estado(UF)
        textEstadoUF.setBounds(644, 198, 46, 20);
        contentPane.add(textEstadoUF);
        textEstadoUF.setColumns(10);
        
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
        
        TelefoneField = new JPasswordField();
        TelefoneField.setToolTipText("Telefone");
        TelefoneField.setBounds(279, 198, 206, 20);
        contentPane.add(TelefoneField);
        
        JLabel lblDigiteOTelefone = new JLabel("Digite o Telefone:");
        lblDigiteOTelefone.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblDigiteOTelefone.setBounds(289, 172, 189, 14);
        contentPane.add(lblDigiteOTelefone);
        
        PlanoSaudeField = new JPasswordField();
        PlanoSaudeField.setToolTipText("Plano de saúde");
        PlanoSaudeField.setBounds(21, 255, 206, 20);
        contentPane.add(PlanoSaudeField);
        
        JLabel lblDigitePlano = new JLabel("Digite o Plano de saúde:");
        lblDigitePlano.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblDigitePlano.setBounds(31, 231, 189, 14);
        contentPane.add(lblDigitePlano);
        
        JLabel lblDigiteProfissao = new JLabel("Digite a profissão:");
        lblDigiteProfissao.setToolTipText("Digite a profissão:");
        lblDigiteProfissao.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblDigiteProfissao.setBounds(279, 231, 189, 14);
        contentPane.add(lblDigiteProfissao);
        
        textProfissao = new JTextField();
        textProfissao.setToolTipText("Digite a profissão:");
        textProfissao.setBounds(279, 255, 206, 18);
        contentPane.add(textProfissao);
        textProfissao.setColumns(10);
        
        JComboBox textSexo = new JComboBox();
        textSexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
        textSexo.setBounds(533, 197, 46, 22);
        contentPane.add(textSexo);

        
        // ADICIONA LISTENER PARA BUSCA AUTOMÁTICA DE CEP
        implementCEPAutoComplete();
	}
    
    /**
     * Método para realizar o cadastro
     */
    private void realizarCadastro() {
        String mensagem = "";
        int camposEmBranco = 0;
        
        if (textNome.getText().trim().isEmpty()) {
            camposEmBranco++;
            mensagem += "Nome\n";
        }
        if (textCPF.getText().trim().isEmpty()) {
            camposEmBranco++;
            mensagem += "CPF\n";
        }
        if (textEmail.getText().trim().isEmpty()) {
            camposEmBranco++;
            mensagem += "Email\n";
        }
      
        if (dcDataNascimento.getDate() == null) {
            camposEmBranco++;
            mensagem += "Data de Nascimento\n";
        }
        
        if (camposEmBranco > 0) {
            JOptionPane.showMessageDialog(
                null,
                "Preencha os campos:\n" + mensagem,
                "Erro de Validação",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
 
        }
    
    /**
     * Implementa a busca automática de CEP
     */
    private void implementCEPAutoComplete() {
        textField.getDocument().addDocumentListener(new DocumentListener() {
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
                String cep = textField.getText().replaceAll("[^0-9]", "");
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
        String cep = textField.getText().trim().replaceAll("[^0-9]", "");
        
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
                        JOptionPane.showMessageDialog(TelaSecretariaCadastrar.this, 
                            "CEP não encontrado!\nVerifique o CEP digitado.", 
                            "CEP não encontrado", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    textMunicipio.setText(endereco.getLocalidade());
                    textEstadoUF.setText(endereco.getUf());
                    textField_1.setText(endereco.getLogradouro());
                    textBairro.setText(endereco.getBairro());
                    
                    // Foca no campo Número automaticamente
                    SwingUtilities.invokeLater(() -> {
                        textField_2.requestFocus();
                    });
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(TelaSecretariaCadastrar.this,
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