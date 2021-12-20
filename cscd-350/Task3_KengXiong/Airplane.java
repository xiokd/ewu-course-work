package cs350s21task2;

public class Airplane {
	private Mover mover;
	private String id;
	
	public Airplane(final String id, final Mover mover) {
		this.id = id;
		this.mover = mover;
	}
	
	public String getID() {
		return this.id;
	}
	
	public Mover getMover() {
		return this.mover;
	}
	
	public void update() {
		this.mover.update();
	}
}
