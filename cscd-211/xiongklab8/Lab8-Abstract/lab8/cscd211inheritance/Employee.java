package lab8.cscd211inheritance;

public abstract class Employee implements Comparable<Employee> {
   private final double BASE;
   private String name;
   protected double salary;

   public Employee(final String name, final double basePayrate, final double additionalPayrate) {
      if(name.isEmpty() || name == null || basePayrate < 0 || additionalPayrate < 0) {
         throw new IllegalArgumentException("Parameters Employee null or empty or less than zero");
      }
      this.name = name;
      this.BASE = basePayrate;
      this.salary = this.BASE + additionalPayrate;
   }

   public double getSalary() {
      return this.salary;
   }

   public double getBaseSalary() {
      return this.BASE;
   }

   public String getName() {
      return this.name;
   }

   public String getType() {
      return this.getClass().getSimpleName();
   }

   @Override
   public String toString() {
      return this.getName();
   }

   @Override
   public int compareTo(Employee another) {
      if(another == null) {
         throw new IllegalArgumentException("Parameter compareTo null");
      }
      int res = this.getType().compareTo(another.getType());
      if(res != 0) {
         return res;
      }
      return Double.valueOf(this.getSalary()).compareTo(Double.valueOf(another.getSalary()));
   }
   public abstract void report(); // Abstract method
} //End of Employee class
