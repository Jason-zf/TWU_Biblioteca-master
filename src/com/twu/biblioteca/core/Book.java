package com.twu.biblioteca.core;

public class Book {
    String name;
    String author;
    Integer yearPublished;
    boolean checkedOut;

    public Book(String name, String author, Integer yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.checkedOut = false;
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

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }


}
