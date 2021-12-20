package lab4.cscd211lab4;

import java.util.*;
import lab4.cscd211methods.*;

/**
 * The methods class for the CSCD211Lab4 that contains main<br>
 * The purpose of this main is to get practice working with an ArrayList.
 * An ArrayList can hold any kind of Object type (not primitives). In our case
 * the ArrayList will be of type Double.  Notice how the ArrayList type is specified at
 * declaration and in the method headers of CSCD211Lab4Methods.
 */
public class CSCD211Lab4
{
	/**
	 * The simple main for testing.  NOTE: there is no throws Exception on main because
	 * we don't need it we are not working with any File objects for this lab.
	 * @param args Representing the command line arguments
	 */
   public static void main(String [] args)
   {
      int num, choice;
      Scanner kb = new Scanner(System.in);
      ArrayList<Double> myArrayList = null;
      double mean, median, midpoint, stdDev;
      
      num = CSCD211Lab4Methods.readNum(kb);
      myArrayList = new ArrayList<Double>(num);
      CSCD211Lab4Methods.fillArrayList(num, myArrayList);
                  
      do
      {
         choice = CSCD211Lab4Methods.menu(kb);
         
         switch(choice)
         {
            case 1:  CSCD211Lab4Methods.addNum(myArrayList, kb);
                     break;
                     
            case 2:  CSCD211Lab4Methods.deleteValue(myArrayList, kb);
                     break;
                     
            case 3:  CSCD211Lab4Methods.deleteValueByIndex(myArrayList, kb);
                     break;
                     
            case 4:  CSCD211Lab4Methods.printArrayList(myArrayList);
                     break;
                     
            case 5:  mean = CSCD211Lab4Methods.computeMean(myArrayList);
                     CSCD211Lab4Methods.printResults("Mean", mean);
                     break;
                       
            case 6:  median = CSCD211Lab4Methods.computeMedian(myArrayList);
                     CSCD211Lab4Methods.printResults("Median", median);
                     break;

            case 7:  midpoint = CSCD211Lab4Methods.computeMidpoint(myArrayList);
                     CSCD211Lab4Methods.printResults("Midpoint", midpoint);
                     break;
                     
            case 8:  stdDev = CSCD211Lab4Methods.computeStandardDeviation(myArrayList);
            		 CSCD211Lab4Methods.printResults("Standard Deviation", stdDev);
            break;
                              
         }// end switch
      
      }while(choice != 9);
   
   }// end main   
   
   /**
   * You WILL NOT WRITE this constructor it is provided by Java. <br>
   * DO NOT WRITE!
   */
  public CSCD211Lab4()
  {
      /* empty constructor */
  }
 

}// end class