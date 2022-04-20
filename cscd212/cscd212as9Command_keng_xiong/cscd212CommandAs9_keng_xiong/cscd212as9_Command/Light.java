package cscd212as9_Command;

public class Light {
	String location = null;
	
	public Light(String location) {
		this.location = location;
	}
	
	public void on() {
		System.out.println(location + " light is on"); // Prints out location and String
	}
	
	public void off() {
		System.out.println(location + " light is off"); // Prints out location and String
	}
}
