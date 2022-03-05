/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/
    
    ///////////////////////////Employee Class//////////////////////////////////////////////////////
    /**
     *  The class that includes the functions of all the operations that the employee can do
     *<p>
     *  Extends Company Class
     *<p>
     * Implement  Employee_Operations Interface and Override its methods 
     */
    public class Employee extends Company implements Employee_Operations{
        private int index_of_permanent_and_temporary_arrays=0;              //Using for index of array.
        
        private  int []Customer_Num_Arr;
        private static int [][]temporary_item_number=new int[10][20];
        private static int [][]temporary_amount_product_num=new int[10][20];
        private static int [][]permanent_item_number=new int[10][20];
        private static int [][]permanent_amount_product_num=new int[10][20];
        private static String []address_arr=new String[20];
        private static String []phone_number_arr=new String[20];
        private static int []product_list_num=new int[125];
        private static int [][]completed_order_number=new int[15][1];

        //Customer special number.Using when a customer shopping in store.
        //Assigns by Employee to customer
        private int customer_num;

        // Array, which holds the amount of product in stock.                
        private int []product_stock_num=new int[125];           
    /*-----------------------------------------------------------------------------------------*/
        /**
         * Employee Constructor
         * <p>
         * Used when an employee will register to the system
         *
         * @param name            name of Employee
         * @param surname         surname of Employee
         * @param e_mail           e-mail of Employee
         * @param password        password of Employee
         */
        public Employee(String name,String surname,String e_mail,String password){
            super(name,surname,e_mail,password);
            Company person=new Customer("default","default","default","default");
            Customer_Num_Arr=((Customer)person).getCustomer_Num_Arr();
            temporary_item_number=((Customer)person).getTemporary_item_number();
            temporary_amount_product_num=((Customer)person).getTemporary_amount_product_num();
            permanent_item_number=((Customer)person).getPermanent_item_number();
            permanent_amount_product_num=((Customer)person).getPermanent_amount_product_num();
            completed_order_number=((Customer)person).getCompleted_order_number();
            address_arr=((Customer)person).getAddress();
            phone_number_arr=((Customer)person).getPhone_number();
            product_list_num=((Customer)person).getProduct_list_num();
            
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         * Copy Constructor
         *
         * @param employee     Employee class object
         */
        public Employee(Employee employee){
            this(employee.GetName_of_customer(),employee.GetSurname_of_customer(),employee.GetE_mail_of_customer(),employee.GetPassword_of_customer());
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  Function that returns the arrays that hold the amount of products in stocks.
         *
         * @return   product_stock_num   the arrays that hold the amount of products in stocks.
         */
        public int[] getProduct_stock_num(){
            return product_stock_num;
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  Set  product_stock_num array according to given array.
         *
         * @param product_stock_num
         */
        public void setProduct_stock_num(int []product_stock_num){
            this.product_stock_num=product_stock_num;
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  Return The special customer number.
         *
         * @return  customer_num   The special customer number.
         */
        public int getCustomer_num(){
            return customer_num;
        }
    /*-----------------------------------------------------------------------------------------*/
        /** 
         *   Set The special customer number according to given array.
         *
         * @param customer_num  The special customer number.
         */
        public void setCustomer_num(int customer_num){
            this.customer_num=customer_num;
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  Function indicating the status of stocks according to the amount of products ordered by customers.
         * <p>
         *  Employee does not add products to stocks if all customer orders are sufficient.
         * <p>
         *  If the product order quantity of any customer is more than the amount in the stocks,
         * <p> 
         *  the employee adds that product in the stocks as required.
         */
        public void check_The_Product_Stock(){
            int[][]Office_Chairs=getOffice_Chairs();
            int[][]Office_Desks=getOffice_Desks();
            int[][]Meeting_Tables=getMeeting_Tables();
            int[]Bookcases=getBookcases();
            int[]Office_Cabinets=getOffice_Cabinets();

            int k=1;

            

            for(int i=0;i<Office_Chairs.length;i++){
                for(int j=0;j<Office_Chairs[i].length;j++){
                    product_stock_num[k]=Office_Chairs[i][j];
                    k++;
                }
            }
            for(int i=0;i<Office_Desks.length;i++){
                for(int j=0;j<Office_Desks[i].length;j++){
                    product_stock_num[k]=Office_Desks[i][j];
                    k++;
                }
            }
            for(int i=0;i<Meeting_Tables.length;i++){
                for(int j=0;j<Meeting_Tables[i].length;j++){
                    product_stock_num[k]=Meeting_Tables[i][j];
                    k++;
                }
            }
            for(int i=0;i<Bookcases.length;i++){
                product_stock_num[k]=Bookcases[i];
                k++;
            }
            for(int i=0;i<Office_Cabinets.length;i++){
                product_stock_num[k]=Office_Cabinets[i];
                k++;
            }
            int less_num=0;

            

            for(int i=0;i<Customer_Num_Arr.length;i++){
                int counter=0;
                if(Customer_Num_Arr[i+1]==0){
                    break;
                }
                try{
                    pre_cust_order(Customer_Num_Arr[i]);
                }
                catch(ClassException e){
                    System.out.println();
                }

                for(int j=0;j<temporary_item_number[i].length;j++){
                    if(temporary_item_number[Customer_Num_Arr[i]][0]==0){
                        counter++;
                        break;
                    }
                    if(temporary_item_number[Customer_Num_Arr[i]][j]==0){
                        break;
                    }
                    if(product_stock_num[temporary_item_number[Customer_Num_Arr[i]][j]]<temporary_amount_product_num[Customer_Num_Arr[i]][j]){
                        less_num=temporary_amount_product_num[Customer_Num_Arr[i]][j]-product_stock_num[temporary_item_number[Customer_Num_Arr[i]][j]];
                        System.out.println("Dear Administrator "+temporary_item_number[Customer_Num_Arr[i]][j]+". Product less :"+ less_num + " Therefore i am adding !!!");
                        counter++;
                        Add_Product_to_Stock((temporary_item_number[Customer_Num_Arr[i]][j]),less_num);
                    }
                }
                if(counter==0){
                    System.out.println("!!!All Order's Amounts are enough in the Stock!!!");
                }
                System.out.println();
            }
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  The Employee makes the sales according to the orders of the customers.
         * <p>
         *  The Employee reduces products from product stocks according to order amounts.
         * <p>
         *  If all sales have been made, a warning message is printed on the screen.
         * <p>
         */
        public void Selling_Ordered_Products(){
            int[][]Office_Chairs=getOffice_Chairs();
            int[][]Office_Desks=getOffice_Desks();
            int[][]Meeting_Tables=getMeeting_Tables();
            int[]Bookcases=getBookcases();
            int[]Office_Cabinets=getOffice_Cabinets();
            Company person=new Customer("default","default","default","default");

            for(int i=0;i<Customer_Num_Arr.length;i++){
                int counter=0;
                if(Customer_Num_Arr[i]==0){
                    System.out.println("-----EMPLOYEE SAY THAT:");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!ALL ORDERS ARE SOLD!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println();
                    break;
                }
                for(int j=0;j<temporary_item_number[i].length;j++){
                    if(temporary_item_number[Customer_Num_Arr[i]][j]==0){
                        completed_order_number[i][0]+=counter;
                        break;
                    }
                    product_stock_num[temporary_item_number[Customer_Num_Arr[i]][j]]-=temporary_amount_product_num[Customer_Num_Arr[i]][j];
                    temporary_item_number[Customer_Num_Arr[i]][j]=0;
                    temporary_amount_product_num[Customer_Num_Arr[i]][j]=0;
                    counter++;
                }
            }
            ((Customer)person).setCompleted_order_number(completed_order_number);
            ((Customer)person).setTemporary_item_number(temporary_item_number);
            ((Customer)person).setTemporary_amount_product_num(temporary_amount_product_num);


            int k=1;
            for(int i=0;i<Office_Chairs.length;i++){
                for(int j=0;j<Office_Chairs[i].length;j++){
                    Office_Chairs[i][j]=product_stock_num[k];
                    k++;
                }
            }
            for(int i=0;i<Office_Desks.length;i++){
                for(int j=0;j<Office_Desks[i].length;j++){
                    Office_Desks[i][j]=product_stock_num[k];
                    k++;
                }
            }
            for(int i=0;i<Meeting_Tables.length;i++){
                for(int j=0;j<Meeting_Tables[i].length;j++){
                    Meeting_Tables[i][j]=product_stock_num[k];
                    k++;
                }
            }
            for(int i=0;i<Bookcases.length;i++){
                Bookcases[i]=product_stock_num[k];
                k++;
            }
            for(int i=0;i<Office_Cabinets.length;i++){
                Office_Cabinets[i]=product_stock_num[k];
                k++;
            }
            setOffice_Chairs(Office_Chairs);
            setOffice_Desks(Office_Desks);
            setMeeting_Tables(Meeting_Tables);
            setBookcases(Bookcases);
            setOffice_Cabinets(Office_Cabinets);
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  The function that adds products to stocks according to the given product item number and product amount.
         * <p>  
         *  This is done using the help of array product_stock_num.
         *
         * @param num_of_product     Item number of products in the product list
         * @param piece_of_product   The amount of the ordered product
         */
        public void Add_Product_to_Stock(int num_of_product,int piece_of_product){
            int[][]Office_Chairs=getOffice_Chairs();
            int[][]Office_Desks=getOffice_Desks();
            int[][]Meeting_Tables=getMeeting_Tables();
            int[]Bookcases=getBookcases();
            int[]Office_Cabinets=getOffice_Cabinets();

            product_stock_num[num_of_product]+=piece_of_product;
            int k=1;

            for(int i=0;i<Office_Chairs.length;i++){
                for(int j=0;j<Office_Chairs[i].length;j++){
                    Office_Chairs[i][j]=product_stock_num[k];
                    k++;
                }
            }
            for(int i=0;i<Office_Desks.length;i++){
                for(int j=0;j<Office_Desks[i].length;j++){
                    Office_Desks[i][j]=product_stock_num[k];
                    k++;
                }
            }
            for(int i=0;i<Meeting_Tables.length;i++){
                for(int j=0;j<Meeting_Tables[i].length;j++){
                    Meeting_Tables[i][j]=product_stock_num[k];
                    k++;
                }
            }
            for(int i=0;i<Bookcases.length;i++){
                Bookcases[i]=product_stock_num[k];
                k++;
            }
            for(int i=0;i<Office_Cabinets.length;i++){
                Office_Cabinets[i]=product_stock_num[k];
                k++;
            }
            setOffice_Chairs(Office_Chairs);
            setOffice_Desks(Office_Desks);
            setMeeting_Tables(Meeting_Tables);
            setBookcases(Bookcases);
            setOffice_Cabinets(Office_Cabinets);
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  Employee, by entering the special customer number into the system :
         * <p>
         *  The employee sees the customers' previous orders.
         * <p>
         *  The employee only sees the products that are not sold.
         * <p>
         *  The employee removes the product from the customer's order list after the sale is made.
         * <p>
         *  if the customer has a new order, the employee adds it to the order list.
         * <p>
         *  If the employee enters a special customer number that does not exist, the error message is suppressed.
         *
         * @param number            Special customer number entered by employee
         * @throws ClassException    Error handling Class
         */
        public void pre_cust_order(int number)throws ClassException{
            int counter6=0;
            for(int i=0;i<Customer_Num_Arr.length;i++){
                if(Customer_Num_Arr[i]==0){
                    break;
                }
                if(number==Customer_Num_Arr[i]){
                    counter6++;
                }
            }
            if(counter6==0){
                throw new ClassException("!!! Given number is not belong any special customer numbers !!!");
            }

            System.out.println("Orders for Customer that special customer number's is "+ number+".");
            int counter=0;
            for(int i=0;i<Customer_Num_Arr.length;i++){
                if(Customer_Num_Arr[i]==number){
                    for(int j=0;j<temporary_item_number[number].length;j++){
                        if(temporary_item_number[number][j]==0){
                            if(counter==0){
                                System.out.println("!!!!! There is No Order !!!!!");
                            }
                            break;
                        }
                        System.out.println(temporary_item_number[number][j]+". Product in the List of Product and Amount of Product :"+temporary_amount_product_num[number][j]);
                        counter++;
                    }
                }
            }
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *If a customer purchases at the store,
         *<p> 
         *an order list is created by the employee according to the products customer bought.
         *<p>
         *If the customer enters a product number that is not included in the product list 
         *<p>
         *and if the customer enters a phone number belonging to another customer, 
         *<p>
         *the error message will be printed on the screen.
         * @param address            address of customer
         * @param phone_number        phone number of customer
         * @param num_of_product      Item number of products in the product list
         * @param piece_of_product      The amount of the ordered product
         * @throws ClassException      Error handling Class
         */
        public void Create_Order_List_For_Market_Customer(String address,String phone_number,int num_of_product,int piece_of_product)throws ClassException{
            int count3=0,count4=0,count5=0;
            Company person=new Customer("default","default","default","default");
            
            for(int i=0;i<address_arr.length;i++){
                if(address.equals(address_arr[i])){
                    count3++;
                }
            }
            for(int i=0;i<phone_number_arr.length;i++){
                if(phone_number.equals(phone_number_arr[i])){
                    count4++;
                }
            }
            if(count3==0 && count4!=0){
                throw new ClassException("!!! Given phone number using for other customer !!!");
            }
            for(int i=0;i<product_list_num.length;i++){
                if(num_of_product==product_list_num[i]){
                    count5++;
                }
            }
            if(count5==0){
                throw new ClassException("!!! Given product number does not belong the product list !!!");
            }

            else{
                int index_of_addres_and_phone_number_arr=((Customer)person).getIndex_of_addres_and_phone_number_arr();
                address_arr[index_of_addres_and_phone_number_arr]=address;
                phone_number_arr[index_of_addres_and_phone_number_arr]=phone_number;
                index_of_addres_and_phone_number_arr++;
                ((Customer)person).setIndex_of_addres_and_phone_number_arr(index_of_addres_and_phone_number_arr);

                temporary_item_number[customer_num][index_of_permanent_and_temporary_arrays]=num_of_product;
                temporary_amount_product_num[customer_num][index_of_permanent_and_temporary_arrays]=piece_of_product;

                permanent_item_number[customer_num][index_of_permanent_and_temporary_arrays]=num_of_product;
                permanent_amount_product_num[customer_num][index_of_permanent_and_temporary_arrays]=piece_of_product;

                index_of_permanent_and_temporary_arrays++;

                ((Customer)person).setAdress(address_arr);
                ((Customer)person).setPhone_numbe(phone_number_arr);
                ((Customer)person).setTemporary_item_number(temporary_item_number);
                ((Customer)person).setTemporary_amount_product_num(temporary_amount_product_num);
                ((Customer)person).setPermanent_item_number(permanent_item_number);
                ((Customer)person).setPermanent_amount_product_num(permanent_amount_product_num);

                


            }
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         * The employee creates a new account for the customer shopping at the store.
         *
         * @param name         name of customer
         * @param surname       surname of customer
         * @param e_mail        e-mail of customer
         * @param password       password of customer
         * @return
         */
        public Customer Create_New_Account_For_Market_Customer(String name,String surname,String e_mail,String password){
            Company person2=new Customer("default","default","default","default");
            customer_num=((Customer)person2).getRandom_special_customer_num();
            Company person=new Customer(name,surname,e_mail,password,customer_num);

            return ((Customer)person);
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  Employee add the given amount of office chairs to their product stock.
         *  A function initially used to add a certain amount of office chairs to the product store.
         *
         * @param number             Given amount for the adding product
         * @param num_of_model       Which model
         * @param num_of_color       Which color
         */
        public void Supply_Office_Chairs(int number,int num_of_model,int num_of_color){
            int[][]Office_Chairs=getOffice_Chairs();
            Office_Chairs[num_of_model][num_of_color]+=number;
            setOffice_Chairs(Office_Chairs);
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  Employee add the given amount of office desks to their product stock.
         *  A function initially used to add a certain amount of office desks to the product store.
         *
         * @param number             Given amount for the adding product
         * @param num_of_model       Which model
         * @param num_of_color       Which color
         */
        public void Supply_Office_Desks(int number,int num_of_model,int num_of_color){
            int[][]Office_Desks=getOffice_Desks();
            Office_Desks[num_of_model][num_of_color]+=number;
            setOffice_Desks(Office_Desks);
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  Employee add the given amount of meeting tables to their product stock.
         *  A function initially used to add a certain amount of meeting tables to the product store.
         *
         * @param number             Given amount for the adding product
         * @param num_of_model       Which model
         * @param num_of_color       Which color
         */
        public void Supply_Meeting_Tables(int number,int num_of_model,int num_of_color){
            int[][]Meeting_Tables=getMeeting_Tables();
            Meeting_Tables[num_of_model][num_of_color]+=number;
            setMeeting_Tables(Meeting_Tables);
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  Employee add the given amount of bookcases to their product stock.
         *  A function initially used to add a certain amount of bookcases to the product store.
         *
         * @param number          Given amount for the adding product
         * @param num_of_model      Which model
         */
        public void Supply_Bookcases(int number,int num_of_model){
            int[]Bookcases=getBookcases();
            Bookcases[num_of_model]+=number;
            setBookcases(Bookcases);
        }
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  Employee add the given amount of office cabinets to their product stock.
         *  A function initially used to add a certain amount of office cabinets to the product store.
         *
         * @param number          Given amount for the adding product
         * @param num_of_model      Which model
         */
        public void Supply_Office_Cabinets(int number,int num_of_model){
            int[]Office_Cabinets=getOffice_Cabinets();
            Office_Cabinets[num_of_model]+=number;
            setOffice_Cabinets(Office_Cabinets);
        }
    }

/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/