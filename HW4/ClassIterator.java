import java.util.ArrayList;
@SuppressWarnings("unchecked")

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/**
 * My Iterator Class 
 *<p>
 * it implements  Iterator interface
 */
public class ClassIterator<T> implements Iterator<T>{
    private ArrayList<T> items;                   //it is hols the min heap datas.
    private int cursor=0; 						  //using for current iterator position.
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Iterator Constructor
     */
    public ClassIterator(){								
        this.items=null;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////		
    /**
     * Iterator Constructor
     *<p>
     * assign given ArrayList to the iterator class's ArrayList. 
     * @param items   given ArrayList
     */
    public ClassIterator(ArrayList<T> items){            
        this.items=items;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////	

    /**
     * it is use for traverse of end of the Heap
     * @return true or false
     */
    public boolean hasNext() {
        return cursor!=items.size();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method return iterator's current value
     * @return iterator's current value
     * @throws ClassException if The Heap is empty 
     */
    public T next() throws ClassException{					//Iterator next() Function
        if(items.size()==0){
            throw new ClassException("! The Heap is empty, Please insert an element !");
        }
        int k=cursor;
        T next=items.get(k);
        cursor=k+1;
        return next;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Starting from the given index,
     *<p>
	 *If any parent is greater than its child, it replaces it.
     * @param index starting point to start comparing in the Heap
     */
    private void siftDown(int index) {
        int k = index;
        int l = 2*k+1;
        while (l < items.size()) {

            int min=l, r=l+1;
            if (r < items.size()) { // there is a right child
                if (  (((Comparable<T>)items.get(r)).compareTo(items.get(l))) < 0) {
                    min++;
                }
            }
            if ((((Comparable<T>)items.get(k)).compareTo(items.get(min))) > 0) {
                // switch
                T temp = items.get(k);
                items.set(k, items.get(min));
                items.set(min, temp);
                k = min;
                l = 2*k+1;
            }
            else {
                break;
            }}}
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Starting from the given index,
     *<p>
     *	If any child is smaller than its parent, it replaces it.
     * @param index starting point to start comparing in the Heap
     */
    private void siftUp(int index) {
        int k = index;
        while (k > 0) {
            int p = (k-1)/2;
            T item = items.get(k);
            T parent = items.get(p);
            if (( ((Comparable<T>) item) .compareTo(parent)) < 0) {
                // swap
                items.set(k, parent);
                items.set(p, item);

                // move up one level
                k = p;
            } else {
                break;
            }}}
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * remove element from iterator's current position in the Heap 
     * @throws ClassException   if The Heap is empty 
     */
    public void remove() throws ClassException{
        if(items.size()==0){
            throw new ClassException("! The Heap is empty, Please insert an element !");
        }

        System.out.println(cursor-1);
        items.set(cursor-1, items.remove(items.size()-1));
        siftDown(cursor-1);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Given value replace with iterator's current position in the Heap 
     * @param value Given value that sets with the Heap's value 
     */
    public void Set(T value){
        System.out.println("cursor: "+(cursor));
        items.set(cursor-1,value);
        siftUp(cursor-1);
        siftDown(cursor-1);
    }
}
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/



