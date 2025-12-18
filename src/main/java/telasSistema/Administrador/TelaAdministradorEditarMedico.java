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
import conexao.ConnectionFactory;
import model.Criptografia;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class TelaAdministradorEditarMedico extends JFrame {
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
    private JLabel lblStrengthFeedbackNIVELSENHA;
    private JProgressBar progressBarBARRAdoNIVELSENHA;
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
	private int Id_Usuario;
	private int Especialidade;
	
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
                    TelaAdministradorEditarMedico frame = new TelaAdministradorEditarMedico();
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
    public TelaAdministradorEditarMedico() {
    	
    	httpClient = new OkHttpClient();
		gson = new Gson();
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 888, 550);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(143, 222, 239));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel LabelTitulo = new JLabel("Editar Dados do Médico");
        LabelTitulo.setBounds(315, 0, 300, 67);
        LabelTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
        contentPane.add(LabelTitulo);
        
        JLabel lblPreenchaOsDados = new JLabel("Preencha os dados do(a) médico(a). Comece pelo CPF.");
        lblPreenchaOsDados.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblPreenchaOsDados.setBounds(299, 53, 331, 14);
        contentPane.add(lblPreenchaOsDados);

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
        FieldCpf.setBounds(381, 98, 100, 25);
        contentPane.add(FieldCpf);

        JButton btnBuscarCPF = new JButton("Verificar");
        btnBuscarCPF.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
        btnBuscarCPF.setBounds(502, 98, 90, 25);
        btnBuscarCPF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    verificar();      
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
        DefaultComboBoxModel<String> modeloespecialidades;
        try {
            Especialidade especialidades = new Especialidade();
            modeloespecialidades = especialidades.buscaEspecialidades();
          
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar especialidades");
            modeloespecialidades = new DefaultComboBoxModel<>();
            e.printStackTrace();
        }
        BoxEspecialidades = new JComboBox<>();
        BoxEspecialidades.setModel(modeloespecialidades);
        BoxEspecialidades.setBounds(21, 329, 206, 22);
        contentPane.add(BoxEspecialidades);
        
        // --- SEGURANÇA (SENHA) ---
        JLabel labelSENHA = new JLabel("Nova Senha:");
        labelSENHA.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        labelSENHA.setBounds(21, 360, 100, 14);
        contentPane.add(labelSENHA);

        FieldSENHA = new JPasswordField();
        FieldSENHA.setBounds(21, 384, 160, 20);
        contentPane.add(FieldSENHA);

        JLabel labelConfirmarSenha = new JLabel("Confirmar Senha:");
        labelConfirmarSenha.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        labelConfirmarSenha.setBounds(200, 360, 124, 14);
        contentPane.add(labelConfirmarSenha);

        FieldConfirmarSenha = new JPasswordField();
        FieldConfirmarSenha.setBounds(200, 384, 160, 20);
        contentPane.add(FieldConfirmarSenha);

        lblStrengthFeedbackNIVELSENHA = new JLabel("Nível:");
        lblStrengthFeedbackNIVELSENHA.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblStrengthFeedbackNIVELSENHA.setBounds(21, 410, 50, 14);
        contentPane.add(lblStrengthFeedbackNIVELSENHA);

        progressBarBARRAdoNIVELSENHA = new JProgressBar(0, 5);
        progressBarBARRAdoNIVELSENHA.setBounds(70, 410, 110, 18);
        progressBarBARRAdoNIVELSENHA.setStringPainted(true);
        contentPane.add(progressBarBARRAdoNIVELSENHA);

        // --- ENDEREÇO (LATERAL DIREITA) ---
        
        // CEP
        JLabel lblCep = new JLabel("CEP:");
        lblCep.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblCep.setBounds(644, 140, 46, 14);
        contentPane.add(lblCep);

        FieldCep = new JTextField();
        FieldCep.setBounds(644, 166, 86, 20);
        contentPane.add(FieldCep);
        FieldCep.setColumns(10);

        JButton btnBuscarCEP = new JButton("Buscar");
        btnBuscarCEP.setBounds(740, 165, 83, 22);
        btnBuscarCEP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	buscarEnderecoPorCEP();
            }
        });
        contentPane.add(btnBuscarCEP);

        // Município e Estado
        JLabel lblMun = new JLabel("Município:");
        lblMun.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblMun.setBounds(740, 199, 72, 14);
        contentPane.add(lblMun);

        FieldMunicipio = new JTextField();
        FieldMunicipio.setBounds(740, 224, 86, 20);
        contentPane.add(FieldMunicipio);

        JLabel lblEst = new JLabel("UF:");
        lblEst.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblEst.setBounds(644, 199, 72, 14);
        contentPane.add(lblEst);

        FieldEstado = new JTextField();
        FieldEstado.setBounds(644, 224, 46, 20);
        contentPane.add(FieldEstado);
        
        // Bairro e Rua
        JLabel lblBairro = new JLabel("Bairro:");
        lblBairro.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblBairro.setBounds(644, 256, 46, 14);
        contentPane.add(lblBairro);

        FieldBairro = new JTextField();
        FieldBairro.setBounds(644, 281, 86, 20);
        contentPane.add(FieldBairro);

        JLabel lblRua = new JLabel("Rua:");
        lblRua.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblRua.setBounds(644, 312, 46, 14);
        contentPane.add(lblRua);

        FieldRua = new JTextField();
        FieldRua.setBounds(644, 330, 179, 20);
        contentPane.add(FieldRua);
        FieldRua.setColumns(10);

        // Número
        JLabel lblNum = new JLabel("Número:");
        lblNum.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNum.setBounds(750, 256, 72, 14);
        contentPane.add(lblNum);

        FieldNum = new JTextField();
        FieldNum.setBounds(753, 281, 59, 20);
        contentPane.add(FieldNum);
        FieldNum.setColumns(10);

        // --- BOTÕES DE AÇÃO ---
        
        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        btnAtualizar.setForeground(Color.BLACK);
        btnAtualizar.addActionListener(e -> {
        	validarDados();
        	atualizar();
        });

        btnAtualizar.setBounds(678, 459, 145, 35);
        contentPane.add(btnAtualizar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        btnVoltar.setBounds(31, 460, 125, 32);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		TelaAdminEditarUsuarios telaAdminEditarUsuarios = new TelaAdminEditarUsuarios();
            		telaAdminEditarUsuarios.setLocationRelativeTo(null);
            		telaAdminEditarUsuarios.setVisible(true);
    				 dispose();
            }
        });
        contentPane.add(btnVoltar);
     // chamando o método que implementa O DocumentListener
        implementPasswordStrengthCheck();
        
        // ADICIONA LISTENER PARA BUSCA AUTOMÁTICA DE CEP
        implementCEPAutoComplete();
    
}
    public void atualizar() {
        Connection conexao = null;
        PreparedStatement psIdusuario = null;
        ResultSet rsidusuario = null;
        PreparedStatement psusuario = null;
        PreparedStatement psmedico = null;
        
        try {
            conexao = ConnectionFactory.getConnection();
            conexao.setAutoCommit(false); // Iniciar transação
            
            int idusuario = 0;
            
            String sqlIdusuario = "SELECT id_usuario FROM usuarios WHERE cpf=?";
            psIdusuario = conexao.prepareStatement(sqlIdusuario);
            psIdusuario.setString(1, FieldCpf.getText());
            rsidusuario = psIdusuario.executeQuery();
            
            if (rsidusuario.next()) {
                idusuario = rsidusuario.getInt("id_usuario");
            } else {
                throw new SQLException("Usuário não encontrado com o CPF informado");
            }
            
            String sqlusuario = "UPDATE usuarios SET Email=?,Senha=?, Nome=?, CPF=?, "
                              + "Data_Nasc=?, Bairro=?, Rua=?, Num_Casa=?, Cidade=?, "
                              + "Uf=?, Plano_De_Saude=?, CEP=?, Telefone=? "
                              + "WHERE id_usuario=?";
            
            psusuario = conexao.prepareStatement(sqlusuario); // REMOVER Statement.RETURN_GENERATED_KEYS
            
            psusuario.setString(1, FieldEmail.getText());
            String senha = new String(FieldSENHA.getPassword());
            Criptografia criptografia = new Criptografia(senha,"MD5");

            psusuario.setString(2, criptografia.getInformacao());
            psusuario.setString(3, FieldNome.getText());
            psusuario.setString(4, FieldCpf.getText());
            
            // Converter data
            java.util.Date dataNascUtil = dcDataNascimento.getDate();
            if (dataNascUtil != null) {
                java.sql.Date dataNascSql = new java.sql.Date(dataNascUtil.getTime());
                psusuario.setDate(5, dataNascSql);
            } else {
                psusuario.setNull(5, java.sql.Types.DATE);
            }
            
            psusuario.setString(6, FieldBairro.getText());
            psusuario.setString(7, FieldRua.getText());
            psusuario.setString(8, FieldNum.getText());
            psusuario.setString(9, FieldMunicipio.getText());
            psusuario.setString(10, FieldEstado.getText());
            psusuario.setString(11, FieldPlanoSaude.getText());
            psusuario.setString(12, FieldCep.getText());
            psusuario.setString(13, FieldTelefone.getText());
            psusuario.setInt(14, idusuario);
            
            int linhasAfetadas = psusuario.executeUpdate();
            
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha ao atualizar paciente");
            }
            
            if (!FieldCrm.getText().trim().isEmpty()) {
                String sqlVerificaMedico = "SELECT COUNT(*) FROM medico WHERE id_usuario=?";
                PreparedStatement psVerifica = conexao.prepareStatement(sqlVerificaMedico);
                psVerifica.setInt(1, idusuario);
                ResultSet rsVerifica = psVerifica.executeQuery();
                
                boolean medicoExiste = false;
                if (rsVerifica.next()) {
                    medicoExiste = rsVerifica.getInt(1) > 0;
                }
                psVerifica.close();
                rsVerifica.close();
                
                if (medicoExiste) {
                    String sqlmedico = "UPDATE medico SET Crm=?, Rqe=?, Especialidade=? "
                                     + "WHERE id_usuario=?";
                    
                    psmedico = conexao.prepareStatement(sqlmedico);
                    psmedico.setString(1, FieldCrm.getText());
                    psmedico.setString(2, FieldRqe.getText());
                    psmedico.setInt(3,BoxEspecialidades.getSelectedIndex()+1);
                    
                    
                    psmedico.setInt(4, idusuario);
                    int linhasMedico = psmedico.executeUpdate();
                    
                    if (linhasMedico == 0) {
                        throw new SQLException("Falha ao atualizar dados do médico");
                    }
                } else { JOptionPane.showMessageDialog(null,
                        "Medico não existe!" + idusuario,
                        "failed", JOptionPane.WARNING_MESSAGE);
                	
                }
            }
            
            conexao.commit();
            
            JOptionPane.showMessageDialog(null,
                "Medico atualizado com sucesso! ID: " + idusuario,
                "Sucess", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e) {
            try {
                if (conexao != null) {
                    conexao.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
            JOptionPane.showMessageDialog(null,
                "Erro ao atualizar paciente: " + e.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Erro inesperado: " + e.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            
        } finally {
            try {
                if (rsidusuario != null) rsidusuario.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            try {
                if (psmedico != null) psmedico.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            try {
                if (psusuario != null) psusuario.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            try {
                if (psIdusuario != null) psIdusuario.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            try {
                if (conexao != null) {
                    conexao.setAutoCommit(true); 
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
                        JOptionPane.showMessageDialog(TelaAdministradorEditarMedico.this, 
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
                        FieldNum.requestFocus();
                    });
                    
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(TelaAdministradorEditarMedico.this,
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
