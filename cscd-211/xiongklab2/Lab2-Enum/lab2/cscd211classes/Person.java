package lab2.cscd211classes;

import lab2.cscd211enums.Color;

public class Person implements Comparable<Person>
{
   private Color color;
   private String fn, ln;
   
   public Person(final String fn, final String ln, final Color color)
   {
      if(ln == null || fn == null || color == null)
      {
         throw new IllegalArgumentException("Bad params Person");
      }
      
      this.fn = fn;
      this.ln = ln;
      this.color = color;
      
   }
   
   public int compareTo(Person another)
   {
      if(another == null)
      {
         throw new IllegalArgumentException("Bad params compareTo");
      }
      
      int res1 = this.ln.compareTo(another.ln);
      int res2 = this.fn.compareTo(another.fn);
      
      if(res1 != 0)
      {
         return res1;
      }

      if(res2 != 0)
      {
         return res2;
      }
      
      return color.compareTo(another.color);      

   }
   
   public Color getColor()
   {
      return this.color;
   }
   
   @Override
   public String toString()
   {
      String str = "";
      
      str = this.fn + " " + this.ln + ", " + this.color;
      
      return str;
      
   }
}