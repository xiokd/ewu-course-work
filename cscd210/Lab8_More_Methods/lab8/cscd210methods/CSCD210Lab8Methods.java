package lab8.cscd210methods;

import java.util.Scanner;

public class CSCD210Lab8Methods
{
   public static java.lang.String readName(final Scanner kb)
   {
         if(kb == null)
         {
               throw new IllegalArgumentException("Bad param readName");
         } // Exception if Scanner is null
         
         System.out.print("Please enter your name: ");
         String name = kb.nextLine();
         
         while(name.length() == 0)
         {
               System.out.print("Please enter your name: ");
               name = kb.nextLine();    
         }
         
         /* kb.nextLine(); (leaves a space within the program, uncommented */
         
         return name;
   }
   
   public static double readInfo(final Scanner kb, final String type)
   {
         if(kb == null || type == null || type.isEmpty())
         {
               throw new IllegalArgumentException("Bad param readInfo");
         } // Exception if Scanner is null, variable type is null, and if type is empty
   
         System.out.print("Please enter your " + type + ": ");
         double res = kb.nextDouble();
         
         while(res <= 0)
         {
               System.out.print("Please enter your " + type + ": ");
               res = kb.nextDouble();               
         }
         
         kb.nextLine(); // Clears input buffer
         
         return res;
   }
   
   public static double readInfo(final java.lang.String type, final Scanner kb)
   {
         if(kb == null || type == null || type.isEmpty())
         {
               throw new IllegalArgumentException("Bad param readInfo");
         } // Exception if Scanner is null, variable type is null, and if type is empty
   
         double res = CSCD210Lab8Methods.readInfo(kb, type);

         return res;
   } 
   
   public static void displayResults(final String name, final double height, final double weight, final double bmi)
   {
      if(name == null || name.isEmpty() || height <= 0 || weight <= 0 || bmi <= 0)
      {
             throw new IllegalArgumentException("Bad param displayResults");
      } // Exception for if String name is null, String name is empty, if height, weight, or bmi is less than or equal to zero
      
      String bmiPhrase = "";
      
      if(bmi < 18.5)
      {
            bmiPhrase = "you are underweight";
      }
      else if(bmi > 18.5 && bmi < 25)
      {
            bmiPhrase = "you are normal weight";
      }
      else if(bmi > 25 && bmi < 30)
      {
            bmiPhrase = "you are overweight";
      }
      else if(bmi > 30)
      {
            bmiPhrase = "you are obese";
      }

      System.out.printf("%s with a weight of %f and a height of %f, your BMI is %f %s.", name, weight, height, bmi, bmiPhrase);
      System.out.println();
         
   }
   
   public static boolean goAgain(final Scanner kb)
   {
         if(kb == null)
         {
               throw new IllegalArgumentException("Bad param goAgain");
         } // Exception if Scanner is null
         
         boolean userChoice = false;
         String choice = "";
         do
         {
               System.out.print("Would you like to calculate another BMI (Yes/No): ");
               choice = kb.nextLine();   
                
         }while(!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")); 
               
               if(choice.equalsIgnoreCase("yes"))
               {
                     userChoice = true;
               }
               else if(choice.equalsIgnoreCase("no"))
               {     
                     System.out.println();
                     System.out.print("Good bye");
                     userChoice = false;
               }
               
               System.out.println();
               /* kb.nextLine(); (leaves a space within the program, uncommented */
               
         return userChoice;
   }
   
   public static double calcBMI(final double height, final double weight)
   {
         if(height <= 0 || weight <= 0)
         {
               throw new IllegalArgumentException("Bad param calcBMI");
         } // Exception if height or weight is less or equal to zero
         
         double bmi;
         
         bmi = weight / (height * height) * 703;
         
         return bmi;
   }
   

}