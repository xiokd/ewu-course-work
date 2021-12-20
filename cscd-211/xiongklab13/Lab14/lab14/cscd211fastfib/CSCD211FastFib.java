package lab14.cscd211fastfib;


public class CSCD211FastFib
{
   /*
 * Fibonacci numbers are a sequence of values defined as follows:
 * 
 * Fibonacci of 0 is by definition 0
 * Fibonacci of 1 is by definition 1
 * 
 * All other Fibonacci values are the result of adding the previous
 * two Fibonacci values together.  Thus the Fibonacci value of 2 is
 * the Fibonacci value of 0 plus the Fibonacci value of 1 which results
 * in 1.  The Fibonacci value of 3 is Fibonacci of 1 plus Fibonacci of 2, which
 * results in 2.
 * 
 * The classic (but incredibly slow - O(2^n) ) recursive solution uses the
 * recurrence:
 * 
 *  Fibonacci(n) = Fibonacci(n-2) + Fibonacci(n-1)
 *  
 *  We can use recursion to produce Fibonacci values much faster than this.
 *  For Fibonacci numbers greater than 1, we need to repetitively calculate
 *  Fibonacci numbers starting at 2 until we reach the desired Fibonacci value
 *  for a specified n.  
 *  
 *  For each recursive call, we simply calculate the current Fibonacci value
 *  by using the previous two Fibonacci values, which are passed as parameters
 *  in the recursive call.  A subsequent recursive call will use the newly 
 *  produced Fibonacci value and the Fibonacci value previous to it.  In addition,
 *  we will want to move to the next Fibonacci number when we make a recursive call.
 *  
 *  Of course we'll stop making recursive calls once the current Fibonacci number
 *  reaches the specified n from the original method call.
 *  
 *  Write the fast version of Fibonacci.  No loops are allowed.  The slow recursive
 *  version is also not allowed. Any code other than the fast recursive version of
 *  Fibonacci will result in 0 points!  Recursion must be used to productively solve
 *  the problem or 0 points will be assigned.
 *  
 *  You are given the public version of the fastFibonacci method.  It includes code
 *  to deal with the base cases of Fibonacci (0 and 1) as well as a commented out call
 *  to a helper method that is the recursive solution.  Uncomment that call, comment out
 *  the return 0 at the end of the method (which was placed there only so the code will
 *  compile), then write the code for the helper method.  The helper method should be
 *  declared private, since something outside this class does not have the proper
 *  information to call it.
 */
 
   public static long fastFibonacci(long n){
		long fib0 = 0; //by definition
		long fib1 = 1; //by definition
		if (n < 2) //base cases (fib of 0 and fib of 1)
			return n;
		
		//to be here we must want at least fib of 2,
		//so make first recursive call with that 2
		
		return fastFibonacci(fib0, fib1, 2, n);
		//return 0;//placed here so code would compile, remove once you have written helper
	}
   
   private static long fastFibonacci(long secondPrev, long firstPrev, long fibNum, long num)
   {
      long currentFib = secondPrev + firstPrev;
      
      if(fibNum < num)
      {
         return fastFibonacci(firstPrev, currentFib, fibNum + 1, num);
      }
      
      return currentFib;
   }

}