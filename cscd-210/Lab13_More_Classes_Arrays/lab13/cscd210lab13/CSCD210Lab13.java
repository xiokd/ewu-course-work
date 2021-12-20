package lab13.cscd210lab13;


import java.io.*;
import java.util.*;
import lab13.cscd210utils.*;
import lab13.cscd210classes.Author;
import lab13.cscd210methods.CSCD210Lab13Methods;


/**
 * The provided class to test your code.
 * @NOTE You can't change this file, all parameters are passed as final and all pre and
 * post conditions are enforced.
 */
public class CSCD210Lab13
{
   public static void main(String [] args)throws FileNotFoundException
   {
      
      Author [] array = null;
      Author anAuthor = null;
      int choice, total, index;
      Scanner kb = new Scanner(System.in);
      
      File inf = FileUtils.openInputFile(args[0]);  // open the file passedin in args[0]
      Scanner fin = new Scanner(inf);
      total = FileUtils.countRecords(fin, 2);
      fin.close();
      
      fin = new Scanner(inf);
      array = CSCD210Lab13Methods.fillArray(fin, total); // You write
      fin.close();
      
      SortUtils.selectionSort(array);
      
      do
      {
         choice = CSCD210Lab13Methods.menu(kb);
         switch(choice)
         {
            case 1:	ArrayUtils.printArray(array, System.out);  // You write
   					   break;
                     
            case 2:  anAuthor = CSCD210Lab13Methods.readAuthor(kb); // You write
                     array = CSCD210Lab13Methods.add(array, anAuthor); // You write
                     SortUtils.selectionSort(array);
                     break;
                     
            case 3:  anAuthor = CSCD210Lab13Methods.readAuthor(kb);
                     index = SearchUtils.linearSearch(array, anAuthor); // You write
                     array = CSCD210Lab13Methods.remove(array, index); // You write
                     break;
         }// end switch
      
      }while(choice != 4);
    
   }// end main
   
}// end class