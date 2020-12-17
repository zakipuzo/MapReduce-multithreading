package views;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class TemperatureOptions extends JFrame {
	private JPanel contentPane;
	private JButton btnClose;
	public TemperatureOptions() {
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
		
		
		JRadioButton min = new JRadioButton("MIN");
		springLayout.putConstraint(SpringLayout.NORTH, min, 32, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, min, 40, SpringLayout.WEST, getContentPane());
		min.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(min);
		min.setSelected(true);
		
		JRadioButton max = new JRadioButton("MAX");
		sl_contentPane.putConstraint(SpringLayout.WEST, max, 310, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, min, 0, SpringLayout.NORTH, max);
		sl_contentPane.putConstraint(SpringLayout.EAST, min, -24, SpringLayout.WEST, max);
		springLayout.putConstraint(SpringLayout.NORTH, max, 6, SpringLayout.SOUTH, min);
		springLayout.putConstraint(SpringLayout.WEST, max, 0, SpringLayout.WEST, min);
		getContentPane().add(max);
		
		JRadioButton moyenne = new JRadioButton("MOYENNE");
		sl_contentPane.putConstraint(SpringLayout.NORTH, moyenne, 0, SpringLayout.NORTH, min);
		sl_contentPane.putConstraint(SpringLayout.WEST, moyenne, 17, SpringLayout.EAST, max);
		springLayout.putConstraint(SpringLayout.NORTH, moyenne, 0, SpringLayout.SOUTH, max);
		springLayout.putConstraint(SpringLayout.WEST, moyenne, 0, SpringLayout.WEST, min);
		getContentPane().add(moyenne);
		
		ButtonGroup group = new ButtonGroup();
		group.add(min);
		group.add(max);
		group.add(moyenne);
		
		 btnClose = new JButton("Fermer");
		 btnClose.setFocusPainted(false);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		btnClose.setFont(new Font("Raleway ExtraBold", Font.BOLD, 18));
		btnClose.setForeground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnClose, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnClose, -10, SpringLayout.EAST, contentPane);
		
		btnClose.setContentAreaFilled(false);
		btnClose.setBackground(Color.RED);
		btnClose.setOpaque(true);
		contentPane.add(btnClose);
		
		JButton chosefilebtn = new JButton("Choisir fichier");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, max, -61, SpringLayout.NORTH, chosefilebtn);
		sl_contentPane.putConstraint(SpringLayout.NORTH, chosefilebtn, 194, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, chosefilebtn, 275, SpringLayout.WEST, contentPane);
		chosefilebtn.addActionListener(new ActionListener() {
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
					int op=1;
				 if(max.isSelected()){
					 op=2;
				 }else if(moyenne.isSelected()){
					 op=3;
				 }
				TemperatureFrame f=new TemperatureFrame(path,op);
				
				f.setVisible(true);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, chosefilebtn, 60, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, chosefilebtn, -104, SpringLayout.EAST, getContentPane());
		getContentPane().add(chosefilebtn);
		
		JLabel lblNewLabel = new JLabel("Operation");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, max);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -24, SpringLayout.NORTH, max);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, min);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, min);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTemprature = new JLabel("Temp\u00E9rature");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTemprature, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTemprature, 0, SpringLayout.WEST, min);
		lblTemprature.setForeground(Color.WHITE);
		lblTemprature.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(lblTemprature);
	}

}
