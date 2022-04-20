package lab7.cscd211Inheritance;

public class TruckEngine extends Engine {
   private boolean diesel;

   public TruckEngine(final String manufacturer, final int horsePower, final boolean diesel) {
      super(manufacturer, horsePower);
      this.diesel = diesel;
   }

   @Override
   public String toString() {
      String truckString = "";
      String isDiesel = "";

      if(this.diesel == true) {
         isDiesel = " is";
      }

      else {
         isDiesel = " is NOT";
      }

      truckString = "Truck Engine - " + super.toString() + isDiesel + " a diesel engine";
      return truckString;
   }

   @Override
   public int calcOutput() {
      int dieselOutput = 0;

      if(this.diesel == true) {
         dieselOutput = super.calcOutput() / 18;
      }

      else {
         dieselOutput = super.calcOutput() / 8;
      }
      return dieselOutput;
   }
} //End of TruckEngine class
