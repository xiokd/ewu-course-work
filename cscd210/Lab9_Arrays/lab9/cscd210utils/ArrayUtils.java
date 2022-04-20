package lab9.cscd210utils;

import java.util.Scanner;

public class ArrayUtils
{
      public static int[] addNum(final int[] myArray, final Scanner kb)
      {
            if(kb == null || myArray == null || myArray.length <= 0)
            {
                  throw new IllegalArgumentException("Bad param addNum");
            } // Exception
                     
            int[] copy = new int[myArray.length + 1];
            for(int i = 0; i < myArray.length; i++)
            {
                  copy[i] = myArray [i];
            }
            
            System.out.print("Please enter an integer: ");
            copy[copy.length - 1] = kb.nextInt();
            kb.nextLine();
            
            return copy;
      }
      
      public static int[] createAndFillArray(final int num, final Scanner kb)
      {
            int array[] = new int[num];
            
            if(kb == null || num == 0)
            {
                  throw new IllegalArgumentException("Bad param createAndFillArray");
            } // Exception
            

            System.out.println("Enter the " + num + " numbers:");
            
            for(int i = 0; i < array.length; i++)
            {
                  array[i] = kb.nextInt();
            }
                        
            return array;
      }
      
      public static int[] deleteSingleValue(final int[] myArray, final Scanner kb)
      {     
            if(kb == null || myArray == null || myArray.length <= 0)
            {
                  throw new IllegalArgumentException("Bad param deleteSingleValue");
            } // Exception 
                
            int numDel;
            
            System.out.print("Enter the number you want removed from the array: ");
            numDel = kb.nextInt();
            kb.nextLine();
            
         /*   int index = -1;
            int i = 0;
            for(i = 0; i < myArray.length; i++);
            {
                 if(myArray[i] == numDel)
                 {
                     index = i;
                 } 
            }
            
            if( index == -1)
            {
                  return myArray;
            } 
            
            int[] copy = new int[myArray.length - 1];
            
            int x;
            for(x = 0; x < index ; x++)
            {      
                  copy[x] = myArray[x];
            }
            
            for(int j = x + 1; j < myArray.length; j++)
            {
                  copy[x] = myArray[j];
                  x++;
            }
            
          return copy;  */ 
          
          // Code produces "Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException"
          
          return myArray;
      }
      
      public static void printArray(final int[] myArray)
      {
            if(myArray == null || myArray.length <= 0)
            {
                  throw new IllegalArgumentException("Bad param addNum");
            } // Exception
                  
            System.out.print("[ ");
            
            for(int i = 0; i < myArray.length; i++)
            {
                  System.out.print(myArray[i] + " ");
            }
            System.out.println("]");
      }

}