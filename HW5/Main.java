@SuppressWarnings("unchecked")

public class Main{
	public static void main(String []args) throws ClassException{
		HashMap<String,String> b=new HashMap<String,String>();
		HashMap<String,String> b2=new HashMap<String,String>();		
		HashMap<Integer,Integer> b3=new HashMap<Integer,Integer>();

		b.put("Türkiye","Ankara");
		b.put("Fransa","Paris");
		b.put("İngiltere","Londra");
		b.put("İspanya","Madrid");
		b.put("Portekiz","Porto");
		b.put("Almanya","Berlin");
		b.put("Rusya","Moskava");
		b.put("Ukrayna","Kiev");
		
		System.out.println("HashMap b :");
		b.print();
/*----------------------------------------------------------------------------------------------------------------*/
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("--- With Iterator HashMap b (Begin Fransa key) (itr) ---");
		Iterator<String> itr=b.iterator("Fransa");
		
		while(itr.hasNext()==true){
			try{
				System.out.println(itr.next());
			}catch(ClassException e){
				System.out.println(e);
			}
		}
/*----------------------------------------------------------------------------------------------------------------*/		
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("--- Prev method applied for 6 position from the last cursor position(İspanya) ---");
		System.out.println(" Cursor back to İspanya key again with using prev method (itr)");
		System.out.println("--- Prev Method For b HashMap ---");
		try{	
			System.out.println(itr.prev());
			System.out.println(itr.prev());
			System.out.println(itr.prev());
			System.out.println(itr.prev());
			System.out.println(itr.prev());
			System.out.println(itr.prev());
		}catch(ClassException e){
			System.out.println(e);
		}
/*----------------------------------------------------------------------------------------------------------------*/
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("--- With Iterator HashMap b (Begin initial key) (itr5) ---");
		Iterator<String> itr5=b.iterator();

		while(itr5.hasNext()==true){
			try{
				System.out.println(itr5.next());
			}catch(ClassException e){
				System.out.println(e);
			}
		}
/*----------------------------------------------------------------------------------------------------------------*/		
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		Iterator<Integer> itr3=b3.iterator();
		System.out.println();
		System.out.println("--- Before the put element to b3 HashMap ---");
		System.out.println( "if there are still not-iterated key/s in the Map, otherwise returns False :");
		System.out.println(itr3.hasNext());		
/*----------------------------------------------------------------------------------------------------------------*/		
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		b3.put(1,101);
		System.out.println();
		System.out.println("HashMap b3 :");
		b3.print();

/*----------------------------------------------------------------------------------------------------------------*/		
		System.out.println("----------------------------------------------------------------------------------------------------------------");		
		System.out.println();
		System.out.println("It returns the first key when there is no not-iterated key in the Map (itr3) :");
		
		try{
			System.out.println(itr3.next());
		}catch(ClassException e){
			System.out.println(e);
		}
/*----------------------------------------------------------------------------------------------------------------*/
		b3.put(2,102);
		b3.put(3,103);
		b3.put(4,104);
		b3.put(5,105);
		b3.put(6,106);
		b3.put(7,107);
/*----------------------------------------------------------------------------------------------------------------*/
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("HashMap b3 :");
		b3.print();		
/*----------------------------------------------------------------------------------------------------------------*/		
		System.out.println("----------------------------------------------------------------------------------------------------------------");		
		System.out.println();
		System.out.println("It returns the last key when the iterator(itr6) is at the first key :");
		Iterator<Integer> itr6=b3.iterator();
		try{
			System.out.println(itr6.prev());
			
		}catch(ClassException e){
			System.out.println(e);
		}		
/*----------------------------------------------------------------------------------------------------------------*/
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		Iterator<Integer> itr4=b3.iterator(4);
		System.out.println();
		System.out.println("--- With Iterator(itr4) HashMap b3 (Begin 4 key) ---");
		
		while(itr4.hasNext()==true){
			try{
				System.out.println(itr4.next());
			}catch(ClassException e){
				System.out.println(e);
			}
		}
System.out.println("----------------------------------------------------------------------------------------------------------------");
//////////////////////////////////////////////////////////////////////////// Exception
		System.out.println();
		System.out.println("For Empty HashMap b2: ");
		System.out.println("--- Exception Handling For HashMap ---");
/*----------------------------------------------------------------------------------------------------------------*/
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		Iterator<String> itr2=b2.iterator();
		//next method
		try{
			System.out.println(itr2.next());
		}catch(ClassException e){
			System.out.println(e);
		}
/*----------------------------------------------------------------------------------------------------------------*/		
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		//prev method
		System.out.println("--- After Prev Method For b2 HashMap ---");
		try{	
			System.out.println(itr2.prev());
		}catch(ClassException e){
			System.out.println(e);
		}
/*----------------------------------------------------------------------------------------------------------------*/
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		//get method
		System.out.println("--- After Prev Method For b2 HashMap ---");
		try{	
			System.out.println(b2.get("Çin"));
		}catch(ClassException e){
			System.out.println(e);
		}

/*----------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------HashTableChain------------------------------------------------------*/
/*--------------------------------------------With LinkedList-----------------------------------------------------*/
	System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("--------------------------------------------HashTableChain------------------------------------------------------");
	System.out.println("--------------------------------------------With LinkedList-----------------------------------------------------");
	int SMALL=10;
	int MEDIUM=100;
	int LARGE=1000;

	long startTime;
	long endTime;
	long estimatedTime;
	
	System.out.println();
	System.out.println("------ HashTableChain With LinkedList ------");
	
	HashTableChain<String,Integer> a=new HashTableChain<String,Integer>();
	HashTableChain<String,Integer> a2=new HashTableChain<String,Integer>();

	System.out.println("------ METHOD TESTING ------");
/*----------------------------------------------------------------------------------------------------------------*/		
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	a.put("Adana",01);
	a.put("Çankırı",18);
	a.put("Çorum",19);
	a.put("İstanbul",34	);
	
	System.out.println("İstanbul(Key) is being put and its value : "+a.put("İstanbul",37));
	
	a.put("İzmir",35);
	a.put("Kocaeli",41);
	a.put("Edirne",22);
	a.put("Bolu",14);
	a.print();
/*----------------------------------------------------------------------------------------------------------------*/		
	System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("Size of the HashTable :" +a.size());
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("HashTable is mpty ? :" +a.isEmpty());
/*----------------------------------------------------------------------------------------------------------------*/		
	System.out.println("----------------------------------------------------------------------------------------------------------------");		
	try{
		System.out.println();
		System.out.println("if the key does not exits in the HashTableChain :");
		System.out.println("Muğla(Key) is being Remove and its value : "+a.remove("Muğla"));
	}catch(ClassException e){
		System.out.println(e);
	}
/*----------------------------------------------------------------------------------------------------------------*/		
	System.out.println("----------------------------------------------------------------------------------------------------------------");	
	System.out.println();
	a.print();
	try{
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println("İzmir(Key) is being Remove and its value : "+ a.remove("İzmir"));
	}catch(ClassException e){
		System.out.println(e);
	}
	System.out.println();
	a.print();
System.out.println("----------------------------------------------------------------------------------------------------------------");	
//////////////////////////////////////////////////////////////////////////// Exception
	System.out.println();
	System.out.println("For Empty HashTableChain a2: ");
	System.out.println("--- Exception Handling For HashTableChain With LinkedList ---");

	//remove method
	try{
		System.out.println(a2.remove("Ordu"));
	}catch(ClassException e){
		System.out.println(e);
	}
	System.out.println();
/*----------------------------------------------------------------------------------------------------------------*/		
	System.out.println("----------------------------------------------------------------------------------------------------------------");		
	//get method
	try{
		System.out.println(a2.get("Ordu"));
	}catch(ClassException e){
		System.out.println(e);
	}	
/*----------------------------------------------------------------------------------------------------------------*/		
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("------------------ PERFORMANCE TESTING ------------------");
	
	HashTableChain<Integer,Integer> small=new HashTableChain<Integer,Integer>();
	HashTableChain<Integer,Integer> medium=new HashTableChain<Integer,Integer>();
	HashTableChain<Integer,Integer> large=new HashTableChain<Integer,Integer>();

	System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("1) TEST WITH SMALL SIZE ");
	System.out.println("----------------------------------------------------------------------------------------------------------------");
/*----------------------------------------------------------------------------------------------------------------*/	
	startTime = System.nanoTime();
	for(int i=0 ; i<SMALL ; i++){
		small.put(i,i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with LİnkedList For put Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=0 ; i<SMALL ; i++){
		small.get(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with LİnkedList For get Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=0 ; i<SMALL ; i++){
		small.remove(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with LİnkedList For remove Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/
System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("1) TEST WITH MEDIUM SIZE ");
	System.out.println("----------------------------------------------------------------------------------------------------------------");
/*----------------------------------------------------------------------------------------------------------------*/	
	startTime = System.nanoTime();
	for(int i=0 ; i<MEDIUM ; i++){
		medium.put(i,i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with LİnkedList For put Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=0 ; i<MEDIUM ; i++){
		medium.get(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with LİnkedList For get Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=1 ; i<MEDIUM ; i++){
		medium.remove(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with LİnkedList For remove Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/
System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("1) TEST WITH LARGE SIZE ");
	System.out.println("----------------------------------------------------------------------------------------------------------------");
/*----------------------------------------------------------------------------------------------------------------*/	
	startTime = System.nanoTime();
	for(int i=0 ; i<LARGE ; i++){
		large.put(i,i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with LİnkedList For put Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=0 ; i<LARGE ; i++){
		large.get(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with LİnkedList For get Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=0 ; i<LARGE ; i++){
		large.remove(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with LİnkedList For remove Method Operation Time:"+estimatedTime);	
/*----------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------HashTableChain------------------------------------------------------*/
/*---------------------------------------------With TreeSet-------------------------------------------------------*/
	System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("--------------------------------------------HashTableChain------------------------------------------------------");
	System.out.println("--------------------------------------------With TreeSet-----------------------------------------------------");
	System.out.println();
	System.out.println("--- HashTableChain With TreeSet ---");
	
	HashTableChain2<String,Integer> c=new HashTableChain2<String,Integer>();
	HashTableChain2<String,Integer> c2=new HashTableChain2<String,Integer>();

	c.put("Adana",01);
	c.put("Çankırı",18);
	c.put("Çorum",19);
	c.put("İstanbul",34	);
	c.put("İzmir",35);
	c.put("Kocaeli",41);
	c.put("Edirne",22);
	c.put("Bolu",14);

	System.out.println("------ METHOD TESTING ------");	
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");	
	c.print();
/*----------------------------------------------------------------------------------------------------------------*/		
	System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("Size of the HashTable :" +c.size());
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("HashTable is mpty ? :" +c.isEmpty());	
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	try{
		System.out.println();
		System.out.println("if the key does not exits in the HashTableChain :");
		System.out.println("Karaman(Key) is being Remove and its value : "+c.remove("Karaman"));
	}catch(ClassException e){
		System.out.println(e);
	}
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");	
	System.out.println();
	c.print();
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");	
	try{
		System.out.println();
		System.out.println("Bolu(Key) is being Remove and its value : "+ c.remove("Bolu"));
	}catch(ClassException e){
		System.out.println(e);
	}
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");	
	System.out.println();
	c.print();
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

//////////////////////////////////////////////////////////////////////////// Exception
	System.out.println();
	System.out.println("--- Exception Handling For HashTableChain With TreeSet ---");

	//remove method
	try{
		System.out.println(c2.remove("Ordu"));
	}catch(ClassException e){
		System.out.println(e);
	}
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");	
	System.out.println();
	//get method
	try{
		System.out.println(c2.get("Ordu"));
	}catch(ClassException e){
		System.out.println(e);
	}
/*----------------------------------------------------------------------------------------------------------------*/		
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("------------------ PERFORMANCE TESTING ------------------");
	
	HashTableChain2<Integer,Integer> small2=new HashTableChain2<Integer,Integer>();
	HashTableChain2<Integer,Integer> medium2=new HashTableChain2<Integer,Integer>();
	HashTableChain2<Integer,Integer> large2=new HashTableChain2<Integer,Integer>();

	System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("1) TEST WITH SMALL SIZE ");
	System.out.println("----------------------------------------------------------------------------------------------------------------");
/*----------------------------------------------------------------------------------------------------------------*/	
	startTime = System.nanoTime();
	for(int i=0 ; i<SMALL ; i++){
		small2.put(i,i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with TreeSet For put Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=0 ; i<SMALL ; i++){
		small2.get(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with TreeSet For get Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=0 ; i<SMALL ; i++){
		small2.remove(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with TreeSet For remove Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/
System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("1) TEST WITH MEDIUM SIZE ");
	System.out.println("----------------------------------------------------------------------------------------------------------------");
/*----------------------------------------------------------------------------------------------------------------*/	
	startTime = System.nanoTime();
	for(int i=0 ; i<MEDIUM ; i++){
		medium2.put(i,i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with TreeSet For put Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=0 ; i<MEDIUM ; i++){
		medium2.get(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with TreeSet For get Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=1 ; i<MEDIUM ; i++){
		medium2.remove(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with TreeSet For remove Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/
System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("1) TEST WITH LARGE SIZE ");
	System.out.println("----------------------------------------------------------------------------------------------------------------");
/*----------------------------------------------------------------------------------------------------------------*/	
	startTime = System.nanoTime();
	for(int i=0 ; i<LARGE ; i++){
		large2.put(i,i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with TreeSet For put Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=0 ; i<LARGE ; i++){
		large2.get(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("ashTable Chain with TreeSet For get Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=0 ; i<LARGE ; i++){
		large2.remove(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("HashTable Chain with TreeSet For remove Method Operation Time:"+estimatedTime);	

/*----------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------HashTableOpen------------------------------------------------------*/
/*------------------------------------With Coalesced Hashing Technique--------------------------------------------*/	
	System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("--------------------------------------------HashTableOpen------------------------------------------------------");
	System.out.println("---------------------------------- With Coalesced Hashing Technique--------------------------------------------");
	System.out.println();
	System.out.println("------------------------------------------------------------------------------------------------------");
	System.out.println("--- HashTableOpen Coalesced Hashing Technique ---");
	System.out.println();
	System.out.println("------ METHOD TESTING ------");	
	
	HashtableOpen<Integer,Integer> d=new HashtableOpen<Integer,Integer>();
	HashtableOpen<Integer,Integer> d2=new HashtableOpen<Integer,Integer>();

	d.put(3,100);
	d.put(12,101);
	d.put(13,102);
	d.put(25,103);
	d.put(23,104);
	d.put(51,105);
	d.put(42,106);
	
	
	d.print();
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");	
	

	System.out.println("Number of HashTableOpen :"+d.size());	
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("--- After the Removing ---");
	
	try{
		
		System.out.println("if the key does not exits in the HashTableOpen :");
		System.out.println("1(Key) is being Remove and its value : "+d.remove(1));
	}catch(ClassException e){
		System.out.println(e);
	}
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");	
	System.out.println();
	d.print();
	try{
		System.out.println();
		System.out.println("13(Key) is being Remove and its value : "+ d.remove(13));
	}catch(ClassException e){
		System.out.println(e);
	}
	System.out.println();
	d.print();
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
//////////////////////////////////////////////////////////////////////////// Exception
	System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("--- Exception Handling For HashTableOpen Coalesced Hashing Technique ---");
	

	//remove method
	try{
		System.out.println(d2.remove(50));
	}catch(ClassException e){
		System.out.println(e);
	}
	System.out.println();
	//get method
	try{
		System.out.println(d2.get(74));
	}catch(ClassException e){
		System.out.println(e);
	}	
	
	/*----------------------------------------------------------------------------------------------------------------*/		
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("------------------ PERFORMANCE TESTING ------------------");
	
	HashtableOpen<Integer,Integer> small3=new HashtableOpen<Integer,Integer>();
	HashtableOpen<Integer,Integer> medium3=new HashtableOpen<Integer,Integer>();
	HashtableOpen<Integer,Integer> large3=new HashtableOpen<Integer,Integer>();

	System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("1) TEST WITH SMALL SIZE ");
	System.out.println("----------------------------------------------------------------------------------------------------------------");
/*----------------------------------------------------------------------------------------------------------------*/	
	startTime = System.nanoTime();
	for(int i=0 ; i<SMALL ; i++){
		small3.put(i,i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("Coalesced HashTable Open  For put Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=0 ; i<SMALL ; i++){
		small3.get(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("Coalesced HashTable Open For get Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=0 ; i<SMALL ; i++){
		small3.remove(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("Coalesced HashTable Open For remove Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/
System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("1) TEST WITH MEDIUM SIZE ");
	System.out.println("----------------------------------------------------------------------------------------------------------------");
/*----------------------------------------------------------------------------------------------------------------*/	
	startTime = System.nanoTime();
	for(int i=0 ; i<MEDIUM ; i++){
		medium3.put(i,i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("Coalesced HashTable Open For put Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=0 ; i<MEDIUM ; i++){
		medium3.get(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("Coalesced HashTable Open For get Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=1 ; i<MEDIUM ; i++){
		medium3.remove(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("Coalesced HashTable Open For remove Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/
System.out.println();
	System.out.println("----------------------------------------------------------------------------------------------------------------");
	System.out.println("1) TEST WITH LARGE SIZE ");
	System.out.println("----------------------------------------------------------------------------------------------------------------");
/*----------------------------------------------------------------------------------------------------------------*/	
	startTime = System.nanoTime();
	for(int i=0 ; i<LARGE ; i++){
		large3.put(i,i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("Coalesced HashTable Open For put Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=0 ; i<LARGE ; i++){
		large3.get(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("Coalesced HashTable Open For get Method Operation Time:"+estimatedTime);
/*----------------------------------------------------------------------------------------------------------------*/	
	System.out.println("----------------------------------------------------------------------------------------------------------------");

	startTime = System.nanoTime();
	for(int i=0 ; i<LARGE ; i++){
		large3.remove(i);
	}
	endTime=System.nanoTime();
	estimatedTime=endTime-startTime;
	System.out.println("Coalesced HashTable Open For remove Method Operation Time:"+estimatedTime);
















	}
}