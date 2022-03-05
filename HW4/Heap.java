import java.util.ArrayList;
@SuppressWarnings("unchecked")

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/**
 * My min Heap Class
 */
public class Heap<T> extends ClassIterator<T>{
    private ArrayList<T> items;             //it is hols the min heap datas
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Heap Constructor
     */
    public Heap() {
        items = new ArrayList<T>();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method return an object from Iterator class
     * @return  return an object from Iterator class
     */
    public Iterator<T> iterator(){
        return new ClassIterator<T>(this.items);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////

     /**
     * Starting from the given index,
     *<p>
     *	If any child is smaller than its parent, it replaces it.
     * @param index starting point to start comparing in the Heap
     */
    private void siftUp() {
        int k = items.size()- 1;
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
     * This method insert the given element at the end of the Heap.
     * @param item the given element
     */
    public void insert(T item) {
        items.add(item);
        siftUp();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This Method merge the Heap with Given Heap.
     * @param hp2 Given Heap Tree
     */
    public void merge(Heap<T> hp2){
        for(int i=0;i<hp2.size();i++) {
            this.insert(hp2.items.get(i));
        }}
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method chec the given value in the Heap if Heap contains return true else false.
     * @param val given value.
     * @param k a variable using for traverse in the Heap.
     * @param t a variable using for traverse in the Heap.
     * @return true or false
     */
    public boolean contains(T val,int k,int t) {
        if(k<items.size()) {
            if(items.get(k)==val) {
                return true;
            }
            else {
                return contains(val,2*t+1,t+1) || contains(val,2*t+2,t+1);
            }}
        return false;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Search the given value in the Heap.
     * @param val   given value.
     */
    public void search(T val) {
        System.out.println(val+" is inside in the Heap? :"+contains(val,0,0));
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
                if ((((Comparable<T>)items.get(r)).compareTo(items.get(l))) < 0) {
                    min++;
                }}
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
     * This method sort the ArrayList and return i^th largest element
     * @param items_temp given ArrayList
     * @param k size value of the desired element to be removed
     * @return i^th largest element
     */
    public T Sort_and_Return(ArrayList<T> items_temp,int k){
        int n = items_temp.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if ( (((Comparable<T>)items_temp.get(j)).compareTo(items_temp.get(j+1))) < 0 ){
                    // swap 
                    T temp = items_temp.get(j);
                    items_temp.set(j,items_temp.get(j+1));
                    items_temp.set(j+1,temp);
                }}}
        return items_temp.get(k-1);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////	

    /**
     * This method return i^th largest element's index.
     * @param items_temp given ArrayList. 
     * @param val i^th largest element.
     * @return i^th largest element's index in the ArrayList.
     */
    public int find_index_of_i_th_largest(ArrayList<T> items_temp,T val){
        int index=0;
        for(int i=0;i<items_temp.size();i++) {
            if(val==items_temp.get(i)) {
                index=i;
            }}
        return index;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 	This method remove the i^th largest element's in the Heap.
     * @param x size value of the desired element to be removed.
     * @return i^th largest element.
     * @throws ClassException      if The Heap is empty or Given value more than the Heap size.
     */
    public T remove(int x) throws ClassException {
        if (items.size() == 0) {
            throw new ClassException("! The Heap is empty, Please insert an element !");
        }
        if(x>items.size()){
            throw new ClassException("! Given value is more than the Heap size, Please be careful !");
        }
        if (items.size() == 1) {
            return items.remove(0);
        }

        ArrayList<T> items_temp=new ArrayList<T>();
        items_temp.addAll(items);

        T i_th_max_value=Sort_and_Return(items_temp,x);

        int index_of_i_th_largest=find_index_of_i_th_largest(items,i_th_max_value);

        T hold = items.get(index_of_i_th_largest);
        items.set(index_of_i_th_largest, items.remove(items.size()-1));
        siftDown(index_of_i_th_largest);
        return hold;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 
     * @return The Heap size.
     */
    public int size() {
        return items.size();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////	

    /**
     * check the Heap it is empty or not.
     * @return   true or false
     */
    public boolean isEmpty() {
        return items.isEmpty();

    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////	

    /**
     * This Method using for print Heap Tree.
     * @return   Heap.
     */
    public String toString() {
        return items.toString();
    }
}
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/