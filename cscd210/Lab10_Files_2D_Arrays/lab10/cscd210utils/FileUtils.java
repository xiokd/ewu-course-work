package lab10.cscd210utils;

import java.io.*;
import java.util.Scanner;

/**
 * The start of a FileUtils class for CSCD 210<br>
 * All parameters will be passed as final
 */
public class FileUtils
{ 
   /**
    * The openInputFile prompts the user for a filename. After the user enters the filename, 
    * an new file object is created. The file object is checked to see if the file actually exists.
    * If the file exists it is returned otherwise the user is reprompted to enter a file name.
    * This occurs until a file is found that exists.
    * @param kb Representing a valid Scanner object
    * @return File Representing a File that exists
    * @throws IllegalArgumentException if kb is null
    * @NOTE The input buffer will be left empty 
    */
   public static File openInputFile(final Scanner kb)
   {
      if(kb == null)
      {
            throw new IllegalArgumentException("Bad param openInputFile");
      } // Exception
      
      String fn = "";
      File inf = null;
      
      do
      { 
            System.out.print("Enter file name: ");
            fn = kb.nextLine();
            inf = new File(fn);
            
      }while(!inf.exists());
  
      return inf;
   }

}// end class