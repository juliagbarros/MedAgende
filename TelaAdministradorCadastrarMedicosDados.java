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
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JProgressBar;
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
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

// IMPORTAÇÕES PARA API DOS CORREIOS
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaAdministradorCadastrarMedicosDados extends JFrame {

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
    private JTextField FieldNome;
    private JFormattedTextField FieldCpf;
    private JTextField FieldEmail;
    private JTextField FieldTelefone;
    private JPasswordField FieldSENHA;
    private JPasswordField FieldConfirmarSenha;
    private JDateChooser dcDataNascimento;
    
    // NOVOS COMPONENTES PARA FEEDBACK
    private JLabel lblStrengthFeedbackNIVELSENHA;
    private JProgressBar progressBarBARRAdoNIVELSENHA;
    private JTextField FieldCep; // CEP
    private JTextField FieldRua; // Rua
    private JTextField FieldNum; // Número
    private JTextField FieldMunicipio;
    private JTextField FieldEstado;
    private JTextField FieldBairro;

    // Componentes para API
    private OkHttpClient httpClient;
    private Gson gson;
    private JTextField FieldCrm;
    private JTextField FieldRqe;
    private JTextField FieldPlanoSaude;
    private JComboBox<String> BoxEspecialidades;
    private String matricula;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaAdministradorCadastrarMedicosDados frame = new TelaAdministradorCadastrarMedicosDados();
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
    public TelaAdministradorCadastrarMedicosDados() {
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
        
        JLabel LabelCadastroUsuarios = new JLabel("Cadastro de Médicos");
        LabelCadastroUsuarios.setBounds(315, 0, 277, 67);
        LabelCadastroUsuarios.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
        contentPane.add(LabelCadastroUsuarios);
        
        FieldNome = new JTextField();
        FieldNome.setBounds(21, 142, 206, 20);
        contentPane.add(FieldNome);
        FieldNome.setColumns(10);
        
        MaskFormatter maskCpf = null;

        try {
            maskCpf = new MaskFormatter("###.###.###-##");
            maskCpf.setPlaceholderCharacter('_');
        } catch (Exception e) {
            e.printStackTrace();
        }

        FieldCpf = new JFormattedTextField(maskCpf);
        FieldCpf.setBounds(281, 140, 100, 25);
        contentPane.add(FieldCpf);
        FieldCpf.setColumns(10);
        
        FieldEmail = new JTextField();
        FieldEmail.setToolTipText("Ex: costelinha123@gmail.com...");
        FieldEmail.setBounds(21, 198, 206, 20);
        contentPane.add(FieldEmail);
        FieldEmail.setColumns(10);
        
        JLabel labelEmail = new JLabel("Digite o Email:");
        labelEmail.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        labelEmail.setBounds(31, 172, 189, 14);
        contentPane.add(labelEmail);
        
        JLabel labelSENHA = new JLabel("Digite aqui a senha :");
        labelSENHA.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        labelSENHA.setBounds(252, 172, 206, 14);
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
        dcDataNascimento = new JDateChooser();
        dcDataNascimento.setToolTipText("Ex: 25/06/2003...");
        dcDataNascimento.setDateFormatString("dd/MM/yyyy");
        dcDataNascimento.setBounds(441, 142, 120, 20); 
        contentPane.add(dcDataNascimento);
        
        FieldSENHA = new JPasswordField();
        FieldSENHA.setToolTipText("Ex: 40028922...");
        FieldSENHA.setBounds(254, 198, 160, 20);
        contentPane.add(FieldSENHA);
        
        FieldConfirmarSenha = new JPasswordField();
        FieldConfirmarSenha.setBounds(438, 198, 135, 20);
        contentPane.add(FieldConfirmarSenha);
        
        JLabel labelConfirmarSenha = new JLabel("Confirme a senha:");
        labelConfirmarSenha.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        labelConfirmarSenha.setBounds(438, 172, 124, 14);
        contentPane.add(labelConfirmarSenha);
        
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
        
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnCadastrar.setForeground(new Color(0, 0, 0));
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validarDados()) {
                    cadastrar();
                }
            }
        });
        btnCadastrar.setBounds(677, 406, 135, 35);
        contentPane.add(btnCadastrar);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaAdministradorCadastroMedicos tela = new TelaAdministradorCadastroMedicos();
                tela.setVisible(true);
                dispose();
            }
        });
        btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnVoltar.setBounds(31, 407, 125, 32);
        contentPane.add(btnVoltar);
        
        JLabel lblNewLabel = new JLabel("CEP:");
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNewLabel.setBounds(652, 117, 46, 14);
        contentPane.add(lblNewLabel);
        
        FieldCep = new JTextField(); 
        FieldCep.setBounds(644, 140, 86, 20);
        contentPane.add(FieldCep);
        FieldCep.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("Rua:");
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNewLabel_1.setBounds(740, 230, 46, 14);
        contentPane.add(lblNewLabel_1);
        
        FieldRua = new JTextField(); 
        FieldRua.setBounds(740, 255, 86, 20);
        contentPane.add(FieldRua);
        FieldRua.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Número:");
        lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNewLabel_2.setBounds(740, 286, 72, 14);
        contentPane.add(lblNewLabel_2);
        
        FieldNum = new JTextField(); 
        FieldNum.setBounds(740, 311, 59, 20);
        contentPane.add(FieldNum);
        FieldNum.setColumns(10);
        
        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblBairro.setBounds(644, 230, 46, 14);
        contentPane.add(lblBairro);
        
        FieldBairro = new JTextField(); 
        FieldBairro.setBounds(644, 255, 86, 20);
        contentPane.add(FieldBairro);
        FieldBairro.setColumns(10);
        
        JLabel lblMunicipio = new JLabel("Município:");
        lblMunicipio.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblMunicipio.setBounds(740, 173, 72, 14);
        contentPane.add(lblMunicipio);
        
        FieldMunicipio = new JTextField(); 
        FieldMunicipio.setBounds(740, 198, 86, 20);
        contentPane.add(FieldMunicipio);
        FieldMunicipio.setColumns(10);
        
        JLabel lblEstadoUF = new JLabel("Estado(UF):");
        lblEstadoUF.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblEstadoUF.setBounds(644, 173, 72, 14);
        contentPane.add(lblEstadoUF);
        
        FieldEstado = new JTextField(); 
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
        lblDigiteOTelefone.setBounds(21, 257, 189, 14);
        contentPane.add(lblDigiteOTelefone);
        
        FieldTelefone = new JTextField();
        FieldTelefone.setBounds(21, 284, 206, 20);
        contentPane.add(FieldTelefone);
        FieldTelefone.setColumns(10);
    
        JLabel lblCRM = new JLabel("CRM");
        lblCRM.setBounds(252, 261, 46, 14);
        contentPane.add(lblCRM);
        
        FieldCrm = new JTextField();
        FieldCrm.setBounds(252, 283, 162, 20);
        contentPane.add(FieldCrm);
        FieldCrm.setColumns(10);
        
        FieldRqe = new JTextField();
        FieldRqe.setColumns(10);
        FieldRqe.setBounds(252, 339, 162, 20);
        contentPane.add(FieldRqe);
        
        JLabel lblRQE = new JLabel("RQE");
        lblRQE.setBounds(257, 314, 46, 14);
        contentPane.add(lblRQE);
        
        BoxEspecialidades = new JComboBox<>();
        BoxEspecialidades.setModel(new DefaultComboBoxModel<>(new String[] {
            "Ortopedista", "Cardiologista", "Dermatologista", 
            "Urologista", "Neurologista", "Psiquiatra"
        }));
        BoxEspecialidades.setForeground(new Color(0, 0, 0));
        BoxEspecialidades.setToolTipText("");
        BoxEspecialidades.setBounds(21, 340, 206, 22);
        contentPane.add(BoxEspecialidades);
        
        FieldPlanoSaude = new JTextField();
        FieldPlanoSaude.setBounds(438, 283, 151, 20);
        contentPane.add(FieldPlanoSaude);
        FieldPlanoSaude.setColumns(10);
        
        JLabel lblPlanoSaude = new JLabel("Plano de Saúde");
        lblPlanoSaude.setBounds(441, 261, 93, 14);
        contentPane.add(lblPlanoSaude);

        // chamando o método que implementa O DocumentListener
        implementPasswordStrengthCheck();
        
        // ADICIONA LISTENER PARA BUSCA AUTOMÁTICA DE CEP
        implementCEPAutoComplete();
    }
    
    /**
     * Método para cadastrar médico
     */
    public void cadastrar() {
        Connection conexao = null;
        PreparedStatement pstUsuario = null;
        PreparedStatement pstBuscarEsp = null;
        PreparedStatement pstInserirEsp = null;
        PreparedStatement pstMedico = null;
        ResultSet rsUsuario = null;
        ResultSet rsEspecialidade = null;
        ResultSet rsNovaEsp = null;
        ResultSet rsMedico = null;
        
        try {
            // 1. Conectando ao bd
            conexao = ConnectionFactory.getConnection();
            if (conexao == null) {
                JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados", 
                    "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            
            conexao.setAutoCommit(false);
            
            // 3. colocando em usuario os valores
            String sqlusuario = "INSERT INTO usuarios (Email, Senha, Nome, CPF, Data_Nasc, Bairro, Rua, Num_Casa, Cidade, Servíco, Plano_De_Saude, CEP, Telefone) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            pstUsuario = conexao.prepareStatement(sqlusuario, Statement.RETURN_GENERATED_KEYS);
            pstUsuario.setString(1, FieldEmail.getText());
            String senha = new String(FieldSENHA.getPassword());
            pstUsuario.setString(2, senha);
            pstUsuario.setString(3, FieldNome.getText());
            pstUsuario.setString(4, FieldCpf.getText());
            
            java.util.Date dataUtil = dcDataNascimento.getDate();
            if (dataUtil != null) {
                java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
                pstUsuario.setDate(5, dataSql);
            } else {
                pstUsuario.setNull(5, java.sql.Types.DATE);
            }
            
            pstUsuario.setString(6, FieldBairro.getText());
            pstUsuario.setString(7, FieldRua.getText());
            pstUsuario.setString(8, FieldNum.getText());
            pstUsuario.setString(9, FieldMunicipio.getText());
            pstUsuario.setString(10, "Médico");
            pstUsuario.setString(11, FieldPlanoSaude.getText());
            pstUsuario.setString(12, FieldCep.getText());
            pstUsuario.setString(13, FieldTelefone.getText());
            
            pstUsuario.executeUpdate();
            
            // 4. pega o id que é auto increment
            rsUsuario = pstUsuario.getGeneratedKeys();
            int idUsuario = 0;
            if (rsUsuario.next()) {
                idUsuario = rsUsuario.getInt(1);
            }
            
            // 5. buscar especialidade
            String especialidadeSelecionada = (String) BoxEspecialidades.getSelectedItem();
            int idEspecialidade = 0;
            
            // Primeiro tenta buscar se ja existe
            String sqlBuscarEspecialidade = "SELECT Id_Especialidade FROM especialidades WHERE Nome_Especialidade = ?";
            pstBuscarEsp = conexao.prepareStatement(sqlBuscarEspecialidade);
            pstBuscarEsp.setString(1, especialidadeSelecionada);
            rsEspecialidade = pstBuscarEsp.executeQuery();
            
            if (rsEspecialidade.next()) {
                idEspecialidade = rsEspecialidade.getInt("Id_Especialidade");
            } 
            
            // 6. INSERIR MÉDICO
            String sqlMedico = "INSERT INTO medico (Id_Usuario, Especialidade, Crm, Situacao, Rqe) VALUES (?,?,?,?,?)";
            pstMedico = conexao.prepareStatement(sqlMedico, Statement.RETURN_GENERATED_KEYS);
            pstMedico.setInt(1, idUsuario);
            pstMedico.setInt(2, idEspecialidade);
            pstMedico.setString(3, FieldCrm.getText());
            pstMedico.setString(4, "ativo");
            pstMedico.setString(5, FieldRqe.getText());
            
            pstMedico.executeUpdate();
            
            // 7. PEGAR MATRÍCULA GERADA
            rsMedico = pstMedico.getGeneratedKeys();
            if (rsMedico.next()) {
                matricula = String.valueOf(rsMedico.getInt(1));
            }
            
            conexao.commit();
            
            JOptionPane.showMessageDialog(this, 
                "Médico cadastrado com sucesso!\nMatrícula: " + matricula, 
                "Cadastro Concluído", 
                JOptionPane.INFORMATION_MESSAGE);
            
            // 9. LIMPAR CAMPOS APÓS CADASTRO
            limparCampos();
            
        } catch (SQLException e) {
            try {
                if (conexao != null) {
                    conexao.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            JOptionPane.showMessageDialog(this, 
                "Erro ao cadastrar médico:\n" + e.getMessage(), 
                "Erro no Cadastro", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            
        } finally {
            // FECHAR TODOS OS RECURSOS
            try {
                if (rsMedico != null) rsMedico.close();
                if (rsNovaEsp != null) rsNovaEsp.close();
                if (rsEspecialidade != null) rsEspecialidade.close();
                if (rsUsuario != null) rsUsuario.close();
                
                if (pstMedico != null) pstMedico.close();
                if (pstInserirEsp != null) pstInserirEsp.close();
                if (pstBuscarEsp != null) pstBuscarEsp.close();
                if (pstUsuario != null) pstUsuario.close();
                
                if (conexao != null) {
                    conexao.setAutoCommit(true);
                    // Não feche a conexão da ConnectionFactory
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Método para validar dados antes do cadastro
     */
    private boolean validarDados() {
        StringBuilder erros = new StringBuilder();
        
        // Validação de campos obrigatórios
        if (FieldNome.getText().trim().isEmpty()) {
            erros.append("Nome completo\n");
        }
        
        String cpf = FieldCpf.getText().replaceAll("\\D", "");
        if (cpf.isEmpty() || cpf.length() != 11) {
            erros.append("CPF válido (11 dígitos)\n");
        }
        
        if (FieldEmail.getText().trim().isEmpty()) {
            erros.append("Email\n");
        } else {
            String email = FieldEmail.getText().trim();
            if (!email.contains("@") || !email.contains(".")) {
                erros.append("Email válido\n");
            }
        }
        
        if (FieldSENHA.getPassword().length == 0) {
            erros.append(" Senha\n");
        }
        
        if (FieldConfirmarSenha.getPassword().length == 0) {
            erros.append("Confirmação de senha\n");
        } else {
            String senha = new String(FieldSENHA.getPassword());
            String confirmacao = new String(FieldConfirmarSenha.getPassword());
            if (!senha.equals(confirmacao)) {
                erros.append(" Senhas não coincidem\n");
            }
        }
        
        if (dcDataNascimento.getDate() == null) {
            erros.append("Data de nascimento\n");
        }
        
        if (FieldTelefone.getText().trim().isEmpty()) {
            erros.append("Telefone\n");
        } else {
            String telefone = FieldTelefone.getText().replaceAll("[^0-9]", "");
            if (telefone.length() < 10) {
                erros.append(" Telefone válido (mínimo 10 dígitos)\n");
            }
        }
        
        if (FieldCep.getText().trim().isEmpty()) {
            erros.append(" CEP\n");
        }
        
        if (FieldCrm.getText().trim().isEmpty()) {
            erros.append(" CRM\n");
        }
        
        if (erros.length() > 0) {
            JOptionPane.showMessageDialog(this, 
                "Preencha os seguintes campos corretamente:\n\n" + erros.toString(),
                "Validação de Dados",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    /**
     * Limpa os campos após cadastro
     */
    private void limparCampos() {
        FieldNome.setText("");
        FieldCpf.setText("");
        FieldEmail.setText("");
        FieldSENHA.setText("");
        FieldConfirmarSenha.setText("");
        dcDataNascimento.setDate(null);
        FieldTelefone.setText("");
        FieldCep.setText("");
        FieldRua.setText("");
        FieldNum.setText("");
        FieldBairro.setText("");
        FieldMunicipio.setText("");
        FieldEstado.setText("");
        FieldCrm.setText("");
        FieldRqe.setText("");
        FieldPlanoSaude.setText("");
        BoxEspecialidades.setSelectedIndex(0);
        
        // Resetar feedback de senha
        lblStrengthFeedbackNIVELSENHA.setText("Nível da Senha:");
        lblStrengthFeedbackNIVELSENHA.setForeground(Color.BLACK);
        progressBarBARRAdoNIVELSENHA.setValue(0);
        progressBarBARRAdoNIVELSENHA.setString("");
    }
    
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
        FieldSENHA.getDocument().addDocumentListener(new DocumentListener() {
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
                String password = new String(FieldSENHA.getPassword());
                
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
            JOptionPane.showMessageDialog(this, 
                "CEP deve conter 8 dígitos!", 
                "CEP Inválido", 
                JOptionPane.WARNING_MESSAGE);
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

                    try (Response response = httpClient.newCall(request).execute()) {
                        if (!response.isSuccessful() || response.body() == null) {
                            throw new IOException("Resposta inválida da API");
                        }

                        String json = response.body().string();
                        ViaCEPResponse viaCEPResponse = gson.fromJson(json, ViaCEPResponse.class);
                        return viaCEPResponse;
                    }

                } catch (IOException e) {
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
                        JOptionPane.showMessageDialog(TelaAdministradorCadastrarMedicosDados.this, 
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
                    SwingUtilities.invokeLater(() -> { FieldNum.requestFocus();
                    });
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(TelaAdministradorCadastrarMedicosDados.this,
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