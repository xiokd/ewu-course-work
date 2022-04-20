package lab1.cscd210lab1;

import java.io.*;
import java.util.*;
import lab1.cscd210utils.*;
import lab1.cscd210classes.Book;
import lab1.cscd210comparators.*;
import lab1.cscd210methods.CSCD210Lab1Methods;

/**
 * The class that contains main.
 *
 * @NOTE You CANNOT change this class or methods in any fashion
 */
public class CSCD210Lab1
{
   public static void main(String [] args) throws Exception
   {
      Book [] myBooks = null;
      int choice, total, results;
      Scanner kb = new Scanner(System.in);
      
      File inf = FileUtils.openInputFile(kb); // you write
      
      Scanner fin = new Scanner(inf);
      total = FileUtils.countRecords(fin, 4);  // you write
      fin.close();
      
      fin = new Scanner(inf);
      myBooks = CSCD210Lab1Methods.fillArray(fin, total); // you write
      fin.close();

      do
      {
         choice = CSCD210Lab1Methods.menu(kb);
         
         switch(choice)
         {
            case 1:  CSCD210Lab1Methods.printBooks(myBooks, System.out);// you write
                     break;
                     
            case 2:  PrintStream fout = new PrintStream(CSCD210Lab1Methods.readOutputFilename(kb));  
                     CSCD210Lab1Methods.printBooks(myBooks, fout);
                     break;
                     
            case 3:  SortUtils.selectionSort(myBooks); // you write 

                     break;
            
            case 4:  Arrays.sort(myBooks, new BookISBNComparator());// you write BookISBNComparator
                     break;
                     
            case 5:  myBooks = CSCD210Lab1Methods.addBook(myBooks, CSCD210Lab1Methods.createBook(kb)); // you write both addBook and createBook
                     break;
                     
            case 6:  results = SearchUtils.linearSearch(myBooks, CSCD210Lab1Methods.createBook(kb));// you write linearSearch
                     if(results != -1)
                        System.out.println("Book information: " + myBooks[results]);                         
                     else
                        System.out.println("Book was not found");
                     break;
                     
            case 7:  System.out.println("Program Ending");
         
         }// end choice
         
      }while(choice != 7);
      
   }// end main

}// end class