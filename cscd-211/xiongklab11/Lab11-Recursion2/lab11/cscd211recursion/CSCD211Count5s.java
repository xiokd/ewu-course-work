package lab11.cscd211recursion;


/**
 * The class for the single recursive method used for this lab
 */
public class CSCD211Count5s
{
    /**
    * Given a non-negative int n, return the count of the occurrences of 5 as a digit,
    * so for example 515 yields 2. (no loops or strings). 
    * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), 
    * while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
    *
    * count5s(515) - 2
    * count5s(5) - 1
    * count5s(123) - 0
    * count5s(57) - 1
    * count5s(75) - 1
    *
    * <br>
    * @param n The value to be checked for 5s
    * @return int The number of 5s in the number n
    */
   public static int count5s(final int n)
   {
      if(n == 0)
      {
         return 0;
      }
      
      else if(n % 10 == 5)
      {
         return 1 + count5s(n / 10);
      }
      
      return count5s(n / 10);
   }// end method   

}// end class


/*
Count of 5s - Number: 515 - Count: 2
Count of 5s - Number: 5 - Count: 1
Count of 5s - Number: 123 - Count: 0
Count of 5s - Number: 55 - Count: 2
Count of 5s - Number: 5123 - Count: 1
Count of 5s - Number: 551235 - Count: 3
Count of 5s - Number: 551535 - Count: 4
Count of 5s - Number: 45751 - Count: 2
Count of 5s - Number: 555555 - Count: 6
Count of 5s - Number: 50501255 - Count: 4
Count of 5s - Number: 555756195 - Count: 5
Count of 5s - Number: 99999 - Count: 0
Count of 5s - Number: 99599 - Count: 1
*/