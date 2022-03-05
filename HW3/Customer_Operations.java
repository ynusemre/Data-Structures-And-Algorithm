/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/

////////////////////////////Customer Operations Interface///////////////////////////////////////
	/**
     * It is inside  Customer Operation Functions. 
     */
    public interface Customer_Operations{
        /**
         *	The customer number is automatically defined in the system and the user is informed about it
         */
        public void Inform_Customer_Number();
    /*-----------------------------------------------------------------------------------------*/   
		/**
         *  Listing function when the customer wants to see the product list.    
         */
        public void List_Of_Products();
    /*-----------------------------------------------------------------------------------------*/
		/**
         *  Stock function when the customer wants to see the product Stock.
         */
        public void Stock();
    /*-----------------------------------------------------------------------------------------*/    
        /**
         *		Shopping Operations
         * @param address          Address of customer
         * @param phone_number     Phone number of customer
         * @param num_of_product   number of product  at the product list
         * @param piece_of_product   Amount of Product
         * @throws ClassException   Error handling Class
         */
        public void Shopping_on_Online(String address,String phone_number,int num_of_product,int piece_of_product)throws ClassException;
    /*-----------------------------------------------------------------------------------------*/    
        /**
         *   Show Customer Prcious Orders.
         */
        public void previous_order();
    /*-----------------------------------------------------------------------------------------*/    
        /**
         *  Return an array. 
         * @return
         */
        public int[] getCustomer_Num_Arr();
    /*-----------------------------------------------------------------------------------------*/    
        /** 
         * Set array according to given array. 
         * @param Customer_Num_Arr
         */
        public void setCustomer_Num_Arr(int[] Customer_Num_Arr);
    /*-----------------------------------------------------------------------------------------*/    
        /**
         *  Return an array.
         * @return
         */
        public int[][] getTemporary_item_number();
    /*-----------------------------------------------------------------------------------------*/    
        /**
         *  Set array according to given array.
         * @param temporary_item_number
         */
        public void setTemporary_item_number(int[][] temporary_item_number);
    /*-----------------------------------------------------------------------------------------*/    
        /**
         *   Return an array.
         * @return
         */
        public KWArrayList<KWArrayList<Integer> > getTemporary_amount_product_num();
    /*-----------------------------------------------------------------------------------------*/    
        /**
         *  Set array according to given array.
         * @param temporary_amount_product_num   
         */
        public void setTemporary_amount_product_num(KWArrayList<KWArrayList<Integer> > temporary_amount_product_num);
    /*-----------------------------------------------------------------------------------------*/    
        /**
         *   Return an array.
         * @return
         */
        public KWArrayList<String> getAddress();
    /*-----------------------------------------------------------------------------------------*/    
        /**
         *   Set array according to given array.
         * @param address_arr
         */
        public void setAdress(KWArrayList<String> address_arr);
    /*-----------------------------------------------------------------------------------------*/    
        /**
         *  Return an arraylist.
         * @return
         */
        public KWArrayList<String> getPhone_number();
    /*-----------------------------------------------------------------------------------------*/    
        /**
         *   Set arraylist according to given arraylist.
         * @param phone_number_arr
         */
        public void setPhone_numbe(KWArrayList<String> phone_number_arr);
    /*-----------------------------------------------------------------------------------------*/    
        /**
         *   Return an array.
         * @return
         */
        public KWArrayList<KWArrayList<Integer> > getPermanent_item_number();
    /*-----------------------------------------------------------------------------------------*/    
        /**
         * Set array according to given array.
         * @param permanent_item_number
         */
        public void setPermanent_item_number(KWArrayList<KWArrayList<Integer> > permanent_item_number);
    /*-----------------------------------------------------------------------------------------*/    
        /**
         * Return an array.
         * @return
         */
        public KWArrayList<KWArrayList<Integer> > getPermanent_amount_product_num();
    /*-----------------------------------------------------------------------------------------*/    
        /**
         *  Set array according to given array.
         * @param permanent_amount_product_num
         */
        public void setPermanent_amount_product_num(KWArrayList<KWArrayList<Integer> > permanent_amount_product_num);
    /*-----------------------------------------------------------------------------------------*/    
        /**
         *	Return an array. 
         * @return
         */
        public int[] getProduct_list_num();
    /*-----------------------------------------------------------------------------------------*/    
        /**
         * Set array according to given array.
         * @param product_list_num
         */
        public void setProduct_list_num(int[] product_list_num);
    /*-----------------------------------------------------------------------------------------*/    
        /**
         *  Return an array.
         * @return
         */
        public int[][] getCompleted_order_number();
    /*-----------------------------------------------------------------------------------------*/    
        /**
         * Set array according to given array.
         * @param completed_order_number
         */
        public void setCompleted_order_number(int[][] completed_order_number);
    }

/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/