// Keng Xiong

/*
 * FlyweightPatterDemo Java program:
 *
 * This Java source file contains the main which creates colored circle objects and sets a location with an X and Y value
 * for that circle object. The circle object is then drawn.
 *
 */

public class FlyweightPatternDemo {
	private static final String[] colors = {"Red", "Green", "Blue", "White", "Black"}; // Private static String array for colors

	public static void main(String[] args) {
		for(int i = 0; i < 20; i++) { // Loop continues until 20 circles have been drawn
			Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor()); // Calls ShapeFactory class and returns a circle object and assigns it to local variable
			circle.setX(getRandomX()); // Calls method and assigns random X value
			circle.setY(getRandomY()); // Calls method and assigns random Y value
			circle.setRadius(100); // Sets circle to fixed radius of 100
			circle.draw(); // Calls circle class draw method
		}
	}

	  private static String getRandomColor() { // Returns random color String from String array colors
		    return colors[(int) (Math.random() * colors.length)];
		  }

		  private static int getRandomX() { // Generates and returns random number for X value
		    return (int) (Math.random() * 100);
		  }

		  private static int getRandomY() { // Generates and returns random number for Y value
		    return (int) (Math.random() * 100);
		  }
}
