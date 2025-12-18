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
		
		JButton configurations_button = new JButton("");
		configurations_button.setBounds(60, 24, 25, 25);
		configurations_button.setAction(config_action);
		configurations_button.setFocusable(false);
		configurations_button.setFocusTraversalKeysEnabled(false);
		configurations_button.setFocusPainted(false);
		configurations_button.setIcon(new ImageIcon("C:\\Users\\overh\\eclipse-workspace\\Med-Agende\\src\\main\\java\\com\\syst\\app\\Button_config_icon.png"));
		configurations_button.setBorder(null);
		configurations_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.setLayout(null);
		
		JButton menu_button = new JButton("");
		menu_button.setBounds(95, 24, 25, 25);
		menu_button.setAction(Menu_action);
		menu_button.setIconTextGap(0);
		menu_button.setFocusable(false);
		menu_button.setIcon(new ImageIcon("C:\\Users\\overh\\eclipse-workspace\\Med-Agende\\src\\main\\java\\com\\syst\\app\\Button_menu_icon.png"));
		menu_button.setFocusTraversalKeysEnabled(false);
		menu_button.setFocusPainted(false);
		menu_button.setBorder(null);
		panel.add(menu_button);
		panel.add(configurations_button);
			
		JLabel perfil_iconLabel = new JLabel("", new ImageIcon("C:\\Users\\overh\\eclipse-workspace\\Med-Agende\\src\\main\\java\\com\\syst\\app\\perfil_resized.jpg"), JLabel.CENTER);
		perfil_iconLabel.setBounds(10, 9, 40, 40);
		perfil_iconLabel.setBorder(null);
		perfil_iconLabel.setEnabled(false);
		panel.add(perfil_iconLabel);
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
		
		JLabel data_nascimento_table = DefaultComponentFactory.getInstance().createLabel("Data_nascimento");
		data_nascimento_table.setBounds(522, 11, 126, 14);
		panel_consultas.add(data_nascimento_table);
		
		JLabel cpf_table = DefaultComponentFactory.getInstance().createLabel("CPF");
		cpf_table.setBounds(395, 11, 132, 14);
		panel_consultas.add(cpf_table);
		
		JLabel registro_table = DefaultComponentFactory.getInstance().createLabel("Registro");
		registro_table.setBounds(270, 11, 126, 14);
		panel_consultas.add(registro_table);
		
		JLabel idade_table = DefaultComponentFactory.getInstance().createLabel("Idade");
		idade_table.setBounds(145, 11, 126, 14);
		panel_consultas.add(idade_table);
		
		JLabel nomes_table = DefaultComponentFactory.getInstance().createLabel("Nome");
		nomes_table.setBounds(20, 11, 126, 14);
		panel_consultas.add(nomes_table);
		
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
		
		JButton consultas_button = new JButton("Consultas");
		consultas_button.setAction(Consultas_show);
		consultas_button.setBorder(null);
		consultas_button.setFocusable(false);
		consultas_button.setFocusTraversalKeysEnabled(false);
		consultas_button.setFocusPainted(false);
		consultas_button.setBounds(new Rectangle(3, 3, 3, 3));
		consultas_button.setBackground(new Color(240, 230, 140));
		consultas_button.setBounds(10, 22, 79, 58);
		panel_2.add(consultas_button);
		
		JButton agendamentos_button = new JButton("Agendamentos");
		agendamentos_button.setAction(Agendamentos_show);
		agendamentos_button.setFocusable(false);
		agendamentos_button.setFocusTraversalKeysEnabled(false);
		agendamentos_button.setFocusPainted(false);
		agendamentos_button.setBounds(new Rectangle(3, 3, 3, 3));
		agendamentos_button.setBorder(null);
		agendamentos_button.setBackground(new Color(240, 230, 140));
		agendamentos_button.setBounds(10, 96, 79, 58);
		panel_2.add(agendamentos_button);
		
		JButton concluidos_button = new JButton("Concluídos");
		concluidos_button.setAction(Concluídos_show);
		concluidos_button.setFocusable(false);
		concluidos_button.setFocusTraversalKeysEnabled(false);
		concluidos_button.setFocusPainted(false);
		concluidos_button.setBounds(new Rectangle(3, 3, 3, 3));
		concluidos_button.setBorder(null);
		concluidos_button.setBackground(new Color(240, 230, 140));
		concluidos_button.setBounds(10, 165, 79, 58);
		panel_2.add(concluidos_button);
		
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
