/*
 * Non-JUnit tests for Recursion fastFibonacci method
 * 
 * Compile and run this file against your solution to fastFibonacci method in CSCD211FastFib.java
 * 
 * Correct output shown in comment below main method
 * 
 * Testing methods follow comment that contains correct output. Check those methods
 * for expected results.
 * 
 */
package lab14.cscd211fastfib;


public class RecursionFastFibonacciMain {

	public static void main(String[] args) {
		RecursionFastFibonacciMain tester = new RecursionFastFibonacciMain();
		
		tester.testFastFibonacci0();
		tester.testFastFibonacci1();
		tester.testFastFibonacci2();
		tester.testFastFibonacci3();
		tester.testFastFibonacci4();
		tester.testFastFibonacci5();
		tester.testFastFibonacci10();
		tester.testFastFibonacci40();

	}
/*	
Correct test results below:

PASSED testFastFibonacci0
PASSED testFastFibonacci1
PASSED testFastFibonacci2
PASSED testFastFibonacci3
PASSED testFastFibonacci4
PASSED testFastFibonacci5
PASSED testFastFibonacci10
PASSED testFastFibonacci40
*/

	public void testFastFibonacci0() {
		try{
			long result = CSCD211FastFib.fastFibonacci(0);
			
			if (result == 0)
				System.out.println("PASSED testFastFibonacci0");
			else
				System.out.println("FAILED testFastFibonacci0");
			
		}
		catch(Exception e){
			System.out.println("FAILED testFastFibonacci0 -- Exception occurred in testFastFibonacci0: " + e.getMessage());
		}
		
	}
	

	public void testFastFibonacci1() {
		try{
			long result = CSCD211FastFib.fastFibonacci(1);
			
			if (result == 1)
				System.out.println("PASSED testFastFibonacci1");
			else
				System.out.println("FAILED testFastFibonacci1");

			
		}
		catch(Exception e){
			System.out.println("FAILED testFastFibonacci1 -- Exception occurred in testFastFibonacci1: " + e.getMessage());
		}
		
	}
	

	public void testFastFibonacci2() {
		try{
			long result = CSCD211FastFib.fastFibonacci(2);
			
			if (result == 1)
				System.out.println("PASSED testFastFibonacci2");
			else
				System.out.println("FAILED testFastFibonacci2");

			
		}
		catch(Exception e){
			System.out.println("FAILED testFastFibonacci2 -- Exception occurred in testFastFibonacci2: " + e.getMessage());
		}
		
	}
	

	public void testFastFibonacci3() {
		try{
			long result = CSCD211FastFib.fastFibonacci(3);
			
			if (result == 2)
				System.out.println("PASSED testFastFibonacci3");
			else
				System.out.println("FAILED testFastFibonacci3");

			
		}
		catch(Exception e){
			System.out.println("FAILED testFastFibonacci3 -- Exception occurred in testFastFibonacci3: " + e.getMessage());
		}
		
	}
	

	public void testFastFibonacci4() {
		try{
			long result = CSCD211FastFib.fastFibonacci(4);
			
			if (result == 3)
				System.out.println("PASSED testFastFibonacci4");
			else
				System.out.println("FAILED testFastFibonacci4");

			
		}
		catch(Exception e){
			System.out.println("FAILED testFastFibonacci4 -- Exception occurred in testFastFibonacci4: " + e.getMessage());
		}
		
	}
	

	public void testFastFibonacci5() {
		try{
			long result = CSCD211FastFib.fastFibonacci(5);
			
			if (result == 5)
				System.out.println("PASSED testFastFibonacci5");
			else
				System.out.println("FAILED testFastFibonacci5");

			
		}
		catch(Exception e){
			System.out.println("FAILED testFastFibonacci5 -- Exception occurred in testFastFibonacci5: " + e.getMessage());
		}
		
	}
	

	public void testFastFibonacci10() {
		try{
			long result = CSCD211FastFib.fastFibonacci(10);
			
			if (result == 55)
				System.out.println("PASSED testFastFibonacci10");
			else
				System.out.println("FAILED testFastFibonacci10");

			
		}
		catch(Exception e){
			System.out.println("FAILED testFastFibonacci10 -- Exception occurred in testFastFibonacci10: " + e.getMessage());
		}
		
	}
	

	public void testFastFibonacci40() {
		try{
			long result = CSCD211FastFib.fastFibonacci(40);
			
			if (result == 102334155)
				System.out.println("PASSED testFastFibonacci40");
			else
				System.out.println("FAILED testFastFibonacci40");

			
		}
		catch(Exception e){
			System.out.println("FAILED testFastFibonacci40 -- Exception occurred in testFastFibonacci40: " + e.getMessage());
		}
		
	}

	
}
