package lab8.cscd211inheritance;

public class Programmer extends Employee
{
   private boolean busPass;

   public Programmer(final String name, final double basePayrate, final double additionalPayrate, final boolean busPass) {
      super(name, basePayrate, additionalPayrate);
      this.busPass = busPass;
   }

   public boolean getBusPass() {
      return this.busPass;
   }

   public void report() {
      String passStatus = "";
      if(busPass == true) {
         passStatus = "I get a bus pass.";
      }

      else {
         passStatus = "I do not get a bus pass.";
      }

      System.out.println("I am a Programmer. I make " + super.getSalary() + " and " + passStatus);
   }

   @Override
   public String toString() {
      String str = "Programmer: " + super.toString();
      return str;
   }
} // End of Programmer class
