package views;

import applications.AnagramsMapper;
import applications.AnagramsReader;
import applications.AnagramsReducer;
import models.InCollection;
import models.Workflow;

public class AnagramsTest {

	public static void main(String[] args) {
		System.out.println("Anagrams \nYour CPU have "+Runtime.getRuntime().availableProcessors()+" Cores\n");
	    int n = 8; // We look for n-anagrams
	    
	    InCollection<String,String> data = new AnagramsReader("data/English-Dictionary.txt");
	    
	    
	    Workflow<String,String> w = 
	      new Workflow<String,String>(
	        new AnagramsMapper(), // Mapper
	        new AnagramsReducer(n), // Reducer
	        data // Input reader
	        );
	    InCollection<String,String> results = w.run();
	    System.out.println("\nResult");
	    System.out.println("Out of " + data.count() + 
	        " words, there are " + results.count() + " " + n + "-anagrams");
	    System.out.println(results);

	}

}
