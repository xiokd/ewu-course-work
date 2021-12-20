// Keng Xiong

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RoundRobin {

	public static void main(String[] args) throws IOException {
		String fileName = args[0];
		int serviceTime = Integer.parseInt(args[1]);
		LinkedList dataList = new LinkedList();

		dataList.fillList(fileName); // Fills the Linked List.

		String terminationList = roundRobinRemove(dataList, serviceTime); // Completes the processes and removes them when finished.

		System.out.println(terminationList); // Prints out the order of process terminations.
	}

	public static String roundRobinRemove(final LinkedList list, final int sTime) {
		if (sTime == 0) {
			return "Service time is zero.";
		} // Returns String if service time is zero.

		if(list.getSize() == 0) {
			return "Linked List is empty.";
		} // Returns String if Linked List is empty.

		String processTerm = ""; // String to be returned.

		do {
			if(list.getCursor().getProcess().getProcessTime() - sTime < 0) {
				int curServe = list.getCursor().getProcess().getProcessTime();
				list.getCursor().getProcess().setProcessTime(list.getCursor().getProcess().getProcessTime() - curServe);
			} // If service time is greater than the time left in Process, subtract remaining time.

			else {
				list.getCursor().getProcess().setProcessTime(list.getCursor().getProcess().getProcessTime() - sTime);
			} // Subtracts service time from process time.

			if(list.getCursor().getProcess().getProcessTime() == 0) {
				processTerm += list.getCursor().getProcess().getProcessID();
				list.remove(list.getCursor());

				if(list.getSize() > 0) {
					processTerm += ", ";
				} // When size is greater than zero, appends a comma to separate numbers.
			} // When process time is zero, remove the Node from the Linked List.

			else {
				list.advance(); // Advances to next Node.
			}

		} while (list.getSize() != 0); // Continues loop while list isn't empty.

		return processTerm;
	}
}

class LinkedList {
	protected Node cursor;
	protected long size;

	public LinkedList() {
		cursor = null;
		size = 0;
	} // Constructor for empty Linked List.

	public void advance() {
		if(size > 1) {
			cursor = cursor.getNext();
		}
	} // Moves cursor to next Node.

	public long getSize() {
		return this.size;
	} // Returns Linked List size.

	public Node getCursor() {
		return this.cursor;
	} // Returns cursor.

	public void fillList(final String fileName) throws IOException {
		Scanner fileReader = new Scanner(new File(fileName)); // Scanner reads from file.

		while(fileReader.hasNext()) {
			String tempString = fileReader.nextLine();
			String[] strArray = tempString.split(",");
			int pID = Integer.parseInt(strArray[0].trim());
			int pTime = Integer.parseInt(strArray[1].trim());

			Process process = new Process(pID,pTime); // Creates Process object.
			Node nn = new Node(process);
			addOrdered(nn);
		} // While loop will cycle until file is empty.
		fileReader.close();
	}

	public void addOrdered(final Node dataNode) {
		if (dataNode == null) {
			return;
		} // Does nothing if Node is null.

		if (size == 0) {
			cursor = dataNode;
			cursor.setNext(cursor);
			cursor.setPrev(cursor);
		} // Cursor gets assigned to the new Node if Linked List is empty.

		else if (dataNode.getProcess().getProcessID() < cursor.getProcess().getProcessID()) {
			dataNode.setNext(cursor);
			dataNode.setPrev(cursor.getPrev());
			cursor.getPrev().setNext(dataNode);
			cursor.setPrev(dataNode);
			cursor = dataNode;
		} // If the new Node is less than the cursor, cursor gets assigned to the new Node.

		else if (size == 1) {
			dataNode.setNext(cursor);
			dataNode.setPrev(cursor);
			cursor.setNext(dataNode);
			cursor.setPrev(dataNode);
		} // If the size is 1, the Node will be added after cursor.

		else {
			Node cur;
			for (cur = cursor; cur.getNext().getProcess().getProcessID() < dataNode.getProcess().getProcessID(); cur = cur.getNext()) {
				;
			} // Empty loop to travel the Linked List

			dataNode.setNext(cur.getNext());
			dataNode.setPrev(cur);
			cur.getNext().setPrev(dataNode);
			cur.setNext(dataNode);
		} // Adds Nodes in order based on Process ID.
		size++; // Size increases by one.
	}

	public void remove(final Node selectedNode) {
		if(selectedNode == null) {
			return;
		} // Does nothing if Node is null.

		Node removed;
		if(size == 0) {
			return;
		} // Does nothing if list is empty.

		else if (size == 1) {
			removed = cursor;
			cursor.setNext(null);
			cursor.setPrev(null);
			cursor = null;
			removed.setNext(null);
			removed.setPrev(null);
			size--;	// Reduces size by one.
		} // When size is 1, remaining Node is removed and cursor is set to null.

		else {
			removed = cursor;
			advance(); // Advances cursor to the next Node.
			removed.getPrev().setNext(removed.getNext());
			removed.getNext().setPrev(removed.getPrev());
			removed.setNext(null);
			removed.setPrev(null);
			size--; // Reduces size by one.
		}
	}

}

class Node {
	private Process process;
	private Node prev;
	private Node next;

	public Node(final Process process) {
		this(process, null, null);
	}

	public Node(final Process process, final Node prev, final Node next) {
		this.process = process;
		this.prev = prev;
		this.next = next;
	}

	public Process getProcess() {
		return this.process;
	} // Returns Process object.

	public Node getNext() {
		return this.next;
	} // Returns next Node.

	public Node getPrev() {
		return this.prev;
	} // Returns previous Node.

	public void setNext(final Node next) {
		this.next = next;
	} // Sets next Node.

	public void setPrev(final Node prev) {
		this.prev = prev;
	} // Sets previous Node
}

class Process {
	private int processID;
	private int processTime;

	public Process(final int processID, final int processTime) {
		this.processID = processID;
		this.processTime = processTime;
	}

	public int getProcessID() {
		return this.processID;
	} // Returns process ID

	public int getProcessTime() {
		return this.processTime;
	} // Returns process time.

	public void setProcessID(final int processID) {
		this.processID = processID;
	} // Sets process ID

	public void setProcessTime(final int processTime) {
		this.processTime = processTime;
	} // Sets process time.
}
