package lab12.cscd210methods;

import java.io.*;
import java.util.*;
import lab12.cscd210classes.Fish;

/**
 * The standard methods class that we all have to write
 *
 * @NOTE You must pass all parameters as final
 */
public class CSCD210Lab12Methods
{
      
   /**
    * The fillArray first builds an array of Fish references based on the argument total.  The fillArray method
    * next reads a line from the file. The file is comma separated and is a valid file.
    * The file contains type, weight. Use a nextLine to read in the entire line and then separate that
    * line using methods in the String class or by creating a different Scanner that will find the next token
    * based on the comma. Once you have the type and weight separated build a Fish object and place the object into the array.
    *
    * @param fin Representing the Scanner object to an open file
    * @param total Representing how many items will be in the array
    * @param linesPer Representing the number of lines that make up a record
    * @return Fish[] Representing a filled array of Fish objects
    *
    * @throws IllegalArgumentException if fin is null
    * @throws IllegalArgumentException if total &lt;=0
    * @throws IllegalArgumentException if linesPer is &lt;=0
    *
    * @NOTE if you use methods in the String class to separate type from weight you will also need to use .trim() from the String class
    */
   public static Fish[] fillArray(final Scanner fin, final int total, final int linesPer)
   {
      if(fin == null || total <= 0 || linesPer <= 0)
      {
         throw new IllegalArgumentException("Bad params fillArray");
      }
               
      Fish [] array = new Fish[total];
      
      for(int i = 0; i < array.length ; i++)
      {
            String temp = fin.nextLine();
            String [] res = temp.split(",");
            res[0] = res[0].trim();
            
            double d = Double.parseDouble(res[1].trim());
            array[i] = new Fish(res[0], d);
      }
      
            
      return array;
   }
   
   /**
    * The printArray method uses the PrintStream object output to print out each fish one fish per line
    * to either the screen or the file depending on where output is an alias
    *
    * @param myFish Representing the array of Fish
    * @param output Representing the PrintStream object to the screen or the file
    *
    * @throws IllegalArgumentException if myFish is null or the length is &lt;=0
    * @throws IllegalArgumentException if output is null   
    */
   public static void printArray(final Fish [] myFish, PrintStream output)
   {
      if(myFish == null || myFish.length <= 0 || output == null)
         throw new IllegalArgumentException("Bad Params printArray");
  
      for(Fish f: myFish)
         output.println(f);
   
   }
   
   /**
    * The readIndex method prompts the user to enter a number that is between the
    * startIndex and endIndex inclusive.  It ensure the value entered is &gt;= startIndex and &lt;= endIndex
    *
    * @param startIndex Representing the starting value
    * @param endIndex Representing the ending value
    * @param kb Representing the Scanner object to the keyboard
    * @return int Representing a value between startIndex and endIndex inclusive
    *
    * @throws IllegalArgumentException if startIndex is &lt; 0
    * @throws IllegalArgumentException if endIndex is &lt; 0 or &lt; startIndex
    * @throws IllegalArgumentException if kb is null
    *
    * @NOTE The input buffer will be cleared by you at the end of the method
    */    
   public static int readIndex(int startIndex, int endIndex, Scanner kb)
   {
      if(startIndex < 0 || endIndex < 0 || endIndex < startIndex ||kb == null)
      {
         throw new IllegalArgumentException("Bad params readIndex");
      }
      
      int val;
      
      do
      {
         System.out.print("Please enter a number between " + startIndex +  " and " +  endIndex + " ");
         val = Integer.parseInt(kb.nextLine());
      }while(val < startIndex || val > endIndex);
      
      return val;
   }// end readIndex
   
   /**
    * The menu method prompts the user to enter a value between 1 and 4 inclusive. <br>
    * 1) Print the array to the screen<br>
    * 2) Print the array to an output file<br>
    * 3) Read and index and check for equality<br>
    * 4) Quit<br>
    *
    * @param kb Representing the Scanner object to the keyboard
    * @return int Representing a number between 1 and 4 inclusive
    *
    * @throws IllegalArgumentException if kb is null
    *
    * @NOTE The input buffer will be cleared by you at the end of the method
    */    
   public static int menu(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("Bad Params menu");
   
      int choice;
      do
      {
         System.out.println("Please choose from the following:");
         System.out.println("1) Print the array to the screen");      
         System.out.println("2) Print the array to a file"); 
         System.out.println("3) Read and index and check for equality");           
         System.out.println("4) Quit"); 
         System.out.print("Choice --> "); 
         choice = Integer.parseInt(kb.nextLine());
      }while(choice < 1 || choice > 4);
      
      return choice;         
   }// end menu
   
   /**
    * The readOutputFileName prompts the user of the name of an output file and ensures a filename is entered
    *
    * @param kb Representing the Scanner object to the keyboard
    * @return String Representing the output filename
    *
    * @throws IllegalArgumentException if kb is equal to null
    *
    * @NOTE The input buffer will be cleared by you at the end of the method
    */
   public static String readOutputFileName(final Scanner kb)
   {
      if(kb == null)
      {
            throw new IllegalArgumentException("Scanner kb cannot be null");
      }
               
      String filename = "";
      
      do
      {
            System.out.print("Enter file name: ");
            filename = kb.nextLine();
      }while(filename.isEmpty());
      
     return filename;
   }// end readOutputFileName
   
}// end class