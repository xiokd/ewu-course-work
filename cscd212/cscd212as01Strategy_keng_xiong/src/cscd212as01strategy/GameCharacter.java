package cscd212as01strategy;

public abstract class GameCharacter {
	GuitarType guitarType;
	SoloActBehavior soloActBehavior;

	public GameCharacter() {
	}

	public abstract void characterName();

	public void playGuitar() {
		characterName();
		guitarType.guitar();
	}

	public void playSolo() {
		characterName();
		soloActBehavior.soloAct();
	}

	public void setSolo(SoloActBehavior sab) {
		soloActBehavior = sab;
	}

	public void setGuitar(GuitarType gt) {
		guitarType = gt;
	}
}
