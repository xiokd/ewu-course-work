//Keng Xiong

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class Richest {

	public static void main(String[] args) throws IOException {
		Scanner fileReader = new Scanner(new File(args[0])); // Create Scanner using a file name
		MinHeap heap = new MinHeap(10000); // Initial Max load that can be stored in memory
		findRichest(fileReader, heap); // Finds the top 10000 Richest
		fileReader.close(); // Closes Scanner
		
		FileWriter writer = new FileWriter("richest.output"); // Creates FileWriter Object with an output file richest.output
		writeToFile(writer, heap); // Writes to the outputfile using the MinHeap
		writer.close(); // Closes Writer
	}
	
	public static void findRichest(final Scanner fileReader, final MinHeap heap) {
		heap.initialHeapFill(fileReader); // The initial fill of the top 10000 Richest into the Heap
		heap.buildMinHeap();
		
		int candidateElement;
		while(fileReader.hasNext()) { // Searches the remaining data from the Scanner
			candidateElement = Integer.parseInt(fileReader.nextLine()); // Stores nextLine() element into local variable
			if(candidateElement > heap.getMinElement()) { // If the candidate element is larger than the smallest element in the Heap
				heap.setElement(1, candidateElement); // Replaces the smallest element in the Heap with the candidate
				heap.buildMinHeap();
			}
		}
		
		heap.buildMinHeap();
		heap.heapSort();
	}
	
	public static void writeToFile(final FileWriter writer, final MinHeap heap) throws IOException {
		for(int i = 1; i <= heap.getSize(); i++) {
			writer.write(heap.getElement(i) + "\n"); // Writes each element from the Heap into a single line on the output file
		}
	}

}

class MinHeap {
	private int[] heap;
	private int heapMaxSize;
	private int size;
	
	public MinHeap(final int maxSize) {
		this.heap = new int[maxSize + 1]; // Using one-based indexing
		this.size = 0;
		this.heapMaxSize = maxSize;	
	}
	
	public int getParent(final int position) {
		return (int) (Math.floor(position / 2));
	}
	
	public int getLeftChild(final int position) {
		return (position * 2);
	}
	
	public int getRightChild(final int position) {
		return ((position * 2) + 1);	
	}
		
	public int getSize() {
		return this.size;
	}
	
	public void setSize(final int size) {
		this.size = size;
	}
	
	public int getElement(final int position) {
		return this.heap[position];
	}
	
	public int getMinElement() {
		return this.heap[1];
	}
	
	public void setElement(final int position, final int element) {
		this.heap[position] = element;
	}
	
	public void buildMinHeap() {
		for(int i = (int) (Math.floor(this.getSize() / 2)); i >= 1; i--) {
			minHeapify(i);
		}
	}
	
	public void minHeapify(final int position) {
		if(position * 2 <= this.getSize() && (position * 2) + 1 <= this.getSize()) { // If true, then the index has two children
			int leftChildElement = this.getElement(this.getLeftChild(position));
			int rightChildElement = this.getElement(this.getRightChild(position));
			
			int candidatePosition;
			if(leftChildElement < rightChildElement) { // Compares the two children of the index for the smallest element
				candidatePosition = this.getLeftChild(position); // If the left child is less than the right child
			} else {
				candidatePosition = this.getRightChild(position); // If the right child is less than the left child
			}
			
			if(this.getElement(candidatePosition) < this.getElement(position)) {
				this.swap(position, candidatePosition); // Swaps the element of the parent and the selected candidate child	
			}
			
		} else { // If false, then the index only has the left child
			if(this.getElement(this.getLeftChild(position)) < this.getElement(position)) { // Compares left child with parent for the smallest element
				this.swap(position, this.getLeftChild(position)); // Swaps the element of the parent and the left child
			}
			
			// If the left child is not less than the parent, then do nothing
		}
	}
	
	public void heapSort() {
		int initialSize = this.getSize();
		for(int i = initialSize; i >= 2; i--) {
			this.swap(1, i);
			this.setSize(this.getSize() - 1);
			this.buildMinHeap();
		}
		this.setSize(initialSize); // Restores the Heap's size after sorting operation
	}
	
	public void insert(final int input) {
		this.heap[this.size] = input;
	}
	
	public void swap(final int initialPosition, final int endingPosition) {
		int initialElement = this.getElement(initialPosition); // Stores the initial positions element into local variable
		this.setElement(initialPosition, this.getElement(endingPosition)); // Assigns new element into the position of the initial element
		this.setElement(endingPosition, initialElement); // Assigns initial element into the position of new element
	
	}
	
	public void initialHeapFill(final Scanner inputFileReader) { // Initial fill for the Heap
		while(this.size < this.heapMaxSize && inputFileReader.hasNext()) {
			this.size++;
			insert(Integer.parseInt(inputFileReader.nextLine()));
			this.buildMinHeap();
		}
	}
	
	public void replacementHeap() { // Repositions the new element in the Heap
		int initialPosition = 1;
		boolean endSearch = false;
		
		int leftChildElement, rightChildElement;
		while(endSearch == false) { // While the boalean remains false
			if(this.getLeftChild(initialPosition) <= this.getSize() && this.getRightChild(initialPosition) <= this.getSize()) { // If there exists a left and right child
				leftChildElement = this.getElement(this.getLeftChild(initialPosition));
				rightChildElement = this.getElement(this.getRightChild(initialPosition));
				
				if(leftChildElement < rightChildElement) { // If the left child has the smallest element
					if(this.getElement(initialPosition) > leftChildElement) { // If the newly inserted element in its current position is greater than its left child
						this.swap(initialPosition, this.getLeftChild(initialPosition));
					} else { // If the newly inserted element in its current position is not greater than its left child, end the loop
						endSearch = true;
					}
				} else { // If the right child has the smallest element
					if(this.getElement(initialPosition) > rightChildElement) { // If the newly inserted element in its current position is greater than its right child
						this.swap(initialPosition, this.getRightChild(initialPosition));
					} else { // If the newly inserted element in its current position is not greater than its right child, end the loop
						endSearch = true;
					}
				}
			} else if(this.getLeftChild(initialPosition) <= this.getSize()) { // If there only exists a left child
				leftChildElement = this.getElement(this.getLeftChild(initialPosition));

				if(this.getElement(initialPosition) > leftChildElement) { // If the newly inserted element in its current position is greater than its left child
					this.swap(initialPosition, this.getLeftChild(initialPosition));
				} else { // If the newly inserted element in its current position is not greater than its left child, end the loop
					endSearch = true;
				}
			} else { // If the current position is a leaf node
				endSearch = true;
			}
		}
	}
}
