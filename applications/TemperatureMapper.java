package applications;

import java.util.Arrays;

import models.Mapper;
import models.OutCollection;
import models.Tuple;

public class TemperatureMapper  implements Mapper<String,Integer>
{
	  @Override
	  public void map(OutCollection<String,Integer> out, Tuple<String,Integer> t)
	  {
	    
	    out.collect(t);
	  }
	}