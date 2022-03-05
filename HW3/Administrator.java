/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/

//////////////////////////////////Administrator Class////////////////////////////////////
    /**
     *Administrator class for the Administrators.
     *<p>
     *And extendes by Company class.
     *<p>
     *Implement  Administrator_Operations Interface and Override its methods 
     */
    public class Administrator extends Company implements Administrator_Operations{
        private static KWSingleLinkedList<Integer> num_of_branch=new KWSingleLinkedList<Integer>();  //At the initial number of brach is 4.
        //private static int num_of_branch=4;     
        private static int num_of_employee;     //Employee number in The Company
        

        //I keep the name, surname, e-mail and password of the administrator working in the branch with a linkedlist.
        private static KWSingleLinkedList<String> Administrator_name_work_in_branch=new KWSingleLinkedList<String>();
        private static KWSingleLinkedList<String> Administrator_surname_work_in_branch=new KWSingleLinkedList<String>();
        private static KWSingleLinkedList<String> Administrator_email_work_in_branch=new KWSingleLinkedList<String>();
        private static KWSingleLinkedList<String> Administrator_password_work_in_branch=new KWSingleLinkedList<String>();

        //Holds the number of products at the stocks
        //Helper array used to modify product quantities in stocks.
        private int []product_stock_num=new int[125];  
	/*-----------------------------------------------------------------------------------------*/
        /**
         * Constructor of Administrator class.
         * @param name  name of the user of System
         * @param surname surname of the user of System
         * @param e_mail e_mail of the user of System
         * @param password password of the user of System
         */
        public Administrator(String name,String surname,String e_mail,String password){
            super(name,surname,e_mail,password);
            num_of_branch.add(4);
            Administrator_name_work_in_branch.add(name);
            Administrator_surname_work_in_branch.add(name);
            Administrator_email_work_in_branch.add(name);
            Administrator_password_work_in_branch.add(name);
        }
	/*-----------------------------------------------------------------------------------------*/
        /**
         *Copy Constructor
         * @param admin  take a  Administrator Object
         */
        public Administrator(Administrator admin){
            this(admin.GetName_of_customer(),admin.GetSurname_of_customer(),admin.GetE_mail_of_customer(),admin.GetPassword_of_customer());
        }
	/*-----------------------------------------------------------------------------------------*/
        /**
         *Return number of branch.
         *@return num_of_branch variable
         */
        public int getNum_of_branch(){
            return num_of_branch.get(0);
        }
	/*-----------------------------------------------------------------------------------------*/
		/**
         *  Set number of branch according to given number.
         * @param num_of_branch
         */
        public void setNum_of_branc(KWSingleLinkedList<Integer> num_of_branch){
            this.num_of_branch=num_of_branch;
        }
	/*-----------------------------------------------------------------------------------------*/
        /**
         *Return number of employee.
         *@return num_of_employee variable
         */
        public int getNum_of_employee(){
            return num_of_employee;
        }
	/*-----------------------------------------------------------------------------------------*/
		/**
         * Set number of employee according to given number.
         * @param num_of_employee
         */
        public void setNum_of_employee(int num_of_employee){
            this.num_of_employee=num_of_employee;
        }
	/*-----------------------------------------------------------------------------------------*/
        /**
         *increase number of branch
         */
        public void Adding_Branch(int number){
            int num=num_of_branch.get(0);
            num_of_branch.add(num+number);
            //num_of_branch+=number;
        }
	/*-----------------------------------------------------------------------------------------*/
        /**
         *decrease number of branch
         */
        public void Remove_Branch(int number){
            num_of_branch.add(num_of_branch.get(0)-number);
            //num_of_branch-=number;
        }
	/*-----------------------------------------------------------------------------------------*/
        /**
         *increase number of employee
         */
        public void Adding_Employee(int number){
            num_of_employee+=number;
        }
	/*-----------------------------------------------------------------------------------------*/
		/**
         * The Administrator is registering new employee.
         * @param name      name of Employee
         * @param surname   Surname of Employee
         * @param e_mail    e-mail of Employee
         * @param password   password of Employee
         * @return          Employee Object
         */
		public Employee Create_New_Account_Employee(String name,String surname,String e_mail,String password){
            Employee person=new Employee(name,surname,e_mail,password);
            return ((Employee)person);
        }
	/*-----------------------------------------------------------------------------------------*/
		/**
         *   Administrator fires the employee
         * @param person  Employee Object
         * @return  Null Employee Object 
         */
        public Employee Deleting_Account_Employee(Employee person){
            person=null;
			return ((Employee)person);
        }
	/*-----------------------------------------------------------------------------------------*/
        /**
         *decrease number of employee
         */
        public void Remove_Employee(int number){
            num_of_employee-=number;
        }
	/*-----------------------------------------------------------------------------------------*/
        /**
         *The Administrator checks the stocks according to the customer orders and warns the employee 
         *<p>
         *if there is a product that needs to be added to the stocks.
         */
        public void Query_Product_in_Stock(){
            KWSingleLinkedList<KWSingleLinkedList<Integer> > Office_Chairs=getOffice_Chairs();
            KWSingleLinkedList<KWSingleLinkedList<Integer> > Office_Desks=getOffice_Desks();
            KWSingleLinkedList<KWSingleLinkedList<Integer> > Meeting_Tables=getMeeting_Tables();
            KWSingleLinkedList<Integer> Bookcases=getBookcases();
            KWSingleLinkedList<Integer> Office_Cabinets=getOffice_Cabinets();

            Company person=new Customer("default","default","default","default");
            int []Customer_Num_Arr=((Customer)person).getCustomer_Num_Arr();
            KWArrayList<KWArrayList<Integer> > temporary_amount_product_num=((Customer)person).getTemporary_amount_product_num();
            int [][]temporary_item_number=((Customer)person).getTemporary_item_number();
            
            int k=1;
            for(int i=0;i<Office_Chairs.size();i++){
                for(int j=0;j<Office_Chairs.get(i).size();j++){
                    product_stock_num[k]=Office_Chairs.get(i).get(j);
                    k++;
                }}
            for(int i=0;i<Office_Desks.size();i++){
                for(int j=0;j<Office_Desks.get(i).size();j++){
                    product_stock_num[k]=Office_Desks.get(i).get(j);
                    k++;
                }}
            for(int i=0;i<Meeting_Tables.size();i++){
                for(int j=0;j<Meeting_Tables.get(i).size();j++){
                    product_stock_num[k]=Meeting_Tables.get(i).get(j);
                    k++;
                }}
            for(int i=0;i<Bookcases.size();i++){
                product_stock_num[k]=Bookcases.get(i);
                k++;
            }
            for(int i=0;i<Office_Cabinets.size();i++){
                product_stock_num[k]=Office_Cabinets.get(i);
                k++;
            }
            int less_num=0;
            for(int i=0;i<Customer_Num_Arr.length;i++){
                int counter=0;
                
                if(Customer_Num_Arr[i+1]==0){
                    break;
                }

                System.out.println("Orders for Customer that special customer number's is "+Customer_Num_Arr[i]+".");
                for(int j=0;j<temporary_item_number[i].length;j++){
                    if(temporary_item_number[Customer_Num_Arr[i]][0]==0){
                        System.out.println("!!!!! There is No Order And Supplying Does Not Necessary !!!!!");
                        counter++;
                        break;
                    }
                    if(temporary_item_number[Customer_Num_Arr[i]][j]==0){
                        break;
                    }
                    if(product_stock_num[temporary_item_number[Customer_Num_Arr[i]][j]]<temporary_amount_product_num.get(Customer_Num_Arr[i]).get(j)){
                        less_num=temporary_amount_product_num.get(Customer_Num_Arr[i]).get(j)-product_stock_num[temporary_item_number[Customer_Num_Arr[i]][j]];
                        System.out.println("Dear Employee "+temporary_item_number[Customer_Num_Arr[i]][j]+". Product less :"+ less_num + " Therefore please supply it !!!");

                        counter++;
                    }}
                if(counter==0){
                    System.out.println("All order's amounts are enough !!!");
                }
                System.out.println();
            }}}
/*------------------------------------------------------------------------------------------------------------*/    
/**************************************************************************************************************/    
/*------------------------------------------------------------------------------------------------------------*/