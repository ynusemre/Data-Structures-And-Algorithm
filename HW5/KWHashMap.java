@SuppressWarnings("unchecked")
/**
 * KWHashMap Interface
 *<p>
 * It contains the methods of the HashMap and HashTableChains class
 */
public interface KWHashMap<K,V> { 
    V get (K key) throws ClassException;
    boolean isEmpty();
    V put( K key, V value);

}