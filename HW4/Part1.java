@SuppressWarnings("unchecked")

/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
public class Part1 {
	public static void main(String[] args)throws ClassException {
//////////////////////////////////////////////////////////////////////////////////////////////   insert Method
		Heap<Integer> hp = new Heap<Integer>();    					//First Heap Tree
		hp.insert(6);
		hp.insert(18);
		hp.insert(8);
		hp.insert(20);
		hp.insert(39);
		hp.insert(29);
		hp.insert(28);
		hp.insert(37);
		hp.insert(32);
		hp.insert(76);
		hp.insert(26);
		hp.insert(66);
		hp.insert(30);
		hp.insert(89);
		hp.insert(35);
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/		
//////////////////////////////////////////////////////////////////////////////////////////////   -search Method-
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("---SEARCH METHOD---");
		System.out.println("hp Heap Tree :"+hp);
		hp.search(101);  											//If given value does not exist
		hp.search(76);  											//If given value exists
		hp.search(89);  											//If given value exists
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/		
//////////////////////////////////////////////////////////////////////////////////////////////   -merge Method-		
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("---MERGE METHOD---");
		Heap<Integer> hp2 = new Heap<Integer>();    				//Second Heap Tree
		
		hp2.insert(20);
		hp2.insert(21);
		hp2.insert(22);
		hp2.insert(23);
		hp2.insert(6);
		hp2.insert(4);
		hp2.insert(3);
		hp2.insert(2);
		
		System.out.println("Before The Merge operations :");
		System.out.println("hp Heap Tree :"+hp);
		System.out.println("hp2 Heap Tree :"+hp2);
		System.out.println("---------------------------");
		System.out.println("For Heap hp :");
		hp.search(23);
		hp.search(2);
		hp.search(3);
		
		hp.merge(hp2);
		System.out.println("---------------------------");
		System.out.println();
		System.out.println("After The Merge operations :");
		System.out.println("hp Heap Tree :"+hp);
		System.out.println("For Heap hp :");
		hp.search(23);
		hp.search(2);
		hp.search(3);
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/		
//////////////////////////////////////////////////////////////////////////////////////////////   -remove Method-		
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("---REMOVE METHOD---");
		
		System.out.println("Before The remove operations :");
		System.out.println("hp Heap Tree :"+hp);
		System.out.println("---------------------------");
		System.out.println("1th largest value is "+hp.remove(1)+" removing from hp Heap Tree");// remove 1th largest element
		System.out.println("15th largest value is "+hp.remove(15)+" removing from hp Heap Tree");// remove 15th largest element
		System.out.println("---------------------------");
		System.out.println();
		System.out.println("After The remove operations :");
		System.out.println("hp Heap Tree :"+hp);
/////////////////////////////////////////////////////////////////////     if given value more than the heap size,
		System.out.println("---------------------------");
		System.out.println();
		System.out.println("if given value more than the heap size :");
		try{
			System.out.println("90th largest value is "+hp.remove(90)+" removing from hp Heap Tree");
		}catch(ClassException e){
			System.out.println(e);
		}
/////////////////////////////////////////////////////////////////////     if a Heap tree is empty,
		Heap<Integer> hp3 = new Heap<Integer>();    					//Third Heap Tree
		System.out.println("---------------------------");
		System.out.println();
		System.out.println("If a Heap is Empty :");
		try{
			System.out.println("1th largest value is "+hp3.remove(1)+" removing from hp3 (EMPTY) Heap Tree");
		}catch(ClassException e){
			System.out.println(e);
		}							
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
//////////////////////////////////////////////////////////////////////////////////////////////     -Iterator set Method-
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("---Iterator Class---");

		System.out.println("hp Heap Tree :"+hp);
		
		Iterator itr=hp.iterator();
		int i=0;
		System.out.println();
		System.out.println("Iterator start to traverse in the heap :");
		
		while(itr.hasNext()){
			try{
				if(i==2){
					System.out.println("1 number set to iterator's current cursor ");
					System.out.println("1 set to "+itr.next());
					itr.Set(1);
				}
				itr.next();
				i++;
			}
			catch(ClassException e){
				System.out.println(e);
			}
		}
		System.out.println();	
		System.out.println("After the Iterator set operations :");	
		System.out.println("hp Heap Tree :"+hp);
/////////////////////////////////////////////////////////////////////     if a Heap tree is empty,		
		System.out.println("---------------------------");
		System.out.println();
		System.out.println("If a Heap is Empty (FOR THE iterator next METHOD):");

		Iterator itr2=hp3.iterator();
		try{
			itr2.next();
		}catch(ClassException e){
			System.out.println(e);
		}

		System.out.println("---------------------------");
		System.out.println();
		System.out.println("If a Heap is Empty (FOR THE iterator remove METHOD):");

		try{
			itr2.remove();
		}catch(ClassException e){
			System.out.println(e);
		}
	}
}
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------------------------------------------*/