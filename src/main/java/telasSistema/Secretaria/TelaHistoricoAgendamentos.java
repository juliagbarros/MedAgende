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
    private JLabel lblConfirmacao;
    private JLabel lblClinicaOlindaEspecialidade;
    private JLabel lblClinicaRecifeEspecialidade;

    private String cpfPaciente;

    public TelaHistoricoAgendamentos(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;

        setBounds(100, 100, 742, 454);
        getContentPane().setBackground(new Color(170, 255, 255));
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 253, 255));
        panel.setBounds(0, 1, 729, 417);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Histórico de Consultas do paciente");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setBounds(127, 31, 441, 54);
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

      
        JPanel panel1 = new JPanel();
        panel1.setBounds(81, 142, 572, 54);
        panel.add(panel1);
        panel1.setLayout(null);

        lblConfirmacao = new JLabel();
        lblConfirmacao.setBounds(0, 10, 575, 40);
        lblConfirmacao.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        panel1.add(lblConfirmacao);

       
        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(81, 220, 572, 54);
        panel.add(panel2);

        lblClinicaOlindaEspecialidade = new JLabel();
        lblClinicaOlindaEspecialidade.setBounds(0, 10, 575, 40);
        lblClinicaOlindaEspecialidade.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        panel2.add(lblClinicaOlindaEspecialidade);

      
        JPanel panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBounds(81, 285, 572, 54);
        panel.add(panel3);

        lblClinicaRecifeEspecialidade = new JLabel();
        lblClinicaRecifeEspecialidade.setBounds(0, 10, 575, 40);
        lblClinicaRecifeEspecialidade.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        panel3.add(lblClinicaRecifeEspecialidade);

        carregarHistorico();
    }

    private void carregarHistorico() {

        // Validação do CPF
        if (cpfPaciente == null || cpfPaciente.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "CPF do paciente não informado.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Limpa os labels antes de carregar
        lblConfirmacao.setText("");
        lblClinicaOlindaEspecialidade.setText("");
        lblClinicaRecifeEspecialidade.setText("");

        String sql = """
            SELECT c.nome_clinica,
                   e.nome AS especialidade,
                   m.nome AS medico,
                   a.data_consulta,
                   a.horario,
                   a.status
            FROM agendamento a
            JOIN paciente p ON a.id_paciente = p.id
            JOIN medico m ON a.id_medico = m.id
            JOIN especialidade e ON m.id_especialidade = e.id
            JOIN clinica c ON m.id_clinica = c.id
            WHERE p.cpf = ?
            ORDER BY a.data_consulta DESC, a.horario DESC
            LIMIT 3
        """;

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cpfPaciente);
            ResultSet rs = ps.executeQuery();

            JLabel[] labels = {
                lblConfirmacao,
                lblClinicaOlindaEspecialidade,
                lblClinicaRecifeEspecialidade
            };

            int i = 0;
            while (rs.next() && i < labels.length) {

                labels[i].setText(
                    " Clínica " + rs.getString("nome_clinica") +
                    ", especialidade " + rs.getString("especialidade") +
                    ", com o(a) médico(a) " + rs.getString("medico") +
                    " no dia " + rs.getDate("data_consulta") +
                    " às " + rs.getTime("horario")
                );

                String status = rs.getString("status");
                if ("REALIZADA".equalsIgnoreCase(status)) {
                    labels[i].setForeground(new Color(0, 128, 0));
                } else if ("CANCELADA".equalsIgnoreCase(status)) {
                    labels[i].setForeground(Color.RED);
                } else {
                    labels[i].setForeground(Color.BLACK);
                }

                i++;
            }

            if (i == 0) {
                lblConfirmacao.setText("Nenhuma consulta encontrada para este paciente.");
                lblConfirmacao.setForeground(Color.GRAY);
            }

            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar histórico de consultas.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
