package lab13.cscd210utils;

import java.util.Scanner;
import java.io.PrintStream;

/**
 * The ArrayUtils class performs basic array functions, such as adding an item to the array
 * removing items from the array, printing the arrays.<br>
 * All parameters will be passed as final. <br>
 * All pre and post conditions will be enforced
 * @NOTE The ArrayUtils class only works on Generics with or without Comparable
 */
public class ArrayUtils<T>
{
   
   /**
    * The printArray method prints the array in the following fashion<br>
    * [value, value, value, ..., value]
    *
    * @param <T> This describes a generic type
    * @param myArray Representing the array of T to be printed
    * @param fout Representing the PrintStream object
    *
    * @throws IllegalArgumentException if myArray is null
    * @throws IllegalArgumentException if the length of myArray is less than or equal to zero
    */
   public static <T> void printArray(T [] myArray, final PrintStream fout)
   {
      if(myArray == null || myArray.length <= 0)
      {
         throw new IllegalArgumentException("Bad params printArray");
      }
      
      fout.print("[");
      
      for(int i = 0; i < myArray.length; i++)
      {
         fout.print(myArray[i]);
         if(i != myArray.length - 1)
         {
             fout.print(", ");
         }

      }
      
      fout.println("]");
      
   }// end printArray

}// end class