package lab8.cscd210lab8;

import java.util.Scanner;
import lab8.cscd210methods.CSCD210Lab8Methods;

/**
 * You will not modify this file in any fashion
 */
public class CSCD210Lab8
{
   public static void main(String [] args)
   {
      Scanner kb = new Scanner(System.in);
      
      String name = null;
      double height, weight;
      
      do
      {
         name = CSCD210Lab8Methods.readName(kb);
         height = CSCD210Lab8Methods.readInfo(kb, "height");
         weight = CSCD210Lab8Methods.readInfo("weight", kb);
         CSCD210Lab8Methods.displayResults(name, height, weight, CSCD210Lab8Methods.calcBMI(height, weight));
         
      }while(CSCD210Lab8Methods.goAgain(kb)); 
   
   }// end main

}// end class