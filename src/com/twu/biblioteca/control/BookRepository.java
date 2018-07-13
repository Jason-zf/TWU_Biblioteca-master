package com.twu.biblioteca.control;

import com.twu.biblioteca.core.Book;

import java.util.ArrayList;

public class BookRepository {
    private ArrayList<Book> books = new ArrayList<Book>();

    public BookRepository() {
        books.add(new Book("book1", "zhangsan", 2000));
        books.add(new Book("book2", "lisi", 2005));
        books.add(new Book("book3", "wangwu", 2010));
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void print() {
        String res = "";
        String splitLine = "";
        for (int i = 0; i < 65; i++) {
            splitLine += "-";
        }
        res += splitLine + "\n" + String.format("%-15s %-15s %-15s %-15s", "|Number", "|Name", "|Author", "|Year Published") + "|\n" + splitLine + "\n";
        for (int i = 0; i < books.size(); ++i) {
            Book book = books.get(i);
            if (!book.isCheckedOut()) {
                res += String.format("%-15s %-15s %-15s %-15s", "|" + String.valueOf(i + 1), "|" + book.getName(), "|" + book.getAuthor(), "|" + book.getYearPublished()) + "|\n";
            }
        }
        res += splitLine + "\n";
        System.out.print(res);
    }

    public boolean isValidBook(String name) {
        for (int i = 0; i < books.size(); ++i) {
            if (books.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Book getBook(String name) {
        for (int i = 0; i < books.size(); ++i) {
            if (books.get(i).getName().equals(name)) {
                return books.get(i);
            }
        }
        return null;
    }
}
