import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.util.Hashtable;
import java.util.Map;
@SuppressWarnings("unchecked")

/*------------------------------------------------------------------------------------------------------------*/
/*---------------------------------------------CUSTOMER CLASS-------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------------*/
/**
 * Customer Class extends User_Info class and implemets Customer_Operations interface
 */
public class Customer extends User_Info implements Customer_Operations{
    private BinarySearchTree<String> tree = new BinarySearchTree<>();

    private ArrayList<String> arrL1=new ArrayList<>();
    private ArrayList<Integer> arrL2=new ArrayList<>();
    private ArrayList<String> arrL3=new ArrayList<>();

    private LinkedList<Integer> linkedL1=new LinkedList<>();
    private LinkedList<String> linkedL2=new LinkedList<>();
    private LinkedList<String> linkedL3=new LinkedList<>();
    private LinkedList<String> linkedL4=new LinkedList<>();

    private String product_name;
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Constructor
     * @param name customer name
     * @param id  customer id
     * @param password  customer password
     */
    public Customer(String name,String id,String password){
        super(name,id,password);
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Customer search the product in the product.txt
     * @param product_name Customer wants to search this word
     * @throws IOException  for file operations
     */
    public void search_Product(String product_name)throws IOException{
        this.product_name=product_name;

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("----------------- "+product_name+" is searching in the product.txt -------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();

        System.out.println("Product Name      Product ID         Trader         Price        Discounted Price");

        File f2=new File("product.txt");
        BufferedReader s2=new BufferedReader(new FileReader(f2));
        String row2;

        while((row2 = s2.readLine()) != null) {
            String[] split2=row2.split(";");

            if(split2[1].contains(product_name) || split2[5].contains(product_name) ){
                tree.insert(split2[1]+"---"+split2[0]+"---"+split2[2]+"---"+split2[3]+"---"+split2[4]);

                linkedL2.add(split2[1]);

                linkedL4.add("---"+split2[0]+"---"+split2[2]+"---"+split2[3]+"---"+split2[4]);
                arrL3.add(split2[1]+"---"+split2[0]+"---"+split2[2]+"---");

                arrL1.add(split2[2]);

                int number = Integer.parseInt(split2[3]);
                arrL2.add(number);

                int number2 = Integer.parseInt(split2[4]);
                linkedL1.add(number2);
                linkedL3.add(split2[0]+"---"+split2[1]+"---"+split2[2]+"---"+split2[3]);

            }
        }
        s2.close();
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Print Searching product as Decreasing Order
     */
    
    public void print_searchedProduct(){
        tree.inorder();           //Search with Deacreasing order
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Sorting product name as increasing order
     */
    public void sorting_ProductName(){
        SelectionSort ob2 = new SelectionSort();
        ob2.sort(linkedL2,linkedL4);

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("------------------------ Sorted As Product Name --------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Product Name      Product ID         Trader         Price        Discounted Price");

        printLinkedList2(linkedL2,linkedL4);                        
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Sorting normal price as increasing order
     */
    public void sorting_Price(){
        QuickSort qsu = new QuickSort(arrL2,arrL3,linkedL1);
        qsu.startQuickStart(0, arrL2.size()-1);

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("------------------------ Sorted As Normal Price --------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Product Name      Product ID         Trader         Price        Discounted Price");

        printArrayList(arrL2,arrL3,linkedL1);                          
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Sorting discounted price as increasing order
     */
    public void sorting_DiscountedPrice(){
        HeapSort ob = new HeapSort();
        ob.sort(linkedL1,linkedL3);

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("------------------------ Sorted As Discounted Price ----------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Product Name      Product ID         Trader         Price        Discounted Price");

        printLinkedList(linkedL1,linkedL3);							
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     *   Prices greater than lower bound
     * @param lower    given bound
     * @throws IOException  for file operations
     */
    public void threshold_Lower_Price(int lower)throws IOException{
        File f2=new File("product.txt");
        BufferedReader s2=new BufferedReader(new FileReader(f2));
        String row2;

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("-------------------------- Prices greater than "+lower+" -----------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Product Name      Product ID         Trader         Price        Discounted Price");

        while((row2 = s2.readLine()) != null) {
            String[] split2=row2.split(";");

            if(split2[1].contains(product_name) || split2[5].contains(product_name) ){
                int number = Integer.parseInt(split2[3]);
                if(number>lower){
                    System.out.println(split2[1]+"---"+split2[0]+"---"+split2[2]+"---"+split2[3]+"---"+split2[4]);

                }
            }
        }
        s2.close();
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     *   Prices smaller than upper bound
     * @param upper   upper bound
     * @throws IOException  for file operations
     */
    public void threshold_Upper_Price(int upper)throws IOException{
        File f2=new File("product.txt");
        BufferedReader s2=new BufferedReader(new FileReader(f2));
        String row2;

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("------------------------ Prices smaller than "+upper+" -------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Product Name      Product ID         Trader         Price        Discounted Price");

        while((row2 = s2.readLine()) != null) {
            String[] split2=row2.split(";");

            if(split2[1].contains(product_name) || split2[5].contains(product_name) ){
                int number = Integer.parseInt(split2[3]);
                if(upper>number){
                    System.out.println(split2[1]+"---"+split2[0]+"---"+split2[2]+"---"+split2[3]+"---"+split2[4]);

                }
            }
        }
        s2.close();

    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     *  Prices greater than lower bound  and smaller than upper bound
     * @param lower  lower bound
     * @param upper   upper bound
     * @throws IOException   for file operations
     */
    public void threshold_UpperAndLower_Price(int lower,int upper)throws IOException{
        File f2=new File("product.txt");
        BufferedReader s2=new BufferedReader(new FileReader(f2));
        String row2;

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------- Prices greater than "+lower+ " and smaller than "+ upper +" ----------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Product Name      Product ID         Trader         Price        Discounted Price");

        while((row2 = s2.readLine()) != null) {
            String[] split2=row2.split(";");

            if(split2[1].contains(product_name) || split2[5].contains(product_name) ){
                int number = Integer.parseInt(split2[3]);
                if(upper>number && number > lower){
                    System.out.println(split2[1]+"---"+split2[0]+"---"+split2[2]+"---"+split2[3]+"---"+split2[4]);
                }
            }
        }
        s2.close();

    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     *  Discounted Prices greater than lower bound
     * @param lower    lower bound
     * @throws IOException   for file operations
     */
    public void threshold_Lower_DiscountedPrice(int lower)throws IOException{
        File f2=new File("product.txt");
        BufferedReader s2=new BufferedReader(new FileReader(f2));
        String row2;

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("------------------- Discounted Prices greater than "+lower+" -------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Product Name      Product ID         Trader         Price        Discounted Price");

        while((row2 = s2.readLine()) != null) {
            String[] split2=row2.split(";");

            if(split2[1].contains(product_name) || split2[5].contains(product_name) ){
                int number = Integer.parseInt(split2[4]);
                if(number>lower){
                    System.out.println(split2[1]+"---"+split2[0]+"---"+split2[2]+"---"+split2[3]+"---"+split2[4]);
                }
            }
        }
        s2.close();

    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Discounted Prices smaller than upper bound
     * @param upper  upper bound
     * @throws IOException   for file operations
     */
    public void threshold_Upper_DiscountedPrice(int upper)throws IOException{
        File f2=new File("product.txt");
        BufferedReader s2=new BufferedReader(new FileReader(f2));
        String row2;

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("------------------- Discounted Prices smaller than "+upper+" -------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Product Name      Product ID         Trader         Price        Discounted Price");

        while((row2 = s2.readLine()) != null) {
            String[] split2=row2.split(";");

            if(split2[1].contains(product_name) || split2[5].contains(product_name) ){
                int number = Integer.parseInt(split2[4]);
                if(upper>number){
                    System.out.println(split2[1]+"---"+split2[0]+"---"+split2[2]+"---"+split2[3]+"---"+split2[4]);
                }
            }
        }
        s2.close();

    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * 	Discounted Prices greater than lower bound  and smaller than upper bound	
     * @param lower  lower bound
     * @param upper   upper bound
     * @throws IOException   for file operations
     */
    public void threshold_UpperAndLower_DiscountedPrice(int lower,int upper)throws IOException{
        File f2=new File("product.txt");
        BufferedReader s2=new BufferedReader(new FileReader(f2));
        String row2;

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("------ Discounted Prices greater than "+lower+ " and smaller than "+ upper +" --");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Product Name      Product ID         Trader         Price        Discounted Price");

        while((row2 = s2.readLine()) != null) {
            String[] split2=row2.split(";");

            if(split2[1].contains(product_name) || split2[5].contains(product_name) ){
                int number = Integer.parseInt(split2[4]);
                if(upper>number && number > lower){
                    System.out.println(split2[1]+"---"+split2[0]+"---"+split2[2]+"---"+split2[3]+"---"+split2[4]);
                }
            }
        }
        s2.close();
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Customer order product and they are print to screen
     * @throws IOException   for file operations
     */
    public void order()throws IOException{
        Writer r2=new FileWriter("order.txt");
        r2.write("  Trader "+" ; "+"    Product Name "+" ; "+"         Normal Price "+" ; "+"Discounted Price "+"\n");
        r2.write("Wallmantra"+";"+"Wallmantra Large Vinyl Stickers Sticker"+";"+"1958"+";"+"1424"+"\n");
        r2.write("Wallmantra"+";"+"Wallmantra Medium Vinyl Stickers Sticker"+";"+"779"+";"+"623"+"\n");
        r2.write("Creative Width Decor"+";"+"Creative Width Decor Small Vinyl Sticker Sticker"+";"+"799"+";"+"399"+"\n");
        r2.write("Happy walls"+";"+"Happy walls Extra Large PVC vinyl Sticker"+";"+"1299"+";"+"299"+"\n");

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("------------------------- Customers Orders These Product -----------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();

        System.out.println("  Trader "+" ; "+"    Product Name "+" ; "+"         Normal Price "+" ; "+"Discounted Price ");
        System.out.println("Wallmantra"+";"+"Wallmantra Large Vinyl Stickers Sticker"+";"+"1958"+";"+"1424");
        System.out.println("Wallmantra"+";"+"Wallmantra Medium Vinyl Stickers Sticker"+";"+"779"+";"+"623");
        System.out.println("Creative Width Decor"+";"+"Creative Width Decor Small Vinyl Sticker Sticker"+";"+"799"+";"+"399");
        System.out.println("Happy walls"+";"+"Happy walls Extra Large PVC vinyl Sticker"+";"+"1299"+";"+"299");

        r2.close();
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Customer see all product of given trader
     * @param trader_Name    customer wants to see this trader all product
     * @throws IOException   for file operations
     */
    public void all_product_Trader(String trader_Name)throws IOException{
        Queue<String> q= new LinkedList<>();

        File f3=new File("product.txt");
        BufferedReader s3=new BufferedReader(new FileReader(f3));
        String row3;
        while((row3 = s3.readLine()) != null) {
            String[] split3=row3.split(";");

            if(split3[2].contains(trader_Name)){
                q.offer(split3[1]);
            }
        }
        s3.close();

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("-------------------- All product of given Trader "+ trader_Name  +" ------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();

        printQueue(q);
    }


}