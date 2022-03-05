import java.io.*;
@SuppressWarnings("unchecked")

/** Class for a binary tree that stores type E objects. */
public class BinaryTree<E> implements Serializable {

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/	

	// Insert inner class Node<E> here.
	/** Class to encapsulate a tree node. */
	protected static class Node<E> implements Serializable {
		
		// Data Fields
		/** The information stored in this node. */
		protected E data;
		
		/** Reference to the left child. */
		protected Node<E> left;
		
		/** Reference to the right child. */
		protected Node<E> right;

		// Constructors
		/** Construct a node with given data and no children.
		@param data The data to store in this node
		*/
		public Node(E data) {
			this.data = data;
			left = null;
			right = null;
		}

		// Methods
	 	/** Return a string representation of the node.
			@return A string representation of the data fields
		*/
		public String toString () {
			return data.toString();
		}
	}

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

	// Data Field
	/** The root of the binary tree */
	protected Node<E> root;
	
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

	public BinaryTree() {
		 root = null;
	}

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

	protected BinaryTree(Node<E> root) {
		this.root = root;
	}

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/

	/** Constructs a new binary tree with data in its root leftTree
		 as its left subtree and rightTree as its right subtree.
	*/
	public BinaryTree(E data, BinaryTree<E> leftTree,BinaryTree<E> rightTree) {
		 root = new Node<>(data);
		 if (leftTree != null) {
		 	root.left = leftTree.root;
		 }else {
		 	root.left = null;
		 }
		 if (rightTree != null) {
		 	root.right = rightTree.root;
		 }else {
		 	root.right = null;
		 }
	}
}		
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/