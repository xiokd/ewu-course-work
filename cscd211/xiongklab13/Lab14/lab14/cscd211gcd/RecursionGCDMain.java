/*
 * Non-JUnit tests for Recursion Gcd method
 * 
 * Compile and run this file against your solution to Gcd method in CSCD211GCD.java
 * 
 * Correct output shown in comment below main method
 * 
 * Testing methods follow comment that contains correct output. Check those methods
 * for expected results.
 * 
 */
package lab14.cscd211gcd;

public class RecursionGCDMain {

	public static void main(String[] args) {
		RecursionGCDMain tester = new RecursionGCDMain();
		
		tester.testGcd1and1();
		tester.testGcd1and2();
		tester.testGcd2and1();
		tester.testGcd2and3();
		tester.testGcd2and4();
		tester.testGcd2and1000();
		tester.testGcd3and1000();
		tester.testGcd1000and3();
		tester.testGcd1000and600();
		tester.testGcd1001and991();
		tester.testGcd1002and992();

	}
/*
Correct results shown below:

PASSED testGcd1and1
PASSED testGcd1and2
PASSED testGcd2and1
PASSED testGcd2and3
PASSED testGcd2and4
PASSED testGcd2and1000
PASSED testGcd3and1000
PASSED testGcd1000and3
PASSED testGcd1000and600
PASSED testGcd1001and991
PASSED testGcd1002and992

 */
	
	public void testGcd1and1() {
		try{
			int result = CSCD211GCD.gcd(1, 1);
			
			if (result == 1)
				System.out.println("PASSED testGcd1and1");
			else
				System.out.println("FAILED testGcd1and1");
			
		}
		catch(Exception e){
			System.out.println("FAILED -- Exception occurred in testGcd1and1: " + e.getMessage());
		}
		
	}
	

	public void testGcd1and2() {
		try{
			int result = CSCD211GCD.gcd(1, 2);
			
			if (result == 1)
				System.out.println("PASSED testGcd1and2");
			else
				System.out.println("FAILED testGcd1and2");
	
			
		}
		catch(Exception e){
			System.out.println("FAILED -- Exception occurred in testGcd1and2: " + e.getMessage());
		}
		
	}
	

	public void testGcd2and1() {
		try{
			int result = CSCD211GCD.gcd(2, 1);
			
			if (result == 1)
				System.out.println("PASSED testGcd2and1");
			else
				System.out.println("FAILED testGcd2and1");
	
			
		}
		catch(Exception e){
			System.out.println("FAILED -- Exception occurred in testGcd2and1: " + e.getMessage());
		}
		
	}
	

	public void testGcd2and3() {
		try{
			int result = CSCD211GCD.gcd(2, 3);
			
			if (result == 1)
				System.out.println("PASSED testGcd2and3");
			else
				System.out.println("FAILED testGcd2and3");
	
			
		}
		catch(Exception e){
			System.out.println("FAILED -- Exception occurred in testGcd2and3: " + e.getMessage());
		}
		
	}
	

	public void testGcd2and4() {
		try{
			int result = CSCD211GCD.gcd(2, 4);
			
			if (result == 2)
				System.out.println("PASSED testGcd2and4");
			else
				System.out.println("FAILED testGcd2and4");
	
	
		}
		catch(Exception e){
			System.out.println("FAILED -- Exception occurred in testGcd2and4: " + e.getMessage());
		}
		
	}
	

	public void testGcd2and1000() {
		try{
			int result = CSCD211GCD.gcd(2, 1000);
			
			if (result == 2)
				System.out.println("PASSED testGcd2and1000");
			else
				System.out.println("FAILED testGcd2and1000");

		}
		catch(Exception e){
			System.out.println("FAILED -- Exception occurred in testGcd2and1000: " + e.getMessage());
		}
		
	}
	

	public void testGcd3and1000() {
		try{
			int result = CSCD211GCD.gcd(3, 1000);
			
			if (result == 1)
				System.out.println("PASSED testGcd3and1000");
			else
				System.out.println("FAILED testGcd3and1000");

		}
		catch(Exception e){
			System.out.println("FAILED -- Exception occurred in testGcd3and1000: " + e.getMessage());
		}
		
	}
	

	public void testGcd1000and3() {
		try{
			int result = CSCD211GCD.gcd(1000, 3);
			
			if (result == 1)
				System.out.println("PASSED testGcd1000and3");
			else
				System.out.println("FAILED testGcd1000and3");

		}
		catch(Exception e){
			System.out.println("FAILED -- Exception occurred in testGcd1000and3: " + e.getMessage());
		}
		
	}
	

	public void testGcd1000and600() {
		try{
			int result = CSCD211GCD.gcd(1000, 600);
			
			if (result == 200)
				System.out.println("PASSED testGcd1000and600");
			else
				System.out.println("FAILED testGcd1000and600");

		}
		catch(Exception e){
			System.out.println("FAILED -- Exception occurred in testGcd1000and600: " + e.getMessage());
		}
		
	}
	

	public void testGcd1001and991() {
		try{
			int result = CSCD211GCD.gcd(1001, 991);
			
			if (result == 1)
				System.out.println("PASSED testGcd1001and991");
			else
				System.out.println("FAILED testGcd1001and991");

		}
		catch(Exception e){
			System.out.println("FAILED -- Exception occurred in testGcd1001and991: " + e.getMessage());
		}
		
	}
	

	public void testGcd1002and992() {
		try{
			int result = CSCD211GCD.gcd(1002, 992);
			
			if (result == 2)
				System.out.println("PASSED testGcd1002and992");
			else
				System.out.println("FAILED testGcd1002and992");

		}
		catch(Exception e){
			System.out.println("FAILED -- Exception occurred in testGcd1002and992: " + e.getMessage());
		}
		
	}
	
}
