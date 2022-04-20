package lab5.cscd211linkedlist;

import java.util.*;

/**
 * The LinkedList class and Node class.  All parameters will be passed as final.
 *
 * @param <T> A type that implements Comparable and a compareTo method using the Generic
 * @NOTE T item is just a different word for data
 */
public class LinkedList<T extends Comparable <? super T>> {
   private static class Node<T> {
      public T data;
      public Node next;

      public Node() {
    	  this.data = null;
    	  this.next = null;
      }

      public Node(final T data) {
         this(data, null);
      }

      public Node(final T data, final Node next) {
         this.data = data;
         this.next = next;
      }
   }// end class Node

   private Node head;
   private int size;

   /**
    * Constructs a list with no dummy head node containing the elements of the
    * specified array, that are in the order the array.
    *
    * @param array Representing the T array
    *
    * @throws IllegalArgumentException if the array is null
    */
   public LinkedList(final T [] array)
   {
      if(array == null)
      {
         throw new IllegalArgumentException("Bad params LinkedList");
      }

      this.head = null;
      this.size = array.length;

      for(int i = 0; i < array.length; i++)
      {
         Node nn = new Node(array[i]);
         nn.next = this.head;
         this.head = nn;
      }

   }// end EVC


   /**
    * Inserts the specified element at the beginning of this list.
    *
    * @param item The item to add
    *
    * @throws IllegalArgumentException if item is null
    */
   public void addFirst(final T item) {
      if(item == null) {
         throw new IllegalArgumentException("Bad params addFirst");
      }

      Node nn = new Node(item);
      nn.next = this.head;
      this.head = nn;
      this.size++;
   }// end addFirst


   /**
    * Appends the specified element to the end of this list.
    *
    * @param item The element to be appended to this list
    *
    * @throws IllegalArgumentException if item is null
    */
   public void add(final T item) {
      if(item == null) {
         throw new IllegalArgumentException("Bad params add");
      }

      Node nn = new Node(item);
      Node cur = this.head;

      while(cur.next != null) {
         cur = cur.next;
      }

      nn.next = cur.next;
      cur.next = nn;
      this.size++;
   }// end add

   /**
    * Inserts all of the elements in the specified array into this list,
    * starting at the specified position. Shifts the element currently at that position
    * (if any) and any subsequent elements to the right (increases their indices).
    * The new elements will appear in the list in the order that they were in the array
    *
    * @param index at which to insert the first element from the specified array
    * @param array containing elements to be added to this list
    *
    * @throws IllegalArgumentException if the array is null
    * @throws IndexOutOfBoundsException if index less than 0 or greater than size
    */
   public void addAll(final int index, final T [] array) {
      if(array == null) {
         throw new IllegalArgumentException("Bad params addAll");
      }

      if(index < 0 || index > this.size) {
         throw new IndexOutOfBoundsException("Index is less than 0 or greater than size");
      }

      int listIndex = index;

      for(int i = 0; i < array.length; i++) {
         int counter = 0;
         Node nn = new Node(array[i]);
         Node cur = this.head;
         Node prev = null;

         while(cur != null && counter < index) {
            prev = cur;
            cur = cur.next;
            counter++;
         }

         if(prev == null){
            nn.next = this.head;
            this.head = nn;
            this.size++;
         }
         else {
            nn.next = cur;
            prev.next = nn;
            this.size++;
         }
      }
   }// end addAll

   /**
    * Removes all of the elements from this list.
    * The list will be empty after this call returns.
    */
   public void clear() {
      this.size = 0;
      this.head = null;
   }// end clear

   /**
    * Returns the element at the specified position in this list.
    *
    * @param index The index of the element to return
    * @return T The element at the specified position in this list
    *
    * @throws IndexOutOfBoundsException if index is less than 0 or greater than or equal to size
    */
   public T get(final int index) {
      if(index < 0 || index >= size) {
         throw new IndexOutOfBoundsException("Index is less than 0 or greater than size");
      }

      int counter = 0;

      Node<T> cur = this.head;

      while(cur != null && counter < index) {
         cur = cur.next;
         counter++;
      }
      return cur.data;
   }// end get

   /**
    * Returns the last element in this list.
    *
    * @return The last element in the list
    *
    * @throws NoSuchElementException if the list is empty
    */
   public T getLast() {
      if(this.head == null) {
         throw new NoSuchElementException("The list is empty");
      }

      int counter = 0;
      int listLast = this.size - 1;

      Node<T> cur = this.head;

      while(cur != null && counter < listLast) {
         cur = cur.next;
         counter++;
      }
      return cur.data;
   }// end getLast

