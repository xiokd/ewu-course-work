package lab2.cscd211lab2;

import java.io.*;
import java.util.*;
import lab1.cscd210utils.*;
import lab2.cscd211enums.*;
import lab2.cscd211classes.*;
import lab2.cscd211methods.*;
import lab2.cscd211comparators.*;



/**
 * The provided class used to test your code.  This file will
 * not be changed!<br>
 * 
 * <br>NOTE: FileUtils and SortUtils are provided in the jar file;
 */
public class CSCD211Lab2
{
   public static void main(String [] args) throws Exception
   {
      File inf = null;
      int total, choice;
      Person [] myPeeps = null;
      Scanner kb = new Scanner(System.in), fin = null;
      
      inf = FileUtils.openInputFile(kb);
      fin = new Scanner(inf);
      total = FileUtils.countRecords(fin, 3);
      fin.close();
      
      fin = new Scanner(inf);
      myPeeps = CSCD211Lab2Methods.fillArray(fin, total);
      SortUtils.selectionSort(myPeeps);
      fin.close();
      
      do
      {
         choice = CSCD211Lab2Methods.menu(kb);
         
         if(choice == 1)
            CSCD211Lab2Methods.printArray(myPeeps);
         
         else if(choice == 2)
         {
            Color toFind = CSCD211Lab2Methods.readColor(kb);
            CSCD211Lab2Methods.displayAll(toFind, myPeeps);
         }// end choice == 2
         
         else if(choice == 3)
            Arrays.sort(myPeeps, new ColorComparator());
         
         else if(choice == 4)
            Arrays.sort(myPeeps);
            
      }while(choice != 5);
   
   }// end main
      
}// end class 