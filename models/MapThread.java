package models;

class MapThread<K,V> extends Thread 
{
  
  TupleCollection<K,V> source = new TupleCollection<K,V>();
  TupleCollection<K,V> Thread_Temp_col = new TupleCollection<K,V>();
  Mapper<K,V> Thread_m_mapper = null;
 
  MapThread(TupleCollection<K,V> source, TupleCollection<K,V> temp_coll, Mapper<K,V> m_mapper) 
  {
    this.source = source;
    this.Thread_Temp_col = temp_coll;
    this.Thread_m_mapper = m_mapper;
  }
 
  public void run() 
  {
	  int i=0;
	  while(source.hasNext()){
		  Tuple<K,V> t=source.next();
		  i++;
		  Thread_m_mapper.map(Thread_Temp_col, t);
	}
	  System.out.println("I will map "+i +" tuples");
   
  }
}
