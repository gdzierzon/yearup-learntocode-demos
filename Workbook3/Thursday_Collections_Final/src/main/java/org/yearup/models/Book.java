package org.yearup.models;

import java.time.LocalDate;

public class Book
{
    private int id;
    private String isbn;
    private String title;
    private LocalDate publishDate;
    private String category;

    public Book()
    {
    }

    public Book(int id, String isbn, String title, LocalDate publishDate, String category)
    {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.publishDate = publishDate;
        this.category = category;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public LocalDate getPublishDate()
    {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate)
    {
        this.publishDate = publishDate;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }
}
