package com.mert.entity.books;

import com.mert.Utility.Situation;

import java.util.UUID;

public abstract class Book {

    private String id;
 private    String ISBN;
 private String bookName;
 private String author;

 private int yearReleased;

Situation situation;



    public Book(String ISBN, String bookName, String author, int yearReleased, Situation situation) {
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.author = author;
        this.yearReleased = yearReleased;
        this.situation = situation;
        this.id = UUID.randomUUID().toString();

    }

    public String getId() {
        return id;
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public void setYearReleased(int yearRekeased) {
        this.yearReleased = yearRekeased;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }





    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("id='").append(id).append('\'');
        sb.append(", ISBN='").append(ISBN).append('\'');
        sb.append(", bookName='").append(bookName).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", yearReleased=").append(yearReleased);
        sb.append(", situation=").append(situation);
        sb.append('}');
        return sb.toString();
    }
}
