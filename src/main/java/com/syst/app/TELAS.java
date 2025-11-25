package com.syst.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JToggleButton;
import java.awt.Font;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JSlider;
import java.awt.CardLayout;
import java.awt.Panel;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class TELAS {

	private JFrame frame;
	private JTextField txtUserId;
	private JTextField txtEx;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TELAS window = new TELAS();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TELAS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 668, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Digite aqui seu usuário:");
		lblNewLabel_1.setBounds(348, 107, 143, 14);
		panel_1.add(lblNewLabel_1);
		
		txtUserId = new JTextField();
		txtUserId.setToolTipText("Ex: costelinha123@gmail.com");
		txtUserId.setBounds(344, 132, 160, 20);
		panel_1.add(txtUserId);
		txtUserId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 31));
		lblNewLabel_2.setBounds(405, 23, 129, 42);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Não possui cadastro? ");
		lblNewLabel_3.setBounds(374, 396, 130, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cadastrar-se");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		lblNewLabel_4.setBounds(504, 396, 91, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Digite aqui sua senha:");
		lblNewLabel.setBounds(348, 178, 150, 14);
		panel_1.add(lblNewLabel);
		
		txtEx = new JTextField();
		txtEx.setToolTipText("Ex:1234567...");
		txtEx.setBounds(348, 209, 156, 20);
		panel_1.add(txtEx);
		txtEx.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Digite aqui sua Matrícula:");
		lblNewLabel_5.setBounds(348, 253, 150, 14);
		panel_1.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(348, 278, 156, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setForeground(new Color(0, 128, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(405, 359, 129, 28);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("MedAgende");
		lblNewLabel_6.setBackground(new Color(0, 177, 191));
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6.setBounds(0, 23, 308, 416);
		panel_1.add(lblNewLabel_6);
	}
	
	private void initialize() {
		frame2= new JFrame();
		frame2setBounds(100, 100, 668, 479);
		frame2.etDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

