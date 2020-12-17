package views;

import applications.TemperatureMapper;
import applications.TemperatureReader;
import applications.TemperatureReducer;
import applications.WordCountCollection;
import applications.WordCountMapper;
import applications.WordCountReducer;
import models.InCollection;
import models.Workflow;

public class temptest {
	public static void main(String[] args) {
		
		int n=1;//for max
		 Workflow<String,Integer> w = 
			        new Workflow<String,Integer>( // Initialisation
			            new TemperatureMapper(), // Mapper
			            new TemperatureReducer(2), // Reducer
			            new TemperatureReader("data/data.txt") // Reader
			            );
		 
			    // Run the workflow; send results to the InCollector
			    InCollection<String,Integer> results = w.run();
			    System.out.println("\nResult");
			    
			     
			    System.out.println(results);
	}
}
