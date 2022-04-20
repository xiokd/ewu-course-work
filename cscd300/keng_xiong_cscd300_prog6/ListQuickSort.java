//Keng Xiong

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ListQuickSort {

	public static void main(String[] args) throws IOException {
		DLinkedList list = new DLinkedList();

		fillList(list, args[0]);

		testQuickSort(list, list.head.getNext(), list.tail.getPrev());

		printSortedList(list); // Prints out all the contents from the list
	}

	public static void testQuickSort(final DLinkedList list, final DNode left, final DNode right) {
		if (left == right || left == right.getNext() || left == right.getNext().getNext() || right == list.head.getNext() || left == list.tail) {
			return;
		}

		DNode tempLeft = left; // Temporary reference
		DNode tempRight = right; // Temporary reference

		DNode leftCheckLeft = tempLeft.getPrev(); // Used to check the left of the left node
		DNode leftCheckRight = tempLeft.getNext(); // Used to check the right of the left node
		DNode rightCheckLeft = tempRight.getPrev(); // Used to check the left of the right node
		DNode rightCheckRight = tempRight.getNext(); // Used to check the right of the right node

		DNode pivotIndex = partition(list, tempLeft, tempRight); // Finds the index for pivot

		if(tempLeft.getNext() != leftCheckRight && tempLeft.getPrev() != leftCheckLeft || tempRight.getNext() != rightCheckRight && tempRight.getPrev() != rightCheckLeft) { // If there are any changes in the list, then reset
			DNode resetRight = tempLeft;
			DNode resetLeft = list.head.getNext();

			tempLeft = resetLeft; // Resets the position of the right side
			tempRight = resetRight; // Resets the position of the left side
		}

		testQuickSort(list, tempLeft, pivotIndex.getPrev()); // Sorts Left side
		testQuickSort(list, pivotIndex.getNext(), tempRight); // Sorts Right side

	}

	public static DNode partition(final DLinkedList list, final DNode left, final DNode right) {
		int pivot = right.getElement();
		DNode index = left;

		DNode tempLeft = left; // Temporary local variables
		DNode tempRight = right; // Temporary local variables

		for (DNode i = tempLeft; i != tempRight; i = i.getNext()) {
			if (i.getElement() <= pivot) {
				swap(list, index, i);

				DNode resetIndex = i;
				DNode resetPosition = index;
				index = resetIndex; // Resets the position of the index
				i = resetPosition;	// Resets the position of i

				index = index.getNext();
			}
		}
		swap(list, index, tempRight); // Final swap

		DNode resetIndex = tempRight;
		DNode resetRight = index;
		index = resetIndex; // Resets the position of the index
		tempRight = resetRight; // Resets the position of right side

		return index; // Returns the new pivot index
	}

	public static void swap(final DLinkedList list, final DNode leftPosition, final DNode rightPosition) {

		if (leftPosition == rightPosition) { // If the left position is the same as right, do nothing
			return;
		}

		else if (leftPosition.getNext() == rightPosition) { // If the left position is right next to the right, swap
			leftPosition.setNext(rightPosition.getNext());
			rightPosition.getNext().setPrev(leftPosition);

			rightPosition.setPrev(leftPosition.getPrev());
			rightPosition.setNext(leftPosition);

			leftPosition.getPrev().setNext(rightPosition);
			leftPosition.setPrev(rightPosition);
		}

		else { // If they are not next to each other or the same, swap
			leftPosition.getPrev().setNext(leftPosition.getNext());
			leftPosition.getNext().setPrev(leftPosition.getPrev());
			leftPosition.setNext(leftPosition.getPrev());

			rightPosition.getPrev().setNext(rightPosition.getNext());
			rightPosition.getNext().setPrev(rightPosition.getPrev());
			rightPosition.setNext(rightPosition.getPrev());

			leftPosition.setNext(rightPosition.getNext());
			rightPosition.setPrev(leftPosition.getPrev());

			leftPosition.setPrev(leftPosition.getNext());
			rightPosition.setNext(rightPosition.getPrev());

			leftPosition.setNext(leftPosition.getNext().getNext());
			leftPosition.getPrev().setNext(leftPosition);
			leftPosition.getNext().setPrev(leftPosition);

			rightPosition.setNext(rightPosition.getNext().getNext());
			rightPosition.getPrev().setNext(rightPosition);
			rightPosition.getNext().setPrev(rightPosition);
		}

	}

	public static void printSortedList(final DLinkedList list) {
		if (list.getSize() == 0) {
			throw new IllegalArgumentException("List size is zero");
		}

		for (DNode cur = list.head.getNext(); cur != list.tail; cur = cur.getNext()) {
			System.out.println(cur.getElement());
		}
	}

	public static void fillList(final DLinkedList list, final String fileName) throws IOException {
		Scanner fileReader = new Scanner(new File(fileName));

		while (fileReader.hasNext()) {
			int element = Integer.parseInt(fileReader.nextLine());
			DNode node = new DNode(element);
			list.add(node);
		}
		fileReader.close();
	}

}

class DLinkedList {
	protected DNode head;
	protected DNode tail;
	protected long size;

	public DLinkedList() {
		head = new DNode(0, null, null);
		tail = new DNode(0, null, null);
		head.setNext(tail);
		tail.setPrev(head);
		size = 0;
	}

	public long getSize() {
		return this.size;
	}

	public void add(DNode v) {
	v.setPrev(tail.getPrev());
		v.setNext(tail);
		tail.getPrev().setNext(v);
		tail.setPrev(v);
		size++;
	}
}

class DNode {
	private int element;
	private DNode prev;
	private DNode next;

	public DNode(int element) {
		this(element, null, null);
	}

	public DNode(int element, DNode prev, DNode next) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}

	public int getElement() {
		return this.element;
	}

	public DNode getNext() {
		return this.next;
	}

	public DNode getPrev() {
		return this.prev;
	}

	public void setElement(int element) {
		this.element = element;
	}

	public void setNext(DNode next) {
		this.next = next;
	}

	public void setPrev(DNode prev) {
		this.prev = prev;
	}
}
