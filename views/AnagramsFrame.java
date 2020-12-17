package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import applications.AnagramsMapper;
import applications.AnagramsReader;
import applications.AnagramsReducer;
import models.InCollection;
import models.TupleCollection;
import models.Workflow;

import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class AnagramsFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnClose;

	 
	public AnagramsFrame(String filepath, int minanagrams) {
				
		 System.out.println("Anagrams \nYour CPU have "+Runtime.getRuntime().availableProcessors()+" Cores\n");
		    int n = 8; // We look for n-anagrams
		   
		    Workflow<String,String> w = 
		      new Workflow<String,String>(
		        new AnagramsMapper(), // Mapper
		        new AnagramsReducer(n), // Reducer
		        new AnagramsReader(filepath) // Input reader
		        );
		    InCollection<String,String> results = w.run();
		    System.out.println("\nResult");
		    System.out.println("Out of " + results.count() + 
		        " words, there are " + results.count() + " " + n + "-anagrams");
		    System.out.println(results);
		 
			
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
		btnClose.setFont(new Font("Raleway ExtraBold", Font.BOLD, 18));
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
        
        	htmlresult+="<h3>"+results.next().toString()+"</h3>";
        }
        
       // newsTextPane.setText(results.toString());
        
        newsTextPane.setText(htmlresult);
        
        
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
		
		JLabel nbrmot = new JLabel("");
		nbrmot.setForeground(Color.WHITE);
		nbrmot.setFont(new Font("Calibri Light", Font.BOLD, 23));
		sl_contentPane.putConstraint(SpringLayout.NORTH, nbrmot, 29, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, nbrmot, 0, SpringLayout.WEST, scrollPane);
		contentPane.add(nbrmot);
		
		this.setLocationRelativeTo(null);
		
		nbrmot.setText(""+results.count()); 
		
		JLabel label = new JLabel("Anagrams");
		sl_contentPane.putConstraint(SpringLayout.NORTH, label, 0, SpringLayout.NORTH, nbrmot);
		sl_contentPane.putConstraint(SpringLayout.WEST, label, 266, SpringLayout.EAST, nbrmot);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(label);
		
	}
}
