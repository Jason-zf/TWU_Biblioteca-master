package com.twu.biblioteca.control;

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
    }

    public UserAccount getOne(String id) {
        for (int i = 0; i < userAccounts.size(); ++i) {
            if (userAccounts.get(i).getID().equals(id)) {
                return userAccounts.get(i);
            }
        }
        return null;
    }
}
