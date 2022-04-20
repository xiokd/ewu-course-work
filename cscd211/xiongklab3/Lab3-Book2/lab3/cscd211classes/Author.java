package lab3.cscd211classes;

public class Author implements Comparable<Author>
{
   private String first, last;
   
   public Author(final String first, final String last)
   {
      if(first == null || last == null || first.isEmpty() || last.isEmpty())
      {
         throw new IllegalArgumentException("Bad params Author");
      }
      
      this.first = first;
      this.last = last;
   }
   
   public int compareTo(Author pi)
   {
      if(pi == null)
      {
         throw new IllegalArgumentException("Bad params compareTo");
      }
      
      int res = this.last.compareTo(pi.last);
      
      if(res != 0)
      {
         return res;
      }
      
      return this.first.compareTo(pi.first);
      
   }
   
   public String getFirstname()
   {
      return this.first;
   }
   
   public String getLastname()
   {
      return this.last;
   }
   
   @Override
   public String toString()
   {
      String str = "";
      
      str = this.last + " " + this.first;
      
      return str;
   }
}