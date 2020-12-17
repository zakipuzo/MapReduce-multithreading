package applications;

import models.Mapper;
import models.OutCollection;
import models.Tuple;

public   class WordCountMapper implements Mapper<String,String>
{
  private int m_minLetters = 1;


  public WordCountMapper(int k)
  {
    m_minLetters = k;
  }

  @Override
  public void map(OutCollection<String,String> out, Tuple<String,String> t)
  {
    String[] words = t.getKey().split(" ");
    for (String w : words)
    {
  	 
      // Remove punctuation and convert to lowercase
      String new_w = w.toLowerCase();
      new_w = new_w.replaceAll("[^\\w]", "");
      if (new_w.length() >= m_minLetters)
        out.collect(new Tuple<String,String>(new_w, "1"));
    }
  }
}
