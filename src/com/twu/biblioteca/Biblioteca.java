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

        Scanner scanner = new Scanner(System.in);
        mainMenuSelectionProcess(scanner);
    }

    private void checkedOutBookProcess(Scanner scanner) {
        System.out.println();
        System.out.println("Would you like to checkout a book?");
        System.out.print("If so...,pleasure input book number;If not...,pleasure input 'm' to main menu:");
        Integer optionNum = 1;
        String in = "";
        while (true) {
            try {
                in = scanner.nextLine();
                optionNum = Integer.parseInt(in);
            } catch (NumberFormatException e) {
                if (in.toLowerCase().equals("q") || in.toLowerCase().equals("quit")) {
                    System.exit(0);
                }
                if (in.toLowerCase().equals("m")) {
                    mainMenuSelectionProcess(scanner);
                    continue;
                }
                System.out.println("Select a valid option!");
                System.out.print("Input a book number or input 'm' to main menu:");
                continue;
            }
            if (0 < optionNum && optionNum <= bookControl.getBooks().size()) {
                if (bookControl.getBooks().get(optionNum).isCheckedOut()) {
                    System.out.println("That book is not available.");
                    System.out.println("Input another book number or press 'm' to main menu:");
                    continue;
                } else {
                    System.out.println("Thank you! Enjoy the book");
                    mainMenuSelectionProcess(scanner);
                }
            } else {
                System.out.println("That book is not available.");
                System.out.println("Input another book number or press 'm' to main menu:");
                continue;
            }
        }

    }

    private void mainMenuSelectionProcess(Scanner scanner) {
        System.out.println();
        System.out.println("Main menu:");
        mainMenu.print();
        Integer optionNum = 1;
        String in = "";
        while (true) {
            try {
                in = scanner.nextLine();
                optionNum = Integer.parseInt(in);
            } catch (NumberFormatException e) {
                if (in == "q" || in == "Q" || in == "quit" || in == "Quit") {
                    System.exit(0);
                }
                System.out.println("Select a valid option!");
                System.out.print("Choose one option with number:");
                continue;
            }
            if (0 < optionNum && optionNum <= mainMenu.getMenuList().size()) {
                break;
            }
            System.out.println("Select a valid option!");
            System.out.print("Choose one option with number:");
            continue;
        }

        switch (optionNum) {
            case 1:
                bookControl.print();
                checkedOutBookProcess(scanner);
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                checkedOutBookProcess(scanner);
                break;
        }
    }
}
