package lab8.cscd211comparators;

import java.util.*;
import lab8.cscd211inheritance.*;

public class NameComparator implements Comparator<Employee>
{
   public int compare(Employee e1, Employee e2)
   {
      if(e1 == null || e2 == null)
      {
         throw new IllegalArgumentException("Parameters compare null");
      }
      
      return e1.getName().compareTo(e2.getName());
   }
}