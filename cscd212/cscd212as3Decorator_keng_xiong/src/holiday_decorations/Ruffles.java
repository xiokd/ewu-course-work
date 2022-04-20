package holiday_decorations;

public class Ruffles extends TreeDecorator {
	private HolidayItem base;

	public Ruffles(HolidayItem base) {
		this.base = base;
		this.setStarTracker(base.getStarTracker());
		this.setStar(base.getStar(), false);
	}

	@Override
	public String getDescription() {
		return base.getDescription() + ", Ruffles";
	}

	public int price() {
		return 1 + base.price();
	}
}
