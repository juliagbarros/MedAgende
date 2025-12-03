package telasSistema;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditEspecialidadesFrame extends JFrame {
	private JTextField CQM_VAR;
	private JTextField Area_atuacao_VAR;
	private JTextField Especialidade_VAR;
	private JTextField RQE_VAR;
	private JTextField Situacao_VAR;
	private final Action Confirmar_especialidade_edit = new SwingAction();
	private final Action Voltar = new SwingAction_1();
    public EditEspecialidadesFrame() {
    	getContentPane().setBackground(new Color(135, 206, 235));
    	getContentPane().setForeground(new Color(0, 0, 0));
        initComponents();
    }

    private void initComponents() {
        setTitle("Editar Especialidades");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        JLabel lblTitulo = new JLabel("EDITAR ESPECIALIDADE", SwingConstants.CENTER);
        lblTitulo.setBounds(116, 31, 248, 64);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        getContentPane().add(lblTitulo);
        
        JButton btnvoltar = new JButton("Voltar");
        btnvoltar.setAction(Voltar);
        btnvoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        btnvoltar.setForeground(new Color(178, 34, 34));
        btnvoltar.setFont(new Font("Segoe UI", Font.BOLD, 11));
        btnvoltar.setFocusTraversalKeysEnabled(false);
        btnvoltar.setFocusPainted(false);
        btnvoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnvoltar.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
        btnvoltar.setBackground(new Color(135, 206, 235));
        btnvoltar.setBounds(284, 221, 65, 23);
        getContentPane().add(btnvoltar);
        
        CQM_VAR = new JTextField();
        CQM_VAR.setColumns(10);
        CQM_VAR.setBounds(10, 119, 132, 20);
        getContentPane().add(CQM_VAR);
        
        Area_atuacao_VAR = new JTextField();
        Area_atuacao_VAR.setColumns(10);
        Area_atuacao_VAR.setBounds(183, 119, 132, 20);
        getContentPane().add(Area_atuacao_VAR);
        
        JLabel lblArea_de_atuacao_Titulo = new JLabel("Área de atuação");
        lblArea_de_atuacao_Titulo.setForeground(Color.GRAY);
        lblArea_de_atuacao_Titulo.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblArea_de_atuacao_Titulo.setBounds(183, 106, 94, 14);
        getContentPane().add(lblArea_de_atuacao_Titulo);
        
        JLabel CRM_Titulo = new JLabel("CQM");
        CRM_Titulo.setForeground(Color.GRAY);
        CRM_Titulo.setFont(new Font("Segoe UI", Font.BOLD, 11));
        CRM_Titulo.setBounds(10, 106, 65, 14);
        getContentPane().add(CRM_Titulo);
        
        JLabel lblEspecialidade_Titulo = new JLabel("Especialidade");
        lblEspecialidade_Titulo.setForeground(Color.GRAY);
        lblEspecialidade_Titulo.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblEspecialidade_Titulo.setBounds(84, 161, 87, 14);
        getContentPane().add(lblEspecialidade_Titulo);
        
        Especialidade_VAR = new JTextField();
        Especialidade_VAR.setColumns(10);
        Especialidade_VAR.setBounds(84, 175, 132, 20);
        getContentPane().add(Especialidade_VAR);
        
        RQE_VAR = new JTextField();
        RQE_VAR.setColumns(10);
        RQE_VAR.setBounds(257, 175, 132, 20);
        getContentPane().add(RQE_VAR);
        
        JLabel lblRQE_Titulo = new JLabel("RQE");
        lblRQE_Titulo.setForeground(Color.GRAY);
        lblRQE_Titulo.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblRQE_Titulo.setBounds(257, 161, 65, 14);
        getContentPane().add(lblRQE_Titulo);
        
        JButton btnConfirmar_cadastro_especialidade = new JButton("Confirmar");
        btnConfirmar_cadastro_especialidade.setAction(Confirmar_especialidade_edit);
        btnConfirmar_cadastro_especialidade.setForeground(new Color(0, 51, 0));
        btnConfirmar_cadastro_especialidade.setFont(new Font("Segoe UI", Font.BOLD, 11));
        btnConfirmar_cadastro_especialidade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConfirmar_cadastro_especialidade.setBorder(new LineBorder(new Color(50, 205, 50), 2, true));
        btnConfirmar_cadastro_especialidade.setBackground(new Color(135, 206, 235));
        btnConfirmar_cadastro_especialidade.setBounds(127, 221, 65, 23);
        getContentPane().add(btnConfirmar_cadastro_especialidade);
        
        Situacao_VAR = new JTextField();
        Situacao_VAR.setColumns(10);
        Situacao_VAR.setBounds(342, 119, 132, 20);
        getContentPane().add(Situacao_VAR);
        
        JLabel lblArea_de_atuacao_Titulo_1 = new JLabel("Área de atuação");
        lblArea_de_atuacao_Titulo_1.setForeground(Color.GRAY);
        lblArea_de_atuacao_Titulo_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblArea_de_atuacao_Titulo_1.setBounds(342, 106, 94, 14);
        getContentPane().add(lblArea_de_atuacao_Titulo_1);
        setSize(500, 315);
        setLocationRelativeTo(null);
    }
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Confirmar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if (CQM_VAR.getText().isEmpty() || Area_atuacao_VAR.getText().isEmpty() || Especialidade_VAR.getText().isEmpty() || RQE_VAR.getText().isEmpty() || Situacao_VAR.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos antes de confirmar a edição da especialidade.", "Campos Incompletos", JOptionPane.WARNING_MESSAGE);
			} else {
				// Por enquanto, apenas exibe uma mensagem de sucesso
				JOptionPane.showMessageDialog(null, "Especialidade editada com sucesso!", "Edição Confirmada", JOptionPane.INFORMATION_MESSAGE);
				
				CQM_VAR.setText("");
				Area_atuacao_VAR.setText("");
				Especialidade_VAR.setText("");
				RQE_VAR.setText("");
				Situacao_VAR.setText("");
				//TODO: Adicionar lógica para salvar os dados editados da especialidade
				
				// Fecha o frame após a confirmação
				EditEspecialidadesFrame.this.dispose();
			}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Voltar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			EditEspecialidadesFrame.this.dispose();
		}
	}
}
