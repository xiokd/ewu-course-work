// Keng Xiong

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class BST {

	public static void main(String[] args) throws IOException {
		Scanner kb = new Scanner(System.in); // Creates Scanner for user input
		BinarySearchTree bst = fillTree(args[0]); // Assigns BST object to local variable

		int userKey;
		BST_Node tempNode;
		char choice;

		do {
			choice = menu(kb); // Calls method that displays a menu and prompts user for a char input
			switch (choice) {
				case '1':
					System.out.print("Input a key: "); // Prompts the user for a key
					userKey = Integer.parseInt(kb.nextLine());
					tempNode = bst.search(userKey); // Performs a search in the BST

					if(tempNode != null) {
						System.out.println("The given key exists.\n"); // Prints if the key already exists
					}

					else {
						System.out.println("The given key does not exist.\n"); // Prints if the key is null
					}

					break;
				case '2':
					System.out.print("Input a key: "); // Prompts the user for a key
					userKey = Integer.parseInt(kb.nextLine());
					tempNode = bst.insert(userKey); // Inserts key from user input into the BST

					if(tempNode != null) {
						System.out.println("The given key has been inserted successfully.\n"); // Prints if the key was added to the BST
					}

					else {
						System.out.println("The given already exists.\n"); // Prints if the key already exists in the BST
					}

					break;
				case '3':
					System.out.print("Input a key: "); // Prompts the user for a key
					userKey = Integer.parseInt(kb.nextLine());
					tempNode = bst.delete(userKey); // Passes key from user input into the delete method

					if(tempNode != null) {
						System.out.println("The given key has been successfully deleted.\n"); // Prints if the key exists and removed
					}

					else {
						System.out.println("No such key.\n"); // Prints if the key doesn't exist
					}

					break;
				case '4':
					bst.InOrder_Traversal(bst.getRoot()); // Prints the BST Nodes in order
	                System.out.println("\n");

					break;
				case '5':
					bst.PreOrder_Traversal(bst.getRoot()); // Prints the BST Nodes in Pre Order
					System.out.println("\n");

					break;
				case '6':
					bst.PostOrder_Traversal(bst.getRoot()); // Prints the BST Nodes in Post Order
					System.out.println("\n");

					break;
				case '7':
					bst.LevelOrder_Traversal(bst.getRoot()); // Prints the BST Nodes in Level Order
					System.out.println("\n");

					break;
				case '8':
					tempNode = bst.min(bst.getRoot()); // Finds the BST Node with the smallest key and assigns it to local variable

					if(tempNode != null) {
						System.out.println(tempNode + "\n"); // Prints the BST Node with the smallest key
					}

					else {
						System.out.println("The tree is empty.\n"); // Prints if the BST was empty
					}

					break;
				case '9':
					tempNode = bst.max(bst.getRoot());

					if(tempNode != null) {
						System.out.println(tempNode + "\n"); // Prints the BST Node with the largest key
					}

					else {
						System.out.println("The tree is empty.\n"); // Prints if the BST was empty
					}

					break;
				case 'a':
					System.out.print("Input a key: ");
					userKey = Integer.parseInt(kb.nextLine());
					tempNode = bst.search(userKey);

					if(tempNode != null) {
						tempNode = bst.successor(tempNode); // Searches the BST only if the key from user input was found

						if(tempNode != null) {
							System.out.println(tempNode + "\n"); // Prints the successor of the key from user input
						}

						else {
							System.out.println("The given key exists but does not have a successor.\n"); // Prints if there was no successor to the key from user input
						}
					}

					else {
						System.out.println("No such key.\n"); // Prints if the key from user input was not found in the BST
					}

					break;
				case 'b':
					System.out.print("Input a key: ");
					userKey = Integer.parseInt(kb.nextLine());
					tempNode = bst.search(userKey);

					if(tempNode != null) {
						tempNode = bst.predecessor(tempNode); // Searches the BST only if the key from user input was found

						if(tempNode != null) {
							System.out.println(tempNode + "\n"); // Prints the predecessor of the key from user input
						}

						else {
							System.out.println("The given key exists but does not have a predecessor.\n"); // Prints if there was no predecessor to the key from user input
						}
					}

					else {
						System.out.println("No such key.\n"); // Prints if the key from user input was not found in the BST
					}

					break;
				case 'x':
					System.out.println("Program ending"); // Prints when user chooses to end the program
					break;
				default:
					System.out.println("Please enter a valid choice\n"); // Prints when user input does not match any cases
					break;
			}

		} while(choice != 'x');
	}

	public static char menu(Scanner kb) {
		if(kb == null) {
			throw new IllegalArgumentException("Invalid Scanner in method menu"); // Throws IllegalArgumentException if Scanner is null
		}

		System.out.println("Choose one of the following options:\n"
				+ "=====================================\n"
				+ "1) Search for a key\n"
				+ "2) Insert a new key\n"
				+ "3) Delete an existing key\n"
				+ "4) Inorder traversal of the BST\n"
				+ "5) Preorder traversal of the BST\n"
				+ "6) Postorder traversal of the BST\n"
				+ "7) Level-order traversal of the BST\n"
				+ "8) Find the smallest key\n"
				+ "9) Find the largest key\n"
				+ "a) Find the successor of the given key\n"
				+ "b) Find the predecessor of a given key\n"
				+ "x) Quit\n");

		System.out.print("Your choice: ");
		char userChoice = kb.nextLine().charAt(0); // Stores user input into local variable of data type char
		System.out.print("\n");

		return userChoice;
	}

	public static BinarySearchTree fillTree(String fileName) throws IOException {
		Scanner fileReader = new Scanner(new File(fileName)); // Creates Scanner using text file
		BinarySearchTree tempBST = new BinarySearchTree(); // Creates BST

		while(fileReader.hasNext()) {
			tempBST.insert(Integer.parseInt(fileReader.nextLine())); // Insert data from text file into the BST
		}

		return tempBST;
	}
}

