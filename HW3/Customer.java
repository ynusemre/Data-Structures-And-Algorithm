/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/

///////////////////////////Customer Class//////////////////////////////////////////////////////
	/**
     *	The class that includes the functions of all the operations that the customer can do
     *<p>
     *  Extends	Company Class
     *<p>
     * Implement  Customer_Operations Interface and Override its methods 
     */
    public class Customer extends Company implements Customer_Operations{
        private static KWArrayList<String> address_arr=new KWArrayList<String>();  //Holds All Customer's Adresses.
        private static KWArrayList<String> phone_number_arr=new KWArrayList<String>(); // Holds All Customer's Phone numbers.
        
        //Helper arraylist used to modify product quantities in stocks.
        //arraylist that holds the amounts of products requested by the customer.
        //However, as the customer's orders are completed, the values it keep from this arraylist decrease.
        //The first index is the special customer number and the second index is the product amount. 
        //Therefore, it is special for every customer.
        private static KWArrayList<KWArrayList<Integer> > temporary_amount_product_num=new KWArrayList<KWArrayList<Integer> >();
        
        //The product number of the product selected by the customer from the product list. 
        //arraylist, which holds the number of products the customer has selected in the product list.
        //No decrease even if the customer's order is completed.
        //The first index is the special customer number and the second index is the number of the product in the list. 
        //Thus it is special for each customer.
        private static KWArrayList<KWArrayList<Integer> > permanent_item_number=new KWArrayList<KWArrayList<Integer> >();
        
        //Helper arraylist used to modify product quantities in stocks.
        //arraylist that holds the amounts of products requested by the customer.
		//No decrease even if the customer's order is completed.
		//The first index is the special customer number and the second index is the product amount. 
        //Therefore, it is special for every customer.
        private static KWArrayList<KWArrayList<Integer> > permanent_amount_product_num=new KWArrayList<KWArrayList<Integer> >();
        
        
		//Array that holds the item numbers of the products in the product list.
        //private static KWArrayList<Integer> product_list_num=new KWArrayList<Integer>();
        private static int []product_list_num=new int[125];

        private static int []Customer_Num_Arr=new int[12];  //Holds All The Special  Customer Numbers.
        
        //That arraylist helps to using for used to print to screen the customer's completed orders.
        //The first index is the special customer number and the second index is the completed customer order number. 
        private static int [][]completed_order_number=new int[15][1];
        
        //The product number of the product selected by the customer from the product list. 
        //arraylist, which holds the number of products the customer has selected in the product list.
        //However, as the customer's orders are completed, the values it keep from this arraylist decrease.
        //The first index is the special customer number and the second index is the number of the product in the list. 
        //Thus it is special for each customer.
        private static int [][]temporary_item_number=new int[10][20];

        private int customer_num;   			 // Customer number variable.
        private static int index_of_Customer_Num_Arr=0,index_of_addres_and_phone_number_arr=0;   //This variables using for the arrays indexes.
        private static int random_special_customer_num=1;         //This variable increase by one when a customer registers.
	/*-----------------------------------------------------------------------------------------*/
		/**
         *Customer Class Constructor.It is used when the customer creates an account while shopping online.
         *<p>
         * That constructor assign a value to customer_num and  Customer_Num_Arr. 	
         * @param name      name of customer
         * @param surname   surname of customer
         * @param e_mail   e-mail of customer
         * @param password   password of customer
         */
        public Customer(String name,String surname,String e_mail,String password){
            super(name,surname,e_mail,password);
            Customer_Num_Arr[index_of_Customer_Num_Arr]=random_special_customer_num;
            customer_num=random_special_customer_num;

            temporary_amount_product_num.add(new KWArrayList<Integer>());
            permanent_item_number.add(new KWArrayList<Integer>());
            permanent_amount_product_num.add(new KWArrayList<Integer>());   
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         * This Constructor using for when an employee create account when customer shopping in store.
         * @param name  name of customer
         * @param surname   surname of customer
         * @param e_mail   e-mail of customer
         * @param password    password of customer
         * @param customer_num   special customer number for a customer 
         */
        public Customer(String name,String surname,String e_mail,String password,int customer_num){
            super(name,surname,e_mail,password);
            Customer_Num_Arr[index_of_Customer_Num_Arr]=customer_num;
            this.customer_num=customer_num;

            temporary_amount_product_num.add(new KWArrayList<Integer>());
            permanent_item_number.add(new KWArrayList<Integer>());
            permanent_amount_product_num.add(new KWArrayList<Integer>());   
        }
    /*-----------------------------------------------------------------------------------------*/
      	/**
         *  Copy Constructor
         * @param customer  Customer class object.
         */
        public Customer(Customer customer){
            this(customer.GetName_of_customer(),customer.GetSurname_of_customer(),customer.GetE_mail_of_customer(),customer.GetPassword_of_customer());
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *  The customer number is automatically defined in the system and the user is informed about it.
		 *<p>
		 *	The index of the array holding the special custom numbers of the customers is increased.
		 *<p>
		 *	Static variable is incremented for next customer's special number.
         */
        public void Inform_Customer_Number(){
            System.out.println("Your Customer Number is : "+customer_num);
            random_special_customer_num++;
            index_of_Customer_Num_Arr++;
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         * Function returning random special customer number.
         * @return  random special customer number
         */
        public int getRandom_special_customer_num(){
            return random_special_customer_num;
        }    
    /*-----------------------------------------------------------------------------------------*/
        /**
         * Function returning index of addres and phone number arr.
         * @return  index of addres and phone number arr
         */
        public int getIndex_of_addres_and_phone_number_arr(){
            return index_of_addres_and_phone_number_arr;
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  Function sets index of addres and phone number arr according to given number.   
         * @param index_of_addres_and_phone_number_arr given number from user.
         */
        public void setIndex_of_addres_and_phone_number_arr(int index_of_addres_and_phone_number_arr){
            this.index_of_addres_and_phone_number_arr=index_of_addres_and_phone_number_arr;
        }        
    /*-----------------------------------------------------------------------------------------*/
    	/**
         * Function returning the customer's special number.
         * @return  special customer number
         */
        public int getcustomer_num(){
            return customer_num;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *	Function sets the customer's special number according to given number.	
         * @param customer_num given number from user.
         */
        public void setcustomer_num(int customer_num){
            this.customer_num=customer_num;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *  The function that returns an arraylist that holds the special numbers of all customers.
         * @return  arraylist that hols the special numbers of all customers.
         */
        public int[] getCustomer_Num_Arr(){
            return Customer_Num_Arr;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *  The function that sets an arraylist that holds the special numbers of all customers according to given arraylist.
         * @param Customer_Num_Arr  given arraylist from user
         */
        public void setCustomer_Num_Arr(int[] Customer_Num_Arr){
            this.Customer_Num_Arr=Customer_Num_Arr;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *	Returns product_list_num array.
         * @return   product_list_num
         */
        public int[] getProduct_list_num(){
            return product_list_num;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *  Sets product_list_num array according to given array.
         * @param product_list_num
         */
        public void setProduct_list_num(int[] product_list_num){
            this.product_list_num=product_list_num;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *  Returns temporary_item_number array.
         * @return  temporary_item_number
         */
        public int[][] getTemporary_item_number(){
            return temporary_item_number;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *   Sets temporary_item_number array according to given array.
         * @param temporary_item_number
         */
        public void setTemporary_item_number(int[][] temporary_item_number){
            this.temporary_item_number=temporary_item_number;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *   Returns completed_order_number array.
         * @return  completed_order_number
         */
        public int[][] getCompleted_order_number(){
            return completed_order_number;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *   Sets completed_order_number array according to given array.
         * @param completed_order_number
         */
        public void setCompleted_order_number(int[][] completed_order_number){
            this.completed_order_number=completed_order_number;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *   Returns permanent_item_number arraylist.
         * @return  permanent_item_number
         */
        public KWArrayList<KWArrayList<Integer> > getPermanent_item_number(){
            return permanent_item_number;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *  Sets permanent_item_number arraylist according to given arraylist.
         * @param permanent_item_number
         */
        public void setPermanent_item_number(KWArrayList<KWArrayList<Integer> > permanent_item_number){
            this.permanent_item_number=permanent_item_number;
        }
	/*-----------------------------------------------------------------------------------------*/
		/**
         *  Returns temporary_amount_product_num arraylist.
         * @return  temporary_amount_product_num
         */
        public KWArrayList<KWArrayList<Integer> > getTemporary_amount_product_num(){
            return temporary_amount_product_num;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *    Sets temporary_amount_product_num arraylist according to given arraylist.
         * @param temporary_amount_product_num
         */
        public void setTemporary_amount_product_num(KWArrayList<KWArrayList<Integer> > temporary_amount_product_num){
            this.temporary_amount_product_num=temporary_amount_product_num;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *  Returns permanent_amount_product_num arraylist.
         * @return   permanent_amount_product_num
         */ 
        public KWArrayList<KWArrayList<Integer> > getPermanent_amount_product_num(){
            return permanent_amount_product_num;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *   Sets permanent_amount_product_num arraylist according to given arraylist.
         * @param permanent_amount_product_num
         */
        public void setPermanent_amount_product_num(KWArrayList<KWArrayList<Integer> > permanent_amount_product_num){
            this.permanent_amount_product_num=permanent_amount_product_num;
        }    
    /*-----------------------------------------------------------------------------------------*/
		/**
         *   Returns address_arr arraylist.
         * @return   address_arr
         */
        public KWArrayList<String> getAddress(){
            return address_arr;
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *   Sets address_arr arraylist according to given arraylist.
         * @param address_arr
         */
        public void setAdress(KWArrayList<String> address_arr){
            this.address_arr=address_arr;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *   Returns phone_number_arr arraylist.
         * @return   phone_number_arr
         */
        public KWArrayList<String> getPhone_number(){
            return phone_number_arr;
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  Sets phone_number_arr arraylist. according to given arraylist.
         * @param phone_number_arr
         */
        public void setPhone_numbe(KWArrayList<String> phone_number_arr){
            this.phone_number_arr=phone_number_arr;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *	All products owned by the furniture company are displayed on the screen one by one.	
         */
        public void List_Of_Products(){
            KWSingleLinkedList<KWSingleLinkedList<Integer> > Office_Chairs=getOffice_Chairs();
            KWSingleLinkedList<KWSingleLinkedList<Integer> > Office_Desks=getOffice_Desks();
            KWSingleLinkedList<KWSingleLinkedList<Integer> > Meeting_Tables=getMeeting_Tables();
            KWSingleLinkedList<Integer> Bookcases=getBookcases();
            KWSingleLinkedList<Integer> Office_Cabinets=getOffice_Cabinets();

            int ctr=0;
            System.out.println();
            System.out.println("****************************************");
            System.out.println("-----------Office Chair List-----------");
            System.out.println("****************************************");

            for(int i=0;i<7;i++){
                System.out.println();
                System.out.println("-----------Office Chair "+(i+1)+". Model-----------");
                for(int j=0;j<Office_Chairs.get(i).size();j++){
                    System.out.println((ctr+1)+". -> Office Chair "+ (i+1) +".Model "+(j+1)+".Color");
                    product_list_num[ctr]=ctr+1;
                    ctr++;
                }}
            System.out.println();
            System.out.println("****************************************");
            System.out.println("-----------Office Desk List-----------");
            System.out.println("****************************************");

            for(int i=0;i<5;i++){
                System.out.println();
                System.out.println("-----------Office Desk "+(i+1)+". Model-----------");
                for(int j=0;j<Office_Desks.get(i).size();j++){
                    System.out.println((ctr+1)+". -> Office Desk "+ (i+1) +".Model "+(j+1)+".Color");
                    product_list_num[ctr]=ctr+1;
                    ctr++;
                }}
            System.out.println();
            System.out.println("****************************************");
            System.out.println("-----------Meeting Table List-----------");
            System.out.println("****************************************");

            for(int i=0;i<10;i++){
                System.out.println();
                System.out.println("-----------Meeting Table "+(i+1)+". Model-----------");
                for(int j=0;j<Meeting_Tables.get(i).size();j++){
                    System.out.println((ctr+1)+". -> Meeting Table "+ (i+1) +".Model "+(j+1)+".Color");
                    product_list_num[ctr]=ctr+1;
                    ctr++;
                }}
            System.out.println();
            System.out.println("****************************************");
            System.out.println("-----------Bookcase List-----------");
            System.out.println("****************************************");

            for(int i=0;i<Bookcases.size();i++){
                System.out.println((ctr+1)+". -> Bookcase "+ (i+1) +".Model");
                ctr++;
                product_list_num[ctr]=ctr+1;
            }
            System.out.println();
            System.out.println("****************************************");
            System.out.println("-----------Office Cabinet List-----------");
            System.out.println("****************************************");

            for(int i=0;i<Office_Cabinets.size();i++){
                System.out.println((ctr+1)+". -> Office Cabinet "+ (i+1) +".Model");
                product_list_num[ctr]=ctr+1;
                ctr++;
            }}
    /*-----------------------------------------------------------------------------------------*/
		/**
         *The function that prints the total amount of products in all branches of the furniture company.
         */
        public void Stock(){
            KWSingleLinkedList<KWSingleLinkedList<Integer> > Office_Chairs=getOffice_Chairs();
            KWSingleLinkedList<KWSingleLinkedList<Integer> > Office_Desks=getOffice_Desks();
            KWSingleLinkedList<KWSingleLinkedList<Integer> > Meeting_Tables=getMeeting_Tables();
            KWSingleLinkedList<Integer> Bookcases=getBookcases();
            KWSingleLinkedList<Integer> Office_Cabinets=getOffice_Cabinets();
            int ctr=0;

            System.out.println();
            System.out.println("****************************************");
            System.out.println("-----------Office Chair Stock-----------");
            System.out.println("****************************************");

            for(int i=0;i<7;i++){
                System.out.println();
                System.out.println("-----------Office Chair "+(i+1)+". Model-----------");
                for(int j=0;j<Office_Chairs.get(i).size();j++){
                    System.out.println((ctr+1)+". -> Office Chair "+ (i+1) +".Model "+(j+1)+".Color : "+Office_Chairs.get(i).get(j));
                    ctr++;
                }}
            System.out.println();
            System.out.println("****************************************");
            System.out.println("-----------Office Desk Stock-----------");
            System.out.println("****************************************");

            for(int i=0;i<5;i++){
                System.out.println();
                System.out.println("-----------Office Desk "+(i+1)+". Model-----------");
                for(int j=0;j<Office_Desks.get(i).size();j++){
                    System.out.println((ctr+1)+". -> Office Desk "+ (i+1) +".Model "+(j+1)+".Color : "+Office_Desks.get(i).get(j));
                    ctr++;
                }}
            System.out.println();
            System.out.println("****************************************");
            System.out.println("-----------Meeting Table Stock-----------");
            System.out.println("****************************************");

            for(int i=0;i<10;i++){
                System.out.println();
                System.out.println("-----------Meeting Table "+(i+1)+". Model-----------");
                for(int j=0;j<Meeting_Tables.get(i).size();j++){
                    System.out.println((ctr+1)+". -> Meeting Table "+ (i+1) +".Model "+(j+1)+".Color : "+Meeting_Tables.get(i).get(j));
                    ctr++;
                }}
            System.out.println();
            System.out.println("****************************************");
            System.out.println("-----------Bookcase Stock-----------");
            System.out.println("****************************************");

            for(int i=0;i<Bookcases.size();i++){
                System.out.println((ctr+1)+". -> Bookcase "+ (i+1) +".Model : "+Bookcases.get(i));
                ctr++;
            }
            System.out.println();
            System.out.println("****************************************");
            System.out.println("-----------Office Cabinet Stock-----------");
            System.out.println("****************************************");

            for(int i=0;i<Office_Cabinets.size();i++){
                System.out.println((ctr+1)+". -> Office Cabinet "+ (i+1) +".Model : "+Office_Cabinets.get(i));
                ctr++;
            }}
    /*-----------------------------------------------------------------------------------------*/
		/**
         *the customer determines the item number of a product from the product list and the amount of the product.
         *<p>
         * then customer enters the its  address and phone number.
         *<p>
         *If the customer enters a product number that is not included in the product list 
         *<p>
         *and if the customer enters a phone number belonging to another customer, 
         *<p>
         *the error message will be printed on the screen.	
         *
         * @param address       Address of customer.
         * @param phone_number   Phone number of customer.
         * @param num_of_product    The product number of the product selected by the customer from the product list.
         * @param piece_of_product The amount of product the customer will buy.
         * @throws ClassException  Error handling Class
         */
        public void Shopping_on_Online(String address,String phone_number,int num_of_product,int piece_of_product)throws ClassException{
            int count3=0,count4=0,count5=0;
            for(int i=0;i<this.address_arr.size();i++){
                if(address.equals(this.address_arr.get(i))){
                    count3++;
                }}
            for(int i=0;i<this.phone_number_arr.size();i++){
                if(phone_number.equals(this.phone_number_arr.get(i))){
                    count4++;
                }}
            if(count3==0 && count4!=0){
                throw new ClassException("!!! Given phone number using for other customer !!!");
            }
            for(int i=0;i<product_list_num.length;i++){
                if(num_of_product==product_list_num[i]){
                    count5++;
                }}
            if(count5==0){
                throw new ClassException("!!! Given product number does not belong the product list !!!");
            }
            else{
                int count2=0;
                for(int i=0;i<this.phone_number_arr.size();i++){
                    if(phone_number==this.phone_number_arr.get(i)){
                        count2++;
                    }}
                if(count2==0){
                    this.address_arr.add(index_of_addres_and_phone_number_arr,address);
                    this.phone_number_arr.add(index_of_addres_and_phone_number_arr,phone_number);
                    index_of_addres_and_phone_number_arr++;
                }
                int ctr2=0;
                
                for(int j=0;j<temporary_item_number[customer_num].length;j++){
                    if(temporary_item_number[customer_num][j]==0){
                        break;
                    }
                    ctr2++;
                }

                temporary_item_number[customer_num][ctr2]=num_of_product;

                ctr2=0;
                for(int j=0;j<permanent_item_number.get(customer_num).size();j++){
                    if(permanent_item_number.get(customer_num).get(j)==0){
                        break;
                    }
                    ctr2++;
                }
                permanent_item_number.get(customer_num).add(ctr2,num_of_product);

                ctr2=0;
                for(int j=0;j<temporary_amount_product_num.get(customer_num).size();j++){
                    if(temporary_amount_product_num.get(customer_num).get(j)==0){
                        break;
                    }
                    ctr2++;
                }
                temporary_amount_product_num.get(customer_num).add(ctr2,piece_of_product);

                ctr2=0;
                for(int j=0;j<permanent_amount_product_num.get(customer_num).size();j++){
                    if(permanent_amount_product_num.get(customer_num).get(j)==0){
                        break;
                    }
                    ctr2++;
                }
                permanent_amount_product_num.get(customer_num).add(ctr2,piece_of_product);
            }}
    /*-----------------------------------------------------------------------------------------*/
		/**
         *function displaying the customer's previous orders.
         *<p>
		 *If a customer's order has been delivered, (done) is written next to it. 
		 *<p>
		 *If the customer's order has not been delivered, nothing will be written.
         */
        public void previous_order(){
            System.out.println("Your Previous Order(Customer Number "+customer_num+"):");

            for(int i=0;i<Customer_Num_Arr.length;i++){
                int ctr2=0;
                if(Customer_Num_Arr[i]==customer_num){
                    for(int j=0;j<permanent_item_number.get(customer_num).size();j++){
                        if(permanent_item_number.get(customer_num).get(j)==0){
                            if(ctr2==0){
                                System.out.println("!!!!! There is No Order !!!!!");
                            }
                            break;
                        }
                        if(j<completed_order_number[i][0]){
                            System.out.println(permanent_item_number.get(customer_num).get(j)
                                +". Product in the List of Product and Amount of Product :"
                                +permanent_amount_product_num.get(customer_num).get(j)+" (DONE)");
                            ctr2++;
                        }
                        if(j>=completed_order_number[i][0]){
                            System.out.println(permanent_item_number.get(customer_num).get(j)
                                +". Product in the List of Product and Amount of Product :"
                                +permanent_amount_product_num.get(customer_num).get(j));
                            ctr2++;
                        }}}}}}
/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/