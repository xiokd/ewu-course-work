package lab8.cscd211inheritance;

public class Accountant extends Employee {
   private double parkingStipend;

   public Accountant(final String name, final double basePayrate, final double additionalPayrate, final double parkingStipend) {
      super(name, basePayrate, additionalPayrate);
      if(parkingStipend < 0.00) {
         throw new IllegalArgumentException("Parameter parkingStipend less than 0");
      }
      this.parkingStipend = parkingStipend;
   }

   public double getParkingStipend() {
      return this.parkingStipend;
   }

   public void report() {
      System.out.println("I am an Accountant. I make " + super.getSalary() + " plus a parking stipend of " + this.parkingStipend + ".");
   }

   @Override
   public String toString() {
      String str = "Accountant: " + super.toString();
      return str;
   }
} // End of Accountant class
