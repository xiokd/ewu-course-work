package lab14.cscd211gcd;
/*
 * Write the two recursive methods below, given the instructions that precede
 * each method.  Also look at (and run) the unit tests (RecursionGCDTests and
 * RecursionFastFibonacciTests) if you are using Eclipse and understand unit tests
 * or look at (and run) RecursionGCDMain and RecursionFastFibonacciMain if you
 * do not understand unit tests and/or you are not using Eclipse.
 * 
 */
public class CSCD211GCD
{
	
	/*
	 * There are multiple algorithms to produce the greatest common divisor
	 * of two integers greater than 0.  
	 * 
	 * One version, which is recursive in nature is defined as follows:
	 * 
	 * gcd(m, n)
	 * 	if (m == n): m
	 *  if (m > n): recursively call gcd with m-n and n
	 *  if (m < n): recursively call gcd with m and n-m
	 *  
	 *  Implement the algorithm above in the method below.  No loops or other
	 *  versions of gcd are allowed and will result in 0 points!  Recursion
	 *  must be used to productively solve the problem or 0 points will be assigned.
	 */
	public static int gcd(int m, int n)
	{
      if(m == n)
      {
         return m;
      }
      
      else if(m > n)
      {
         return gcd(m - n, n);
      }
      
      return gcd(m, n - m);   
	}
	
}// end class
