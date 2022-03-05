@SuppressWarnings("unchecked")

/**
 * class RedBlackTree implements the operations in Red Black Tree
 */
public class RedBlackTree {

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    // initial root of the Red-Black Tree
    private Node root; 

    // a null tree that creating for the help the operations
    private Node NULL_Tree;

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * nested Node class that represents a node in the tree
     */
    private class Node {

        // holds the value of node
        private int number; 
        
        // pointer to the parent of node
        private Node parent; 
        
        // pointer to left child of node
        private Node left; 
        
        // pointer to right child of node
        private Node right; 
        
        // this is the color node using for the determine the color of node. With like this  1 . Red, 0 . Black 
        private int color; 
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Red-Black Tree Constructure
     * assing a value to Node's class variable
     */
    public RedBlackTree(){
        NULL_Tree = new Node();
        NULL_Tree.color = 0;
        NULL_Tree.left = null;
        NULL_Tree.right = null;
        root = NULL_Tree;
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     *   Red-Black Tree Insert Method 
     *
     * insert the given element to the tree in its proper position as like a binary search tree.
     * And fix the tree.How to do it is explained below in the insert helper.
     * New node must be red
     * @param element
     */
    public void insert(int element) {
        // Common Binary Search Insertion
        Node node = new Node();
        node.parent = null;
        node.number = element;
        node.left = NULL_Tree;
        node.right = NULL_Tree;
        node.color = 1; 		// new node must be red

        Node paren_of_root = null;
        Node temp_root = this.root;

        while (temp_root != NULL_Tree) {
            paren_of_root = temp_root;

            if (node.number < temp_root.number) {
                temp_root = temp_root.left;
            }

            else {
                temp_root = temp_root.right;
            }}

        node.parent = paren_of_root;

        if (paren_of_root == null) {
            root = node;
        }

        else if (node.number < paren_of_root.number) {
            paren_of_root.left = node;
        }

        else {
            paren_of_root.right = node;
        }

        // if new node is a root node, just return
        if (node.parent == null){
            node.color = 0;
            return;
        }

        // if the grandparent is null, just return
        if (node.parent.parent == null) {
            return;
        }

        // Fix the tree
        Insert_Helper(node);
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

	/**
     * Fix the red-black tree
     *
     * if given localRoot's uncle's color is red then the code just change the parent, uncle and grandparent color.
     * if given localRoot's uncle's color is not red, then the code firstly arrange the balance of Red-Black Tree (left or right rotate) 
     * then change the uncle, parent and grandparent color. After this oparation Tree is checking again because it must be broken again
     * if the rules that i explain at the up is okey the process is done.
     * 
     * @param localRoot given node 
     */
    private void Insert_Helper(Node localRoot){
        Node uncle;
        while (localRoot.parent.color == 1) {
            if (localRoot.parent == localRoot.parent.parent.right) {
                uncle = localRoot.parent.parent.left; // uncle
                if (uncle.color == 1) {
                    // case 3.1
                    uncle.color = 0;
                    localRoot.parent.color = 0;
                    localRoot.parent.parent.color = 1;
                    localRoot = localRoot.parent.parent;
                }
                else {
                    if (localRoot == localRoot.parent.left) {
                        // case 3.2.2
                        localRoot = localRoot.parent;
                        rightRotate(localRoot);
                    }
                    // case 3.2.1
                    localRoot.parent.color = 0;
                    localRoot.parent.parent.color = 1;
                    leftRotate(localRoot.parent.parent);
                }}
            else{
                uncle = localRoot.parent.parent.right; // uncle

                if (uncle.color == 1) {
                    // mirror case 3.1
                    uncle.color = 0;
                    localRoot.parent.color = 0;
                    localRoot.parent.parent.color = 1;
                    localRoot = localRoot.parent.parent;
                }
                else {
                    if (localRoot == localRoot.parent.right){
                        // mirror case 3.2.2
                        localRoot = localRoot.parent;
                        leftRotate(localRoot);
                    }
                    // mirror case 3.2.1
                    localRoot.parent.color = 0;
                    localRoot.parent.parent.color = 1;
                    rightRotate(localRoot.parent.parent);
                }}
            if (localRoot == root){
                break;
            }
        }
        root.color = 0;
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**  
     * Rotate left at node localRoot
	 *
   	 *	Method to perform a left rotation.
	 *	@pre root is the root of a red-black tree.
	 *	@post root.left is the root of a red-black tree,
	 *	root.left.left is raised one level,
	 *	root.left.right does not change levels,
	 *	root.right is lowered one level,
	 * 	the new root is returned.
	 *	@param localRoot The root of the red-black tree to be rotated
	 */
		
    public void leftRotate(Node localRoot){

        Node localRoot_Right = localRoot.right;
        localRoot.right = localRoot_Right.left;

        if (localRoot_Right.left != NULL_Tree) {
            localRoot_Right.left.parent = localRoot;
        }

        localRoot_Right.parent = localRoot.parent;

        if (localRoot.parent == null){
            this.root = localRoot_Right;
        }

        else if (localRoot == localRoot.parent.left){
            localRoot.parent.left = localRoot_Right;
        }

        else {
            localRoot.parent.right = localRoot_Right;
        }

        localRoot_Right.left = localRoot;
        localRoot.parent = localRoot_Right;
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**  
     *  Rotate left at node localRoot
	 *	
     *	Method to perform a right rotation.
	 *	@pre root is the root of a red-black tree.
	 *	@post root.right is the root of a red-black tree,
	 *	root.right.right is raised one level,
	 *	root.right.left does not change levels,
	 *	root.left is lowered one level,
	 *	the new root is returned.
	 *	@param localRoot The root of the red-black tree to be rotated
		
	*/
    public void rightRotate(Node localRoot){

        Node localRoot_Left = localRoot.left;
        localRoot.left = localRoot_Left.right;

        if (localRoot_Left.right != NULL_Tree) {
            localRoot_Left.right.parent = localRoot;
        }

        localRoot_Left.parent = localRoot.parent;

        if (localRoot.parent == null) {
            this.root = localRoot_Left;
        }

        else if (localRoot == localRoot.parent.right){
            localRoot.parent.right = localRoot_Left;
        }

        else {
            localRoot.parent.left = localRoot_Left;
        }

        localRoot_Left.right = localRoot;
        localRoot.parent = localRoot_Left;
    }}

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
