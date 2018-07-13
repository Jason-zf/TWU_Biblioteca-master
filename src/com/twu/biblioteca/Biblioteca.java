package com.twu.biblioteca;

import com.twu.biblioteca.control.BookControl;
import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.Menu;

import javax.swing.*;
import java.util.ArrayList;

public class Biblioteca {
    private Menu mainMenu = new Menu();
    private BookControl bookControl = new BookControl();

    public Biblioteca() {
    }

    public void start() {
        System.out.println();
        System.out.println("Welcome to the Biblioteca library!");
        System.out.println();

        String str = bookControl.print();
        System.out.println(str);
    }
}
