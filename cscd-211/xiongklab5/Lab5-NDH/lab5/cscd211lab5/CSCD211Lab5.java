package lab5.cscd211lab5;

import java.util.Scanner;
import lab5.cscd211linkedlist.LinkedList;
import lab5.cscd211methods.LinkedListMethods;

/**
 * The class that contains main and is used for testing our LinkedList code
 * NOTE: All parameters will be final and all preconditions will be enforced
 */
public class CSCD211Lab5
{
	/**
	 * The main method to test your code
	 * @param args Command line parameters 
	 */
   public static void main(String [] args)
   {
      Integer value = null, item = null;
      boolean res =  false;
      Integer [] array = new Integer[5];
      int choice = 0, index = 0;
      Scanner kb = new Scanner(System.in);
      
      LinkedListMethods.fillArray(kb, array);  
      
      LinkedList <Integer>myList = new LinkedList<Integer>(array); // no dummy head node

      do
      {
         choice = LinkedListMethods.menu(kb);
         
         switch(choice)
         {
            case 1:  System.out.println(myList);
                     break;
                     
            case 2:  value = LinkedListMethods.createInteger(kb);
                     myList.add(value);
                     break;
            
            case 3:  array = LinkedListMethods.fillArray(kb, 3);
                     index = LinkedListMethods.readIndex(kb);
                     myList.addAll(index, array);
                     break;
            
            case 4:  index = LinkedListMethods.readIndex(kb);
                     item = myList.get(index);
                     System.out.println("The results of get " + item);
                     break;

            case 5:  item = myList.getLast();
                     System.out.println("The results of getLast " + item);
                     break;

            case 6:  item = myList.remove();
                     System.out.println("The results of remove " + item);
                     break;

            case 7:  index = LinkedListMethods.readIndex(kb);
                     item = myList.remove(index);
                     System.out.println("The results of remove " + item);
                     break;

            case 8:  item = myList.removeLast();
                     System.out.println("The results of removeLast " + item);
                     break;

            case 9:  Object [] temp = myList.toArray();
                     for(Object o: temp)
                        System.out.print(o + " ");
                     System.out.println();
                     break;
                     
            case 10: value = LinkedListMethods.createInteger(kb);
                     res = myList.removeAllOccurrences(value);
                     System.out.println("The results of removeAllOccurrences " + res);
                     break;

            case 11: myList.clear();
                     break;
                     
            default: System.out.println("Program ending");
         
         }// end switch
      
      }while(choice != 12);
      
      kb.close();
   
   }// end main

}// end class