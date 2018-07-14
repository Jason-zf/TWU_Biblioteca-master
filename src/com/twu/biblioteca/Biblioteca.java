package com.twu.biblioteca;

import com.twu.biblioteca.control.BookRepository;
import com.twu.biblioteca.control.MovieRepository;
import com.twu.biblioteca.control.Repository;
import com.twu.biblioteca.control.UserAccountRepository;
import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.Menu;
import com.twu.biblioteca.core.Movie;
import com.twu.biblioteca.core.UserAccount;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private Menu mainMenu = new Menu();
    private BookRepository bookRepository = new BookRepository();
    private MovieRepository movieRepository = new MovieRepository();
    private UserAccountRepository userAccountRepository = new UserAccountRepository();
    private UserAccount userAccount = null;
    private Boolean isBook = true;
    private final int MAX_INPUT_TIMES = 6;

    public boolean start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Welcome to the Biblioteca library!");
        System.out.println();
        if (login(scanner)) {
            return mainMenuProcess(scanner);
        }
        return false;
    }

    private Boolean login(Scanner scanner) {
        for (int i = 0; i < MAX_INPUT_TIMES; ++i) {
            System.out.print("Pleasure input your ID(xxx-xxxx):");
            String id = scanner.nextLine();
            System.out.print("Pleasure input your password:");
            String password = scanner.nextLine();

            userAccount = userAccountRepository.getOne(id);
            if (userAccount != null && userAccount.getPassword().equals(password)) {
                userAccount.print();
                return true;
            }
            System.out.print("User name or password incorrect,pleasure input again(you have six times to input)!");
        }
        System.out.print("You have run out six opportunities,pleasure try another time!");
        return false;
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
                isBook = true;
                break;
            case 2:
                movieRepository.print();
                subMenu = new Menu(new ArrayList<String>() {{
                    add(".Checkout Movie");
                    add(".Return Movie");
                }});
                isBook = false;
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

        switch (optionNum) {
            case 1:
                if (isBook) {
                    return checkedOut(scanner, bookRepository);
                }
                return checkedOut(scanner, movieRepository);
            case 2:
                if (isBook) {
                    return returning(scanner, bookRepository);
                }
                return returning(scanner, movieRepository);
            default:
                return mainMenuProcess(scanner);
        }
    }

    private boolean checkedOut(Scanner scanner, Repository repository) {
        System.out.println();
        System.out.print("Input a number to checkout or input 'm' to main menu:");
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
                System.out.print("Input a number to checkout or input 'm' to main menu:");
                continue;
            }
            if (isBook && 0 < optionNum && optionNum <= repository.getAll().size() && !((Book) repository.getAll().get(optionNum - 1)).isCheckedOut()) {
                System.out.println("Thank you! Enjoy the book");
                Book book = ((Book) repository.getAll().get(optionNum - 1));
                book.setCheckedOut(true);
                userAccount.getCheckedOutBooks().add(book);
                userAccount.print();
                return mainMenuProcess(scanner);
            } else if (!isBook && 0 < optionNum && optionNum <= repository.getAll().size() && !((Movie) repository.getAll().get(optionNum - 1)).isCheckedOut()) {
                System.out.println("Thank you! Enjoy the movie");
                Movie movie = ((Movie) repository.getAll().get(optionNum - 1));
                movie.setCheckedOut(true);
                userAccount.getCheckedOutMovies().add(movie);
                return mainMenuProcess(scanner);
            } else {
                System.out.println("That " + (isBook == true ? "book" : "movie") + " is not available.");
                System.out.print("Input another number or press 'm' to main menu:");
                continue;
            }
        }
    }

    private boolean returning(Scanner scanner, Repository repository) {
        System.out.println();
        System.out.print("Input a return name or input 'm' to main menu:");
        String name = "";
        while (true) {
            name = scanner.nextLine();
            if (name.toLowerCase().equals("q") || name.toLowerCase().equals("quit")) {
                return false;
            }
            if (isBook && repository.isValid(name)) {
                Book book = ((Book) repository.getOne(name));
                book.setCheckedOut(false);
                if (userAccount.getCheckedOutMovies().contains(book)) {
                    userAccount.getCheckedOutMovies().remove(book);
                }
                System.out.println("Thank you for returning the book.");
                return mainMenuProcess(scanner);
            } else if (!isBook && repository.isValid(name)) {
                Movie movie = ((Movie) repository.getOne(name));
                movie.setCheckedOut(false);
                if (userAccount.getCheckedOutMovies().contains(movie)) {
                    userAccount.getCheckedOutMovies().remove(movie);
                }
                System.out.println("Thank you for returning the movie.");
                return mainMenuProcess(scanner);
            }
            System.out.println("That is not a valid " + (isBook == true ? "book" : "movie") + " to return.");
            System.out.print("Pleasure input valid name or input 'm' to main menu:");
        }
    }

}
