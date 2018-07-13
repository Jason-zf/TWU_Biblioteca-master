package com.twu.biblioteca.control;

import com.twu.biblioteca.core.Book;

import java.util.ArrayList;

public class BookControl {
    private ArrayList<Book> books = new ArrayList<Book>();

    public BookControl() {
        Book book1 = new Book("book1", "zhangsan", 2000);
        Book book2 = new Book("book2", "lisi", 2005);
        Book book3 = new Book("book3", "wangwu", 2010);
        books.add(book1);
        books.add(book2);
        books.add(book3);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
