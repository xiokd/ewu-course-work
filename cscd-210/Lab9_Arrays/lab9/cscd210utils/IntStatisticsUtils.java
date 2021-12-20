package lab9.cscd210utils;

import java.util.Scanner;
import lab9.cscd210sort.SortUtils;

public class IntStatisticsUtils
{
      public static double computeMean(final int[] myArray)
      {
            if(myArray == null || myArray.length <= 0)
            {
                  throw new IllegalArgumentException("Bad param computeMean");
            } // Exception
                  
            int sum = 0;
            
            for(int i = 0; i < myArray.length ; i++)
            {
                  sum = sum + myArray[i];
            }
            
            double ave = sum / myArray.length;
            
            return ave;
      }
      
      public static double computeMedian(final int[] myArray)
      {
            if(myArray == null || myArray.length <= 0)
            {
                  throw new IllegalArgumentException("Bad param computeMedian");
            } // Exception
                  
            int middle = myArray.length / 2;
            double median = 0;
            
            SortUtils.selectionSort(myArray);
            
            if(myArray.length % 2 != 0)
            {
                  median = myArray[middle];
            }
            else
            {
                  median = (myArray[middle - 1] + myArray[middle]) / 2;
            }
            
            
            return median;
      }
      
      public static double computeMidpoint(final int[] myArray)
      {
            if(myArray == null || myArray.length <= 0)
            {
                  throw new IllegalArgumentException("Bad param computeMidpoint");
            } // Exception
                  
            int start, end, valueStart, valueEnd ;
            
            SortUtils.selectionSort(myArray);
            
            start = 0;
            end = myArray.length - 1;
            valueStart = myArray[start];
            valueEnd = myArray[end];
            
            double midpoint = (valueStart + valueEnd) /2;
           
            return midpoint;
      }
      
      public static double computeMode(final int[] myArray)
      {
            
            // Unsure how to calulate the mode
            
            return 0;
      }
      
      public static double computeStdDev(final int[] myArray)
      {
            if(myArray == null || myArray.length <= 0)
            {
                  throw new IllegalArgumentException("Bad param computeStdDev");
            } // Exception
                  
            double mean = IntStatisticsUtils.computeMean(myArray); // Mean of the array
            
            double sum, result, sd;
            
            double[] deviation = new double[myArray.length];
            double[] squared = new double[deviation.length];
            
            for(int i = 0; i < deviation.length; i++) // Array of deviations
            {
                  deviation[i] = myArray[i] - mean;
            }
            
            for(int i = 0; i < squared.length; i++) // Squaring each element in the array
            {
                  squared[i] = deviation[i] * deviation [i];
            }
            
            sum = 0;
            for(int i = 0; i < squared.length; i++) // Sum of the squared deviations
            {
                  sum = sum + squared[i];
            }
            
            result = sum / (myArray.length - 1); // Dividing by .length - 1
            
            sd = Math.sqrt(result);
            
            return sd;
      }
      
      public static void printResults(final String type, double result)
      {
            if(type == null || type.isEmpty())
            {
                  throw new IllegalArgumentException("Bad param computeMidpoint");
            } // Exception
                  
            System.out.printf("The results for the %s are: %f \n", type, result); 
      }
      
}