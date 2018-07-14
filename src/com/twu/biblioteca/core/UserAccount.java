package com.twu.biblioteca.core;

import java.util.ArrayList;
import java.util.Objects;

public class UserAccount {
    private String ID;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private ArrayList<Book> checkedOutBooks = new ArrayList<>();

    public UserAccount(String ID, String password, String name, String email, String phoneNumber) {
        this.ID = ID;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public void print() {
        String res = "";
        String splitLine = "";
        for (int i = 0; i < 48; i++) {
            splitLine += "-";
        }
        res += splitLine + "\n" + String.format("%-15s %-15s %-15s", "|Name", "|Email", "|Phone") + "|\n" + splitLine + "\n";
        res += String.format("%-15s %-15s %-15s", "|" + name, "|" + email, "|" + phoneNumber) + "|\n" + splitLine + "\n";
        System.out.print(res);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(ID, that.ID);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID);
    }
}
