package telasSistema;

import java.util.*;
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

import com.toedter.calendar.JDateChooser; //Jcalendar importado;
import java.util.Arrays;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTree;
import javax.swing.JMenuItem;
import java.awt.Checkbox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox; // Importação para Arrays.fill (boa prática de segurança)

public class TelaCadastro extends JFrame {

    // Enum para definir os níveis de força
    private enum PasswordStrength {
        WEAK, // Fraca
        MEDIUM, // Média
        STRONG // Forte
    }

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textEmail;
	private JTextField textField_3;
	private JPasswordField passwordFieldSENHA;
	private JPasswordField passwordCONFIRMARSENHA;
	private JDateChooser dcDataNascimento;
    
    // NOVOS COMPONENTES PARA FEEDBACK
    private JLabel lblStrengthFeedbackNIVELSENHA; // Rótulo para texto (Fraca, Forte)
    private JProgressBar progressBarBARRAdoNIVELSENHA; // Barra de progresso para visualização

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
		contentPane.setBackground(new Color(143, 222, 239));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setLocation(420, 336);
		addPopup(contentPane, popupMenu);
		contentPane.setLayout(null);
		
		JLabel LabelTítuloCadastro = new JLabel("Cadastro");
		LabelTítuloCadastro.setBounds(313, -13, 181, 67);
		LabelTítuloCadastro.setFont(new Font("Trebuchet MS", Font.PLAIN, 35));
		contentPane.add(LabelTítuloCadastro);
		