class BinarySearchTree {
	protected BST_Node root;

	public BinarySearchTree() {
		root = null;
	}

	public BST_Node getRoot() {
		return this.root;
	}

	public BST_Node insert(int key) {
		BST_Node tempNode = new BST_Node(key);

		BST_Node y = null;
		BST_Node x = root;

		while(x != null) {
			y = x;
			if(key == x.getKey()) {
				return null; // Returns null when the key already exists
			}

			else if(key < x.getKey()) {
				x = x.getLeft(); // Reassigns x to be x's left if the key is less than x's current key
			}

			else {
				x = x.getRight(); // Reassigns x to be x's right if key is greater than x's current key
			}
		}

		tempNode.setParent(y); // Assigns new node's parent to be y

		if(y == null) {
			root = tempNode; // If y is null, then the list was empty. The new node is now root.
		}

		else if(key < y.getKey()) {
			y.setLeft(tempNode); // If the user input key is less than the current y's key, set the new node to left side
		}

		else {
			y.setRight(tempNode); // If the user input key is greater than the current y's key, set the new node to right side
		}

		return tempNode;
	}

	public BST_Node search(int key) {
		BST_Node temp = root;

		while(temp != null && key != temp.getKey()) { // Continues loop as long as list is not empty and key hasn't been found
			if(key < temp.getKey()) {
				temp = temp.getLeft(); // If the key is less then the current temp's key, assign temp's left to temp
			}

			else {
				temp = temp.getRight(); // If the key is greater then the current temp's key, assign temp's right to temp
			}
		}

		return temp; // temp to method call location
	}

	public BST_Node min(BST_Node subtree_root) {
		BST_Node temp = subtree_root;

		if(temp != null) { // Checks to see if the BST is empty
			while(temp.getLeft() != null) {
				temp = temp.getLeft(); // Reassigns temp to be temp's left while temp still has a left node
			}
		}

		return temp;
	}

	public BST_Node max(BST_Node subtree_root) {
		BST_Node temp = subtree_root;

		if(temp != null) { // Checks to see if the BST is empty
			while(temp.getRight() != null) {
				temp = temp.getRight(); // Reassigns temp to be temp's right while temp still has a right node
			}
		}

		return temp;
	}

	public BST_Node successor(BST_Node subtree_root) {
		if(subtree_root.getRight() != null) {
			return min(subtree_root.getRight()); // If the current subroot has a right node, find the min
		}

		BST_Node tempNode = subtree_root.getParent();

		while(tempNode != null && subtree_root == tempNode.getRight()) { // While tempNode isn't null and the subroot is equal to tempNode's right
			subtree_root = tempNode; // Reassigns subroot to be current tempNode
			tempNode = tempNode.getParent(); // Reassigns tempNode to tempNode's parent
		}

		return tempNode;
	}

	public BST_Node predecessor(BST_Node subtree_root) {
		if(subtree_root.getLeft() != null) {
			return min(subtree_root.getLeft()); // If the current subroot has a left node, find the max
		}

		BST_Node tempNode = subtree_root.getParent();

		while(tempNode != null && subtree_root == tempNode.getLeft()) { // While tempNode isn't null and the subroot is equal to tempNode's left
			subtree_root = tempNode; // Reassigns subroot to be current tempNode
			tempNode = tempNode.getParent(); // Reassigns tempNode to tempNode's parent
		}

		return tempNode;
	}

	public void InOrder_Traversal(BST_Node subtree_root) {
		if(subtree_root != null) {
			InOrder_Traversal(subtree_root.getLeft()); // Recursive call to the same method using subroot's left node
			System.out.print(subtree_root.getKey() + " "); // Prints the current subroot
			InOrder_Traversal(subtree_root.getRight()); // Recursive call to the same method using subroot's right node
		}
	}

