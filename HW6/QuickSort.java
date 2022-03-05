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
 * this method sort the given variables
 */
public class QuickSort {
    private static ArrayList<Integer> inputArray = new ArrayList<Integer>();
    private static ArrayList<String> inputArray2 = new ArrayList<String>();
    private LinkedList<Integer> linkedL1=new LinkedList<>();
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     *   Constructor
     * @param inputArray  given ArrayList
     * @param inputArray2  given ArrayList
     * @param linkedL1    given LinkedList
     */
    public QuickSort(ArrayList<Integer> inputArray,ArrayList<String> inputArray2,LinkedList<Integer> linkedL1){
        this.inputArray = inputArray;
        this.inputArray2 = inputArray2;
        this.linkedL1 = linkedL1;
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * 
     * @param start  start point 
     * @param end   end point 
     */
    public void startQuickStart(int start,int end){
        int q;
        if(start<end){
            q = partition(start, end);
            startQuickStart(start, q);
            startQuickStart(q+1, end);
        }
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * 
     * @return  the wants to sort ArrayList
     */
    public ArrayList<Integer> getSortedArray(){
        return QuickSort.inputArray;
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * 
     * @param start start point
     * @param end   end point
     * @return   length
     */
    public int partition(int start,int end){
        int init = start;
        int length = end;

        Random r = new Random();
        int pivotIndex = nextIntInRange(start,end,r);
        int pivot = inputArray.get(pivotIndex);



        while(true){
            while(inputArray.get(length)>pivot && length>start){
                length--;
            }

            while(inputArray.get(init)<pivot && init<end){
                init++;
            }

            if(init<length){
                int temp;
                temp = inputArray.get(init);
                inputArray.set(init,inputArray.get(length));
                inputArray.set(length,temp);

                String temp2 = inputArray2.get(init);
                inputArray2.set(init,inputArray2.get(length));
                inputArray2.set(length,temp2);

                int temp3 = linkedL1.get(init);
                linkedL1.set(init,linkedL1.get(length));
                linkedL1.set(length,temp3);


                length--;
                init++;
            }else{

                return length;
            }
        }

    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * 
     * @param min   min value
     * @param max   max value 
     * @param rng  random value
     * @return   integer
     */
    // Below method is to just find random integer from given range
    public static int nextIntInRange(int min, int max, Random rng) {
        if (min > max) {
            throw new IllegalArgumentException("Cannot draw random int from invalid range [" + min + ", " + max + "].");
        }
        int diff = max - min;
        if (diff >= 0 && diff != Integer.MAX_VALUE) {
            return (min + rng.nextInt(diff + 1));
        }
        int i;
        do {
            i = rng.nextInt();
        } while (i < min || i > max);
        return i;
    }
}