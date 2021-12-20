package lab3.cscd211methods;

import java.io.*;
import java.util.*;
import lab3.cscd211classes.*;
import lab3.cscd211enums.Genre;


public class CSCD211Lab3Methods
{
   public static Book[] addBook(Book[] array, Book book)
   {
      if(array == null || book == null)
      {
         throw new IllegalArgumentException("Bad params addBook");
      }
      
      Book [] temp = new Book[array.length + 1];
      
      for(int i = 0; i < array.length; i++)
      {
         temp[i] = array[i];
      }
      
      temp[temp.length - 1] = book;
      
      return temp;
   }
   
   public static Book createBook(final Scanner kb)
   {
      if(kb == null)
      {
         throw new IllegalArgumentException("Bad params createBook");
      }
      
      String title, isbn, type, bookType, pubName, pubCity, first, last;
      int pages, numberAuth;
      Genre bookGenre;
      Author[] array;
      
      System.out.print("Please enter the title of the book: ");
      title = kb.nextLine();
      
      System.out.print("Please enter the ISBN: ");
      isbn = kb.nextLine();
      
      System.out.print("Please enter the number of pages: ");
      pages = Integer.parseInt(kb.nextLine());
      
      System.out.print("Please enter the Genre: ");
      bookType = kb.nextLine();
      bookGenre = CSCD211Lab3Methods.getGenre(bookType);
      type = bookGenre.toString();
      
      System.out.print("Please enter the Publisher name: ");
      pubName = kb.nextLine();
      System.out.print("Please enter the Publisher city: ");
      pubCity = kb.nextLine();
      
      System.out.print("Please enter the number of Authors: ");
      numberAuth = Integer.parseInt(kb.nextLine());
      array = new Author[numberAuth];
      for(int i = 0; i < array.length; i++)
      {
         System.out.print("Please enter the first name of the author: ");
         first = kb.nextLine();
         System.out.print("Please enter the last name of the author: ");
         last = kb.nextLine();
         
         Author newAuthors = new Author(first, last);
         
         array[i] = newAuthors;
      }
      
      Book newBook = new Book(title, isbn, pages, type, pubName, pubCity, array);
      
      return newBook;  
   }
   
   public static Genre getGenre(final String g)
   {
      if(g == null || g.isEmpty())
      {
         throw new IllegalArgumentException("Bad params getGenre");
      }
       String temp = g.toUpperCase().trim();
       String defGenre = "FICTION";
       Genre[] array = Genre.values();
       boolean found = false;
       
       for(int i = 0; i < array.length && found != true; i++)
       {
         if(array[i].toString().equals(temp))
         {
            found = true;
         }
       }
       
       if(found == false)
       {
         return Genre.valueOf(defGenre);
       }
       
      return Genre.valueOf(temp);
   }
   
   public static Book[] fillArray(final Scanner fin)
   {
        if(fin == null)
        {
            throw new IllegalArgumentException("Bad params fillArray");
        }
        
        String title, isbn, pubName, pubCity, authName, firstName, lastName;
        int pages, bookNum, authNum;
        Genre type;
        Publisher pubs;
        String [] author, nameAuth;
        
        bookNum = Integer.parseInt(fin.nextLine());
        
        Book[] array = new Book[bookNum];
        
        for(int i = 0; i < array.length; i++)
        {
            title = fin.nextLine();
            isbn = fin.nextLine();
            pages = Integer.parseInt(fin.nextLine());
            type = CSCD211Lab3Methods.getGenre(fin.nextLine());
            
            pubName = fin.nextLine();
            pubCity = fin.nextLine();
            pubs = new Publisher(pubName, pubCity);
            
            authNum = Integer.parseInt(fin.nextLine());
            author = new String[authNum];
            
            for(int j = 0; j < author.length; j++)
            {
               authName = fin.nextLine();
               
               nameAuth = authName.split(" ");
               
               firstName = nameAuth[0].trim();
               lastName = nameAuth[1].trim();
               
               if(nameAuth.length > 2)
               {
                  for(int k = 2; k < nameAuth.length; k++)
                  {
                     lastName = lastName + " " + nameAuth[k];
                  }
               } 
               
               author[j] = firstName + " " + lastName;
            }
            
            array[i] = new Book(title, isbn, pages, type, pubs, author); 
        }
        
        return array;
   }
   
   public static int menu(final Scanner kb)
   {
      if(kb == null)
      {
         throw new IllegalArgumentException("Bad scanner menu");
      }
      
      int choice;
      do
      {
         System.out.println("Please choose from the following");
         System.out.println("1) Print the books to the screen");
         System.out.println("2) Print the books to a file");
         System.out.println("3) Sort the book using compareTo");
         System.out.println("4) Sort the books by first author as a Comparator");
         System.out.println("5) Add a book");
         System.out.println("6) Quit");
         System.out.print("Choice --> ");
         choice = Integer.parseInt(kb.nextLine());
         System.out.println();
      }while(choice < 1 || choice > 6);

      return choice;      
      
   }
   
   public static void printBooks(final Book[] array, final PrintStream fout)
   {
      if(array == null || fout == null)
      { 
         throw new IllegalArgumentException("Bad params printBooks");
      }
      
      for(int i = 0; i < array.length; i++)
      {
         fout.println(array[i]);
         fout.println();
      }         
   }
   
   public static String readFileName(final Scanner kb)
   {
      if(kb == null)
      {
         throw new IllegalArgumentException("Bad params readFileName");
      }
      String str;
      
      do
      {
         System.out.print("Please enter the file name: ");
         str = kb.nextLine();
      }while(str == null || str.isEmpty());
   
      return str;
   }
}