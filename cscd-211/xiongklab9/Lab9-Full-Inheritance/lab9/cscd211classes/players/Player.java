package lab9.cscd211classes.players;

public abstract class Player implements Cloneable {
   protected String name;
   protected String ssn;
   protected String position;
   protected int salary;

   protected Player(final String name, final String ssn, final int salary, final String position) {
      if(name == null || name.isEmpty() || ssn == null || ssn.isEmpty() || position == null || position.isEmpty()) {
         throw new IllegalArgumentException("Parameters Player null or empty");
      }
      this.name = name;
      this.ssn = ssn;
      this.salary = salary;
      this.position = position;
   }

   public int getSalary() {
      return this.salary;
   }

   public String getPosition() {
      return this.position;
   }

   public String getName() {
      return this.name;
   }

   public String getSSN() {
      return this.ssn;
   }

   @Override
   public String toString() {
      String str = "";
      str = this.name + " " + this.ssn + " " + this.salary + " " + this.position;
      return str;
   }

   @Override
   public Player clone() throws CloneNotSupportedException {
      return (Player) super.clone();
   }
}
