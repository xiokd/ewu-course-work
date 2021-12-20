package holiday_decorations;

public class Ribbons extends TreeDecorator {
	private HolidayItem base;
	
	public Ribbons (HolidayItem base) {
		this.base = base;
		this.setStarTracker(base.getStarTracker());
		this.setStar(base.getStar(), false);
	}

	@Override
	public String getDescription() {
		return base.getDescription() + ", Ribbons";
	}

	public int price() {
		return 2 + base.price();
	}
}