		textNome = new JTextField();
		textNome.setBounds(31, 115, 112, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textCPF = new JTextField();
		textCPF.setBounds(270, 115, 86, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setToolTipText("Ex: costelinha123@gmail.com...");
		textEmail.setBounds(31, 198, 125, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(408, 389, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel LabelEmail = new JLabel("Digite aqui seu Email:");
		LabelEmail.setBounds(21, 172, 189, 14);
		contentPane.add(LabelEmail);
		
		JLabel LabelSENHA = new JLabel("Digite aqui a senha que deseja usar:");
		LabelSENHA.setBounds(223, 172, 206, 14);
		contentPane.add(LabelSENHA);
		
		JLabel LabelCPF = new JLabel("DIgite aqui seu CPF:");
		LabelCPF.setBounds(237, 89, 154, 14);
		contentPane.add(LabelCPF);
		
		JLabel LabelNome = new JLabel("Digite aqui seu Nome Completo:");
		LabelNome.setBounds(21, 90, 206, 14);
		contentPane.add(LabelNome);
		
		JLabel lblNewLabel_5 = new JLabel("Selecione como deseja se Cadastrar:");
		lblNewLabel_5.setBounds(45, 336, 379, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel LabelMatrícula = new JLabel("Digite aqui sua Matrícula");
		LabelMatrícula.setBounds(386, 363, 175, 14);
		contentPane.add(LabelMatrícula);
		
		JLabel LabelDataNascimento = new JLabel("Insira sua Data de Nascimento:");
		LabelDataNascimento.setBounds(434, 89, 154, 14);
		contentPane.add(LabelDataNascimento);
        
        // --- JCALENDAR ---
        dcDataNascimento = new JDateChooser();
        dcDataNascimento.setToolTipText("Ex: 25/06/2003...");
        dcDataNascimento.setDateFormatString("dd/MM/yyyy"); // Formato da data
        dcDataNascimento.setBounds(444, 115, 120, 20); 
        contentPane.add(dcDataNascimento);
		
		passwordFieldSENHA = new JPasswordField();
		passwordFieldSENHA.setToolTipText("Ex: 40028922...");
		passwordFieldSENHA.setBounds(233, 198, 160, 20);
		contentPane.add(passwordFieldSENHA);
		
		passwordCONFIRMARSENHA = new JPasswordField();
		passwordCONFIRMARSENHA.setBounds(457, 198, 135, 20);
		contentPane.add(passwordCONFIRMARSENHA);
		
		JLabel LabelCONFIRMARSENHA = new JLabel("Confirme sua senha:");
		LabelCONFIRMARSENHA.setBounds(468, 172, 124, 14);
		contentPane.add(LabelCONFIRMARSENHA);
		
		
		// configuração dos novos componentes 
        // Rótulo para feedback de texto
		lblStrengthFeedbackNIVELSENHA = new JLabel("Nível da Senha:");
		lblStrengthFeedbackNIVELSENHA.setBounds(203, 229, 100, 14); // Posição ajustada
		contentPane.add(lblStrengthFeedbackNIVELSENHA);
        
        // Barra de progresso para feedback visual
        progressBarBARRAdoNIVELSENHA = new JProgressBar(0, 5); // Valor mínimo 0, máximo 5 (pontuação máxima)
        progressBarBARRAdoNIVELSENHA.setBounds(293, 228, 72, 20); // Posição ajustada
        progressBarBARRAdoNIVELSENHA.setStringPainted(true); // Exibir o texto de progresso (opcional)
        contentPane.add(progressBarBARRAdoNIVELSENHA);
        
        Checkbox checkbox = new Checkbox("Médico");
        checkbox.setBounds(31, 363, 95, 22);
        contentPane.add(checkbox);
        
        Checkbox checkbox_1 = new Checkbox("Secretária");
        checkbox_1.setBounds(132, 363, 95, 22);
        contentPane.add(checkbox_1);
        
        Checkbox checkbox_1_1 = new Checkbox("Administrador");
        checkbox_1_1.setBounds(232, 363, 95, 22);
        contentPane.add(checkbox_1_1);
        
        Checkbox checkbox_2 = new Checkbox("Paciente");
        checkbox_2.setBounds(31, 401, 95, 22);
        contentPane.add(checkbox_2);
        
        JLabel lblNewLabel_10 = new JLabel("Já possui Cadastro? ");
        lblNewLabel_10.setBounds(279, 53, 135, 14);
        contentPane.add(lblNewLabel_10);
        
        JButton btnCadastro = new JButton("CADASTRAR-SE");
        btnCadastro.setForeground(new Color(13, 242, 219));
        btnCadastro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnCadastro.setBounds(628, 363, 120, 32);
        contentPane.add(btnCadastro);
        
        JButton btnLogin = new JButton("Realizar Login");
        btnLogin.setBounds(405, 50, 135, 20);
        contentPane.add(btnLogin);
               
        JLabel LabelEstados = new JLabel("Estado(UF):");
        LabelEstados.setBounds(699, 85, 72, 22);
        contentPane.add(LabelEstados);
        
        JLabel LabelMunicípios = new JLabel("Município:");
        LabelMunicípios.setBounds(699, 162, 59, 35);
        contentPane.add(LabelMunicípios);
        
        JComboBox comboBoxEstados = new JComboBox();
        comboBoxEstados.setBounds(699, 114, 72, 22);
        contentPane.add(comboBoxEstados);
        
        JComboBox comboBoxMunicípios = new JComboBox();
        comboBoxMunicípios.setBounds(691, 197, 95, 22);
        contentPane.add(comboBoxMunicípios);

		JLabel lblNewLabel_9 = new JLabel("Senha:");
		lblNewLabel_9.setBounds(285, 224, 46, 14);
		// Removi o lblNewLabel_9 para dar espaço ao novo JLabel e JProgressBar
		// contentPane.add(lblNewLabel_9); 
        
        // chamando o método que implementa O DocumentListener
        implementPasswordStrengthCheck();

	}

    
    //AVALIAÇÃO DA FORÇA DA SENHA
    

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
        // Senhas com menos de 8 caracteres vão ser consideradas fracas, mas se for maior que isso, aumenta a segurança.
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
        // Pelo menos um símbolo/caractere especial 
        if (password.matches(".*[^a-zA-Z0-9].*")) { 
            score++;
        }
        
        // Define a força com base na pontuação total (máximo de 5 pontos)
        if (score >= 4) {
            return PasswordStrength.STRONG;
        } else if (score >= 2) {
            return PasswordStrength.MEDIUM;
        } else {
            return PasswordStrength.WEAK;
        }
    }

    // 
    // 2. integração do SWING com DocumentListener
    // 

    /**
     * Adiciona o DocumentListener ao campo de senha para atualizar o feedback em tempo real.
     */
    private void implementPasswordStrengthCheck() {
        
        passwordFieldSENHA.getDocument().addDocumentListener(new DocumentListener() {
            
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
                // recebe a senha como String (uso temporário)
                String password = new String(passwordFieldSENHA.getPassword());
                
                // 1. verifica se está vazio e limpa o feedback
                if (password.isEmpty()) {
                    lblStrengthFeedbackNIVELSENHA.setText("Nível da Senha:");
                    lblStrengthFeedbackNIVELSENHA.setForeground(Color.BLACK);
                    progressBarBARRAdoNIVELSENHA.setValue(0);
                    progressBarBARRAdoNIVELSENHA.setString("");
                    return;
                }
                
                // 2. Executa a lógica de avaliação
                PasswordStrength strength = checkPasswordStrength(password);
                
                // Limpa o array char[] da senha da memória imediatamente (boa prática de segurança)
                Arrays.fill(passwordFieldSENHA.getPassword(), ' '); 

                // 3. Atualiza o JLabel e JProgressBar
                switch (strength) {
                    case WEAK:
                        lblStrengthFeedbackNIVELSENHA.setText("FRACA");
                        lblStrengthFeedbackNIVELSENHA.setForeground(Color.RED);
                        progressBarBARRAdoNIVELSENHA.setValue(1); // 1 de 5
                        progressBarBARRAdoNIVELSENHA.setForeground(Color.RED);
                        progressBarBARRAdoNIVELSENHA.setString("Fraca");
                        break;
                    case MEDIUM:
                        lblStrengthFeedbackNIVELSENHA.setText("MÉDIA");
                        lblStrengthFeedbackNIVELSENHA.setForeground(Color.ORANGE.darker());
                        progressBarBARRAdoNIVELSENHA.setValue(3); // 3 de 5
                        progressBarBARRAdoNIVELSENHA.setForeground(Color.ORANGE.darker());
                        progressBarBARRAdoNIVELSENHA.setString("Média");
                        break;
                    case STRONG:
                        lblStrengthFeedbackNIVELSENHA.setText("FORTE");
                        lblStrengthFeedbackNIVELSENHA.setForeground(Color.GREEN.darker());
                        progressBarBARRAdoNIVELSENHA.setValue(5); // 5 de 5
                        progressBarBARRAdoNIVELSENHA.setForeground(Color.GREEN.darker());
                        progressBarBARRAdoNIVELSENHA.setString("Forte");
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