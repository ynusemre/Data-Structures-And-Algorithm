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
/*---------------------------------------------Trader CLASS Interface---------------------------------------*/
/*------------------------------------------------------------------------------------------------------------*/
/**
 * This interface inside all operation of trader
 */
public  interface Trader_Operations{
    void create_productFile()throws IOException;
    void order_Meet()throws IOException;
    void order_Cancel()throws IOException;
    void add_Product_to_List(String st1,String st2,String st3,String st4,String st5,
                             String st6,String st7)throws IOException;
    void remove_Product_to_list(String id)throws IOException;
    void edit_Product_to_list(String id2,String edit_Price,String edit_DiscountedPrice,
                              String edit_Description)throws IOException;
    void see_order_list()throws IOException;
}		