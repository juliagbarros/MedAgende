package telasSistema.Administrador;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

import com.google.gson.Gson;
import com.toedter.calendar.JDateChooser;

import Back.Especialidade;
import Back.Médico;
import Back.Usuarios;
import conexao.ConnectionFactory;
import model.Criptografia;
import model.Usuario;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class TelaAdministradorExcluirMedico extends JFrame {
	
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
    private JTextField FieldCep;
    private JTextField FieldRua;
    private JTextField FieldNum;
    private JTextField FieldMunicipio;
    private JTextField FieldEstado;
    private JTextField FieldBairro;
    private JTextField FieldCrm;
    private JTextField FieldRqe;
    private JTextField FieldPlanoSaude;
    private JComboBox<String> BoxEspecialidades;
    private JDateChooser dcDataNascimento;
    private Usuario usuarioAtual;
    
    private OkHttpClient httpClient;
    private Gson gson;
    private JTextField textPlano;
    private JTextField textTelefone;
    private JPasswordField textSenha;
	private int Id_Usuario;
	private int Especialidade;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaAdministradorExcluirMedico frame = new TelaAdministradorExcluirMedico();
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
    public TelaAdministradorExcluirMedico() {
    	
    	httpClient = new OkHttpClient();
		gson = new Gson();
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 888, 550);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(143, 222, 239));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel LabelTitulo = new JLabel("Excluir Médico(a)");
        LabelTitulo.setBounds(311, 0, 300, 51);
        LabelTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
        contentPane.add(LabelTitulo);
        
        JLabel lblSubTitulo = new JLabel("Digite o CPF para buscar o(a) médico(a) para excluir: ");
        lblSubTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblSubTitulo.setBounds(280, 53, 331, 14);
        contentPane.add(lblSubTitulo);

        JLabel labelCPF = new JLabel("CPF (Digite para buscar):");
        labelCPF.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        labelCPF.setBounds(370, 78, 154, 14);
        contentPane.add(labelCPF);

        MaskFormatter maskCpf = null;
        try {
            maskCpf = new MaskFormatter("###.###.###-##");
            maskCpf.setPlaceholderCharacter('_');
        } catch (Exception e) {
            e.printStackTrace();
        }

        FieldCpf = new JFormattedTextField();
        FieldCpf.setText("");
        FieldCpf.setBounds(381, 98, 100, 25);
        contentPane.add(FieldCpf);

        JButton btnBuscarCPF = new JButton("Verificar");
        btnBuscarCPF.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
        btnBuscarCPF.setBounds(502, 98, 90, 25);
        btnBuscarCPF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    String cpf = FieldCpf.getText().replace(".", "").replace("-", "");

                    verificar();


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao buscar médico");
                    ex.printStackTrace();
                }
            }
        });

        contentPane.add(btnBuscarCPF);

        // --- DADOS PESSOAIS ---
        
        // Nome
        JLabel labelNome = new JLabel("Nome Completo:");
        labelNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        labelNome.setBounds(21, 142, 206, 14);
        contentPane.add(labelNome);

        FieldNome = new JTextField();
        FieldNome.setBounds(21, 166, 206, 20);
        contentPane.add(FieldNome);
        FieldNome.setColumns(10);

        // Email
        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        labelEmail.setBounds(21, 196, 189, 14);
        contentPane.add(labelEmail);

        FieldEmail = new JTextField();
        FieldEmail.setBounds(21, 222, 206, 20);
        contentPane.add(FieldEmail);
        FieldEmail.setColumns(10);

        // Data Nascimento
        JLabel labelDataNascimento = new JLabel("Data de Nascimento:");
        labelDataNascimento.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        labelDataNascimento.setBounds(252, 142, 167, 14);
        contentPane.add(labelDataNascimento);

        dcDataNascimento = new JDateChooser();
        dcDataNascimento.setDateFormatString("dd/MM/yyyy");
        dcDataNascimento.setBounds(252, 166, 120, 20);
        contentPane.add(dcDataNascimento);

        // Telefone
        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblTelefone.setBounds(252, 196, 189, 14);
        contentPane.add(lblTelefone);

        FieldTelefone = new JTextField();
        FieldTelefone.setText("(81)");
        FieldTelefone.setBounds(252, 222, 167, 20);
        contentPane.add(FieldTelefone);
        FieldTelefone.setColumns(10);

        // --- DADOS PROFISSIONAIS ---
        
        // CRM
        JLabel lblCRM = new JLabel("CRM:");
        lblCRM.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblCRM.setBounds(21, 253, 46, 14);
        contentPane.add(lblCRM);

        FieldCrm = new JTextField();
        FieldCrm.setBounds(21, 277, 120, 20);
        contentPane.add(FieldCrm);
        FieldCrm.setColumns(10);

        // RQE
        JLabel lblRQE = new JLabel("RQE:");
        lblRQE.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblRQE.setBounds(151, 253, 46, 14);
        contentPane.add(lblRQE);

        FieldRqe = new JTextField();
        FieldRqe.setBounds(151, 277, 120, 20);
        contentPane.add(FieldRqe);
        FieldRqe.setColumns(10);

        // Plano de Saúde
        JLabel lblPlanoSaude = new JLabel("Plano de Saúde:");
        lblPlanoSaude.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblPlanoSaude.setBounds(281, 253, 100, 14);
        contentPane.add(lblPlanoSaude);

        FieldPlanoSaude = new JTextField();
        FieldPlanoSaude.setBounds(281, 277, 138, 20);
        contentPane.add(FieldPlanoSaude);
        FieldPlanoSaude.setColumns(10);

        // Especialidade
        JLabel lblEsp = new JLabel("Especialidade:");
        lblEsp.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblEsp.setBounds(21, 308, 100, 14);
        contentPane.add(lblEsp);

        BoxEspecialidades = new JComboBox<>();
        BoxEspecialidades.setModel(new DefaultComboBoxModel<>(new String[] {
            "Ortopedista", "Cardiologista", "Dermatologista", 
            "Urologista", "Neurologista", "Psiquiatra"
        }));
        BoxEspecialidades.setBounds(21, 329, 206, 22);
        contentPane.add(BoxEspecialidades);

        // --- ENDEREÇO (LATERAL DIREITA) ---
        
        // CEP
        JLabel lblCep = new JLabel("CEP:");
        lblCep.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblCep.setBounds(606, 143, 46, 14);
        contentPane.add(lblCep);

        FieldCep = new JTextField();
        FieldCep.setBounds(606, 166, 86, 20);
        contentPane.add(FieldCep);
        FieldCep.setColumns(10);

        JButton btnBuscarCEP = new JButton("Buscar");
        btnBuscarCEP.setBounds(713, 164, 83, 22);
        btnBuscarCEP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	buscarEnderecoPorCEP();           
            	}
        });
        contentPane.add(btnBuscarCEP);

        // Município e Estado
        JLabel lblMun = new JLabel("Município:");
        lblMun.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblMun.setBounds(713, 197, 72, 14);
        contentPane.add(lblMun);

        FieldMunicipio = new JTextField();
        FieldMunicipio.setBounds(713, 222, 86, 20);
        contentPane.add(FieldMunicipio);

        JLabel lblEst = new JLabel("UF:");
        lblEst.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblEst.setBounds(606, 197, 72, 14);
        contentPane.add(lblEst);

        FieldEstado = new JTextField();
        FieldEstado.setBounds(606, 222, 46, 20);
        contentPane.add(FieldEstado);
        
        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblBairro.setBounds(606, 254, 46, 14);
        contentPane.add(lblBairro);

        FieldBairro = new JTextField();
        FieldBairro.setBounds(606, 281, 86, 20);
        contentPane.add(FieldBairro);

        JLabel lblRua = new JLabel("Rua:");
        lblRua.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblRua.setBounds(606, 309, 46, 14);
        contentPane.add(lblRua);

        FieldRua = new JTextField();
        FieldRua.setBounds(606, 330, 154, 20);
        contentPane.add(FieldRua);
        FieldRua.setColumns(10);

        // Número
        JLabel lblNum = new JLabel("Número:");
        lblNum.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNum.setBounds(713, 266, 72, 14);
        contentPane.add(lblNum);

        FieldNum = new JTextField();
        FieldNum.setBounds(714, 281, 59, 20);
        contentPane.add(FieldNum);
        FieldNum.setColumns(10);

        // --- BOTÕES DE AÇÃO ---
        
        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        btnExcluir.setForeground(Color.BLACK);
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	validarDados();
                excluir();
                limparCampos();
            }
        });
        btnExcluir.setBounds(678, 459, 145, 35);
        contentPane.add(btnExcluir);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        btnVoltar.setBounds(31, 460, 125, 32);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		TelaAdminExcluirUsuarios telaAdminExcluirUsuarios = new TelaAdminExcluirUsuarios();
            		telaAdminExcluirUsuarios.setLocationRelativeTo(null);
            		telaAdminExcluirUsuarios.setVisible(true);
    				 dispose();
            }
        });
        contentPane.add(btnVoltar);
    
       
        
        implementCEPAutoComplete();
    
    }
    public void verificar() {
        ResultSet rsusuario = null;
        PreparedStatement psusuario = null;
        Connection conexao = null;
        PreparedStatement psmedico = null;
        ResultSet rsmedico = null;
        PreparedStatement psEspecialidade = null;
        ResultSet rsEspecialidade = null;
        
        try {
            conexao = ConnectionFactory.getConnection();
            String sqlusuario = "select * from usuarios where CPF=?";
            psusuario = conexao.prepareStatement(sqlusuario);
            psusuario.setString(1, FieldCpf.getText().trim());
            rsusuario = psusuario.executeQuery();
            
            if (rsusuario.next()) {
                String servico = rsusuario.getString("Servíco"); 
                
                if (servico != null && servico.equals("Médico")) {

                	FieldNome.setText(rsusuario.getString("Nome"));
                    FieldEmail.setText(rsusuario.getString("Email"));
                    dcDataNascimento.setDate(rsusuario.getDate("Data_Nasc"));
                    FieldTelefone.setText(rsusuario.getString("Telefone"));
                    FieldCep.setText(rsusuario.getString("CEP"));
                    FieldPlanoSaude.setText(rsusuario.getString("Plano_De_Saude"));
                    FieldMunicipio.setText(rsusuario.getString("Cidade"));
                    FieldBairro.setText(rsusuario.getString("Bairro"));
                    FieldRua.setText(rsusuario.getString("Rua"));
                    FieldEstado.setText(rsusuario.getString("Uf"));
                    FieldNum.setText(rsusuario.getString("Num_Casa"));
                    
                    this.Id_Usuario = rsusuario.getInt("Id_Usuario");
                    
                    String sqlmedico = "select Crm, Rqe, Especialidade from Medico where Id_Usuario=?";
                    psmedico = conexao.prepareStatement(sqlmedico);
                    psmedico.setInt(1, Id_Usuario);
                    rsmedico = psmedico.executeQuery();
                    
                    if (rsmedico.next()) {
                        FieldCrm.setText(rsmedico.getString("Crm"));
                        FieldRqe.setText(rsmedico.getString("Rqe"));
                        
                        this.Especialidade = rsmedico.getInt("Especialidade");
                        
                        String sqlEspecialidade = "select Nome_Especialidade from especialidades where Id_Especialidade=?";
                        psEspecialidade = conexao.prepareStatement(sqlEspecialidade);
                        psEspecialidade.setInt(1, Especialidade);
                        rsEspecialidade = psEspecialidade.executeQuery();
                        
                        if (rsEspecialidade.next()) {
                            String especialidadeBanco = rsEspecialidade.getString("Nome_Especialidade");
                            BoxEspecialidades.setSelectedItem(especialidadeBanco);
                        }
                        JOptionPane.showMessageDialog(null, 
                                "Médico carregado com sucesso", 
                                "Sucesso", 
                                JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Médico não encontrado na tabela médico", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "O CPF inserido não pertence a um médico", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "CPF não encontrado no sistema", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rsEspecialidade != null) rsEspecialidade.close();
                if (psEspecialidade != null) psEspecialidade.close();
                if (rsmedico != null) rsmedico.close();
                if (psmedico != null) psmedico.close();
                if (rsusuario != null) rsusuario.close();
                if (psusuario != null) psusuario.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
    
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
        if (FieldRqe.getText().trim().isEmpty()) {
            erros.append(" Rqe\n");
        }
        if (FieldCep.getText().trim().isEmpty()) {
            erros.append(" Cep\n");
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
    private void limparCampos() {
        FieldNome.setText("");
        FieldCpf.setText("");
        FieldEmail.setText("");
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
        
     
    }
    public void excluir() {
        Connection conexao = null;
        PreparedStatement psVerificaUsuario = null;
        ResultSet rsUsuario = null;
        PreparedStatement psVerificaMedico = null;
        ResultSet rsMedico = null;
        PreparedStatement psExcluirMedico = null;
        PreparedStatement psExcluirUsuario = null;
        
        try {
            conexao = ConnectionFactory.getConnection();
            conexao.setAutoCommit(false); 
            
            String sqlUsuario = "SELECT Id_Usuario, Nome, Servíco FROM usuarios WHERE CPF=?";
            psVerificaUsuario = conexao.prepareStatement(sqlUsuario);
            psVerificaUsuario.setString(1, FieldCpf.getText().trim());
            rsUsuario = psVerificaUsuario.executeQuery();
            
            if (!rsUsuario.next()) {
                JOptionPane.showMessageDialog(null, 
                    "CPF não encontrado no sistema", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int idUsuario = rsUsuario.getInt("Id_Usuario");
            String nomeUsuario = rsUsuario.getString("Nome");
            String servico = rsUsuario.getString("Servíco");
            
            if (servico == null || !servico.equals("Médico")) {
                JOptionPane.showMessageDialog(null, 
                    "O CPF inserido não pertence a um médico", 
                    "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int confirmacao = JOptionPane.showConfirmDialog(null,
                "Tem certeza que deseja excluir o médico:\n" +
                "Nome: " + nomeUsuario + "\n" +
                "CPF: " + FieldCpf.getText() + "\n\n" +
                "Esta ação NÃO pode ser desfeita!",
                "Confirmação de Exclusão",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            if (confirmacao != JOptionPane.YES_OPTION) {
                return;
            }
            
            String sqlVerificaMedico = "SELECT Crm, Rqe FROM medico WHERE Id_Usuario=?";
            psVerificaMedico = conexao.prepareStatement(sqlVerificaMedico);
            psVerificaMedico.setInt(1, idUsuario);
            rsMedico = psVerificaMedico.executeQuery();
            
            String crm = "";
            if (rsMedico.next()) {
                crm = rsMedico.getString("Crm");
            }
            
            String sqlExcluirMedico = "DELETE FROM medico WHERE Id_Usuario=?";
            psExcluirMedico = conexao.prepareStatement(sqlExcluirMedico);
            psExcluirMedico.setInt(1, idUsuario);
            int linhasMedico = psExcluirMedico.executeUpdate();
            
            String sqlExcluirUsuario = "DELETE FROM usuarios WHERE Id_Usuario=?";
            psExcluirUsuario = conexao.prepareStatement(sqlExcluirUsuario);
            psExcluirUsuario.setInt(1, idUsuario);
            int linhasUsuario = psExcluirUsuario.executeUpdate();
            
            if (linhasUsuario > 0) {
                conexao.commit();
                
                
                JOptionPane.showMessageDialog(null,
                    "Médico excluído com sucesso!\n" +
                    "Nome: " + nomeUsuario + "\n" +
                    "CRM: " + (crm.isEmpty() ? "Não informado" : crm) + "\n" +
                    "CPF: " + FieldCpf.getText(),
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                conexao.rollback();
                JOptionPane.showMessageDialog(null,
                    "Erro ao excluir médico. Nenhum registro foi afetado.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            }
            limparCampos();
        } catch (SQLException e) {
            try {
                if (conexao != null) {
                    conexao.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            JOptionPane.showMessageDialog(null,
                "Erro ao excluir médico: " + e.getMessage() + "\n" +
                "Código do erro: " + e.getErrorCode(),
                "Erro no Banco de Dados",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            
        } finally {
            fecharRecurso(rsMedico);
            fecharRecurso(psVerificaMedico);
            fecharRecurso(rsUsuario);
            fecharRecurso(psVerificaUsuario);
            fecharRecurso(psExcluirMedico);
            fecharRecurso(psExcluirUsuario);
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
    /**
     */
    private void buscarEnderecoPorCEP() {
        String cep = FieldCep.getText().trim().replaceAll("[^0-9]", "");
        
        if (cep.length() != 8) {
            JOptionPane.showMessageDialog(this, "CEP deve conter 8 dígitos!", "CEP Inválido", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
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
                        JOptionPane.showMessageDialog(TelaAdministradorExcluirMedico.this, 
                            "CEP não encontrado!\nVerifique o CEP digitado.", 
                            "CEP não encontrado", 
                            JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    FieldMunicipio.setText(endereco.getLocalidade());
                    FieldEstado.setText(endereco.getUf());
                    FieldRua.setText(endereco.getLogradouro());
                    FieldBairro.setText(endereco.getBairro());
                    
                    SwingUtilities.invokeLater(() -> {
                        FieldNum.requestFocus();
                    });
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(TelaAdministradorExcluirMedico.this,
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