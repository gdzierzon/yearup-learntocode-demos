package org.yearup.lists;

import org.yearup.models.Book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListBooks
{
    public static void main(String[] args)
    {

        ArrayList<Book> books = loadBooks();

        for (int i = 0; i < books.size(); i++)
        {
            Book book = books.get(i);
            System.out.println(book.getTitle());
        }
    }

    public static ArrayList<Book> loadBooks()
    {
        // create the array (container)
        ArrayList<Book> books = new ArrayList<>();

        // load the array
        FileInputStream stream;
        Scanner fileScanner = null;
        try
        {
            stream = new FileInputStream("files/books.csv");
            fileScanner = new Scanner(stream);

            fileScanner.nextLine();

            while (fileScanner.hasNext())
            {
                String line = fileScanner.nextLine();

                // split line into fields
                String[] columns = line.split("\\|");
                int id = Integer.parseInt(columns[0]);
                String isbn = columns[1];
                String title = columns[2];
                LocalDate date = LocalDate.parse(columns[3]);
                String category = columns[4];

                // create book and add to the ArrayList
                Book book = new Book(id, isbn, title, date, category);
                books.add(book);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("There was an error loading the file");
        }
        finally
        {
            // close the stream
            if(fileScanner != null)
            {
                fileScanner.close();
            }
        }

        // return the array
        return books;
    }

    public static void findBook(ArrayList<Book> books, String title)
    {

    }

}