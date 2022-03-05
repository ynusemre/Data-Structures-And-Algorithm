import java.util.*;

/**
 * KWSingleLinkedList Class
 * @param <E>
 */
public class KWSingleLinkedList<E> {
    /** Reference to list head. */
    private Node<E> head = null;
    /** The number of items in the list */
    private int size = 0;

    /** A Node is the building block for a single‐linked list. */
    private static class Node<E> {
        // Data Fields
        /** The reference to the data. */
        private E data;
        /** The reference to the next node. */
        private Node<E> next;
        // Constructors
        /** Creates a new node with a null next field.
         @param dataItem The data stored
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }
        /** Creates a new node that references another node.
         @param dataItem The data stored
         @param nodeRef The node referenced by new node
         */
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    /**
     * adding element to first of the list.
     * @param item
     */
    public void addFirst(E item) {
        head = new Node<>(item, head);
        size++;
    }

    /**
     * adding element to after of a node.
     * @param node
     * @param item
     */
    private void addAfter(Node<E> node, E item) {
        node.next = new Node<>(item, node.next);
        size++;
    }

    /**
     * removing element to after of a node.
     * @param node
     * @return
     */
    private E removeAfter(Node<E> node) {
        Node<E> temp = node.next;
        if (temp != null) {
            node.next = temp.next;
            size=size-1;
            return temp.data;
        }
        else {
            return null;
        }
    }

    /**
     * removing element to first of the list.
     * @return
     */
    private E removeFirst() {
        Node<E> temp = head;
        if (head != null) {
            head = head.next;
        }
        // Return data at old head or null if list is empty.
        if (temp != null) {
            size=size-1;
            return temp.data;
        }
        else {
            return null;
        }
    }

    /**
     *  traverse head to the node of given index.
     * @param index
     * @return
     */
    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    /**
     *   given the node of given index.
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    /**
     *   set element to given index.
     * @param index
     * @param newValue
     * @return
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }

    /**
     *  add the element to given index.
     * @param index
     * @param item
     */
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        }
        else {
            int a=index-1;
            Node<E> node = getNode(a);
            addAfter(node, item);
        }
    }

    /**
     * add the element to the last of the list and return always ture.
     * @param item
     * @return
     */
    public boolean add(E item) {
        add(size, item);
        return true;
    }

    /**
     *  give the size of list.
     * @return
     */
    public int size(){
        return size;
    }
}