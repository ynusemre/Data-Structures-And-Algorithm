import java.util.*;

/**
 * KWArrayList Class.
 * @param <E>
 */
public class KWArrayList<E> {
    // Data Fields
    /** The default initial capacity */
    private static final int INITIAL_CAPACITY = 10;
    /** The underlying data array */
    private E[] theData;
    /** The current size */
    private int size = 0;
    /** The current capacity */
    private int capacity = 0;

    /**
     * KWArrayList constructor set the capacity as INITIAL_CAPACITY.
     */
    public KWArrayList(){
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
    }

    /**
     * add the element to the last of the list and return always ture.
     * <p>
     * rellocate if the size equal to capacity	.
     * @param anEntry
     * @return
     */
    public boolean add(E anEntry){
        if (size == capacity){
            reallocate();
        }
        theData[size] = anEntry;
        size++;

        return true;
    }

    /**
     * add the element to given index.
     * <p>
     * reallocate if the size equal to capacity.
     * @param index
     * @param anEntry
     */
    public void add(int index, E anEntry){
        if (index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (size == capacity){
            reallocate();
        }
        // Shift data in elements from index to size ‐ 1
        for (int i = size; i > index; i--){
            theData[i] = theData[i - 1];
        }
        // Insert the new item.
        theData[index] = anEntry;
        size++;
    }

    /**
     * return the node of given index.
     * @param index
     * @return
     */
    public E get(int index){
        if (index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    /**
     * set element to given index and return the removing oldvalue.
     * @param index
     * @param newValue
     * @return
     */
    public E set(int index, E newValue){
        if (index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = newValue;

        return oldValue;
    }

    /**
     * remove the element to given index and return the removing value.
     * @param index
     * @return
     */
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E returnValue = theData[index];
        for (int i = index + 1; i < size; i++) {
            theData[i - 1] = theData[i];
        }
        size--;
        return returnValue;
    }

    /**
     * return size of the list.
     * @return
     */
    public int size(){
        return size;
    }

    /**
     *  increase capacity of the list.
     */
    private void reallocate(){
        capacity = 2 * capacity;
        theData = Arrays.copyOf(theData, capacity);
    }
}