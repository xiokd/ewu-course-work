package lab13.cscd210utils;


/**
 * Basic SortUtil class that will be used throughout
 * the rest of the quarter for CSCD 210.<br>
 *
 * <br>@NOTE: All passed parameters are always final!
 * <br>@NOTE: I provided SortUtils for this lab.
 */
public class SortUtils<T extends Comparable<? super T>>
{
   /* ignore this it is here so it doesn't appear in the JavaDocs */
   public SortUtils(){}


   /**
    * The selectSort method sorts the array in ascending order. The 
    * array is of a type that has a compareTo method.  
    *
    * @param <T> This describes a generic type
    * @param array The array to be sorted
    *
    * @throws IllegalArgumentException if the array is null or if the array.length &lt;= 0
    */
   public static <T extends Comparable<? super T>> void selectionSort(T [] array)
   {
      if(array == null || array.length <= 0)
         throw new NullPointerException("selectionSort bad Params");
         
      int start, search, min;
      T temp;
      
      for(start = 0; start < array.length - 1; start ++)
      {
         min = start;
         
         for(search = start + 1; search < array.length; search ++)
         {
            if(array[search].compareTo(array[min]) < 0)
               min = search;
         
         }// end for search
         
         temp = array[min];
         array[min] = array[start];
         array[start] = temp;     
      
      }// end for start
   
   }// end SortUtil
   
   /**
    * The selectionSort method sorts the array of integers in ascending order
    * <br>
    * NOTE: This method is provided by me and should be copied from Lab 8
    * <br>
    *
    * @param myArray Representing an array of integers
    *
    * @throws IllegalArgumentException if myArray is null
    * @throws IllegalArgumentException if the length of myArray is less than or equal to zero
    */
   public static void selectionSort(final int [] myArray)
   {
      if(myArray == null || myArray.length < 1)
         throw new IllegalArgumentException("Bad params selectionSort");
         
      int search, start, min;
      int temp;
      
      for(start = 0; start < myArray.length - 1; start++)
      {
         min = start;
         
         for(search = start + 1; search < myArray.length; search++)
         {
            if(myArray[search] < min)
               min = search;
         }// end for search
         
         temp = myArray[start];
         myArray[start] = myArray[min];
         myArray[min] = temp;   
      
      }// end for start
   }// end method


}// end class