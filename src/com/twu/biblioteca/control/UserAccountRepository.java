package com.twu.biblioteca.control;

import com.twu.biblioteca.core.UserAccount;

import java.util.ArrayList;

public class UserAccountRepository {
    private ArrayList<UserAccount> userAccounts = new ArrayList<>();

    public UserAccountRepository() {
        userAccounts.add(new UserAccount("user1", "user1@163.com", "xi'an", "12345678901"));
        userAccounts.add(new UserAccount("user2", "user2@163.com", "xi'an", "12345678902"));
        userAccounts.add(new UserAccount("user3", "user3@163.com", "xi'an", "12345678903"));
        userAccounts.add(new UserAccount("user4", "user4@163.com", "xi'an", "12345678904"));
    }


}
