package telasSistema.Administrador;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
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

import Back.Secretaria;
import Back.Usuarios;
import model.Criptografia;
import model.Usuario;
public class TelaAdministradorEditarSecretaria extends JFrame {

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
    private JTextField FieldPlanoSaude;
    private JDateChooser dcDataNascimento;
    private Usuario usuarioAtual;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaAdministradorEditarSecretaria frame = new TelaAdministradorEditarSecretaria();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaAdministradorEditarSecretaria() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 888, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(143, 222, 239));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel LabelTitulo = new JLabel("Editar Dados da Secretaria");
        LabelTitulo.setBounds(315, 0, 320, 67);
        LabelTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
        contentPane.add(LabelTitulo);
        
        JLabel lblPreenchaOsDados = new JLabel("Preencha os dados da(o) secretária(o). Comece pelo CPF.");
        lblPreenchaOsDados.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblPreenchaOsDados.setBounds(297, 53, 331, 14);
        contentPane.add(lblPreenchaOsDados);

        JLabel labelCPF = new JLabel("CPF (Digite para buscar):");
        labelCPF.setFont(new Font("Trebuchet MS", Font.BOLD, 12));
        labelCPF.setBounds(375, 73, 154, 14);
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
        FieldCpf.setBounds(385, 98, 100, 25);
        contentPane.add(FieldCpf);

        JButton btnBuscarCPF = new JButton("Verificar");
        btnBuscarCPF.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
        btnBuscarCPF.setBounds(510, 98, 90, 25);
        btnBuscarCPF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	try {
                    String cpf = FieldCpf.getText().replace(".", "").replace("-", "");
                    Usuarios usuarios = new Usuarios();
                    usuarioAtual = usuarios.buscarUsuarioPorCpf(cpf);

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
                    FieldEstado.setText(usuarioAtual.getUf());

                    JOptionPane.showMessageDialog(null, "Usuário carregado com sucesso");

                } catch (Exception er) {
                    JOptionPane.showMessageDialog(null, "Erro ao buscar usuário");
                    er.printStackTrace();
                }
            }
        });
        contentPane.add(btnBuscarCPF);

        JLabel labelNome = new JLabel("Nome Completo:");
        labelNome.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        labelNome.setBounds(21, 142, 206, 14);
        contentPane.add(labelNome);

        FieldNome = new JTextField();
        FieldNome.setBounds(21, 166, 206, 20);
        contentPane.add(FieldNome);
        FieldNome.setColumns(10);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        labelEmail.setBounds(21, 196, 189, 14);
        contentPane.add(labelEmail);

        FieldEmail = new JTextField();
        FieldEmail.setBounds(21, 222, 206, 20);
        contentPane.add(FieldEmail);
        FieldEmail.setColumns(10);

        JLabel labelDataNascimento = new JLabel("Data de Nascimento:");
        labelDataNascimento.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        labelDataNascimento.setBounds(252, 142, 167, 14);
        contentPane.add(labelDataNascimento);

        dcDataNascimento = new JDateChooser();
        dcDataNascimento.setDateFormatString("dd/MM/yyyy");
        dcDataNascimento.setBounds(252, 166, 120, 20);
        contentPane.add(dcDataNascimento);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblTelefone.setBounds(252, 196, 189, 14);
        contentPane.add(lblTelefone);

        FieldTelefone = new JTextField();
        FieldTelefone.setText("(81)");
        FieldTelefone.setBounds(252, 222, 167, 20);
        contentPane.add(FieldTelefone);
        FieldTelefone.setColumns(10);

        JLabel lblPlanoSaude = new JLabel("Plano de Saúde:");
        lblPlanoSaude.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblPlanoSaude.setBounds(21, 255, 100, 14);
        contentPane.add(lblPlanoSaude);

        FieldPlanoSaude = new JTextField();
        FieldPlanoSaude.setBounds(21, 279, 206, 20);
        contentPane.add(FieldPlanoSaude);
        FieldPlanoSaude.setColumns(10);

        JLabel labelSENHA = new JLabel("Nova Senha:");
        labelSENHA.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        labelSENHA.setBounds(21, 315, 100, 14);
        contentPane.add(labelSENHA);

        FieldSENHA = new JPasswordField();
        FieldSENHA.setBounds(21, 339, 160, 20);
        contentPane.add(FieldSENHA);

        JLabel labelConfirmarSenha = new JLabel("Confirmar Senha:");
        labelConfirmarSenha.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        labelConfirmarSenha.setBounds(200, 315, 124, 14);
        contentPane.add(labelConfirmarSenha);

        FieldConfirmarSenha = new JPasswordField();
        FieldConfirmarSenha.setBounds(200, 339, 160, 20);
        contentPane.add(FieldConfirmarSenha);

        lblStrengthFeedbackNIVELSENHA = new JLabel("Nível:");
        lblStrengthFeedbackNIVELSENHA.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblStrengthFeedbackNIVELSENHA.setBounds(21, 365, 50, 14);
        contentPane.add(lblStrengthFeedbackNIVELSENHA);

        progressBarBARRAdoNIVELSENHA = new JProgressBar(0, 5);
        progressBarBARRAdoNIVELSENHA.setBounds(70, 365, 110, 18);
        progressBarBARRAdoNIVELSENHA.setStringPainted(true);
        contentPane.add(progressBarBARRAdoNIVELSENHA);

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
            }
        });
        contentPane.add(btnBuscarCEP);

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

        JLabel lblNum = new JLabel("Número:");
        lblNum.setFont(new Font("Trebuchet MS", Font.PLAIN, 10));
        lblNum.setBounds(740, 312, 72, 14);
        contentPane.add(lblNum);

        FieldNum = new JTextField();
        FieldNum.setBounds(740, 337, 59, 20);
        contentPane.add(FieldNum);
        FieldNum.setColumns(10);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnAtualizar.setForeground(new Color(0, 0, 0));
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (usuarioAtual == null) {
                    JOptionPane.showMessageDialog(null, "Busque uma secretária primeiro");
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
                    usuarioAtual.setNumCasa(FieldNum.getText());
                    usuarioAtual.setDataNasc(dcDataNascimento.getDate());
                    usuarioAtual.setUf(FieldEstado.getText());
                    String senhauser = new String(FieldSENHA.getPassword());
                    Criptografia criptografia = new Criptografia(senhauser,"MD5");

                	usuarioAtual.setSenha(criptografia.getInformacao());
                    usuarioAtual.setPlanoDeSaude(FieldPlanoSaude.getText());
                    
                    

                    Secretaria secretaria = new Secretaria();
                    secretaria.editarSecretaria(usuarioAtual);

                    JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao atualizar secretária");
                    ex.printStackTrace();
                }
            }
        });

        btnAtualizar.setBounds(677, 406, 135, 35);
        contentPane.add(btnAtualizar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnVoltar.setBounds(31, 407, 125, 32);
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
