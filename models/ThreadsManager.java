package models;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreadsManager<K,V> {
	
	public final int ThreadsNumber=3;
	
	public static int CoresNumber;
	 
	
	
	public ThreadsManager() {
		
		}
	
	public void startMap() {
		
		
	}
	
	public List<MapThread<K,V>> getMapThreads(InCollection<K,V> m_source, TupleCollection<K,V> out, Mapper<K,V> m_mapper){
		
		TupleCollection<K,V> Col1=new TupleCollection<K,V>();
		TupleCollection<K,V> Col2=new TupleCollection<K,V>();
		TupleCollection<K,V> Col3=new TupleCollection<K,V>();
		
		int tuplecount=m_source.count();
		int j=0;
		while (m_source.hasNext()){
			if(j<=tuplecount/ThreadsNumber)
				Col1.collect(m_source.next());
			else if(j<=(2*tuplecount)/ThreadsNumber)
				Col2.collect(m_source.next());
			else if(j<=tuplecount){
				Col3.collect(m_source.next());
			}
			
			j++;
		}
		
		  List<MapThread<K,V>> MapThreads =null;
		
		MapThreads=new LinkedList<MapThread<K,V>>();
		
		if(Col1.count()>0)
		MapThreads.add(new MapThread<K,V>(Col1, out, m_mapper));
		if(Col2.count()>0)
		MapThreads.add(new MapThread<K,V>(Col2, out, m_mapper));
		if(Col3.count()>0)
		MapThreads.add(new MapThread<K,V>(Col3, out, m_mapper));
		
		return MapThreads;
	}
	


	public List<ReduceThread<K,V>> getReduceThreads(TupleCollection<K,V> out,  Map<K,TupleCollection<K,V>> shuffle, Reducer<K,V> m_reducer)
	  {	
		Map<K,TupleCollection<K,V>> MapCol1=new HashMap<K,TupleCollection<K,V>>();
		Map<K,TupleCollection<K,V>> MapCol2=new HashMap<K,TupleCollection<K,V>>();
		Map<K,TupleCollection<K,V>> MapCol3=new HashMap<K,TupleCollection<K,V>>();
		
		Set<K> keys = shuffle.keySet();
		int size=shuffle.size();
		int i=0;
		for (K key : keys)
		{
			TupleCollection<K,V> s_source = shuffle.get(key);
			if(i<=size/3)
				MapCol1.put(key, s_source);
			else if(i<=(2*size/3))
				MapCol2.put(key, s_source);
			else if(i<=size)
				MapCol3.put(key, s_source);
			
			i++;
			 
		}
		
		   List<ReduceThread<K,V>> ReduceThreads=null;
		ReduceThreads=new LinkedList<ReduceThread<K,V>>();
		
		if(MapCol1.size()>0)
			ReduceThreads.add(new ReduceThread<K,V>(out, MapCol1, m_reducer));
		if(MapCol2.size()>0)
			ReduceThreads.add(new ReduceThread<K,V>(out, MapCol2, m_reducer));
		if(MapCol3.size()>0)
			ReduceThreads.add(new ReduceThread<K,V>(out, MapCol3, m_reducer));
		
		
	
	
	return ReduceThreads;
}

}

 

