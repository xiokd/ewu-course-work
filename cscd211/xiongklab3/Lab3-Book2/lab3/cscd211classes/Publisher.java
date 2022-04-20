package lab3.cscd211classes;

public class Publisher implements Comparable<Publisher>
{
   private String name, city;
   
   public Publisher(final String name, final String city)
   {
      if(name == null || name.isEmpty() || city == null || city.isEmpty())
      {
         throw new IllegalArgumentException("Bad params Publisher");
      }
      
      this.name = name;
      this.city = city;
      
   }
   
   public int compareTo(Publisher pi)
   {
      if(pi == null)
      {
         throw new IllegalArgumentException("Bad params compareTo");
      }
      
      return this.name.compareTo(pi.name);      
   }
   
   public String getPubName()
   {
      return this.name;
   }
   
   public String getPubCity()
   {
      return this.city;
   }
   
   @Override
   public String toString()
   {
      String str = "";
      str = this.name + ", " + this.city;
      
      return str;
   }
   
}