package lab1.cscd210comparators;

import java.util.Comparator;
import lab1.cscd210classes.Book;

public class BookISBNComparator implements Comparator<Book> {
   public int compare(final Book o1, final Book o2) {
      if(o1 == null || o2 == null)
         throw new IllegalArgumentException("Bad params compare");

      return o1.getISBN().compareTo(o2.getISBN());
   }
}
