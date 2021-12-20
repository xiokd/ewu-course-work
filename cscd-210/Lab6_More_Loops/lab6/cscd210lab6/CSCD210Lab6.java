package lab6.cscd210lab6;

import java.util.Scanner;

public class CSCD210Lab6
{
   public static void main(String [] args)
   {
      Scanner kb = new Scanner(System.in);   
      int choice=3, theNum, copy, x, y, counter, even, odd, zero;
      
      /**
         You are NOT allowed to declare additonal variables
         If you use continue or break in your solutions
         (other than the break for the switch) you
         will receive 0 points for Lab 6
      */
      
      System.out.print("Please enter a positive number ");
      theNum = Integer.parseInt(kb.nextLine());
         
      // use a while loop to ensure theNum is greater than 0
      // Your code goes below to the the do
      while (theNum < 1)
      {
      System.out.print("Please enter a positive number ");
      theNum = Integer.parseInt(kb.nextLine());
      }
            
      do
      {
      
         // use a do while loop to ensure choice is in the range of 1 - 4 inclusive
         // Your code goes below to the the switch
         System.out.println();
         System.out.println("Please choose from the following");
         System.out.println("1) Enter a new number");
         System.out.println("2) Print the number of even, odd and zeros in theNum");                           
         System.out.println("3) Print the prime numbers from 2 up to and possibly including theNum");
         System.out.println("4) Quit");
         System.out.print("Choice --> ");
         // read in choice here
         
         choice = kb.nextInt();
         System.out.println();
         
         while (choice < 1 || choice > 4)
         {
            System.out.println("Please choose a valid choice option");
            System.out.print("Choice --> "); 
            choice = kb.nextInt();
         }            
                                             
         switch(choice)
         {
            case 1:  // read a new positive theNum
                     // Your code goes below to the break
                     System.out.print("Please enter a new positive number ");
                     theNum = kb.nextInt();
                     kb.nextLine();
                     
                     break;
                    
            case 2:  // make a copy of theNum 
                     // using a loop display the number of even values, odd values 
                     // and values that are zero in the copy of the number
                     // 1230 has 2 odds, 1 even and 1 zero
                     // Your code goes below to the break
                     
                     copy = theNum;
                     even = 0;
                     odd = 0;
                     zero = 0;
                     
                     while(copy > 0)
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
                           
                           copy = copy /10;
                     }
                     
                     System.out.printf("The number of even/odd/zeros in %d are %d - even, %d - odd, %d - zeros." ,theNum , even, odd, zero);
                     
                     break;  
            
            case 3:  // using nested for loops print the prime numbers 
                     // from 2 up to and possibly including theNum
                     // Your code goes below to the break
                     
                     
                     for( x = 2;x <= theNum;x++)
                     {
                           counter = 0;
                           for(y = 1;y <= x;y++)
                           {
                                 if(x % y == 0)
                                 {
                                       counter++;
                                 }
                           
                           } 
                           if(counter == 2)
                           {
                                 System.out.print(x + " ");
                           }
                           
                     }
                     
                     break;
                     
            default: System.out.println("Good Bye");         
         
         }// end switch
            
      }while(choice != 4);

   }// end main

}// end class