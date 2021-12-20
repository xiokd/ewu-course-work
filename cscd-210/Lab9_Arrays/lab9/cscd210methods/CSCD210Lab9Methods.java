package lab9.cscd210methods;

import java.util.Scanner;

public class CSCD210Lab9Methods
{
      public static int readNum(final Scanner kb)
      {
            int num;
            
            if(kb == null)
            {
                  throw new IllegalArgumentException("Bad param readName");
            } // Exception
            
            do
            {
                  System.out.print("Please enter a positive number greater than zero: ");
                  num = Integer.parseInt(kb.nextLine());
            }while(num <= 0);
            
            return num;
      }
      
      public static int menu(final Scanner kb)
      {
            int choice;
            
            if(kb == null)
            {
                  throw new IllegalArgumentException("Bad param readName");
            } // Exception
            
            do
            {
               System.out.println("Menu choices are:");
               System.out.println("1.) Add a value to the array (by value)");
               System.out.println("2.) Delete a value from the array (by value)");
               System.out.println("3.) Display the array");
               System.out.println("4.) Compute the mean of the array");
               System.out.println("5.) Compute the median of the array");
               System.out.println("6.) Compute the midpoint of the array");
               System.out.println("7.) Compute the standard deviation of the array");
               System.out.println("8.) Compute the mode of the array");
               System.out.println("9.) Quit");
               System.out.println();
               
               System.out.print("Enter your choice: ");
               choice = kb.nextInt();
               kb.nextLine();
               
            }while(choice < 1 || choice > 9);
            
            return choice;
      }
}