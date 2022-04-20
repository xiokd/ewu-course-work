package lab7.cscd211Inheritance;

public class CarEngine extends Engine {
   public CarEngine(final String manufacturer, final int horsePower) {
      super(manufacturer, horsePower);
   }

   public CarEngine(final int horsePower, final String manufacturer) {
      super(horsePower, manufacturer);
   }

   @Override
   public String toString() {
      String carString= "Car Engine - " + super.toString();
      return carString;
   }

   @Override
   public int calcOutput() {
      int output = super.calcOutput() / 12;
      return output;
   }
}
