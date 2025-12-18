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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Time;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import conexao.ConnectionFactory;

public class TelaHistoricoAgendamentos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtCPFBusca;
    private JButton btnBuscarCPF;
    private JButton btnLimparBusca;
    private JLabel lblStatusBusca;
    private JTable tabelaConsultas;
    private DefaultTableModel modeloTabela;
    private JScrollPane scrollPane;

    public TelaHistoricoAgendamentos() {
        setTitle("Histórico de Consultas");
        setBounds(100, 100, 1000, 650);
        getContentPane().setBackground(new Color(170, 255, 255));
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 253, 255));
        panel.setBounds(0, 1, 986, 613);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Histórico de Consultas");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setBounds(350, 20, 350, 54);
        panel.add(lblTitulo);

        JLabel lblBuscaCPF = new JLabel("Buscar por CPF:");
        lblBuscaCPF.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblBuscaCPF.setBounds(50, 85, 100, 20);
        panel.add(lblBuscaCPF);

        txtCPFBusca = new JTextField();
        txtCPFBusca.setBounds(140, 85, 200, 25);
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
        lblStatusBusca.setBounds(140, 110, 700, 20);
        panel.add(lblStatusBusca);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            voltarParaMenu();
        });
        btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnVoltar.setBounds(50, 550, 100, 30);
        panel.add(btnVoltar);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(e -> {
            carregarTodasConsultas();
        });
        btnAtualizar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnAtualizar.setBounds(850, 550, 100, 30);
        panel.add(btnAtualizar);

        criarTabelaConsultas();
        scrollPane = new JScrollPane(tabelaConsultas);
        scrollPane.setBounds(50, 140, 900, 390);
        panel.add(scrollPane);

        carregarTodasConsultas();
    }

    private void criarTabelaConsultas() {
        String[] colunas = {
            "ID", "Paciente", "CPF", "Médico", "Especialidade", 
            "Data", "Hora"
        };
        
        modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tabelaConsultas = new JTable(modeloTabela);
        tabelaConsultas.setRowHeight(25);
        tabelaConsultas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabelaConsultas.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        
        tabelaConsultas.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabelaConsultas.getColumnModel().getColumn(1).setPreferredWidth(180);
        tabelaConsultas.getColumnModel().getColumn(2).setPreferredWidth(120);
        tabelaConsultas.getColumnModel().getColumn(3).setPreferredWidth(180);
        tabelaConsultas.getColumnModel().getColumn(4).setPreferredWidth(120);
        tabelaConsultas.getColumnModel().getColumn(5).setPreferredWidth(100);
        tabelaConsultas.getColumnModel().getColumn(6).setPreferredWidth(80);
    }

    private void carregarTodasConsultas() {
        limparTabela();
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            
            
            String sql = "SELECT " +
                        "c.Id_Consulta, " +
                        "p.Nome AS paciente_nome, " +
                        "p.CPF AS paciente_cpf, " +
                        "u.Nome AS medico_nome, " +
                        "e.Nome_Especialidade AS especialidade, " +
                        "c.Data, " +          
                        "c.Hora " +           
                        "FROM consultas c " +
                        "INNER JOIN paciente p ON c.Id_Paciente = p.Id_Paciente " +
                        "INNER JOIN medico m ON c.Matricula_Med = m.Matricula " +
                        "INNER JOIN usuarios u ON m.Id_Usuario = u.Id_Usuario " +
                        "INNER JOIN especialidades e ON m.Especialidade = e.Id_Especialidade " +
                        "ORDER BY c.Data DESC, c.Hora DESC";
            
            System.out.println("Executando SQL: " + sql);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            int count = 0;
            while (rs.next()) {
                Object[] linha = new Object[7]; 
                linha[0] = rs.getInt("Id_Consulta");
                linha[1] = rs.getString("paciente_nome");
                linha[2] = formatarCPF(rs.getString("paciente_cpf"));
                linha[3] = rs.getString("medico_nome");
                linha[4] = rs.getString("especialidade");
                linha[5] = rs.getDate("Data");
                linha[6] = formatarHora(rs.getTime("Hora"));
                
                modeloTabela.addRow(linha);
                count++;
            }
            
            lblStatusBusca.setText("Mostrando " + count + " consulta(s)");
            lblStatusBusca.setForeground(Color.BLUE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar consultas: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            lblStatusBusca.setText("Erro ao carregar consultas");
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
        
        String cpfFormatado = formatarCPFNumeros(cpf);
        
        if (cpfFormatado.length() != 11) {
            JOptionPane.showMessageDialog(this,
                "CPF inválido! Deve conter 11 dígitos.\n" +
                "Exemplo: 123.456.789-01",
                "CPF Inválido",
                JOptionPane.WARNING_MESSAGE);
            txtCPFBusca.requestFocus();
            return;
        }
        
        if (cpfFormatado.matches("(\\d)\\1{10}")) {
            JOptionPane.showMessageDialog(this,
                "CPF inválido!",
                "CPF Inválido",
                JOptionPane.WARNING_MESSAGE);
            txtCPFBusca.requestFocus();
            return;
        }
        
        btnBuscarCPF.setEnabled(false);
        btnBuscarCPF.setText("Buscando...");
        
        buscarConsultasDoPaciente(cpfFormatado);
        
        btnBuscarCPF.setEnabled(true);
        btnBuscarCPF.setText("Buscar");
        
        txtCPFBusca.setText(formatarCPF(cpfFormatado));
    }

    private void buscarConsultasDoPaciente(String cpf) {
        limparTabela();
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            
            String nomePaciente = "";
            String sqlPaciente = "SELECT Nome FROM paciente WHERE CPF = ?";
            PreparedStatement psPaciente = con.prepareStatement(sqlPaciente);
            psPaciente.setString(1, cpf);
            ResultSet rsPaciente = psPaciente.executeQuery();
            
            if (rsPaciente.next()) {
                nomePaciente = rsPaciente.getString("Nome");
            }
            rsPaciente.close();
            psPaciente.close();
            
            if (nomePaciente.isEmpty()) {
                lblStatusBusca.setText("Paciente com CPF " + formatarCPF(cpf) + " não encontrado!");
                lblStatusBusca.setForeground(Color.RED);
                return;
            }
            
            
            String sql = "SELECT " +
                        "c.Id_Consulta, " +
                        "p.Nome AS paciente_nome, " +
                        "p.CPF AS paciente_cpf, " +
                        "u.Nome AS medico_nome, " +
                        "e.Nome_Especialidade AS especialidade, " +
                        "c.Data, " +          
                        "c.Hora " +          
                        "FROM consultas c " +
                        "INNER JOIN paciente p ON c.Id_Paciente = p.Id_Paciente " +
                        "INNER JOIN medico m ON c.Matricula_Med = m.Matricula " +
                        "INNER JOIN usuarios u ON m.Id_Usuario = u.Id_Usuario " +
                        "INNER JOIN especialidades e ON m.Especialidade = e.Id_Especialidade " +
                        "WHERE p.CPF = ? " +
                        "ORDER BY c.Data DESC, c.Hora DESC";
            
            ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            
            int count = 0;
            while (rs.next()) {
                Object[] linha = new Object[7]; 
                linha[0] = rs.getInt("Id_Consulta");
                linha[1] = rs.getString("paciente_nome");
                linha[2] = formatarCPF(rs.getString("paciente_cpf"));
                linha[3] = rs.getString("medico_nome");
                linha[4] = rs.getString("especialidade");
                linha[5] = rs.getDate("Data");
                linha[6] = formatarHora(rs.getTime("Hora"));
                
                modeloTabela.addRow(linha);
                count++;
            }
            
            if (count > 0) {
                lblStatusBusca.setText("Mostrando " + count + " consulta(s) para " + nomePaciente + " (" + formatarCPF(cpf) + ")");
                lblStatusBusca.setForeground(new Color(0, 100, 0));
            } else {
                lblStatusBusca.setText("Nenhuma consulta encontrada para " + nomePaciente + " (" + formatarCPF(cpf) + ")");
                lblStatusBusca.setForeground(Color.ORANGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao buscar consultas: " + e.getMessage(),
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

    private void limparBusca() {
        txtCPFBusca.setText("");
        lblStatusBusca.setText("");
        carregarTodasConsultas();
        txtCPFBusca.requestFocus();
    }

    private void limparTabela() {
        modeloTabela.setRowCount(0);
    }

    private String formatarCPF(String cpf) {
        if (cpf == null) return "";
        String cpfNumeros = cpf.replaceAll("[^0-9]", "");
        if (cpfNumeros.length() == 11) {
            return cpfNumeros.substring(0, 3) + "." + 
                   cpfNumeros.substring(3, 6) + "." + 
                   cpfNumeros.substring(6, 9) + "-" + 
                   cpfNumeros.substring(9, 11);
        }
        return cpf;
    }
    
    private String formatarCPFNumeros(String cpf) {
        return cpf.replaceAll("[^0-9]", "");
    }
    
    private String formatarHora(Time hora) {
        if (hora == null) return "";
        String horaStr = hora.toString();
        return horaStr.length() >= 5 ? horaStr.substring(0, 5) : horaStr;
    }

    private void voltarParaMenu() {
        dispose();
        
        try {
            Class<?> secretariaClass = Class.forName("telasSistema.Secretaria.TelaPrincipalSecretaria");
            JFrame tela = (JFrame) secretariaClass.getDeclaredConstructor().newInstance();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
        } catch (Exception e) {
            System.out.println("Não foi possível abrir a tela anterior: " + e.getMessage());
        }
    }

    private void testarConsultaSQL() {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            
            String sql = "SELECT Id_Consulta, Data, Hora FROM consultas LIMIT 5";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            System.out.println("=== TESTE DE CONSULTA ===");
            System.out.println("SQL: " + sql);
            
            int count = 0;
            while (rs.next()) {
                System.out.println("Consulta " + (++count) + ":");
                System.out.println("  ID: " + rs.getInt("Id_Consulta"));
                System.out.println("  Data: " + rs.getDate("Data"));
                System.out.println("  Hora: " + rs.getTime("Hora"));
            }
            
            if (count == 0) {
                System.out.println("Nenhuma consulta encontrada na tabela!");
            }
            
            System.out.println("========================");
            
            rs.close();
            ps.close();
            
        } catch (Exception e) {
            System.out.println("Erro no teste SQL: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TelaHistoricoAgendamentos tela = new TelaHistoricoAgendamentos();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        
        tela.testarConsultaSQL();
    }
}