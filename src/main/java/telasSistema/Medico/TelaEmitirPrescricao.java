package telasSistema.Medico;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaEmitirPrescricao extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textDiagnostico;
    private JTextField textPaciente;
    private JTextField textFrequencia;
    private JTextField textMedico;
    private JTextField textConvenio;
    private JTextField textAlergias;
    private JTextArea textMedicamentos;
    private JTextArea textDescricao;
    private JTextArea textNumeroPrescricao;
    private JComboBox<String> comboBoxDiaInicio;
    private JComboBox<String> comboBoxMesInicio;
    private JComboBox<String> comboBoxAnoInicio;
    private JComboBox<String> comboBoxDiaTermino;
    private JComboBox<String> comboBoxMesTermino;
    private JComboBox<String> comboBoxAnoTermino;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaEmitirPrescricao frame = new TelaEmitirPrescricao();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaEmitirPrescricao() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                voltarParaTelaAnterior();
            }
        });
        
        setTitle("Emitir Prescrição Médica");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(100, 100, 900, 550);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(135, 206, 235));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        inicializarComponentes();
        preencherComboboxDatas();
    }
    
    private void inicializarComponentes() {
        
        JLabel lblTitulo = new JLabel("EMITIR PRESCRIÇÃO MÉDICA");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 19));
        lblTitulo.setBounds(300, 20, 300, 30);
        contentPane.add(lblTitulo);
        
        JLabel lblNumeroPrescricao = new JLabel("Nº da Prescrição:");
        lblNumeroPrescricao.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblNumeroPrescricao.setBounds(50, 70, 130, 25);
        contentPane.add(lblNumeroPrescricao);
        
        textNumeroPrescricao = new JTextArea();
        textNumeroPrescricao.setBounds(180, 70, 150, 25);
        textNumeroPrescricao.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        contentPane.add(textNumeroPrescricao);
        
        JLabel lblPaciente = new JLabel("Paciente:");
        lblPaciente.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblPaciente.setBounds(350, 70, 100, 25);
        contentPane.add(lblPaciente);
        
        textPaciente = new JTextField();
        textPaciente.setBounds(420, 70, 150, 25);
        contentPane.add(textPaciente);
        textPaciente.setColumns(10);
        
        JLabel lblFrequencia = new JLabel("Frequência:");
        lblFrequencia.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblFrequencia.setBounds(600, 70, 100, 25);
        contentPane.add(lblFrequencia);
        
        textFrequencia = new JTextField();
        textFrequencia.setBounds(690, 70, 150, 25);
        contentPane.add(textFrequencia);
        textFrequencia.setColumns(10);
        
        JLabel lblDiagnostico = new JLabel("Diagnóstico:");
        lblDiagnostico.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblDiagnostico.setBounds(50, 120, 100, 25);
        contentPane.add(lblDiagnostico);
        
        textDiagnostico = new JTextField();
        textDiagnostico.setBounds(160, 120, 250, 25);
        contentPane.add(textDiagnostico);
        textDiagnostico.setColumns(10);
        
        JLabel lblDataInicio = new JLabel("Data de início:");
        lblDataInicio.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblDataInicio.setBounds(430, 120, 120, 25);
        contentPane.add(lblDataInicio);
        
        comboBoxDiaInicio = new JComboBox<>();
        comboBoxDiaInicio.setBounds(550, 120, 50, 25);
        contentPane.add(comboBoxDiaInicio);
        
        comboBoxMesInicio = new JComboBox<>();
        comboBoxMesInicio.setBounds(610, 120, 60, 25);
        contentPane.add(comboBoxMesInicio);
        
        comboBoxAnoInicio = new JComboBox<>();
        comboBoxAnoInicio.setBounds(680, 120, 70, 25);
        contentPane.add(comboBoxAnoInicio);
        
        JLabel lblDataTermino = new JLabel("Data de término:");
        lblDataTermino.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblDataTermino.setBounds(430, 160, 120, 25);
        contentPane.add(lblDataTermino);
        
        comboBoxDiaTermino = new JComboBox<>();
        comboBoxDiaTermino.setBounds(550, 160, 50, 25);
        contentPane.add(comboBoxDiaTermino);
        
        comboBoxMesTermino = new JComboBox<>();
        comboBoxMesTermino.setBounds(610, 160, 60, 25);
        contentPane.add(comboBoxMesTermino);
        
        comboBoxAnoTermino = new JComboBox<>();
        comboBoxAnoTermino.setBounds(680, 160, 70, 25);
        contentPane.add(comboBoxAnoTermino);
        
        JLabel lblMedicamentos = new JLabel("Medicamento(s):");
        lblMedicamentos.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblMedicamentos.setBounds(50, 200, 130, 25);
        contentPane.add(lblMedicamentos);
        
        textMedicamentos = new JTextArea();
        textMedicamentos.setBounds(50, 230, 350, 100);
        textMedicamentos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        textMedicamentos.setLineWrap(true);
        textMedicamentos.setWrapStyleWord(true);
        contentPane.add(textMedicamentos);
        
        JLabel lblDescricao = new JLabel("Descrição/Instruções:");
        lblDescricao.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblDescricao.setBounds(430, 200, 150, 25);
        contentPane.add(lblDescricao);
        
        textDescricao = new JTextArea();
        textDescricao.setBounds(430, 230, 400, 100);
        textDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        textDescricao.setLineWrap(true);
        textDescricao.setWrapStyleWord(true);
        contentPane.add(textDescricao);
        
        JLabel lblMedico = new JLabel("Médico:");
        lblMedico.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblMedico.setBounds(50, 350, 100, 25);
        contentPane.add(lblMedico);
        
        textMedico = new JTextField();
        textMedico.setBounds(120, 350, 200, 25);
        contentPane.add(textMedico);
        textMedico.setColumns(10);
        
        JLabel lblConvenio = new JLabel("Convênio:");
        lblConvenio.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblConvenio.setBounds(350, 350, 100, 25);
        contentPane.add(lblConvenio);
        
        textConvenio = new JTextField();
        textConvenio.setBounds(430, 350, 200, 25);
        contentPane.add(textConvenio);
        textConvenio.setColumns(10);
        
        JLabel lblAlergias = new JLabel("Alergia(s):");
        lblAlergias.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblAlergias.setBounds(50, 390, 100, 25);
        contentPane.add(lblAlergias);
        
        textAlergias = new JTextField();
        textAlergias.setBounds(120, 390, 510, 25);
        contentPane.add(textAlergias);
        textAlergias.setColumns(10);
        
        JButton btnImprimir = new JButton("EMITIR PRESCRIÇÃO");
        btnImprimir.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnImprimir.setBackground(new Color(255, 255, 255));
        btnImprimir.setForeground(Color.WHITE);
        btnImprimir.setBounds(550, 440, 200, 40);
        btnImprimir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                emitirPrescricao();
            }
        });
        contentPane.add(btnImprimir);
        
        JButton btnVoltar = new JButton("VOLTAR");
        btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnVoltar.setBackground(new Color(255, 255, 255));
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setBounds(150, 440, 150, 40);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarParaTelaAnterior();
            }
        });
        contentPane.add(btnVoltar);
        
        JButton btnLimpar = new JButton("LIMPAR CAMPOS");
        btnLimpar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnLimpar.setBackground(new Color(255, 255, 255));
        btnLimpar.setForeground(Color.WHITE);
        btnLimpar.setBounds(350, 440, 150, 40);
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        contentPane.add(btnLimpar);
    }
    
    private void preencherComboboxDatas() {
        for (int i = 1; i <= 31; i++) {
            String dia = String.format("%02d", i);
            comboBoxDiaInicio.addItem(dia);
            comboBoxDiaTermino.addItem(dia);
        }
        
        String[] meses = {"Jan", "Fev", "Mar", "Abr", "Mai", "Jun", 
                         "Jul", "Ago", "Set", "Out", "Nov", "Dez"};
        for (String mes : meses) {
            comboBoxMesInicio.addItem(mes);
            comboBoxMesTermino.addItem(mes);
        }
        
        for (int i = 2020; i <= 2030; i++) {
            String ano = String.valueOf(i);
            comboBoxAnoInicio.addItem(ano);
            comboBoxAnoTermino.addItem(ano);
        }
        
        comboBoxDiaInicio.setSelectedIndex(15);
        comboBoxMesInicio.setSelectedIndex(5); 
        comboBoxAnoInicio.setSelectedItem("2024");
        
        comboBoxDiaTermino.setSelectedIndex(30);
        comboBoxMesTermino.setSelectedIndex(5); 
        comboBoxAnoTermino.setSelectedItem("2024");
    }
    
    private void emitirPrescricao() {
        String paciente = textPaciente.getText().trim();
        String diagnostico = textDiagnostico.getText().trim();
        String medicamentos = textMedicamentos.getText().trim();
        String medico = textMedico.getText().trim();
        String convenio = textConvenio.getText().trim();
        String alergias = textAlergias.getText().trim();
        String frequencia = textFrequencia.getText().trim();
        String descricao = textDescricao.getText().trim();
        
        String dataInicio = comboBoxDiaInicio.getSelectedItem() + "/" + 
                           comboBoxMesInicio.getSelectedItem() + "/" + 
                           comboBoxAnoInicio.getSelectedItem();
        
        String dataTermino = comboBoxDiaTermino.getSelectedItem() + "/" + 
                            comboBoxMesTermino.getSelectedItem() + "/" + 
                            comboBoxAnoTermino.getSelectedItem();
        
        if (paciente.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Informe o nome do paciente!", 
                "Campo obrigatório", 
                JOptionPane.WARNING_MESSAGE);
            textPaciente.requestFocus();
            return;
        }
        
        if (diagnostico.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Informe o diagnóstico!", 
                "Campo obrigatório", 
                JOptionPane.WARNING_MESSAGE);
            textDiagnostico.requestFocus();
            return;
        }
        
        if (medicamentos.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Informe os medicamentos!", 
                "Campo obrigatório", 
                JOptionPane.WARNING_MESSAGE);
            textMedicamentos.requestFocus();
            return;
        }
        
        if (medico.isEmpty()) {
            medico = "Dr. Não Informado";
        }
        
        if (alergias.isEmpty()) {
            alergias = "Nenhuma conhecida";
        }
        
        if (convenio.isEmpty()) {
            convenio = "Particular";
        }
        
        if (frequencia.isEmpty()) {
            frequencia = "Conforme orientação médica";
        }
        
        try {
            Back.EmitirPrescricao prescricao = new Back.EmitirPrescricao(
                medico,
                paciente,
                diagnostico,
                medicamentos,
                descricao,
                frequencia,
                dataInicio,
                dataTermino,
                convenio,
                alergias,
                "" 
            );
            
            boolean sucesso = prescricao.emitir();
            
            if (sucesso) {
                int opcao = JOptionPane.showOptionDialog(this,
                    "Prescrição emitida com sucesso!\nDeseja limpar os campos para nova prescrição?",
                    "Sucesso",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new Object[]{"Sim", "Não"},
                    "Sim");
                
                if (opcao == JOptionPane.YES_OPTION) {
                    limparCampos();
                }
            } else {
                JOptionPane.showMessageDialog(this,
                    "Erro ao emitir prescrição. Verifique se o Adobe Reader está instalado.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro: " + e.getMessage(),
                "Erro inesperado",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    private void limparCampos() {
        textPaciente.setText("");
        textDiagnostico.setText("");
        textMedicamentos.setText("");
        textMedico.setText("");
        textConvenio.setText("");
        textAlergias.setText("");
        textFrequencia.setText("");
        textDescricao.setText("");
        textNumeroPrescricao.setText("");
        
        comboBoxDiaInicio.setSelectedIndex(15);
        comboBoxMesInicio.setSelectedIndex(5);
        comboBoxAnoInicio.setSelectedItem("2024");
        
        comboBoxDiaTermino.setSelectedIndex(30);
        comboBoxMesTermino.setSelectedIndex(5);
        comboBoxAnoTermino.setSelectedItem("2024");
        
        textPaciente.requestFocus();
    }
    
    private void voltarParaTelaAnterior() {
        int confirmacao = JOptionPane.showConfirmDialog(this,
            "Deseja realmente voltar? Os dados não salvos serão perdidos.",
            "Confirmar saída",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirmacao == JOptionPane.YES_OPTION) {
           
            dispose();
        }
    }
    
    public void preencherDadosPaciente(String nome, String convenio, String alergias) {
        textPaciente.setText(nome);
        textConvenio.setText(convenio);
        textAlergias.setText(alergias);
    }
    
    public void setMedico(String nomeMedico) {
        textMedico.setText(nomeMedico);
    }
}