package lab4.cscd211methods;

import java.util.*;
import java.util.Collections;
import java.lang.Math;

/**
 * The methods class for the Lab 4 methods that you must write<br>
 * This methods class contains methods for working with ArrayLists.
 * @NOTE you will need to use Double.valueOf at key places you will lose massive points
 * if the compiler displays<br>
 * Note: lab4/cscd211methods/CSCD211Lab4Methods.java uses or overrides a deprecated API.<br>
 * Note: Recompile with -Xlint:deprecation for details.
 */
public class CSCD211Lab4Methods
{
   /**
    * The addNum method prompts the user to enter a number that
    * is between 0 and 100 inclusive.  The method ensures the number is between 0 and
    * 100 inclusive.  Once a proper number is received that number is added to the ArrayList
    *
    * @param myAList Representing the array list
    * @param kb - Representing the Scanner Object
    * @post. The ArrayList will be modified in place and trimmed to size
    *
    * @throws IllegalArgumentException if the Scanner object or the array list is null
    */
   public static void addNum(final ArrayList<Double> myAList, final Scanner kb) {
      if(kb == null || myAList == null) {
         throw new IllegalArgumentException("Bad params addNum");
      }
      double userNum;

      do {
         System.out.print("Please enter a number between 0 and 100: ");
         userNum = Double.parseDouble(kb.nextLine());
      }while(userNum < 0.0 || userNum > 100.0);

      myAList.add(userNum);
  	  myAList.trimToSize();
   }// end addNum

   /**
    * The computeMean calculates the mean value of the array list.
    * The mean is average of the values in the array. Total the array list of numbers.
    * Divide by the size. You cannot produce a mean from an empty array list
    *
    * @param myAList Representing the array list
    * @return double - Representing the mean
    *
    * @throws IllegalArgumentException if the array list is null
    * @throws IllegalArgumentException if the array list size is 0
    */
   public static double computeMean(final ArrayList<Double> myAList) {
      if(myAList == null || myAList.size() == 0) {
         throw new IllegalArgumentException("Bad params computeMean");
      }

      Collections.sort(myAList);

      double value = 0.0;
      for(int i = 0; i < myAList.size(); i++) {
         value = value + myAList.get(i);
      }

      double mean = value / myAList.size();

      return mean;
   }

   /**
    * The computeMean calculates the median value of the ArrayList.
    * The median is the �middle value� of a sorted ArrayList,
    * you must first sort your array list from lowest value to highest.
    * The calculation for a median is different for an ArrayList of even length
    * versus an array list of an odd size.

    * <br> An array list with an odd size.
    * <br>Find the index of the middle element
    * <br>Compute middle index with size divided by 2.
    * <br> The median would be the value at this array list index.<br>
    * <br>An ArrayList with an even size.
    * <br>There will be two middle values.
    * <br>Compute index #1 with array list length divided by 2.
    * <br>Compute index #2 with index #1 - 1.
    * <br>Get the values stored at index #1 and index #2.
    * <br>The median is the two values added together and divided by 2.
    * (recall we are doing int arithmetic) Divide by the size.
    * @pre. You cannot produce a median from an empty array list
    *
    * @param myAList Representing the array list
    * @return double Representing the median
    *
    * @throws IllegalArgumentException if the array list is null
    * @throws IllegalArgumentException if the array list size is 0
    */
   public static double computeMedian(final ArrayList<Double> myAList) {
      if(myAList == null || myAList.size() == 0) {
         throw new IllegalArgumentException("Bad params computeMedian");
      }

      Collections.sort(myAList);

      int middle = myAList.size() / 2;
      double median = 0.0;

      if(myAList.size() % 2 != 0) {
         median = myAList.get(middle);
      }
      else {
         median = (myAList.get(middle - 1) + myAList.get(middle)) / 2;
      }

      return median;
   }// end computeMedian

   /**
    * The computeMidpoint calculates the midpoint value of the ArrayList.
    * The midpoint is the mean of the smallest and largest values in your array list.
    * <br>Sort your array list in ascending order.
    * <br>Retrieve the values from the beginning and end of the array list.
    * <br>The midpoint is those two values added together and divided by 2.
    * @pre. You cannot produce a midpoint from an empty array list
    *
    * @param myAList Representing the array list
    * @return double Representing the midpoint
    *
    * @throws IllegalArgumentException if the array list is null
    * @throws IllegalArgumentException if the array list size is 0
    */
   public static double computeMidpoint(final ArrayList<Double> myAList) {
      if(myAList == null || myAList.size() == 0) {
         throw new IllegalArgumentException("Bad params computeMidpoint");
      }

      Collections.sort(myAList);

      int start = 0;
      int end = myAList.size() - 1;
      double valueStart = myAList.get(start);
      double valueEnd = myAList.get(end);

      double midpoint = (valueStart + valueEnd) / 2;

      return midpoint;
   }// end computeMidPoint

