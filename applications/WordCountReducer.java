package applications;

import models.InCollection;
import models.OutCollection;
import models.Reducer;
import models.Tuple;

public  class WordCountReducer implements Reducer<String,String>
{
  private int m_numOccurrences = 2;

  
  public WordCountReducer(int n)
  {
    m_numOccurrences = n;
  }

  @Override
  public void reduce(OutCollection<String,String> out, String key, InCollection<String,String> values)
  {// in  houma les values dir bihouù li bghiti
    int num_words = values.count();
    if (num_words >= m_numOccurrences)
      out.collect(new Tuple<String,String>(key, "" + String.valueOf(num_words)));
  }
}
