package telasSistema;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class GestaoProfissionaisFrame extends JFrame {
	private final Action Cadastrar_medicos_action = new SwingAction();
	private final Action Vincular_medicos_action = new SwingAction_1();
	private final Action Desativar_medicos_e_especialistas_action = new SwingAction_2();
	private final Action Editar_dados_medicos = new SwingAction_3();
	private final Action Horarios_disponibilidade_medico = new SwingAction_4();
	private final Action Voltar_gestao_especialidades = new SwingAction_5();
    
	public GestaoProfissionaisFrame() {
    	setAutoRequestFocus(false);
    	getContentPane().setBackground(new Color(135, 206, 235));
    	getContentPane().setLayout(null);
    	setSize(new Dimension(650, 420));
    	setLocationRelativeTo(null);
    	JLabel Título = new JLabel("GESTÃO DE MÉDICOS");
    	Título.setHorizontalAlignment(SwingConstants.CENTER);
    	Título.setFont(new Font("Segoe UI", Font.BOLD, 30));
    	Título.setBounds(158, 33, 317, 66);
    	getContentPane().add(Título);
    	
    	JButton btnCadastrarMedicos = new JButton("Cadastrar médicos");
    	btnCadastrarMedicos.setAction(Cadastrar_medicos_action);
    	btnCadastrarMedicos.setBorder(new LineBorder(new Color(128, 128, 128), 3, true));
    	btnCadastrarMedicos.setBounds(64, 145, 211, 40);
    	getContentPane().add(btnCadastrarMedicos);
    	
    	JButton btnVincularMedicosEEspecialistas = new JButton("vincular médicos a clínicas e especialistas");
    	btnVincularMedicosEEspecialistas.setAction(Vincular_medicos_action);
    	btnVincularMedicosEEspecialistas.setBorder(new LineBorder(new Color(128, 128, 128), 3, true));
    	btnVincularMedicosEEspecialistas.setFont(new Font("Tahoma", Font.PLAIN, 9));
    	btnVincularMedicosEEspecialistas.setBounds(64, 213, 211, 40);
    	getContentPane().add(btnVincularMedicosEEspecialistas);
    	
    	JButton btnDesativarMedicosEEspecialistas = new JButton("Desativar médicos e especialistas inativos");
    	btnDesativarMedicosEEspecialistas.setAction(Desativar_medicos_e_especialistas_action);
    	btnDesativarMedicosEEspecialistas.setBorder(new LineBorder(new Color(128, 128, 128), 3, true));
    	btnDesativarMedicosEEspecialistas.setFont(new Font("Tahoma", Font.PLAIN, 9));
    	btnDesativarMedicosEEspecialistas.setBounds(64, 274, 211, 40);
    	getContentPane().add(btnDesativarMedicosEEspecialistas);
    	
    	JButton btnEditarDadosDosMedicos = new JButton("Editar dados dos médicos\r\n");
    	btnEditarDadosDosMedicos.setAction(Editar_dados_medicos);
    	btnEditarDadosDosMedicos.setBorder(new LineBorder(new Color(128, 128, 128), 3, true));
    	btnEditarDadosDosMedicos.setFont(new Font("Tahoma", Font.PLAIN, 11));
    	btnEditarDadosDosMedicos.setBounds(358, 145, 211, 40);
    	getContentPane().add(btnEditarDadosDosMedicos);
    	
    	JButton btnDefinirHorariosEDisponibilidadeDoMedico = new JButton("Definir horários e disponibilidade do médico");
    	btnDefinirHorariosEDisponibilidadeDoMedico.setAction(Horarios_disponibilidade_medico);
    	btnDefinirHorariosEDisponibilidadeDoMedico.setBorder(new LineBorder(new Color(128, 128, 128), 3, true));
    	btnDefinirHorariosEDisponibilidadeDoMedico.setFont(new Font("Tahoma", Font.PLAIN, 9));
    	btnDefinirHorariosEDisponibilidadeDoMedico.setBounds(358, 213, 211, 40);
    	getContentPane().add(btnDefinirHorariosEDisponibilidadeDoMedico);
    	
    	JButton btnVoltarAoMenu = new JButton("Voltar ao menu");
    	btnVoltarAoMenu.setAction(Voltar_gestao_especialidades);
    	btnVoltarAoMenu.setContentAreaFilled(false);
    	btnVoltarAoMenu.setBorder(new LineBorder(new Color(128, 128, 128), 3));
    	btnVoltarAoMenu.setForeground(new Color(255, 255, 255));
    	btnVoltarAoMenu.setBackground(new Color(139, 0, 0));
    	btnVoltarAoMenu.setFont(new Font("Tahoma", Font.PLAIN, 9));
    	btnVoltarAoMenu.setBounds(358, 274, 211, 40);
    	getContentPane().add(btnVoltarAoMenu);
    	
    	JEditorPane editorPane = new JEditorPane();
    	editorPane.setEditable(false);
    	editorPane.setBackground(new Color(139, 0, 0));
    	editorPane.setBounds(358, 275, 211, 37);
    	getContentPane().add(editorPane);
    }
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Cadastrar médicos");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Vincular médicos a clínicas e especialistas");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Desativar médicos e especialistas inativos");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Editar dados dos médicos");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Definir horários e disponibilidade do médico");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "Voltar para a Cadastro de especialidades");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			GestaoProfissionaisFrame.this.dispose();
			
			
		}
	}
}
