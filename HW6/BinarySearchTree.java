import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.util.Hashtable;
import java.util.Map;
@SuppressWarnings("unchecked")



/**
 *  Java program to demonstrate
 * insert operation in binary
 * search tree
 */
public  class BinarySearchTree <T extends Comparable<T>> {

    

    /**
     * Class containing left
     * and right child of current node
     * and key value
     * @param <T>  generic type
     */
    private static class Node <T>
    {
        T key;
        Node left, right;

        public Node(T item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    

    /**
     *  Constructor
     */
    public BinarySearchTree()
    {
        root = null;
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
   

    /**
     *  This method mainly calls insertRec()
     * @param key  a variable the wants to insert to BST
     */
    public void insert(T key)
    {
        root = insertRec(root, key);
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
	    
    /**
     * A recursive function to
     * insert a new key in BST
     * @param root  root node
     * @param key   given value
     * @return   Node
     */
    public Node insertRec(Node root, T key)
    {

	        /* If the tree is empty,
	           return a new node */
        if (root == null)
        {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key.compareTo((T)root.key)<=0)
            root.left = insertRec(root.left, key);
        else if (key.compareTo((T)root.key)>=0)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    

    /**
     * This method mainly calls InorderRec()
     */
    public void inorder()
    {
        inorderRec(root);
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
     

    /**
     * A utility function to
     * do inorder traversal of BST
     * @param root   root Node
     */
    public void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.right);
            System.out.println(root.key);
            inorderRec(root.left);
        }
    }
}