	public void PreOrder_Traversal(BST_Node subtree_root) {
		if(subtree_root != null) {
			System.out.print(subtree_root.getKey() + " "); // Prints the current subroot
			PreOrder_Traversal(subtree_root.getLeft()); // Recursive call to the same method using subroot's left node
			PreOrder_Traversal(subtree_root.getRight()); // Recursive call to the same method using subroot's right node
		}
	}

	public void PostOrder_Traversal(BST_Node subtree_root) {
		if(subtree_root != null) {
			PostOrder_Traversal(subtree_root.getLeft()); // Recursive call to the same method using subroot's left node
			PostOrder_Traversal(subtree_root.getRight()); // Recursive call to the same method using subroot's right node
			System.out.print(subtree_root.getKey() + " "); // Prints the current subroot
		}
	}

	public void LevelOrder_Traversal(BST_Node subtree_root) {
		ListQueue Q = new ListQueue(); // Creates a FIFO Linked list
		Q.enqueue(subtree_root); // Enqueues the current subroot's reference

		while(Q.size > 0) { // Continues while the BST still has nodes to be enqueued
			BST_Node node = Q.dequeue(); // Dequeues from the FIFO Linked list
			System.out.print(node.getKey() + " "); // Prints the dequeued node's key

			if(node.getLeft() != null) {
				Q.enqueue(node.getLeft()); // Enqueues current node's left reference if it still has a left node
			}

			if(node.getRight() != null) {
				Q.enqueue(node.getRight()); // Enqueues current node's right reference if it still has a right node
			}
		}
	}

	public void transplant(BST_Node old_subtree, BST_Node new_subtree) {
		if(old_subtree == null) {
			root = new_subtree; // If the old subtree is null, assign the new subtree to be the root
		}

		else if(old_subtree == old_subtree.getParent().getLeft()) {
			old_subtree.getParent().setLeft(new_subtree); // If old tree is the parent's left child, assign the new subtree to be left
		}

		else {
			old_subtree.getParent().setRight(new_subtree); // If old tree is the parent's right child, assign the new subtree to be right
		}

		if(new_subtree != null) {
			new_subtree.setParent(old_subtree); // If the new subtree is null, set the old sub tree to be the parent
		}
	}

	public BST_Node delete(int key) { // The delete method that can be called by the user
		BST_Node z = search(key); //

		if(z != null) {
			delete(z); // If the key exists, remove it from the BST
		}

		return z;
	}

	public void delete(BST_Node z) { // The delete method that removes a node from the BST
		if(z.getLeft() == null && z.getRight() == null) {
			transplant(z, null); // If z doesn't have a right or left nodes, transplant null to where z was
		}

		else if(z.getLeft() == null) {
			transplant(z, z.getRight()); // If z has a right node, transplant z's right node to where z was
		}

		else if(z.getRight() == null) {
			transplant(z, z.getLeft()); // If z has a left node, transplant z's left node to where z was
		}

		else {
			BST_Node y = min(z.getRight()); // Find z's min and assign it to y
			if(y.getParent() != z) { // If y's parent is z
				transplant(y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
			}

			transplant(z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
		}
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
		return this.size;
	}

	public BST_Node front() {
		return this.head.getTreeNode();
	}

	public void enqueue(BST_Node tree_node) {
		Node tempNode = new Node(tree_node);
		if(this.size() == 0) {
			head = tempNode;
			tail = tempNode;
		}

		else {
			tail.setNext(tempNode);
			tail = tempNode;
		}
		size++;
	}

	public BST_Node dequeue() {
		if(size == 0) {
			throw new NoSuchElementException("The list is empty");
		}

		BST_Node ret = head.getTreeNode();
		if(size == 1) {
			head = null;
			tail = null;
		}

		else {
			head = head.getNext();
		}
		size--;

		return ret;
	}
}

class BST_Node {
	private int key;
	private BST_Node parent;
	private BST_Node left;
	private BST_Node right;

	public BST_Node(int key) {
		this(key, null, null, null);
	}

	public BST_Node(int key, BST_Node parent, BST_Node left, BST_Node right) {
		this.key = key;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}

	public int getKey() {
		return this.key;
	}

	public BST_Node getLeft() {
		return this.left;
	}

	public BST_Node getRight() {
		return this.right;
	}

	public BST_Node getParent() {
		return this.parent;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public void setLeft(BST_Node left) {
		this.left = left;
	}

	public void setRight(BST_Node right) {
		this.right = right;
	}

	public void setParent(BST_Node parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return String.valueOf(this.key);
	}
}

class Node {
	private BST_Node tree_node;
	private Node next;

	public Node(BST_Node tree_node) {
		this(tree_node, null);
	}

	public Node(BST_Node tree_node, Node next) {
		this.tree_node = tree_node;
		this.next = next;
	}

	public BST_Node getTreeNode() {
		return this.tree_node;
	}

	public Node getNext() {
		return this.next;
	}

	public void setTreeNode(BST_Node tree_node) {
		this.tree_node = tree_node;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}

interface Queue {
	public int size();
	public BST_Node front();
	public void enqueue(BST_Node item);
	public BST_Node dequeue();
}
