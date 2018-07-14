package com.twu.biblioteca.control;

import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.Movie;
import com.twu.biblioteca.core.UserAccount;

import java.util.ArrayList;

public class UserAccountRepository {
    private ArrayList<UserAccount> userAccounts = new ArrayList<>();

    public UserAccountRepository() {
        userAccounts.add(new UserAccount("000-0001", "password0", "librarian", "librarian@163.com", "12345678900"));
        userAccounts.add(new UserAccount("001-0001", "password1", "user1", "user1@163.com", "12345678901"));
        userAccounts.add(new UserAccount("001-0002", "password2", "user2", "user2@163.com", "12345678902"));
        userAccounts.add(new UserAccount("001-0003", "password3", "user3", "user3@163.com", "12345678903"));
        userAccounts.add(new UserAccount("001-0004", "password4", "user4", "user4@163.com", "12345678904"));
        userAccounts.get(1).getCheckedOutBooks().add(new Book("book1", "zhangsan", 2000));
        userAccounts.get(4).getCheckedOutBooks().add(new Book("book3", "wangwu", 2010));
        userAccounts.get(4).getCheckedOutMovies().add(new Movie("movie3", 2010, "wangwu", "unrated"));
    }

    public UserAccount getOne(String id) {
        for (int i = 0; i < userAccounts.size(); ++i) {
            if (userAccounts.get(i).getID().equals(id)) {
                return userAccounts.get(i);
            }
        }
        return null;
    }

    public void print() {
        System.out.println();
        String res = "Checked book or movie List:\n";
        String splitLine = "";
        for (int i = 0; i < 64; ++i) {
            splitLine += "-";
        }
        res += splitLine + "\n" + String.format("%-10s %-10s %-20s %-20s", "|ID", "|Name", "|CheckedOutBooks", "|CheckedOutMovies") + "|\n";
        res += splitLine + "\n";
        for (int i = 0; i < userAccounts.size(); ++i) {
            String str = "";
            UserAccount userAccount = userAccounts.get(i);
            if (userAccount.getCheckedOutMovies().size() != 0 || userAccount.getCheckedOutBooks().size() != 0) {
                str = String.format("%-10s %-10s %-20s %-20s", "|" + userAccount.getID(), "|" + userAccount.getName(), "|" + userAccount.getCheckedOutBooks().size(), "|" + userAccount.getCheckedOutMovies().size());
                res += str + "|\n";
            }
        }
        res += splitLine + "\n";
        System.out.print(res);
    }
}
