package telasSistema;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color; // Importação adicionada para cores
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JProgressBar;
import javax.swing.event.DocumentEvent; // Importação para DocumentListener
import javax.swing.event.DocumentListener; // Importação para DocumentListener
import java.util.Arrays;
import javax.swing.JCheckBoxMenuItem; // Importação para Arrays.fill (boa prática de segurança)

public class TelaCadastro extends JFrame {

    // Enum para definir os níveis de força
    private enum PasswordStrength {
        WEAK, // Fraca
        MEDIUM, // Média
        STRONG // Forte
    }

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
    
    // NOVOS COMPONENTES PARA FEEDBACK
    private JLabel lblStrengthFeedback; // Rótulo para texto (Fraca, Forte)
    private JProgressBar progressBar; // Barra de progresso para visualização

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setBounds(350, 11, 135, 67);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 27));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(57, 115, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(270, 115, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(31, 198, 125, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(457, 115, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Digite aqui seu Email:");
		lblNewLabel_1.setBounds(21, 172, 189, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Digite aqui a senha que deseja usar:");
		lblNewLabel_2.setBounds(223, 172, 206, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DIgite aqui seu CPF:");
		lblNewLabel_3.setBounds(237, 89, 154, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Digite aqui seu Nome Completo:");
		lblNewLabel_4.setBounds(21, 90, 206, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Selecione como deseja se Cadastrar:");
		lblNewLabel_5.setBounds(315, 276, 379, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Digite aqui sua Matrícula");
		lblNewLabel_6.setBounds(31, 276, 175, 14);
		contentPane.add(lblNewLabel_6);
		
		
		table = new JTable();
		table.setBounds(508, 303, 1, 1);
		contentPane.add(table);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(233, 198, 160, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(457, 198, 135, 20);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_8 = new JLabel("Confirme sua senha:");
		lblNewLabel_8.setBounds(468, 172, 124, 14);
		contentPane.add(lblNewLabel_8);
		
		
		// CONFIGURAÇÃO DOS NOVOS COMPONENTES DE FEEDBACK
        // Rótulo para feedback de texto
		lblStrengthFeedback = new JLabel("Nível da Senha:");
		lblStrengthFeedback.setBounds(203, 229, 100, 14); // Posição ajustada
		contentPane.add(lblStrengthFeedback);
        
        // Barra de progresso para feedback visual
        progressBar = new JProgressBar(0, 5); // Valor mínimo 0, máximo 5 (pontuação máxima)
        progressBar.setBounds(293, 228, 72, 20); // Posição ajustada
        progressBar.setStringPainted(true); // Exibir o texto de progresso (opcional)
        contentPane.add(progressBar);

		JLabel lblNewLabel_9 = new JLabel("Senha:");
		lblNewLabel_9.setBounds(285, 224, 46, 14);
		// Removido o lblNewLabel_9 para dar espaço ao novo JLabel e JProgressBar
		// contentPane.add(lblNewLabel_9); 
        
        // CHAMADA DO MÉTODO QUE IMPLEMENTA O DocumentListener
        implementPasswordStrengthCheck();

	}

    // =======================================================================
    // 1. LÓGICA DE AVALIAÇÃO DA FORÇA DA SENHA
    // =======================================================================

    /**
     * Avalia a força da senha com base em vários critérios (comprimento, tipos de caracteres).
     * @param password A string da senha a ser avaliada.
     * @return O nível de força (WEAK, MEDIUM, STRONG).
     */
    private PasswordStrength checkPasswordStrength(String password) {
        int score = 0;
        
        // 0. Verifica se está vazia
        if (password.length() == 0) {
            return PasswordStrength.WEAK; // Será tratado no Listener para limpar o feedback
        }

        // 1. Pontua por comprimento
        // Senhas com menos de 8 caracteres são consideradas fracas, mas pontuamos acima disso.
        if (password.length() >= 8) {
            score++;
        }
        if (password.length() >= 12) {
            score++;
        }

        // 2. Pontua por ter diferentes tipos de caracteres (Regex)
        // Pelo menos uma minúscula
        if (password.matches(".*[a-z].*")) { 
            score++;
        }
        // Pelo menos uma maiúscula
        if (password.matches(".*[A-Z].*")) { 
            score++;
        }
        // Pelo menos um número
        if (password.matches(".*[0-9].*")) { 
            score++;
        }
        // Pelo menos um símbolo/caractere especial (não alfanumérico)
        if (password.matches(".*[^a-zA-Z0-9].*")) { 
            score++;
        }
        
        // Define a força com base na pontuação total (máximo: 5 pontos)
        if (score >= 4) {
            return PasswordStrength.STRONG;
        } else if (score >= 2) {
            return PasswordStrength.MEDIUM;
        } else {
            return PasswordStrength.WEAK;
        }
    }

    // =======================================================================
    // 2. INTEGRAÇÃO SWING COM DocumentListener
    // =======================================================================

    /**
     * Adiciona o DocumentListener ao campo de senha para atualizar o feedback em tempo real.
     */
    private void implementPasswordStrengthCheck() {
        
        passwordField.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkAndUpdateUI();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkAndUpdateUI();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Não usado para JPasswordField
            }

            private void checkAndUpdateUI() {
                // Obtém a senha como String (uso temporário)
                String password = new String(passwordField.getPassword());
                
                // 1. Verifica se está vazio e limpa o feedback
                if (password.isEmpty()) {
                    lblStrengthFeedback.setText("Nível da Senha:");
                    lblStrengthFeedback.setForeground(Color.BLACK);
                    progressBar.setValue(0);
                    progressBar.setString("");
                    return;
                }
                
                // 2. Executa a lógica de avaliação
                PasswordStrength strength = checkPasswordStrength(password);
                
                // Limpa o array char[] da senha da memória imediatamente (boa prática de segurança)
                Arrays.fill(passwordField.getPassword(), ' '); 

                // 3. Atualiza o JLabel e JProgressBar
                switch (strength) {
                    case WEAK:
                        lblStrengthFeedback.setText("FRACA");
                        lblStrengthFeedback.setForeground(Color.RED);
                        progressBar.setValue(1); // 1 de 5
                        progressBar.setForeground(Color.RED);
                        progressBar.setString("Fraca");
                        break;
                    case MEDIUM:
                        lblStrengthFeedback.setText("MÉDIA");
                        lblStrengthFeedback.setForeground(Color.ORANGE.darker());
                        progressBar.setValue(3); // 3 de 5
                        progressBar.setForeground(Color.ORANGE.darker());
                        progressBar.setString("Média");
                        break;
                    case STRONG:
                        lblStrengthFeedback.setText("FORTE");
                        lblStrengthFeedback.setForeground(Color.GREEN.darker());
                        progressBar.setValue(5); // 5 de 5
                        progressBar.setForeground(Color.GREEN.darker());
                        progressBar.setString("Forte");
                        break;
                }
            }
        });
    }

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}