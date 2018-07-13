package com.twu.biblioteca.core;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return checkedOut == book.checkedOut &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(yearPublished, book.yearPublished);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, author, yearPublished, checkedOut);
    }
}
