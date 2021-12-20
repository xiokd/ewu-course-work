package cscd212as01strategy;

public class GameCharacterSlash extends GameCharacter {
	public GameCharacterSlash(final GuitarType gt, final SoloActBehavior sab) {
		this.guitarType = gt;
		this.soloActBehavior = sab;
	}

	public void characterName() {
		System.out.print("Slash");
	}
}
