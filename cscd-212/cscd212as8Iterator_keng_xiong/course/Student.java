package course;

public class Student {
	private String firstName;
	private String lastName;
	private double gpa;

	public Student(String firstName, String lastName, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gpa = gpa;
	}

	public void setFirst(String first) {
		this.firstName = first;
	}
	
	public void setLast(String last) {
		this.lastName = last;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	@Override
	public String toString() {
		String str = this.firstName + " " + this.lastName + " " + this.gpa;
		return str;
	}

}//end Student class
