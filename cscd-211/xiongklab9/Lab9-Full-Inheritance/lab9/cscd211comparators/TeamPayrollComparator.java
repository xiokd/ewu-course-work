package lab9.cscd211comparators;

import java.util.*;
import lab9.cscd211classes.*;

public class TeamPayrollComparator implements Comparator<Team>
{
   public int compare(Team t1, Team t2)
   {
      if(t1 == null || t2 == null)
      {
         throw new IllegalArgumentException("Parameters compare is null");
      }
      
      return t1.getPayroll() - t2.getPayroll();
   }
}