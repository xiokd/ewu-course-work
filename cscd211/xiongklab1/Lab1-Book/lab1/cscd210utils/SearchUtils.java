package lab1.cscd210utils;

/**
 * The class that contains a basic linearSearch and a basic binarySearch
 *
 * @NOTE All parameters to methods must be passed as final
 */
public class SearchUtils<T extends Comparable<? super T>>
{
   /**
    * The linearSearch method is passed an array of type guaranteed to have implemented Comparable utilizing the generic
    * and a target fo the same type. The methods starts at index 0 and goes to the end of the array checking the element against
    * the target by using the equals method of the type.  If the target does not match any value in the
    * array then -1 is returned.
    *
    * @param array Representing an array of a type that has implemented Comparable and has a compareTo method
    * @param target Representing a parameter of a type that has implemented Comparable and has a compareTo method
    * @param <T> Representing the generic
    * @return int Representing the index value of the element if found or -1 otherwise
    *
    * @throws IllegalArgumentException if array is null or length is &lt; 1
    * @throws IllegalArgumentException if the target is null
    */
	public static <T extends Comparable<? super T>> int linearSearch(final T [] array, final T target) {
      if(array == null || array.length < 1 || target == null) {
         throw new IllegalArgumentException("Bad params linearSearch");
      }

      for(int i = 0; i < array.length; i++) {
         if(array[i].equals(target)) {
            return i;
         }
      }

	   return -1;
	}//end linearSearch
}//end class
