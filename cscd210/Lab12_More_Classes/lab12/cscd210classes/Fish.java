package lab12.cscd210classes;

public class Fish implements Comparable<Fish>
{
   private String type;
   private double weight;
      
   public Fish(final String type, final double weight)
   {
      if(type == null || type.isEmpty() || weight <= 0)
      {
         throw new IllegalArgumentException("Bad params Fish");
      }
      
      this.type = type;
      this.weight = weight;
   }
      
   public double getWeight()
   {
      return this.weight;
   }
      
   public String getType()
   {
      return this.type;
   }
      
   public void setWeight(final double weight)
   {
      if(weight <= 0)
      {
         throw new IllegalArgumentException("Weight cannot be less than or equal to zero");
      }
      this.weight = weight;
   }
      
   public void setType(final String type)
   {
      if(type == null || type.isEmpty())
      {
         throw new IllegalArgumentException("Type cannot be null or empty");
      }
      this.type = type;
   }
      
   @Override
   public boolean equals(final Object obj)
   {
      if(obj == null)
      {
         return false;
      }
            
      if(obj == this)
      {
         return true;
      }
            
      if(!(obj instanceof Fish))
      {
         return false;
      }
            
      Fish another = (Fish)obj;
            
      boolean res = this.type.equals(another.type) && Double.valueOf(this.weight).equals(Double.valueOf(another.weight));
            
      return res;
            
      }
      
   @Override
   public int hashCode()
   {
      int res = (int)(this.weight * 100) + this.type.hashCode();
            
      return res;
   }
      
   @Override
   public int compareTo(final Fish another)
   {
      if(another == null)
      {
         throw new IllegalArgumentException("Fish cannot equal null");
      }
            
      int res = this.type.compareTo(another.type);
            
      if(res != 0)
      {
         return res;
      }
            
      return (int)(this.weight * 100) - (int)(another.weight * 100);
   }
      
   @Override
   public String toString()
   {
       String str = this.type + " - " + this.weight;
             
       return str;
   }
      
      
}