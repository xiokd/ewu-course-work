package lab2.cscd211comparators;

import java.util.Comparator;
import lab2.cscd211classes.Person;

public class ColorComparator implements Comparator<Person>
{
   public int compare(final Person p1, final Person p2)
   {
      if(p1 == null || p2 == null)
      {
         throw new IllegalArgumentException("Bad params compare");
      }
      
      return p1.getColor().compareTo(p2.getColor());
   }
   
}
