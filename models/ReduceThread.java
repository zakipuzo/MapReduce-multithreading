package models;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class ReduceThread<K,V> extends Thread 
{
 
  TupleCollection<K,V> outThread = new TupleCollection<K,V>();
  Map<K,TupleCollection<K,V>> Threadshuffle = new HashMap<K,TupleCollection<K,V>>();
  TupleCollection<K,V> Thread_s_source = new TupleCollection<K,V>();
  Reducer<K,V> Thread_m_reducer = null;

 
  ReduceThread(TupleCollection<K,V> out, Map<K,TupleCollection<K,V>> shuffle,  Reducer<K,V> m_reducer) 
  {
    this.outThread = out;
    this.Threadshuffle = shuffle;
    this.Thread_m_reducer = m_reducer;
  }
 
  public void run() 
  {System.out.println("I will Reduce a map with "+Threadshuffle.size()+" Key Values");
	  Set<K> keys = Threadshuffle.keySet();
		for (K key : keys)
		{
			TupleCollection<K,V> s_source = Threadshuffle.get(key);
			
			Thread_m_reducer.reduce(outThread, key, s_source);
		}
    
  }
}
