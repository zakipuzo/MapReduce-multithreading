package applications;

import models.InCollection;
import models.OutCollection;
import models.Reducer;
import models.Tuple;

public class TemperatureReducer implements Reducer<String,Integer>
{
	
	//*ici operation sigifie le traitement
	// 1 == temp max
	// 2 == temp min
	
	//3 ==temp moyenne
    private int operation = 1;;

    public TemperatureReducer(int n)
    {
    	operation = n;
    }

    @Override
    public void reduce(OutCollection<String,Integer> out, String key, InCollection<String,Integer> in)
    {
      String word_list = "";
      int temp = -200;
      int somme=0; 
      int result=0;
      while (in.hasNext())
      {
    	 switch(operation){
    	 case 1: {
    		 Tuple<String,Integer> t = in.next();
    		 int temperature=t.getValue();
    	        if(t.getValue()>temp){
    	        	temp=t.getValue();
    	        }
    	        break;}
    	 case 2:{
    		 Tuple<String,Integer> t = in.next();
    		 int temperature=t.getValue();
    	        if(t.getValue()>temp){
    	        	temp=t.getValue();
    	        }
    	        break;}
    	 case 3:{
    		 Tuple<String,Integer> t = in.next();
    		 int temperature=t.getValue();
    	        if(t.getValue()>temp){
    	        	somme+=t.getValue();
    	        }
    	        break;
    	 }
    	 
    	 }
        
      }
      if(operation==3 && in.count()>0){
    	  result=somme/in.count();
    	  
      }else{
    	  result=temp;
      }
     
        out.collect(new Tuple<String,Integer>(key, result));
    }
  }