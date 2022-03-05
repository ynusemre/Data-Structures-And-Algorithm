import java.util.Iterator;
import java.util.LinkedList;
@SuppressWarnings("unchecked")

/** Hash table implementation using open addressing. */
public class HashtableOpen<K, V> implements KWHashMap<K, V> {

    /** Contains key‐value pairs for a hash table. */
    private static class Entry<K, V> {

        /** The key */
        private final K key;

        /** The value */
        private V value;

        /** The next value */
        private K next=null;

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
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        /** Sets the next.
          *	@param n The new next
          *
          */
        public void setNext(Integer n) {
            next=(K)n;
        }
        /** Retrieves the next.
        	@return The next
        */
        public K getNext() {
            return next;
        }
    }

    /** The table */
    private Entry<K, V>[] table;
    
	/** initial capacity */
    private static final int START_CAPACITY = 10;

    /** The maximum load factor */
    private double LOAD_THRESHOLD = 0.75;
    
    /** The number of keys */
    private int numKeys;

    private int numDeletes;
    private final Entry<K, V> DELETED = new Entry<>(null, null);

    /**
     * HashtableOpen Constructor.Create table
     */
    public HashtableOpen() {
        table = new Entry[START_CAPACITY];
    }

    /** Finds either the target key or the first empty slot in the
      *	search chain using linear probing.
      *	@pre The table is not full.
      *	@param key The key of the target object
      *	@return The position of the target or the first empty slot if
      *	the target is not in the table.
     */
    private int find(Object key) {
        // Calculate the starting index.
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length; // Make it positive.
        // Increment index until an empty slot is reached
        // or the key is found.
        while ((table[index] != null)
                && (!key.equals(table[index].getKey()))) {
            index++;
            // Check for wraparound.
            if (index >= table.length)
                index = 0; // Wrap around.
        }
        return index;
    }

    /**
     * This method return special index value for the given key
     * @param key key value
     * @param length length of HashtableOpen  
     * @return  special index value for the given key
     */
    public int hash(K key, int length) {
        int index = key.hashCode() % length;
        if (index < 0) {
            index += length;
        }
        return index;
    }


    /** Method get for class HashtableOpen.
      *	@param key The key being sought
      *	@return the value associated with this key if found;
      *	otherwise, null
      */
    @Override
    public V get(Object key) throws ClassException{
        if (size() == 0) {
            throw new ClassException("!!! The HashTableOpen is empty, Please insert an element before the get method !!!");
        }

        // Find the first table element that is empty
        // or the table element that contains the key.
        int index = find(key);
        // If the search is successful, return the value.
        if (table[index] != null)
            return table[index].getValue();
        else
            return null; // key not found.
    }

    /**
     *  print HashTableOpen keys and Values
     */
    public void print(){
        for(int i=0;i<table.length;++i){
            if(table[i]!=null){
                System.out.println(table[i].getKey()+" => "+table[i].getValue() +" İndex :" +i+" next :"+table[i].getNext());
            }}}

    /**
     * If the given key exists in HashTableOpen, 
     * it first deletes the given key and then writes its next to the deleted one. It continues until null is achieved with a loop.
     * quadratic probing coalesced hashing method is used.
     * @param key Given key
     * @return removing value
     * @throws ClassException  if HashTableOpen is empty
     */
    public V remove(K key) throws ClassException{
        if (size() == 0) {
            throw new ClassException("!!! The HashTableOpen is empty, Please insert an element before the remove method !!!");
        }

        int counter=0;
        for(int i=0;i<table.length;i++){
            if(table[i]!=null && table[i].getKey()==key){
                counter++;
            }
        }
        if(counter==0){
            return null;
        }


        V key_value;
        int temp = hash(key, this.table.length);
        int h=1,index=temp;


        while (!key.equals(table[index].getKey())){
            index = (temp + h * h++) % this.table.length; //  Quadratic probing 
        }

        key_value=table[index].getValue();
        if(table[index].getNext()!=null){
            int temp3=(int)table[index].getNext();
        }

        table[index]=null;
        this.numKeys = this.numKeys - 1;

        int ctr=0;
        for (index = (temp + h * h++) % this.table.length ; table[index] != null ; index = (temp + h * h++) % this.table.length){
            if(hash(table[index].getKey(), this.table.length) != temp && ctr!=0){
                break;
            }
            ctr++;
            int k=0;
            K temp1 = table[index].getKey();
            V temp2 = table[index].getValue();
            if(table[index].getNext()!=null){
                k  = (int)table[index].getNext();
            }
            table[index]= null;
            put(temp1, temp2);
            if(k!=0 && table[index] != null){
                table[hash(table[index].getKey(), this.table.length)].setNext(k);
            }
        }
        return key_value;
    }


    /** Method put for class HashtableOpen.
      *	adding element with using quadratic probing coalesced hashing method
      * If the LOAD_THRESHOLD is exceeded, the table is expanded.
      *	 @param key The key of item being inserted
      *	 @param value The value for this key
      *	@return Old value associated with this key if found;
      *	otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int temp = hash(key, this.table.length);
        int h=1,index=temp,k=0,ctr=0,ctr2=0;
        int []arr=new int[this.table.length];
        V val = null;
		
		do{
            if (this.table[index] == null) {           // if the place is empty
                table[index] = new Entry<>(key, value);
                numKeys++;

                for(int j=0;j<k;j++){
                    if(table[arr[j]].getNext()==null){
                        ctr++;
                    }
                }
                if(ctr >=2){
                    table[arr[k-1]].setNext(index);
                    ctr2++;
                }


                if(ctr2==0){
                    for(int i=0;i<k;i++){
                        if(table[arr[i]].getNext()==null){
                            table[arr[i]].setNext(index);
                        }
                    }}

                double loadFactor =(double) (numKeys + numDeletes) / table.length;
                if (loadFactor > LOAD_THRESHOLD)
                    rehash();

                return (V) val;
            }
            if(table[index].getKey()==key){                            
                // assert: table element that contains the key was found.
                // Replace value for this key.
                val=table[index].setValue(value);


                double loadFactor =(double) (numKeys + numDeletes) / table.length;
                if (loadFactor > LOAD_THRESHOLD)
                    rehash();

                return val;
            }

            arr[k++]=index;
            index = (temp + h * h++) % this.table.length;
        }
        while (index != temp);

        return value;
    }

    /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
      *	@post The size of the table is doubled and is an odd integer.
      *	Each nondeleted entry from the original table is
      *	reinserted into the expanded table.
      *	The value of numKeys is reset to the number of items
      *	actually inserted; numDeletes is reset to 0.
     */
    private void rehash() {
        // Save a reference to oldTable.
        Entry<K, V>[] oldTable = table;
        // Double capacity of this table.
        table = new Entry[2 * oldTable.length + 1];

        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;
        numDeletes = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if ((oldTable[i] != null) && (oldTable[i] != DELETED)) {
                // Insert entry in expanded table
                put(oldTable[i].getKey(), oldTable[i].getValue());
            }}}

    /**
    * This method returns size of HashTableOpen
    * @return size of HashTableOpen
    */
    public int size() {
        return numKeys;
    }

    /**
     * Used to detect if HashTableOpen is full
     * @return true or false
     */ 
    public boolean isEmpty() {
        return (this.size() < 1);
    }
}				