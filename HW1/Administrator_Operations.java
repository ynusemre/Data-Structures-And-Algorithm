/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/ 

////////////////////////////////Administrator Operations Interface////////////////////////////////////
	/**
     *  It is inside  Administrator Operation Functions.
     */
    public interface Administrator_Operations{
        /**
         *   Adding operation.
         * @param number
         */
        public void Adding_Branch(int number);
    /*-----------------------------------------------------------------------------------------*/
        /**
         *   Removing operation.
         * @param number
         */
        public void Remove_Branch(int number);
    /*-----------------------------------------------------------------------------------------*/
        /**
         *   Adding operation.
         * @param number
         */
        public void Adding_Employee(int number);
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  Removing operation.
         * @param number
         */
        public void Remove_Employee(int number);
    /*-----------------------------------------------------------------------------------------*/
        /**
         *   Query operation.
         */
        public void Query_Product_in_Stock();
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  Create New Account operation
         * @param name     	  name of Employee
         * @param surname     surname of Employee
         * @param e_mail      e-mail of Employee
         * @param password    password of Employee
         * @return         
         */
        public Employee Create_New_Account_Employee(String name,String surname,String e_mail,String password);
    /*-----------------------------------------------------------------------------------------*/
        /**
         *   Removing operation.
         * @param person      
         * @return            
         */      
        public Employee Deleting_Account_Employee(Employee person);
    /*-----------------------------------------------------------------------------------------*/
        /**
         *    return an integer.
         * @return    
         */
        public int getNum_of_branch();
    /*-----------------------------------------------------------------------------------------*/
        /**
         *	Set an integer according to given number.
         * @param num_of_branch
         */
        public void setNum_of_branc(int num_of_branch);
    /*-----------------------------------------------------------------------------------------*/
        /**
         *   return an integer.
         * @return
         */
        public int getNum_of_employee();
    /*-----------------------------------------------------------------------------------------*/
        /**
         *  Set an integer according to given number.
         * @param num_of_employee
         */
        public void setNum_of_employee(int num_of_employee);
    }

/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/