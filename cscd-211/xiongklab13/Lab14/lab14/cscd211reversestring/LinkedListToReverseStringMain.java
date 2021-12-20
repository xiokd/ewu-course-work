/*
 * Non-JUnit tests for LinkedList toReverseString method
 * 
 * Compile and run this file against your solution to toReverseString method in LinkedList.java
 * 
 * Correct output shown in comment below main method
 * 
 * Testing methods follow comment that contains correct output
 * 
 */
package lab14.cscd211reversestring;

public class LinkedListToReverseStringMain {
	
	private LinkedList list;

	public static void main(String[] args) {
		LinkedListToReverseStringMain tester = new LinkedListToReverseStringMain();
		
		tester.setUp();
		tester.testToReverseStringEmptyList();
		
		tester.setUp();
		tester.testToReverseString1Item();
		
		tester.setUp();
		tester.testToReverseString2Items();
		
		tester.setUp();
		tester.testToReverseString10Items();

	}
/*	
Correct output shown below:

PASSED testToReverseStringEmptyList
PASSED testToReverseString1Item
PASSED testToReverseString2Items
PASSED testToReverseString10Items
 */

	public void setUp() {
		list = new LinkedList();
	}



	public void testToReverseStringEmptyList() {
		try{
			if (list.toReverseString().equals(""))
				System.out.println("PASSED testToReverseStringEmptyList");
			else
				System.out.println("FAILED testToReverseStringEmptyList");
			
		}
		catch(Exception e){
			System.out.println("FAILED testToReverseStringEmptyList -- Exception occurred in testToReverseStringEmptyList: " + e.getMessage());
		}
	}
	

	public void testToReverseString1Item() {
		try{
			list.addFirst("single item");
			
			if (list.toReverseString().equals("single item\r\n"))
				System.out.println("PASSED testToReverseString1Item");
			else
				System.out.println("FAILED testToReverseString1Item");
	
			
		}
		catch(Exception e){
			System.out.println("FAILED testToReverseString1Item -- Exception occurred in testToReverseString1Item: " + e.getMessage());
		}
	}
	

	public void testToReverseString2Items() {
		try{
			list.addFirst("second");
			list.addFirst("first");
			
			if (list.toReverseString().equals("second\r\nfirst\r\n"))
				System.out.println("PASSED testToReverseString2Items");
			else
				System.out.println("FAILED testToReverseString2Items");
	
		}
		catch(Exception e){
			System.out.println("FAILED testToReverseString2Items -- Exception occurred in testToReverseString2Items: " + e.getMessage());
		}
	}
	

	public void testToReverseString10Items() {
		try{
			list.addFirst("10");
			list.addFirst("9");
			list.addFirst("8");
			list.addFirst("7");
			list.addFirst("6");
			list.addFirst("5");
			list.addFirst("4");
			list.addFirst("3");
			list.addFirst("2");
			list.addFirst("1");
			
			if (list.toReverseString().equals("10\r\n9\r\n8\r\n7\r\n6\r\n5\r\n4\r\n3\r\n2\r\n1\r\n"))
				System.out.println("PASSED testToReverseString10Items");
			else
				System.out.println("FAILED testToReverseString10Items");

			
		}
		catch(Exception e){
			System.out.println("FAILED testToReverseString10Items -- Exception occurred in testToReverseString10Items: " + e.getMessage());
		}
	}


}
