package com.syst.app;
import javax.swing.JFrame;
import javafx.embed.swing.*;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.imageio.ImageIO;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Canvas;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.Label;
import java.awt.List;
import java.awt.Point;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import java.awt.Button;
public class MedAgende_main extends JFrame {
	private JTextField Login_de_design;
	private JTextField barra_de_design;
	private final Action config_action = new SwingAction();
	private final Action Menu_action = new SwingAction_1();
	private JTable Consultas;
	private final Action Consultas_show = new SwingAction_2();
	private final Action Agendamentos_show = new SwingAction_3();
	private final Action Concluídos_show = new SwingAction_4();
	
	public MedAgende_main() throws IOException {
		// TODO icone e título
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\overh\\eclipse-workspace\\Med-Agende\\src\\main\\java\\com\\syst\\app\\MedAgende-icone.png"));
		setTitle("Med Agende");
		
		//TODO ajustes de ícone.
        String caminho = "app/perfil.jpg";
        String conteudo = new String(Files.readAllBytes(Paths.get(caminho)));
        File file = new File(caminho);
		ImageIO.read(file);
		BufferedImage image = ImageIO.read(file);
		int newWidth = 40; // TODO Largura 
		int newHeight = 40; // TODO Altura 
		ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(newWidth, newHeight, image.SCALE_SMOOTH));
		Panel panel = new Panel();
		panel.setFocusable(false);
		panel.setFocusTraversalKeysEnabled(false);
		panel.setBounds(new Rectangle(3, 3, 3, 3));
		panel.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton Configurations_button = new JButton("");
		Configurations_button.setBounds(60, 24, 25, 25);
		Configurations_button.setAction(config_action);
		Configurations_button.setFocusable(false);
		Configurations_button.setFocusTraversalKeysEnabled(false);
		Configurations_button.setFocusPainted(false);
		Configurations_button.setIcon(new ImageIcon("C:\\Users\\overh\\eclipse-workspace\\Med-Agende\\src\\main\\java\\com\\syst\\app\\Button_config_icon.png"));
		Configurations_button.setBorder(null);
		Configurations_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.setLayout(null);
		
		JButton Menu_button = new JButton("");
		Menu_button.setBounds(95, 24, 25, 25);
		Menu_button.setAction(Menu_action);
		Menu_button.setIconTextGap(0);
		Menu_button.setFocusable(false);
		Menu_button.setIcon(new ImageIcon("C:\\Users\\overh\\eclipse-workspace\\Med-Agende\\src\\main\\java\\com\\syst\\app\\Button_menu_icon.png"));
		Menu_button.setFocusTraversalKeysEnabled(false);
		Menu_button.setFocusPainted(false);
		Menu_button.setBorder(null);
		panel.add(Menu_button);
		panel.add(Configurations_button);
		
				
		JLabel Perfil_iconLabel = new JLabel("", new ImageIcon("C:\\Users\\overh\\eclipse-workspace\\Med-Agende\\src\\main\\java\\com\\syst\\app\\perfil_resized.jpg"), JLabel.CENTER);
		Perfil_iconLabel.setBounds(10, 9, 40, 40);
		Perfil_iconLabel.setBorder(null);
		Perfil_iconLabel.setEnabled(false);
		panel.add(Perfil_iconLabel);
		//TODO ajustes de textField.
		barra_de_design = new JTextField();
		barra_de_design.setBounds(148, 0, 636, 30);
		barra_de_design.setEnabled(false);
		barra_de_design.setEditable(false);
		barra_de_design.setBorder(new MatteBorder(0, 0, 0, 10, (Color) new Color(0, 0, 0)));
		barra_de_design.setBackground(SystemColor.control);
		panel.add(barra_de_design);
		barra_de_design.setColumns(10);
		
		Login_de_design = new JTextField();
		Login_de_design.setBounds(0, 0, 158, 70);
		Login_de_design.setEnabled(false);
		Login_de_design.setEditable(false);
		Login_de_design.setBackground(UIManager.getColor("CheckBox.background"));
		Login_de_design.setBorder(new CompoundBorder(new CompoundBorder(new CompoundBorder(new MatteBorder(0, 0, 0, 10, (Color) new Color(0, 0, 0)), new MatteBorder(0, 0, 10, 0, (Color) new Color(240, 240, 240))), new LineBorder(new Color(240, 240, 240), 3, true)), new BevelBorder(BevelBorder.RAISED, null, new Color(255, 255, 255), new Color(240, 240, 240), new Color(240, 240, 240))));
		panel.add(Login_de_design);
		Login_de_design.setColumns(10);
		
