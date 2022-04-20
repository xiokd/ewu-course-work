package lab7.cscd211Inheritance;

public class Engine implements Comparable<Engine> {
   private String manufacturer;
   protected int horsePower;

   public Engine(final String manufacturer, final int horsePower) {
      if(manufacturer == null || horsePower <= 0) {
         throw new IllegalArgumentException("Manufacturer is null or horsePower is less or equal to zero");
      }
      this.manufacturer = manufacturer;
      this.horsePower = horsePower;
   }

   public Engine(final int horsePower, final String manufacturer) {
      if(manufacturer == null || horsePower <= 0) {
         throw new IllegalArgumentException("Manufacturer is null or horsePower is less or equal to zero");
      }
      this.manufacturer = manufacturer;
      this.horsePower = horsePower;
   }

   @Override
   public String toString() {
      String str = "";
      str = "Manufacturer: " + this.manufacturer + " with HP of " + this.horsePower;
      return str;
   }

   public int calcOutput() {
      int output = this.horsePower / 5;
      return output;
   }

   public String getManufacturer() {
      return this.manufacturer;
   }

   public int compareTo(Engine pi) {
      int res = this.horsePower - pi.horsePower;
      if(res != 0) {
         return res;
      }
      return this.manufacturer.compareTo(pi.manufacturer);
   }
} //End of Engine class
