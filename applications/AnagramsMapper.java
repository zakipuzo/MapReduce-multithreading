package applications;

import java.util.Arrays;

import models.Mapper;
import models.OutCollection;
import models.Tuple;
 

public  class AnagramsMapper implements Mapper<String,String>
{
  @Override
  public void map(OutCollection<String,String> out, Tuple<String,String> t)
  {
	  String[] words = t.getKey().split(" ");
	  
	  for (String w : words)
	    {
		  if(w=="" || w==",")
			  continue;
		  String new_w = w.toLowerCase();
	      
		  char[] wordChars = new_w.toCharArray();
		    Arrays.sort(wordChars);
		   
		    String sortedWord = new String(wordChars);
		    out.collect(new Tuple<String,String>(sortedWord, w));
	    }
	   
   
  }
}