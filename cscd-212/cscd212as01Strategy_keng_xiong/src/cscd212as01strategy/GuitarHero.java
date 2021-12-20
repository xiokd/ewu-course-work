package cscd212as01strategy;

public class GuitarHero {

	public static void main(String[] args) {
		/*
		 * Constructors for all three game characters accept behaviors as parameters to
		 * create GameCharacter objects
		 * 
		 */
		GameCharacter player1 = new GameCharacterSlash(new GibsonSG(), new JumpOffStage());
		GameCharacter player2 = new GameCharacterHendrix(new FenderTelecaster(), new SmashGuitar());
		GameCharacter player3 = new GameCharacterAngusYoung(new GibsonFlyingV(), new GuitarOnFire());

		player1.playGuitar(); // Prints Slash is playing a Gibson SG
		player1.playSolo(); // Prints Slash jumped off the stage

		player2.playGuitar(); // Prints Hendrix is playing on a Fender Telecaster
		player2.playSolo(); // Prints Hendrix smashed the guitar

		player3.playGuitar(); // Prints Angus Young is playing on a Gibson Flying V
		player3.playSolo(); // Prints Angus Young set the guitar on fire

		player1.setGuitar(new GibsonFlyingV()); // Sets the guitar for Slash to Gibson Flying V
		player1.setSolo(new GuitarOnFire()); // Sets the solo act for Slash to set the guitar on fire

		player2.setGuitar(new GibsonSG()); // Sets the guitar for Hendrix to Gibson SG
		player2.setSolo(new JumpOffStage()); // Sets the solo act for Hendrix to jumped off the stage

		player3.setGuitar(new FenderTelecaster()); // Sets the guitar for Angus Young to Fender Telecaster
		player3.setSolo(new SmashGuitar()); // Sets the solo act for Angus Young to smashed the guitar

		player1.playGuitar(); // Prints Slash is playing on a Gibson Flying V
		player1.playSolo(); // Prints Slash set the guitar on fire

		player2.playGuitar(); // Prints Hendrix is playing on a Gibson SG
		player2.playSolo(); // Prints Hendrix jumped off the stage

		player3.playGuitar(); // Prints Angus Young is playing on a Fender Telecaster
		player3.playSolo(); // Prints Angus Young smashed the guitar

	}// End of main
} // End of Class
