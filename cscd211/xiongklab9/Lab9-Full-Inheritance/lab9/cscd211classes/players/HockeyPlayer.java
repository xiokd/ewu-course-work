package lab9.cscd211classes.players;

public class HockeyPlayer extends Player implements Cloneable {
   protected int jerseyNumber;

   public HockeyPlayer(final String name, final String ssn, final int salary, final String position, final int jerseyNumber) {
      super(name, ssn, salary, position);
      if(jerseyNumber < 0) {
         throw new IllegalArgumentException("Parameters HockeyPlayer less than zero");
      }
      this.jerseyNumber = jerseyNumber;
   }

   @Override
   public String toString() {
      String str = super.toString() + " Jersey Number: " + this.jerseyNumber;

      return str;
   }

   @Override
   public HockeyPlayer clone() throws CloneNotSupportedException {
      return (HockeyPlayer) super.clone();
   }
}
