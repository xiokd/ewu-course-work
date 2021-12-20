package holiday_decorations;

public abstract class HolidayItem {
	String description = "Unknown Holiday Item";
	private boolean starInstance = false;
	private boolean starTracker = false;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract int price();

	public void setStar(boolean star, boolean starStatus) {
		if(star == true && starStatus == true) {
			this.setStarTracker(true);
		}

		if(starStatus == false) {
			this.starInstance = star;
		}

		else {
			this.starInstance = starStatus;
		}
	}

	public boolean getStar() {
		return this.starInstance;
	}

	public void setStarTracker(boolean trackStatus) {
		this.starTracker = trackStatus;
	}

	public boolean getStarTracker() {
		return this.starTracker;
	}
}
