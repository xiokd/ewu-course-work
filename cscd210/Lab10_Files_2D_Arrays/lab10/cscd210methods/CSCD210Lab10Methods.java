package lab10.cscd210methods;

import java.util.Scanner;

/**
 * The methods for the Andromeda Problem.<br>
 * All parameters will be passed as final<br>
 * All preconditions and post conditions will be enforced
 */
public class CSCD210Lab10Methods
{
   /**
    * This method fills the solutions array with the values
    * from the file.
    * @param fin Representing a Scanner object to the open file
    * @return int [] Representing the filled array
    * @throws IllegalArgumentException if fin is null
    */
   public static int [] fillSolution(final Scanner fin)
   {
      if(fin == null)
      {
            throw new IllegalArgumentException("Bad param fillSolution");      
      } //Exception
      
      int [] array  = new int[16];
      
      for (int i = 0; i < array.length; i++)
      {
            array[i] = fin.nextInt();
      }

      return array;
   
   }// end fillSolution
   
   
   /** 
    * This method prints Solution and then the values from the solution array
    * @param array Representing the filled solutions array
    * @throws IllegalArgumentException if the array is null or the length less than 1
    */
   public static void print(int [] array)
   {
      if(array == null || array.length < 1)
      {
            throw new IllegalArgumentException("Bad param print");
      }
      
      System.out.println("Solution: ");
      for (int val : array)
      {
            System.out.print(val + " ");
      }
      
      System.out.println();
            
   }// end print
   
   
   /**
    * This method creates the generation array which is a 10 x 10 2D array
    * of integers. The array is then filled with the values
    * from the file.
    * @param fin Representing a Scanner object to the open file
    * @return int[] [] Representing the filled generation array
    * @throws IllegalArgumentException if fin is null
    */
   public static int [][] fillGeneration(Scanner fin)
   {
      if(fin == null)
      {
            throw new IllegalArgumentException("Bad param fillGeneration");      
      } //Exception      
   
      int [][] twoD = new int[10][10];
      for(int r = 0; r < twoD.length; r++)
      {
            for(int c = 0; c < twoD[r].length ; c++)
            {
                  twoD[r][c] = fin.nextInt();
            }
      }
                 
      return twoD;
   
   }// end fillGeneration
   
   
   /** 
    * This method prints Generation and the day and then the generation array
    * with the values converted to the proper characters
    * @param array Representing the filled generation array
    * @param day Representing which day the generation is on
    * @throws IllegalArgumentException if the array is null or the length less than 1
    * @throws IllegalArgumentException if day is less than 1
    */
   public static void print(int [][] array, int day)
   {
   /*   if(array == null || array.length < 1 || day < 1)
      {
            throw new IllegalArgumentException("Bad param print");
      } */
      
    /*  System.out.println("Generation:" 0 + day);
      
      for(int r = 0; r < array.length; r++)
      {
            for(int c = 0; c < array[r].length ; c++)
            {
                 if(array[r][c] == 0)
                 {
                     System.out.print(".");
                 }
                 else if(array[r][c] == 1)
                 {
                     System.out.print("!");
                 }
                 else if(array[r][c] == 2)
                 {
                     System.out.print("X");
                 }
                  else if(array[r][c] == 3)
                 {
                     System.out.print("#");
                 }                
                                                   
            }
            
            System.out.println();
      } */            
            
   }// end print
   
   
   /** 
    * This method prints Generation 0 and then the generation array
    * with the values converted to the proper characters
    * @param array Representing the filled generation array
    * @throws IllegalArgumentException if the array is null or the length less than 1
    */
   public static void print(int [][] array)
   {
      if(array == null || array.length < 1)
      {
            throw new IllegalArgumentException("Bad param print");
      }
      System.out.println("Generation: 0");
      for(int r = 0; r < array.length; r++)
      {
            for(int c = 0; c < array[r].length ; c++)
            {
                 if(array[r][c] == 0)
                 {
                     System.out.print(".");
                 }
                 else if(array[r][c] == 1)
                 {
                     System.out.print("!");
                 }
                 else if(array[r][c] == 2)
                 {
                     System.out.print("X");
                 }
                  else if(array[r][c] == 3)
                 {
                     System.out.print("#");
                 }                
                                                   
            }
            
            System.out.println();
      }         
      
      
   }// end print

   
   
   /**
    * This method is the hardest part of the assignment.  It is passed the 1D solution array
    * and the 2D generation array. The method makes a new temp 2D array that is 10 x 10. The idea
    * here is each element in the generation array is examined. The solution is applied against the 
    * generation array and the results are stored in the new temp array for that element. Once all 
    * elements in the generation array have been processed the temp array is returned.
    * @param array Representing the 2D generation array
    * @param solution Representing the 1D solution array
    * @return int [][] Representing a new 2D generation array
    * @throws IllegalArgumentException if either array is null or the length is less than 1
    */
   public static int [][] runSolution(int [][] array, int [] solution)
   {
      /*if(array == null || array.length < 1)
      {
            throw new IllegalArgumentException("Bad param runSolution");
      } */
      
     /* for(int r = 0; r < array.length; r++)
      {
            for(int c = 0; c < array[r].length ; c++)
            {
                  int left = r - 1;
                  int right = r + 1;
                  int above = c + 1;
                  int below = c - 1;
                  
                  int val = array[r][c] + array[left][c] + array[right][c] + array[r][above] + array[r][below];
                  int solVal = solution[val];
                  
                
                  
            } 
      } */      
      return null;
   
   }// end runSolution
   
   
   /**
    * The readNum methods reads the number of solutions and the number of days from the file
    * @NOTE there is no prompt only just reading from the file
    * @param fin Representing a valid Scanner object
    * @return int Representing the number read from the file
    * @throws IllegalArgumentException if fin is null
    */
   public static int readNum(final Scanner fin)
   {
      if(fin == null)
      {
            throw new IllegalArgumentException("Bad param readNum");      
      } //Exception
         
      int num = Integer.parseInt(fin.nextLine());
      
      return num;
   }
   

}// end class