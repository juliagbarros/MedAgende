package telasSistema.Secretaria;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import conexao.ConnectionFactory;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class TelaSecretariaCancelar extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField FieldCpf;
    private JTextField FieldNomePaciente;
    private JLabel lblNomeEncontrado;
    private JButton btnBuscar;
    private JTable tableConsultas;
    private DefaultTableModel tableModel;
    private JButton btnCancelarConsulta;
    private int pacienteId = -1;

    public TelaSecretariaCancelar() {
        initialize();
    }

    private void initialize() {
        setBounds(100, 100, 900, 600);
        getContentPane().setBackground(new Color(170, 255, 255));
        getContentPane().setLayout(null);
        setTitle("Cancelamento de Consulta - Sistema Clínica");
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 253, 255));
        panel.setBounds(0, 1, 886, 562);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        setupTitle(panel);
        setupFormFields(panel);
        setupConsultasTable(panel);
        setupButtons(panel);
    }
    
    private void setupTitle(JPanel panel) {
        JLabel lblCancelarConsulta = new JLabel("Cancelar Consulta");
        lblCancelarConsulta.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblCancelarConsulta.setBounds(300, 30, 280, 50);
        lblCancelarConsulta.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblCancelarConsulta);
        
        JLabel lblPreenchaDados = new JLabel("Busque o paciente para ver e cancelar consultas agendadas");
        lblPreenchaDados.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblPreenchaDados.setBounds(250, 80, 400, 20);
        lblPreenchaDados.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblPreenchaDados);
    }
    
    private void setupFormFields(JPanel panel) {
        // CPF Label and Field
        JLabel lblCpfPaciente = new JLabel("CPF do paciente:");
        lblCpfPaciente.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblCpfPaciente.setBounds(108, 140, 120, 20);
        panel.add(lblCpfPaciente);
        
        FieldCpf = new JTextField();
        FieldCpf.setBounds(238, 140, 280, 25);
        FieldCpf.setColumns(10);
        FieldCpf.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!FieldCpf.getText().trim().isEmpty()) {
                    buscarPacientePorCPF();
                }
            }
        });
        panel.add(FieldCpf);
        
        // Nome Label
        JLabel lblNomePaciente = new JLabel("Nome do paciente:");
        lblNomePaciente.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblNomePaciente.setBounds(108, 180, 120, 20);
        panel.add(lblNomePaciente);
        
        FieldNomePaciente = new JTextField();
        FieldNomePaciente.setEditable(false);
        FieldNomePaciente.setBounds(238, 180, 280, 25);
        FieldNomePaciente.setColumns(10);
        FieldNomePaciente.setBackground(new Color(240, 240, 240));
        panel.add(FieldNomePaciente);
        
        // Label para mostrar resultado da busca
        lblNomeEncontrado = new JLabel("");
        lblNomeEncontrado.setFont(new Font("Segoe UI", Font.ITALIC, 11));
        lblNomeEncontrado.setForeground(Color.BLUE);
        lblNomeEncontrado.setBounds(238, 210, 280, 20);
        panel.add(lblNomeEncontrado);
        
        // Botão para buscar manualmente
        btnBuscar = new JButton("Buscar");
        btnBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnBuscar.setBounds(530, 140, 80, 25);
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarPacientePorCPF();
            }
        });
        panel.add(btnBuscar);
        
        // Botão de limpar
        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnLimpar.setBounds(530, 180, 80, 25);
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        panel.add(btnLimpar);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(108, 240, 670, 2);
        panel.add(separator);
    }
    
    private void setupConsultasTable(JPanel panel) {
        JLabel lblConsultasAgendadas = new JLabel("Consultas Agendadas para Cancelamento:");
        lblConsultasAgendadas.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblConsultasAgendadas.setBounds(108, 250, 300, 25);
        panel.add(lblConsultasAgendadas);
        
        // Modelo da tabela - SEM CIDADE E SITUAÇÃO (pois não existem na tabela)
        String[] colunas = {"ID", "Data", "Hora", "Médico", "Especialidade"};
        tableModel = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tableConsultas = new JTable(tableModel);
        tableConsultas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableConsultas.getTableHeader().setReorderingAllowed(false);
        tableConsultas.setRowHeight(25);
        tableConsultas.getColumnModel().getColumn(0).setPreferredWidth(50);
        tableConsultas.getColumnModel().getColumn(1).setPreferredWidth(100);
        tableConsultas.getColumnModel().getColumn(2).setPreferredWidth(80);
        tableConsultas.getColumnModel().getColumn(3).setPreferredWidth(180);
        tableConsultas.getColumnModel().getColumn(4).setPreferredWidth(150);
        
        JScrollPane scrollPane = new JScrollPane(tableConsultas);
        scrollPane.setBounds(108, 280, 670, 200);
        panel.add(scrollPane);
    }
    
    private void setupButtons(JPanel panel) {
        JSeparator separator = new JSeparator();
        separator.setBounds(108, 490, 670, 2);
        panel.add(separator);
        
        // Botão Cancelar Consulta (funcional)
        btnCancelarConsulta = new JButton("Cancelar Consulta Selecionada");
        btnCancelarConsulta.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnCancelarConsulta.setBackground(Color.RED);
        btnCancelarConsulta.setForeground(Color.WHITE);
        btnCancelarConsulta.setBounds(108, 500, 220, 30);
        btnCancelarConsulta.setEnabled(false);
        btnCancelarConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelarConsultaSelecionada();
            }
        });
        panel.add(btnCancelarConsulta);
        
        // Botão Atualizar Lista
        JButton btnAtualizar = new JButton("Atualizar Lista");
        btnAtualizar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnAtualizar.setBounds(340, 500, 120, 30);
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pacienteId != -1) {
                    carregarConsultasPaciente(pacienteId);
                }
            }
        });
        panel.add(btnAtualizar);
        
        // Botão Voltar
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnVoltar.setBounds(580, 500, 100, 30);
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarParaTelaPrincipal();
            }
        });
        panel.add(btnVoltar);
    }
    
    private void buscarPacientePorCPF() {
        String cpf = FieldCpf.getText().trim();
        
        if (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, digite um CPF para buscar.",
                "CPF Vazio",
                JOptionPane.WARNING_MESSAGE);
            FieldCpf.requestFocus();
            return;
        }
        
        // Formatar CPF (remover caracteres não numéricos)
        cpf = cpf.replaceAll("[^0-9]", "");
        
        // Validar formato do CPF
        if (cpf.length() != 11) {
            FieldNomePaciente.setText("");
            lblNomeEncontrado.setText("CPF inválido (deve ter 11 dígitos)");
            lblNomeEncontrado.setForeground(Color.RED);
            limparTabelaConsultas();
            return;
        }
        
        // Desabilitar botão durante a busca
        btnBuscar.setEnabled(false);
        btnBuscar.setText("Buscando...");
        
        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conexao = ConnectionFactory.getConnection();
            if (conexao == null) {
                JOptionPane.showMessageDialog(this,
                    "Erro ao conectar ao banco de dados.",
                    "Erro de Conexão",
                    JOptionPane.ERROR_MESSAGE);
                btnBuscar.setEnabled(true);
                btnBuscar.setText("Buscar");
                return;
            }
            
            String sql = "SELECT Id_Paciente, Nome FROM paciente WHERE CPF = ?";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                pacienteId = rs.getInt("Id_Paciente");
                String nomePaciente = rs.getString("Nome");
                
                FieldNomePaciente.setText(nomePaciente);
                FieldCpf.setText(formatarCPF(cpf));
                
                carregarConsultasPaciente(pacienteId);
                
                lblNomeEncontrado.setText("Paciente encontrado - ID: " + pacienteId);
                lblNomeEncontrado.setForeground(new Color(0, 150, 0));
                
            } else {
                pacienteId = -1;
                FieldNomePaciente.setText("");
                limparTabelaConsultas();
                lblNomeEncontrado.setText("Paciente não encontrado");
                lblNomeEncontrado.setForeground(Color.RED);
                
                int opcao = JOptionPane.showConfirmDialog(this,
                    "CPF não encontrado no sistema!\n\n" +
                    "Deseja cadastrar este paciente?",
                    "Paciente Não Encontrado",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
                
                if (opcao == JOptionPane.YES_OPTION) {
                    abrirTelaCadastroPaciente(cpf);
                }
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao buscar paciente: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            btnBuscar.setEnabled(true);
            btnBuscar.setText("Buscar");
            
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void carregarConsultasPaciente(int idPaciente) {
        limparTabelaConsultas();
        btnCancelarConsulta.setEnabled(false);
        
        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conexao = ConnectionFactory.getConnection();
            if (conexao == null) return;
            
            // CONSULTA CORRIGIDA para o seu banco de dados
            String sql = "SELECT " +
                        "c.Id_Consulta, " +           // Nome correto da coluna
                        "c.Data AS data_consulta, " +  // Nome correto: Data (não Data_Consulta)
                        "c.Hora AS hora_consulta, " +  // Nome correto: Hora (não Horario_Consulta)
                        "u.Nome AS medico_nome, " +
                        "e.Nome_Especialidade AS especialidade " +
                        "FROM consultas c " +
                        "INNER JOIN medico m ON c.Matricula_Med = m.Matricula " +  // Matricula_Med (não Fk_Matricula_Medico)
                        "INNER JOIN usuarios u ON m.Id_Usuario = u.Id_Usuario " +
                        "INNER JOIN especialidades e ON m.Especialidade = e.Id_Especialidade " +
                        "WHERE c.Id_Paciente = ? " +  // Id_Paciente (não Fk_Id_Paciente)
                        "AND c.Data >= CURDATE() " +  // Mostrar apenas consultas futuras ou de hoje
                        "ORDER BY c.Data ASC, c.Hora ASC";
            
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            rs = ps.executeQuery();
            
            int count = 0;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            
            while (rs.next()) {
                Object[] row = new Object[5]; // 5 colunas agora (sem situação)
                row[0] = rs.getInt("Id_Consulta");
                
                // Formatar data
                Date data = rs.getDate("data_consulta");
                if (data != null) {
                    row[1] = dateFormat.format(data);
                } else {
                    row[1] = "N/A";
                }
                
                // Formatar hora
                java.sql.Time hora = rs.getTime("hora_consulta");
                if (hora != null) {
                    row[2] = timeFormat.format(hora);
                } else {
                    row[2] = "N/A";
                }
                
                row[3] = rs.getString("medico_nome");
                row[4] = rs.getString("especialidade");
                
                tableModel.addRow(row);
                count++;
            }
            
            if (count > 0) {
                lblNomeEncontrado.setText("Paciente encontrado - " + count + " consulta(s) futura(s)");
                btnCancelarConsulta.setEnabled(true);
            } else {
                lblNomeEncontrado.setText("Paciente encontrado - Nenhuma consulta futura agendada");
                lblNomeEncontrado.setForeground(Color.ORANGE);
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao carregar consultas: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                "Erro ao carregar consultas: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void cancelarConsultaSelecionada() {
        int selectedRow = tableConsultas.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                "Por favor, selecione uma consulta na tabela para cancelar.",
                "Nenhuma Consulta Selecionada",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int consultaId = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
        String data = tableModel.getValueAt(selectedRow, 1).toString();
        String hora = tableModel.getValueAt(selectedRow, 2).toString();
        String medico = tableModel.getValueAt(selectedRow, 3).toString();
        
        int confirm = JOptionPane.showConfirmDialog(this,
            "Deseja realmente cancelar esta consulta?\n\n" +
            "Data: " + data + "\n" +
            "Hora: " + hora + "\n" +
            "Médico: " + medico + "\n\n" +
            "Esta ação não pode ser desfeita!",
            "Confirmar Cancelamento",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE);
        
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        Connection conexao = null;
        PreparedStatement ps = null;
        
        try {
            conexao = ConnectionFactory.getConnection();
            
            // COMO NÃO TEMOS COLUNA SITUAÇÃO, VAMOS EXCLUIR A CONSULTA OU ADICIONAR UMA COLUNA
            // Opção 1: Excluir a consulta
            String sql = "DELETE FROM consultas WHERE Id_Consulta = ?";
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, consultaId);
            
            int rowsAffected = ps.executeUpdate();
            
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this,
                    "Consulta cancelada com sucesso!\n" +
                    "ID da consulta: " + consultaId,
                    "Cancelamento Realizado",
                    JOptionPane.INFORMATION_MESSAGE);
                
                // Remover a linha da tabela
                tableModel.removeRow(selectedRow);
                
                // Desabilitar o botão se não houver mais consultas
                if (tableModel.getRowCount() == 0) {
                    btnCancelarConsulta.setEnabled(false);
                    lblNomeEncontrado.setText("Paciente encontrado - Nenhuma consulta futura agendada");
                    lblNomeEncontrado.setForeground(Color.ORANGE);
                }
                
            } else {
                JOptionPane.showMessageDialog(this,
                    "Erro ao cancelar consulta. Consulte o administrador.",
                    "Erro no Cancelamento",
                    JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao cancelar consulta: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void abrirTelaCadastroPaciente(String cpf) {
        try {
            dispose();
            
       
            
            JOptionPane.showMessageDialog(this,
                "Funcionalidade de cadastro de paciente será implementada.\n" +
                "CPF para cadastro: " + formatarCPF(cpf),
                "Cadastro de Paciente",
                JOptionPane.INFORMATION_MESSAGE);
            
            voltarParaTelaPrincipal();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
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
    
    private void limparCampos() {
        FieldCpf.setText("");
        FieldNomePaciente.setText("");
        lblNomeEncontrado.setText("");
        limparTabelaConsultas();
        pacienteId = -1;
        btnCancelarConsulta.setEnabled(false);
        FieldCpf.requestFocus();
    }
    
    private void limparTabelaConsultas() {
        tableModel.setRowCount(0);
    }
    
    private void voltarParaTelaPrincipal() {
        try {
            Class<?> secretariaClass = Class.forName("telasSistema.Secretaria.TelaPrincipalSecretaria");
            JFrame tela = (JFrame) secretariaClass.getDeclaredConstructor().newInstance();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
            dispose();
        } catch (Exception e) {
            System.out.println("Não foi possível abrir a tela anterior: " + e.getMessage());
            dispose(); 
        }
    }
    
    private void verificarEstruturaConsulta() {
        Connection con = null;
        try {
            con = ConnectionFactory.getConnection();
            String sql = "SHOW COLUMNS FROM consultas";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            System.out.println("=== ESTRUTURA DA TABELA CONSULTAS ===");
            while (rs.next()) {
                System.out.println(rs.getString("Field") + " - " + rs.getString("Type"));
            }
            System.out.println("====================================");
            
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
    
    // Método main para teste
    public static void main(String[] args) {
        TelaSecretariaCancelar tela = new TelaSecretariaCancelar();
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        
        // Para debug - verificar estrutura da tabela
        tela.verificarEstruturaConsulta();
    }
}