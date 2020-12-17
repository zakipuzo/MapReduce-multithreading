package models;
import java.util.*;


public class TupleCollection<K,V>  implements InCollection<K,V>, OutCollection<K,V>
{
  private List<Tuple<K,V>> m_tuples = new LinkedList<Tuple<K,V>>();
  private Iterator<Tuple<K,V>> m_it = null;

  
  public List<Tuple<K,V>> toList()
  {
    return m_tuples;
  }

  
  public void addAll(Collection<Tuple<K,V>> list)
  {
    synchronized (this) {
      m_tuples.addAll(list);
    }
  }

  
  public void collect(Tuple<K,V> t)
  {
    synchronized (this) {
      m_tuples.add(t);
    }
  }

  
  public TupleCollection<K,V> subCollection(K key)
  {
    TupleCollection<K,V> c = new TupleCollection<K,V>();
    synchronized (this) {
      for (Tuple<K,V> t : m_tuples)
      {
        if (t.getKey().equals(key))
          c.m_tuples.add(t);
      }
    }
    return c;

  }

  public int count()
  {
    synchronized (this) {
      return m_tuples.size();
    }
  }

  
  public Map<K,TupleCollection<K,V>> shuffle()
  {
    Map<K,TupleCollection<K,V>> out = new HashMap<K,TupleCollection<K,V>>();

    synchronized (this) {
      for ( Tuple<K,V> t : m_tuples)
      {
        K key = t.getKey();
        //kat3mer deja b dakchi li f collector dial out awla null
        TupleCollection<K,V> c = out.get(key);

        if (c == null)
          c = new TupleCollection<K,V>();
        
        /// F Map out : koula collector ghatkoun fih liste dyal les tuple li bhal bhal  ... dakchi 3lach kandiro count()...
        c.collect(t);
        out.put(key, c);
      }
    }
    return out;
  }

  @Override
  public boolean hasNext()
  { 
    if (m_it == null)
      m_it = m_tuples.iterator();
   
    return m_it.hasNext();
  }

  @Override
  public Tuple<K,V> next()
  {
    return m_it.next();
  }

  @Override
  public void remove()
  {
    m_it.remove();
  }

  @Override
  public String toString()
  {
    return m_tuples.toString();
  }

  @Override
  public void rewind()
  {
    m_it = null;
  }
  
  
}
