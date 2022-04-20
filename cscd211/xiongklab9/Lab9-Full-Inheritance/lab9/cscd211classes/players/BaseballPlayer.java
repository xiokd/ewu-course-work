package lab9.cscd211classes.players;

public class BaseballPlayer extends Player implements Cloneable
{
   protected double batAvg;

   public BaseballPlayer(final String name, final String ssn, final int salary, final String position, final double batAvg) {
      super(name, ssn, salary, position);
      if(batAvg < 0) {
         throw new IllegalArgumentException("Parameters BaseballPlayer is less than zero");
      }
      this.batAvg = batAvg;
   }

   @Override
   public String toString() {
      String str = super.toString() + " Batting Avg: " + this.batAvg;
      return str;
   }

   @Override
   public BaseballPlayer clone() throws CloneNotSupportedException {
      return (BaseballPlayer) super.clone();
   }
}
