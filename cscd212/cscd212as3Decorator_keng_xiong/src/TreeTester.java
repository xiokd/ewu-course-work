import holiday_decorations.*;

public class TreeTester {
	public static void main(String[] args) {
		HolidayItem mytree1 = new ColoradoBlueSpruce();
		mytree1 = new Star(mytree1); // Adds a Star
		mytree1 = new Ruffles(mytree1); // Adds Ruffles
		mytree1 = new Star(mytree1); // This will produce a message saying there is already a star
		mytree1 = new Ruffles(mytree1); // Adds Ruffles
		System.out.print(mytree1.getDescription()); // Prints the description of the tree

		System.out.println(" costs $" + mytree1.price() + "\n"); // Prints Colorado Blue Spruce

		HolidayItem mytree2 = new FraserFir();
		mytree2 = new BallsBlue(mytree2); // Adds Blue Balls
		mytree2 = new BallsRed(mytree2); // Adds Red Balls
		mytree2 = new LEDs(mytree2); // Adds LEDs
		mytree2 = new BallsSilver(mytree2); // Adds Silver Balls
		System.out.print(mytree2.getDescription()); // Prints the description of the tree

		System.out.println(" costs $" + mytree2.price() + "\n"); // Prints Fraser Fir tree

		HolidayItem mytree3 = new BalsamFir();
		mytree3 = new Ribbons(mytree3); // Adds Ribbons
		mytree3 = new Lights(mytree3); // Adds Lights
		mytree3 = new Star(mytree3); // Adds a Star
		mytree3 = new BallsBlue(mytree3); // Adds Blue Balls
		System.out.print(mytree3.getDescription()); // Prints the description of the tree

		System.out.println(" costs $" + mytree3.price() + "\n"); // Prints Balsam Fir tree

		HolidayItem mytree4 = new DouglasFir();
		mytree4 = new BallsRed(mytree4); // Adds Red Balls
		mytree4 = new Lights(mytree4); // Adds Lights
		mytree4 = new Star(mytree4); // Adds a Star
		mytree4 = new Ruffles(mytree4); // Adds Ruffles
		System.out.print(mytree4.getDescription()); // Prints the description of the tree

		System.out.println(" costs $" + mytree4.price() + "\n"); // Prints Douglas Fir tree

	}
}
