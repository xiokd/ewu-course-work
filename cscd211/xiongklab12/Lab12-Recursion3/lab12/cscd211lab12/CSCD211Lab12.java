package lab12.cscd211lab12;

import lab12.cscd211recursion.*;


public class CSCD211Lab12 {
	
	
	public static void testFindLargestEmptyArray() {
		try{
			int [] array = new int[0];
			
			int largest = RecursionFindLargest.findLargest(array);
			System.out.println("testFindLargestEmptyArray - largest value is: " + largest);
		}
		catch(Exception e){
			System.out.println("testFindLargestEmptyArray - Expected exception: " + e.getClass().getSimpleName() + ", " + e.getMessage());
		}
		
		
	}
	
	
	public static void testFindLargest1ItemArray() {
		try{
			int [] array = {55};
			
			int largest = RecursionFindLargest.findLargest(array);
			System.out.println("testFindLargest1ItemArray - largest value is: " + largest);
		}
		catch(Exception e){
			System.out.println("Exception occurred in testFindLargestEmptyArray: " + e.getMessage());
		}
		
	}
	
	
	public static void testFindLargest2ItemArray() {
		try{
			int [] array = {55, 66};
			
			int largest = RecursionFindLargest.findLargest(array);
			System.out.println("testFindLargest2ItemArray - largest value is: " + largest);
		}
		catch(Exception e){
			System.out.println("Exception occurred in testFindLargest2ItemArray: " + e.getMessage());
		}
		
	}
	
	
	public static void testFindLargest3ItemArray() {
		try{
			int [] array = {55, 66, 44};
			
			int largest = RecursionFindLargest.findLargest(array);
			System.out.println("testFindLargest3ItemArray - largest value is: " + largest);
		}
		catch(Exception e){
			System.out.println("Exception occurred in testFindLargest3ItemArray: " + e.getMessage());
		}
		
	}
	
	
	public static void testFindLargest5ItemArray() {
		try{
			int [] array = {1, 2, 1, 2, 1};
			
			int largest = RecursionFindLargest.findLargest(array);
			System.out.println("testFindLargest5ItemArray - largest value is: " + largest);
		}
		catch(Exception e){
			System.out.println("Exception occurred in testFindLargest5ItemArray: " + e.getMessage());
		}
		
	}

	
	public static void testFindLargest10ItemArray() {
		try{
			int [] array = {1, 2, 1, 2, 1, 0, -1, 2, 3, 1};
			
			int largest = RecursionFindLargest.findLargest(array);
			System.out.println("testFindLargest10ItemArray - largest value is: " + largest);
		}
		catch(Exception e){
			System.out.println("Exception occurred in testFindLargest10ItemArray: " + e.getMessage());
		}
		
	}

	
	public static void testFindLargest10ItemArrayAllSame() {
		try{
			int [] array = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
			
			int largest = RecursionFindLargest.findLargest(array);
			System.out.println("testFindLargest10ItemArrayAllSame - largest value is: " + largest);
		}
		catch(Exception e){
			System.out.println("Exception occurred in testFindLargest10ItemArrayAllSame: " + e.getMessage());
		}
		
	}

	
	public static void testFindLargest10ItemArrayAscending() {
		try{
			int [] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
			
			int largest = RecursionFindLargest.findLargest(array);
			System.out.println("testFindLargest10ItemArrayAscending - largest value is: " + largest);
		}
		catch(Exception e){
			System.out.println("Exception occurred in testFindLargest10ItemArrayAscending: " + e.getMessage());
		}
		
	}


	public static void main(String[] args) {
		testFindLargestEmptyArray();
		testFindLargest1ItemArray();
		testFindLargest2ItemArray();
		testFindLargest3ItemArray();
		testFindLargest5ItemArray();
		testFindLargest10ItemArray();
		testFindLargest10ItemArrayAllSame();
		testFindLargest10ItemArrayAscending();

	}

}
/*
testFindLargestEmptyArray - Expected exception: IllegalArgumentException, array passed to findLargest was empty
testFindLargest1ItemArray - largest value is: 55
testFindLargest2ItemArray - largest value is: 66
testFindLargest3ItemArray - largest value is: 66
testFindLargest5ItemArray - largest value is: 2
testFindLargest10ItemArray - largest value is: 3
testFindLargest10ItemArrayAllSame - largest value is: 1
testFindLargest10ItemArrayAscending - largest value is: 10
*/

