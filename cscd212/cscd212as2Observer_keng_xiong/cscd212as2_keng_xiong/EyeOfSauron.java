import java.util.*;

public class EyeOfSauron implements Subject {
	private ArrayList observers;
	private int hobbit;
	private int elve;
	private int dwarve;
	private int human;

	public EyeOfSauron() {
		observers = new ArrayList();
	}

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i >= 0) {
			observers.remove(i);
		}
	}

	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(hobbit, elve, dwarve, human);
		}
	}

	public void numberChanged() {
		notifyObservers();
	}

	public void setEnemies(final int hobbit, final int elve, final int dwarve, final int human) {
		this.hobbit = hobbit;
		this.elve = elve;
		this.dwarve = dwarve;
		this.human = human;
		numberChanged();
	}

}
