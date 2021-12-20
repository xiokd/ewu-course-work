public class TestSauronEye {

	public static void main(String[] args) {
		EyeOfSauron eye = new EyeOfSauron();
		BadGuy saruman = new BadGuy(eye, "Saruman");
		BadGuy witchKing= new BadGuy(eye, "Witch King");

		eye.setEnemies(1, 1, 2, 0); //hobbits, elves, dwarves, men
		saruman.defeated(); //Saruman is no longer registered with the Eye
	  eye.setEnemies(4, 2, 2, 100); //only the Witch King reports on the enemies

	}

}
