package lab2.cscd211methods;

import java.io.*;
import java.util.*;
import lab2.cscd211classes.Person;
import lab2.cscd211enums.Color;

public class CSCD211Lab2Methods
{
   public static Color convertColor(final String color)
   {
      if(color == null)
      {
         throw new IllegalArgumentException("Bad params convertColor");
      } 
      
      String temp = color.toUpperCase().trim();
      Color userColor = Color.valueOf(temp);
      
      for(Color c : Color.values())
      {
         if(userColor.equals(c))
         {
            return userColor;
         }
      }
      
      throw new RuntimeException("The color does not exist");
      
   }      
   
   public static void displayAll(final Color toFind, Person[] myPeeps)
   {
      if(myPeeps == null)
      {
         throw new IllegalArgumentException("Bad params displayAll");
      }
      
      for(int i = 0; i < myPeeps.length; i++)
      {
         if(myPeeps[i].getColor() == toFind)
         {
            System.out.println(myPeeps[i]);
            System.out.println();
         }
      }    
   }
   
   public static Person[] fillArray(final Scanner fin, final int total)
   {
      if(fin == null || total <= 0)
      {
         throw new IllegalArgumentException("Bad params fillArray");
      }
      
      int counter;
     
      Person [] array = new Person[total];
      
      for(int i = 0; i < array.length; i++)
      {
      
         String temp = fin.nextLine();
         temp = temp + "," + fin.nextLine();
         temp = temp + "," + fin.nextLine();

         String [] res = temp.split(",");
         res [0] = res[0].trim();
         res [1] = res[1].trim();
         Color userColor = CSCD211Lab2Methods.convertColor(res[2].trim());
        
         array[i] = new Person(res[0], res[1], userColor);    
      }
      
      return array;   
   }
   
   public static int menu(final Scanner kb)
   {
      if(kb == null)
      {
         throw new IllegalArgumentException("Bad scanner menu");
      }
      
      int choice;
      do
      {
         System.out.println("Please choose from the following");
         System.out.println("1) Print the Array to the screen");
         System.out.println("2) Display all people that contain a certain color");
         System.out.println("3) Sort the array by Color");
         System.out.println("4) Sort the array by the natural order");
         System.out.println("5) Quit");
         System.out.print("Choice --> ");
         choice = Integer.parseInt(kb.nextLine());
         System.out.println();
      }while(choice < 1 || choice > 5);

      return choice;
      
   }
   
   public static void printArray(Person[] myPeeps)
   {
      if(myPeeps == null)
      { 
         throw new IllegalArgumentException("Bad params printArray");
      }
      
      for(int i = 0; i < myPeeps.length; i++)
      {
         System.out.println(myPeeps[i]);
         System.out.println();
      }      
   
   }
   
   public static Color readColor(final Scanner kb)
   {
      if(kb == null)
      {
         throw new IllegalArgumentException("bad scanner menu");
      }
      
      System.out.print("Please enter a color: ");
      String tempColor = kb.nextLine();
      Color userColor = CSCD211Lab2Methods.convertColor(tempColor);
      
      return userColor;
   
   }
   
}