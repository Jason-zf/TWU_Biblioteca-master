package com.twu.biblioteca;

import com.twu.biblioteca.control.BookRepository;
import com.twu.biblioteca.core.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private Menu mainMenu;
    private BookRepository bookRepository;

    public Biblioteca() {
        mainMenu = new Menu();
        bookRepository = new BookRepository();
    }

    public boolean start() {
        System.out.println();
        System.out.println("Welcome to the Biblioteca library!");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        return mainMenuProcess(scanner);
    }

    private boolean mainMenuProcess(Scanner scanner) {
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
                    return false;
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
                bookRepository.print();
                return subMenuProcess(scanner);
            case 2:
                break;
            case 3:
                break;
        }
        return true;
    }

    private boolean subMenuProcess(Scanner scanner) {
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
                    return false;
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
                return checkedOutBookProcess(scanner);
            case 2:
                return returnBookProcess(scanner);
            default:
                return mainMenuProcess(scanner);
        }
    }

    private boolean checkedOutBookProcess(Scanner scanner) {
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
                    return false;
                }
                if (in.toLowerCase().equals("m")) {
                    return mainMenuProcess(scanner);
                }
                System.out.println("Select a valid option!");
                System.out.print("Input a book number or input 'm' to main menu:");
                continue;
            }
            if (0 < optionNum && optionNum <= bookRepository.getBooks().size()) {
                if (bookRepository.getBooks().get(optionNum - 1).isCheckedOut()) {
                    System.out.println("That book is not available.");
                    System.out.print("Input another book number or press 'm' to main menu:");
                    continue;
                } else {
                    System.out.println("Thank you! Enjoy the book");
                    bookRepository.getBooks().get(optionNum - 1).setCheckedOut(true);
                    return mainMenuProcess(scanner);
                }
            } else {
                System.out.println("That book is not available.");
                System.out.print("Input another book number or press 'm' to main menu:");
                continue;
            }
        }
    }

    private boolean returnBookProcess(Scanner scanner) {
        System.out.println();
        System.out.print("Input a return book name or input 'm' to main menu:");
        String name = "";
        while (true) {
            name = scanner.nextLine();
            if (bookRepository.isValidBook(name)) {
                bookRepository.getBook(name).setCheckedOut(false);
                System.out.println("Thank you for returning the book.");
                return mainMenuProcess(scanner);
            } else if (name.toLowerCase().equals("q") || name.toLowerCase().equals("quit")) {
                return false;
            } else {
                System.out.println("That is not a valid book to return.");
                System.out.print("Pleasure input valid book name or input 'm' to main menu:");
            }
        }
    }
}
