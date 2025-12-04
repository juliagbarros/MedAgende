package telasSistema;

import java.util.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color; // Importação adicionada para cores
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JProgressBar;
import javax.swing.event.DocumentEvent; // Importação para DocumentListener
import javax.swing.event.DocumentListener; // Importação para DocumentListener

import com.toedter.calendar.JDateChooser; //Jcalendar importado;
import java.util.Arrays;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTree;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Checkbox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox; // Importação para Arrays.fill (boa prática de segurança)
import javax.swing.Timer; // Importação para Timer
import java.awt.Cursor; // Importação para Cursor

// IMPORTAÇÕES PARA API DOS CORREIOS
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class TelaCadastro extends JFrame {

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
    }

    // CLASSE INTERNA PARA O SERVIÇO DA API
    private static class ViaCEPService {
        private static final String VIA_CEP_URL = "https://viacep.com.br/ws/%s/json/";
        
        public ViaCEPResponse buscarCEP(String cep) throws IOException {
            // Remove caracteres não numéricos
            cep = cep.replaceAll("[^0-9]", "");
            
            if (cep.length() != 8) {
                throw new IllegalArgumentException("CEP deve conter 8 dígitos");
            }
            
            OkHttpClient client = new OkHttpClient();
            String url = String.format(VIA_CEP_URL, cep);
            
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    throw new IOException("Erro na requisição: " + response.code());
                }
                
                String jsonResponse = response.body().string();
                
                // Verifica se o CEP não foi encontrado
                if (jsonResponse.contains("\"erro\": true")) {
                    return null;
                }
                
                Gson gson = new Gson();
                return gson.fromJson(jsonResponse, ViaCEPResponse.class);
            }
        }
    }

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textEmail;
	private JPasswordField passwordFieldSENHA;
	private JPasswordField passwordCONFIRMARSENHA;
	private JDateChooser dcDataNascimento;
    
    // NOVOS COMPONENTES PARA FEEDBACK
    private JLabel lblStrengthFeedbackNIVELSENHA; // Rótulo para texto (Fraca, Forte)
    private JProgressBar progressBarBARRAdoNIVELSENHA; // Barra de progresso para visualização
    private JTextField textField; // CEP
    private JTextField textField_1; // Rua
    private JTextField textField_2; // Número
    private JTextField textMunicipio;
    private JTextField textEstadoUF;
    private JTextField textBairro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	public TelaCadastro() {
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
		popupMenu.setLocation(420, 336);
		addPopup(contentPane, popupMenu);
		contentPane.setLayout(null);
		
		JLabel LabelTítuloCadastro = new JLabel("Cadastro");
		LabelTítuloCadastro.setBounds(313, -13, 181, 67);
		LabelTítuloCadastro.setFont(new Font("Trebuchet MS", Font.PLAIN, 35));
		contentPane.add(LabelTítuloCadastro);
		
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
		
		JLabel LabelEmail = new JLabel("Digite aqui seu Email:");
		LabelEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		LabelEmail.setBounds(21, 172, 189, 14);
		contentPane.add(LabelEmail);
		
		JLabel LabelSENHA = new JLabel("Digite aqui a senha que deseja usar:");
		LabelSENHA.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		LabelSENHA.setBounds(232, 172, 206, 14);
		contentPane.add(LabelSENHA);
		
		JLabel LabelCPF = new JLabel("Digite aqui seu CPF:");
		LabelCPF.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		LabelCPF.setBounds(260, 118, 154, 14);
		contentPane.add(LabelCPF);
		
		JLabel LabelNome = new JLabel("Digite aqui seu Nome Completo:");
		LabelNome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		LabelNome.setBounds(21, 118, 206, 14);
		contentPane.add(LabelNome);
		
		JLabel lblNewLabel_5 = new JLabel("Selecione como deseja se Cadastrar:");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(31, 322, 379, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel LabelDataNascimento = new JLabel("Insira sua Data de Nascimento:");
		LabelDataNascimento.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		LabelDataNascimento.setBounds(438, 118, 167, 14);
		contentPane.add(LabelDataNascimento);
        
        // --- JCALENDAR ---
        dcDataNascimento = new JDateChooser();
        dcDataNascimento.setToolTipText("Ex: 25/06/2003...");
        dcDataNascimento.setDateFormatString("dd/MM/yyyy"); // Formato da data
        dcDataNascimento.setBounds(441, 142, 120, 20); 
        contentPane.add(dcDataNascimento);
		
		passwordFieldSENHA = new JPasswordField();
		passwordFieldSENHA.setToolTipText("Ex: 40028922...");
		passwordFieldSENHA.setBounds(254, 198, 160, 20);
		contentPane.add(passwordFieldSENHA);
		
		passwordCONFIRMARSENHA = new JPasswordField();
		passwordCONFIRMARSENHA.setBounds(457, 198, 135, 20);
		contentPane.add(passwordCONFIRMARSENHA);
		
		JLabel LabelCONFIRMARSENHA = new JLabel("Confirme sua senha:");
		LabelCONFIRMARSENHA.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		LabelCONFIRMARSENHA.setBounds(468, 172, 124, 14);
		contentPane.add(LabelCONFIRMARSENHA);
		
		
		// configuração dos novos componentes 
        // Rótulo para feedback de texto
		lblStrengthFeedbackNIVELSENHA = new JLabel("Nível da Senha:");
		lblStrengthFeedbackNIVELSENHA.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblStrengthFeedbackNIVELSENHA.setBounds(203, 229, 100, 14); // Posição ajustada
		contentPane.add(lblStrengthFeedbackNIVELSENHA);
        
        // Barra de progresso para feedback visual
        progressBarBARRAdoNIVELSENHA = new JProgressBar(0, 5); // Valor mínimo 0, máximo 5 (pontuação máxima)
        progressBarBARRAdoNIVELSENHA.setBounds(293, 228, 72, 20); // Posição ajustada
        progressBarBARRAdoNIVELSENHA.setStringPainted(true); // Exibir o texto de progresso (opcional)
        contentPane.add(progressBarBARRAdoNIVELSENHA);
        
        Checkbox checkbox = new Checkbox("Médico");
        checkbox.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        checkbox.setBounds(40, 363, 86, 14);
        contentPane.add(checkbox);
        
        Checkbox checkbox_1 = new Checkbox("Secretária");
        checkbox_1.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        checkbox_1.setBounds(132, 357, 95, 22);
        contentPane.add(checkbox_1);
        
        Checkbox checkbox_1_1 = new Checkbox("Administrador");
        checkbox_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        checkbox_1_1.setBounds(232, 355, 95, 22);
        contentPane.add(checkbox_1_1);
        
        JLabel lblNewLabel_10 = new JLabel("Já possui Cadastro? ");
        lblNewLabel_10.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblNewLabel_10.setBounds(279, 53, 135, 14);
        contentPane.add(lblNewLabel_10);
        
        JButton btnCadastro = new JButton("Cadastrar-se");
        btnCadastro.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnCadastro.setForeground(new Color(13, 242, 219));
        btnCadastro.addActionListener(new ActionListener() {
        btnCadastro.setBounds(528, 406, 135, 35);
        contentPane.add(btnCadastro);
        
        JButton btnLogin = new JButton("Realizar Login");
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String mensagem="";
        		int camposEmBranco=0;
        		if (textNome.getText().trim().isEmpty()) {
					camposEmBranco++;
					mensagem+="Nome\n";
				}
				if (textCPF.getText().trim().isEmpty()) {
					camposEmBranco++;
					cposEmBranco++;
					mensagem+="CPf\n";
				}
				if (textEmail.getText().trim().isEmpty()) {
					camposEmBranco++;
					mensagem+="Email\n";
				}
				
				if (textField_3.getText().trim().isEmpty()) {
				if (passwordFieldSENHA.getPassword().length==0) {
					camposEmBranco++;
				 if (	passwordCONFIRMARSENHA.getPassword().length==0) {
					 camposEmBranco++;
					 mensagem+="Confirmação de Senha\n";
				
				if (camposEmBranco > 0) {
				        
				     System.out.println(camposEmBranco + " campo(s) em branco. Abortando login.");
				        // 
				        JOptionPane.showMessageDialog(
				            null,
				            "Preencha os campos:\n" + mensagem,
				            "Erro de Validação",
				            JOptionPane.WARNING_MESSAGE 
				        );
				        
				        return; 
				    }
        		TelaLogin tela = new TelaLogin();
				tela.setLocationRelativeTo(null);
        		tela.setVisible(true);
				 dispose();
        	}
        });
        btnLogin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnLogin.setBounds(405, 50, 135, 20);
        contentPane.add(btnLogin);
        
        // REMOVI OS CAMPOS ANTIGOS SEM FUNCIONALIDADE:
        // JLabel LabelEstados = new JLabel("Estado(UF):"); // REMOVIDO
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		TelaLogin tela = new TelaLogin();
				tela.setLocationRelativeTo(null);
        		tela.setVisible(true);
				 dispose();
        	}
        });
        btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnVoltar.setBounds(686, 407, 125, 32);
        contentPane.add(btnVoltar);
        
        JLabel lblNewLabel = new JLabel("CEP:");
        lblNewLabel.setBounds(652, 117, 46, 14);
        contentPane.add(lblNewLabel);
        
        textField = new JTextField(); // CEP
        textField.setBounds(644, 140, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Rua:");
        lblNewLabel_1.setBounds(740, 230, 46, 14);
        contentPane.add(lblNewLabel_1);
        
        textField_1 = new JTextField(); // Rua
        textField_1.setBounds(740, 255, 86, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Número:");
        lblNewLabel_2.setBounds(740, 286, 72, 14);
        contentPane.add(lblNewLabel_2);
        
        textField_2 = new JTextField(); // Número
        textField_2.setBounds(740, 311, 59, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        
        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setBounds(644, 230, 46, 14);
        contentPane.add(lblBairro);
        
        textBairro = new JTextField(); // Bairro
        textBairro.setBounds(644, 255, 86, 20);
        contentPane.add(textBairro);
        textBairro.setColumns(10);
        
        // RENOMEADO: Município (antiga Cidade)
        JLabel lblMunicipio = new JLabel("Município:");
        lblMunicipio.setBounds(740, 173, 72, 14);
        contentPane.add(lblMunicipio);
        
        textMunicipio = new JTextField(); // Município
        textMunicipio.setBounds(740, 198, 86, 20);
        contentPane.add(textMunicipio);
        textMunicipio.setColumns(10);
        
        // RENOMEADO: Estado(UF)
        JLabel lblEstadoUF = new JLabel("Estado(UF):");
        lblEstadoUF.setBounds(644, 173, 72, 14);
        contentPane.add(lblEstadoUF);
        
        textEstadoUF = new JTextField(); // Estado(UF)
        textEstadoUF.setBounds(644, 198, 46, 20);
        contentPane.add(textEstadoUF);
        textEstadoUF.setColumns(10);
        
        // BOTÃO PARA BUSCAR CEP (OPCIONAL)
        JButton btnBuscarCEP = new JButton("Buscar");
        btnBuscarCEP.setBounds(740, 140, 83, 20);
        btnBuscarCEP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarEnderecoPorCEP();
            }
        });
        contentPane.add(btnBuscarCEP);

		// chamando o método que implementa O DocumentListener
        implementPasswordStrengthCheck();
        
        // ADICIONA LISTENER PARA BUSCA AUTOMÁTICA DE CEP
        implementCEPAutoComplete();

	}

    
    //AVALIAÇÃO DA FORÇA DA SENHA
    

    /**
     * Avalia a força da senha com base em vários critérios (comprimento, tipos de caracteres).
     * @param password A string da senha a ser avaliada.
     * @return O nível de força (WEAK, MEDIUM, STRONG).
     */
    private PasswordStrength checkPasswordStrength(String password) {
        int score = 0;
        
        // 0. Verifica se está vazia
        if (password.length() == 0) {

        // 1. Pontua por comprimento
        // Senhas com menos de 8 caracteres vão ser consideradas fracas, mas se for maior que isso, aumenta a segurança.
            score++;
        if (password.length() >= 12) {
            score++;

        // Pelo menos uma minúscula
        if (password.matches(".*[a-z].*")) { 
            score++;
        }
        // Pelo menos uma maiúscula
        if (password.matches(".*[A-Z].*")) { 
        }
        // Pelo menos um número
        if (password.matches(".*[0-9].*")) { 
            score++;
        }
        // Pelo menos um símbolo/caractere especial 
        if (password.matches(".*[^a-zA-Z0-9].*")) { 
            score++;
        }
        
        // Define a força com base na pontuação total (máximo de 5 pontos)
        if (score >= 4) {
            return PasswordStrength.STRONG;
        } else if (score >= 2) {
            return PasswordStrength.MEDIUM;
        } else {
            return PasswordStrength.WEAK;
        }
    }

    // 
    // 2. integração do SWING com DocumentListener
    // 
        if (password.length() >= 12) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        
        else if (score >= 2) return PasswordStrength.MEDIUM;
        else return PasswordStrength.WEAK;

    /**
     */
    private void implementPasswordStrengthCheck() {
        
        passwordFieldSENHA.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
                checkAndUpdateUI();
            @Override
            }
            public void removeUpdate(DocumentEvent e) { checkAndUpdateUI(); }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Não usado para JPasswordField
            }

            private void checkAndUpdateUI() {
                // recebe a senha como String (uso temporário)
                String password = new String(passwordFieldSENHA.getPassword());
                
                // 1. verifica se está vazio e limpa o feedback
                if (password.isEmpty()) {
                    lblStrengthFeedbackNIVELSENHA.setText("Nível da Senha:");
                    lblStrengthFeedbackNIVELSENHA.setForeground(Color.BLACK);
                    progressBarBARRAdoNIVELSENHA.setValue(0);
                    progressBarBARRAdoNIVELSENHA.setString("");
                    return;
                }
                
                // 2. Executa a lógica de avaliação
                PasswordStrength strength = checkPasswordStrength(password);
                
                // Limpa o array char[] da senha da memória imediatamente (boa prática de segurança)
                Arrays.fill(passwordFieldSENHA.getPassword(), ' '); 

                // 3. Atualiza o JLabel e JProgressBar
                switch (strength) {
                    case WEAK:
                        lblStrengthFeedbackNIVELSENHA.setText("FRACA");
                        lblStrengthFeedbackNIVELSENHA.setForeground(Color.RED);
                        progressBarBARRAdoNIVELSENHA.setValue(1); // 1 de 5
                        progressBarBARRAdoNIVELSENHA.setForeground(Color.RED);
                        progressBarBARRAdoNIVELSENHA.setString("Fraca");
                        break;
                    case MEDIUM:
                        lblStrengthFeedbackNIVELSENHA.setText("MÉDIA");
                        lblStrengthFeedbackNIVELSENHA.setForeground(Color.ORANGE.darker());
                        progressBarBARRAdoNIVELSENHA.setValue(3); // 3 de 5
                        progressBarBARRAdoNIVELSENHA.setForeground(Color.ORANGE.darker());
                        progressBarBARRAdoNIVELSENHA.setString("Média");
                        break;
                    case STRONG:
                        lblStrengthFeedbackNIVELSENHA.setText("FORTE");
                        lblStrengthFeedbackNIVELSENHA.setForeground(Color.GREEN.darker());
                        progressBarBARRAdoNIVELSENHA.setValue(5); // 5 de 5
                        progressBarBARRAdoNIVELSENHA.setForeground(Color.GREEN.darker());
                        progressBarBARRAdoNIVELSENHA.setString("Forte");
                        break;
                }
            }
        });
    }
    
    /**
     * MÉTODO ADICIONADO: Implementa a busca automática de CEP
     */
    private void implementCEPAutoComplete() {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { buscarQuandoCompleto(); }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Não faz nada
            }
            
            @Override
            public void changedUpdate(DocumentEvent e) { buscarQuandoCompleto(); }
            
            private void buscarQuandoCompleto() {
                String cep = textField.getText().replaceAll("[^0-9]", "");
                if (cep.length() == 8) {
                    // Aguarda 500ms antes de buscar (para não buscar a cada tecla)
                    Timer timer = new Timer(500, e2 -> buscarEnderecoPorCEP());
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        });
    }
    
    /**
     * MÉTODO ADICIONADO: Busca endereço por CEP
     */
    private void buscarEnderecoPorCEP() {
        String cep = textField.getText().trim().replaceAll("[^0-9]", "");
        
        if (cep.length() != 8) {
            JOptionPane.showMessageDialog(this, "CEP deve conter 8 dígitos!", "CEP Inválido", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Mostra cursor de carregamento
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        
        // Usa SwingWorker para não travar a interface
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
                    
                    
                } catch (Exception e) {
            }
            
            @Override
            protected void done() {
                setCursor(Cursor.getDefaultCursor());
                
                try {
                    ViaCEPResponse endereco = get();
                    
                    if (endereco == null) {
                    if (endereco == null || endereco.temErro()) {
                        JOptionPane.showMessageDialog(TelaCadastro.this, 
                            "CEP não encontrado!\nVerifique o CEP digitado.", 
                            "CEP não encontrado", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    textMunicipio.setText(endereco.getLocalidade()); // Preenche Município
                    textEstadoUF.setText(endereco.getUf()); // Preenche Estado(UF)
                    // Foca no campo Número automaticamente
                    SwingUtilities.invokeLater(() -> {
                        textBairro.setText(endereco.getBairro());
                        
                        textField_2.requestFocus();
                    });
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(TelaCadastro.this,
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
				if (e.isPopupTrigger()) showMenu(e);
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) showMenu(e);
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}