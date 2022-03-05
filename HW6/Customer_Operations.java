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
/*---------------------------------------------CUSTOMER CLASS Interface---------------------------------------*/
/*------------------------------------------------------------------------------------------------------------*/
/**
 * This interface inside all operation of customer
 */
public  interface Customer_Operations{
    void search_Product(String product_name)throws IOException;
    void print_searchedProduct();
    void sorting_ProductName();
    void sorting_Price();
    void sorting_DiscountedPrice();
    void threshold_Lower_Price(int lower)throws IOException;
    void threshold_Upper_Price(int upper)throws IOException;
    void threshold_UpperAndLower_Price(int lower,int upper)throws IOException;
    void threshold_Lower_DiscountedPrice(int lower)throws IOException;
    void threshold_Upper_DiscountedPrice(int upper)throws IOException;
    void threshold_UpperAndLower_DiscountedPrice(int lower,int upper)throws IOException;
    void order()throws IOException;
    void all_product_Trader(String trader_Name)throws IOException;
}