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
 * Java program for implementation of Heap Sort
 */
public  class HeapSort {
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * 
     * @param arr  given LinkedList
     * @param arr2  given LinkedList
     */
    public void sort(LinkedList<Integer> arr,LinkedList<String> arr2)
    {
        int n = arr.size();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr,arr2, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr.get(0);
            arr.set(0,arr.get(i));
            arr.set(i,temp);

            String temp2 = arr2.get(0);
            arr2.set(0,arr2.get(i));
            arr2.set(i,temp2);

            // call max heapify on the reduced heap
            heapify(arr,arr2, i, 0);
        }
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap

    /**
     * 
     * @param arr   given LinkedList
     * @param arr2   given LinkedList
     * @param n  given integer
     * @param i   given integer
     */
    public void heapify(LinkedList<Integer> arr,LinkedList<String> arr2, int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr.get(l)>arr.get(largest))
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr.get(r)>arr.get(largest))
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr.get(i);
            arr.set(i,arr.get(largest));
            arr.set(largest,swap);

            String swap2 = arr2.get(i);
            arr2.set(i,arr2.get(largest));
            arr2.set(largest,swap2);

            // Recursively heapify the affected sub-tree
            heapify(arr,arr2, n, largest);
        }
    }

}