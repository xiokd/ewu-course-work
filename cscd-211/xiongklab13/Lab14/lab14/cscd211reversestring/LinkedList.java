package lab14.cscd211reversestring;

/*
 * Write the recursive toReverseString method at the bottom of the LinkedList
 * class given below.  See the method signature for further details.
 * 
 * To further clarify behavior, run the unit tests in LinkedListToReverseStringTests
 * if you are familiar with unit tests and are using Eclipse.  Look at and run
 * LinkedListToReverseStringMain if you are not familiar with unit tests and/or
 * your are not using Eclipse.
 */

//LinkedList with no dummy node (head points at first node in list)
public class LinkedList {

	//nested Node class
	private class Node{
		private Object data;
		private Node next;
		
		private Node(){
			this(null, null);
			
		}// end default Node constructor
		
		private Node(Object data, Node next){
			this.data = data;
			this.next = next;
		}// end parameterized Node constructor
		
				
	}//end nested class Node
	
	private Node head;
	private int size;
	
	public LinkedList(){
		
		this.head = null;
		this.size = 0;
		
	}// end default LinkedList constructor
	
	public int size(){
		return this.size;
	}// end size method
	
	@Override
	public String toString(){
		
		String result = "";
		
		result += "List size is: " + this.size + "\r\n";
		
		for (Node cur = this.head; cur != null; cur = cur.next){
			result += cur.data + "\r\n";
		}//end for
		
		return result;
		
	}// end toString method
	
	public void addFirst(Object data){
		
		this.head = new Node(data, this.head);
		this.size++;
		
	}// end addFirst
	
	
	/*
	 * Given the public method below, write a private recursive helper method
	 * (based on the call in the public method below).
	 * 
	 * The private helper method should use recursion to build a string containing
	 * the contents of the linked list (based on the data in each node).  The
	 * string should contain the contents of the list in REVERSE order.
	 * 
	 * Each entry will be separated by a newline -- \r\n
	 * 
	 * No loops of any form are allowed an recursion must be used productively to
	 * solve the problem or 0 points will be earned.
	 */
	public String toReverseString(){
		String result = "";
		
		//NOTE: UNCOMMENT THE LINE OF CODE BELOW ONCE YOU HAVE WRITTEN THE HELPER METHOD
		//YOUR HELPER METHOD SHOULD BE DESIGNED SPECIFICALLY BASED ON THE CALL
		//MADE BELOW.
		
		result = toReverseString(this.head, result);
		
		return result;
		
	}//end printReverse
	
	private String toReverseString(Node cur, String res)
   {
      if(cur != null)
      {
         res = res + toReverseString(cur.next, res);
         res = res + cur.data + "\r\n";
      }
      
      return res;
   }
   		
}//end LinkedList
