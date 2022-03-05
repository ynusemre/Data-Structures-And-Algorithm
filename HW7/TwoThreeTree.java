import java.util.LinkedList;
import java.util.Queue;

/**
 * 2-3 Tree Class. Its order is 3
 */
public class TwoThreeTree {

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
    
    // The initial root of the 2-3 tree
    private TwoThreeTree_Node root;

    //the order that using for the number of nodes a node can be linked to.That given in the Driver Class 3
    private int order;

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     *  inner class for the 2-3 tree node 
     */
    private class TwoThreeTree_Node{

        // ids of nodes
        private int[] node_ids; 
        
        // order of  2-3 tree node
        private int order;

        // Child node of any node
        private TwoThreeTree_Node[] child; 
        
        // Number of ids of node
        private int number; 
        
        // True if the node is leaf
        private boolean isLeaf; 

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

        /**
         * Constructor
         * This constructure assign the initial value of TwoThreeTree Node variable
         * @param order given order
         * @param isLeaf given boolean expression for the determine leaf 
         */
        public TwoThreeTree_Node(int order,boolean isLeaf){
            this.order = order;
            this.isLeaf = isLeaf;
            this.node_ids = new int[2*this.order-1]; // Node has 2*order-1 ids at most
            this.child = new TwoThreeTree_Node[2*this.order];
            this.number = 0;
        }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

        /**
         *  This method fix the 2-3 tree if any node is full, then this method arrange the 2-3 tree.
         *  Find a new place when the given element when the node is full. and arrenge the 2-3 tree.
         *  create a new node and link it with other node.
         *  
         * @param element wants the inserts variable 
         */
        public void Insert_Helper(int element){

            // Initialize index as the rightmost index
            int index = number -1; 

            // When it is a leaf node
            if (isLeaf){ 

                //in this part
                // Find the location where the new element should be inserted
                //backward shift
                while (index >= 0 && node_ids[index] > element){
                    node_ids[index+1] = node_ids[index];  
                    index--;
                }

                node_ids[index+1] = element;
                number = number +1;
            }
            else{

                // Find the child node location that should be inserted
                // When the child node is full
                // After splitting, the element in the middle of the child node moves up, and the child node splits into three
                while (index >= 0 && node_ids[index] > element){
                    index--;
                }
                if (child[index+1].number == 2*order - 1){ 
                    splitNode(index+1,child[index+1]);
                    
                    if (node_ids[index+1] < element){
                        index++;
                    }}

                child[index+1].Insert_Helper(element);
            }}

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

        /**
         * in this method,
         * if the node to which the element will be inserted is full, then this method arrange the 2-3 tree 
         * link the created node with others
         * 
         * @param constant given constant that detirmane to index
         * @param localRoot given localRoot
         */
        public void splitNode(int constant ,TwoThreeTree_Node localRoot){
            
            // First, create a node 
            TwoThreeTree_Node temp = new TwoThreeTree_Node(localRoot.order,localRoot.isLeaf);
            temp.number = order - 1;

            
            for (int j = 0; j < order-1; j++){
                temp.node_ids[j] = localRoot.node_ids[j+order];
            }
            if (!localRoot.isLeaf){
                for (int j = 0; j < order; j++){
                    temp.child[j] = localRoot.child[j+order];
                }}

            localRoot.number = order-1;

            // Insert a new child into the child
            for (int j = number; j >= constant+1; j--){
                child[j+1] = child[j];
            }
            child[constant+1] = temp;

            // Move a key in localRoot to this node
            for (int j = number-1;j >= constant;j--){
                node_ids[j+1] = node_ids[j];
            }

            node_ids[constant] = localRoot.node_ids[order-1];
            number = number + 1;
        }
    }
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    

    /**
     * Constructor of 2-3 Tree
     * assign the initial value of its variables
     * @param order
     */
    public TwoThreeTree(int order){
        this.root = null;
        this.order = order;
    }
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * in this method,
     * given variable inserted in the 2-3 tree than if the 2-3 tree structure is broken 
     * it is fixing with using insert helper (fixing expression in there)
     *
     * @param element value wants to be inserted
     */
    public void insert(int element){
        int index = 0;
        TwoThreeTree_Node temp = new TwoThreeTree_Node(order,false);

        if (root == null){

            root = new TwoThreeTree_Node(order,true);
            root.node_ids[0] = element;
            root.number = 1;
        }
        else {
            // if the root node is full, then the tree will grow high
            if (root.number == 2*order-1){

                // The old root node becomes a child of the new root node
                temp.child[0] = root;

                // Separate the old root node and give a element to the new node
                temp.splitNode(0,root);

                // The new root node has 3 child nodes. Move the old one over there
                if (temp.node_ids[0]< element){
                    index++;
                }
                temp.child[index].Insert_Helper(element);

                root = temp;
            }
            else
                root.Insert_Helper(element);
        }}}
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/