import java.io.*;
@SuppressWarnings("unchecked")

/** Class for a binary search tree that extends BinaryTree class, implements SearchTree interface .*/
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    // Data Fields
    /** Return value from the public add method. */
    protected boolean addReturn;

    /** Return value from the public delete method. */
    private E deleteReturn;

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /** Starter method add.
     pre: The object to insert must implement the
     Comparable interface.
     @param item The object being inserted
     @return true if the object is inserted, false
     if the object already exists in the tree
     */
    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /** Recursive add method.
     post: The data field addReturn is set true if the item is added to
     the tree, false if the item is already in the tree.
     @param localRoot The local root of the subtree
     @param item The object to be inserted
     @return The new local root that now contains the
     inserted item
     */
    private Node<E> add(Node<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree — insert it.
            addReturn = true;
            return new Node<>(item);
        }else if (item.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            // item is greater than localRoot.data
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /** Starter method delete.
     post: The object is not in the tree.
     @param target The object to be deleted
     @return The object deleted from the tree
     or null if the object was not in the tree
     @throws ClassCastException if target does not implement
     Comparable
     */
    public E remove(E target) {
        root = delete(root, target);
        return deleteReturn;
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /** Recursive delete method.
     post: The item is not in the tree;
     deleteReturn is equal to the deleted item
     as it was stored in the tree or null
     if the item was not found.
     @param localRoot The root of the current subtree
     @param item The item to be deleted
     @return The modified local root that does not contain
     the item
     */
    private Node<E> delete(Node<E> localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }
        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        }else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        }else {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            }else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            }else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                }else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }}}

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /** Find the node that is the
     inorder predecessor and replace it
     with its left child (if any).
     post: The inorder predecessor is removed from the tree.
     @param parent The parent of possible inorder
     predecessor (ip)
     @return The data in the ip
     */
    private E findLargestChild(Node<E> parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.right.right == null){
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        }
        else {
            return findLargestChild(parent.right);
        }
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * This method  calls preOrderRec method
     */
    public void preOrder(){
        preOrderRec(root);
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * A utility function to
     * do preOrder traversal of BST
     * @param root   root Node
     */
    public void preOrderRec(Node<E> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * This method,
     * return true if this Binary Search Tree is a AVL Tree
     * return false if this Binary Search Tree is not a AVL Tree  
     *
     * @return a booleand variable
     */
    public boolean isAvl(){
        return BST_isBalanced_like_AVL(root);
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * In this method,
     * Returns true if Binary Search Tree is height-balanced as AVL Tree
     * The Binary Search Tree controlling to start the given node,
     * The Binary Search Tree's any node's left subTree and right subTree height difference smaller or equal 1
     * The Binary Search Tree can be AVL Tree, if heifgt differen more than 1 it can not be possible. 
     *
     * @param localRoot  given root
     * @return return true if the Binary Search Tree Balanced as AVL Tree
     */
    public boolean BST_isBalanced_like_AVL(Node<E> localRoot){

        // height of left subtree 
        int leftheight; 
        
        // height of right subtree 
        int rightheight; 

        // If tree is empty then return true because empty BST is a AVL TRee
        if (localRoot == null){
            return true;
        }

        //In this part,
        // find the height of left and right sub trees with using height_tree method
        leftheight = height_tree(localRoot.left);
        rightheight = height_tree(localRoot.right);
        int height_difference=Math.abs(leftheight - rightheight);

        // If the rule of the AVL Tree is valid, then return true.
        if (height_difference <= 1 && BST_isBalanced_like_AVL(localRoot.left) && BST_isBalanced_like_AVL(localRoot.right)){
            return true;
        }

        // If the rule of the AVL Tree is not valid, then return false.
        return false;
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * In this method,
     * find the height that is the number of nodes along the longest path from the localRoot node
     *  down to the farthest leaf node.
     *
     * @param localRoot given root 
     * @return return the given  tree node
     */
    public int height_tree(Node<E> localRoot){

        // if given tree is empty, then return 0
        if (localRoot == null){
            return 0;
        }
 
        // If tree is not empty then sum max of left height and right heights and recusivly add 1 
        return 1 + Math.max(height_tree(localRoot.left), height_tree(localRoot.right));
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * An inner class that holds the node' subTree height.
     * i Crete it because the code  is using this in the helper method to determine any node valid for the Red-Black Tree rules
     */
    private class Height{
        //Any node's subTree Height    
        private int h;

        //Initially 0
        public Height(){
            h = 0;
        }
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /*
        In a Red-Black Tree, every path through a leaf has the same number of black nodes, 
        and at least every second node on the path will be black, since a red node can't have a red child. 
        Therefore, the one with the most red nodes's the longest path to a leaf in the tree 
        is at most twice as long as the shortest path to a leaf.
    */

    /**
     * This method,
     * return true if this Binary Search Tree is a Red-Black Tree
     * return false if this Binary Search Tree is not a Red-Black Tree
     * creating maxheight and minheight object and send to helper method
     * for the determine each node is valid for the Red-Black Tree rules
     * 
     * @return a boolean variable 
     */
    public boolean is_Red(){
        
        // max height a node
        Height maxheight=new Height();
        
        // min height a node
        Height minheight=new Height();

        return BST_isBalanced_like_RedBlack(root, maxheight, minheight);
    }

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

    /**
     * In this method,
     * The code checks the Binary Search Tree.it starts the given root point. 
     * the Checking rule is : the one with the most red nodes's the longest path to a leaf in the tree 
     *   is at most twice as long as the shortest path to a leaf.
     *
     * The code using the node's max and min height (find them with using its right and left subtree) 
     *
     * @param localRootlocalRoot given localRoot the starting point the checking
     * @param maxheight   initial max height the starting point
     * @param minheight   initial min height the starting point
     * @return     return true if Binary Search Tree is Blanced like Red-Black Tree, or false.
     */
    public boolean BST_isBalanced_like_RedBlack(Node<E> localRootlocalRoot,Height maxheight, Height minheight){

        // if the Binary Search Tree is empty, then it is a Red-Black Tree so return true.
        if (localRootlocalRoot == null){
            maxheight.h = 0;
            minheight.h = 0;
            return true;
        }

        // Create the Height class object to holds max and min heights of node's left subtree
        Height leftmaxheight=new Height();
        Height leftminheight=new Height();

        // Create the Height class object to holds max and min heights of node's right subtree
        Height rigthmaxheight=new Height();
        Height rightminheight=new Height();

        // Control for if node's left subtree is balanced,
        if (BST_isBalanced_like_RedBlack(localRootlocalRoot.left, leftmaxheight, leftminheight) == false){
            return false;
        }

        // Control for if node's right subtree is balanced,
        if (BST_isBalanced_like_RedBlack(localRootlocalRoot.right, rigthmaxheight, rightminheight) == false){
            return false;
        }

        // determine node's the max and min heights 
        maxheight.h = Math.max(leftmaxheight.h, rigthmaxheight.h) + 1;
        minheight.h = Math.min(leftminheight.h, rightminheight.h) + 1;

        // In this part the code check the rule. if BST is valid for rule return true 
        if (maxheight.h <= 2*minheight.h){
            return true;
        }

        //if BST is valid for rule return false 
        return false;
    }
}
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/