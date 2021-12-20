package lab3.cscd211classes;

import lab3.cscd211enums.Genre;
import lab3.cscd211classes.*;
import lab3.cscd211methods.CSCD211Lab3Methods;

public class Book implements Comparable<Book>
{
   private String isbn, title;
   private int pages;
   private Genre type;
   private Publisher pub;
   private Author[] authors;
   
   public Book(final String title, final String isbn, final int pages, final Genre type, final Publisher pub, final String[] author)
   {
      if(title == null || isbn == null ||author == null ||title.isEmpty() || isbn.isEmpty() || pages <= 0)
      {
         throw new IllegalArgumentException("Bad params Book");
      }
      
      this.title = title;
      this.isbn = isbn;
      this.pages = pages;
      this.type = type;
      this.pub = pub;
      
      Author [] arrayTemp = new Author[author.length];
      String [] authTemp = new String[author.length];

      for(int i = 0; i < author.length; i++)
      {
         String authorName = author[i];
         authTemp = authorName.split(" ");
         String firstName = authTemp[0].trim();
         String lastName = authTemp[1].trim();
               
         if(authTemp.length > 2)
         {
            for(int j = 2; j < authTemp.length; j++)
            {
                lastName = lastName + " " + authTemp[i];
            }
         } 
         
         arrayTemp[i] = new Author(firstName, lastName);
         
      }
      
      this.authors = new Author[arrayTemp.length];
      
      for(int k = 0; k < this.authors.length ; k++)
      {
         this.authors[k] = arrayTemp[k];
      }
      
   }
   
   public Book(final String title, final String isbn, final int pages, final String type, final String pubName, final String pubCity, final Author[] array)
   {
      if(title == null || isbn == null || type == null || pubName == null || pubCity == null || array == null || title.isEmpty() || isbn.isEmpty() || type.isEmpty() || pubName.isEmpty() || pubCity.isEmpty() || pages <= 0)
      {
         throw new IllegalArgumentException("Bad Params Book");
      }
      this.title = title;
      this.isbn = isbn;
      this.pages = pages;
      
      Genre bookGenre = Genre.valueOf(type.toUpperCase());
      this.type = bookGenre;
      this.pub = new Publisher(pubName, pubCity);
      this.authors = new Author[array.length];
      
      for(int z = 0 ; z < this.authors.length; z++)
      {
         this.authors[z] = array[z];
      }      
   
   }
   
   public int compareTo(Book passedIn)
   {
      if(passedIn == null)
      {
         throw new IllegalArgumentException("Bad params compareTo");
      }
      
      int res1 = this.pub.compareTo(passedIn.pub);
      int res2 = this.title.compareTo(passedIn.title);
      
      if(res1 != 0)
      {
         return res1;
      }
      
      if(res2 != 0)
      {
         return res2;
      }
      
      return this.isbn.compareTo(passedIn.isbn);    
   }
   
   @Override
   public boolean equals(Object obj)
   {
      if(obj == null)
      {
         return false;
      }
      
      if (obj == this)
      {
         return true;
      }
      
      if(!(obj instanceof Book))
      {
         return false;
      }
      
      Book another = (Book)obj;
      
      return this.title.equals(another.title) && this.isbn.equals(another.isbn) && this.pages == another.pages;
   }
   
   public String getISBN()
   {
      return this.isbn;
   }
   
   public int getPages()
   {
      return this.pages;
   }
   
   public String getTitle()
   {
      return this.title;
   }
   
   public Genre getType()
   {
      return this.type;
   }
   
   public int hashCode()
   {
      return this.title.hashCode() + this.isbn.hashCode();
   }
   
   public void setISBN(final String isbn)
   {
      if(isbn == null || isbn.isEmpty())
      {
         throw new IllegalArgumentException("Bad params setISBN");
      }
      
      this.isbn = isbn;
   }
   
   public void setPages(final int pages)
   {
      if(pages <= 0)
      {
         throw new IllegalArgumentException("Bad params setPages");
      } 
      
      this.pages = pages;     
   }
   
   public void setTitle(final String title)
   {
      if(title == null || title.isEmpty())
      {
         throw new IllegalArgumentException("Bad params setTitle");
      }
      
      this.title = title;      
   }
   
   public String toString()
   {
      String str = "";
      str = this.title + ", ISBN: " + this.isbn;
      
      return str;
   }
}