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
 * This method sort the given value
 */
public class SelectionSort<T extends Comparable<T>>
{
    /**
     * 
     * @param arr given  LinkedList
     * @param arr2  given  LinkedList
     */
    public void sort(LinkedList<T> arr,LinkedList<T> arr2)
    {
        int n = arr.size();

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr.get(j).compareTo(arr.get(min_idx)) < 0 )
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            T temp = arr.get(min_idx);
            arr.set(min_idx,arr.get(i));
            arr.set(i,temp);

            T temp2 = arr2.get(min_idx);
            arr2.set(min_idx,arr2.get(i));
            arr2.set(i,temp2);

        }
    }
}