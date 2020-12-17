package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import applications.WordCountCollection;
import applications.WordCountMapper;
import applications.WordCountReducer;
import models.InCollection;
import models.Tuple;
import models.TupleCollection;
import models.Workflow;

import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class WordCountFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public WordCountFrame(String filepath,int nombrelettreMin,int occurenceMin) {
				
		System.out.println("WordCount");
	    int k = 1; // We keep only words with at least k letters
	    int n = 1; // We keep only words that appear n times or more
	    Workflow<String,String> w = 
	        new Workflow<String,String>( // Initialization
	            new WordCountMapper(nombrelettreMin), // Mapper
	            new WordCountReducer(occurenceMin), // Reducer
	            new WordCountCollection(filepath) // Reader
	            );
	    // Run the workflow; send results to the InCollector
	    InCollection<String,String> results = w.run();
	    System.out.println("\nResult");
	    
	    String info="" + results.count() + 
	        " mot(s) " ;
	    System.out.println("There are " + results.count() + 
	        " word(s) of at least " + k + 
	        " letter(s) that appear at least " + n + " times");
	    // Iterator over InCollector to display results
	    System.out.println(results);
	    
		 
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
		//////////# RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRREEEEEEEEEEEEEEEEEEEESSSSSSSSSSSSSSSULT
		
		JTextPane newsTextPane = new JTextPane();
		newsTextPane.setFont(new Font("Calibri", Font.PLAIN, 13));
        newsTextPane.setContentType("text/html");
        newsTextPane.setEditable(false);
        
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
        
        
        
        
		JScrollPane scrollPane = new JScrollPane(newsTextPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 87, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 62, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -45, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 499, SpringLayout.WEST, contentPane);
		
		SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                scrollPane.getVerticalScrollBar().setValue(0);

            }
        });
		
		contentPane.add(scrollPane);
		
		JLabel nbrmot = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, nbrmot, 62, SpringLayout.WEST, contentPane);
		nbrmot.setForeground(Color.WHITE);
		nbrmot.setFont(new Font("Arial", Font.BOLD, 23));
		sl_contentPane.putConstraint(SpringLayout.NORTH, nbrmot, 29, SpringLayout.NORTH, contentPane);
		contentPane.add(nbrmot);
		
		this.setLocationRelativeTo(null);
		
		nbrmot.setText(info); 
		
		JLabel label = new JLabel("WordCount");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, -6, SpringLayout.NORTH, nbrmot);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 157, SpringLayout.EAST, nbrmot);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(label);
		
	}
}
