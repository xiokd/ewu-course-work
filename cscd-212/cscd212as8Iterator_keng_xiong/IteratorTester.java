import java.util.ArrayList;
import java.util.Iterator;
import course.*;

public class IteratorTester {

	public static void main(String[] args) {
		Course cscd212 = new Course();

		cscd212.addStudent(new Student("Nancy","Ripplinger", 3.14));
		cscd212.addStudent(new Student("Tom","Capaul", 3.141));
		cscd212.addStudent(new Student("Sponge Bob","Square Pants", 4.0));
		cscd212.addStudent(new Student("Patrick","Star", 0.7));

		// Loop implicitly
		System.out.println("Students in Course via foreach loop, implicitly uses Iterator");
		for(Student s: cscd212) {
			System.out.println(s); // Prints out all the contents
		}

		// Loop manually
		System.out.println("Students in Course by manually using Iterator behaviors (next and hasNext)");
		Iterator<Student> studentIterator = cscd212.iterator();
		while(studentIterator.hasNext()) {
			System.out.println(studentIterator.next()); // Prints out all the contents
		}

	}//End main
}// End of Class
