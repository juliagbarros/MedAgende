package telasSistema.Administrador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import Back.Médico;
import Back.Usuarios;
import dao.EspecialidadeDAO;
import model.Usuario;
import model.Medico;

public class TelaAdministradorEditarMedico extends JFrame {

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
    private Usuario usuarioAtual;
    private Medico medicoAtual;


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

        FieldCpf = new JFormattedTextField(maskCpf);
        FieldCpf.setBounds(381, 98, 100, 25);
        contentPane.add(FieldCpf);

        JButton btnBuscarCPF = new JButton("Verificar");
        btnBuscarCPF.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
        btnBuscarCPF.setBounds(502, 98, 90, 25);
        btnBuscarCPF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String cpf = FieldCpf.getText().replace(".", "").replace("-", "");
                    Usuarios usuarios = new Usuarios();
                    usuarioAtual = usuarios.buscarUsuarioPorCpf(cpf);
                    
                    Médico medicos = new Médico();
                    medicoAtual = medicos.buscarDadosMedico(usuarioAtual.getIdUsuario());

                    if (medicoAtual != null) {
                        FieldCrm.setText(medicoAtual.getCrm());
                        FieldRqe.setText(medicoAtual.getRqe());
                        BoxEspecialidades.setSelectedItem(medicoAtual.getEspecialidade());
                    }

                    if (usuarioAtual == null) {
                        JOptionPane.showMessageDialog(null, "Usuário não encontrado");
                        return;
                    }
                    
                    FieldNome.setText(usuarioAtual.getNome());
                    FieldEmail.setText(usuarioAtual.getEmail());
                    FieldTelefone.setText(usuarioAtual.getTelefone());
                    FieldRua.setText(usuarioAtual.getRua());
                    FieldBairro.setText(usuarioAtual.getBairro());
                    FieldMunicipio.setText(usuarioAtual.getCidade());
                    FieldCep.setText(usuarioAtual.getCep());
                    FieldPlanoSaude.setText(usuarioAtual.getPlanoDeSaude());
                    FieldNum.setText(usuarioAtual.getNumCasa());
                    dcDataNascimento.setDate(usuarioAtual.getDataNasc());
                    JOptionPane.showMessageDialog(null, "Usuário carregado com sucesso");

                } catch (Exception er) {
                    JOptionPane.showMessageDialog(null, "Erro ao buscar usuário");
                    er.printStackTrace();
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
        DefaultComboBoxModel<String> modeloespecialidades = EspecialidadeDAO.getespecialidades();
        JLabel lblEsp = new JLabel("Especialidade:");
        lblEsp.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblEsp.setBounds(21, 308, 100, 14);
        contentPane.add(lblEsp);

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
                // TODO: Adicionar lógica de busca de CEP
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
        lblRua.setBounds(740, 256, 46, 14);
        contentPane.add(lblRua);

        FieldRua = new JTextField();
        FieldRua.setBounds(740, 281, 86, 20);
        contentPane.add(FieldRua);
        FieldRua.setColumns(10);

        // Número
        JLabel lblNum = new JLabel("Número:");
        lblNum.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNum.setBounds(740, 312, 72, 14);
        contentPane.add(lblNum);

        FieldNum = new JTextField();
        FieldNum.setBounds(740, 337, 59, 20);
        contentPane.add(FieldNum);
        FieldNum.setColumns(10);

        // --- BOTÕES DE AÇÃO ---
        
        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        btnAtualizar.setForeground(Color.BLACK);
        btnAtualizar.addActionListener(e -> {
            if (usuarioAtual == null) {
                JOptionPane.showMessageDialog(this, "Busque um médico pelo CPF primeiro!");
                return;
            }

            
            try {
        
                usuarioAtual.setNome(FieldNome.getText());
                usuarioAtual.setEmail(FieldEmail.getText());
                usuarioAtual.setTelefone(FieldTelefone.getText());
                usuarioAtual.setRua(FieldRua.getText());
                usuarioAtual.setBairro(FieldBairro.getText());
                usuarioAtual.setCidade(FieldMunicipio.getText());
                usuarioAtual.setCep(FieldCep.getText());
                usuarioAtual.setPlanoDeSaude(FieldPlanoSaude.getText());
                usuarioAtual.setNumCasa(FieldNum.getText());
                usuarioAtual.setDataNasc(dcDataNascimento.getDate());
            
                
                String crm = FieldCrm.getText();
                String rqe = FieldRqe.getText();
                int especialidade = BoxEspecialidades.getSelectedIndex();
                //gambiarra +1
                especialidade += 1;

                Médico med = new Médico();
                med.editarMedico(usuarioAtual, crm, rqe, especialidade);
                JOptionPane.showMessageDialog(this, "Médico atualizado");

            } 
            catch (SQLException er) {
                JOptionPane.showMessageDialog(this, "Erro ao conectar com o banco de dados");
            } 
            catch (Exception er) {
                JOptionPane.showMessageDialog(this, "Erro inesperado");
            }
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
    }
}
