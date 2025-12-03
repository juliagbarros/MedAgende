package telasSistema;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;

public class AddEspecialidadesFrame extends JFrame {
	
	private JTextField CQM_VAR;
	private JTextField Area_Atuacao_VAR;
	private JTextField Especialidade_VAR;
	private JTextField RQE_VAR;
	private final Action Comfirm = new SwingAction();
	private final Action Voltar = new SwingAction_1();
	
    public AddEspecialidadesFrame() {
    	getContentPane().setBackground(new Color(135, 206, 235));
    	setBackground(new Color(135, 206, 235));
        initComponents();
    }

    private void initComponents() {
    	
    	//TODO: Ajustar tamanho da janela se necessário
    	
        setTitle("Adicionar Especialidades");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setResizable(false);
        
        //TODO: Ajustar título se necessário
        
        JLabel lbl = new JLabel("ADICIONAR ESPECIALIDADE", SwingConstants.CENTER);
        lbl.setBounds(67, 11, 267, 60);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
        getContentPane().add(lbl);
        
        //TODO: Ajustar botão voltar se necessário
        
        JButton btnvoltar = new JButton("Voltar");
        btnvoltar.setAction(Voltar);
        btnvoltar.setFont(new Font("Segoe UI", Font.BOLD, 11));
        btnvoltar.setForeground(new Color(178, 34, 34));
        btnvoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnvoltar.setBorder(new LineBorder(new Color(255, 0, 0), 2, true));
        btnvoltar.setFocusPainted(false);
        btnvoltar.setFocusTraversalKeysEnabled(false);
        btnvoltar.setBackground(new Color(135, 206, 235));
        btnvoltar.setBounds(284, 183, 65, 23);
        getContentPane().add(btnvoltar);
        
        //TODO: Ajustar labels e textfields para nomes corretos
        CQM_VAR = new JTextField();
        CQM_VAR.setBounds(55, 82, 132, 20);
        getContentPane().add(CQM_VAR);
        CQM_VAR.setColumns(10);
        
        Area_Atuacao_VAR = new JTextField();
        Area_Atuacao_VAR.setColumns(10);
        Area_Atuacao_VAR.setBounds(228, 82, 132, 20);
        getContentPane().add(Area_Atuacao_VAR);
        
        Especialidade_VAR = new JTextField();
        Especialidade_VAR.setColumns(10);
        Especialidade_VAR.setBounds(55, 140, 132, 20);
        getContentPane().add(Especialidade_VAR);
        
        RQE_VAR = new JTextField();
        RQE_VAR.setColumns(10);
        RQE_VAR.setBounds(228, 140, 132, 20);
        getContentPane().add(RQE_VAR);
        
        JLabel CRM_Titulo = new JLabel("CQM");
        CRM_Titulo.setForeground(new Color(128, 128, 128));
        CRM_Titulo.setFont(new Font("Segoe UI", Font.BOLD, 11));
        CRM_Titulo.setBounds(55, 69, 65, 14);
        getContentPane().add(CRM_Titulo);
        
        JLabel lblArea_de_atuacao_Titulo = new JLabel("Área de atuação");
        lblArea_de_atuacao_Titulo.setForeground(new Color(128, 128, 128));
        lblArea_de_atuacao_Titulo.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblArea_de_atuacao_Titulo.setBounds(228, 69, 94, 14);
        getContentPane().add(lblArea_de_atuacao_Titulo);
        
        JLabel lblEspecialidade_Titulo = new JLabel("Especialidade");
        lblEspecialidade_Titulo.setForeground(new Color(128, 128, 128));
        lblEspecialidade_Titulo.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblEspecialidade_Titulo.setBounds(55, 126, 87, 14);
        getContentPane().add(lblEspecialidade_Titulo);
        
        JLabel lblRQE_Titulo = new JLabel("RQE");
        lblRQE_Titulo.setForeground(new Color(128, 128, 128));
        lblRQE_Titulo.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblRQE_Titulo.setBounds(228, 126, 65, 14);
        getContentPane().add(lblRQE_Titulo);
        
        JButton btnConfirmar_cadastro_especialidade = new JButton("Confirmar");
        btnConfirmar_cadastro_especialidade.setAction(Comfirm);
        btnConfirmar_cadastro_especialidade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConfirmar_cadastro_especialidade.setForeground(new Color(0, 51, 0));
        btnConfirmar_cadastro_especialidade.setFont(new Font("Segoe UI", Font.BOLD, 11));
        btnConfirmar_cadastro_especialidade.setBorder(new LineBorder(new Color(50, 205, 50), 2, true));
        btnConfirmar_cadastro_especialidade.setBackground(new Color(135, 206, 235));
        btnConfirmar_cadastro_especialidade.setBounds(77, 184, 65, 23);
        getContentPane().add(btnConfirmar_cadastro_especialidade);
        btnvoltar.addActionListener(e -> dispose());
        setSize(449, 272);
        setLocationRelativeTo(null);
    }
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Confirmar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			//TODO: Adicionar validação e salvamento dos dados da especialidade
			
			if (CQM_VAR.getText().isEmpty() || Area_Atuacao_VAR.getText().isEmpty() || Especialidade_VAR.getText().isEmpty() || RQE_VAR.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				//TODO: Aqui você pode adicionar o código para salvar os dados da especialidade
				JOptionPane.showMessageDialog(null, "Especialidade cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				//TODO: Limpar os campos após o cadastro
				CQM_VAR.setText("");
				Area_Atuacao_VAR.setText("");
				Especialidade_VAR.setText("");
				RQE_VAR.setText("");
				//TODO: Obs: criar a lógica de salvamento dessas variáveis conforme a necessidade do sistema
			}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Voltar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			AddEspecialidadesFrame.this.dispose();
		}
	}
}
