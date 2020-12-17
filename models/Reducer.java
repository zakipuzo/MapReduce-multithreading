package models;

public interface Reducer<K,V>
{
	
	public void reduce(OutCollection<K,V> out, K key, InCollection<K,V> in);
}
