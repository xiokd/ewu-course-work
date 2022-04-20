package lab9.cscd211classes.players;

public class FootballPlayer extends Player implements Cloneable
{
   protected int jerseyNumber;
   protected int td;

   public FootballPlayer(final String name, final String ssn, final int salary, final String position, final int td, final int jerseyNumber) {
      super(name, ssn, salary, position);
      if(td < 0|| jerseyNumber < 0) {
         throw new IllegalArgumentException("Parameters FootballPlayer is less than zero");
      }
      this.td = td;
      this.jerseyNumber = jerseyNumber;
   }

   @Override
   public String toString() {
      String str = super.toString() + "   " + "Touchdowns: " + this.td + "   " + this.jerseyNumber;
      return str;
   }

   @Override
   public FootballPlayer clone() throws CloneNotSupportedException {
      return (FootballPlayer) super.clone();
   }
}
