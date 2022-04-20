package holiday_decorations;

public class BallsSilver extends TreeDecorator {
	private HolidayItem base;

	public BallsSilver(HolidayItem base) {
		this.base = base;
		this.setStarTracker(base.getStarTracker());
		this.setStar(base.getStar(), false);
	}

	@Override
	public String getDescription() {
		return base.getDescription() + ", Silver Balls";
	}

	public int price() {
		return 3 + base.price();
	}
}