   /**
    * The computeStandardDeviation calculates the amount of variation form the average
    * <br>Compute the mean of the ArrayList
    * <br>Create a new ArrayList of deviations by subtracting the mean from each member from the original ArrayList.
    * <br>Square each member of the deviations ArrayList.
    * <br>Total those squared deviations.
    * <br>Divide by one less than the original ArrayList size. The standard deviation is the square root of this number.
     * @pre. You cannot produce a midpoint from an empty array list
    *
    * @param myAList Representing the array list
    * @return double - Representing the midpoint
    *
    * @throws IllegalArgumentException if the array list is null
    * @throws IllegalArgumentException if the array list size is 0
    */
   public static double computeStandardDeviation(final ArrayList<Double> myAList) {
      if(myAList == null || myAList.size() == 0) {
         throw new IllegalArgumentException("Bad params computeStandardDeviation");
      }

      double mean, sum, result, stDev;

      mean = CSCD211Lab4Methods.computeMean(myAList);

      ArrayList<Double> devAList = new ArrayList<Double>(myAList.size());
      ArrayList<Double> sqrAList = new ArrayList<Double>(myAList.size());

      double meanTemp = 0.0;
      for(int i = 0; i < myAList.size(); i++) {
         meanTemp = myAList.get(i) - mean;
         devAList.add(meanTemp);
      }

      double sqrTemp = 0.0;
      for(int j = 0; j < myAList.size(); j++) {
         sqrTemp = (devAList.get(j) * devAList.get(j));
         sqrAList.add(sqrTemp);
      }

      sum = 0.0;
      for(int k = 0; k < myAList.size(); k++) {
         sum = sum + sqrAList.get(k);
      }

      result = sum / (myAList.size() - 1);
      stDev = Math.sqrt(result);

	   return stDev;
   }

   /**
    * The deleteValue prompts the user for a value that may be in the array list
    * and removes the item from the array list.
    * The entered value must be between 0 and 100 inclusive
    * The removed item is printed to the screen or the value does not exist
    *
    * @param myAList Representing the array list
    * @param kb Representing the Scanner object
    * @post. The ArrayList will be modified in place and trimmed to size if the precondition was met
    * @pre. The ArrayList must contain at least 1 item for the list to be modified - If the ArrayList does not
    * contain 1 item the ArrayList is not modified<br>
    * NOTE: You must use an if statement to enforce the precondition properly<br>
    * <br>if(myAList.size() = 0)<br>
    * return<br><br>
    * will earn 0 points for this method!
    *
    * @throws IllegalArgumentException if the array list or the Scanner is null
    * @throws IllegalArgumentException if the size of the array list is less than 1
    */
   public static void deleteValue(final ArrayList<Double> myAList,final Scanner kb) {
      if(kb == null || myAList.isEmpty()) {
         throw new IllegalArgumentException("Bad params deleteValue");
      }
      double userNum;
      int index = -1;

      do {
         System.out.print("Please enter the value you want to remove from the array list: ");
         userNum = Double.parseDouble(kb.nextLine());
      }while(userNum < 0 || userNum > 100);

      for(int i = 0; i < myAList.size(); i++) {
         myAList.get(i);

         if(myAList.get(i) == userNum) {
            index = i;
         }
      }

      if(index == -1) {
         System.out.println("Value does not exist");
      }
      else {
         myAList.remove(index);
         myAList.trimToSize();
      }
   }// end deleteValue


   /**
    * The deleteValueByIndex prompts the user for an index value
    * and removes the item at that index from the array list.
    * The entered index must be between 0 and the list size - 1
    *
    * @param myAList Representing the array list
    * @param kb Representing the Scanner object
    * @post. The ArrayList will be modified in place and trimmed to size if the precondition was met
    * @pre. The ArrayList must contain at least 1 item for the list to be modified - If the ArrayList does not
    * contain 1 item the ArrayList is not modified<br>
    * NOTE: You must use an if statement to enforce the precondition properly<br>
    * <br>if(myAList.size() = 0)<br>
    * return<br><br>
    * will earn 0 points for this method!
    *
    * @throws IllegalArgumentException if the array list or the Scanner is null
    * @throws IllegalArgumentException if the size of the array list is less than 1
    */
   public static void deleteValueByIndex(final ArrayList<Double> myAList,final Scanner kb) {
      if(kb == null || myAList.isEmpty()) {
         throw new IllegalArgumentException("Bad params deleteValueByIndex");
      }
      int userNum;
      int indexSet = myAList.size() - 1;

      do {
         System.out.print("Please enter the index you want to remove: ");
         userNum = Integer.parseInt(kb.nextLine());
      }while(userNum < 0 || userNum > indexSet);

      for(int i = 0; i < myAList.size(); i++) {
         if(i == userNum) {
            myAList.remove(userNum);
            myAList.trimToSize();
         }
      }
   }// end deleteValueByIndex

