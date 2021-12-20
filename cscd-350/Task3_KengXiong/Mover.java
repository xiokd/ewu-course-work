package cs350s21task2;

public class Mover {
	private double x;
	private double y;
	private double z;
	private double heading;
	private double speedHorizontal;
	private double speedVertical;
	private double accelerationHorizontal;
	private double turnRate;
	private double headingTarget;
	private boolean headingTargetDirection;
	private double speedHorizontalTarget;


	public Mover(double x, double y, double z, double heading, double speedHorizontal
			, double speedVertical, double accelerationHorizontal, double turnRate) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.heading = heading;
		this.speedHorizontal = speedHorizontal;
		this.speedVertical = speedVertical;
		this.accelerationHorizontal = accelerationHorizontal;
		this.turnRate = turnRate;
		this.headingTarget = heading; // Initial heading target
		this.headingTargetDirection = true; // Initial heading target direction (clockwise)
		this.speedHorizontalTarget = speedHorizontal; // Initial speed horizontal target
	}

	public double getAccelerationHorizontal() {
		return this.accelerationHorizontal;
	}

	public double getHeading() {
		return this.heading;
	}

	public double getHeadingTarget() {
		return this.headingTarget;
	}

	public boolean getHeadingTargetDirection() {
		return this.headingTargetDirection;
	}

	public double getSpeedHorizontal() {
		return this.speedHorizontal;
	}

	public double getSpeedHorizontalTarget() {
		return this.speedHorizontalTarget;
	}

	public void setSpeedHorizontalTarget​(double speed) {
		this.speedHorizontalTarget = speed;
	}

	public double getSpeedVertical() {
		return this.speedVertical;
	}

	public void setSpeedVertical​(double speed) {
		this.speedVertical = speed;
	}

	public String getState() {
		String str = this.x + "," + this.y + "," + this.z + "," + this.heading 
				+ "," + this.speedHorizontal + "," + this.speedVertical;
		
		return str;
	}

	public double getTurnRate() {
		return this.turnRate;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return this.z;
	}

	public void setHeadingTarget​(double heading, boolean direction) {
		this.headingTarget = heading;
		this.headingTargetDirection = direction;
	}

	public void update() {
		if(this.getSpeedHorizontal() != this.getSpeedHorizontalTarget()) { // Checks if the current horizontal speed is different from the target speed, if so update speed
			if(this.getSpeedHorizontalTarget() > this.getSpeedHorizontal()) { // If the target speed is greater than the current speed
				this.speedHorizontal += this.accelerationHorizontal;
				if(this.getSpeedHorizontal() > this.getSpeedHorizontalTarget()) { // If the current speed exceeds the target speed after addition of the acceleration
					this.speedHorizontal = this.getSpeedHorizontalTarget();
				}
			} else { // If the target speed is less than the current speed
				this.speedHorizontal -= this.accelerationHorizontal;
				if(this.getSpeedHorizontal() < this.getSpeedHorizontalTarget()) { // If the current speed is less than the target speed after addition of the acceleration
					this.speedHorizontal = this.getSpeedHorizontalTarget();
				}
			}
		} // End of speedHorizontal update		
		
		if(this.getHeading() != this.getHeadingTarget()) { // Checks if the current heading is different from the target heading
			if(this.getHeadingTargetDirection() == true) { // If the headingTarget is true, move clockwise (add)
				if(this.getHeading() > this.getHeadingTarget()) { // If the heading is greater than the target before adding
					this.heading += this.getTurnRate();
					if(this.getHeading() > 359.0) { // If the heading is greater than 359.0 after adding, mod by 360.0
						this.heading -= 360.0;
					}
				} else { // If the heading is less than the target before adding
					this.heading += this.getTurnRate();
					if(this.getHeading() > this.getHeadingTarget()) { // If the heading is now greater than target, cap heading
						this.heading = this.getHeadingTarget();
					}
				}
			} else { // If the headingTarget is false, move counter-clockwise (subtract)
				if(this.getHeading() < this.getHeadingTarget()) { // If the heading is less than the target before subtracting
					this.heading -= this.getTurnRate();
					if(this.getHeading() < 0) { // If the heading is less than zero after subtracting, mod by 360.0
						this.heading += 360.0;
					}
				} else { // If the heading is greater than the target before subtracting
					this.heading -= this.getTurnRate();
					if(this.getHeading() < this.getHeadingTarget()) { // If the heading is now less than target, cap heading
						this.heading = this.getHeadingTarget();
					}
				}
			}
		} // End of heading update
		
		this.x += this.getSpeedHorizontal() * Math.sin(Math.toRadians(this.getHeading())); // Update X coordinate
		this.y += this.getSpeedHorizontal() * Math.cos(Math.toRadians(this.getHeading())); // Update Y coordinate
		this.z += this.getSpeedVertical(); // Update Z coordinate			
	}
}
