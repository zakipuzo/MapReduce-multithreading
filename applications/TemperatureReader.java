package applications;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import models.Tuple;
import models.TupleCollection;

public class TemperatureReader extends TupleCollection<String,Integer>
{ 
	  public  TemperatureReader(String filename)
	  {
	    super();
	    try
	    {
	      BufferedReader input =  new BufferedReader(new FileReader(filename));
	      try
	      {
	        String line = null;
	        while (( line = input.readLine()) != null)
	        {
	        	
	        	String[] parts = line.split(",");
	        	if(parts.length!=2)
	        	{
	        		continue;
	        	}else{
	        		
	        		if (!Utils.isInteger(parts[1])){
	        			continue;
	        		}
	        	
	        	
	        	int temp=Integer.parseInt(parts[1]);
	        	
	          super.collect(new Tuple<String,Integer>(parts[0], temp));
	        	}
	        }
	      }
	      finally
	      {
	        input.close();
	      }
	    }
	    catch (IOException ex)
	    {
	      ex.printStackTrace();
	    }
	  }
	}