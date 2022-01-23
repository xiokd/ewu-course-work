// Keng Xiong

import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class FastMatrixMulti {

	public static void main(String[] args) throws IOException {
		int[] matrixDimensions = fillArray(args[0]); // Reads matrix dimension from text file and stores them into an array
		matrixChainResults res = matrixChainOrder(matrixDimensions); // Performs matrix chains operations using the matrix dimensions
		printOptimalParenthesis(res.getS(), 1, matrixDimensions.length - 1); // Prints the optimal parenthesis for the matrix chain
		System.out.println("\n" + res.getTimeCost()); // Prints the time cost for the matrix chain
	}
	
	public static matrixChainResults matrixChainOrder(final int[] matrixDimensions) {
		int n = matrixDimensions.length - 1; // Total number of matrices
		int indexing = matrixDimensions.length + 1; // Used for one-based indexing
		
		int[][] m = new int[indexing][indexing]; // Stores optimal time cost for multiplying sub-chains
		int[][] s = new int[indexing][indexing]; // Stores optimal position of the optimal outermost pair parenthesis
		int timeCost = 0; // Initialized to store optimal time cost
		
		for(int h = 2; h <= n; h++) { // h assigned to be length of the sub-chain
			for(int i = 1; i <= n - h + 1; i++) { // Starting position of the sub-chain
				int j = i + h - 1; // Ending position of the sub-chain
				m[i][j] = Integer.MAX_VALUE; // Infinite (integer max value)
				for(int k = i; k <= j; k++) { // Trying different positions for the outermost pair parenthesis for current sub-chain
					int q = m[i][k] + m[k + 1][j] + (matrixDimensions[i - 1] * matrixDimensions[k] 
							* matrixDimensions[j]);
					if(q < m[i][j]) {
						m[i][j] = q; // Store the optimal time cost for the current sub-chain
						s[i][j] = k; // Store position of outermost parenthesis
						timeCost = q; // Assigns optimal time cost
					}
				}
			}
		}
		
		return new matrixChainResults(m, s, timeCost); // Returns the results to method call in main
	}
	
	public static void printOptimalParenthesis(final int[][]s, final int i, final int j) {
		if(i == j) {
			System.out.print("A" + i);
		} else {
			System.out.print("(");
			printOptimalParenthesis(s, i, s[i][j]);
			printOptimalParenthesis(s, s[i][j] + 1, j);
			System.out.print(")");
		}
	}
	
	public static int[] fillArray(final String file) throws IOException {
		if(file == null) {
			throw new IllegalArgumentException("String file in method fillArray is null"); // displays if the file is null
		}
		
		Scanner fileReader = new Scanner(new File(file)); // Creates Scanner object using the text file
		
		int numLines = 0;
		while(fileReader.hasNext()) { // Used for counting the number of lines in the text file
			fileReader.nextLine();
			numLines++;
		}
		
		fileReader.close();
		
		fileReader = new Scanner(new File(file));
		
		int[] dimensions = new int[numLines];
		for(int i = 0; i < dimensions.length; i++) { // Used for filling a temporary local array to be returned to method call
			dimensions[i] = Integer.parseInt(fileReader.nextLine());
		}
		
		fileReader.close();
		
		return dimensions;
	}

}

class matrixChainResults {
	protected int[][] m;
	protected int[][] s;
	protected int timeCost;
	
	public matrixChainResults(final int[][] m, final int[][] s, final int timeCost) {
		this.m = m;
		this.s = s;
		this.timeCost = timeCost;
	}
	
	public int[][] getM() {
		return this.m;
	}
	
	public int[][] getS() {
		return this.s;
	}
	
	public int getTimeCost() {
		return this.timeCost;
	}
	
}
