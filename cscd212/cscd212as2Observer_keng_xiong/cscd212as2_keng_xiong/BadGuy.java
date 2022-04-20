public class BadGuy implements Observer, DisplayElement{
	private Subject eye;
	private String name;
	private int hobbit;
	private int elve;
	private int dwarve;
	private int human;

	public BadGuy(Subject eye, String name) {
		this.eye = eye;
		this.name = name;
		eye.registerObserver(this);
	}

	public void defeated() {
		System.out.println(name + " was defeated!\n");
		eye.removeObserver(this);
	}

	public void update(int hobbit, int elve, int dwarve, int human) {
		this.hobbit = hobbit;
		this.elve = elve;
		this.dwarve = dwarve;
		this.human = human;
		display();
	}

	public void display() {
		System.out.println(name + " knows about -");
		System.out.println("\t" + hobbit + " Hobbits");
		System.out.println("\t" + elve + " Elves");
		System.out.println("\t" + dwarve + " Dwarves");
		System.out.println("\t" + human + " Humans\n");
	}
}
