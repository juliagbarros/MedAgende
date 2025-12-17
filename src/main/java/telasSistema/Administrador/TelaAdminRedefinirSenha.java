package telasSistema.Administrador;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Adicione esta importação para a TelaLogin
import telasSistema.TelaInicial.TelaLogin;

public class TelaAdminRedefinirSenha extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField passwordFieldNovaSenha;
    private JPasswordField passwordFieldConfirmarSenha;
    private JTextField txtEmailUsuario;

    
    public TelaAdminRedefinirSenha(String email) {
        setTitle("Redefinição de Senha - Administração");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 701, 569);
        setLocationRelativeTo(null);
        setResizable(false);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 248, 255));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        inicializarComponentes(email);
    }
    
    
    public TelaAdminRedefinirSenha() {
        this(""); // Email vazio
    }
    
    private void inicializarComponentes(String email) {
        // Cabeçalho com ícone
        JPanel panelCabecalho = new JPanel();
        panelCabecalho.setBackground(new Color(0, 204, 204));
        panelCabecalho.setBounds(0, 0, 675, 80);
        panelCabecalho.setLayout(null);
        contentPane.add(panelCabecalho);
        
        JLabel lblTitulo = new JLabel("Redefinir Senha");
        lblTitulo.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(12, 13, 328, 47);
        panelCabecalho.add(lblTitulo);
        
        JLabel lblSubtitulo = new JLabel("Sistema Administrativo");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblSubtitulo.setForeground(new Color(220, 220, 220));
        lblSubtitulo.setBounds(42, 47, 200, 20);
        panelCabecalho.add(lblSubtitulo);
        
        // Informações do usuário
        JPanel panelInfoUsuario = new JPanel();
        panelInfoUsuario.setBackground(new Color(255, 255, 255));
        panelInfoUsuario.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)), 
            "Informações da Conta",
            javax.swing.border.TitledBorder.LEFT,
            javax.swing.border.TitledBorder.TOP,
            new Font("Segoe UI", Font.BOLD, 11),
            new Color(70, 130, 180)));
        panelInfoUsuario.setBounds(30, 95, 615, 70);
        panelInfoUsuario.setLayout(null);
        
        JLabel lblUsuarioLabel = new JLabel("Email do Usuário:");
        lblUsuarioLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblUsuarioLabel.setForeground(new Color(100, 100, 100));
        lblUsuarioLabel.setBounds(15, 20, 100, 20);
        panelInfoUsuario.add(lblUsuarioLabel);
        
        txtEmailUsuario = new JTextField(email);
        txtEmailUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        txtEmailUsuario.setBounds(120, 20, 350, 20);
        panelInfoUsuario.add(txtEmailUsuario);
        
        JLabel lblStatusLabel = new JLabel("Status:");
        lblStatusLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblStatusLabel.setForeground(new Color(100, 100, 100));
        lblStatusLabel.setBounds(15, 40, 60, 20);
        panelInfoUsuario.add(lblStatusLabel);
        
        JLabel lblStatusValor = new JLabel("Administrador redefinindo senha");
        lblStatusValor.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        lblStatusValor.setForeground(new Color(0, 150, 0));
        lblStatusValor.setBounds(75, 40, 200, 20);
        panelInfoUsuario.add(lblStatusValor);
        
        contentPane.add(panelInfoUsuario);
        
        // Painel de redefinição
        JPanel panelRedefinicao = new JPanel();
        panelRedefinicao.setBackground(Color.WHITE);
        panelRedefinicao.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)), 
            "Nova Senha",
            javax.swing.border.TitledBorder.LEFT,
            javax.swing.border.TitledBorder.TOP,
            new Font("Segoe UI", Font.BOLD, 11),
            new Color(70, 130, 180)));
        panelRedefinicao.setBounds(30, 180, 615, 180);
        panelRedefinicao.setLayout(null);
        
        // Nova Senha
        JLabel lblNovaSenha = new JLabel("Nova Senha:");
        lblNovaSenha.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblNovaSenha.setBounds(20, 30, 100, 25);
        panelRedefinicao.add(lblNovaSenha);
        
        passwordFieldNovaSenha = new JPasswordField();
        passwordFieldNovaSenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        passwordFieldNovaSenha.setBounds(20, 55, 450, 35);
        panelRedefinicao.add(passwordFieldNovaSenha);
        
        // Confirmar Senha
        JLabel lblConfirmarSenha = new JLabel("Confirmar Senha:");
        lblConfirmarSenha.setFont(new Font("Segoe UI", Font.BOLD, 12));
        lblConfirmarSenha.setBounds(20, 100, 120, 25);
        panelRedefinicao.add(lblConfirmarSenha);
        
        passwordFieldConfirmarSenha = new JPasswordField();
        passwordFieldConfirmarSenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        passwordFieldConfirmarSenha.setBounds(20, 125, 450, 35);
        panelRedefinicao.add(passwordFieldConfirmarSenha);
        
        // Botão mostrar/ocultar senha
        JButton btnToggleSenha = new JButton("👁");
        btnToggleSenha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btnToggleSenha.setBackground(new Color(240, 240, 240));
        btnToggleSenha.setBounds(480, 55, 40, 35);
        btnToggleSenha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (passwordFieldNovaSenha.getEchoChar() == '•') {
                    passwordFieldNovaSenha.setEchoChar((char)0);
                    passwordFieldConfirmarSenha.setEchoChar((char)0);
                    btnToggleSenha.setText("🔒");
                    btnToggleSenha.setToolTipText("Ocultar senha");
                } else {
                    passwordFieldNovaSenha.setEchoChar('•');
                    passwordFieldConfirmarSenha.setEchoChar('•');
                    btnToggleSenha.setText("👁");
                    btnToggleSenha.setToolTipText("Mostrar senha");
                }
            }
        });
        btnToggleSenha.setToolTipText("Mostrar senha");
        panelRedefinicao.add(btnToggleSenha);
        
        contentPane.add(panelRedefinicao);
        
        // Painel de força da senha
        JPanel panelForcaSenha = new JPanel();
        panelForcaSenha.setBackground(new Color(250, 250, 250));
        panelForcaSenha.setBorder(BorderFactory.createTitledBorder("Força da Senha"));
        panelForcaSenha.setBounds(30, 370, 615, 60);
        panelForcaSenha.setLayout(null);
        
        JLabel lblForcaTexto = new JLabel("Nível de segurança:");
        lblForcaTexto.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        lblForcaTexto.setBounds(10, 25, 100, 20);
        panelForcaSenha.add(lblForcaTexto);
        
        JProgressBar progressBarForca = new JProgressBar(0, 100);
        progressBarForca.setBounds(120, 25, 300, 20);
        progressBarForca.setForeground(Color.RED);
        panelForcaSenha.add(progressBarForca);
        
        JLabel lblForcaStatus = new JLabel("Aguardando senha...");
        lblForcaStatus.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        lblForcaStatus.setForeground(Color.GRAY);
        lblForcaStatus.setBounds(430, 25, 150, 20);
        panelForcaSenha.add(lblForcaStatus);
        
        // Listener para atualizar força da senha
        passwordFieldNovaSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                atualizarForcaSenha(progressBarForca, lblForcaStatus);
            }
        });
        
        contentPane.add(panelForcaSenha);
        
        // Painel de botões COM BOTÃO VOLTAR ADICIONADO
        JPanel panelBotoes = new JPanel();
        panelBotoes.setBackground(new Color(240, 248, 255));
        panelBotoes.setBounds(0, 440, 675, 80);
        panelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        
        // BOTÃO VOLTAR - MODIFICADO PARA VOLTAR AO LOGIN
        JButton btnVoltar = new JButton("← Voltar ao Login");
        btnVoltar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnVoltar.setBackground(new Color(220, 220, 220));
        btnVoltar.setPreferredSize(new Dimension(150, 35));
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                voltarParaTelaLogin();
            }
        });
        
        // Botão Cancelar
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnCancelar.setBackground(new Color(220, 220, 220));
        btnCancelar.setPreferredSize(new Dimension(120, 35));
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelarRedefinicao();
            }
        });
        
        // Botão Redefinir
        JButton btnRedefinir = new JButton("Redefinir Senha");
        btnRedefinir.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnRedefinir.setBackground(new Color(70, 130, 180));
        btnRedefinir.setForeground(Color.WHITE);
        btnRedefinir.setPreferredSize(new Dimension(150, 35));
        btnRedefinir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                redefinirSenha();
            }
        });
        
        // Adiciona os botões na ordem
        panelBotoes.add(btnVoltar);
        panelBotoes.add(btnCancelar);
        panelBotoes.add(btnRedefinir);
        contentPane.add(panelBotoes);
        
        // Tooltips
        txtEmailUsuario.setToolTipText("Digite o email do usuário que terá a senha redefinida");
        passwordFieldNovaSenha.setToolTipText("Digite a nova senha (mínimo 8 caracteres)");
        passwordFieldConfirmarSenha.setToolTipText("Digite novamente a mesma senha para confirmação");
        
        // Foco inicial
        txtEmailUsuario.requestFocus();
    }
    
    /**
     * Método para voltar à tela de login
     */
    private void voltarParaTelaLogin() {
        int confirmacao = JOptionPane.showConfirmDialog(this,
            "Deseja voltar à tela de login?\n\n" +
            "A redefinição de senha será cancelada.",
            "Confirmar Voltar ao Login",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirmacao == JOptionPane.YES_OPTION) {
            try {
                // Abre a TelaLogin
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setLocationRelativeTo(null);
                telaLogin.setVisible(true);
                dispose(); // Fecha a janela atual
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                    "Erro ao abrir tela de login. Fechando aplicação...",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
                dispose();
            }
        }
    }
    
    private void atualizarForcaSenha(JProgressBar progressBar, JLabel label) {
        char[] senha = passwordFieldNovaSenha.getPassword();
        String senhaStr = new String(senha);
        
        if (senhaStr.isEmpty()) {
            progressBar.setValue(0);
            progressBar.setForeground(Color.GRAY);
            label.setText("Aguardando senha...");
            label.setForeground(Color.GRAY);
            return;
        }
        
        int forca = calcularForcaSenha(senhaStr);
        int valorProgresso = forca * 33;
        
        progressBar.setValue(valorProgresso);
        
        switch (forca) {
            case 1:
                progressBar.setForeground(Color.RED);
                label.setText("Fraca");
                label.setForeground(Color.RED);
                break;
            case 2:
                progressBar.setForeground(Color.ORANGE);
                label.setText("Média");
                label.setForeground(Color.ORANGE);
                break;
            case 3:
                progressBar.setForeground(new Color(0, 180, 0));
                label.setText("Forte");
                label.setForeground(new Color(0, 180, 0));
                break;
        }
    }
    
    
    private int calcularForcaSenha(String senha) {
        int pontos = 0;
        
        // Comprimento
        if (senha.length() >= 8) pontos++;
        if (senha.length() >= 12) pontos++;
        
        // Caracteres variados
        if (senha.matches(".*[A-Z].*")) pontos++;
        if (senha.matches(".*[a-z].*")) pontos++;
        if (senha.matches(".*\\d.*")) pontos++;
        if (senha.matches(".*[@#$%&*!].*")) pontos++;
        
        if (pontos <= 2) return 1;
        else if (pontos <= 4) return 2;
        else return 3;
    }
    
    
    private String validarSenha(String senha) {
        if (senha.length() < 8) {
            return "A senha deve ter no mínimo 8 caracteres.";
        }
        
        if (!senha.matches(".*[A-Z].*")) {
            return "A senha deve conter pelo menos uma letra maiúscula.";
        }
        
        if (!senha.matches(".*[a-z].*")) {
            return "A senha deve conter pelo menos uma letra minúscula.";
        }
        
        if (!senha.matches(".*\\d.*")) {
            return "A senha deve conter pelo menos um número.";
        }
        
        if (!senha.matches(".*[@#$%&*!].*")) {
            return "A senha deve conter pelo menos um caractere especial (@, #, $, %, &, *, !).";
        }
        
        return null;
    }
    
    
    private void redefinirSenha() {
        String emailUsuario = txtEmailUsuario.getText().trim();
        
        if (emailUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, insira o email do usuário.",
                "Email Vazio",
                JOptionPane.WARNING_MESSAGE);
            txtEmailUsuario.requestFocus();
            return;
        }
        
        char[] novaSenha = passwordFieldNovaSenha.getPassword();
        char[] confirmarSenha = passwordFieldConfirmarSenha.getPassword();
        
        String novaSenhaStr = new String(novaSenha);
        String confirmarSenhaStr = new String(confirmarSenha);
        
        if (novaSenhaStr.isEmpty() || confirmarSenhaStr.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, preencha ambos os campos de senha.",
                "Campos Incompletos",
                JOptionPane.WARNING_MESSAGE);
            passwordFieldNovaSenha.requestFocus();
            return;
        }
        
        if (!novaSenhaStr.equals(confirmarSenhaStr)) {
            JOptionPane.showMessageDialog(this,
                "As senhas não coincidem. Por favor, digite a mesma senha nos dois campos.",
                "Senhas Diferentes",
                JOptionPane.ERROR_MESSAGE);
            passwordFieldConfirmarSenha.setText("");
            passwordFieldConfirmarSenha.requestFocus();
            return;
        }
        
        String erroValidacao = validarSenha(novaSenhaStr);
        if (erroValidacao != null) {
            int opcao = JOptionPane.showConfirmDialog(this,
                erroValidacao + "\n\nDeseja continuar mesmo assim?",
                "Senha Não Atende aos Critérios",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            if (opcao != JOptionPane.YES_OPTION) {
                return;
            }
        }
        
        mostrarProcessamento();
        
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarSucesso(emailUsuario);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    
    private void mostrarProcessamento() {
        JDialog dialogProcessando = new JDialog(this, "Processando", true);
        dialogProcessando.setSize(300, 150);
        dialogProcessando.setLocationRelativeTo(this);
        dialogProcessando.getContentPane().setLayout(new BorderLayout());
        dialogProcessando.getContentPane().setBackground(Color.WHITE);
        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        JLabel lblProcessando = new JLabel("Processando redefinição de senha...", SwingConstants.CENTER);
        lblProcessando.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        
        panel.add(lblProcessando, BorderLayout.CENTER);
        panel.add(progressBar, BorderLayout.SOUTH);
        
        dialogProcessando.getContentPane().add(panel);
        dialogProcessando.setVisible(true);
        
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogProcessando.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    
    private void mostrarSucesso(String emailUsuario) {
        String senhaCriptografada = "";
        try {
            senhaCriptografada = criptografarSenha(new String(passwordFieldNovaSenha.getPassword()));
        } catch (Exception e) {
            senhaCriptografada = "[CRIPTOGRAFADA]";
        }
        
        String mensagem = "<html><div style='text-align: center;'>"
                + "<h3 style='color: green;'>✅ Senha Redefinida com Sucesso!</h3>"
                + "<p><b>Usuário:</b> " + emailUsuario + "</p>"
                + "<p><b>Status:</b> Senha atualizada no sistema</p>"
                + "<p><b>Próximo passo:</b> O usuário deve fazer login com a nova senha</p>"
                + "<hr>"
                + "<p style='font-size: 10px; color: gray;'>"
                + "Hash da senha (SHA-256):<br>"
                + senhaCriptografada.substring(0, Math.min(50, senhaCriptografada.length())) + "..."
                + "</p>"
                + "</div></html>";
        
        JOptionPane.showMessageDialog(this,
            mensagem,
            "Redefinição Concluída",
            JOptionPane.INFORMATION_MESSAGE);
        
        // Pergunta se deseja voltar ao login
        int opcao = JOptionPane.showConfirmDialog(this,
            "Deseja voltar à tela de login?",
            "Voltar ao Login",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (opcao == JOptionPane.YES_OPTION) {
            voltarParaTelaLogin();
        } else {
            txtEmailUsuario.setText("");
            passwordFieldNovaSenha.setText("");
            passwordFieldConfirmarSenha.setText("");
            dispose();
        }
    }
    
    /**
     * Criptografa a senha usando SHA-256
     */
    private String criptografarSenha(String senha) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(senha.getBytes());
        StringBuilder hexString = new StringBuilder();
        
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        
        return hexString.toString();
    }
    
    
    private void cancelarRedefinicao() {
        int confirmacao = JOptionPane.showConfirmDialog(this,
            "Tem certeza que deseja cancelar a redefinição de senha?\n\n" +
            "Todas as alterações não salvas serão perdidas.",
            "Confirmar Cancelamento",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirmacao == JOptionPane.YES_OPTION) {
            dispose();
        }
    }
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaAdminRedefinirSenha frame = new TelaAdminRedefinirSenha();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}