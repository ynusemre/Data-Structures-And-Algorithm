import java.util.Iterator;
import java.util.LinkedList;
@SuppressWarnings("unchecked")

/** Hash table implementation using chaining with using LinkedList. */
public class HashTableChain<K, V> implements KWHashMap<K, V> {

    /** Contains key‐value pairs for a hash table. */
    private static class Entry<K, V> {
        /** The key */
        private final K key;

        /** The value */
        private V value;

        /** Creates a new key‐value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /** Retrieves the key.
         @return The key
         */
        public K getKey() {
            return key;
        }

        /** Retrieves the value.
         @return The value
         */
        public V getValue() {
            return value;
        }

        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setvalue(V val) {
            V oldvalue = value;
            value = val;
            return oldvalue;
        }
    }

    /** The table. Using with LinkedList */
    private LinkedList<Entry<K, V>>[] table;

    /** The number of keys */
    private int numkeys = 0;

    /** The capacity */
    private int capacity = 31;

    /** The maximum load factor */
    private double loadThreshold = 3.0;

    /**
     * HasMap Constructor.Create table
     */
    public HashTableChain() {
        this.table = new LinkedList[capacity];
    }

    /**
     * HasMap Constructor.Create table.
     * assign given values to loadThreshold and capacity
     * @param capacity
     * @param load
     */
    public HashTableChain(int capacity, double load) {
        this.table = new LinkedList[capacity];
        this.loadThreshold = load;
        this.capacity = capacity;
    }

     /**
     * This method return special index value for the given key
     * @param key key value
     * @param length length of HashTableChain  
     * @return  special index value for the given key
     */
    public int hash(K key, int length) {
        int index = key.hashCode() % length;
        if (index < 0) {
            index += length;
        }
        return index;
    }

    /**
     * print HashTableChain keys and Values
     */
    public void print(){
        for(int i=0;i<table.length;++i){
            if(table[i]!=null){
                System.out.println(table[i].get(0).getKey()+" => "+table[i].get(0).getValue() +" İndex :" +i);
            }
        }
    }

    /**
     * remove given key from the HashTableChain if it is exits
     * @param key given key
     * @return  removed key if it is exits
     * @throws ClassException  if  HashTableChain is empty
     */
    public V remove(K key) throws ClassException{
        if (size() == 0) {
            throw new ClassException("!!! The HashTableChain is empty, Please insert an element before the remove method !!!");
        }
        V key_value;

        //Search the given key.
        for(int i=0;i<table.length;i++){
            if(table[i]!=null){
                if(table[i].get(0).getKey()==key){
                    key_value=table[i].get(0).getValue();
                    table[i]=null;
                    this.numkeys = this.numkeys - 1;
                    return key_value;
                }
            }
        }
        return null;
    }
    /** Method get for class HashtableChain.
      *  @param key The key being sought
      *  @return The value associated with this key if found;
      *  otherwise, null
      * @throws ClassException  if  HashTableChain is empty
      */
    @Override
    public V get(K key) throws ClassException{

        if (size() == 0) {
            throw new ClassException("!!! The HashTableChain is empty, Please insert an element before the get method !!!");
        }

        int index = hash(key, this.table.length);
        if (this.table[index] == null) {
            return null;
        }
        Entry t;
        for(int i = 0; i < table[index].size(); i++) {
            t = table[index].get(i);
            if (t.getKey().equals(key)) {
                return (V) t.getValue();
            }
        }
        return null;
    }

    /**
     * This method uses for incrase the capacity when it is overflow
     */
    public void rehash() {
        this.numkeys = 0;
        LinkedList<Entry<K, V>>[] oldTable;
        oldTable = this.table;
        this.capacity = (this.capacity * 2) + 1;
        this.table = new LinkedList[this.capacity];
        Entry<K, V> t;
        for(int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                for(int j = 0; j < oldTable[i].size(); j++) {
                    t = oldTable[i].get(j);
                    this.put(t.getKey(), t.getValue());
                }
            }
        }
    }
    /**  Method put for class HashtableChain.
      *  @post This key‐value pair is inserted in the
      *  table and numKeys is incremented. If the key is already
      *  in the table, its value is changed to the argument
      *  value and numKeys is not changed.
      *  @param key The key of item being inserted
      *  @param value The value for this key
      *  @return The old value associated with this key if
      *  found; otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = hash(key, this.table.length);
        V val = null;
        if (this.table[index] == null) {
            // if no linked list add the key value to the linked list
            LinkedList ll = new LinkedList();
            ll.add(new Entry(key, value));
            this.table[index] = ll;
            this.numkeys = this.numkeys + 1;

            // if load is more than threshold rehash into a new table with more capacity
            if ((this.numkeys) > (this.loadThreshold * this.capacity)) {
                rehash();
            }
            return (V) val;
        }
        else {

            for(int i = 0; i < table[index].size(); i++) {
                Entry t = this.table[index].get(i);
                if (t.getKey().equals(key)) {
                    val = (V) t.setvalue(value);
                    return val;
                }
            }
            this.table[index].add(new Entry(key, value));

            // if load is more than threshold rehash into a new table with more capacity
            this.numkeys += 1;

            if ((this.numkeys) > (this.loadThreshold * this.table.length)) {
                rehash();
            }
            return value;
        }
    }

    /**
     * This method returns size of HashTableChain
     * @return size of HashTableChain
     */
    public int size() {
        int count = 0;
        Iterator<Entry<K, V>> ir;
        Entry<K, V> t;
        for (LinkedList<Entry<K, V>> ll : this.table) {
            if (ll != null) {
                ir = ll.listIterator(0);
                while (ir.hasNext()) {
                    t = ir.next();
                    if (t.key != null) {
                        count = count + 1;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Used to detect if HashTableChain is full
     * @return true or false
     */ 
    public boolean isEmpty() {
        return (this.size() < 1);
    }
}