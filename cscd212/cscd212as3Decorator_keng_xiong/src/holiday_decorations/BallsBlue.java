package holiday_decorations;

public class BallsBlue extends TreeDecorator {
	private HolidayItem base;

	public BallsBlue(HolidayItem base) {
		this.base = base;
		this.setStarTracker(base.getStarTracker());
		this.setStar(base.getStar(), false);
	}

	@Override
	public String getDescription() {
		return base.getDescription() + ", Blue balls";
	}

	public int price() {
		return 2 + base.price();
	}
}
