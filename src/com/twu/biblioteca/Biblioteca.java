package com.twu.biblioteca;

import com.twu.biblioteca.control.BookControl;
import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.Menu;

import java.util.ArrayList;

public class Biblioteca {
    private Menu mainMenu = new Menu();
    private ArrayList<Book> books = (new BookControl()).getBooks();

    public Biblioteca() {
    }

    public void start() {
        System.out.println("Welcome to the Biblioteca library!");
    }
}
