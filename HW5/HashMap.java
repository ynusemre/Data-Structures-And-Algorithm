import java.util.LinkedList;
@SuppressWarnings("unchecked")

/** Hash table implementation using chaining. */
public class HashMap<K, V> implements KWHashMap<K, V> {

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

    /**
     *  My Iterator Class
     * @param <T> Generic variable
     */
    public class MapIterator<T> implements Iterator<T>{
        /** cursor   */
        private int index;

        /** Default Constructor */
        public MapIterator(){
            index=0;
        }


        /**
         * This constructor take a key and it will use to traverse all HashMap.
         * @param key initial point 
         */
        public MapIterator(T key){
            index = key.hashCode() % capacity;

            if (index < 0) {
                index += capacity;
            }

        }

        /**
         * The method returns True if there are still not-iterated key/s in the Map, 
         * otherwisereturns False.
         * @return  true or false
         */
        public boolean hasNext() {
            //it is goint to untill last key's index value.
            return index!=last_index;
        }

        /**
         * The function returns the next key in the Map. It returns the first key when there is no
         * not-iterated key in the Map.
         * @return  key
         * @throws ClassException if HashMap is empty
         */
        public T next() throws ClassException{
            if(size()==0){
                throw new ClassException("!!! The HashMap is empty, Please insert an element before the next method !!!");
            }

            for(;index<table.length;index++){
                if(table[index]!=null ){  //if key value is not null exit the loop.
                    break;
                }
                if(table[index]==null){  //if key value is null.index is increasing.
                    continue;
                }
            }
            T next=(T)table[index].get(0).getKey();
            if(index!=last_index){
                index=index+1;
            }
            return next;
        }

        /**
         * The iterator points to the previous key in the Map. It returns the last key when the
         * iterator is at the first key.
         * @return  key
         * @throws ClassException  if HashMap is empty
         */
        public T prev() throws ClassException{
            if(size()==0){
                throw new ClassException("!!! The HashMap is empty, Please insert an element before the prev method !!!");
            }
            for(;index-1>=0;index--){
                if(table[index-1]!=null ){
                    break;
                }
                if(table[index-1]==null){
                    continue;
                }
            }
            if(index==0){
                index=last_index+1;
            }
            T prev=(T)table[index-1].get(0).getKey();
            index=index-1;
            return prev;
        }
    }

    /** The table */
    private LinkedList<Entry<K, V>>[] table;

    /** The number of keys */
    private int numkeys = 0;

    /** The capacity */
    private int capacity = 31;

    /** The maximum load factor */
    private double loadThreshold = 3.0;

    /**last key index */
    private int last_index=0;

    /**
     * Use for Create Iterator object
     * @param key   initial point
     * @return    Iterator object   
     */
    public Iterator<K> iterator(K key){
        // Check if the given key is in HashMap, 
        // if there is a key is sent to the constructor that takes the key.
        for(int i=0;i<table.length;++i){
            if(table[i]!=null){
                if(key==table[i].get(0).getKey()){
                    return new MapIterator<K>(key);
                }
            }
        }
        //if initial key point does not found.
        return new MapIterator<K>();
    }

    /**
     * if user does not give initial key point.
     * @return Iterator object
     */
    public Iterator<K> iterator(){
        return new MapIterator<K>();
    }

    /**
     * This method return special index value for the given key
     * @param key key value
     * @param length length of HashMap  
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
     * HasMap Constructor.Create table
     */
    public HashMap() {
        this.table = new LinkedList[capacity];
    }

    /**
     * HasMap Constructor.Create table.
     * assign given values to loadThreshold and capacity
     * @param capacity
     * @param load
     */
    public HashMap(int capacity, double load) {
        this.table = new LinkedList[capacity];
        this.loadThreshold = load;
        this.capacity = capacity;
    }

    /**
     * print HashMap keys and Values
     */
    public void print(){
        for(int i=0;i<table.length;++i){
            if(table[i]!=null){
                System.out.println(table[i].get(0).getKey()+" => "+table[i].get(0).getValue());
            }
        }
    }

    /** Method get for class HashtableChain.
     @param key The key being sought
     @return The value associated with this key if found;
     otherwise, null
     */
    @Override
    public V get(K key) throws ClassException{

        if (size() == 0) {
            throw new ClassException("!!! The Hashmap is empty, Please insert an element before the get method !!!");
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

    /** Method put for class HashtableChain.
     @post This key‐value pair is inserted in the
     table and numKeys is incremented. If the key is already
     in the table, its value is changed to the argument
     value and numKeys is not changed.
     @param key The key of item being inserted
     @param value The value for this key
     @return The old value associated with this key if
     found; otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = hash(key, this.table.length);
        if(index>last_index){
            last_index=index;
        }
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
     * This method returns size of HashMap
     * @return number of keys it is mean size of HashMap
     */
    public int size() {
        return numkeys;
    }

    /**
     * Used to detect if HashMap is full
     * @return true or false
     */
    public boolean isEmpty() {
        return (this.size() < 1);
    }
}