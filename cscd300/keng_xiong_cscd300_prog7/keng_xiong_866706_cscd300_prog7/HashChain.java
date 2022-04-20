// Keng Xiong

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HashChain {

	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(System.in); // Creates Scanner for user input
		HashChainList chain = fillChain(args[0]); // Creates HashChain using contents from text file
		int choice, studentID;
		String studentName;

		do {
			choice = menu(kb); // Displays menu and prompts user for input

			switch (choice) {
				case 1:
					System.out.print("Input the Student ID: ");
					studentID = Integer.parseInt(kb.nextLine());

					System.out.print("Input the Student name: ");
					studentName = kb.nextLine();

					StudentRecord studentRecord = new StudentRecord(studentID, studentName);
					String recordUpdate = chain.put(studentRecord); // Inserts or updates existing record

					if(recordUpdate == null) {
						System.out.println("The new student has been added successfully\n"); // Prints after insertion of new record
					}

					else {
						System.out.println("The student was exiting and the record has been updated\n"); // Prints after existing record is updated
					}

					break;
				case 2:
					System.out.print("Input the Student ID: ");
					studentID = Integer.parseInt(kb.nextLine());

					StudentRecord chainRemove = chain.remove(studentID);

					if(chainRemove == null) {
						System.out.println("No such student\n"); // Prints if searched record does not exist
					}

					else {
						System.out.println("The student has been deleted successfully\n"); // Prints if search record was found and removed
					}

					break;
				case 3:
					System.out.print("Input the Student ID: ");
					studentID = Integer.parseInt(kb.nextLine());

					StudentRecord recordSearch = chain.get(studentID);

					if(recordSearch == null) {
						System.out.println("No such student\n"); // Prints if searched record does not exist
					}

					else {
						System.out.println("Student ID: " + recordSearch.getID() + " " + "Student Name: " + recordSearch.getName() + "\n"); // Prints record
					}

					break;
				case 4:
					int totalRecords = chain.size();
					for(int i = 0; totalRecords != 0; i++) {
						Node cur = chain.HashTable[i].head;
						while(cur != null) {
							System.out.print(cur);
							if(cur != null) {
								System.out.print(" "); // Separates each record with a white space
							}
							totalRecords--;
							cur = cur.getNext();
						}
						System.out.print("\n");
					}
					System.out.print("\n");

					break;
				case 5:
					System.out.println("Program ending");

					break;
			}

		} while(choice != 5); // Quits the program if the choice is 5

	}

	public static int menu(Scanner kb) {
		if(kb == null) {
			throw new IllegalArgumentException("Invalid Scanner");
		}

		int userChoice = 0;

		do {
			System.out.println("Choose one of the following options:");
			System.out.println("=====================================");
			System.out.println("1) Insert/update a new student record");
			System.out.println("2) Delete a student record");
			System.out.println("3) Search for a student record");
			System.out.println("4) Print all the student records");
			System.out.println("5) Quit\n");

			System.out.print("Your choice: ");
			userChoice = Integer.parseInt(kb.nextLine());
			System.out.print("\n");

			if(userChoice < 1 || userChoice > 5) {
				System.out.println("Please enter a valid choice\n"); // Prints if user provides an input that is out of the range
			}

		} while(userChoice < 1 || userChoice > 5);

		return userChoice;
	}

	public static HashChainList fillChain(final String fileName) throws IOException {
		HashChainList chain = new HashChainList(5); // Creates HashChain with fixed size of 5
		Scanner fileReader = new Scanner(new File(fileName));
		String[] data = new String[2]; // To store String references during split

		while(fileReader.hasNext()) {
			data = fileReader.nextLine().split(","); // When reading from the text file, splits string at commas into String Array

			int studentID = Integer.parseInt(data[0]);
			String studentName = data[1];

			StudentRecord studentRecord = new StudentRecord(studentID, studentName);
			chain.initialPut(studentRecord);
		}
		fileReader.close();

		return chain;
	}

}

class HashChainList implements Map {
	int size;
	LinkedList[] HashTable;

	public HashChainList(final int tableSize) {
		size = 0;
		HashTable = new LinkedList[tableSize];
		for(int i = 0; i < tableSize; i++) {
			HashTable[i] = new LinkedList();
		}
	}

	public int hash(final int key) { // Hash function
		return (((7 * key) + 29) % 5);
	}

	public int size() {
		return this.size;
	}