		Panel panel_consultas = new Panel();
		panel_consultas.setBounds(126, 105, 658, 236);
		panel.add(panel_consultas);
		panel_consultas.setLayout(null);
		
		JLabel Data_nascimento_table = DefaultComponentFactory.getInstance().createLabel("Data_nascimento");
		Data_nascimento_table.setBounds(522, 11, 126, 14);
		panel_consultas.add(Data_nascimento_table);
		
		JLabel CPF_table = DefaultComponentFactory.getInstance().createLabel("CPF");
		CPF_table.setBounds(395, 11, 132, 14);
		panel_consultas.add(CPF_table);
		
		JLabel Registro_table = DefaultComponentFactory.getInstance().createLabel("Registro");
		Registro_table.setBounds(270, 11, 126, 14);
		panel_consultas.add(Registro_table);
		
		JLabel Idade_table = DefaultComponentFactory.getInstance().createLabel("Idade");
		Idade_table.setBounds(145, 11, 126, 14);
		panel_consultas.add(Idade_table);
		
		JLabel Nomes_table = DefaultComponentFactory.getInstance().createLabel("Nome");
		Nomes_table.setBounds(20, 11, 126, 14);
		panel_consultas.add(Nomes_table);
		
		Consultas = new JTable();
		Consultas.setName("Consultas");
		Consultas.setModel(new DefaultTableModel(
			new Object[][] {
				{"m\u00E1rio", "21", "abc", "111", "06/03/2024"},
				{"fernando", "30", "cba", "222", "05/09/2450"},
				{"rodrigo", "05", "cab", "333", "12/12/2023"},
				{"ana", "18", "bac", "444", "01/01/2024"},
				{"bia", "25", "bca", "555", "23/11/2024"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Nome", "idade", "registro", "cpf", "data_atendimento"
			}
		));
		Consultas.setBounds(20, 28, 628, 144);
		panel_consultas.add(Consultas);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setScrollPosition(new Point(10, 10));
		scrollPane.setBackground(SystemColor.control);
		scrollPane.setBounds(0, 0, 658, 237);
		panel_consultas.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 105, 97, 235);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton Consultas_button = new JButton("Consultas");
		Consultas_button.setAction(Consultas_show);
		Consultas_button.setBorder(null);
		Consultas_button.setFocusable(false);
		Consultas_button.setFocusTraversalKeysEnabled(false);
		Consultas_button.setFocusPainted(false);
		Consultas_button.setBounds(new Rectangle(3, 3, 3, 3));
		Consultas_button.setBackground(new Color(240, 230, 140));
		Consultas_button.setBounds(10, 22, 79, 58);
		panel_2.add(Consultas_button);
		
		JButton Agendamentos_button = new JButton("Agendamentos");
		Agendamentos_button.setAction(Agendamentos_show);
		Agendamentos_button.setFocusable(false);
		Agendamentos_button.setFocusTraversalKeysEnabled(false);
		Agendamentos_button.setFocusPainted(false);
		Agendamentos_button.setBounds(new Rectangle(3, 3, 3, 3));
		Agendamentos_button.setBorder(null);
		Agendamentos_button.setBackground(new Color(240, 230, 140));
		Agendamentos_button.setBounds(10, 96, 79, 58);
		panel_2.add(Agendamentos_button);
		
		JButton Concluídos_button = new JButton("Concluídos");
		Concluídos_button.setAction(Concluídos_show);
		Concluídos_button.setFocusable(false);
		Concluídos_button.setFocusTraversalKeysEnabled(false);
		Concluídos_button.setFocusPainted(false);
		Concluídos_button.setBounds(new Rectangle(3, 3, 3, 3));
		Concluídos_button.setBorder(null);
		Concluídos_button.setBackground(new Color(240, 230, 140));
		Concluídos_button.setBounds(10, 165, 79, 58);
		panel_2.add(Concluídos_button);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Consultas");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Agendamentos");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "Concluídos");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
