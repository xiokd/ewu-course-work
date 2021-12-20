package lab3.cscd211lab3;

import java.io.*;
import java.util.*;
import lab3.cscd211utils.*;
import lab3.cscd211methods.*;
import lab3.cscd211classes.*;
import lab3.cscd211comparators.FirstAuthorSort;



/**
 * The provided class used to test your code.  This file will
 * not be changed!<br>
 * 
 * <br>NOTE: FileUtils, SortUtils, ArrayUtils, and SearchUtils are provided in the jar file;
 */
public class CSCD211Lab3
{
   public static void main(String [] args) throws Exception
   {
      Book [] myBooks = null;
      int choice;
      Scanner kb = new Scanner(System.in);
      
      File inf = FileUtils.openInputFile(kb); 
      Scanner fin = new Scanner(inf);
      myBooks = CSCD211Lab3Methods.fillArray(fin);
      fin.close();
      
      do
      {
         choice = CSCD211Lab3Methods.menu(kb);
         
         switch(choice)
         {
            case 1:  CSCD211Lab3Methods.printBooks(myBooks, System.out);
                     break;
                     
            case 2:  String fileName = CSCD211Lab3Methods.readFileName(kb);
                     PrintStream fout = new PrintStream(new FileOutputStream(fileName), true);
                     CSCD211Lab3Methods.printBooks(myBooks, fout);
                     fout.close();
                     break;
                     
            case 3:  SortUtils.selectionSort(myBooks);
                     break;
            
            case 4:  Arrays.sort(myBooks, new FirstAuthorSort());
                     break;
                     
            case 5:  myBooks = CSCD211Lab3Methods.addBook(myBooks, CSCD211Lab3Methods.createBook(kb));
                     break;
                     
            case 6:  System.out.println("Program Ending");
         
         }// end choice
         
      }while(choice != 6);
   
   }// end main

}// end class