package lab10.cscd210lab10;

import java.io.*;
import java.util.Scanner;
import lab10.cscd210utils.FileUtils;
import lab10.cscd210methods.CSCD210Lab10Methods;

public class CSCD210Lab10
{
   public static void main(String [] args)throws Exception
   {
      /**
       * Variable declarations
       */
      File inf = null;
      Scanner fin = null;
      String fileName = null;
      int [] solution = null;
      int days = 0, toRun = 0;
      int [][]generation = null;
      Scanner kb = new Scanner(System.in);
      
      /**
       * Open the file and create a Scanner 
       */      
      inf = FileUtils.openInputFile(kb);   
      fin = new Scanner(inf);
      
      /**
       * Read the times to run the solution and
       * read the number of days to run
       */
      toRun = CSCD210Lab10Methods.readNum(fin);
      days = CSCD210Lab10Methods.readNum(fin);
      
      
      /**
       *
       */
      for(int x = 0; x < toRun; x++)
      {
         solution = CSCD210Lab10Methods.fillSolution(fin);
         CSCD210Lab10Methods.print(solution);
         generation = CSCD210Lab10Methods.fillGeneration(fin);
         CSCD210Lab10Methods.print(generation);
         
         for(int day = 0; day < days; day++)
         {
            generation = CSCD210Lab10Methods.runSolution(generation, solution);
            CSCD210Lab10Methods.print(generation, day);  
             
         }// end for int day
         
         System.out.println();      
      
      }// end for x
      
      fin.close();
   
   }// end main

}// end class