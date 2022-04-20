package lab6.cscd211methods;

import java.util.Scanner;

/**
 * Some basic methods we will need to use in conjunction with the LinkedList class
 * @NOTE All parameters will be final and all preconditions met
 */
public class CSCD211Lab6LinkedListMethods
{
   /**
    * menu method for testing your linked list
    * <br>  1) Print the List
    * <br>  2) Create a BoxCar and addFirst
    * <br>  3) Create a BoxCar and addLast
    * <br>  4) Create a BoxCar, read and index and add -- at the index
    * <br>  5) Create a BoxCar, check the list to see if the list contains the BoxCar
    * <br>  6) Create a BoxCar, find the indexOf that BoxCar
    * <br>  7) removeFirst
    * <br>  8) removeLast
    * <br>  9) Read index remove Node at that index
    * <br> 10) Create a BoxCar and removeFirstOccurrence of that BoxCar
    * <br> 11) Create a BoxCar and removeLastOccurrence of that BoxCar
    * <br> 12) clear the list
    * <br> 13) Print the size of the list
    * <br> 14) Quit
    * <br> You must ensure the value entered in within range
    *
    * @param kb Representing the Scanner Object
    * @return int  - The choice guaranteed by you to be between 1 and 14 inclusive
    *
    * @throws IllegalArgumentException if kb is null
    * @NOTE The input buffer will be left clean
    */
   public static int menu(final Scanner kb)
   {
      if(kb == null)
      {
         throw new IllegalArgumentException("Scanner is null");
      }
      
      int choice;
      do
      {
         System.out.println("Please choose from the following:");
         System.out.println("1) Print the list");
         System.out.println("2) Create a BoxCar and addFirst");
         System.out.println("3) Create a BoxCar and addLast");
         System.out.println("4) Create a BoxCar, read and index and add -- at the index");
         System.out.println("5) Create a BoxCar, check the list to see if the list contains the BoxCar");
         System.out.println("6) Create a BoxCar, find the indexOf that BoxCar");
         System.out.println("7) removeFirst");
         System.out.println("8) removeLast");
         System.out.println("9) Read index remove Node at that index");
         System.out.println("10) Create a BoxCar and removeFirstOccurrence of that BoxCar");
         System.out.println("11) Create a BoxCar and removeLastOccurrence of that BoxCar");
         System.out.println("12) clear the list");
         System.out.println("13) Print the size of the list");
         System.out.println("14) Quit");
         System.out.print("Choice: ");
         choice = Integer.parseInt(kb.nextLine());
      }while(choice < 0 || choice > 14);

	   return choice;      
   }
   
   /**
    * Prompts the user for a String and reads the String from the keyboard
    *
    * @param kb The Scanner object
    * @return String The String read from the keyboard
    *
    * @throws IllegalArgumentException if kb is null
    * @NOTE The input buffer will be left clean
    */
   public static String buildAString(final Scanner kb)
   {
      if(kb == null)
      {
         throw new IllegalArgumentException("Scanner is null");
      }
      
      System.out.print("Please enter a String: ");
      String str = kb.nextLine();
      String userString = new String(str);
      
      return userString;
   }
   
   
   /**
    * readIndex reads a value greater than -1
    *
    * @param kb The Scanner object
    * @return int - The index will be guaranteed by you to be greater than -1
    *
    * @throws IllegalArgumentException if kb is null
    * @NOTE The input buffer will be left clean
    */
   public static int readIndex(final Scanner kb)
   {
      if(kb == null)
      {
         throw new IllegalArgumentException("Scanner is null");
      }
      
      System.out.print("Please enter the Index value: ");
      int userIndex = Integer.parseInt(kb.nextLine());
      
      return userIndex;
   }
   
   

}