   /**
    * The fillArrayList method fills the ArrayList with random Double values between
    * 0 and 100 inclusive.  You can either use Math.random or the Random class.
    *
    * @param size Representing the number of elements to fill the array list with
    * @param myAList Representing the array list
    * @post. The ArrayList will be modified in place and trimmed to size
    *
    * @throws IllegalArgumentException if the array list is null
    * @throws IllegalArgumentException if the size of the array list is less than 1
    */
   public static void fillArrayList(final int size, final ArrayList<Double> myAList)
   {
      int num = myAList.size();
      if(myAList == null || myAList.size() < 0)
      {
         throw new IllegalArgumentException("Bad params fillArrayList");
      }

      double randomDouble;
      for(int i = 0; i < size; i++)
      {
         randomDouble = Math.random() * 100;

         myAList.add(randomDouble);
      }

   }// end fillArrayList

   /**
    * The menu method guarantees that a menu choice between 1 and 9 inclusive is entered.
    * <br>The menu choices are:<br>
    * <br>1) Add a value to the ArrayList
    * <br>2) Delete a value from the ArrayList (by value)
    * <br>3) Delete a value from the ArrayList (by index/location)
    * <br>4) Display the ArrayList
    * <br>5) Compute the mean of the ArrayList
    * <br>6) Compute the median of the ArrayList
    * <br>7) Compute the midpoint of the ArrayList
    * <br>8) Compute the standard deviation of the ArrayList
    * <br>9) Quit
    * <br>
    *
    * @param kb Representing the Scanner object to the keyboard
    * @return int - Representing the menu choice guaranteed by you the programmer to be between 1 and 9 inclusive
    * @throws IllegalArgumentException if the Scanner fin is null
    * @post. You must ensure the input buffer is empty at the end of the method.
    */
   public static int menu(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("Error: Invalid Scanner");

      int num = 0;

      do
      {
         System.out.println("Enter a menu choice:");
         System.out.println("1) Add a value to the ArrayList");
         System.out.println("2) Delete a value from the ArrayList (by value)");
         System.out.println("3) Delete a value from the ArrayList (by index/location)");
         System.out.println("4) Display the ArrayList");
         System.out.println("5) Compute the mean of the ArrayList");
         System.out.println("6) Compute the median of the ArrayList");
         System.out.println("7) Compute the midpoint of the ArrayList");
         System.out.println("8) Compute the standard deviation of the ArrayList");
         System.out.println("9) Quit");
         System.out.print("Choice --> ");
         num = Integer.parseInt(kb.nextLine());
      }while(num < 1 || num > 9);

      return num;

   }// end method

   /**
    * The printArrayList prints the contents of the list out in the following
    * format [#, #, #] (This is the standard format when printing an ArrayList object)
    * or empty list if the list size is 0
    *
    * @param myAList Representing the array list
    *
    * @throws IllegalArgumentException if the array list or the Scanner is null
    */
   public static void printArrayList(final ArrayList<Double> myAList)
   {
      if(myAList == null)
         throw new IllegalArgumentException("Error: Array List is null");

      if(myAList.size() == 0)
            System.out.println("Empty List");

      else
         System.out.println(myAList);

     System.out.println();
   }// end printArrayList

   /**
    * The printResults prints the message and the results of the calculation.
    *
    * @param type Representing the String to be printed
    * @param value Representing the value to be printed
    *
    * @throws IllegalArgumentException if the String is null
    * @throws IllegalArgumentException if the String is empty
    */
   public static void printResults(final String type, final double value)
   {
      if(type == null || type.isEmpty())
      {
         throw new IllegalArgumentException("Bad params printResults");
      }

      System.out.println("The " + type + " of the array list is " + value);
   }// end printResults


   /**
    * The readNum method prompts and ensures the user will enter a positive number that
    * is at least 1
    *
    * @param kb Representing the Scanner Object
    * @return int - Representing the entered numbered that will be greater than 0
    *
    * @throws IllegalArgumentException if the Scanner object is null
    */
   public static int readNum(final Scanner kb)
   {
      if(kb == null)
      {
         throw new IllegalArgumentException("Bad params readNum");
      }

      int num;

      do
      {
         System.out.print("Please enter a positive number that is greater than 0: ");
         num = Integer.parseInt(kb.nextLine());
      }while(num <= 0);

      return num;
   }// end readNum

   /**
    * You WILL NOT WRITE this constructor it is provided by Java. <br>
    * DO NOT WRITE!
    */
   public CSCD211Lab4Methods()
   {
       /* empty constructor */
   }

}// end of class
