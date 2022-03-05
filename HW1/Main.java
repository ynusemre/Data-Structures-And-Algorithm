import java.util.Scanner;
/**
 * JavaDoc of Homework1.
 *
 * @author YunusEmreGeyik
 * @version 1.0.0
 * @since  2021-03-07
 */

/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/

/////////////////////////////////// Derived Function ///////////////////////////////////////////////////////////
///////////////////////////// Using For The Unit Test And Integration Test /////////////////////////////////////

/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/   
public class Main { 
    //When a user registers to the system, the options of that user are automatically tested.
    /**
     *   
     * @param args
     */
    public static void main(String args[]){

/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/        
    ///////////////////////////Administrator Authority Testing//////////////////////////////////////////// 
/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/
////////////////////////////////////////////////////////////////////////////////////////////////  ADMINISTRATOR REGISTRATION        
    System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----- Administrator Registration ----- ");
        String name,surname,e_mail,password;
        Scanner scan=new Scanner(System.in);
        int flag=1;

        System.out.println("Please Enter The Administrator Informations");
        System.out.print("Name :");
        name=scan.nextLine();
        System.out.print("Surname :");
        surname=scan.nextLine();
        System.out.print("E_Mail :");
        e_mail=scan.nextLine();
        System.out.print("Password :");
        password=scan.nextLine();

        Company person1=new Administrator(name,surname,e_mail,password);                    //Polimorfizm

        System.out.println();
        System.out.println("----------- Administrator Information -----------");
        System.out.println("Name : "+person1.GetName_of_customer());
        System.out.println("Surname : "+person1.GetSurname_of_customer());
        System.out.println("E_Mail : "+person1.GetE_mail_of_customer());
        System.out.println("Password : "+person1.GetPassword_of_customer());

        System.out.println();
/////////////////////////////////Setting Employee and Branch///////////////////////////////////////////////////////////
    System.out.println("-----------------------------------------------------------------------------------------");
        ((Administrator)person1).setNum_of_employee(15);
        System.out.println("----------- Initial Branch and Employee Number -----------");
        System.out.println("Number of Employee : "+((Administrator)person1).getNum_of_employee());
        System.out.println("Number of Branch : "+((Administrator)person1).getNum_of_branch());

        System.out.println();
/////////////////////////////////Adding Employee and Branch///////////////////////////////////////////////////////////
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----------- After the Adding Employee -----------");
        ((Administrator)person1).Adding_Employee(5);
        System.out.println("Number of Employee : "+((Administrator)person1).getNum_of_employee());
    
    System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        ((Administrator)person1).Adding_Branch(6);
        System.out.println("----------- After the Adding Branch -----------");
        System.out.println("Number of Branch : "+((Administrator)person1).getNum_of_branch());

        System.out.println();
//////////////////////////////////////Removing Employee and Branch//////////////////////////////////////////////////////
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------Removing the Adding Employee-----------");
        ((Administrator)person1).Remove_Employee(2);
        System.out.println("Number of Employee : "+((Administrator)person1).getNum_of_employee());

    System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        ((Administrator)person1).Remove_Branch(2);
        System.out.println("-----------Removing the Adding Branch-----------");
        System.out.println("Number of Branch : "+((Administrator)person1).getNum_of_branch());

        System.out.println();
/*------------------------------------------------------------------------------------------------------------*/
        System.out.println();   
    System.out.println("-----------------------------------------------------------------------------------------");    
        System.out.println("----------------------- Administrator Adding A Employee The System ------------------------------------------------------------------");
    System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Please Enter The Employee Informations");
        System.out.print("Name :");
        name=scan.nextLine();
        System.out.print("Surname :");
        surname=scan.nextLine();
        System.out.print("E_Mail :");
        e_mail=scan.nextLine();
        System.out.print("Password :");
        password=scan.nextLine();

        Employee person8=((Administrator)person1).Create_New_Account_Employee(name,surname,e_mail,password);

        System.out.println();
        System.out.println("-----------Employee Information (Adding By Administrator)-----------");
        System.out.println("Name : "+person8.GetName_of_customer());
        System.out.println("Surname : "+person8.GetSurname_of_customer());
        System.out.println("E_Mail : "+person8.GetE_mail_of_customer());
        System.out.println("Password : "+person8.GetPassword_of_customer());
/*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("---When The Employee Is Dismissed By The Administrator It Is Desired To Look At The Information Of The Dismissed Employee !!!");

        person8=((Administrator)person1).Deleting_Account_Employee(person8);
        try{
            System.out.println();
            System.out.println("-----------Employee Information(After The Removing Hakkı Employee)-----------");
            System.out.println("Name : "+person8.GetName_of_customer());
            System.out.println("Surname : "+person8.GetSurname_of_customer());
            System.out.println("E_Mail : "+person8.GetE_mail_of_customer());
            System.out.println("Password : "+person8.GetPassword_of_customer());
        }
        catch(NullPointerException e){
            System.out.println("!!! There is no employee. Administrator removed him !!!");
        }
/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/
///////////////////////////Employee Authority Testing////////////////////////////////////////////
/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/
////////////////////////////////////////////////////////////////////////////////////////////////  EMPLOYEE REGISTRATION 
    System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("-----Another Employee Registration----- ");
        System.out.println("Please Enter The Employee Informations");

        System.out.print("Name :");
        name=scan.nextLine();
        System.out.print("Surname :");
        surname=scan.nextLine();
        System.out.print("E_Mail :");
        e_mail=scan.nextLine();
        System.out.print("Password :");
        password=scan.nextLine();

        Company person2=new Employee(name,surname,e_mail,password);                        //Polimorfizm

        int[][]Office_Chairs=person2.getOffice_Chairs();
        int[][]Office_Desks=person2.getOffice_Desks();
        int[][]Meeting_Tables=person2.getMeeting_Tables();
        int[]Bookcases=person2.getBookcases();
        int[]Office_Cabinets=person2.getOffice_Cabinets();

        System.out.println();
        System.out.println("----------- Employee Information -----------");
        System.out.println("Name : "+person2.GetName_of_customer());
        System.out.println("Surname : "+person2.GetSurname_of_customer());
        System.out.println("E_Mail : "+person2.GetE_mail_of_customer());
        System.out.println("Password : "+person2.GetPassword_of_customer());

////////////////////////////////////////////////////////////////////////// Firstly Employee Supply The Furniture To Stock
    System.out.println("-----------------------------------------------------------------------------------------");
        for(int i=0;i<Office_Chairs.length;i++){
            for(int j=0;j<Office_Chairs[i].length;j++){
                ((Employee)person2).Supply_Office_Chairs(100,i,j);
            }
        }
        for(int i=0;i<Office_Desks.length;i++){
            for(int j=0;j<Office_Desks[i].length;j++){
                ((Employee)person2).Supply_Office_Desks(100,i,j);
            }
        }
        for(int i=0;i<Meeting_Tables.length;i++){
            for(int j=0;j<Meeting_Tables[i].length;j++){
                ((Employee)person2).Supply_Meeting_Tables(100,i,j);
            }
        }
        for(int i=0;i<Bookcases.length;i++){
            ((Employee)person2).Supply_Bookcases(100,i);
        }
        for(int i=0;i<Office_Cabinets.length;i++){
            ((Employee)person2).Supply_Office_Cabinets(100,i);
        }

/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/
///////////////////////////Customer Authority Testing////////////////////////////////////////////
/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/

/////////////////////////////////////////////////////////////////////////////////////////// ONLINE CUSTOMER REGISTRATION    
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----ONLINE Customer Registration----- ");
    System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Plase Enter The Customer Informations");
        System.out.print("Name :");
        name=scan.nextLine();
        System.out.print("Surname :");
        surname=scan.nextLine();
        System.out.print("E_Mail :");
        e_mail=scan.nextLine();
        System.out.print("Password :");
        password=scan.nextLine();
        
        Company person3=new Customer(name,surname,e_mail,password);

        System.out.println();
        System.out.println("----------- Online Customer Information -----------");
        System.out.println("----------- Created By Own -----------");
        System.out.println("Name : "+person3.GetName_of_customer());
        System.out.println("Surname : "+person3.GetSurname_of_customer());
        System.out.println("E_Mail : "+person3.GetE_mail_of_customer());
        System.out.println("Password : "+person3.GetPassword_of_customer());

/*------------------------------------------------------------------------------------------------------------*/        
//////////////////////////////////////////////////////////////////////   CUSTOMER INFORMED ABOUT ITS SPECIAL CUSTOMER NUMBER
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        ((Customer)person3).Inform_Customer_Number();
    System.out.println("-----------------------------------------------------------------------------------------");    
/*------------------------------------------------------------------------------------------------------------*/
////////////////////////////////////////////////////////////////////// CUSTOMER WANTS TO SEE PRODUCT LIST       
        System.out.println();
   System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----------------------------------Product List----------------------------------");
    System.out.println("-----------------------------------------------------------------------------------------");    
        ((Customer)person3).List_Of_Products();
/*------------------------------------------------------------------------------------------------------------*/
//////////////////////////////////////////////////////////////////////  CUSTOMER WANTS TO SEE PRODUCT STOCK        
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("------------------------  Initial Product Stock -------------------------");
    System.out.println("-----------------------------------------------------------------------------------------");    
        ((Customer)person3).Stock();
/*------------------------------------------------------------------------------------------------------------*/
//////////////////////////////////////////////////////////////////////  CUSTOMER ORDER THE PRODUCTS ON ONLINE
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");

        int num_of_product=0,amount_of_product=0;
        String address,phone_number;
        int option,counter=0,counter2=0,counter3=0;
        System.out.println("Orders for Customer that special customer number's is "+ ((Customer)person3).getcustomer_num() +".");
        
        while(flag!=0){
            Scanner scan2=new Scanner(System.in);
            System.out.println("-------------------------------------------------------");
            System.out.println("Please Select The Item Number Of Product  At The List :");
            counter=0;
            counter2=0;
            counter3=0;
            try{
                System.out.print("Item number of product : ");
                num_of_product=scan2.nextInt();
            }
            catch(Exception e){
                System.out.println("!! Please enter the only integer !!!");
                System.out.println();
                counter++;
                counter2++;
            }
            if(counter2==0){
                try{
                    System.out.print("Amount Of Product : ");
                    amount_of_product=scan2.nextInt();

                }
                catch(Exception e){
                    System.out.println("!! Please enter the only integer !!!");
                    counter++;
                }}
            if(counter==0){
                Scanner scan3=new Scanner(System.in);

                try{
                    System.out.print("Please Enter Your Adress : ");
                    address=scan3.nextLine();

                    System.out.print("Please Enter Your Phone Number : ");
                    phone_number=scan3.nextLine();

                    ((Customer)person3).Shopping_on_Online(address,phone_number,num_of_product,amount_of_product);
                }
                catch(ClassException e){
                    System.out.println();
                    System.out.println("!!! Please Select New The Prodct Number Again !!!");
                    counter3++;
                }
                if(counter3==0){
                    System.out.println();
                    System.out.println("Please press 0 For The Quit The Shopping :");
                    System.out.println("Please press 1 For The Continue The Shopping :");
                    System.out.print("Operation :");
                    option=scan3.nextInt();

                    if(option==0){
                        flag=0;
                    }}}}
/*------------------------------------------------------------------------------------------------------------*/
/////////////////////////////////////////////////////////////////////////////// CUSTOMER LOOKS AT ITS PREVIOUS ORDER LİST
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------Customer Order List-----------");
    System.out.println("-----------------------------------------------------------------------------------------");
        ((Customer)person3).previous_order();
/*------------------------------------------------------------------------------------------------------------*/
/////////////////////////////////////////////////////////////////////////////////////////////ONLINE  CUSTOMER REGISTRATION        
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----ONLINE Customer Registration----- ");
    System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Plase Enter The Customer Informations");
        System.out.print("Name :");
        name=scan.nextLine();
        System.out.print("Surname :");
        surname=scan.nextLine();
        System.out.print("E_Mail :");
        e_mail=scan.nextLine();
        System.out.print("Password :");
        password=scan.nextLine();

        Company person4=new Customer(name,surname,e_mail,password);
/*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");    
        System.out.println("----------- Online Customer Information -----------");
        System.out.println("----------- Created By Own -----------");
    System.out.println("-----------------------------------------------------------------------------------------");
        
        System.out.println("Name : "+person4.GetName_of_customer());
        System.out.println("Surname : "+person4.GetSurname_of_customer());
        System.out.println("E_Mail : "+person4.GetE_mail_of_customer());
        System.out.println("Password : "+person4.GetPassword_of_customer());
//////////////////////////////////////////////////////////////////////   CUSTOMER INFORMED ABOUT ITS SPECIAL CUSTOMER NUMBER
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        ((Customer)person4).Inform_Customer_Number();
    System.out.println("-----------------------------------------------------------------------------------------");
///////////////////////////////////////////////////////////////////////////////  CUSTOMER ORDER THE PRODUCTS ON ONLINE
        flag=1;
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Orders for Customer that special customer number's is "+ ((Customer)person4).getcustomer_num() +".");
        while(flag!=0){
            System.out.println("-------------------------------------------------------");
            System.out.println("Please Select The Item Number Of Product  At The List :");
            Scanner scan2=new Scanner(System.in);
            counter=0;
            counter2=0;
            counter3=0;
            try{
                System.out.print("Item number of product : ");
                num_of_product=scan2.nextInt();

            }
            catch(Exception e){
                System.out.println("!! Please enter the only integer !!!");
                System.out.println();
                counter++;
                counter2++;
            }
            if(counter2==0){
                try{
                    System.out.print("Amount Of Product : ");
                    amount_of_product=scan2.nextInt();

                }
                catch(Exception e){
                    System.out.println("!! Please enter the only integer !!!");
                    counter++;
                }}
            if(counter==0){
                Scanner scan3=new Scanner(System.in);

                try{
                    System.out.print("Please Enter Your Adress : ");
                    address=scan3.nextLine();

                    System.out.print("Please Enter Your Phone Number : ");
                    phone_number=scan3.nextLine();

                    ((Customer)person4).Shopping_on_Online(address,phone_number,num_of_product,amount_of_product);
                }
                catch(ClassException e){
                    System.out.println();
                    System.out.println("!!! Please Select New The Prodct Number Again !!!");
                    counter3++;
                }
                if(counter3==0){
                    System.out.println();
                    System.out.println("Please press 0 For The Quit The Shopping :");
                    System.out.println("Please press 1 For The Continue The Shopping :");
                    System.out.print("Operation :");
                    option=scan3.nextInt();

                    if(option==0){
                        flag=0;
                    }}}}
////////////////////////////////////////////////////////////////////// CUSTOMER LOOKS AT ITS PREVIOUS ORDER LİST
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----------- Customer Order List -----------");
    System.out.println("-----------------------------------------------------------------------------------------");
        
        ((Customer)person4).previous_order();
/*------------------------------------------------------------------------------------------------------------*/
        //////////////////////////////////////////////////////////////////////////////////////MARKET  CUSTOMER REGISTRATION
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Employee Create A New Account For The A Customer That Shopping In The Store");
    System.out.println("-----------------------------------------------------------------------------------------");
       
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----MARKET Customer Registration----- ");
    System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Plase Enter The Customer Informations");
        System.out.print("Name :");
        name=scan.nextLine();
        System.out.print("Surname :");
        surname=scan.nextLine();
        System.out.print("E_Mail :");
        e_mail=scan.nextLine();
        System.out.print("Password :");
        password=scan.nextLine();
        System.out.println();

        Customer person6=((Employee)person2).Create_New_Account_For_Market_Customer(name,surname,e_mail,password);
/*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----------- Market Customer Information -----------");
        System.out.println("----------- Created By Employee -----------");
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Name : "+person6.GetName_of_customer());
        System.out.println("Surname : "+person6.GetSurname_of_customer());
        System.out.println("E_Mail : "+person6.GetE_mail_of_customer());
        System.out.println("Password : "+person6.GetPassword_of_customer());
/*------------------------------------------------------------------------------------------------------------*/        
//////////////////////////////////////////////////////////////////////  CUSTOMER INFORMED ABOUT ITS SPECIAL CUSTOMER NUMBER
    System.out.println("-----------------------------------------------------------------------------------------");
        ((Customer)person6).Inform_Customer_Number();
    System.out.println("-----------------------------------------------------------------------------------------");    
/*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Customer Shopping in the "+ (((Administrator)person1).getNum_of_branch()-6) +". Branch. ");
/*------------------------------------------------------------------------------------------------------------*/
//////////////////////////////////////////////////////////////////////////////////  CUSTOMER ORDER THE PRODUCTS IN MARKET        
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
        
        System.out.println("When Customer Shopping in the Market,Employee create a List to Customer.");
        System.out.println("And uptade Customer's Order List when it'is necessary.");

        System.out.println();
        
        System.out.println("CUSTOMER TELL THE ORDER TO EMPLOYEE IN THE MARKET AND EMPLOYEE CREATE IT");
        
        System.out.println("-----------------------------------------------------------------------------------------");

        flag=1;
        System.out.println();
        System.out.println("Orders for Customer that special customer number's is "+ ((Customer)person6).getcustomer_num() +".");
        while(flag!=0){
            Scanner scan2=new Scanner(System.in);
            System.out.println("-------------------------------------------------------");
            System.out.println("Please Select The Item Number Of Product  At The List :");
            counter=0;
            counter2=0;
            counter3=0;
            try{
                System.out.print("Item number of product : ");
                num_of_product=scan2.nextInt();

            }
            catch(Exception e){
                System.out.println("!! Please enter the only integer !!!");
                System.out.println();
                counter++;
                counter2++;
            }
            if(counter2==0){
                try{
                    System.out.print("Amount Of Product : ");
                    amount_of_product=scan2.nextInt();

                }
                catch(Exception e){
                    System.out.println("!! Please enter the only integer !!!");
                    counter++;
                }}
            if(counter==0){
                Scanner scan3=new Scanner(System.in);
                try{
                    System.out.print("Please Enter Your Adress : ");
                    address=scan3.nextLine();

                    System.out.print("Please Enter Your Phone Number : ");
                    phone_number=scan3.nextLine();

                    ((Employee)person2).Create_Order_List_For_Market_Customer(address,phone_number,num_of_product,amount_of_product);
                }
                catch(ClassException e){
                    System.out.println();
                    System.out.println("!!! Please Select New The Prodct Number Again !!!");
                    counter3++;
                }
                if(counter3==0){
                    System.out.println();
                    System.out.println("Please press 0 For The Quit The Shopping :");
                    System.out.println("Please press 1 For The Continue The Shopping :");
                    System.out.print("Operation :");
                    option=scan3.nextInt();

                    if(option==0){
                        flag=0;
                    }}}}
/*------------------------------------------------------------------------------------------------------------*/                    
/////////////////////////////////////////////////////////////////////////////////////  CUSTOMER LOOK AT İTS ORDER LİST
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("            Customer Order List(Shopping Market)          ");
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
        person6.previous_order();

/*------------------------------------------------------------------------------------------------------------*/
///////////////////////////////////////////////////////////////////////////////  CUSTOMER ORDER THE PRODUCTS ON ONLINE        
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("          After the Market Shopping Customer Shopping on Online            ");
     System.out.println("-----------------------------------------------------------------------------------------");    
        System.out.println();   
       
        flag=1;
        System.out.println();
        System.out.println("Orders for Customer that special customer number's is "+ ((Customer)person6).getcustomer_num() +".");
        
        while(flag!=0){
            Scanner scan2=new Scanner(System.in);
            System.out.println("-------------------------------------------------------");
            System.out.println("Please Select The Item Number Of Product  At The List :");
            counter=0;
            counter2=0;
            counter3=0;
            try{
                System.out.print("Item number of product : ");
                num_of_product=scan2.nextInt();
            }
            catch(Exception e){
                System.out.println("!! Please enter the only integer !!!");
                System.out.println();
                counter++;
                counter2++;
            }
            if(counter2==0){
                try{
                    System.out.print("Amount Of Product : ");
                    amount_of_product=scan2.nextInt();

                }
                catch(Exception e){
                    System.out.println("!! Please enter the only integer !!!");
                    counter++;
                }}
            if(counter==0){
                Scanner scan3=new Scanner(System.in);
                try{
                    System.out.print("Please Enter Your Adress : ");
                    address=scan3.nextLine();

                    System.out.print("Please Enter Your Phone Number : ");
                    phone_number=scan3.nextLine();

                    person6.Shopping_on_Online(address,phone_number,num_of_product,amount_of_product);
                }
                catch(ClassException e){
                    System.out.println();
                    System.out.println("!!! Please Select New The Prodct Number Again !!!");
                    counter3++;
                }
                if(counter3==0){
                    System.out.println();
                    System.out.println("Please press 0 For The Quit The Shopping :");
                    System.out.println("Please press 1 For The Continue The Shopping :");
                    System.out.print("Operation :");
                    option=scan3.nextInt();

                    if(option==0){
                        flag=0;
                    }}}}
/*------------------------------------------------------------------------------------------------------------*/                    
/////////////////////////////////////////////////////////////////////////////////////  CUSTOMER LOOK AT İTS ORDER LİST
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("              Customer Order List(With Shopping Online)                 ");
    System.out.println("---------------------------------------------------------------------------");
        person6.previous_order();
/*------------------------------------------------------------------------------------------------------------*/
///////////////////////////////////////////////////////////////////////////////////// EMPLOYEE LOOK AT CUSTOMER'S ORDER LİST        
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("------------- Employee Look At The Customers Orders -------------");
        System.out.println("------------- EMPLOYEE SEES ONLY UNSOLD PRODUCT -------------");
        System.out.println("--- If A Product Has Been Sold, It Will Remove It From The Order List By Employee ---");
    System.out.println("-----------------------------------------------------------------");
        System.out.println();
        
        try{
            ((Employee)person2).pre_cust_order(((Customer)person3).getcustomer_num());
            System.out.println();
            ((Employee)person2).pre_cust_order(((Customer)person4).getcustomer_num());
            System.out.println();
            ((Employee)person2).pre_cust_order(((Customer)person6).getcustomer_num());
        }
        catch(ClassException e){
            System.out.println();
        }
/*------------------------------------------------------------------------------------------------------------*/
/////////////////////////////////////////////////////////////////////////////////////  ADMINISTRATOR QUERY THE STOCK        
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----------- Administrator Query The Stock And Look At The Customer Orders -----------");
    System.out.println("-----------------------------------------------------------------------------------------");
        ((Administrator)person1).Query_Product_in_Stock();
/*------------------------------------------------------------------------------------------------------------*/
///////////////////////////////////////////////////////////////////////////////////// EMPLOYEE CHECKING THE STOCK        
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----------- Employee Checking the Stock -----------");
    System.out.println("-----------------------------------------------------------------------------------------");
        ((Employee)person2).check_The_Product_Stock();
/*------------------------------------------------------------------------------------------------------------*/
////////////////////////////////////////////////////////////////////////////////// EMPLOYEE SELLING ORDERED PRODUCT        
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("!!! ---EMPLOYEE SELLING ORDERED PRODUCT --- !!!");
    System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println();
        ((Employee)person2).Selling_Ordered_Products();
/*------------------------------------------------------------------------------------------------------------*/
//////////////////////////////////////////////////////////////////////  CUSTOMER WANTS TO SEE PRODUCT STOCK         
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----------- After The Saleing The Product Stock ------------");
        System.out.println("----------- There Is A Decrease In Stocks In Selected Products ------------");
    System.out.println("-----------------------------------------------------------------------------------------");
        ((Customer)person3).Stock();
/*------------------------------------------------------------------------------------------------------------*/
/////////////////////////////////////////////////////////////////////////////////////  ADMINISTRATOR QUERY THE STOCK        
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-------------------------------- AFTER THE SELLING ----------------------------");
        System.out.println("----------- Administrator Query The Stock And Look At The Customer Orders -----------");
    System.out.println("-----------------------------------------------------------------------------------------");
        ((Administrator)person1).Query_Product_in_Stock();
/*------------------------------------------------------------------------------------------------------------*/
///////////////////////////////////////////////////////////////////////////////////// EMPLOYEE CHECKING THE STOCK        
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----------- Employee Checking the Stock -----------");
    System.out.println("-----------------------------------------------------------------------------------------");
        ((Employee)person2).check_The_Product_Stock();

/*------------------------------------------------------------------------------------------------------------*/
       System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----------------- AFTER THE SELLİNG, CUSTOMERS LOOK AT THEIR PREVIOUS ORDER LIST -----------------");
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
        
        person6.previous_order();

        System.out.println();
        ((Customer)person3).previous_order();

        System.out.println();
        ((Customer)person4).previous_order();
/*------------------------------------------------------------------------------------------------------------*/
/////////////////////////////////////////////////////////////////////////////////////////// ONLINE CUSTOMER REGISTRATION
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----ONLINE Customer Registration----- ");
    System.out.println("-----------------------------------------------------------------------------------------");
        
        System.out.println("Plase Enter The Customer Informations");
        System.out.print("Name :");
        name=scan.nextLine();
        System.out.print("Surname :");
        surname=scan.nextLine();
        System.out.print("E_Mail :");
        e_mail=scan.nextLine();
        System.out.print("Password :");
        password=scan.nextLine();
        System.out.println();

        Company person7=new Customer(name,surname,e_mail,password);

        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("-----------Online Customer Information-----------");
        System.out.println("-----------Created By Own-----------");
        System.out.println("Name : "+person7.GetName_of_customer());
        System.out.println("Surname : "+person7.GetSurname_of_customer());
        System.out.println("E_Mail : "+person7.GetE_mail_of_customer());
        System.out.println("Password : "+person7.GetPassword_of_customer());

/*------------------------------------------------------------------------------------------------------------*/      
///////////////////////////////////////////////////////////////////   CUSTOMER INFORMED ABOUT ITS SPECIAL CUSTOMER NUMBER
    System.out.println("-----------------------------------------------------------------------------------------");
        ((Customer)person7).Inform_Customer_Number();
    System.out.println("-----------------------------------------------------------------------------------------");

/*------------------------------------------------------------------------------------------------------------*/
//////////////////////////////////////////////////////////////////////////////// CUSTOMERS ARE DOING SHOPPING ON ONLINE
        flag=1;
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Orders for Customer that special customer number's is "+ ((Customer)person3).getcustomer_num() +".");
    System.out.println("-----------------------------------------------------------------------------------------");    
        while(flag!=0){
            Scanner scan2=new Scanner(System.in);
            System.out.println("-------------------------------------------------------");
            System.out.println("Please Select The Item Number Of Product  At The List :");
            counter=0;
            counter2=0;
            counter3=0;
            try{
                System.out.print("Item number of product : ");
                num_of_product=scan2.nextInt();
            }
            catch(Exception e){
                System.out.println("!! Please enter the only integer !!!");
                System.out.println();
                counter++;
                counter2++;
            }
            if(counter2==0){
                try{
                    System.out.print("Amount Of Product : ");
                    amount_of_product=scan2.nextInt();

                }
                catch(Exception e){
                    System.out.println("!! Please enter the only integer !!!");
                    counter++;
                }}
            if(counter==0){
                Scanner scan3=new Scanner(System.in);

                try{
                    System.out.print("Please Enter Your Adress : ");
                    address=scan3.nextLine();

                    System.out.print("Please Enter Your Phone Number : ");
                    phone_number=scan3.nextLine();

                    ((Customer)person3).Shopping_on_Online(address,phone_number,num_of_product,amount_of_product);
                }
                catch(ClassException e){
                    System.out.println();
                    System.out.println("!!! Please Select New The Prodct Number Again !!!");
                    counter3++;
                }
                if(counter3==0){
                    System.out.println();
                    System.out.println("Please press 0 For The Quit The Shopping :");
                    System.out.println("Please press 1 For The Continue The Shopping :");
                    System.out.print("Operation :");
                    option=scan3.nextInt();

                    if(option==0){
                        flag=0;
                    }}}}
/*------------------------------------------------------------------------------------------------------------*/
        flag=1;
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Orders for Customer that special customer number's is "+ ((Customer)person4).getcustomer_num() +".");
    System.out.println("-----------------------------------------------------------------------------------------");    
        
        while(flag!=0){
            Scanner scan2=new Scanner(System.in);
            System.out.println("-------------------------------------------------------");
            System.out.println("Please Select The Item Number Of Product  At The List :");
            counter=0;
            counter2=0;
            counter3=0;
            
            try{
                System.out.print("Item number of product : ");
                num_of_product=scan2.nextInt();

            }
            catch(Exception e){
                System.out.println("!! Please enter the only integer !!!");
                System.out.println();
                counter++;
                counter2++;
            }
            if(counter2==0){
                try{
                    System.out.print("Amount Of Product : ");
                    amount_of_product=scan2.nextInt();

                }
                catch(Exception e){
                    System.out.println("!! Please enter the only integer !!!");
                    counter++;
                }}
            if(counter==0){
                Scanner scan3=new Scanner(System.in);

                try{
                    System.out.print("Please Enter Your Adress : ");
                    address=scan3.nextLine();

                    System.out.print("Please Enter Your Phone Number : ");
                    phone_number=scan3.nextLine();

                    ((Customer)person4).Shopping_on_Online(address,phone_number,num_of_product,amount_of_product);
                }
                catch(ClassException e){
                    System.out.println();
                    System.out.println("!!! Please Select New The Prodct Number Again !!!");
                    counter3++;
                }
                if(counter3==0){
                    System.out.println();
                    System.out.println("Please press 0 For The Quit The Shopping :");
                    System.out.println("Please press 1 For The Continue The Shopping :");
                    System.out.print("Operation :");
                    option=scan3.nextInt();

                    if(option==0){
                        flag=0;
                    }}}}
/*------------------------------------------------------------------------------------------------------------*/
        flag=1;
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Orders for Customer that special customer number's is "+ ((Customer)person6).getcustomer_num() +".");
    System.out.println("-----------------------------------------------------------------------------------------");    
        
        while(flag!=0){
            Scanner scan2=new Scanner(System.in);
            System.out.println("-------------------------------------------------------");
            System.out.println("Please Select The Item Number Of Product  At The List :");
            counter=0;
            counter2=0;
            counter3=0;
            try{
                System.out.print("Item number of product : ");
                num_of_product=scan2.nextInt();
            }
            catch(Exception e){
                System.out.println("!! Please enter the only integer !!!");
                System.out.println();
                counter++;
                counter2++;
            }
            if(counter2==0){
                try{
                    System.out.print("Amount Of Product : ");
                    amount_of_product=scan2.nextInt();

                }
                catch(Exception e){
                    System.out.println("!! Please enter the only integer !!!");
                    counter++;
                }}
            if(counter==0){
                Scanner scan3=new Scanner(System.in);
                try{
                    System.out.print("Please Enter Your Adress : ");
                    address=scan3.nextLine();

                    System.out.print("Please Enter Your Phone Number : ");
                    phone_number=scan3.nextLine();

                    person6.Shopping_on_Online(address,phone_number,num_of_product,amount_of_product);
                }
                catch(ClassException e){
                    System.out.println();
                    System.out.println("!!! Please Select New The Prodct Number Again !!!");
                    counter3++;
                }
                if(counter3==0){
                    System.out.println();
                    System.out.println("Please press 0 For The Quit The Shopping :");
                    System.out.println("Please press 1 For The Continue The Shopping :");
                    System.out.print("Operation :");
                    option=scan3.nextInt();

                    if(option==0){
                        flag=0;
                    }}}}
/*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("AFTER THE SELLİNG, CUSTOMER ORDER NEW PRODUCT AND LOOK AT THEIR PREVIOUS ORDER LIST");
    System.out.println("-------------------------------------------------------------------------------------");
        System.out.println();

        person6.previous_order();
        System.out.println();
        ((Customer)person3).previous_order();

        System.out.println();
        ((Customer)person4).previous_order();

        System.out.println();
        ((Customer)person7).previous_order();
/*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("------------- Employee Look At The Customers Orders -------------");
        System.out.println("!!!!!!!!!!! ----EMPLOYEE SEES ONLY UNSOLD PRODUCT---- !!!!!!!!!!!");
        System.out.println("--- If a product has been sold, it will remove it from the order list by employee ---");
    System.out.println("-----------------------------------------------------------------------------------------");
        
        try{
            ((Employee)person2).pre_cust_order(((Customer)person3).getcustomer_num());
            System.out.println();
            ((Employee)person2).pre_cust_order(((Customer)person4).getcustomer_num());
            System.out.println();
            ((Employee)person2).pre_cust_order(((Customer)person6).getcustomer_num());
            System.out.println();
            ((Employee)person2).pre_cust_order(((Customer)person7).getcustomer_num());
        }
        catch(ClassException e){
            System.out.println();
        }
/*------------------------------------------------------------------------------------------------------------*//*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----------- Administrator Query The Stock And Look At The Customer Orders -----------");
    System.out.println("-----------------------------------------------------------------------------------------");
        ((Administrator)person1).Query_Product_in_Stock();
/*------------------------------------------------------------------------------------------------------------*//*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("------ CUSTOMERS ARE ORDERING PRODUCTS IN EXCESS OF THEIR STOCK QUANTITIES ------");
        System.out.println();
        System.out.println("!!! PLEASE ENTER AMOUNT OF PRODUCT HIGHER NUMBER THAN STOCK PRODUCT AMOUNT FOR THE TESTING !!!");
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
        
        flag=1;
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");    
        System.out.println("Orders for Customer that special customer number's is "+ ((Customer)person3).getcustomer_num() +".");
    System.out.println("-----------------------------------------------------------------------------------------");    
        
        while(flag!=0){
            Scanner scan2=new Scanner(System.in);
            System.out.println("-------------------------------------------------------");
            System.out.println("Please Select The Item Number Of Product  At The List :");
            counter=0;
            counter2=0;
            counter3=0;
            try{
                System.out.print("Item number of product : ");
                num_of_product=scan2.nextInt();
            }
            catch(Exception e){
                System.out.println("!! Please enter the only integer !!!");
                System.out.println();
                counter++;
                counter2++;
            }
            if(counter2==0){
                try{
                    System.out.print("Amount Of Product : ");
                    amount_of_product=scan2.nextInt();

                }
                catch(Exception e){
                    System.out.println("!! Please enter the only integer !!!");
                    counter++;
                }}
            if(counter==0){
                Scanner scan3=new Scanner(System.in);

                try{
                    System.out.print("Please Enter Your Adress : ");
                    address=scan3.nextLine();

                    System.out.print("Please Enter Your Phone Number : ");
                    phone_number=scan3.nextLine();

                    ((Customer)person3).Shopping_on_Online(address,phone_number,num_of_product,amount_of_product);
                }
                catch(ClassException e){
                    System.out.println();
                    System.out.println("!!! Please Select New The Prodct Number Again !!!");
                    counter3++;
                }
                if(counter3==0){
                    System.out.println();
                    System.out.println("Please press 0 For The Quit The Shopping :");
                    System.out.println("Please press 1 For The Continue The Shopping :");
                    System.out.print("Operation :");
                    option=scan3.nextInt();

                    if(option==0){
                        flag=0;
                    }}}}
/*------------------------------------------------------------------------------------------------------------*/
        flag=1;
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Orders for Customer that special customer number's is "+ ((Customer)person4).getcustomer_num() +".");
    System.out.println("-----------------------------------------------------------------------------------------");    
        while(flag!=0){
            Scanner scan2=new Scanner(System.in);
            System.out.println("-------------------------------------------------------");
            System.out.println("Please Select The Item Number Of Product  At The List :");
            counter=0;
            counter2=0;
            counter3=0;
            try{
                System.out.print("Item number of product : ");
                num_of_product=scan2.nextInt();

            }
            catch(Exception e){
                System.out.println("!! Please enter the only integer !!!");
                System.out.println();
                counter++;
                counter2++;
            }
            if(counter2==0){
                try{
                    System.out.print("Amount Of Product : ");
                    amount_of_product=scan2.nextInt();

                }
                catch(Exception e){
                    System.out.println("!! Please enter the only integer !!!");
                    counter++;
                }}
            if(counter==0){
                Scanner scan3=new Scanner(System.in);

                try{
                    System.out.print("Please Enter Your Adress : ");
                    address=scan3.nextLine();

                    System.out.print("Please Enter Your Phone Number : ");
                    phone_number=scan3.nextLine();

                    ((Customer)person4).Shopping_on_Online(address,phone_number,num_of_product,amount_of_product);
                }
                catch(ClassException e){
                    System.out.println();
                    System.out.println("!!! Please Select New The Prodct Number Again !!!");
                    counter3++;
                }
                if(counter3==0){
                    System.out.println();
                    System.out.println("Please press 0 For The Quit The Shopping :");
                    System.out.println("Please press 1 For The Continue The Shopping :");
                    System.out.print("Operation :");
                    option=scan3.nextInt();

                    if(option==0){
                        flag=0;
                    }}}}
/*------------------------------------------------------------------------------------------------------------*/
        flag=1;
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
       System.out.println("Orders for Customer that special customer number's is "+ ((Customer)person6).getcustomer_num() +".");
    System.out.println("-----------------------------------------------------------------------------------------");    
        
        while(flag!=0){
            Scanner scan2=new Scanner(System.in);
            System.out.println("-------------------------------------------------------");
            System.out.println("Please Select The Item Number Of Product  At The List :");
            counter=0;
            counter2=0;
            counter3=0;
            
            try{
                System.out.print("Item number of product : ");
                num_of_product=scan2.nextInt();
            }
            catch(Exception e){
                System.out.println("!! Please enter the only integer !!!");
                System.out.println();
                counter++;
                counter2++;
            }
            if(counter2==0){
                try{
                    System.out.print("Amount Of Product : ");
                    amount_of_product=scan2.nextInt();
                }
                catch(Exception e){
                    System.out.println("!! Please enter the only integer !!!");
                    counter++;
                }}
            if(counter==0){
                Scanner scan3=new Scanner(System.in);
                try{
                    System.out.print("Please Enter Your Adress : ");
                    address=scan3.nextLine();

                    System.out.print("Please Enter Your Phone Number : ");
                    phone_number=scan3.nextLine();

                    person6.Shopping_on_Online(address,phone_number,num_of_product,amount_of_product);
                }
                catch(ClassException e){
                    System.out.println();
                    System.out.println("!!! Please Select New The Prodct Number Again !!!");
                    counter3++;
                }
                if(counter3==0){
                    System.out.println();
                    System.out.println("Please press 0 For The Quit The Shopping :");
                    System.out.println("Please press 1 For The Continue The Shopping :");
                    System.out.print("Operation :");
                    option=scan3.nextInt();

                    if(option==0){
                        flag=0;
                    }}}}
/*------------------------------------------------------------------------------------------------------------*/                    
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----------------- CUSTOMERS LOOK AT THEIR PREVIOUS ORDER LIST -----------------");
    System.out.println("-----------------------------------------------------------------------------------------");
        person6.previous_order();
        System.out.println();
        ((Customer)person3).previous_order();

        System.out.println();
        ((Customer)person4).previous_order();

        System.out.println();
        ((Customer)person7).previous_order();
/*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------Administrator Query The Stock And Look At The Customer Orders-----------");
    System.out.println("-----------------------------------------------------------------------------------------");    
        ((Administrator)person1).Query_Product_in_Stock();

/*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----------- Employee Checking the Stock -----------");
    System.out.println("-----------------------------------------------------------------------------------------");    
        ((Employee)person2).check_The_Product_Stock();

/*------------------------------------------------------------------------------------------------------------*/
//////////////////////////////////////////////////////////////////////////////////////// EMPLOYEE'S DOING THE SELLING
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        ((Employee)person2).Selling_Ordered_Products();
/*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");    
        System.out.println("------------------------ AFTER THE SELLING ---------------------------");
    System.out.println("-----------------------------------------------------------------------------------------");    
        System.out.println();

    System.out.println("-----------------------------------------------------------------------------------------");    
        System.out.println("-----------  Employee Checking the Stock  -----------");
    System.out.println("-----------------------------------------------------------------------------------------");    
        ((Employee)person2).check_The_Product_Stock();
/*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------Administrator Query The Stock And Look At The Customer Orders-----------");
    System.out.println("-----------------------------------------------------------------------------------------");    
        ((Administrator)person1).Query_Product_in_Stock();
/*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------After The Selling Customer Look At Their Previous Order List "); 
    System.out.println("-----------------------------------------------------------------------------------------");    
        person6.previous_order();
        System.out.println();
        ((Customer)person3).previous_order();

        System.out.println();
        ((Customer)person4).previous_order();

        System.out.println();
        ((Customer)person7).previous_order();
/*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("----------- After The Saleing The Product Stock ------------");
    System.out.println("-----------------------------------------------------------------------------------------");    
        ((Customer)person3).Stock();

/*------------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------------*/
        /*When an employee wants to enter a customer's special customer number and check their orders,
        employee receives an error message if he enters the wrong number.*/
        System.out.println();
    System.out.println("------------------------------------------------------------------------Exception Handling Part");  

        System.out.println("---Employee Enters Wrong Special Customer Number :");
        try{
            ((Employee)person8).pre_cust_order(15);
        }
        catch(ClassException e){
            System.out.println();
        }
/*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("---When a customer enters another customer's phone number while shopping :");
        Company person10=new Customer("Hasan","Çimen","H.çmn@hotmail.com","1544");
        try{
            ((Customer)person10).Shopping_on_Online("İstanbul/Besiktas","05695967842",109,210);
        }
        catch(ClassException e){
            System.out.println();
        }
/*------------------------------------------------------------------------------------------------------------*/
        System.out.println();
    System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("---When A Customer Enters An Product Number That Is Not On The Product List While Shopping :");
        try{
            ((Customer)person10).Shopping_on_Online("İstanbul/Besiktas","05695967878",200,210);
        }
        catch(ClassException e){
            System.out.println();
        }}}
/*------------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------------*/