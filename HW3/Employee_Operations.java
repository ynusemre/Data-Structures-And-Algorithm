/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/
////////////////////////////Employee Operations Interface///////////////////////////////////////
    /**
     *  It is inside Employee Operation Functions.
     */
    public interface Employee_Operations{
        /**
         *	Checking the product stock.
         */
        public void check_The_Product_Stock();
	/*-----------------------------------------------------------------------------------------*/
        /**
         *  Sales Functions.
       	 */
        public void Selling_Ordered_Products();
	/*-----------------------------------------------------------------------------------------*/
        /**
         *	Adding product to the stock.	
         *
         * @param num_of_product     Item number of products in the product list
         * @param piece_of_product   The amount of the ordered product
         */
        public void Add_Product_to_Stock(int num_of_product,int piece_of_product);
	/*-----------------------------------------------------------------------------------------*/
        /**
         * Employee see the customer's orders.
         *
         * @param number            Special customer number entered by employee
         * @throws ClassException    Error handling Class
         */
        public void pre_cust_order(int number)throws ClassException;
	/*-----------------------------------------------------------------------------------------*/
        /**
         *  Employee create order list to market customer.
         *
         * @param address            address of customer
         * @param phone_number        phone number of customer
         * @param num_of_product      Item number of products in the product list
         * @param piece_of_product      The amount of the ordered product
         * @throws ClassException      Error handling Class
         */
        public void Create_Order_List_For_Market_Customer(String address,String phone_number,int num_of_product,int piece_of_product)throws ClassException;
	/*-----------------------------------------------------------------------------------------*/
        /**
         * Employee create new account to market customer.
         *
         * @param name         name of customer
         * @param surname       surname of customer
         * @param e_mail        e-mail of customer
         * @param password       password of customer
         * @return
         */
        public Customer Create_New_Account_For_Market_Customer(String name,String surname,String e_mail,String password);
	/*-----------------------------------------------------------------------------------------*/
        /**
         *  Adding product.
		 *
         * @param number             Given amount for the adding product
         * @param num_of_model       Which model
         * @param num_of_color	     Which color
         */
        public void Supply_Office_Chairs(int number,int num_of_model,int num_of_color);
	/*-----------------------------------------------------------------------------------------*/
        /**
         * Adding product.
		 *
         * @param number             Given amount for the adding product
         * @param num_of_model       Which model
         * @param num_of_color       Which color
         */
        public void Supply_Office_Desks(int number,int num_of_model,int num_of_color);
	/*-----------------------------------------------------------------------------------------*/
        /**
         * Adding product.
		 *
         * @param number            Given amount for the adding product
         * @param num_of_model       Which model
         * @param num_of_color       Which color
         */
        public void Supply_Meeting_Tables(int number,int num_of_model,int num_of_color);
	/*-----------------------------------------------------------------------------------------*/
        /**
         * Adding product.
		 *
         * @param number          Given amount for the adding product
         * @param num_of_model      Which model
         */
        public void Supply_Bookcases(int number,int num_of_model);
	/*-----------------------------------------------------------------------------------------*/
        /**
         * Adding product.
		 *
         * @param number           Given amount for the adding product
         * @param num_of_model       Which model
         */
        public void Supply_Office_Cabinets(int number,int num_of_model);
	/*-----------------------------------------------------------------------------------------*/
        /**
         *	Return an array.
         * @return
         */
        public int[] getProduct_stock_num();
	/*-----------------------------------------------------------------------------------------*/
        /**	
         *	Set an array according to given array.
         * @param product_stock_num
         */
        public void setProduct_stock_num(int []product_stock_num);
	/*-----------------------------------------------------------------------------------------*/
        /**
         *   Return an integer.
         * @return
         */
        public int getCustomer_num();
	/*-----------------------------------------------------------------------------------------*/
        /**
         *    Set an integer according to given number.
         * @param customer_num
         */
        public void setCustomer_num(int customer_num);
    }

/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/