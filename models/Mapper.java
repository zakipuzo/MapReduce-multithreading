package models;

public interface Mapper<K,V>
{

	public void map(OutCollection<K,V> c, Tuple<K,V> t);
}
