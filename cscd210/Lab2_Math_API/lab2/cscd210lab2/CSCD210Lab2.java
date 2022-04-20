package lab2.cscd210lab2;

import java.util.Scanner;
import java.text.DecimalFormat;

public class CSCD210Lab2
{
   public static void main(String [] args)
   {
      double winningTime;
      Scanner kb = new Scanner(System.in);
      
      System.out.print("Please enter the winning time of the race: ");
      winningTime = kb.nextDouble();
      
      System.out.println("The person was traveling at a rate of:");
      
      /* Your code goes below */
      
      DecimalFormat df = new DecimalFormat("0.00");
      
      double mps = 100/winningTime;
      
      double fps = mps*3.28084;
      
      double kph = mps*3.6;
      
      double mph = mps*2.236936;
      
      double minSpeed = (1/mph)*60;
      
      System.out.println(df.format (mps) + " meters per second,");
      
      System.out.println(df.format (fps) + " feet per second,");
      
      System.out.println(df.format (kph) + " kilometers per hour,");
      
      System.out.println(df.format (mph) + " miles per hour,");
      
      System.out.println("It would take " + df.format (minSpeed) + " minutes for the person to run one mile.");
   
   
   }// end main


}// end class