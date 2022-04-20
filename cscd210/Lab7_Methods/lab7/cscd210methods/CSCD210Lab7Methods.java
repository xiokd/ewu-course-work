package lab7.cscd210methods;

import java.util.Scanner;

public class CSCD210Lab7Methods
{ 
   public static int readPosNum(final Scanner kb)
   {
      int userNum;
      
      if(kb == null)
      {
            throw new IllegalArgumentException("Bad param Scanner kb");
      } // Exception if scanner is null
      
      System.out.print("Please enter a positive number ");
      userNum = kb.nextInt();
        
      while (userNum < 1)
      {
      System.out.print("Please enter a positive number ");
      userNum = kb.nextInt();
      } // Checks to make sure user input is a positive number
      
      kb.nextLine(); // Clears input buffer 

     return userNum;
   }     
    
   public static int menu(final Scanner kb)
   {
      int userChoice;
      
      if(kb == null)
      {
            throw new IllegalArgumentException("Bad param Scanner kb");
      } // Exception if scanner is null
      
         System.out.println();
         System.out.println("Please choose from the following");
         System.out.println("1) Enter a new number");
         System.out.println("2) Print the number of even/odd/zeros");                           
         System.out.println("3) Print if number is light or heavy");
         System.out.println("4) Print the value of E");
         System.out.println("5) Print the number in reversed order");
         System.out.println("6) Quit");
         
         System.out.print("Choice --> ");
         
         userChoice = kb.nextInt();
         System.out.println();
         
         while (userChoice < 1 || userChoice > 6)
         {
            System.out.println("Please choose a valid choice option");
            System.out.print("Choice --> "); 
            userChoice = kb.nextInt();
         } // Checks to make sure user input is within range 1-6
         
         kb.nextLine(); // Clears input buffer 
                      
      return userChoice;
   }
      

   public static void oddEvenZero(final int theNum)
   {
         int copy, even, odd, zero, x;

         if(theNum < 1)
         {
               throw new IllegalArgumentException("Number is less than one");
         } // Exception if number is less than one         
         
         copy = theNum;
         even = 0;
         odd = 0;
         zero = 0;
         
         while (copy > 0)
         {
               x = copy % 10;
               if(x != 0 && x % 2 == 0)
               {
                     even++;
               }
               
               else if(x % 2 == 1)
               {
                     odd++;
               }
               
               else
               {
                     zero++;
               }
               
                     copy = copy / 10;
                     
         }
         
         System.out.printf("The number of even/odd/zeros in %d are %d - even, %d - odd, %d - zeros." ,theNum , even, odd, zero);

    }                 

   public static void lightOrHeavy(final int theNum, final Scanner kb)
   {
         if(theNum < 1)
         {
               throw new IllegalArgumentException("Number is less than one");
         } // Exception if number is less than one
         
         if(kb == null)
         {
               throw new IllegalArgumentException("Bad param Scanner kb");
         } // Exception if scanner is null                  
   
          // Unsure how to do this method
   }
   
   
   public static void printE(final int theNum)
   {
         double x, numSum;
         
         if(theNum < 1)
         {
               throw new IllegalArgumentException("Number is less than one");
         } // Exception if number is less than one         
         
         numSum = 1;
         for(x = 1; x <= theNum; x++)
         {
               numSum = numSum + 1/x;
         }
         
         System.out.print(numSum); 
   
   }
   
   public static void printReverse(final int theNum)
   {
         int num, revNum, numCopy;
         
         if(theNum < 1)
         {
               throw new IllegalArgumentException("Number is less than one");
         } // Exception if number is less than one
         
         numCopy = theNum;
         revNum = 0;
         
         while(numCopy != 0)
         {
               num = numCopy % 10;
               revNum = revNum * 10 + num;
               numCopy /= 10;
         
         }
         
         System.out.println(theNum + " reversed is " + revNum);

   }
   


} //End class