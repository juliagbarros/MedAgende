package telasSistema;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities; // para o main
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;

public class TelaAdministradorCadastroDeEspecialidades extends JFrame {
	
	private final Action Edit_especialidades_action = new SwingAction();
	private final Action Add_especialidades_action = new SwingAction_1();
	private final Action Botao_voltar_especialidades = new SwingAction_5();
	private final Action Gestao_profissionais_medicos = new SwingAction_2();
	
	//TODO método para executar a interface (utilizar mais tarde)
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdministradorCadastroDeEspecialidades frame = new TelaAdministradorCadastroDeEspecialidades();
					frame.setVisible(true);
					frame.setSize(650, 400);
					frame.setLocationRelativeTo(null); // Centraliza a janela na tela
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaAdministradorCadastroDeEspecialidades() throws IOException  {
		
		
		//TODO Configurações da janela
		
		setResizable(false);
		setTitle("Cadastro de Especialidades");
		getContentPane().setBackground(new Color(135, 206, 250));
		setBackground(new Color(64, 224, 208));
		setForeground(new Color(255, 0, 0));
		getContentPane().setForeground(new Color(135, 206, 235));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		//TODO Título da aba

		JLabel TITULO = new JLabel("CADASTRO DE ESPECIALIDADES");
		TITULO.setBackground(SystemColor.activeCaption);
		TITULO.setFocusable(false);
		TITULO.setFocusTraversalKeysEnabled(false);
		TITULO.setForeground(SystemColor.desktop);
		TITULO.setBorder(new TitledBorder(
				new CompoundBorder(new MatteBorder(0, 4, 4, 0, (Color) new Color(0, 128, 0)),
					new LineBorder(new Color(50, 205, 50), 4)),
				"", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		TITULO.setFont(new Font("Segoe UI", Font.BOLD, 30));
		TITULO.setHorizontalAlignment(SwingConstants.CENTER);
		TITULO.setBounds(74, 35, 488, 71);
		getContentPane().add(TITULO);
		
		//TODO botões com ações

		JButton btnAdicionarEspecialidades = new JButton("Adicionar especialidades");
		btnAdicionarEspecialidades.setAction(Add_especialidades_action);
		btnAdicionarEspecialidades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionarEspecialidades.setForeground(new Color(0, 0, 0));
		btnAdicionarEspecialidades.setContentAreaFilled(false);
		btnAdicionarEspecialidades.setBackground(UIManager.getColor("Button.background"));
		btnAdicionarEspecialidades
				.setBorder(new CompoundBorder(new MatteBorder(0, 3, 3, 0, (Color) new Color(105, 105, 105)),
					new LineBorder(new Color(255, 255, 255), 4)));
		btnAdicionarEspecialidades.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnAdicionarEspecialidades.setBounds(164, 163, 294, 37);
		getContentPane().add(btnAdicionarEspecialidades);

		JButton Back_cadastro_especialidades = new JButton("<<");
		Back_cadastro_especialidades.setAction(Botao_voltar_especialidades);
		Back_cadastro_especialidades.setForeground(new Color(220, 20, 60));
		Back_cadastro_especialidades.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 20));
		Back_cadastro_especialidades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Back_cadastro_especialidades.setContentAreaFilled(false);
		Back_cadastro_especialidades.setBorder(null);
		Back_cadastro_especialidades.setFocusTraversalKeysEnabled(false);
		Back_cadastro_especialidades.setFocusPainted(false);
		Back_cadastro_especialidades.setBackground(new Color(135, 206, 235));
		Back_cadastro_especialidades.setBounds(10, 310, 54, 30);
		getContentPane().add(Back_cadastro_especialidades);

		JButton btnEditarEspecialidades = new JButton("Editar especialidades");
		btnEditarEspecialidades.setAction(Edit_especialidades_action);
		btnEditarEspecialidades.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditarEspecialidades.setForeground(new Color(0, 0, 0));
		btnEditarEspecialidades.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnEditarEspecialidades.setContentAreaFilled(false);
		btnEditarEspecialidades
				.setBorder(new CompoundBorder(new MatteBorder(0, 3, 3, 0, (Color) new Color(105, 105, 105)),
					new LineBorder(new Color(255, 255, 255), 4)));
		btnEditarEspecialidades.setBackground(UIManager.getColor("Button.background"));
		btnEditarEspecialidades.setBounds(164, 211, 294, 37);
		getContentPane().add(btnEditarEspecialidades);

		JButton btnGestaoDeProfissionaisMedicos = new JButton("Gestão de profissionais(médicos)");
		btnGestaoDeProfissionaisMedicos.setAction(Gestao_profissionais_medicos);
		btnGestaoDeProfissionaisMedicos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGestaoDeProfissionaisMedicos.setForeground(new Color(0, 0, 0));
		btnGestaoDeProfissionaisMedicos.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnGestaoDeProfissionaisMedicos.setContentAreaFilled(false);
		btnGestaoDeProfissionaisMedicos
				.setBorder(new CompoundBorder(new MatteBorder(0, 3, 3, 0, (Color) new Color(105, 105, 105)),
					new LineBorder(new Color(255, 255, 255), 4)));
		btnGestaoDeProfissionaisMedicos.setBackground(UIManager.getColor("Button.background"));
		btnGestaoDeProfissionaisMedicos.setBounds(164, 259, 294, 37);
		getContentPane().add(btnGestaoDeProfissionaisMedicos);
		
		//observação: este botão é uma "sombra" do botão de voltar, para criar um efeito visual, nada mais.

		JButton Back_cadastro_especialidades_sombra = new JButton("<<");
		Back_cadastro_especialidades_sombra.setForeground(new Color(0, 0, 0));
		Back_cadastro_especialidades_sombra.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 20));	
		Back_cadastro_especialidades_sombra.setFocusTraversalKeysEnabled(false);
		Back_cadastro_especialidades_sombra.setFocusPainted(false);
		Back_cadastro_especialidades_sombra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Back_cadastro_especialidades_sombra.setContentAreaFilled(false);
		Back_cadastro_especialidades_sombra.setBorder(null);
		Back_cadastro_especialidades_sombra.setBackground(new Color(135, 206, 235));
		Back_cadastro_especialidades_sombra.setBounds(6, 312, 54, 30);
		getContentPane().add(Back_cadastro_especialidades_sombra);

		}
		
		
		//TODO Ações dos botões (utilizar mais tarde)

		private class SwingAction extends AbstractAction {
			public SwingAction() {
				putValue(NAME, "Editar Especialidades Existentes");
				putValue(SHORT_DESCRIPTION, "Some short description");
			}

			public void actionPerformed(ActionEvent e) {
				EditEspecialidadesFrame editEspecialidadesFrame = null;
				try{ editEspecialidadesFrame = new EditEspecialidadesFrame();
				} catch (Exception ioException) {
					ioException.printStackTrace();
				}
				editEspecialidadesFrame.setVisible(true);
			}
		}

		private class SwingAction_1 extends AbstractAction {
			public SwingAction_1() {
				putValue(NAME, "Adicionar Especialidades");
				putValue(SHORT_DESCRIPTION, "Some short description");
			}

			public void actionPerformed(ActionEvent e) {
				AddEspecialidadesFrame addEspecialidadesFrame = null;
				try{ addEspecialidadesFrame = new AddEspecialidadesFrame();
				} catch (Exception ioException) {
					ioException.printStackTrace();
				}
				addEspecialidadesFrame.setVisible(true);
			}
		}

		private class SwingAction_5 extends AbstractAction {
			public SwingAction_5() {
				putValue(NAME, "<<");
				putValue(SHORT_DESCRIPTION, "Some short description");
			}

			public void actionPerformed(ActionEvent e) {
			}
		}
		
		
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Gestão de Profissionais (Médicos)");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			GestaoProfissionaisFrame gestaoProfissionaisFrame = null;
					try{ gestaoProfissionaisFrame = new GestaoProfissionaisFrame();
					} catch (Exception ioException) {
						ioException.printStackTrace();
					}
					gestaoProfissionaisFrame.setVisible(true);
			
		}
	}
}