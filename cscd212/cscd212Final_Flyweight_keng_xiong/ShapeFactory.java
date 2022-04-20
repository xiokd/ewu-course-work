// Keng Xiong

/*
 * ShapeFactory Java source file:
 *
 * This Java source file imports and implements HashMap which is then used during the creation of a circle object. This file contains
 * a method that takes in a String representing color as a parameter and then creates a circle object with it. That object is then checked
 * and if that object already exists, then it assigns the existing object to the local variable and then returns it to where it is called.
 * If the object does not already exist, then the method creates a new circle object with the String and returns it to where it is called.
 *
 */

import java.util.HashMap;

public class ShapeFactory {
	private static final HashMap circleMap = new HashMap();

	public static Shape getCircle(String color) {
		Circle circle = (Circle) circleMap.get(color);

		if(circle == null) { // If the color does not already exist, create a new circle object with that color
			circle = new Circle(color);
			circleMap.put(color, circle);
			System.out.println("Creating circle of color: " + color); // Only prints when creating a new circle object
		}

		return circle;
	}
}
