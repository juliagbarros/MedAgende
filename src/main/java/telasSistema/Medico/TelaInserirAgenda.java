package telasSistema.Medico;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Back.Agenda;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class TelaInserirAgenda extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						TelaInserirAgenda frame = new TelaInserirAgenda();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		public TelaInserirAgenda() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 742, 454);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(204, 253, 255));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JButton btnrecebeplanilha = new JButton("Insira Planilha");
			btnrecebeplanilha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fileChooser = new JFileChooser();
				    fileChooser.setDialogTitle("Escolha um arquivo XLSX");
				    fileChooser.setFileFilter(new FileNameExtensionFilter("Arquivos do Excel", "xlsx"));
				    
				    
				    //Recebe o RESULTADO do diálogo
				    int escolha = fileChooser.showOpenDialog(contentPane);
				    //Analisa se o resultado foi positivo
				    if (escolha == JFileChooser.APPROVE_OPTION) {
				    	//arquivo recebe o ARQUIVO escolhido
				        File arquivo = fileChooser.getSelectedFile();
				        System.out.println("[DEBUG TelaInserirAgenda] Arquivo recebido");
				        
				        //Chama a função da classe que tá na pasta de backend
				        Agenda.recebeplanilha(arquivo);
				}
				   
				}
			});
			btnrecebeplanilha.setBounds(418, 111, 169, 40);
			contentPane.add(btnrecebeplanilha);
			
			JTextArea painelretorno = new JTextArea();
			painelretorno.setWrapStyleWord(true);
			painelretorno.setEditable(false);
			painelretorno.setBounds(379, 162, 250, 150);
			contentPane.add(painelretorno);
			
			JLabel lbltitulo = new JLabel("Insira a sua agenda");
			lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbltitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lbltitulo.setBounds(231, 11, 250, 74);
			contentPane.add(lbltitulo);
			
			JLabel lbltutorial = new JLabel("<html> IMPORTANTE: Antes de Inserir a sua agenda, certifique-se de que ela seja um aquivo XLSX com exatamente 3 colunas"
					+ " sendo a primeira coluna as datas, a segunda coluna seu horário de chegada, e a terceira coluna seu horário de saída, nesta ordem exata, e que elas estejam na"
					+ " primeira página da sua planilha(o nome não é relevante), o sistema ignora automaticamente textos em sua planilha, mas caso uma linha de sua planilha não seja composta"
					+ "inteiramente por textos pode gerar inconsistencias no momento de salvar o banco de dados </html>");
			lbltutorial.setBounds(34, 108, 286, 201);
			contentPane.add(lbltutorial);
			
			JButton btnvoltar = new JButton("Voltar");
			btnvoltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaPrincipalMedico telaprincipalmedico = new TelaPrincipalMedico();
					telaprincipalmedico.setVisible(true);
					dispose();
				}
			});
			btnvoltar.setBounds(46, 381, 102, 23);
			contentPane.add(btnvoltar);

		}
	}