   /**
    * Retrieves and removes the head (first element) of this list.
    *
    * @return The head element in the list
    *
    * @throws NoSuchElementException if the list is empty
    */
   public T remove() {
      if(this.head == null) {
         throw new NoSuchElementException("The list is empty");
      }

      Node<T> cur = this.head;
      Node<T> nn = new Node(cur.data);
      this.head = cur.next;

      cur.data = null;
      cur.next = null;
      this.size--;

      return nn.data;
   }// end remove



   /**
    * Returns true if all occurrences of data are removed from the list or false otherwise
    *
    * @param data The value for all occurrences to be removed from the list
    * @return boolean Representing if the list was modified or not
    *
    * @throws IllegalArgumentException if data is null
    */
   public boolean removeAllOccurrences(final T data) {
      if(data == null) {
         throw new IllegalArgumentException("Bad params removeAllOccurrences");
      }

      Node<T> cur = this.head, prev = null;
      int counter = 0;

      if(cur.data.equals(data)) {
         this.head = cur.next;
         cur.data = null;
         cur.next = null;
         this.size--;
         counter++;
         cur = this.head;
      } // Checks the first index of the Linked Listed

      while(cur.next != null) {
         prev = cur;
         cur = cur.next;

         if(cur.data.equals(data)) {
            prev.next = cur.next;
            cur.data = null;
            cur.next = null;
            this.size--;
            cur = this.head;
            counter++;
         }
      } // Checks every other index of the Linked List

      if(counter != 0) {
         return true;
      } // If there are any changes to the Linked List
      return false;
   }// end removeAllOccurrences


	/**
	 * Removes and returns the last element from this list.
	 *
	 * @return T the last element from the list
	 *
	 * @throws NoSuchElementException if this list is empty
	 */
	public T removeLast() {
      if(this.head == null) {
         throw new NoSuchElementException("The list is empty");
      }

      int counter = 0;
      int listLast = this.size - 1;

      Node<T> cur = this.head, prev = null;

      while(cur != null && counter < listLast) {
         prev = cur;
         cur = cur.next;
         counter++;
      }

      prev.next = null;
      Node<T> nn = new Node(cur.data);
      cur.data = null;
      cur.next = null;
      this.size--;

      return nn.data;
	}// end removeLast

	/**
	 * Removes the element at the specified position in this list.
	 * Shifts any subsequent elements to the left (subtracts one from their indices).
	 * Returns the element that was removed from the list.
	 *
	 * @param index the index of the element to be removed
	 * @return T The element previously at the specified position
	 *
	 * @throws IndexOutOfBoundsException if index is less than 0 or greater than or equal to size
	 */
	public T remove(int index) {
      if(index < 0 || index >= size) {
         throw new IndexOutOfBoundsException("Index is less than 0 or greater than size");
      }

      int counter = 0;
      Node<T> cur = this.head, prev = null;

      while(cur != null && counter < index) {
         prev = cur;
         cur = cur.next;
         counter++;
      }

      if(counter == 0) {
         prev = cur;
         this.head = prev.next;
      }

      prev.next = cur.next;
      Node<T> nn = new Node(cur.data);
      cur.data = null;
      cur.next = null;
      this.size--;

      return nn.data;
	}// end remove



   /**
    * Returns the number of elements in this list.
    *
    * @return int The size
    */
   public int size() {
      return this.size;
   }// end size

   /**
    * Returns an array containing all of the elements in this list in proper
    * sequence (from first to last element).
    *
    * <br> The returned array will be "safe" in that no references to it are maintained
    * by this list. (In other words, this method must allocate a new array).
    * The caller is thus free to modify the returned array.
    *
    * @return Object [] an array containing all of the elements in this list in proper sequence
    */
   public Object [] toArray() {
      Object [] array = new Object[this.size];
      Node cur = this.head;
      int counter = 0;

      for(int i = 0; i < array.length; i++)
      {
         array[i] = cur.data;
         cur = cur.next;
      }

      return array;
   }  // end toArray


   /**
    * Returns the contents of the list in the format [item, item, item]
    * or Empty List if the list is empty
    *
    * @return String Representing the contents of the list
    */
   @Override
   public String toString() {
      String str = "";

      if(this.head == null) {
         str = "Empty list";
         return str;
      }

      for(Node cur = this.head; cur != null; cur = cur.next) {
         str += cur.data + " ";
      }
      str += "\n"
      return str;
   }// end toString
}// end list
