package lab1.cscd210lab1;

import java.util.Scanner;

public class CSCD210Lab1
{
	public static void main(String [] args)
	{
		int credits; 
      String name; Scanner kb = new Scanner(System.in); 
      
      System.out.print("Please enter your name "); 
      name = kb.nextLine(); 
      
      System.out.print("Please enter the number of credits you are taking "); 
      credits = kb.nextInt(); 
      
      System.out.println("Welcome " + name); 
      System.out.printf("Good luck taking %d %s\n", credits, (credits != 1 && credits != -1) ? "credits" : "credit");
      
	}// end main

}// end class