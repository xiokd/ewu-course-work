package lab11.cscd210lab11;

import lab11.cscd210classes.Clock;

public class CSCD210Lab11
{

	public static void main(String [] args)
	{
		Clock one = new Clock();
      Clock two = new Clock(23, 59, 0);
      Clock three = new Clock(12, 45, 15);
      
      System.out.println("Clock 3 " + three);
      System.out.println("Clock 3 Hour " + three.getHour());
      System.out.println("Clock 3 Minutes:Seconds " + three.getMinutes() + ":" + three.getSeconds());
      
      System.out.println();
      System.out.println("Clock 1 " + one);
      
      one.setHour(3);
      System.out.println("Clock 1 after setting hours by 3 hours " + one);
      
      one.setHour(25);
      System.out.println("Clock 1 after setting hours by 25 hours " + one);
      
      System.out.println();
      System.out.println("Clock 2 " + two);
      
      two.setMinutes(20);
      System.out.println("Clock 2 after setting minutes by 20 minutes " + two);
      
      two.setMinutes(170);
      System.out.println("Clock 2 after setting minutes by 170 minutes " + two);
          
   }// end main

}// end class



