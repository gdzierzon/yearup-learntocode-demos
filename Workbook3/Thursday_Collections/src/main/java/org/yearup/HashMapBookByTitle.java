package org.yearup;

import org.yearup.models.Book;

import java.time.LocalDate;
import java.util.HashMap;

public class HashMapBookByTitle
{
    public static void main(String[] args)
    {
        // create the map
        HashMap<String, Book> books = new HashMap<>();

        // add discount to map
        books.put("SQL Server 2012", new Book(5,"1118102282","SQL Server 2012", LocalDate.parse("2012-05-22"),"Database Administration"));
        books.put("Pro C# 7",new Book(60,"1484230175","Pro C# 7",LocalDate.parse("2017-09-08"), "Software Development"));
        books.put("C# in Depth",new Book(62,"1617294535","C# in Depth",LocalDate.parse("2017-08-06"),"Software Development"));
        books.put("Node Cookbook",new Book(64,"1838558756","Node Cookbook",LocalDate.parse("2013-05-12"),"Software Development"));
        books.put("Core Java",new Book(77,"0135166314","Core Java",LocalDate.parse("2004-08-13"),"Software Development"));
        books.put("Beginning Java",new Book(78,"1119806917","Beginning Java",LocalDate.parse("2005-06-15"),"Software Development"));
        
        // find book by title
        
        // remove code
        
    }
}
