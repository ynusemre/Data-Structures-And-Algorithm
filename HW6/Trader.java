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
 * Trader Class extends User_Info class and implemets Trader_Operations interface
 */
public  class Trader extends User_Info implements Trader_Operations{
    /**
     *  Constructor
     * @param name   trader name
     * @param id     trader id
     * @param password    trader password
     */
    public Trader(String name,String id,String password){
        super(name,id,password);
    }

    /**
     * Trader create a product.txt file 
     * @throws IOException   for file operations
     */
    public void create_productFile()throws IOException{
        File f=new File("e-commerce-samples .csv");

        if(!f.exists()) {
            System.out.println("it is not found");
        }

        Writer r=new FileWriter("product.txt");
        BufferedReader s=new BufferedReader(new FileReader(f));
        String row;
        while((row = s.readLine()) != null) {
            String[] split=row.split(";");
            r.write(split[0]+";"+split[1]+";"+split[6]+";"+split[3]+";"+split[4]+";"+split[5]+";"+split[2]+"\n");
        }
        s.close();
        r.close();
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Trader see the order of customer
     * @throws IOException   for file operations
     */
    public void see_order_list()throws IOException{

        File f5=new File("order.txt");

        BufferedReader s4=new BufferedReader(new FileReader(f5));
        String row4;

        System.out.println();
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("------------------------- Customers Orders List --------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();

        while((row4= s4.readLine()) != null) {
            String[] split4=row4.split(";");


            System.out.println(split4[0]+";"+split4[1]+";"+split4[2]+";"+split4[3]);
        }

        s4.close();
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Trader meet the order of customer
     * @throws IOException    for file operations
     */
    public void order_Meet()throws IOException{
        File f7=new File("MYorder.txt");
        File f5=new File("order.txt");
        Writer r3=new FileWriter(f7);
        BufferedReader s4=new BufferedReader(new FileReader(f5));
        String row4;


        while((row4= s4.readLine()) != null) {
            String[] split4=row4.split(";");

            if(split4[0].equals("Wallmantra")){
                if(split4[1].equals("Wallmantra Large Vinyl Stickers Sticker")){
                    r3.write(split4[0]+";"+split4[1]+";"+split4[2]+";"+split4[3]+" (MEET)"+"\n");
                    continue;
                }
            }
            r3.write(split4[0]+";"+split4[1]+";"+split4[2]+";"+split4[3]+"\n");
        }

        s4.close();
        f5.delete();
        r3.close();
        f7.renameTo(f5);

        System.out.println();
        System.out.println();
        System.out.println("----- After the Order Meet Operation Order.txt -----");
        System.out.println();

        File f6=new File("order.txt");
        BufferedReader s6=new BufferedReader(new FileReader(f6));
        String row6;

        while((row6= s6.readLine()) != null) {
            String[] split6=row6.split(";");
            System.out.println(split6[0]+"   "+split6[1]+"   "+split6[2]+"   "+split6[3]);

        }

        s6.close();
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Trader cancel the order of customer
     * @throws IOException   for file operations
     */
    public void order_Cancel()throws IOException{
        File f7=new File("MYorder.txt");
        File f5=new File("order.txt");
        Writer r3=new FileWriter(f7);
        BufferedReader s4=new BufferedReader(new FileReader(f5));
        String row4;


        while((row4= s4.readLine()) != null) {
            String[] split4=row4.split(";");

            if(split4[0].equals("Wallmantra")){

                if(split4[1].equals("Wallmantra Medium Vinyl Stickers Sticker")){
                    r3.write(split4[0]+";"+split4[1]+";"+split4[2]+";"+split4[3]+" (CANCELED)"+"\n");
                    continue;
                }
            }
            r3.write(split4[0]+";"+split4[1]+";"+split4[2]+";"+split4[3]+"\n");
        }

        s4.close();
        f5.delete();
        r3.close();
        f7.renameTo(f5);

        System.out.println();
        System.out.println();
        System.out.println("----- After the Order Cancel Operation Order.txt -----");
        System.out.println();

        File f6=new File("order.txt");
        BufferedReader s6=new BufferedReader(new FileReader(f6));
        String row6;

        while((row6= s6.readLine()) != null) {
            String[] split6=row6.split(";");
            System.out.println(split6[0]+"   "+split6[1]+"   "+split6[2]+"   "+split6[3]);

        }

        s6.close();
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Trader add new product end of the product.txt
     * @param st1  product's id
     * @param st2   product's name
     * @param st3    trader name
     * @param st4      product's price
     * @param st5		product's discounted price
     * @param st6     product's description
     * @param st7    product's tree
     * @throws IOException   for file operations
     */
    public void add_Product_to_List(String st1,String st2,String st3,String st4,String st5,
                                    String st6,String st7)throws IOException{

        File f8=new File("MYproduct.txt");
        File f9=new File("product.txt");

        Writer r7=new FileWriter(f8,true);
        BufferedReader s7=new BufferedReader(new FileReader(f9));
        String row7;

        int counter=0;

        while((row7= s7.readLine()) != null) {
            String[] split7=row7.split(";");

            if(split7[0].equals(st1) || split7[1].equals(st2) || split7[3].equals(st4)
                    || split7[4].equals(st5) || split7[5].equals(st6) || split7[6].equals(st7)){
                counter++;
            }
            r7.write(split7[0]+";"+split7[1]+";"+split7[2]+";"+split7[3]+";"+split7[4]+";"+split7[5]+";"+split7[6]+"\n");

        }
        if(counter==0){
            r7.write(st1+";"+st2+";"+st3+";"+st4+";"+st5+";"+st6+";"+st7+"\n");
        }
        if(counter!=0){
            System.out.println("At least one of the given product values matches the value of another product in the product file.");
        }

        r7.close();
        s7.close();
        f9.delete();
        f8.renameTo(f9);
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * Trader remove the product from product.txt
     * @param id   product if
     * @throws IOException   for file operations
     */
    public void remove_Product_to_list(String id)throws IOException{
        File f8=new File("MYproduct.txt");
        File f9=new File("product.txt");

        Writer r7=new FileWriter(f8,true);
        BufferedReader s7=new BufferedReader(new FileReader(f9));
        String row7;

        int counter=0;

        while((row7= s7.readLine()) != null) {
            String[] split7=row7.split(";");

            if(split7[0].equals(id)){
                counter++;
                System.out.println();
                System.out.println(" The product with the given product id ("+id+") is removed from the product list. ");
                continue;
            }
            r7.write(split7[0]+";"+split7[1]+";"+split7[2]+";"+split7[3]+";"+split7[4]+";"+split7[5]+";"+split7[6]+"\n");
        }

        if(counter==0){
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("if given product id does not matct any product id in the product.txt :");
            System.out.println(" Given Product id ("+id+") does not equal any product id in the product list. ");
            System.out.println("--------------------------------------------------------------------------------");
        }

        r7.close();
        s7.close();
        f9.delete();
        f8.renameTo(f9);
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/
    /*----------------------------------------------------------------------------------------------------------------*/

    /**
     * assign new values to trader's wanted product
     * @param id2      editting product's id
     * @param edit_Price    editting product's price
     * @param edit_DiscountedPrice    editting product's discounted price
     * @param edit_Description   editting product's description
     * @throws IOException    for file operations
     */
    public void edit_Product_to_list(String id2,String edit_Price,String edit_DiscountedPrice,
                                     String edit_Description)throws IOException{

        File f8=new File("MYproduct.txt");
        File f9=new File("product.txt");

        Writer r7=new FileWriter(f8,true);
        BufferedReader s7=new BufferedReader(new FileReader(f9));
        String row7;

        int counter2=0;
        int counter=0;
        while((row7= s7.readLine()) != null) {
            String[] split7=row7.split(";");


            if(split7[0].equals(id2)){
                counter++;

                if(split7[3].equals(edit_Price) || split7[4].equals(edit_DiscountedPrice)
                        || split7[5].equals(edit_Description)){
                    counter2++;
                }
                if(counter2!=0){
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("if editting values match any value in the product file :");
                    System.out.println("Editing values must be unique but there are anyone match with product file. ");
                    System.out.println("--------------------------------------------------------------------------------");
                }
                if(counter2==0){
                    System.out.println();
                    System.out.println(id2+" Product is editing ...");
                    System.out.println("New Price :"+edit_Price+"--- Old Price :"+split7[3]);
                    System.out.println("New Discounted Price :"+edit_DiscountedPrice+"--- Old Discounted Price :"+split7[4]);
                    System.out.println("New Description :"+edit_Description);

                    split7[3]=edit_Price;
                    split7[4]=edit_DiscountedPrice;
                    split7[5]=edit_Description;
                }
            }
            r7.write(split7[0]+";"+split7[1]+";"+split7[2]+";"+split7[3]+";"+split7[4]+";"+split7[5]+";"+split7[6]+"\n");

        }
        if(counter==0){
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("if given product id does not matct any product id in the product.txt :");
            System.out.println("Given Product id ("+id2+") does not equal any product id in the product list. ");
            System.out.println("--------------------------------------------------------------------------------");
        }

        r7.close();
        s7.close();
        f9.delete();
        f8.renameTo(f9);
    }


}