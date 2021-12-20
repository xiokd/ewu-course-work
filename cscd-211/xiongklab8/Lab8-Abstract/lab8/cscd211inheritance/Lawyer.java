package lab8.cscd211inheritance;

public class Lawyer extends Employee
{
   private int stockOptions;

   public Lawyer(final String name, final double basePayrate, final double additionalPayrate, final int stockOptions) {
      super(name, basePayrate, additionalPayrate);
      if(stockOptions < 0) {
         throw new IllegalArgumentException("Parameter stockOptions less than 0");
      }
      this.stockOptions = stockOptions;
   }

   public int getStockOptions() {
      return this.stockOptions;
   }

   public void report() {
      System.out.println("I am a Lawyer. I make " + super.getSalary() + " and I have " + this.stockOptions + " shares of stock.");
   }

   @Override
   public String toString() {
      String str = "Lawyer: " + super.toString();
      return str;
   }
} // End of Lawyer class
