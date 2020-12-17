package applications;

 
import models.OutCollection;
import models.Reducer;
import models.InCollection;
import models.Tuple;

public class AnagramsReducer  implements Reducer<String,String>
	  {
	    private int m_numWords = 2;

	    public AnagramsReducer(int n)
	    {
	      m_numWords = n;
	    }

	    @Override
	    public void reduce(OutCollection<String,String> out, String key, InCollection<String,String> in)
	    {
	      String word_list = "";
	      int num_words = 0;
	      while (in.hasNext())
	      {
	        num_words++;
	        Tuple<String,String> t = in.next();
	        word_list += (num_words > 1 ? "," : "") + t.getValue();
	      }
	      if (num_words >= m_numWords)
	        out.collect(new Tuple<String,String>(key, word_list));
	    }
	  }