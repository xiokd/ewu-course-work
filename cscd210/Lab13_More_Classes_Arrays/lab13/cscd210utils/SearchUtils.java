package lab13.cscd210utils;


/**
 * A basic SearchUtils class that will work on any generic
 * All parameters will passed as final.
 * All preconditions will be enforced
 */
public class SearchUtils<T>
{

   /**
    * Simple linear search that works on any Object based type
    * If the item is found in the array then the index returned<br>
    * If the item is not found in the array and message is printed 
    * to the screen and negative 1 is returned<br>
    * This method must call the equals method of the appropriate class.
    *
    * @param <T> This describes a generic type
    * @param array Representing an array of some class
    * @param target Representing the item to locate in the array
    *
    * @return int Representing an index in the array if the target was found or -1 if the target was not found
    *
    * @throws IllegalArgumentException if array is null or target is null or the array length is less than or equal to 0
    */
   public static <T> int linearSearch(final T [] array, final T target)
   {
      if(array == null || target == null || array.length <= 0)
      {
         throw new IllegalArgumentException("Bad params linearSearch");
      }
      
      for(int i = 0; i < array.length; i++)
      {
         if(array[i].equals(target))
         {
            return i;
         }
      }
      System.out.println("Item was not found");
      
      return -1;      
        
   }// end linear search

}// end class