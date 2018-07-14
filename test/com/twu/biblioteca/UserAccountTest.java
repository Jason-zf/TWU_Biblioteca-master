package com.twu.biblioteca;

import com.twu.biblioteca.core.Book;
import com.twu.biblioteca.core.UserAccount;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UserAccountTest {
    private UserAccount userAccount;

    @Before
    public void setUp() throws Exception {
        userAccount = new UserAccount("001-0001", "password1", "user1", "user1@163.com", "12345678901");
    }

    @Test
    public void should_return_id_when_get_id() {
        String expectedId = "001-0001";

        assertFalse(userAccount.getID().isEmpty());
        assertEquals(expectedId, userAccount.getID());
    }

    @Test
    public void should_return_password_when_get_password() {
        String expectedPassword = "password1";

        assertFalse(userAccount.getPassword().isEmpty());
        assertEquals(expectedPassword, userAccount.getPassword());
    }

    @Test
    public void should_return_name_when_get_name() {
        String expectedName = "user1";

        assertFalse(userAccount.getName().isEmpty());
        assertEquals(expectedName, userAccount.getName());
    }

    @Test
    public void should_return_email_address_when_get_email() {
        String expectedEmail = "user1@163.com";

        assertFalse(userAccount.getEmail().isEmpty());
        assertEquals(expectedEmail, userAccount.getEmail());
    }

    @Test
    public void should_return_phone_number_when_get_phone_number() {
        String expectedPhoneNumber = "12345678901";

        assertFalse(userAccount.getPhoneNumber().isEmpty());
        assertEquals(expectedPhoneNumber, userAccount.getPhoneNumber());
    }

    @Test
    public void should_return_checked_out_books_when_get_checked_out_books() {
        Book book = new Book("book1", "zhangsan", 2000);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book);

        userAccount.getCheckedOutBooks().add(book);

        assertEquals(1, userAccount.getCheckedOutBooks().size());
        assertEquals(books, userAccount.getCheckedOutBooks());
    }

    @Test
    public void should_print_correct_information_when_print() {
        String expectedStr = "------------------------------------------------\n" +
                "|Name           |Email          |Phone         |\n" +
                "------------------------------------------------\n" +
                "|user1          |user1@163.com  |12345678901   |\n" +
                "------------------------------------------------\n";
        ByteArrayOutputStream systemOutContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOutContent));
        userAccount.print();

        assertFalse(systemOutContent.toString().isEmpty());
        assertEquals(expectedStr, systemOutContent.toString());
    }
}