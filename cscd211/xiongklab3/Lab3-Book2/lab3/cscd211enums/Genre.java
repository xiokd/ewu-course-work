package lab3.cscd211enums;

public enum Genre
{
   FICTION(10, "fiction"), NONFICTION(20, "non-fiction"), ROMANCE(5, "romance"), SCIFI(20, "sci-fi"), EDUCATION(15, "education");
   
   private String name;
   private int value;
   
   private Genre(final int value, final String name)
   {
      this.value = value;
      this.name = name;
   }
   
   public int getValue()
   {
      return this.value;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public String toString()
   {
      return this.name;
   }
}