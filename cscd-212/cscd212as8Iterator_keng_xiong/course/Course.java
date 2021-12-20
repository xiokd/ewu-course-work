package course;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * This is a collection class: it will hold 0 or more items
 * in this case of type Student
 * 
 * In order to use an enhanced for loop (also called foreach)
 * the class must implement the Iterable interface which requires
 * the class provides a method called iterator which returns
 * an object from a class that implements the Iterator interface
 * and 'knows' how to walk through (iterate through) the collection
 * class
 * 
 * Note that since the underlying data we will iterate across is
 * of type Student, we specify that type when we implement both
 * the Iterable and Iterator interfaces
 */
public class Course implements Iterable<Student> {
	private ArrayList<Student> students;
	
	public Course() {
		this.students = new ArrayList<Student>();
	}
	
	public void addStudent(Student student) {
		if(student == null) {
			throw new IllegalArgumentException("Method addStudent parameters is null");
		}
		this.students.add(student);
	}

	@Override
	public String toString() {
		String result = "";
		
		result += "Student count: " + this.students.size() + "\n";
		
		//LOOK!  Taking advantage of Iterator provided by ArrayList to use
		// enhanced for loop (foreach loop)
		for (Student s: this.students) {
			result += s + "\n";
		}
		
		return result;		
	}
	
	@Override
	public Iterator<Student> iterator() {
		return new CourseIterator(this.students);
	}
	
	/* nested class that provides Iterator
	 * This class must implement the Iterator interface and 
	 * provide a means to walk through (iterate across) the data
	 * in the collection class (Course).  
	 * 
	 * The class knows how to walk through the data in the collection
	 * class one step at a time.  It keeps track of the current location
	 * in the collection.  It thus 'knows' if there are more items in
	 * the collection (via the hasNext behavior/method).  It can return
	 * the next item in the collection via the next behavior/method.
	 * 
	 * Note that you can have as many iterator objects (CourseIterator in this
	 * case) as you want for a given collection object instance. Each
	 * iterator keeps track of its location in the underlying collection
	 * as the given iterator is used to traverse the collection.
	 * 
	 * Having multiple iterators across the same collection object
	 * allows for multi-threading and parallel processing which can
	 * greatly improve application performance.
	 * 
	 * Even without concerns about utilizing multiple iterators and
	 * parallel processing, an iterator class gives us the ability
	 * to traverse a collection class without having to know the
	 * underlying representation of the collection (array, linked list,
	 * ArrayList, tree, graph, etc.). The iterator class encapsulates
	 * knowledge of how to traverse the collection so that other things
	 * don't need to worry about it.  This is creates loosely coupled
	 * designs, which allows for cleaner software.
	 * 
	 */
	public class CourseIterator implements Iterator<Student>{
		private int cur;
		private ArrayList<Student> studentRef;
		
		private CourseIterator(ArrayList<Student> students) {
			this.studentRef = students;
			this.cur = 0;
		}
		
		@Override
		public boolean hasNext() {
			return this.cur < this.studentRef.size();
		}
		
		public Student next() {
			if(hasNext() ) { 
				Student nextStudent = this.studentRef.get(this.cur);
				this.cur++;
				return nextStudent;
			} else {
				throw new NoSuchElementException("Next method called with no more students in the collection");
			}
		}
		
	}//end CourseIterator class

}//end Course class

