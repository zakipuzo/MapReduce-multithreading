package views;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class AnagramsOptions extends JFrame {
	private JButton btnClose;
	private JPanel contentPane;
	public AnagramsOptions() {
		setBounds(100, 100, 1000, 678);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 743);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		 btnClose = new JButton("Fermer");
		 btnClose.setFocusPainted(false);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnClose.setFont(new Font("Arial", Font.BOLD, 18));
		btnClose.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnClose, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnClose, -10, SpringLayout.EAST, contentPane);
		
		btnClose.setContentAreaFilled(false);
		btnClose.setBackground(Color.RED);
		btnClose.setOpaque(true);
		contentPane.add(btnClose);
		
		
		JButton btnchose = new JButton("Choisir fichier");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnchose, 198, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnchose, 290, SpringLayout.WEST, contentPane);
	
		springLayout.putConstraint(SpringLayout.WEST, btnchose, 53, SpringLayout.WEST, getContentPane());
		getContentPane().add(btnchose);
		
		
		JLabel lblAu = new JLabel("Occurence");
		lblAu.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblAu, -73, SpringLayout.NORTH, btnchose);
		springLayout.putConstraint(SpringLayout.NORTH, lblAu, 53, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblAu, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblAu);
		String [] nums = new String[100] ;
		for(int i=0;i<100;i++){
			nums[i]=""+(i+1);
			
		}
		
		JComboBox occurencecombo = new JComboBox(nums);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAu, -33, SpringLayout.WEST, occurencecombo);
		sl_contentPane.putConstraint(SpringLayout.EAST, occurencecombo, 456, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, occurencecombo, 365, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, occurencecombo, -69, SpringLayout.NORTH, btnchose);
		springLayout.putConstraint(SpringLayout.SOUTH, occurencecombo, -313, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnchose, 55, SpringLayout.SOUTH, occurencecombo);
		springLayout.putConstraint(SpringLayout.WEST, occurencecombo, 48, SpringLayout.EAST, lblAu);
		springLayout.putConstraint(SpringLayout.EAST, occurencecombo, 97, SpringLayout.EAST, lblAu);
		getContentPane().add(occurencecombo);
		
		JLabel lblAnagrams = new JLabel("Anagrams");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblAnagrams, 24, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblAnagrams, 0, SpringLayout.EAST, btnchose);
		lblAnagrams.setForeground(Color.WHITE);
		lblAnagrams.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblAnagrams);
		
		
		
		btnchose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
				JFileChooser chooser=new JFileChooser();
				chooser.setFileFilter(filter);
				int returnval=chooser.showOpenDialog(null);
				if(returnval==JFileChooser.APPROVE_OPTION){
					String text="";
					String path=chooser.getSelectedFile().getPath();
				/*chosenTitle.setText(chooser.getSelectedFile().getPath());
				File file = new File(path);*/
				AnagramsFrame f=new AnagramsFrame(path,Integer.parseInt(occurencecombo.getSelectedItem().toString()));
				System.out.println("hahahahah "+Integer.parseInt(occurencecombo.getSelectedItem().toString()));
				f.setVisible(true);
				
				}
				
				
			}
		});
		
		 
	}
}
