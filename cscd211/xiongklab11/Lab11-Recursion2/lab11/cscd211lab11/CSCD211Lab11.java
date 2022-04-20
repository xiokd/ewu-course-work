package lab11.cscd211lab11;

import lab11.cscd211recursion.CSCD211Count5s;

/** 
 * Write the recursive methods in the proper package and class as specified below
 */
public class CSCD211Lab11
{
   public static void main(String [] args)
   {      
      int [] values = {515,5,123,55,5123,551235,551535,45751,555555,50501255,555756195,99999,99599};
      
      for(int x = 0; x < values.length; x++)
         System.out.printf("Count of 5s - Number: %d - Count: %d\n", values[x], CSCD211Count5s.count5s(values[x]));
      
   }// end main
   
     
}// end class

