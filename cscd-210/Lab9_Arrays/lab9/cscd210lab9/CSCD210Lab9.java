package lab9.cscd210lab9;

import java.util.Scanner;
import lab9.cscd210utils.ArrayUtils;
import lab9.cscd210utils.IntStatisticsUtils;
import lab9.cscd210methods.CSCD210Lab9Methods;

/**
 * The class that contains the main method
 */
public class CSCD210Lab9
{
   /**
    * The main method you can't change.<br>
    *<br>
    * Note: main exits normally not with a System.exit(0);
    *
    * @param args Representing the array of command line parameters
    */
   public static void main(String [] args)
   {
      int num, choice;
      int [] myArray = null;
      Scanner kb = new Scanner(System.in);
      double mean, median, midpoint, stdDev, mode;

      num = CSCD210Lab9Methods.readNum(kb);
      myArray = ArrayUtils.createAndFillArray(num, kb);

      do
      {
         choice = CSCD210Lab9Methods.menu(kb);

         switch(choice)
         {
            case 1:  myArray = ArrayUtils.addNum(myArray, kb);
                     break;

            case 2:  myArray = ArrayUtils.deleteSingleValue(myArray, kb);
                     break;

            case 3:  ArrayUtils.printArray(myArray);
                     break;

            case 4:  mean = IntStatisticsUtils.computeMean(myArray);
                     IntStatisticsUtils.printResults("Mean", mean);
                     break;

            case 5:  median = IntStatisticsUtils.computeMedian(myArray);
                     IntStatisticsUtils.printResults("median", median);
                     break;

            case 6:  midpoint = IntStatisticsUtils.computeMidpoint(myArray);
                     IntStatisticsUtils.printResults("Midpoint", midpoint);
                     break;

            case 7:  stdDev = IntStatisticsUtils.computeStdDev(myArray);
                     IntStatisticsUtils.printResults("Standard Deviation", stdDev);
                     break;
            
            case 8:  mode = IntStatisticsUtils.computeMode(myArray);
                     IntStatisticsUtils.printResults("Mode", mode);
                     break;

            case 9: System.out.println("All Done");

         }// end switch

      }while(choice != 9);

      System.out.println("Good Bye");

   }// end main

}// end class