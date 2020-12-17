package views;

 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WordCountOptions extends JFrame{
	private JButton btnClose;
	private JPanel contentPane;

	public WordCountOptions() {
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		setBounds(100, 100, 1000, 678);
		

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
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnchose, 224, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnchose, 306, SpringLayout.WEST, contentPane);
	
		getContentPane().add(btnchose);
		String [] nums = new String[100] ;
		for(int i=0;i<100;i++){
			nums[i]=""+(i+1);
			
		}
		
		JComboBox occurencemot = new JComboBox(nums);
		sl_contentPane.putConstraint(SpringLayout.EAST, occurencemot, -534, SpringLayout.EAST, contentPane);
		springLayout.putConstraint(SpringLayout.EAST, occurencemot, -636, SpringLayout.EAST, getContentPane());
		getContentPane().add(occurencemot);
		 
		
		
		JLabel lblNombreDeLettre = new JLabel("Nombre de lettre minimal");
		lblNombreDeLettre.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, btnchose, -4, SpringLayout.NORTH, lblNombreDeLettre);
		springLayout.putConstraint(SpringLayout.NORTH, lblNombreDeLettre, 90, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNombreDeLettre, 32, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNombreDeLettre);
		
		JLabel lblNombreDoccurenceMinimal = new JLabel("Nombre d'occurence minimal");
		sl_contentPane.putConstraint(SpringLayout.WEST, occurencemot, 46, SpringLayout.EAST, lblNombreDoccurenceMinimal);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNombreDoccurenceMinimal, 4, SpringLayout.NORTH, occurencemot);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNombreDoccurenceMinimal, 0, SpringLayout.EAST, lblNombreDeLettre);
		lblNombreDoccurenceMinimal.setForeground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, occurencemot, -4, SpringLayout.NORTH, lblNombreDoccurenceMinimal);
		springLayout.putConstraint(SpringLayout.WEST, occurencemot, 39, SpringLayout.EAST, lblNombreDoccurenceMinimal);
		springLayout.putConstraint(SpringLayout.WEST, lblNombreDoccurenceMinimal, 32, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, lblNombreDoccurenceMinimal, 22, SpringLayout.SOUTH, lblNombreDeLettre);
		getContentPane().add(lblNombreDoccurenceMinimal);
		String [] numspourlettre = new String[40] ;
		for(int i=0;i<40;i++){
			numspourlettre[i]=""+(i+1);
			
		}
		JComboBox nbrlettre = new JComboBox(numspourlettre);
		sl_contentPane.putConstraint(SpringLayout.NORTH, occurencemot, 23, SpringLayout.SOUTH, nbrlettre);
		sl_contentPane.putConstraint(SpringLayout.NORTH, nbrlettre, 105, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, nbrlettre, 316, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, nbrlettre, -510, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNombreDeLettre, 4, SpringLayout.NORTH, nbrlettre);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNombreDeLettre, -46, SpringLayout.WEST, nbrlettre);
		springLayout.putConstraint(SpringLayout.WEST, btnchose, 97, SpringLayout.EAST, nbrlettre);
		springLayout.putConstraint(SpringLayout.NORTH, nbrlettre, -4, SpringLayout.NORTH, lblNombreDeLettre);
		springLayout.putConstraint(SpringLayout.WEST, nbrlettre, 0, SpringLayout.WEST, occurencemot);
		springLayout.putConstraint(SpringLayout.SOUTH, nbrlettre, -13, SpringLayout.NORTH, occurencemot);
		springLayout.putConstraint(SpringLayout.EAST, nbrlettre, -636, SpringLayout.EAST, getContentPane());
		nbrlettre.setSelectedIndex(4);
		getContentPane().add(nbrlettre);
		
		JLabel lblWordcount = new JLabel("WordCount");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblWordcount, 224, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblWordcount, -34, SpringLayout.NORTH, nbrlettre);
		lblWordcount.setForeground(Color.WHITE);
		lblWordcount.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblWordcount);
		
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
				WordCountFrame f=new WordCountFrame(path,
						Integer.parseInt(nbrlettre.getSelectedItem().toString()),
						Integer.parseInt(occurencemot.getSelectedItem().toString()));
				
				f.setVisible(true);
				
				}
				
				
			}
		});
	}
}
