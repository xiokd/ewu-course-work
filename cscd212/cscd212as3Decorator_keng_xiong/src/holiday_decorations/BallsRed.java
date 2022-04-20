package holiday_decorations;

public class BallsRed extends TreeDecorator {
	private HolidayItem base;

	public BallsRed(HolidayItem base) {
		this.base = base;
		this.setStarTracker(base.getStarTracker());
		this.setStar(base.getStar(), false);
	}
	
	@Override
	public String getDescription() {
		return base.getDescription() + ", Red Balls";
	}

	public int price() {
		return 1 + base.price();
	}
}
