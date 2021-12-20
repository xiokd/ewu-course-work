package lab7.cscd210lab7;

import java.util.Scanner;
import lab7.cscd210methods.CSCD210Lab7Methods;

public class CSCD210Lab7
{
   /**
    * Don't write this construtctor it is given for free
    */
   public CSCD210Lab7()
   {}
   
   /**
    * The main method.  You can't change the code in this method
    * or this class in any fashion
    *
    * @param args Representing any command line arguments passed into main
    */
   public static void main(String [] args)
   {
      int theNum, choice;
      Scanner kb = new Scanner(System.in);
      
      theNum = CSCD210Lab7Methods.readPosNum(kb);
      
      do
      {
         choice = CSCD210Lab7Methods.menu(kb);
         
         switch(choice)
         {
            case 1:  theNum = CSCD210Lab7Methods.readPosNum(kb);
                     break;
                    
            case 2:  CSCD210Lab7Methods.oddEvenZero(theNum);
                     break;  
            
            case 3:  CSCD210Lab7Methods.lightOrHeavy(theNum, kb);
                     break;
                     
            case 4:  CSCD210Lab7Methods.printE(theNum);
                     break;
                     
            case 5:  CSCD210Lab7Methods.printReverse(theNum);
                     break;
                     
            default: System.out.println("Good Bye");         
         
         }// end switch
            
      }while(choice != 6);
  
   }// end main

}// end class