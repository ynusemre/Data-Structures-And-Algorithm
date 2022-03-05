import java.util.*;

@SuppressWarnings("unchecked")
/**
 * Skip-List class implements NavigableSet
 */
public class SkipList<E extends Comparable<E>> implements NavigableSet<E>{

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Skip-List Node Class
     *  That create a node for our Skip-List
     */
    private class SkipList_Node<E>{
        private SkipList_Node[] next_node;
        private E element;
        private int height;

        /**
         * Constructor
         * That create a node for our Skip-List
         * @param element  given element
         * @param height  given height
         */
        public SkipList_Node(E element, int height){
            this.element = element;
            this.height = height;
            // 0 is the base height
            this.next_node = new SkipList_Node[height+1];
        }

        /**
         * That method return value of node
         * @return node value
         */
        public E getElement() {
            return this.element;
        }

        /**
         *  that function return height and element of node as a string
         * @return height and element
         */
        @Override
        public String toString() {
            return "[ height " + height + " | element "+element + " ]";
        }
    }
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    // i determine the max height as 4
    private int max_height =4;
    
    //initial root of skip-list
    private SkipList_Node<E> root;

    //size of skip-list
    private int size;
    
    //the current max height
    private int lastMaxHeight;
    
    //this boolean variable using for inrement or not increment the height of the skip-list
    private Random is_height_increment = new Random();

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Skip-List constructor
     * assing an initial value for the root, lastMaxHeight and size
     */
    public SkipList() {
        this.root = new SkipList_Node<>(null, max_height);
        this.lastMaxHeight = 1;
        this.size = 0;
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
    /**
     * this method return a Skip-List iterator
     * Returned iterator is walking in the Skip-List in Decrasing Order .
     * So The iterator Starting from and of The Skip-List. and Iterator's next Method return it
     * 
     * @return a Skip-List iterator  
     */
    @Override
    public MyIterator<E> descendingIterator(){
        return new SkipListIter();
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
    /**
     * this method return a Skip-List iterator
     *
     * @return a Skip-List iterator  
     */
    @Override
    public MyIterator<E> iterator() {
        return new SkipListIter();
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Skip-List iterator class implements MyIterator interface which i created as own.
     */
    private class SkipListIter implements MyIterator<E>{
        //cursor variable for the walking on the skip-list
        private int cursor=0;

        //this variable a Skip-List Node using for walking on the skip-list 
        private SkipList_Node<E> current;

        /**
         * This method looking to skip-list for is there any node.
         * if there is no node it will be finish
         * @return  if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return  cursor!=size;
        }

        /*----------------------------------------------------------------------------------------------------------------*/
        /*----------------------------------------------------------------------------------------------------------------*/
        /*----------------------------------------------------------------------------------------------------------------*/

        /**
         * Returns the next element in the iteration.
         * 
         * This method walking in the skip-list and it walks to end of the skip-list end return it.
         * but the end value decrease by one for every calling.
         * 
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            current=root;
            for(int i=0;i<size-cursor;i++){
                current = current.next_node[0];
            }
            E next=(E)current.element;
            cursor++;

            return next;
        }
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     *    Skip-List Insert Method 
     *
     *   make the node a part of the lowest-height list only.
     *  the node will be a part of the lowest two lists. , the node will be a part of lists.
     *  And  Insert the node at the casual position in the lists that it is a part of.
     *  Max height is set to 4 now
     *
     * @param element wants to insert element
     * @return if element inserted return true.
     */
    @Override
    public boolean insert(E element) {

        int height = 0;

        // in this part the code determine the height of the skip-list increase or not with randomly
        for (int i = 0; i < max_height; i++) {
            if (is_height_increment.nextBoolean()) {
                height++;
                if (height == this.lastMaxHeight) {
                    lastMaxHeight++;
                    break;
                }
            } else {
                break;
            }
        }

        //creating a new node with a given element and randomly defined height
        SkipList_Node<E> newNode = new SkipList_Node<>(element,height);

        //cursor for walking in the skip-list
        SkipList_Node cursor = root;

        //this part walks height to down in the skip-list until it find a range
        //  when at cursor height, then needs to find the right node to stop
        for (int i = lastMaxHeight - 1; i >= 0; i--) {
            while (null != cursor.next_node[i]) {
                if (((E) cursor.next_node[i].getElement()).compareTo(element) > 0 ) {
                    break;
                }
                cursor = cursor.next_node[i];
            }

            if (i <= height) {
                newNode.next_node[i] = cursor.next_node[i];
                cursor.next_node[i] = newNode;
            }
        }
        //increase size of skip-list
        size++;
        return true;
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * This method delete the given value from the skip-list
     * @param element wants to delete variable
     * @return true if the element is deleted
     */
    @Override
    public boolean delete(E element) {
        SkipList_Node cursor = root;
        boolean result = false;
        for (int i = lastMaxHeight - 1; i >= 0; i--) {

            //this part walks height to down in the skip-list until it find a range
            //  when at cursor height, then needs to find the right node to stop
            // delete one height is not enough, all levels needs to be removed;
            while (null != cursor.next_node[i]) {
                
                if (((E) cursor.next_node[i].getElement()).compareTo(element) > 0) {
                    break;
                }
                if (((E) cursor.next_node[i].getElement()).compareTo(element) == 0) {
                    cursor.next_node[i] = cursor.next_node[i].next_node[i];
                    result = true;
                    size--;
                    
                    break;
                }
                cursor = cursor.next_node[i];
            }
        }
        return result;
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * i did not define this method for the Skip-List but it is in the NavigableSet ,and we are not using in our HW for the Skip-List
     * @param toElement given element
     * @param inclusive boolean expression 
     * @return SkipList 
     */
    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive){
        return new SkipList<E>();
    }

    /**
     * i did not define this method for the Skip-List but it is in the NavigableSet ,and we are not using in our HW for the Skip-List
     * @param fromElement given element
     * @param inclusive  boolean expression 
     * @return  SkipList
     */
    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive){
        return new SkipList<E>();
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * This method using for the driver method.I show the operations validity with this method.
     * i printing the skip-list height and element in the node
     */
    public void levelPrint() {
        // find the initial height
        SkipList_Node cursor = root;
        int start = max_height - 1;
        while (null == cursor.next_node[start]) {
            start--;
        }

        // bring together all node
        cursor = root;
        List<SkipList_Node> ref = new ArrayList<>();
        while (null != cursor) {
            ref.add(cursor);
            cursor = cursor.next_node[0];
        }

        for (int i = 0; i <= start; i++) {
            cursor = root;
            cursor = cursor.next_node[i];
            System.out.print( "Layer "+ i + " | height " + max_height + " | root |");

            int levelIndex = 1;
            while (null != cursor) {
                if (i > 0) {
                    while (ref.get(levelIndex).getElement() != cursor.getElement()) {
                        levelIndex++;
                        System.out.print( "--------------------------");
                    }
                    
                    levelIndex++;
                }

                System.out.print( "---> " + cursor);
                cursor = cursor.next_node[i];
            }

            System.out.println();
        }}}
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/        

