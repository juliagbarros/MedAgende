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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import Back.Secretaria;
import Back.Usuarios;
import model.Usuario;

public class TelaAdministradorExcluirSecretaria extends JFrame {

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
    private JTextField FieldPlanoSaude;
    private JDateChooser dcDataNascimento;
    private Usuario usuarioAtual;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaAdministradorExcluirSecretaria frame = new TelaAdministradorExcluirSecretaria();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaAdministradorExcluirSecretaria() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 888, 500);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(143, 222, 239));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel LabelTitulo = new JLabel("Excluir Secretaria");
        LabelTitulo.setBounds(359, 0, 320, 67);
        LabelTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
        contentPane.add(LabelTitulo);
        
        JLabel lblPreenchaOsDados = new JLabel("Digite o CPF para buscar a secretára para excluir: ");
        lblPreenchaOsDados.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
        lblPreenchaOsDados.setBounds(307, 53, 331, 14);
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
                        JOptionPane.showMessageDialog(null, "Secretária não encontrada");
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
                    FieldEstado.setText(usuarioAtual.getUf());
                    dcDataNascimento.setDate(usuarioAtual.getDataNasc());

                    JOptionPane.showMessageDialog(null, "Secretária carregada");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao buscar secretária");
                    ex.printStackTrace();
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

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnExcluir.setForeground(new Color(0, 0, 0));
        btnExcluir.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

              	if (usuarioAtual == null) {
                    JOptionPane.showMessageDialog(null, "Busque uma secretária primeiro");
                    return;
                }

                int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esta secretária?", "Confirmação", JOptionPane.YES_NO_OPTION);

                if (opcao == JOptionPane.YES_OPTION) {
                    try {
                        Secretaria secretaria = new Secretaria();
                        secretaria.deletarSecretaria(usuarioAtual.getIdUsuario());
                        JOptionPane.showMessageDialog(null, "Secretária excluída com sucesso");
                       
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao excluir secretária");
                        ex.printStackTrace();
                    }
                }
            }
        });

        btnExcluir.setBounds(677, 406, 135, 35);
        contentPane.add(btnExcluir);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnVoltar.setBounds(31, 407, 125, 32);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TelaAdminExcluirUsuarios telaAdminExcluirUsuarios = new TelaAdminExcluirUsuarios();
            	telaAdminExcluirUsuarios.setLocationRelativeTo(null);
            	telaAdminExcluirUsuarios.setVisible(true);
				 dispose();
            }
        });
        contentPane.add(btnVoltar);
        

    }
}
