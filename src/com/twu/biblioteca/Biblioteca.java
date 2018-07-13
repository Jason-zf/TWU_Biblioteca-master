package com.twu.biblioteca;

import com.twu.biblioteca.control.BookControl;
import com.twu.biblioteca.core.Menu;

import java.util.ArrayList;
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
        mainMenuProcess(scanner);
    }

    private void mainMenuProcess(Scanner scanner) {
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
                if (in.toLowerCase().equals("q") || in.toLowerCase().equals("quit")) {
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
                subMenuProcess(scanner);
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                subMenuProcess(scanner);
                break;
        }
    }

    private void subMenuProcess(Scanner scanner) {
        Menu subMenu = new Menu(new ArrayList<String>() {{
            add(".Checkout Book");
            add(".Return Book");
        }});
        System.out.println();
        subMenu.print();
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
                System.out.println("Select a valid option!");
                System.out.print("Choose one option with number:");
                continue;
            }
            if (0 < optionNum && optionNum <= subMenu.getMenuList().size()) {
                break;
            }
            System.out.println("Select a valid option!");
            System.out.print("Choose one option with number:");
            continue;
        }

        switch (optionNum) {
            case 1:
                checkedOutBookProcess(scanner);
                break;
            case 2:
                returnBookProcess(scanner);
                break;
            default:
                mainMenuProcess(scanner);
                break;
        }
    }

    private void checkedOutBookProcess(Scanner scanner) {
        System.out.println();
        System.out.print("Input a book number to checkout or input 'm' to main menu:");
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
                    mainMenuProcess(scanner);
                    continue;
                }
                System.out.println("Select a valid option!");
                System.out.print("Input a book number or input 'm' to main menu:");
                continue;
            }
            if (0 < optionNum && optionNum <= bookControl.getBooks().size()) {
                if (bookControl.getBooks().get(optionNum - 1).isCheckedOut()) {
                    System.out.println("That book is not available.");
                    System.out.print("Input another book number or press 'm' to main menu:");
                    continue;
                } else {
                    System.out.println("Thank you! Enjoy the book");
                    mainMenuProcess(scanner);
                }
            } else {
                System.out.println("That book is not available.");
                System.out.print("Input another book number or press 'm' to main menu:");
                continue;
            }
        }

    }

    private void returnBookProcess(Scanner scanner) {
        System.out.println();
        System.out.print("Input a return book name or input 'm' to main menu:");
        String name = "";
        while (true) {
            name = scanner.nextLine();
            if (bookControl.isValidBook(name)) {
                bookControl.getBook(name).setCheckedOut(false);
                System.out.println("Thank you for returning the book.");
                mainMenuProcess(scanner);
            } else if (name.toLowerCase().equals("q") || name.toLowerCase().equals("quit")) {
                System.exit(0);
            } else {
                System.out.println("That is not a valid book to return.");
                System.out.print("Pleasure input valid book name or input 'm' to main menu:");
            }
        }
    }
}
