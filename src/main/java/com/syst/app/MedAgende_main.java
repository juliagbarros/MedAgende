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
public class MedAgende_main extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private final Action config_action = new SwingAction();
	private final Action Menu_action = new SwingAction_1();
	
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
		panel.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton Configurations_button = new JButton("");
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
		
		JButton Menu_button = new JButton("");
		Menu_button.setAction(Menu_action);
		Menu_button.setIconTextGap(0);
		Menu_button.setFocusable(false);
		Menu_button.setIcon(new ImageIcon("C:\\Users\\overh\\eclipse-workspace\\Med-Agende\\src\\main\\java\\com\\syst\\app\\Button_menu_icon.png"));
		Menu_button.setFocusTraversalKeysEnabled(false);
		Menu_button.setFocusPainted(false);
		Menu_button.setBorder(null);
		Menu_button.setBounds(95, 24, 25, 25);
		panel.add(Menu_button);
		Configurations_button.setBounds(60, 24, 25, 25);
		panel.add(Configurations_button);
		
				
		JLabel Perfil_iconLabel = new JLabel("", new ImageIcon("C:\\Users\\overh\\eclipse-workspace\\Med-Agende\\src\\main\\java\\com\\syst\\app\\perfil_resized.jpg"), JLabel.CENTER);
		Perfil_iconLabel.setBorder(null);
		Perfil_iconLabel.setBounds(new Rectangle(5, 5, 5, 5));
		Perfil_iconLabel.setBounds(10, 9, 40, 40);
		Perfil_iconLabel.setEnabled(false);
		panel.add(Perfil_iconLabel);
		//TODO ajustes de textField.
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setBounds(new Rectangle(3, 3, 3, 3));
		textField_1.setBorder(new MatteBorder(0, 0, 0, 10, (Color) new Color(0, 0, 0)));
		textField_1.setBackground(SystemColor.control);
		textField_1.setBounds(148, 0, 636, 30);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(new Rectangle(3, 3, 3, 3));
		textField.setBackground(UIManager.getColor("CheckBox.background"));
		textField.setBorder(new CompoundBorder(new CompoundBorder(new CompoundBorder(new MatteBorder(0, 0, 0, 10, (Color) new Color(0, 0, 0)), new MatteBorder(0, 0, 10, 0, (Color) new Color(240, 240, 240))), new LineBorder(new Color(240, 240, 240), 3, true)), new BevelBorder(BevelBorder.RAISED, null, new Color(255, 255, 255), new Color(240, 240, 240), new Color(240, 240, 240))));
		textField.setBounds(0, 0, 158, 70);
		panel.add(textField);
		textField.setColumns(10);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(95, 105, 658, 343);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		Label label = new Label("New label");
		label.setBounds(10, 10, 62, 22);
		panel_1.add(label);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setScrollPosition(new Point(10, 10));
		scrollPane.setBackground(SystemColor.control);
		scrollPane.setBounds(0, 0, 658, 393);
		panel_1.add(scrollPane);
		
		Label label_1 = new Label("New label");
		label_1.setBounds(20, 38, 62, 22);
		panel_1.add(label_1);
		
		Label label_2 = new Label("New label");
		label_2.setBounds(35, 76, 62, 22);
		panel_1.add(label_2);
		
		Label label_3 = new Label("New label");
		label_3.setBounds(54, 128, 62, 22);
		panel_1.add(label_3);
		
		Label label_4 = new Label("New label");
		label_4.setBounds(82, 188, 62, 22);
		panel_1.add(label_4);
		
		Label label_5 = new Label("New label");
		label_5.setBounds(92, 214, 62, 22);
		panel_1.add(label_5);
		
		
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
}
