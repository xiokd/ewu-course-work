package lab5.cscd210lab5;

import java.util.Scanner;
import java.text.DecimalFormat;

public class CSCD210Lab5
{
   public static void main(String [] args)
   {
      int term;
      int x;
      int counter = 1;
      double piCalc=0.0;
      String goAgainResponse = null;
      boolean goAgain = false;
      Scanner kb = new Scanner(System.in);
      
      /* NOTE you may not declare any additional variables */
   
      do
      {
            
         System.out.println("Welcome to the Pi approximation program.");
         System.out.println("This program will approximate Pi based on the following series:");
         System.out.println("4 - 4/3 + 4/5 - 4/7 + 4/9 - ...");
         
         System.out.println("Enter the term number to which you would like to approximate Pi");
         System.out.print("(note that 4 is term 1, 4/3 is term 2): ");
      
         /* Your code goes below */
         
         DecimalFormat df = new DecimalFormat(".000000000000000");
         
         term = kb.nextInt();
         
         while (term <= 9)
         {
            System.out.print("Invalid input! Please enter a term greater than 9: ");
            term = kb.nextInt();
         }
         
         
        /*  x = 1;
         while ( x <= term)
         {
            if (x % 2 == 1)
            {
             piCalc = piCalc + (4.0 / counter);
             
             counter = counter + 2;
             x++;
            }
            else if (x % 2 == 0)
            {
            piCalc = piCalc - (4.0 / counter);
            x++;
            }
            
         }  */
          
         
         kb.nextLine();
         
         
         System.out.print("Would you like to try again (yes/no)? ");
         goAgainResponse = kb.nextLine();
         
         while (!goAgainResponse.equalsIgnoreCase("yes") && !goAgainResponse.equalsIgnoreCase("no")) 
         {
            System.out.print("Invalid input! Please enter a (yes/no): ");
            goAgainResponse = kb.nextLine();
         }
         
         if (goAgainResponse.equalsIgnoreCase("yes"))
         {
            goAgain = true;
         }
         else if (goAgainResponse.equalsIgnoreCase("no"))
         {
            goAgain = false;
         }
         
      }while(goAgain);   
   }// end main   
 }// end class