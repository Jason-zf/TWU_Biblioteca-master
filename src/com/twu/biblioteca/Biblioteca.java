package com.twu.biblioteca;

import com.twu.biblioteca.control.BookRepository;
import com.twu.biblioteca.control.MovieRepository;
import com.twu.biblioteca.core.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private Menu mainMenu = new Menu();
    private BookRepository bookRepository = new BookRepository();
    private MovieRepository movieRepository = new MovieRepository();

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

        Menu subMenu = new Menu(new ArrayList<String>() {{
            add(".Checkout Book");
            add(".Return Book");
        }});
        switch (optionNum) {
            case 1:
                bookRepository.print();
                subMenu = new Menu(new ArrayList<String>() {{
                    add(".Checkout Book");
                    add(".Return Book");
                }});
                break;
            case 2:
                movieRepository.print();
                subMenu = new Menu(new ArrayList<String>() {{
                    add(".Checkout Movie");
                    add(".Return Movie");
                }});
                break;
            case 3:
                break;
        }
        return subMenuProcess(scanner, subMenu);
    }

    private boolean subMenuProcess(Scanner scanner, Menu subMenu) {
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

        boolean isBook = subMenu.getMenuList().get(0) == "1...Checkout Book" ? true : false;
        switch (optionNum) {
            case 1:
                if (isBook) {
                    return checkedOutBookProcess(scanner);
                }
                return checkedOutMovieProcess(scanner);
            case 2:
                if (isBook) {
                    return returnBookProcess(scanner);
                }
                return returnMovieProcess(scanner);
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

    private boolean checkedOutMovieProcess(Scanner scanner) {
        System.out.println();
        System.out.print("Input a movie number to checkout or input 'm' to main menu:");
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
                System.out.print("Input a movie number or input 'm' to main menu:");
                continue;
            }
            if (0 < optionNum && optionNum <= movieRepository.getMovies().size()) {
                if (movieRepository.getMovies().get(optionNum - 1).isCheckedOut()) {
                    System.out.println("That movie is not available.");
                    System.out.print("Input another movie number or press 'm' to main menu:");
                    continue;
                } else {
                    System.out.println("Thank you! Enjoy the movie");
                    movieRepository.getMovies().get(optionNum - 1).setCheckedOut(true);
                    return mainMenuProcess(scanner);
                }
            } else {
                System.out.println("That movie is not available.");
                System.out.print("Input another movie number or press 'm' to main menu:");
                continue;
            }
        }
    }

    private boolean returnMovieProcess(Scanner scanner) {
        System.out.println();
        System.out.print("Input a return movie name or input 'm' to main menu:");
        String name = "";
        while (true) {
            name = scanner.nextLine();
            if (movieRepository.isValidMovie(name)) {
                movieRepository.getMovie(name).setCheckedOut(false);
                System.out.println("Thank you for returning the movie.");
                return mainMenuProcess(scanner);
            } else if (name.toLowerCase().equals("q") || name.toLowerCase().equals("quit")) {
                return false;
            } else {
                System.out.println("That is not a valid movie to return.");
                System.out.print("Pleasure input valid movie name or input 'm' to main menu:");
            }
        }
    }
}
