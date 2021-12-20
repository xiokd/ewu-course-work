package holiday_decorations;

public class Lights extends TreeDecorator {
	private HolidayItem base;

	public Lights(HolidayItem base) {
		this.base = base;
		this.setStarTracker(base.getStarTracker());
		this.setStar(base.getStar(), false);
	}

	@Override
	public String getDescription() {
		return base.getDescription() + ", Lights";
	}

	public int price() {
		return 5 + base.price();
	}
}
