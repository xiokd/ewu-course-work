package lab12.cscd211recursion;

/**
 * Given the public findLargest method below, write the recursive private helper
 * method based on the call in the public method.
 * 
 * The helper method must recursively walk through the array and find the largest value.
 * The largest value should be returned.
 * 
 * No loops of any form are allowed.
 * Failure to productively use recursion to solve this problem will result in 0 points.
 *
 * testFindLargestEmptyArray - Expected exception: IllegalArgumentException, array passed to findLargest was empty
 * testFindLargest1ItemArray - largest value is: 55
 * testFindLargest2ItemArray - largest value is: 66
 * testFindLargest3ItemArray - largest value is: 66
 * testFindLargest5ItemArray - largest value is: 2
 * testFindLargest10ItemArray - largest value is: 3
 * testFindLargest10ItemArrayAllSame - largest value is: 1
 * testFindLargest10ItemArrayAscending - largest value is: 10
 */
public class RecursionFindLargest
{

   /** 
    * This method cannot be changed
    * @param array Representing the array to find the largest
    * @return int Representing the largest value in the array
    * @throws IllegalArgumentException if array is null or length is 0
    */
	public static int findLargest(int [] array)
   {
		if (array == null || array.length == 0)
			throw new IllegalArgumentException("array passed to findLargest was empty");
		return findLargest(array, 1, array[0]);
	}

	/**
    * Write the private helper method to recursively walk the array to
    * find the largest item in the array
    * @param array Representing the array to find the largest
    * @param i Representing the index
    * @param largest Representing the current largest value
    * @return int Representing the largest value in the array
    */
   private static int findLargest(int[] array, int i, int largest)
   {
      if(i == array.length)
      {
         return largest;
      }
      
      else
      {
         if(array[i] > array[i - 1])
         {
            largest = array[i];
         }
      }

     return findLargest(array, i + 1, largest);
      
   }// end helper method findLargest
	
}// end class

