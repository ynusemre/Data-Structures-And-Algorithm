/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/

///////////////////////////////Company Class////////////////////////////////////
    /**
     *Company class for the Users Feature System.
     *<p>
     *It's Hold the information about Users And Furnitures.
     */
    public class Company{
        
        //Holds Office Chairs Amounts 
        private static KWSingleLinkedList<KWSingleLinkedList<Integer> > Office_Chairs=new KWSingleLinkedList<KWSingleLinkedList<Integer> >();
        //Holds Office Desks Amounts 
        private static KWSingleLinkedList<KWSingleLinkedList<Integer> > Office_Desks=new KWSingleLinkedList<KWSingleLinkedList<Integer> >();
        //Holds Meeting Tables Amounts 
        private static KWSingleLinkedList<KWSingleLinkedList<Integer> > Meeting_Tables=new KWSingleLinkedList<KWSingleLinkedList<Integer> >();
        //Holds Bookcases Amounts
        private static KWSingleLinkedList<Integer> Bookcases=new KWSingleLinkedList<Integer>();
        //Holds Office Cabinets Amounts 
        private static KWSingleLinkedList<Integer> Office_Cabinets=new KWSingleLinkedList<Integer>();

        private String name_of_customer;     //name of system user
        private String surname_of_customer;   //surname of system user
        private String e_mail_of_customer;    //e-mail of system user
        private String password_of_customer;   //password of system user
    
    /*-----------------------------------------------------------------------------------------*/
        /**
         *Constructor of Company class.
         *<p>
         *This constructor take variable for the User Of System.
         *
         * @param name  name of the user of system.
         * @param surname surname of the user of system.
         * @param e_mail e_mail of the user of system.
         * @param password password of the user of system.
         *
         */
        public Company(String name,String surname,String e_mail,String password){
            this.name_of_customer=name;
            this.surname_of_customer=surname;
            this.e_mail_of_customer=e_mail;
            this.password_of_customer=password;

            Office_Chairs.add(new KWSingleLinkedList<Integer>());
            Office_Desks.add(new KWSingleLinkedList<Integer>());
            Meeting_Tables.add(new KWSingleLinkedList<Integer>());
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         * Return name of the user of system
         * @return name_of_customer  
         */
        public String GetName_of_customer(){
            return name_of_customer;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *	Return surname of the user of system.
         * @return surname_of_customer
         */
         public String GetSurname_of_customer(){
            return surname_of_customer;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         * Return  e_mail of the user of system.
         * @return e_mail_of_customer
         */
        public String GetE_mail_of_customer(){
            return e_mail_of_customer;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         * Return password of the user of system.
         * @return password_of_customer
         */
        public String GetPassword_of_customer(){
            return password_of_customer;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *	Return Office Chairs. It holds amount of product.
         * @return Office_Chairs 
         */
        public KWSingleLinkedList<KWSingleLinkedList<Integer> > getOffice_Chairs(){
            return Office_Chairs;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *	Return Office Desks. It holds amount of product.
         * @return Office_Desks
         */
        public KWSingleLinkedList<KWSingleLinkedList<Integer> > getOffice_Desks(){
            return Office_Desks;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         * Return Meeting Tables. It holds amount of product.
         * @return Meeting_Tables
         */
        public KWSingleLinkedList<KWSingleLinkedList<Integer> > getMeeting_Tables(){
            return Meeting_Tables;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         * Return Meeting Tables. It holds amount of product.
         * @return Bookcases
         */
        public KWSingleLinkedList<Integer> getBookcases(){
            return Bookcases;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         * Return Office Cabinets. It holds amount of product.
         * @return Office_Cabinets
         */
        public KWSingleLinkedList<Integer> getOffice_Cabinets(){
            return Office_Cabinets;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         *	Set  New_Office_Chairs Array according to given array.
         * @param New_Office_Chairs
         */
        public void setOffice_Chairs(KWSingleLinkedList<KWSingleLinkedList<Integer> > New_Office_Chairs){
            Office_Chairs=New_Office_Chairs;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         * Set Office_Desks Array according to given array.
         * @param New_Office_Desks
         */
        public void setOffice_Desks(KWSingleLinkedList<KWSingleLinkedList<Integer> > New_Office_Desks){
            Office_Desks=New_Office_Desks;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         * Set Meeting_Tables Array according to given array.
         * @param New_Meeting_Tables
         */
        public void setMeeting_Tables(KWSingleLinkedList<KWSingleLinkedList<Integer> > New_Meeting_Tables){
            Meeting_Tables=New_Meeting_Tables;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         * Set Bookcases Array according to given array.
         * @param New_Bookcases
         */
        public void setBookcases(KWSingleLinkedList<Integer> New_Bookcases){
            Bookcases=New_Bookcases;
        }
    /*-----------------------------------------------------------------------------------------*/
		/**
         * Set Office_Cabinets Array according to given array.
         * @param New_Office_Cabinets
         */
        public void setOffice_Cabinets(KWSingleLinkedList<Integer> New_Office_Cabinets){
            Office_Cabinets=New_Office_Cabinets;
        }
   }

/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/ 