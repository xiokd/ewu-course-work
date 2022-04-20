package cscd212as01strategy;

public class GameCharacterAngusYoung extends GameCharacter {
	public GameCharacterAngusYoung(final GuitarType gt, final SoloActBehavior sab) {
		this.guitarType = gt;
		this.soloActBehavior = sab;
	}

	public void characterName() {
		System.out.print("Angus Young");
	}
}
