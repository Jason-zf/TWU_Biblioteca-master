package com.twu.biblioteca.core;

import java.util.ArrayList;

public class UserAccount {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private ArrayList<Book> checkedOutBooks = new ArrayList<>();


    public UserAccount(String name, String email, String address, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void addCheckedOutBooks(Book book) {
        checkedOutBooks.add(book);
    }


}
