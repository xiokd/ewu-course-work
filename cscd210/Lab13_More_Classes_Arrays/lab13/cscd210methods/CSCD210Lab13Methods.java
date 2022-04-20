package lab13.cscd210methods;

import java.util.Scanner;
import lab13.cscd210classes.Author;

/**
 * The methods for this lab
 * @NOTE all parameters will be passed as final and all preconditions will be met
 */
public class CSCD210Lab13Methods
{

   /** 
    * The basic menu method provided by me
    * @param kb Representing the Scanner object
    * @return int Representing the menu choice
    * @throws IllegalArgumentException if kb is null
    * @Post The input buffer is left clean
    */
   public static int menu(final Scanner kb)
   {
      if(kb == null)
         throw new IllegalArgumentException("Bad param menu");
   
      int choice;
      do
      {
         System.out.println("Please choose from the following");
         System.out.println("1) Print the Array to the Screen");
         System.out.println("2) Add an item into the Array");
         System.out.println("3) Delete an item from the Array");
         System.out.println("4) Quit");
         System.out.print("Choice --> ");
         choice = Integer.parseInt(kb.nextLine());
      
      }while(choice < 1 || choice > 4);
      
      return choice;
   }// end menu
   
   /** 
    * The fillArray method 1) creates an array of author references<br>
    * 2) reads the first and last name from the file and breaks that String
    *    apart into the first and last name.  <br>
    * NOTE: More than 2 Strings on the line means String 0 and 1 are the first name
    * and String 2plus are the last name<br>
    * 3) Reads the publisher from the file<br>
    * 4) Builds an author object of last, first, publisher<br>
    * 5) Puts that author object into the array<br>
    * 6) When done filling the array returns the array<br>
    * @param fin Representing the Scanner object
    * @param total Representing the total number of Authors
    * @return Author array Representing the filled array
    * @throws IllegalArgumentException if fin is null or total is less than or equal to 0
    */
   public static Author [] fillArray(final Scanner fin, final int total)
   {
      if(fin == null || total <= 0)
      {
         throw new IllegalArgumentException("Bad params fillArray");
      }
      
      Author[] array = new Author[total];
      
      for(int i = 0; i < array.length; i++)
      {
         String tempName = fin.nextLine();
         String tempPublisher = fin.nextLine();
         String [] res = tempName.split(" ");
         
         if(res.length == 2)
         {
            for(int j = 0; j < res.length; j++)
            {
               res[j] = res[j].trim();
            }
            String tempFirst = res[0];
            String tempLast = res[1];
            
            array[i] = new Author(tempLast, tempFirst, tempPublisher);
         } 

         if(res.length == 3)
         {
            for(int j = 0; j < res.length; j++)
            {
               res[j] = res[j].trim();
            }
            String tempFirst = res[0] + " " + res[1];
            String tempLast = res[2];
            
            array[i] = new Author(tempLast, tempFirst, tempPublisher);
         }
         
         if(res.length == 4)
         {
            for(int j = 0; j < res.length; j++)
            {
               res[j] = res[j].trim();
            }
            String tempFirst = res[0] + " " + res[1];
            String tempLast = res[2] + " " + res[3];
            
            array[i] = new Author(tempLast, tempFirst, tempPublisher);
         }
                             
      }
      
      return array;
   }// end fillArray   
   
   /** 
    * The readAuthor method prompts the user for the first and last name
    * and the publisher.  If any of the strings are null or empty the user is 
    * reprompted.  <br>
    * Once all information has been read in and validated as not null or empty
    * then an Author object is created and returned
    * @param kb Representing the Scanner object
    * @return Author Representing an Author object
    * @throws IllegalArgumentException if kb is null
    * @Post The input buffer is left clean
    */
   public static Author readAuthor(final Scanner kb)
   {
      if(kb == null)
      {
         throw new IllegalArgumentException("Bad params readAuthor");
      }
      
      System.out.print("Please enter the author's first name: ");
      String first = kb.nextLine();
      
      System.out.print("Please enter the author's last name: ");
      String last = kb.nextLine();
      
      System.out.print("Please enter the publisher: ");
      String publisher = kb.nextLine();
      
      Author temp = new Author(last, first, publisher);
            
      return temp;
        
   }// end readAuthor

   /** 
    * The add method is passed the array and an Author object<br>
    * 1) A new Author array is created of length of the old array + 1<br>
    * 2) The Authors from the old array are copied into the new array<br>
    * 3) The new Author is added in the last index of the new array<br>
    * 4) The new array is returned
    * @param array Representing the Author array
    * @param item Representing the Author to be added into the array
    * @return Author [] Representing new array
    * @throws IllegalArgumentException if array or item is null or the array length is less than 0
    */
   public static Author[] add(final Author [] array, final Author item)
   {
      if(array == null || item == null || array.length < 0)
      {
         throw new IllegalArgumentException("Bad params add");
      }
      Author[] copy = new Author[array.length + 1];
      
      for(int i = 0; i < array.length; i++)
      {
         copy[i] = array[i];
      }
      
      copy[copy.length - 1] = item;
      
      return copy;
   }// end add
   
   
   /** 
    * The remove method is passed the array and an index<br>
    * 1) If the index is -1 or the array length is 0 then the original array is returned<br>
    * 2) A new Author array is created of length of the old array - 1<br>
    * 2) The Authors from the old array are copied into the new array except for the index that is being removed<br>
    * 4) The new array is returned
    * @param array Representing the Author array
    * @param index Representing the index to remove
    * @return Author [] Representing new array
    * @throws IllegalArgumentException if array or the array length is less than 0 or index is greater than or equal to the array length or index is less than -1
    */
   public static Author[] remove(final Author[] array, final int index)
   {
      if(array.length < 0 || index >= array.length || index < -1)
      {
         throw new IllegalArgumentException("Bad params remove");
      }
      
      /* The API mentions to also throw an IllegalArgumentException for if array is less than zero, unsure how to implement it into method*/
      
      if(index == -1 || array.length == 0)
      {
         return array;
      }
      
      Author[] copy = new Author[array.length - 1];
      
      int i, j;
      for(i = 0; i < index; i++)
      {
         copy[i] = array[i];
      }
      
      for(j = index + 1; j < array.length; j++)
      {
         copy[i] = array[j];
         i++;
      }

      return copy;
      
   }// end remove
   
}// end class
