// Keng Xiong

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Postfix {
	public static void main(String[] args) throws IOException {
		ListStack stack = new ListStack(); // Creates an empty stack

		String postFixResult = postFixOperation(args[0], stack);

		System.out.println(postFixResult); // Prints out the result from the post fix operations
	} // End of main

	public static String postFixOperation(final String fileName, final ListStack stack) throws IOException {
		if(fileName == null) {
			throw new IllegalArgumentException("File name is null");
		}

		if(stack == null) {
			throw new IllegalArgumentException("Stack is null");
		}

		float value, firstValue, secondValue, calcValue;
		String result = ""; // Empty String

		Scanner file = new Scanner(new File(fileName));

		while(file.hasNext()) {
			String element = new String(file.nextLine());

			if(element.equals("+")) {
				secondValue = stack.pop();
				firstValue = stack.pop();
				calcValue = firstValue + secondValue;
				stack.push(calcValue);
			} // Does two pop operations and adds the first value with the second

			else if(element.equals("-")) {
				secondValue = stack.pop();
				firstValue = stack.pop();
				calcValue = firstValue - secondValue;
				stack.push(calcValue);
			} // Does two pop operations and subtracts the first value with the second

			else if(element.equals("*")) {
				secondValue = stack.pop();
				firstValue = stack.pop();
				calcValue = firstValue * secondValue;
				stack.push(calcValue);
			} // Does two pop operations and multiplies the first value with the second

			else if(element.equals("/")) {
				secondValue = stack.pop();
				firstValue = stack.pop();
				calcValue = firstValue / secondValue;
				stack.push(calcValue);
			} // Does two pop operations and divides the first value with the second

			else {
				value = Float.parseFloat(element);
				stack.push(value);
			} // Pushes value to the top of the stack if it isn't an operator
		} // End of While loop

		file.close();

		if(stack.top() == 0) {
			result = "Stack is empty";
		} // Assigns String to variable if the file or stack is empty

		else {
			result = String.valueOf(stack.top());
		}

		return result;
	} // End postFixOperation method
} // End of Postfix Class

class ListStack {
	protected Node top;
	protected long size;

	public ListStack() {
		top = null;
		size = 0;
	}

	public long size() {
		return this.size;
	}

	public float top() {
		if(size == 0) {
			return 0;
		}
		return top.getElement();
	}

	public void push(float data) {
		if(data == 0) {
			return;
		}

		Node newNode = new Node(data,top);
		top = newNode;
		size++;
	}

	public float pop() {
		if(size == 0) {
			return 0;
		}

		Node oldHead = top;
		top = top.getNext();
		size--;
		oldHead.setNext(null);

		return oldHead.getElement();
	}
} // End of ListStack class

class Node {
	private float element;
	private Node next;

	public Node(final float element, final Node next) {
		this.element = element;
		this.next = next;
	}

	public float getElement() {
		return this.element;
	}

	public Node getNext() {
		return this.next;
	}

	public void setElement(final int element ) {
		this.element = element;
	}

	public void setNext(Node next) {
		this.next = next;
	}
} // End of Node class
