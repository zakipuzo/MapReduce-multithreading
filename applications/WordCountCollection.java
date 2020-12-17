package applications;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import models.Tuple;
import models.TupleCollection;

public  class WordCountCollection extends TupleCollection<String,String>
{
	public  WordCountCollection(String filename)
  {
		
		  super();
    StringBuffer sb = new StringBuffer();
    try
    {
      BufferedReader input =  new BufferedReader(new FileReader(filename));
      try
      {
        String line = null;
        while (( line = input.readLine()) != null)
        {
        //  sb.append(line.trim()).append(" ");
      	  super.collect(new Tuple<String,String>(line.trim(), ""));
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
   // super.collect(new Tuple<String,String>(sb.toString(), ""));
  }
		 
 

  

}