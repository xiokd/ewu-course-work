package lab3.cscd211comparators;

import java.util.Comparator;
import lab3.cscd211classes.Book;
import lab3.cscd211classes.Author;

public class FirstAuthorSort implements Comparator<Book>
{
   public int compare(Book b1, Book b2)
   {
      if(b1 == null || b2 == null)
      {
         throw new IllegalArgumentException("Bad params compare");
      }
      
      return b1.compareTo(b2);
   }
   
}   