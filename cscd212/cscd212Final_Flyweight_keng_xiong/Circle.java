// Keng Xiong

/*
 * Circle Java source file:
 *
 * This Java source file contains the constructor and methods for a circle object. This file also implements the Shape interface
 * and overrides its methods.
 *
 */

public class Circle implements Shape {
	private String color;
	private int x;
	private int y;
	private int radius;

	public Circle(String color) { // Object constructor
		this.color = color;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() { // Overridden method from Shape interface
		System.out.println("Circle: Draw() [Color: " + color + ", x: "
				+ x + ", y: " + y + ", radius: " + radius);
	}
}
