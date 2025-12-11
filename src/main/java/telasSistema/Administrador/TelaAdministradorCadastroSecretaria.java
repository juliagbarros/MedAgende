package telasSistema.Administrador;

import java.util.*;
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
import javax.swing.JProgressBar;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import com.toedter.calendar.JDateChooser;

import dao.UsuarioDAO;
import model.Usuario;

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


public class TelaAdministradorCadastroSecretaria extends JFrame {

    // Enum para definir os níveis de força
    private enum PasswordStrength {
        WEAK, // Fraca
        MEDIUM, // Média
        STRONG // Forte
    }

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
	private JPasswordField textConfirmarSenha;
	private JDateChooser textDataNascimento;
    
    // NOVOS COMPONENTES PARA FEEDBACK
    private JLabel lblStrengthFeedbackNIVELSENHA;
    private JProgressBar progressBarBARRAdoNIVELSENHA;
    private JTextField textCEP; // CEP
    private JTextField textRua; // Rua
    private JTextField textNumero; // Número
    private JTextField textMunicipio;
    private JTextField textEstado;
    private JTextField textBairro;
    
    // Componentes para API
    private OkHttpClient httpClient;
    private Gson gson;
    private JTextField textPlano;
    private JTextField textTelefone;
    private JPasswordField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministradorCadastroSecretaria frame = new TelaAdministradorCadastroSecretaria();
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
	public TelaAdministradorCadastroSecretaria() {
		// INICIALIZA AS BIBLIOTECAS DA API
		httpClient = new OkHttpClient();
		gson = new Gson();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 222, 239));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		contentPane.setLayout(null);
		
		JLabel labelCadastroUsuarios = new JLabel("Cadastro de Secretária(o)");
		labelCadastroUsuarios.setBounds(315, 0, 277, 67);
		labelCadastroUsuarios.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		contentPane.add(labelCadastroUsuarios);
		
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
		
		JLabel labelEmail = new JLabel("Digite o Email:");
		labelEmail.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		labelEmail.setBounds(31, 172, 189, 14);
		contentPane.add(labelEmail);
		
		JLabel labelSENHA = new JLabel("Digite aqui a senha que deseja usar:");
		labelSENHA.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		labelSENHA.setBounds(232, 172, 206, 14);
		contentPane.add(labelSENHA);
		
		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		labelCPF.setBounds(260, 118, 154, 14);
		contentPane.add(labelCPF);
		
		JLabel labelNome = new JLabel("Nome Completo:");
		labelNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		labelNome.setBounds(21, 118, 206, 14);
		contentPane.add(labelNome);
		
		JLabel labelDataNascimento = new JLabel("Insira a Data de Nascimento:");
		labelDataNascimento.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		labelDataNascimento.setBounds(438, 118, 167, 14);
		contentPane.add(labelDataNascimento);
        
        // --- JCALENDAR ---
        textDataNascimento = new JDateChooser();
        textDataNascimento.setToolTipText("Ex: 15/76/2002...");
        textDataNascimento.setDateFormatString("dd/MM/yyyy");
        textDataNascimento.setBounds(441, 142, 120, 20); 
        contentPane.add(textDataNascimento);
		
		textConfirmarSenha = new JPasswordField();
		textConfirmarSenha.setBounds(457, 198, 135, 20);
		contentPane.add(textConfirmarSenha);
		
		JLabel labelCONFIRMARSENHA = new JLabel("Confirme a senha:");
		labelCONFIRMARSENHA.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		labelCONFIRMARSENHA.setBounds(468, 172, 124, 14);
		contentPane.add(labelCONFIRMARSENHA);
		
		// configuração dos novos componentes 
		lblStrengthFeedbackNIVELSENHA = new JLabel("Nível da Senha:");
		lblStrengthFeedbackNIVELSENHA.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblStrengthFeedbackNIVELSENHA.setBounds(203, 229, 100, 14);
		contentPane.add(lblStrengthFeedbackNIVELSENHA);
        
        // Barra de progresso para feedback visual
        progressBarBARRAdoNIVELSENHA = new JProgressBar(0, 5);
        progressBarBARRAdoNIVELSENHA.setBounds(293, 228, 72, 20);
        progressBarBARRAdoNIVELSENHA.setStringPainted(true);
        contentPane.add(progressBarBARRAdoNIVELSENHA);
        
        JButton btnCadastro = new JButton("Cadastrar");
        btnCadastro.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnCadastro.setForeground(new Color(0, 0, 0));
        btnCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarCadastro();
            }
        });
        btnCadastro.setBounds(677, 409, 135, 35);
        contentPane.add(btnCadastro);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaPrincipalAdministrador tela = new TelaPrincipalAdministrador();
				tela.setVisible(true);
				 dispose();
        	}
        });
        btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnVoltar.setBounds(40, 410, 125, 32);
        contentPane.add(btnVoltar);
        
        JLabel lblNewLabel = new JLabel("CEP:");
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNewLabel.setBounds(652, 117, 46, 14);
        contentPane.add(lblNewLabel);
        
        textCEP = new JTextField(); // CEP
        textCEP.setBounds(644, 140, 86, 20);
        contentPane.add(textCEP);
        textCEP.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Rua:");
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNewLabel_1.setBounds(740, 230, 46, 14);
        contentPane.add(lblNewLabel_1);
        
        textRua = new JTextField(); // Rua
        textRua.setBounds(740, 255, 86, 20);
        contentPane.add(textRua);
        textRua.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Número:");
        lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNewLabel_2.setBounds(740, 286, 72, 14);
        contentPane.add(lblNewLabel_2);
        
        textNumero = new JTextField(); // Número
        textNumero.setBounds(740, 311, 59, 20);
        contentPane.add(textNumero);
        textNumero.setColumns(10);
        
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
        
        textEstado = new JTextField(); // Estado(UF)
        textEstado.setBounds(644, 198, 46, 20);
        contentPane.add(textEstado);
        textEstado.setColumns(10);
        
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
        lblDigiteOTelefone.setBounds(40, 253, 189, 14);
        contentPane.add(lblDigiteOTelefone);
        
        JLabel lblDigiteOPlano = new JLabel("Digite o Plano de saúde:");
        lblDigiteOPlano.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblDigiteOPlano.setBounds(279, 256, 189, 14);
        contentPane.add(lblDigiteOPlano);
        
        textPlano = new JTextField();
        textPlano.setBounds(260, 286, 153, 18);
        contentPane.add(textPlano);
        textPlano.setColumns(10);
        
        textTelefone = new JTextField();
        textTelefone.setToolTipText("Digite o telefone");
        textTelefone.setBounds(21, 284, 156, 18);
        contentPane.add(textTelefone);
        textTelefone.setColumns(10);
        
        textSenha = new JPasswordField();
        textSenha.setBounds(242, 198, 172, 18);
        contentPane.add(textSenha);

		// chamando o método que implementa O DocumentListener
        implementPasswordStrengthCheck();
        
        // ADICIONA LISTENER PARA BUSCA AUTOMÁTICA DE CEP
        implementCEPAutoComplete();
	}
    
    /**
     * Método para realizar o cadastro
     */
    private void realizarCadastro() {
    	
    	Usuario u = new Usuario ();
    	UsuarioDAO dao = new UsuarioDAO();
    	
    	u.setNome(textNome.getText());
    	u.setEmail(textEmail.getText());
    	u.setCPF(textCPF.getText());
    	u.setSenha(new String(textSenha.getPassword()));
    	Date data = textDataNascimento.getDate();
    	if (data == null) {
    	    JOptionPane.showMessageDialog(null, "Data de nascimento inválida");
    	    return;
    	}
    	u.setDataNasc(data);
    	u.setBairro(textBairro.getText());
    	u.setCep(textCEP.getText());
    	u.setCidade(textMunicipio.getText());
    	u.setRua(textRua.getText());
    	u.setNumCasa(textNumero.getText());
    	u.setPlanoDeSaude(textPlano.getText());
    	u.setTelefone(textTelefone.getText());
    	u.setServico("Secretária");
    	
    	try {
    	    dao.create(u);
    	    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
    	} 
    	catch (Exception e) {
    	    JOptionPane.showMessageDialog(null, 
    	        "Erro ao cadastrar usuário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    	}
    	
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
        if (textSenha.getPassword().length == 0) {
            camposEmBranco++;
            mensagem += "Senha\n";
        }
        if (textConfirmarSenha.getPassword().length == 0) {
            camposEmBranco++;
            mensagem += "Confirmação de Senha\n";
        }
        if (textDataNascimento.getDate() == null) {
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
        
        // Verificar se senhas coincidem
        String senha = new String(((JPasswordField) textSenha).getPassword());
        String confirmacao = new String(textConfirmarSenha.getPassword());
        
        if (!senha.equals(confirmacao)) {
            JOptionPane.showMessageDialog(
                null,
                "As senhas não coincidem!",
                "Erro de Validação",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
 
        }
    /**
     * Método para abrir a tela de login
     */
    //private void abrirTelaLogin() {
       //  TelaLogin tela = new TelaLogin();
       // tela.setLocationRelativeTo(null);
       // tela.setVisible(true);
       // dispose();
  //  }
    
    /**
     * Avalia a força da senha com base em vários critérios
     */
    private PasswordStrength checkPasswordStrength(String password) {
        int score = 0;
        
        // Verifica se está vazia
        if (password.length() == 0) {
            return PasswordStrength.WEAK;
        }
        
        // Pontua por comprimento
        if (password.length() >= 8) {
            score++;
        }
        if (password.length() >= 12) {
            score++;
        }
        
        // Pelo menos uma minúscula
        if (password.matches(".*[a-z].*")) { 
            score++;
        }
        // Pelo menos uma maiúscula
        if (password.matches(".*[A-Z].*")) { 
            score++;
        }
        // Pelo menos um número
        if (password.matches(".*[0-9].*")) { 
            score++;
        }
        // Pelo menos um símbolo/caractere especial 
        if (password.matches(".*[^a-zA-Z0-9].*")) { 
            score++;
        }
        
        // Define a força com base na pontuação total
        if (score >= 5) {
            return PasswordStrength.STRONG;
        } else if (score >= 3) {
            return PasswordStrength.MEDIUM;
        } else {
            return PasswordStrength.WEAK;
        }
    }

    /**
     * Implementa a verificação de força da senha
     */
    private void implementPasswordStrengthCheck() {
        textSenha.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkAndUpdateUI();
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                checkAndUpdateUI();
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Não usado para JPasswordField
            }

            private void checkAndUpdateUI() {
                String password = new String(textSenha.getPassword());
                
                if (password.isEmpty()) {
                    lblStrengthFeedbackNIVELSENHA.setText("Nível da Senha:");
                    lblStrengthFeedbackNIVELSENHA.setForeground(Color.BLACK);
                    progressBarBARRAdoNIVELSENHA.setValue(0);
                    progressBarBARRAdoNIVELSENHA.setString("");
                    return;
                }
                
                PasswordStrength strength = checkPasswordStrength(password);
                
                // Atualiza a interface
                switch (strength) {
                    case WEAK:
                        lblStrengthFeedbackNIVELSENHA.setText("Nível da Senha:");
                        lblStrengthFeedbackNIVELSENHA.setForeground(Color.RED);
                        progressBarBARRAdoNIVELSENHA.setValue(1);
                        progressBarBARRAdoNIVELSENHA.setForeground(Color.RED);
                        progressBarBARRAdoNIVELSENHA.setString("Fraca");
                        break;
                    case MEDIUM:
                        lblStrengthFeedbackNIVELSENHA.setText("Nível da Senha:");
                        lblStrengthFeedbackNIVELSENHA.setForeground(Color.ORANGE.darker());
                        progressBarBARRAdoNIVELSENHA.setValue(3);
                        progressBarBARRAdoNIVELSENHA.setForeground(Color.ORANGE.darker());
                        progressBarBARRAdoNIVELSENHA.setString("Média");
                        break;
                    case STRONG:
                        lblStrengthFeedbackNIVELSENHA.setText("Nível da Senha:");
                        lblStrengthFeedbackNIVELSENHA.setForeground(Color.GREEN.darker());
                        progressBarBARRAdoNIVELSENHA.setValue(5);
                        progressBarBARRAdoNIVELSENHA.setForeground(Color.GREEN.darker());
                        progressBarBARRAdoNIVELSENHA.setString("Forte");
                        break;
                }
            }
        });
    }
    
    /**
     * Implementa a busca automática de CEP
     */
    private void implementCEPAutoComplete() {
        textCEP.getDocument().addDocumentListener(new DocumentListener() {
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
                String cep = textCEP.getText().replaceAll("[^0-9]", "");
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
        String cep = textCEP.getText().trim().replaceAll("[^0-9]", "");
        
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
                	e.printStackTrace();
                    return null;
                }
            }
            
            @Override
            protected void done() {
                setCursor(Cursor.getDefaultCursor());
                
                try {
                    ViaCEPResponse endereco = get();
                    
                    if (endereco == null || endereco.temErro()) {
                        JOptionPane.showMessageDialog(TelaAdministradorCadastroSecretaria.this, 
                            "CEP não encontrado!\nVerifique o CEP digitado.", 
                            "CEP não encontrado", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    textMunicipio.setText(endereco.getLocalidade());
                    textEstado.setText(endereco.getUf());
                    textRua.setText(endereco.getLogradouro());
                    textBairro.setText(endereco.getBairro());
                    
                    // Foca no campo Número automaticamente
                    SwingUtilities.invokeLater(() -> {
                        textNumero.requestFocus();
                    });
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(TelaAdministradorCadastroSecretaria.this,
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
