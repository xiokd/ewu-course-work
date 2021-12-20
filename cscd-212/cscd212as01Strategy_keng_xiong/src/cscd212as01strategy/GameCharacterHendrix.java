package cscd212as01strategy;

public class GameCharacterHendrix extends GameCharacter {
	public GameCharacterHendrix(final GuitarType gt, final SoloActBehavior sab) {
		this.guitarType = gt;
		this.soloActBehavior = sab;
	}

	public void characterName() {
		System.out.print("Hendrix");
	}
}
