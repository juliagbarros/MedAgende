package telasSistema.Secretaria;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexao.ConnectionFactory;

public class TelaHistoricoAgendamentos extends JFrame {

    private static final long serialVersionUID = 1L;

    // Labels preenchidos dinamicamente
    private JLabel lblConsulta1;
    private JLabel lblConsulta2;
    private JLabel lblConsulta3;
    private JLabel lblStatusBusca;
    private JTextField txtCPFBusca;
    private JButton btnBuscarCPF;
    private JButton btnLimparBusca;

    public TelaHistoricoAgendamentos() {
        setBounds(100, 100, 742, 500); // Aumentei a altura para acomodar os novos componentes
        getContentPane().setBackground(new Color(170, 255, 255));
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 253, 255));
        panel.setBounds(0, 1, 729, 463); // Aumentei a altura do painel principal
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Histórico de Consultas");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setBounds(215, 20, 350, 54); // Ajustei a posição Y
        panel.add(lblTitulo);

        // Adicionando campo de busca por CPF
        JLabel lblBuscaCPF = new JLabel("Buscar por CPF:");
        lblBuscaCPF.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblBuscaCPF.setBounds(81, 85, 100, 20);
        panel.add(lblBuscaCPF);

        txtCPFBusca = new JTextField();
        txtCPFBusca.setBounds(160, 85, 180, 25);
        txtCPFBusca.setColumns(10);
        panel.add(txtCPFBusca);

        btnBuscarCPF = new JButton("Buscar");
        btnBuscarCPF.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnBuscarCPF.setBounds(350, 85, 80, 25);
        btnBuscarCPF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarConsultasPorCPF();
            }
        });
        panel.add(btnBuscarCPF);

        btnLimparBusca = new JButton("Limpar");
        btnLimparBusca.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnLimparBusca.setBounds(440, 85, 80, 25);
        btnLimparBusca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparBusca();
            }
        });
        panel.add(btnLimparBusca);

        lblStatusBusca = new JLabel("");
        lblStatusBusca.setFont(new Font("Segoe UI", Font.ITALIC, 10));
        lblStatusBusca.setForeground(Color.BLUE);
        lblStatusBusca.setBounds(160, 110, 400, 20);
        panel.add(lblStatusBusca);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(e -> {
            TelaPrincipalSecretaria tela = new TelaPrincipalSecretaria();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
            dispose();
        });
        btnConfirmar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnConfirmar.setBounds(533, 400, 95, 20); // Ajustei a posição Y
        panel.add(btnConfirmar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            TelaPrincipalSecretaria tela = new TelaPrincipalSecretaria();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
            dispose();
        });
        btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnVoltar.setBounds(98, 400, 84, 20); // Ajustei a posição Y
        panel.add(btnVoltar);

        // Painel 1
        JPanel panel1 = new JPanel();
        panel1.setBounds(81, 140, 572, 54); // Ajustei a posição Y
        panel.add(panel1);
        panel1.setLayout(null);

        lblConsulta1 = new JLabel();
        lblConsulta1.setBounds(10, 10, 550, 34);
        lblConsulta1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panel1.add(lblConsulta1);

        // Painel 2
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(81, 210, 572, 54); // Ajustei a posição Y
        panel.add(panel2);

        lblConsulta2 = new JLabel();
        lblConsulta2.setBounds(10, 10, 550, 34);
        lblConsulta2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panel2.add(lblConsulta2);

        // Painel 3
        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(81, 280, 572, 54); // Ajustei a posição Y
        panel.add(panel3);

        lblConsulta3 = new JLabel();
        lblConsulta3.setBounds(10, 10, 550, 34);
        lblConsulta3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panel3.add(lblConsulta3);

        // Adicionar listener para busca automática ao perder foco
        txtCPFBusca.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!txtCPFBusca.getText().trim().isEmpty()) {
                    buscarConsultasPorCPF();
                }
            }
        });

        // Carregar histórico geral inicial
        carregarHistorico();
    }

    private void carregarHistorico() {
        carregarHistorico(null);
    }

    private void carregarHistorico(String cpfFiltro) {
        // Limpar labels
        lblConsulta1.setText("");
        lblConsulta2.setText("");
        lblConsulta3.setText("");

        // Construir SQL com ou sem filtro de CPF
        String sql;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;

        try {
            con = ConnectionFactory.getConnection();
            
            if (cpfFiltro != null && !cpfFiltro.trim().isEmpty()) {
                // Buscar paciente pelo CPF primeiro para obter o ID
                String cpfFormatado = cpfFiltro.replaceAll("[^0-9]", "");
                
                // Verificar se o paciente existe
                String sqlPaciente = "SELECT Id_Paciente, Nome FROM paciente WHERE CPF = ?";
                ps = con.prepareStatement(sqlPaciente);
                ps.setString(1, cpfFormatado);
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    int idPaciente = rs.getInt("Id_Paciente");
                    String nomePaciente = rs.getString("Nome");
                    
                    // Fechar ResultSet atual
                    rs.close();
                    ps.close();
                    
                    // Agora buscar as consultas deste paciente
                    sql = "SELECT " +
                          "p.Nome AS paciente, " +
                          "u.Nome AS medico, " +
                          "e.Nome_Especialidade AS especialidade, " +
                          "c.Data, " +
                          "c.Hora, " +
                          "c.Status " +
                          "FROM consultas c " +
                          "JOIN paciente p ON c.Id_Paciente = p.Id_Paciente " +
                          "JOIN medico m ON c.Matricula_Med = m.Matricula " +
                          "JOIN usuarios u ON m.Id_Usuario = u.Id_Usuario " +
                          "JOIN especialidades e ON m.Especialidade = e.Id_Especialidade " +
                          "WHERE p.Id_Paciente = ? " +
                          "ORDER BY c.Data DESC, c.Hora DESC " +
                          "LIMIT 3";
                    
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, idPaciente);
                    rs = ps.executeQuery();
                    
                    lblStatusBusca.setText("Mostrando consultas para: " + nomePaciente + " (CPF: " + formatarCPF(cpfFormatado) + ")");
                    lblStatusBusca.setForeground(new Color(0, 100, 0)); // Verde escuro
                    
                } else {
                    // Paciente não encontrado
                    lblConsulta1.setText("Paciente com CPF " + formatarCPF(cpfFormatado) + " não encontrado.");
                    lblConsulta1.setForeground(Color.RED);
                    lblStatusBusca.setText("Paciente não encontrado");
                    lblStatusBusca.setForeground(Color.RED);
                    return;
                }
            } else {
                // Histórico geral (sem filtro)
                sql = "SELECT " +
                      "p.Nome AS paciente, " +
                      "u.Nome AS medico, " +
                      "e.Nome_Especialidade AS especialidade, " +
                      "c.Data, " +
                      "c.Hora, " +
                      "c.Status " +
                      "FROM consultas c " +
                      "JOIN paciente p ON c.Id_Paciente = p.Id_Paciente " +
                      "JOIN medico m ON c.Matricula_Med = m.Matricula " +
                      "JOIN usuarios u ON m.Id_Usuario = u.Id_Usuario " +
                      "JOIN especialidades e ON m.Especialidade = e.Id_Especialidade " +
                      "ORDER BY c.Data DESC, c.Hora DESC " +
                      "LIMIT 3";
                
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                
                lblStatusBusca.setText("Mostrando últimas 3 consultas gerais");
                lblStatusBusca.setForeground(Color.BLUE);
            }

            JLabel[] labels = { lblConsulta1, lblConsulta2, lblConsulta3 };
            int i = 0;
            
            while (rs.next() && i < labels.length) {
                String status = rs.getString("Status");
                Color corStatus = Color.BLACK;
                
                // Definir cor baseada no status
                if ("agendada".equalsIgnoreCase(status)) {
                    corStatus = new Color(0, 100, 0); // Verde
                } else if ("cancelada".equalsIgnoreCase(status)) {
                    corStatus = Color.RED;
                } else if ("realizada".equalsIgnoreCase(status)) {
                    corStatus = Color.BLUE;
                }
                
                labels[i].setText(
                    "<html>" +
                    "<b>Paciente:</b> " + rs.getString("paciente") +
                    " | <b>Especialidade:</b> " + rs.getString("especialidade") +
                    " | <b>Médico:</b> " + rs.getString("medico") +
                    " | <b>Data:</b> " + rs.getDate("Data") +
                    " | <b>Hora:</b> " + rs.getTime("Hora") +
                    " | <b>Status:</b> <font color='" + getColorHex(corStatus) + "'>" + status + "</font>" +
                    "</html>"
                );
                
                labels[i].setForeground(Color.BLACK);
                i++;
            }

            if (i == 0) {
                lblConsulta1.setText("Nenhuma consulta encontrada.");
                lblConsulta1.setForeground(Color.GRAY);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar histórico de consultas: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            lblStatusBusca.setText("Erro ao buscar consultas");
            lblStatusBusca.setForeground(Color.RED);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void buscarConsultasPorCPF() {
        String cpf = txtCPFBusca.getText().trim();
        
        if (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, digite um CPF para buscar.",
                "CPF Vazio",
                JOptionPane.WARNING_MESSAGE);
            txtCPFBusca.requestFocus();
            return;
        }
        
        // Formatar CPF (remover caracteres não numéricos)
        String cpfFormatado = cpf.replaceAll("[^0-9]", "");
        
        // Validar formato do CPF
        if (cpfFormatado.length() != 11) {
            JOptionPane.showMessageDialog(this,
                "CPF inválido! Deve conter 11 dígitos.\n" +
                "Exemplo: 123.456.789-01",
                "CPF Inválido",
                JOptionPane.WARNING_MESSAGE);
            txtCPFBusca.requestFocus();
            return;
        }
        
        // Desabilitar botão durante a busca
        btnBuscarCPF.setEnabled(false);
        btnBuscarCPF.setText("Buscando...");
        
        // Carregar histórico filtrado por CPF
        carregarHistorico(cpfFormatado);
        
        // Reabilitar botão
        btnBuscarCPF.setEnabled(true);
        btnBuscarCPF.setText("Buscar");
    }

    private void limparBusca() {
        txtCPFBusca.setText("");
        lblStatusBusca.setText("");
        carregarHistorico(); // Carregar histórico geral
        txtCPFBusca.requestFocus();
    }

    private String formatarCPF(String cpf) {
        if (cpf.length() == 11) {
            return cpf.substring(0, 3) + "." + 
                   cpf.substring(3, 6) + "." + 
                   cpf.substring(6, 9) + "-" + 
                   cpf.substring(9, 11);
        }
        return cpf;
    }

    private String getColorHex(Color color) {
        return String.format("#%02x%02x%02x", 
            color.getRed(), 
            color.getGreen(), 
            color.getBlue());
    }

    public static void main(String[] args) {
        TelaHistoricoAgendamentos tela = new TelaHistoricoAgendamentos();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }
}