package telasSistema.Secretaria;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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

    public TelaHistoricoAgendamentos() {

        setBounds(100, 100, 742, 454);
        getContentPane().setBackground(new Color(170, 255, 255));
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 253, 255));
        panel.setBounds(0, 1, 729, 417);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Histórico de Consultas");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setBounds(215, 31, 350, 54);
        panel.add(lblTitulo);

        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(e -> {
            TelaPrincipalSecretaria tela = new TelaPrincipalSecretaria();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
            dispose();
        });
        btnConfirmar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnConfirmar.setBounds(533, 349, 95, 20);
        panel.add(btnConfirmar);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> {
            TelaPrincipalSecretaria tela = new TelaPrincipalSecretaria();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
            dispose();
        });
        btnVoltar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnVoltar.setBounds(98, 349, 84, 20);
        panel.add(btnVoltar);

        // Painel 1
        JPanel panel1 = new JPanel();
        panel1.setBounds(81, 130, 572, 54);
        panel.add(panel1);
        panel1.setLayout(null);

        lblConsulta1 = new JLabel();
        lblConsulta1.setBounds(10, 10, 550, 34);
        lblConsulta1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panel1.add(lblConsulta1);

        // Painel 2
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(81, 200, 572, 54);
        panel.add(panel2);

        lblConsulta2 = new JLabel();
        lblConsulta2.setBounds(10, 10, 550, 34);
        lblConsulta2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panel2.add(lblConsulta2);

        // Painel 3
        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(81, 270, 572, 54);
        panel.add(panel3);

        lblConsulta3 = new JLabel();
        lblConsulta3.setBounds(10, 10, 550, 34);
        lblConsulta3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panel3.add(lblConsulta3);

        carregarHistorico();
    }

    private void carregarHistorico() {

        lblConsulta1.setText("");
        lblConsulta2.setText("");
        lblConsulta3.setText("");

        String sql =
            "SELECT " +
            "p.Nome AS paciente, " +
            "u.Nome AS medico, " +
            "e.Nome_Especialidade AS especialidade, " +
            "c.Data, " +
            "c.Hora " +
            "FROM consultas c " +
            "JOIN paciente p ON c.Id_Paciente = p.Id_Paciente " +
            "JOIN medico m ON c.Matricula_Med = m.Matricula " +
            "JOIN usuarios u ON m.Id_Usuario = u.Id_Usuario " +
            "JOIN especialidades e ON m.Especialidade = e.Id_Especialidade " +
            "ORDER BY c.Data DESC, c.Hora DESC " +
            "LIMIT 3";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            JLabel[] labels = { lblConsulta1, lblConsulta2, lblConsulta3 };

            int i = 0;
            while (rs.next() && i < labels.length) {

                labels[i].setText(
                    "Paciente: " + rs.getString("paciente") +
                    " | Especialidade: " + rs.getString("especialidade") +
                    " | Médico: " + rs.getString("medico") +
                    " | Data: " + rs.getDate("Data") +
                    " | Hora: " + rs.getTime("Hora")
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
                    "Erro ao carregar histórico de consultas.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}

