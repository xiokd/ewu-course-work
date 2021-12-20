// Keng Xiong

import java.io.*;
import java.util.Scanner;

public class BinarySearchRange {

	public static void main(String[] args) throws IOException {
		Scanner dataFile = new Scanner(new File(args[0]));
		int num1 = Integer.parseInt(args[1]);
		int num2 = Integer.parseInt(args[2]);

		int size = 0;
		while (dataFile.hasNext()) {
			dataFile.nextLine();
			size++;
		} // Counts the lines in the text files
		dataFile.close();

		int[] dataSet = new int[size]; // Array is created according line number

		dataFile = new Scanner(new File(args[0]));
		int counter = 0;
		while (dataFile.hasNext()) {
			dataSet[counter] = Integer.parseInt(dataFile.nextLine());
			counter++;
		} // While loop is used to fill the array with the contents on the file
		dataFile.close();

		String searchAnswer = searchMethod(dataSet, num1, num2);

		System.out.println(searchAnswer); // Displays string as answer

	}

	public static String searchMethod(final int[] data, final int x, final int y) {
		String searchAnswer = "";
		int leftIndex = 0, rightIndex = 0;

		if (data.length == 0 || x > y) {
			searchAnswer = null;
		} // Checks if the array is empty or if the left index is larger than the right
		else if (y < data[0]) {
			searchAnswer = null;
		} // Checks if the right side element is less than the leftmost index of the array
		else if (x > data[data.length - 1]) {
			searchAnswer = null;
		} // Checks if the left side index is greater than the rightmost index of the array
		else if (x <= data[0] && y >= data[data.length - 1]) {
			searchAnswer = "A[0.." + String.valueOf(data.length - 1) + "]";
		} // Checks if the range includes all the elements in the array
		else {
			leftIndex = leftSearch(data, x); // Finds the leftmost index
			rightIndex = rightSearch(data, y); // Finds the rightmost index
			if(leftIndex == -1 || rightIndex == -1) {
				searchAnswer = null;
			} // Returns null if either index is -1
			else if (leftIndex <= rightIndex) {
				searchAnswer = "A[" + leftIndex + ".." + rightIndex + "]";
			} // Assigns answer to string variable to be returned
			else {
				searchAnswer = null;
			} // Returns null for all other conditions
		}
		return searchAnswer; // Returns String variable to method call
	}

	public static int leftSearch(final int[] data, final int x) {
		int low = 0, high = data.length - 1;
		while (low <= high) {
			int mid = (int) Math.floor((low + high) / 2);
			if (data[mid] == x) {
				if (data[mid - 1] < x) {
					return mid;
				} // Checks the left side
				else {
					high = mid - 1;
				} // Assigns high as the index left side of mid
			}
			else if (data[mid] > x) {
				if (data[mid] == data[0]) {
					return mid;
				} // Returns mid if mid is index 0
				else if (data[mid - 1] >= x) {
					high = mid - 1;
				} // Assigns high as index left side of mid
				else {
					return mid;
				}
			}
			else {
				low = mid + 1;
			} // If mid is less than leftmost index low gets right side of mid
		}
		return -1;
	}

	public static int rightSearch(final int[] data, final int y) {
		int low = 0, high = data.length - 1;
		while (low <= high) {
			int mid = (int) Math.floor((low + high) / 2);
			if (data[mid] == y) {
				if (data[mid + 1] > y) {
					return mid;
				} // Checks if the index on the right side
				else {
					low = mid + 1;
				} // Assigns low as the index right side of mid
			}
			else if (data[mid] < y) {
				if (data[mid] == data[data.length - 1]) {
					return mid;
				} // Returns mid if mid is index array size - 1
				else if (data[mid + 1] <= y) {
					low = mid + 1;
				} // Assigns low index as right side of mid
				else {
					return mid;
				}
			}
			else {
				high = mid - 1;
			} // If mid is greater than rightmost index high gets left side of mid
		}
		return -1;
	}
}
