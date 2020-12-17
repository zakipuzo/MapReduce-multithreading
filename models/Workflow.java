package models;

import java.util.*;
 
public class Workflow<K,V> 
{
	private Mapper<K,V> m_mapper = null;
	private Reducer<K,V> m_reducer = null;
	private InCollection<K,V> m_source = null;
 
	protected long m_totalTuples = 0;
 
	protected long m_maxTuples = 0;
	
	 
	public Workflow(Mapper<K,V> m, Reducer<K,V> r, InCollection<K,V> c)
	{
		super();
		setMapper(m);
		setReducer(r);
		setSource(c);
	}
	
	public void setMapper(Mapper<K,V> m)
	{
		m_mapper = m;
	}
	
	public void setReducer(Reducer<K,V> r)
	{
		m_reducer = r;
	}
	
	public void setSource(InCollection<K,V> c)
	{
		m_source = c;
	}
	
	public InCollection<K,V> run()
	{
		if (m_mapper == null || m_reducer == null || m_source == null)
			return null;
		assert m_mapper != null;
		assert m_reducer != null;
		assert m_source != null;
		//Nouvelle collector , on lui rempli
		TupleCollection<K,V> temp_coll = new TupleCollection<K,V>();
		m_source.rewind();
	
		//zack
		

		  ThreadsManager<K,V> TM =new ThreadsManager();
		
		List<MapThread<K,V>> MapThreads=TM.getMapThreads(m_source, temp_coll, m_mapper);
		m_source=null;
		System.out.println("Map starts");
				int threadnbr=1;
     for (MapThread zMapThread : MapThreads) {
    	
			System.out.println("\nThread "+threadnbr++ +"--------------");
			zMapThread.start();
			try {
				zMapThread.join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	
     System.out.println("\nthe Map Ends");
		 System.out.println("Now we have "+temp_coll.count() +" Tuples to shuffle");
		 
		 System.out.println("\nShuffle Start\n");
		/// Shuffle Map clé -> valeurs 
		Map<K,TupleCollection<K,V>> shuffle = temp_coll.shuffle();
		temp_coll=null;
		 System.out.println("\nShuffle Ends\n");
	
		TupleCollection<K,V> out = new TupleCollection<K,V>();
		
		///threads of reduce
		List<ReduceThread<K,V>> ReduceThreads=TM.getReduceThreads(out,shuffle,m_reducer);
		threadnbr=1;
		for (ReduceThread zReduceThread : ReduceThreads) {
	    	
			System.out.println("\nThread  Reduce"+threadnbr++ +"--------------");
			zReduceThread.start();
			try {
				zReduceThread.join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		shuffle=null;
		/*
		//f koula key mn keys dyal Map ghanchoufo les valeur li fih : s_source
		for (K key : keys)
		{
			
			Collector<K,V> s_source = shuffle.get(key);
			
			///Total de chaque collector //
			int num_tuples = s_source.count();
			
			///somme tottal des tuple 
			 System.out.println("hadi "+num_tuples);
			m_totalTuples += num_tuples;
			m_maxTuples = Math.max(m_maxTuples, num_tuples);
			m_reducer.reduce(out, key, s_source);
		}*/
		return out;
	}
	

	public long getMaxTuples()
	{
		return m_maxTuples;
	}

	public long getTotalTuples()
	{
		return m_totalTuples;
	}

}
