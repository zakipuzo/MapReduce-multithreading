package views;

import applications.WordCountCollection;
import applications.WordCountMapper;
import applications.WordCountReducer;
import models.InCollection;
import models.Workflow;

public class WordCountTest {

	public static void main(String[] args) {
		 
		System.out.println("WordCount");
	    int k = 1; // on ne laise que les mot avec  k lettres
	    int n = 1; // on ne laise que les mots qui apparaissent n fois ou plus
	    
	    Workflow<String,String> w = 
	        new Workflow<String,String>( // Initialisation
	            new WordCountMapper(k), // Mapper
	            new WordCountReducer(n), // Reducer
	            new WordCountCollection("data/English-Dictionary.txt") // Reader
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
	}

}
