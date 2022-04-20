package lab8.cscd211comparators;

import java.util.*;
import lab8.cscd211inheritance.*;

public class SalaryComparator implements Comparator<Employee>
{
   public int compare(Employee e1, Employee e2)
   {
      if(e1 == null || e2 == null)
      {
         throw new IllegalArgumentException("Parameters compare null");
      }
      
      return Double.valueOf(e1.getSalary()).compareTo(Double.valueOf(e2.getSalary()));
   }
}