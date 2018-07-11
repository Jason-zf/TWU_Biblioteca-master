package com.twu.biblioteca;

public class Book {
    String name;
    String author;
    Integer yearPublished;
    boolean checkOut;

    public Book(String name, String author, Integer yearPublished, boolean checkOut) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkOut = checkOut;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }
}
