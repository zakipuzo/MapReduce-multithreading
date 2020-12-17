package models;

public interface OutCollection<K,V>
{
	public void collect(Tuple<K,V> t);
	
	public void rewind();
}
