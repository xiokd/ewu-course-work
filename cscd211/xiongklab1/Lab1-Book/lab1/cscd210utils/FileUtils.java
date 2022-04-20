package lab1.cscd210utils;

import java.io.*;
import java.util.Scanner;

public class FileUtils {
   public static int countRecords(final Scanner fin, final int linesPer) {
      if(fin == null || linesPer <= 0) {
         throw new IllegalArgumentException("Bad params countRecords");
      }

      int count = 0;

      while(fin.hasNext()) {
         fin.nextLine();
         count++;
      }

      if(count == 0) {
         throw new RuntimeException("Count is 0");
      }

      return count/linesPer;
   }
   
   public static File openInputFile(final Scanner kb)
   {
      if(kb == null) {
         throw new IllegalArgumentException("Bad params openInputFile");
      }

      String fn = null;
      File fin = null;

      do {
         System.out.print("Please enter the name of the file: ");

         fn = kb.nextLine();
         fin = new File(fn);

         if(!fin.exists()) {
            System.out.println("The file does not exist");
         }
      }while(!fin.exists());

      return fin;
   }

    public static File openInputFile(final String filename) {
      if(filename == null || filename.isEmpty()) {
         throw new IllegalArgumentException("filename is empty");
      }

      File inf = new File(filename);

      if(inf.exists()) {
         return inf;
      }

      throw new RuntimeException("File could not be opened");
    }
}
