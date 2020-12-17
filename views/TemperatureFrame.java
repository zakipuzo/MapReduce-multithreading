package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import applications.TemperatureMapper;
import applications.TemperatureReader;
import applications.TemperatureReducer;
import applications.WordCountCollection;
import applications.WordCountMapper;
import applications.WordCountReducer;
import models.InCollection;
import models.TupleCollection;
import models.Workflow;

public class TemperatureFrame extends JFrame{
	private JPanel contentPane;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TemperatureFrame(String filepath,int operation) {
				
		System.out.println("WordCount");
	    int k = 1; // We keep only words with at least k letters
	    int n = 1; // We keep only words that appear n times or more
	    Workflow<String,Integer> w = 
	        new Workflow<String,Integer>( // Initialization
	            new TemperatureMapper(), // Mapper
	            new TemperatureReducer(operation), // Reducer
	            new TemperatureReader(filepath) // Reader
	            );
	    // Run the workflow; send results to the InCollector
	    InCollection<String,Integer> results = w.run();
	  
		 
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 743);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane
				
				);
		
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
		
		JTextPane newsTextPane = new JTextPane();
		newsTextPane.setFont(new Font("Calibri", Font.PLAIN, 13));
        newsTextPane.setContentType("text/html");
        newsTextPane.setEditable(false);
         
        
        JScrollPane scrollPane = new JScrollPane(newsTextPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 87, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 62, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -46, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 726, SpringLayout.WEST, contentPane);
		
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                scrollPane.getVerticalScrollBar().setValue(0);

            }
        });
		
		contentPane.add(scrollPane);
		
        
        String htmlresult="";
        results.rewind();
        
        TupleCollection tcol=(TupleCollection)results;
        
        
      /*  Collections.sort(tcol.toList(), new Comparator<Tuple<String,String>>() {
            
			@Override
			public int compare(Tuple<String, String> t1, Tuple<String, String> t2) {
				// TODO Auto-generated method stub
				return Integer.parseInt(t2.getValue())-Integer.parseInt(t1.getValue());
			}
        });
        
      */
        
        while(results.hasNext()){
        
        	htmlresult+="<h4>"+results.next().toString()+"</h4>";
        }
		
        newsTextPane.setText(htmlresult);
		 
		
		JLabel nbrmot = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, nbrmot, 62, SpringLayout.WEST, contentPane);
		nbrmot.setForeground(Color.WHITE);
		nbrmot.setFont(new Font("Arial", Font.BOLD, 23));
		sl_contentPane.putConstraint(SpringLayout.NORTH, nbrmot, 29, SpringLayout.NORTH, contentPane);
		contentPane.add(nbrmot);
		
		this.setLocationRelativeTo(null);
		
		nbrmot.setText(""+results.count()); 
		
		JLabel label = new JLabel("Temp\u00E9rature");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 223, SpringLayout.EAST, nbrmot);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(label);
		//////////# RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRREEEEEEEEEEEEEEEEEEEESSSSSSSSSSSSSSSULT
	 
		 
	}
}
