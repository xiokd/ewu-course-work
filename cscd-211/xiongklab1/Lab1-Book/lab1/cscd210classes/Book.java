package lab1.cscd210classes;

public class Book implements Comparable<Book>
{
   private String title, author, isbn;
   private int pages;

   public Book(final String title, final String isbn, final int pages, final String author) {
      if(title == null || isbn == null || title.isEmpty() || isbn.isEmpty() || pages < 1 || author == null || author.isEmpty()) {
         throw new IllegalArgumentException("Bad params Book");
      }

      this.title = title;
      this.isbn = isbn;
      this.pages = pages;
      this.author = author;
   }

   public String getISBN() {
      return this.isbn;
   }

   public int getPages() {
      return this.pages;
   }

   @Override
   public String toString() {
      String str = ""; // Empty string
      str = "Title: " + this.title + "\n" + "Author: " + this.author + "\n" + "ISBN: " + this.isbn + "\n" + "Pages: " + this.pages;

      return str;
   }

   @Override
   public boolean equals(final Object obj) {
      if(obj == null)
         return false;
      if(obj == this)
         return true;
      if(!(obj instanceof Book))
         return false;

      Book another = (Book)obj;

      return this.title.equals(another.title) && this.author.equals(another.author) && this.isbn.equals(another.isbn) && this.pages == another.pages;
   }

   @Override
   public int hashCode() {
      return this.title.hashCode() + this.isbn.hashCode() + this.pages + this.author.hashCode();
   }

   public int compareTo(final Book another) {
      if(another == null) {
         throw new IllegalArgumentException("Bad params compareTo");
      }

      int res1 = this.title.compareTo(another.title);
      int res2 = this.author.compareTo(another.author);
      int res3 = this.isbn.compareTo(another.isbn);

      if(res1 != 0) {
         return res1;
      }
      if(res2 != 0) {
         return res2;
      }
      if(res3 != 0) {
         return res3;
      }

      return this.pages - another.pages;
   }
}
