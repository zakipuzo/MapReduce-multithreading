package models;

import java.util.Iterator;

public interface InCollection<K,V> extends Iterator<Tuple<K,V>>
{
	
	public int count();
	
	
	public void rewind();
}
