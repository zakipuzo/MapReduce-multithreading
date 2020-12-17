package applications;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import models.Tuple;
import models.TupleCollection;

public class AnagramsReader extends TupleCollection<String,String>
{
  /**
   * Creates a WordCollector from an input text file. Each line
   * in the file should contain a single expression.
   * @param filename The file to read
   */
  public  AnagramsReader(String filename)
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
          super.collect(new Tuple<String,String>(line, ""));
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