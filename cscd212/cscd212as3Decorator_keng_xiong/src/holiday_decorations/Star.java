package holiday_decorations;

public class Star extends TreeDecorator {
	private HolidayItem base;

	public Star(HolidayItem base) {
		this.base = base;
		this.setStarTracker(base.getStarTracker());
		this.setStar(base.getStar(), true);
	}

	@Override
	public String getDescription() {
		if(base.getStar() == false) {
			return base.getDescription() + ", Star";
		}
		else {
			System.out.println("This tree already has a star!");
			return base.getDescription();
		}
	}

	public int price() {
		if(base.getStar() == false) {
			return 4 + base.price();
		}
		else {
			return base.price();
		}
	}
}
