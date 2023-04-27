package org.yearup;

import org.yearup.models.Book;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapBookByTitle
{
    public static void main(String[] args)
    {
        // create the map
        HashMap<String, Book> books = new HashMap<>();

        // add discount to map
        books.put("sql server 2012", new Book(5,"1118102282","SQL Server 2012", LocalDate.parse("2012-05-22"),"Database Administration"));
        books.put("pro c# 7",new Book(60,"1484230175","Pro C# 7",LocalDate.parse("2017-09-08"), "Software Development"));
        books.put("c# in depth",new Book(62,"1617294535","C# in Depth",LocalDate.parse("2017-08-06"),"Software Development"));
        books.put("node cookbook",new Book(64,"1838558756","Node Cookbook",LocalDate.parse("2013-05-12"),"Software Development"));
        books.put("core java",new Book(77,"0135166314","Core Java",LocalDate.parse("2004-08-13"),"Software Development"));
        books.put("beginning java",new Book(78,"1119806917","Beginning Java",LocalDate.parse("2005-06-15"),"Software Development"));


        System.out.println();
        // find book by title
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a book title: ");
        String title = scanner.nextLine().strip().toLowerCase();

        if(books.containsKey(title))
        {
            Book book = books.get(title);
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Publish Date: " + book.getPublishDate());
            System.out.println("Category: " + book.getCategory());
        }

        
    }
}
