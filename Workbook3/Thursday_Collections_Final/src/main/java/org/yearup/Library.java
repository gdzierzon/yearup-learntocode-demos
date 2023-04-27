package org.yearup;

import org.yearup.models.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Library
{
    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Book> books = new ArrayList<>();
    static HashMap<String, Book> titleMap = new HashMap<>();
    static HashMap<String, Book> isbnMap = new HashMap<>();

    public static void main(String[] args)
    {
        // add books to the ArrayList
        books.add(new Book(5,"1118102282","SQL Server 2012", LocalDate.parse("2012-05-22"),"Database Administration"));
        books.add(new Book(60,"1484230175","Pro C# 7",LocalDate.parse("2017-09-08"), "Software Development"));
        books.add(new Book(62,"1617294535","C# in Depth",LocalDate.parse("2017-08-06"),"Software Development"));
        books.add(new Book(64,"1838558756","Node Cookbook",LocalDate.parse("2013-05-12"),"Software Development"));
        books.add(new Book(77,"0135166314","Core Java",LocalDate.parse("2004-08-13"),"Software Development"));
        books.add(new Book(78,"1119806917","Beginning Java",LocalDate.parse("2005-06-15"),"Software Development"));

        // add books to the maps
        for(Book book : books)
        {
            titleMap.put(book.getTitle().toUpperCase(), book);
            isbnMap.put(book.getIsbn(), book);
        }

        while (true)
        {
            System.out.println("What do you want to do?");
            System.out.println("1) search by title");
            System.out.println("2) search by isbn");
            System.out.println("3) list all books");
            System.out.println("0) exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option)
            {
                case 1:
                    searchByTitle();
                    break;
                case 2:
                    searchByIsbn();
                    break;
                case 3:
                    listAll();
                    break;
                case 0:
                    return;
            }
        }


    }

    private static void searchByTitle()
    {
        System.out.println();
        System.out.print("Enter the title: ");
        String title = scanner.nextLine().strip().toUpperCase();

        System.out.println();
        if(titleMap.containsKey(title))
        {
            Book book = titleMap.get(title);
            System.out.println(book.getTitle());
            System.out.println(book.getIsbn());
            System.out.println(book.getPublishDate());
            System.out.println(book.getCategory());
        }
        else
        {
            System.out.println(title + " was not found");
        }
        System.out.println();
    }

    private static void searchByIsbn()
    {
        System.out.println();
        System.out.print("Enter the isbn: ");
        String isbn = scanner.nextLine().strip().toUpperCase();

        System.out.println();
        if(isbnMap.containsKey(isbn))
        {
            Book book = isbnMap.get(isbn);
            System.out.println(book.getTitle());
            System.out.println(book.getIsbn());
            System.out.println(book.getPublishDate());
            System.out.println(book.getCategory());
        }
        else
        {
            System.out.println(isbn + " was not found");
        }
        System.out.println();
    }

    private static void listAll()
    {

    }
}
