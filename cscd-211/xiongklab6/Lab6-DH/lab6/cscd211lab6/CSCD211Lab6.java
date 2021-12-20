package lab6.cscd211lab6;

import java.util.Scanner;

import lab6.cscd211linkedlist.*;
import lab6.cscd211methods.CSCD211Lab6LinkedListMethods;

/**
 * The class that contains main and is      if(this.head.next == null)
      {
         throw new NoSuchElementException("Empty list");
      } used for testing our LinkedList code
 * You are not allowed to modify this Java file in any fashion
 * All preconditions will be checked and all parameters will be passed as final
 */
public class CSCD211Lab6
{
    /**
     * The main method. The information about this method is describe above.
     * 
     * @param args
     * Any command line parameters that are passed in. If there are
     * any they will be ignored by the program
     */
   public static void main(String [] args)
   {
      boolean res =  false;
      String str = null, item = null;
      int choice = 0, result = 0, index = 0;
      
      Scanner kb = new Scanner(System.in);
      
      LinkedList <String> myList = new LinkedList<String>(); // Dummy Head
      
      do
      {
         choice = CSCD211Lab6LinkedListMethods.menu(kb);
         
         switch(choice)
         {
            case 1:  System.out.println(myList);
                     break;
                     
            case 2:  str = CSCD211Lab6LinkedListMethods.buildAString(kb);
                     myList.addFirst(str);
                     break;
            
            case 3:  str = CSCD211Lab6LinkedListMethods.buildAString(kb);
                     myList.addLast(str);
                     break;
            
            case 4:  str = CSCD211Lab6LinkedListMethods.buildAString(kb);
                     index = CSCD211Lab6LinkedListMethods.readIndex(kb);
                     myList.add(index, str);
                     break;

            case 5:  str = CSCD211Lab6LinkedListMethods.buildAString(kb);
                     res = myList.contains(str);
                     System.out.println("The results of contains " + res);
                     break;

            case 6:  str = CSCD211Lab6LinkedListMethods.buildAString(kb);
                     result = myList.indexOf(str);
                     System.out.println("The results of indexOf " + result);
                     break;

            case 7:  item = myList.removeFirst();
                     System.out.println("The results from remove " + item);
                     break;

            case 8:  item = myList.removeLast();
                     System.out.println("The results from remove " + item);
                     break;

            case 9:  index = CSCD211Lab6LinkedListMethods.readIndex(kb);
                     item = myList.remove(index);
                     System.out.println("The results from remove " + item);
                     break;

            case 10: str = CSCD211Lab6LinkedListMethods.buildAString(kb);
                     res = myList.removeFirstOccurrence(str);
                     System.out.println("The results of contains " + res);
                     break;
                     
            case 11: str = CSCD211Lab6LinkedListMethods.buildAString(kb);
                     res = myList.removeLastOccurrence(str);
                     System.out.println("The results of contains " + res);
                     break;
                     
            case 12: myList.clear();
                     break;
                     
            case 13: System.out.println("List size: " + myList.size());
                     break;            

            case 14: System.out.println("Program ending");
            		 break;
            		 
            default: throw new IllegalArgumentException("Main Range outside 1 - 14");
         
         }// end switch
      
      }while(choice != 14);
      
      kb.close();
   
   }// end main

}// end class