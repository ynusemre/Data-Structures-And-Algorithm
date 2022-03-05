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
 * User information and registration check class
 */
public  class User_Info{
    private String name;
    private String id;
    private String password;

    /**
     *Default constructor
     */
    public User_Info(){
        this.name=null;
        this.id=null;
        this.password=null;
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     *  Constructor
     * @param name  user name
     * @param id     user id 
     * @param password   user password
     */
    public User_Info(String name,String id,String password){
        this.name=name;
        this.id=id;
        this.password=password;
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     *  Writing user to user.txt its unique name,id and password
     * @throws IOException  for file operations
     */
    public void write_user_file()throws IOException{
        Hashtable<String, Integer> ht = new Hashtable<>();

        File f2=new File("product.txt");
        BufferedReader s2=new BufferedReader(new FileReader(f2));
        String row2;

        int trader_id=10000000;

        while((row2 = s2.readLine()) != null) {
            String[] split2=row2.split(";");
            ht.put(split2[2],trader_id++);
        }
        s2.close();

        int k=200000;

        BufferedWriter r4=new BufferedWriter(new FileWriter("users.txt"));
        r4.write("User Name "+";"+" User ID "+";"+" User Password "+"\n");

        for (Map.Entry<String, Integer> e : ht.entrySet()){
            r4.write(e.getKey()+";"+e.getValue()+";"+(k++)+"\n");
        }

        r4.close();
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     *  if the given informatin is not exit in the user.txt this methor return true or false
     * @param name2  user name
     * @param ID2     user id 
     * @param password2   user password
     * @return      true or false
     * @throws IOException for file operations
     */
    public boolean check_Registiration(String name2,String ID2,String password2)throws IOException{
        File f4=new File("users.txt");

        if(!f4.exists()) {
            System.out.println("it is not found");
        }

        BufferedReader s5=new BufferedReader(new FileReader(f4));

        String row5= s5.readLine();
        int counter3=0;

        while(row5  != null) {
            String[] split5=row5.split(";");

            if(split5[1].equals(ID2) || split5[2].equals(password2)){
                counter3++;
            }
            row5= s5.readLine();
        }
        s5.close();
        if(counter3==0){
            writeUserFile("users.txt",name2,ID2, password2);
            return true;
        }
        if(counter3!=0){
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("While Registiration if any user write an exist id or password in the user.txt :");
            System.out.println("This User ID OR password already using");
            System.out.println("--------------------------------------------------------------------------------");
        }
        return false;
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     *  this method print given ArrayList and LinkedList
     * @param arr  given ArrayList
     * @param arr2  given ArrayList
     * @param arr3   given LinkedList
     */
    public void printArrayList(ArrayList<Integer> arr,ArrayList<String> arr2,LinkedList<Integer> arr3)
    {
        int n = arr.size();
        for (int i = 0; i < n; ++i)
            System.out.println(arr2.get(i)+arr.get(i)+"---"+arr3.get(i));
        System.out.println();
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * this method print given Queue
     * @param q  given Queue
     */
    public void printQueue(Queue<String> q){
        int n = q.size();
        for (int i = 0; i < n; i++)
            System.out.println(q.poll());
        System.out.println();
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * this method print given LinkedLists
     * @param arr  given LinkedList
     * @param arr2   given LinkedList
     */
    public void printLinkedList(LinkedList<Integer> arr,LinkedList<String> arr2)
    {
        int n = arr.size();
        for (int i = 0; i < n; ++i)
            System.out.println(arr2.get(i)+" "+arr.get(i));
        System.out.println();
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     *  this method print given LinkedLists
     * @param arr  given LinkedList
     * @param arr2   given LinkedList
     */
    public void printLinkedList2(LinkedList<String> arr,LinkedList<String> arr2)
    {
        int n = arr.size();
        for (int i = 0; i < n; ++i)
            System.out.println(arr.get(i)+" "+arr2.get(i));
        System.out.println();
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     *	this method append the end of the user.txt file
     * @param filename  given filen name
     * @param name   user name
     * @param ID     user id
     * @param password   user password
     * @throws IOException for file operations
     */
    public void writeUserFile(String filename,String name,String ID,String password)throws IOException{
        Writer w=new FileWriter(filename,true);
        w.write(name+";"+ID+";"+password+"\n");
        w.close();

    }
}