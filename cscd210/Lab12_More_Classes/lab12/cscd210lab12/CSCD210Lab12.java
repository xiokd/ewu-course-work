package lab12.cscd210lab12;

import java.io.*;
import java.util.Scanner;
import lab12.cscd210utils.*;
import lab12.cscd210classes.Fish;
import lab12.cscd210methods.CSCD210Lab12Methods;

/**
 * The class that contains main. The main method will call the compareTo method of Fish in the selectionSort 
 */
public class CSCD210Lab12
{
   public static void main(String [] args) throws Exception
   {
      File inf = null;
      Fish [] myFish = null;
      int totalFish, choice;
      Scanner kb = new Scanner(System.in), fin = null;
      
      inf = FileUtils.openInputFile(kb);
      fin = new Scanner(inf);
      
      totalFish = FileUtils.countRecords(fin, 1);
      fin.close();
      
      fin = new Scanner(inf);
      myFish = CSCD210Lab12Methods.fillArray(fin, totalFish, 1);
      fin.close();
      
      SortUtils.selectionSort(myFish);
      
      do
      {
         choice = CSCD210Lab12Methods.menu(kb);
         
         if(choice == 1)
            CSCD210Lab12Methods.printArray(myFish, System.out);
            
         else if(choice == 2)
         {
            
            String fileName =  CSCD210Lab12Methods.readOutputFileName(kb);
            PrintStream fout = new PrintStream(fileName);
            CSCD210Lab12Methods.printArray(myFish, fout);
         }// end else if choice == 2
         
         else if(choice == 3)
         {
            int index1 = CSCD210Lab12Methods.readIndex(0, myFish.length - 1, kb);
            int index2 = CSCD210Lab12Methods.readIndex(0, myFish.length - 1, kb);
            
            if(myFish[index2].equals(myFish[index1]))
               System.out.println("The two fish are equal in both name and weight");
               
            else
               System.out.println("The two fish are not equal");

         }// end else choice == 3
                  
         else
            System.out.println("Exiting");
         
      }while(choice != 4);
            
   }// end main  
   
}// end class
