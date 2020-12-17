package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


import java.awt.Rectangle;
import javax.swing.SpringLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Cursor;
import javax.swing.SwingConstants;

public class mainFrame extends JFrame {

	private JPanel contentPane;
	JLabel chosenTitle;
	JButton btnWordcount;
	JButton btnanagrams;
	JButton btnClose;
	JButton btnchose;
	
	//Mapper mapper;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	
	public mainFrame() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		//For buttons borders
		Border emptyBorder = BorderFactory.createEmptyBorder();
		
		setTitle("Map Reduce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 678);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		 btnWordcount = new JButton("Word Count");
		 sl_contentPane.putConstraint(SpringLayout.WEST, btnWordcount, 85, SpringLayout.WEST, contentPane);
		 btnWordcount.setForeground(Color.WHITE);
		 btnWordcount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 btnWordcount.setFocusTraversalKeysEnabled(false);
		 btnWordcount.setFocusPainted(false);
		btnWordcount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 //btnchose.setVisible(true);
				WordCountOptions w=new WordCountOptions();
				w.setVisible(true);
			}
		});
		btnWordcount.setFont(new Font("Arial", Font.BOLD, 23));
		btnWordcount.setContentAreaFilled(false);
		btnWordcount.setBackground(Color.BLUE);
		btnWordcount.setOpaque(true);
		btnWordcount.setBorder(emptyBorder);
		contentPane.add(btnWordcount);
		
		////////////
		 btnanagrams = new JButton("Anagrams");
		 sl_contentPane.putConstraint(SpringLayout.WEST, btnanagrams, 373, SpringLayout.WEST, contentPane);
		 sl_contentPane.putConstraint(SpringLayout.EAST, btnanagrams, -408, SpringLayout.EAST, contentPane);
		 sl_contentPane.putConstraint(SpringLayout.NORTH, btnWordcount, 0, SpringLayout.NORTH, btnanagrams);
		 sl_contentPane.putConstraint(SpringLayout.EAST, btnWordcount, -79, SpringLayout.WEST, btnanagrams);
		 btnanagrams.setForeground(Color.WHITE);
		 btnanagrams.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 btnanagrams.setFocusPainted(false);
		btnanagrams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnagramsOptions ano=new AnagramsOptions();
				ano.setVisible(true);
			 
			}
		});
		btnanagrams.setFont(new Font("Arial", Font.PLAIN, 23));
		btnanagrams.setContentAreaFilled(false);
		btnanagrams.setBackground(Color.BLUE);
		btnanagrams.setOpaque(true);
		btnanagrams.setBorder(emptyBorder);
		contentPane.add(btnanagrams);
		
		
		/////////////////
		 btnClose = new JButton("Quitter");
		 btnClose.setFocusPainted(false);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setFont(new Font("Raleway ExtraBold", Font.BOLD, 18));
		btnClose.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnClose, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnClose, -10, SpringLayout.EAST, contentPane);
		
		btnClose.setContentAreaFilled(false);
		btnClose.setBackground(Color.RED);
		btnClose.setOpaque(true);
		btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnClose);
		
		//////////
		JLabel lblMapReduce = new JLabel("Map Reduce");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnanagrams, 116, SpringLayout.SOUTH, lblMapReduce);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnanagrams, 246, SpringLayout.SOUTH, lblMapReduce);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblMapReduce, 44, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblMapReduce, 390, SpringLayout.WEST, contentPane);
		lblMapReduce.setForeground(new Color(255, 255, 255));
		lblMapReduce.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblMapReduce);
		
		/////////////BUTTON CHOOOOOSE
		 btnchose = new JButton("Selectionner un fichier");
		 sl_contentPane.putConstraint(SpringLayout.NORTH, btnchose, 479, SpringLayout.NORTH, contentPane);
		 sl_contentPane.putConstraint(SpringLayout.WEST, btnchose, -654, SpringLayout.EAST, contentPane);
		 sl_contentPane.putConstraint(SpringLayout.EAST, btnchose, -330, SpringLayout.EAST, contentPane);
		 btnchose.setForeground(Color.WHITE);
		 btnchose.setFont(new Font("Arial", Font.PLAIN, 20));
		 btnchose.setContentAreaFilled(false);
		 btnchose.setBackground(new Color(0, 102, 204));
		 btnchose.setOpaque(true);
		 btnchose.setBorder(emptyBorder);
		btnchose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				
				
				
				
			}
		});
		btnchose.setVisible(false);
		contentPane.add(btnchose);
		
		 chosenTitle = new JLabel("Aucun fichier s\u00E9lectionn\u00E9");
		 sl_contentPane.putConstraint(SpringLayout.SOUTH, btnWordcount, -255, SpringLayout.NORTH, chosenTitle);
		 sl_contentPane.putConstraint(SpringLayout.NORTH, chosenTitle, 580, SpringLayout.NORTH, contentPane);
		 sl_contentPane.putConstraint(SpringLayout.SOUTH, btnchose, -40, SpringLayout.NORTH, chosenTitle);
		 sl_contentPane.putConstraint(SpringLayout.WEST, chosenTitle, 179, SpringLayout.WEST, contentPane);
		 sl_contentPane.putConstraint(SpringLayout.EAST, chosenTitle, -170, SpringLayout.EAST, contentPane);
		 chosenTitle.setHorizontalAlignment(SwingConstants.CENTER);
		chosenTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		chosenTitle.setForeground(new Color(255, 255, 255));
		chosenTitle.setVisible(false);
		contentPane.add(chosenTitle);
		
		JButton btntemperature = new JButton("Temp\u00E9rature");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btntemperature, 0, SpringLayout.NORTH, btnWordcount);
		sl_contentPane.putConstraint(SpringLayout.WEST, btntemperature, 68, SpringLayout.EAST, btnanagrams);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btntemperature, -255, SpringLayout.NORTH, chosenTitle);
		sl_contentPane.putConstraint(SpringLayout.EAST, btntemperature, -138, SpringLayout.EAST, contentPane);
		btntemperature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TemperatureOptions w=new TemperatureOptions();
				w.setVisible(true);
			}
		});
		
		btntemperature.setBorder(emptyBorder);
		btntemperature.setForeground(Color.WHITE);
		btntemperature.setFont(new Font("Arial", Font.BOLD, 23));
		btntemperature.setBackground(Color.BLUE);
		btntemperature.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btntemperature);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
	}
}
