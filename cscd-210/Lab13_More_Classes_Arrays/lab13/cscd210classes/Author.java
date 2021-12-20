package lab13.cscd210classes;


/**
 * A basic Author class
 * @NOTE All parameters are passed as final and all preconditions are met
 * @NOTE You must have at Override on toString, equals, hashCode and compareTo
 * @NOTE You must use the Generic for Comparable
 */
public class Author implements Comparable<Author>
{  
   /**
    * Private String for the first name
    */
   private String first;    
   /**
    * Private String for the last name
    */
   private String last;
   /**
    * Private String for the publisher
    */
   private String publisher;   
   
   /**
    * The constructor that sets the parameters
    * @param last Representing the last name
    * @param first Representing the first name
    * @param publisher Representing the publisher
    * @throws IllegalArgumentException if any of the strings are null or empty
    */
   public Author(final String last, final String first, String publisher)
   {
      this.first = first;
      this.last = last;
      this.publisher = publisher;
   
   }
   
   /**
    * The toString returns a String of this first name space this last name space dash space this publisher
    * @return String Representing this first name space this last name space dash space this publisher
    */   
   @Override   
   public String toString()
   {
      String str = "";
      str = this.first + " " + this.last + " - " + this.publisher;
      
      return str;
   }
   
   
   /**
    * The compareTo method first compares by last name.  If last names are the
    * same then it compares based on first names.  If first names
    * are the same then it compares based on publisher
    * @param another Representing the other Author object
    * @return int Representing the order guaranteed to be less than 0, greater than 0 or equal to 0
    * @throws IllegalArgumentException if another is null
    */ 
   public int compareTo(final Author another)
   {
      if(another == null)
      {
         throw new IllegalArgumentException("Bad params compareTo");
      }
      
      int res1 = this.first.compareTo(another.first);
      
      if(res1 != 0)
      {
         return res1;
      }
      
      int res2 = this.last.compareTo(another.last);
      
      if(res2 != 0)
      {
         return res2;
      }
      
      return this.publisher.compareTo(another.publisher);
   }
   
   /**
    * The equals checks all strings for equality ignoring case
    * @param obj Representing the Object being passed to equals
    * @return boolean if all strings ignoring case are equal
    */
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
      
      if(!(obj instanceof Author))
      {
         return false;
      }
      
      Author another = (Author)obj;
      
      return this.first.equalsIgnoreCase(another.first) && this.last.equalsIgnoreCase(another.last) && this.publisher.equalsIgnoreCase(another.publisher);
   }
   
   /**
    * The hashCode adss all the hashCodes together for all the private strings in the class
    * @return int Representing the hashCode
    */
   @Override
   public int hashCode()
   {
      return this.first.hashCode() + this.last.hashCode() + this.publisher.hashCode();
   }
   
}// end class