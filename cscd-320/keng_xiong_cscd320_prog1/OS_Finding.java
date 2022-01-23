// Keng Xiong

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class OS_Finding {

	public static void main(String[] args) throws IOException {
		int[] inputArray = fillArray(args[0]);
		int order = Integer.parseInt(args[1]);
		
		if(order > inputArray.length) { // Checks to see if the ith order input is valid 
			System.out.print("null\n"); // Prints when ith order is larger than n
		} else {
			int selectedNum = randomizedSelect(inputArray, 0, inputArray.length - 1, order); // Calls method for randomized selection
			System.out.println(selectedNum); // Prints the ith order statistic
		}
	}
	
	public static int randomizedSelect(final int[] array, final int p, final int r, final int i) {
		if(array.length == 0 || p < 0 || r < 0 || i < 1) { // Checks for valid parameters
			throw new IllegalArgumentException("Invalid parameters for method randomizedSelect"); // Throws exception if invalid
		}
		
		if(p == r) {
			return array[p]; // Recursion stopping condition
		}
		
		int q = randomizedPartition(array, p, r); // Index for pivot after partition
		int k = q - p + 1;
		
		if(i == k) {
			return array[q];
		} else if(i < k) {
			return randomizedSelect(array, p, q - 1, i); // Checks left side of pivot
		} else {
			return randomizedSelect(array, q + 1, r, i - k); // Checks right side of pivot
		}
	}
	
	public static int randomizedPartition(final int[] array, final int leftIndex, final int rightIndex) {
		int i = randomIndex(leftIndex, rightIndex); // Finds a random index within the range of the left and right side
		int[] tempArray = swap(array, i, rightIndex); // Random index swapped with the right side
		return partition(tempArray, leftIndex, rightIndex); // Calls partition method and returns result	
	}
	
	public static int partition(final int[] array, final int leftIndex, final int rightIndex) {
		int[] tempArray = array; // Assigns array to local variable
		int pivot = tempArray[rightIndex]; // Assigns element from arrays right index to pivot
		int index = leftIndex; // Assigns left index to index
		
		for(int i = leftIndex; i < rightIndex; i++) {
			if(tempArray[i] <= pivot) { // Checks to see if element in index i is less or equal to pivot
				tempArray = swap(tempArray, index, i); // Swaps element in index i with index
				index++; // Iterates index after swap
			}
		}
		
		tempArray = swap(tempArray, index, rightIndex);
		return index;
	}
	
	public static int[] swap(final int[] array, final int leftIndexIndex, final int rightIndexIndex) {
		int[] tempArray = array;
		int tempNum = tempArray[leftIndexIndex]; // Stores element of index to temporary local variable
		tempArray[leftIndexIndex] = tempArray[rightIndexIndex]; // Assigns right index element to left index
		tempArray[rightIndexIndex] = tempNum; // Assigns right index with element stored in local temporary variable
		
		return tempArray;
	}
	
	public static int randomIndex(final int leftIndex, final int rightIndex) {
		Random random = new Random();
		return random.nextInt(rightIndex - leftIndex + 1) + leftIndex; // Generates a random number using left and right index as range
	}
	 
	public static int[] fillArray(final String fileName) throws IOException { // Fills array using contents from a file
		Scanner file = new Scanner(new File(fileName));
		int totalNum = 0;
		
		while(file.hasNext()) { // Counts the number of lines that are on a file
			file.nextLine();
			totalNum++;
		}
		
		file.close();
		
		int[] temp = new int[totalNum]; // Creates an array using totalNum for size
		
		file = new Scanner(new File(fileName)); // Opens the file again
		
		for(int i = 0; i < temp.length; i++) {
			temp[i] = Integer.parseInt(file.nextLine()); // Fills array with contents from the file
		}
		
		file.close();
		
		return temp; // Returns the array to method call	
	}

}
