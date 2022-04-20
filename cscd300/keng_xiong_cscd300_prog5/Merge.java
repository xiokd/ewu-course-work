// Keng Xiong

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Merge {

	public static void main(String[] args) throws IOException {
		ArrayQueue[] queueHolder = new ArrayQueue[args.length]; // Creates new Array Queue Array with length of String Array args

		ListQueue sortedSolution = listFill(queueHolder, args);

		display(sortedSolution);
	}

	public static ListQueue listFill(final ArrayQueue[] queueHolder, final String[] args) throws IOException {
		Scanner[] scannerArray = new Scanner[args.length]; // Creates a Scanner array with the same size as original String array

		for(int i = 0; i < scannerArray.length; i++) { // Fills the Scanner Array with Scanners created from the Strings from the String Array
			scannerArray[i] = new Scanner(new File(args[i]));
		}

		ArrayQueue[] filledQueue = initialFill(queueHolder, scannerArray);
		ListQueue solution = new ListQueue();
		int availableQueues = filledQueue.length;

		int curFile, min, counter;
		while(availableQueues > 0) { // While all the Queues are not all empty
			curFile = 0; // Default value
			min = 0; // Default value

			counter = 0;
			while(min == 0) {
				if(filledQueue[counter].size() == 0) { // If the Array Queue is empty, increment the counter
					counter++;
				}

				else { // Else, assign the starting value of min to be compared with all other Array Queues
					curFile = counter;
					min = filledQueue[counter].front();
				}
 			}

			for(int i = 0; i < filledQueue.length; i++) {
				if(filledQueue[i].size() == 0) {
					// Does nothing if the Array Queue is empty
				}

				else if (filledQueue[i].front() < min) {
					min = filledQueue[i].front(); // Assigns new min value to be compared to all other Array Queues
					curFile = i; // Assigns value of the specific Queue the min value was found in
				}
			}

			solution.enqueue(filledQueue[curFile].dequeue()); // Dequeues from Array Queue with the min value and enqueues to the List Queue

			if(scannerArray[curFile].hasNext()) { // If the corresponding file still has values, enqueue it to Array Queue
				filledQueue[curFile].enqueue(Integer.parseInt(scannerArray[curFile].nextLine()));
			}

			else { // Else check if the Array Queue is empty
				if(filledQueue[curFile].size() == 0) { // If the Array Queue is empty, decrement the available Queues
					availableQueues--;
				}
			}

		}

		return solution;
	}

	public static ArrayQueue[] initialFill(final ArrayQueue[] queueHolder, final Scanner[] scannerArray) {
		ArrayQueue[] tempHolder = queueHolder;

		for(int i = 0; i < tempHolder.length; i++) {
			tempHolder[i] = new ArrayQueue(); // Creates a new Array Queue for every index in the Array Queue Array

			while(tempHolder[i].size() < 10 && scannerArray[i].hasNext()) {
				tempHolder[i].enqueue(Integer.parseInt(scannerArray[i].nextLine()));
			}
		}

		return tempHolder;
	}

	public static void display(final ListQueue solution) {
		while(solution.size() > 0) { // Dequeues and prints out all the elements from the List Queue
			System.out.println(solution.dequeue());
		}
	}

}

class ArrayQueue implements Queue {
	protected int capacity;
	public static final int CAPACITY = 10; // Default size

	protected int[] Q;
	protected int head;
	protected int tail;
	protected int size;

	public ArrayQueue() {
		capacity = CAPACITY;
		Q = new int[capacity];
		head = -1;
		tail = -1;
		size = 0;
	}

	public ArrayQueue(final int capacity) {
		if(capacity <= 0) {
			return;
		}

		this.capacity = capacity;
		Q = new int[capacity];
		head = -1;
		tail = -1;
		size = 0;
	}

	public int size() {
		return size;
	}

	public int front() {
		if(size == 0) {
			return -1;
		}
		return Q[head];
	}

	public void enqueue(final int item) {
		if(size == capacity) {
			return;
		}
		if(size == 0) {
			Q[0] = item;
			head = 0;
			tail = 0;
		}

		else {
			tail = (tail + 1) % capacity;
			Q[tail] = item;
		}

		size++;
	}

	public int dequeue() {
		if(size == 0) {
			return -1;
		}

		int ret = Q[head];
		Q[head] = 0;

		if(size == 1) {
			head = -1;
			tail = -1;
		}

		else {
			head = (head + 1) % capacity;
		}

		size--;
		return ret;
	}
}


class ListQueue implements Queue {
	protected Node head;
	protected Node tail;
	protected int size;

	public ListQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public int front() {
		if(size == 0) {
			return -1;
		}
		return head.getElement();
	}

	public void enqueue(final int item) {
		Node new_node = new Node(item, null);

		if(size == 0) {
			head = new_node;
			tail = new_node;
		}

		else {
			tail.setNext(new_node);
			tail = new_node;
		}
		size++;
	}

	public int dequeue() {
		if(size == 0) {
			return -1;
		}

		int ret = head.getElement();

		if(size == 1) {
			head = null;
			tail = null;
		}

		else {
			Node old_head = head;
			head = head.getNext();
			old_head.setNext(null);
		}
		size--;
		return ret;
	}
}

class Node {
	private int element;
	private Node next;

	public Node(final int element, final Node next) {
		this.element = element;
		this.next = next;
	}

	public int getElement() {
		return this.element;
	}

	public Node getNext() {
		return next;
	}

	public void setElement(final int element) {
		this.element = element;
	}

	public void setNext(final Node next) {
		this.next = next;
	}
}

interface Queue {
	public int size();
	public int front();
	public void enqueue(int item);
	public int dequeue();
}
