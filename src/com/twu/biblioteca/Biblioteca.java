package com.twu.biblioteca;

import com.twu.biblioteca.control.BookControl;
import com.twu.biblioteca.core.Menu;

import java.util.Scanner;

public class Biblioteca {
    private Menu mainMenu = new Menu();
    private BookControl bookControl = new BookControl();

    public Biblioteca() {
    }

    public void start() {
        System.out.println();
        System.out.println("Welcome to the Biblioteca library!");
        System.out.println();

        System.out.println("Main menu:");
        mainMenu.print();
        Scanner scanner = new Scanner(System.in);
        Integer optionNum = 1;

        while (true) {
            try {
                optionNum = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Select a valid option!");
                System.out.println("Choose one option with number:");
                continue;
            }
            if (0 < optionNum && optionNum <= mainMenu.getMenuList().size()) {
                break;
            }
            System.out.println("Select a valid option!");
            System.out.println("Choose one option with number:");
            continue;
        }

        switch (optionNum) {
            case 1:
                bookControl.print();
                break;
            case 2:
                break;
            case 3:
                break;
        }

    }
}