	@Override
	public StudentRecord get(final int key) {
		Node temp = HashTable[hash(key)].search(key);

		if(temp == null) {
			return null;
		}

		return temp.getRecord();
	}

	@Override
	public String put(final StudentRecord studentRecord) {
		if(studentRecord == null) {
			throw new IllegalArgumentException("studentRecord is null");
		}

		Node temp = HashTable[hash(studentRecord.getID())].search(studentRecord.getID());

		if(temp == null) {
			HashTable[hash(studentRecord.getID())].insert(studentRecord); // If the record does not already exist
			this.size++;
			return null;
		}

		String oldValue = temp.getRecord().getName(); // Assigns the value of the old record to local String variable
		temp.setRecord(studentRecord); // Replaces previous record with new record

		return oldValue; // Returns the old value
	}

	@Override
	public StudentRecord remove(final int key) {
		Node temp = HashTable[hash(key)].delete(key);

		if(temp == null) {
			return null;
		}

		this.size--;
		return temp.getRecord();
	}

	public void initialPut(final StudentRecord studentRecord) { // The initial put method when creating the HashChain
		if(studentRecord == null) {
			throw new IllegalArgumentException("studentRecord is null");
		}

		Node temp = HashTable[hash(studentRecord.getID())].search(studentRecord.getID());

		if(temp == null) {
			HashTable[hash(studentRecord.getID())].insert(studentRecord); // If the record does not already exist
			this.size++;
		}
		else {
			temp.setRecord(studentRecord);	// Updates existing record with the same ID
		}
	}

}

class Node {
	private StudentRecord studentRecord;
	private Node next;

	public Node(final StudentRecord studentRecord) { // First Node constructor
		this(studentRecord, null); // Call to the main Node constructor
	}

	public Node(final StudentRecord studentRecord, final Node next) {
		this.studentRecord = studentRecord;
		this.next = next;
	}

	public StudentRecord getRecord() {
		return this.studentRecord;
	}

	public Node getNext() {
		return this.next;
	}

	public void setRecord(final StudentRecord element) {
		this.studentRecord = element;
	}

	public void setNext(final Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		String str = "(" + this.studentRecord.getID() + ", " +  this.studentRecord.getName() + ")";
		return str;
	}
}

class LinkedList {
	protected Node head;
	protected int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	public void add(final Node v) {
		if(v == null) {
			return;
		}

		v.setNext(head);
		head = v;
		size++;
	}

	public Node removeFirst() {
		Node oldHead = this.head;
		this.head = head.getNext();
		size--;

		return oldHead;
	}

	public Node remove(final int key) {
		if(this.head == null) { // Checks to see if the Linked List is empty
			return null; // Returns null if the Linked List is empty
		}

		if(this.head.getRecord().getID() == key) { // If the Head's ID is the same as key
			Node temp = removeFirst(); // Calls remove first method if conditions are met
			return temp;
		}

		Node cur = this.head, prev = null;
		boolean wasFound = false;

		while(cur != null && wasFound != true) {
			if(cur.getRecord().getID() == key) {
				wasFound = true; // Changes boolean to true if the key was found
			}
			prev = cur;
			cur = cur.getNext();
		}

		if(wasFound == true) {
			prev.setNext(cur.getNext()); // Removes Node from the Linked List
			return cur; // Returns removed node
		}

		return null; // If nothing was removed, return null
	}

	public Node search(final int key) {
		Node cur = this.head;
		boolean wasFound = false;
		while(cur != null && wasFound != true) {
			if(cur.getRecord().getID() == key) { // Checks Node's ID and compares it with key
				wasFound = true; // Changes boolean to true if the key was found
			}

			else {
				cur = cur.getNext();
			}
		}

		if(wasFound == true) {
			return cur; // Returns if Node with specified key was found
		}

		return null; // Returns null if nothing was found
	}

	public void insert(StudentRecord studentRecord) { // Creates Node with object and adds to the head of a Linked List
		Node recordNode = new Node(studentRecord);
		add(recordNode); // Call to add method
	}

	public Node delete(int key) { // Removes Node with specified key
		Node temp = remove(key);
		return temp;
	}

}

class StudentRecord {
	private int id;
	private String name;

	public StudentRecord(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getID() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setID(final int id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}
}

interface Map {
	int size();
	StudentRecord get(int key);
	String put(StudentRecord student);
	StudentRecord remove(int key);
}
